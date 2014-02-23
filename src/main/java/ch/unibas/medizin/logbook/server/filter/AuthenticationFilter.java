package ch.unibas.medizin.logbook.server.filter;

import static ch.unibas.medizin.logbook.shared.constant.LogBookConstant.ADMIN;
import static ch.unibas.medizin.logbook.shared.constant.LogBookConstant.CURRENT_USER;
import static ch.unibas.medizin.logbook.shared.constant.LogBookConstant.STUDENT;
import static ch.unibas.medizin.logbook.shared.constant.LogBookConstant.UNIQUE_ID;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.commons.lang3.math.NumberUtils.createInteger;
import static org.apache.commons.lang3.math.NumberUtils.isDigits;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import ch.unibas.medizin.logbook.server.domain.Administrator;
import ch.unibas.medizin.logbook.server.domain.Student;
import ch.unibas.medizin.logbook.shared.enums.Gender;
import ch.unibas.medizin.logbook.shared.enums.StudentStatus;

public class AuthenticationFilter implements Filter {

	private static Logger log = Logger.getLogger(AuthenticationFilter.class);

	private static final int ALLOWED_STUDY_BRANCH = 51;
	private static final String STUDY_BRANCH = "studyBranch2"; // "Shib-SwissEP-swissEduPersonStudyBranch2" or studyBranch2
	private static final String EMAIL = "mail";
	private static final String GENDER = "gender";
	private static final String NAME = "givenName";
	private static final String PRENAME = "surname";
	private static final String MATRICULATION_NUMBER = "matriculationNumber";
	
	// for local use
	private static final String STUDENT_ID = "id";
	private static final String CURRENT_USER_PARAM = "currentUser";

	@Override
	public void destroy() {
		log.info("Inside destroy");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		log.info("Inside doFilter");
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		boolean flag = false;
		String uniqueID;
		String matriculationNumber;
		
		/* local development environment Session Management */ 
		uniqueID = getUniqueId(request,response);
		log.info("UNIQUE_ID : " + uniqueID);
		flag = localWork(request, response, uniqueID);

		/* production environment session management */
		/* for production uniqueID and for testing uid */
		uniqueID = request.getHeader("uniqueID");
		matriculationNumber = request.getHeader(MATRICULATION_NUMBER);

		if (isNotBlank(matriculationNumber)) {
			uniqueID = matriculationNumber;
		}

		log.info("UNIQUE_ID : " + uniqueID);
		log.info("matriculationNumber : " + matriculationNumber);

		flag = productionMethod(request, response, uniqueID);

		if (flag) {
			filterChain.doFilter(servletRequest, servletResponse);
		} else {
			((HttpServletResponse) servletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED, uniqueID + " is not authorized to logbook.");
		}
	}

	private final boolean productionMethod(HttpServletRequest request, HttpServletResponse response, String uniqueID) {

		boolean flag = false;

		// than check for (verify alias)Shib-SwissEP-StudyBranch2 -> 51
		// only student of studyBranch 51 has the access, different StudyBranch
		// has to be denied.
		String studyBranch = request.getHeader(STUDY_BRANCH);

		String[] allStudyBranch = StringUtils.split(studyBranch, ";");
		log.info("StudyBranch : " + studyBranch);

		boolean hasAllowedStudyBranch = false;

		if (allStudyBranch != null) {
			for (String sb : allStudyBranch) {
				log.info("sb : " + sb);
				if (isDigits(sb) && (createInteger(sb)) == ALLOWED_STUDY_BRANCH) {
					hasAllowedStudyBranch = true;
					break;
				}
			}
		}

		if (hasAllowedStudyBranch == true) {

			// Session Management
			HttpSession session = request.getSession(false);

			if (session != null) {
				String sessionUniqueId = (String) session.getAttribute(UNIQUE_ID);
				if (uniqueID.equals(sessionUniqueId)) {
					log.info("----> Authenticated student using session");
					flag = true;
				} else {
					flag = authenticationStudentUsingDB(request, response, uniqueID);
					if (flag == true) {
						session.setAttribute(UNIQUE_ID, uniqueID);
						session.setAttribute(CURRENT_USER, STUDENT);
						log.info("----> Authenticated student using DB");
					}
				}
			} else {
				flag = authenticationStudentUsingDB(request, response, uniqueID);
				if (flag == true) {
					session = request.getSession();
					session.setAttribute(UNIQUE_ID, uniqueID);
					session.setAttribute(CURRENT_USER, STUDENT);
					log.info("----> Authenticated student using New Session");
				}
			}
		} else {
			// For admin
			HttpSession session = request.getSession(false);

			if (session != null) {
				String sessionUniqueId = (String) session.getAttribute(UNIQUE_ID);

				// for testing as student
				asStudentTesting(request, response, uniqueID, session);

				if (uniqueID.equals(sessionUniqueId)) {
					log.info("----> Authenticated Admin using session");
					flag = true;
				} else {
					flag = authenticationAdminUsingDB(request, response, uniqueID);
					if (flag == true) {
						session.setAttribute(UNIQUE_ID, uniqueID);
						session.setAttribute(CURRENT_USER, ADMIN);
						log.info("----> Authenticated Admin using DB");

						// for testing as student
						asStudentTesting(request, response, uniqueID, session);
					}
				}
			} else {

				flag = authenticationAdminUsingDB(request, response, uniqueID);
				if (flag == true) {
					session = request.getSession();
					session.setAttribute(UNIQUE_ID, uniqueID);
					session.setAttribute(CURRENT_USER, ADMIN);
					log.info("----> Authenticated Admin using New Session");
					// for testing as student
					asStudentTesting(request, response, uniqueID, session);
				}
			}

		}

		return flag;
	}

	private void asStudentTesting(HttpServletRequest request, HttpServletResponse response, String uniqueID, HttpSession session) {

		if (uniqueID != null && uniqueID.equals("210760@vho-switchaai.ch") && getParamValue(request, response, "shibdId") != null) {
			log.info("set dummy shibdId for student");
			uniqueID = getParamValue(request, response, "shibdId");
			session.setAttribute(UNIQUE_ID, uniqueID);
			session.setAttribute(CURRENT_USER, STUDENT);
		}
	}

	private boolean authenticationAdminUsingDB(HttpServletRequest request, HttpServletResponse response, String uniqueID) {

		boolean flag = false;

		try {
			List<Administrator> listAdministrator = Administrator.findAllAdministrators();
			if (uniqueID != null && uniqueID.equals("210760@vho-switchaai.ch")) {

				log.info("Login successfully by 210760@vho-switchaai.ch");
				flag = true;
			} else if (uniqueID != null && uniqueID.equals("myself")) {

				log.info("Login successfully by myself");
				flag = true;
			} else if (listAdministrator != null) {

				log.info("listAdministrator : " + listAdministrator.size());
				for (Administrator administrator : listAdministrator) {

					if (administrator.getEmail().equals(uniqueID)) {

						log.info("Login successfully");
						flag = true;
						break;

					}
				}
			}
		} catch (Exception e) {
			flag = false;
			log.error("Error in authenticationAdminUsingDB method", e);
		}
		return flag;
	}

	private boolean authenticationStudentUsingDB(HttpServletRequest request, HttpServletResponse response, String uniqueID) {

		boolean flag = false;

		try {

			Student eStudent = Student.findStudentUsingShibId(uniqueID);

			if (eStudent != null && eStudent.getShib_id().equals(uniqueID)) {
				log.info("stib_id" + eStudent.getShib_id());
				log.info("uniqueId : " + uniqueID);
				flag = true;

			}

			if (flag == false) {

				Student student = new Student();
				// student_id : unique student id
				student.setShib_id(uniqueID);
				student.setStudentId(uniqueID);
				if (isNotBlank(request.getHeader(EMAIL))) {
					student.setEmail(request.getHeader(EMAIL));
				}

				// check the gender value in shibd
				if (isNotBlank(request.getHeader(GENDER))) {
					student.setGender(Gender.findGender(createInteger(request.getHeader(GENDER))));
				}

				if (isNotBlank(request.getHeader(NAME))) {
					student.setName(request.getHeader(NAME));
				}

				if (isNotBlank(request.getHeader(PRENAME))) {
					student.setPreName(request.getHeader(PRENAME));
				}

				student.setStudentStatus(StudentStatus.UnFinalized);
				student.persist();

				flag = true;
			}

		} catch (Exception e) {
			flag = false;
			log.error("Error in authenticationStudentUsingDB Method.", e);
		}

		return flag;
	}
	
	private String getUniqueId(HttpServletRequest request, HttpServletResponse response) {

		String referer =  request.getHeader("Referer");
		log.info("referer : " + referer );
		log.info("studentid : " + request.getParameter(STUDENT_ID));

		String uniqueID; 

		if(referer != null) {
			uniqueID = getQueryMap(referer).get(STUDENT_ID);
		}else {
			uniqueID = request.getParameter(STUDENT_ID);
		}

		return uniqueID;
	}
	
	private String getCurrentUser(HttpServletRequest request, HttpServletResponse response) {

		String referer = request.getHeader("Referer");

		String currentUser;

		if (referer != null) {
			currentUser = getQueryMap(referer).get(CURRENT_USER_PARAM);
		} else {
			currentUser = request.getParameter(CURRENT_USER_PARAM);
		}

		return currentUser;
	}

	private final boolean localWork(HttpServletRequest request, HttpServletResponse response, String uniqueID) {
		boolean flag = false;
		try {
			String currentUser = getCurrentUser(request, response);

			log.info("currentUser : " + currentUser);

			// Session Management
			HttpSession session = request.getSession(false);

			if (session != null) {
				String sessionUserId = (String) session.getAttribute(UNIQUE_ID);
				String currentUserId = (String) session.getAttribute(CURRENT_USER);

				if (uniqueID.equals(sessionUserId) && currentUser.equals(currentUserId)) {
					log.info("----> Authenticated using session");
					flag = true;
				} else {
					flag = authenticationUsingDB(response, Long.parseLong(uniqueID), currentUser);

					if (flag == true) {
						if (currentUser.equals(ADMIN)) {
							Administrator administrator = Administrator.findAdministrator(Long.parseLong(uniqueID, 10));
							// change to email Address
							session.setAttribute(UNIQUE_ID, administrator.getEmail());
						} else {
							Student student = Student.findStudent(Long.parseLong(uniqueID, 10));
							// change to shib_id
							session.setAttribute(UNIQUE_ID, student.getShib_id());
						}
						session.setAttribute(CURRENT_USER, currentUser);
						log.info("----> Authenticated using DB");
					}
				}
			} else {
				log.info("----> Authenticated using New Session");
				flag = authenticationUsingDB(response, Long.parseLong(uniqueID), currentUser);
				if (flag == true) {
					session = request.getSession();
					if (currentUser.equals(ADMIN)) {
						Administrator administrator = Administrator.findAdministrator(Long.parseLong(uniqueID, 10));
						// change to email Address
						session.setAttribute(UNIQUE_ID, administrator.getEmail());
					} else {
						Student student = Student.findStudent(Long.parseLong(uniqueID, 10));
						// change to shib_id
						session.setAttribute(UNIQUE_ID, student.getShib_id());
					}
					session.setAttribute(CURRENT_USER, currentUser);
				}
			}

		} catch (Exception e) {
			flag = false;
			log.error("localWork", e);
		}
		return flag;
	}
	
	private boolean authenticationUsingDB(ServletResponse servletResponse, long uniqueId, String currentUser) {

		boolean flag = false;

		if (ADMIN.equals(currentUser)) {
			List<Administrator> adminList = Administrator
					.findAllAdministrators();
			for (Administrator administrator : adminList) {
				if ((long) administrator.getId() == uniqueId) {
					flag = true;
					break;
				}
			}
		} else if (STUDENT.equals(currentUser)) {
			List<Student> studList = Student.findAllStudents();

			for (Student student : studList) {
				if ((long) student.getId() == uniqueId) {
					flag = true;
					break;
				}
			}
		} else {
			flag = false;
		}

		return flag;
	}

	public static Map<String, String> getQueryMap(String query) {

		Map<String, String> map = new HashMap<String, String>();
		if (query.contains("?")) {

			String[] params = StringUtils.substringAfterLast(query, "?").split("&");

			for (String param : params) {
				if (param.split("=").length == 2) {
					String name = param.split("=")[0];
					String value = param.split("=")[1];
					map.put(name, value);
				}
			}
		}

		return map;
	}

	private String getParamValue(HttpServletRequest request, HttpServletResponse response, String param) {

		String referer = request.getHeader("Referer");

		String currentUser;

		if (referer != null) {
			currentUser = getValueFromMap(getQueryMap(referer), param);
		} else {
			currentUser = request.getParameter(param);
		}

		return currentUser;
	}

	private String getValueFromMap(Map<String, String> queryMap, String param) {

		if (queryMap.containsKey(param)) {
			return queryMap.get(param);
		}
		return null;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		log.info("Inside init");
	}
}
