package ch.unibas.medizin.logbook.server.domain;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.Version;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;
import javax.validation.constraints.Size;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import ch.unibas.medizin.logbook.shared.SkillFilteredResult;
import ch.unibas.medizin.logbook.shared.enums.SkillLevels;
import ch.unibas.medizin.logbook.shared.enums.StudentStatus;

import com.allen_sauer.gwt.log.client.Log;
import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;

@Configurable
@Entity
public class Skill {

	@PersistenceContext
	transient EntityManager entityManager;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Version
	@Column(name = "version")
	private Integer version;

	@Size(max = 1024)
	private String description;

	private Integer shortcut;

	@ManyToOne
	private Topic topic;

	@ManyToOne
	private SkillLevel skillLevel;

	@Size(max = 255)
	private String german_text;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "skill")
	private Set<SkillAcquired> skillsAcquired = new HashSet<SkillAcquired>();

	@ManyToMany(mappedBy = "skill")
	private Set<Keyword> keywords = new HashSet<Keyword>();

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getShortcut() {
		return this.shortcut;
	}

	public void setShortcut(Integer shortcut) {
		this.shortcut = shortcut;
	}

	public Topic getTopic() {
		return this.topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public SkillLevel getSkillLevel() {
		return this.skillLevel;
	}

	public void setSkillLevel(SkillLevel skillLevel) {
		this.skillLevel = skillLevel;
	}

	public String getGerman_text() {
		return this.german_text;
	}

	public void setGerman_text(String german_text) {
		this.german_text = german_text;
	}

	public Set<SkillAcquired> getSkillsAcquired() {
		return this.skillsAcquired;
	}

	public void setSkillsAcquired(Set<SkillAcquired> skillsAcquired) {
		this.skillsAcquired = skillsAcquired;
	}

	public Set<Keyword> getKeywords() {
		return this.keywords;
	}

	public void setKeywords(Set<Keyword> keywords) {
		this.keywords = keywords;
	}

	public static List<Long> findCountOfSkillBySkillLevel() {
		List<Long> listOfSkillBySkillLevel = new ArrayList<Long>();
		listOfSkillBySkillLevel.add(findTotalSkillByLevel(1l));
		listOfSkillBySkillLevel.add(findTotalSkillByLevel(2l));
		return listOfSkillBySkillLevel;

	}

	public static Long findTotalSkillByLevel(long skillLevel) {
		CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<Skill> from = criteriaQuery.from(Skill.class);

		criteriaQuery.select(criteriaBuilder.count(from));

		Predicate skillLevelPredicate = criteriaBuilder.equal(from.get("skillLevel").get("levelNumber"), skillLevel);
		criteriaQuery.where(skillLevelPredicate);

		TypedQuery<Long> q = entityManager().createQuery(criteriaQuery);
		return q.getSingleResult();

	}

	public static SkillFilteredResult findSkillBySearchCriteria(int start, int max, Long studentId, Long mainClassificationId, Long classificationTopicId, Long topicId, String fulltextSearch, int chkAsc) {

		if (start != 0)
			start--;

		Log.debug("Asc :" + chkAsc);
		Log.debug("Start :" + start);
		Log.debug("Max :" + max);

		CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
		CriteriaQuery<Skill> criteriaQuery = criteriaBuilder.createQuery(Skill.class);
		Root<Skill> from = criteriaQuery.from(Skill.class);
		CriteriaQuery<Skill> select = criteriaQuery.select(from);

		Join<Skill, Topic> join1 = from.join("topic");
		SetJoin<Skill, Keyword> join4 = from.joinSet("keywords", JoinType.LEFT);
		Join<Topic, ClassificationTopic> join2 = join1.join("classificationTopic");
		Join<ClassificationTopic, MainClassification> join3 = join2.join("mainClassification");

		if (chkAsc == 0) {
			select.orderBy(criteriaBuilder.asc(join1.get("id")), criteriaBuilder.asc(from.get("shortcut")));
		} else if (chkAsc == 1) {

			select.orderBy(criteriaBuilder.desc(join1.get("id")), criteriaBuilder.desc(from.get("shortcut")));
		}
		List<Predicate> predicateList = new ArrayList<Predicate>();

		Predicate predicate1 = null;
		Predicate predicate2 = null;
		Predicate predicate3 = null;

		if (topicId != null) // Topic
		{
			predicate1 = criteriaBuilder.equal(from.get("topic").get("id"), topicId);
			predicateList.add(predicate1);
		}

		if (classificationTopicId != null) // ClassificationTopic
		{
			predicate2 = criteriaBuilder.equal(join2.get("id"), classificationTopicId);
			predicateList.add(predicate2);
		}

		if (mainClassificationId != null) // main classification
		{
			predicate3 = criteriaBuilder.equal(join3.get("id"), mainClassificationId);
			predicateList.add(predicate3);
		}

		if (fulltextSearch != "" && (!fulltextSearch.equals("")) && fulltextSearch != null) {

			fulltextSearch = fulltextSearch.trim();
			Expression<String> skillDescExp = from.get("description");
			Expression<String> germanTestExp = from.get("german_text");

			Expression<String> keywordDesc = join4.get("name");

			Predicate pre1 = criteriaBuilder.like(skillDescExp, "%" + fulltextSearch + "%");
			Predicate pre2 = criteriaBuilder.like(germanTestExp, "%" + fulltextSearch + "%");
			Predicate pre3 = criteriaBuilder.like(keywordDesc, "%" + fulltextSearch + "%");

			Predicate orPre = criteriaBuilder.or(pre1, pre2, pre3);

			predicateList.add(orPre);
		}

		if (predicateList.size() > 0)
			criteriaQuery.where(criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()])));

		TypedQuery<Skill> result = entityManager().createQuery(criteriaQuery);

		Log.debug("Critera query is :" + result.unwrap(Query.class).getQueryString());

		List<Skill> skillresultList = new ArrayList<Skill>();

		int totalSize = 0;

		{
			totalSize = result.getResultList().size();

			result.setFirstResult(start);

			result.setMaxResults(max);

			skillresultList = result.getResultList();

			Log.debug("RESULTLISTSIZE : " + skillresultList.size());
		}

		List<SkillLevels> skillAcquiredList = findSkillAcquiredByStudents(skillresultList, studentId);
		List<String> skillCommentList = findSkillCommentByStudent(skillresultList, studentId);

		SkillFilteredResult finalresult = new SkillFilteredResult();

		finalresult.setTotalSkill(totalSize);
		finalresult.setSkillList(skillresultList);
		finalresult.setSkilltLevelsAcquiredList(skillAcquiredList);
		finalresult.setSkillComment(skillCommentList);

		return finalresult;
	}

	public static SkillFilteredResult findMainClassificatonBySearchCriteria(Long studentId, Long mainClassificationId, Long classificationTopicId, Long topicId, String fulltextSearch, int chkAsc) {

		Log.debug("Asc :" + chkAsc);

		CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
		CriteriaQuery<Skill> criteriaQuery = criteriaBuilder.createQuery(Skill.class);
		Root<Skill> from = criteriaQuery.from(Skill.class);
		CriteriaQuery<Skill> select = criteriaQuery.select(from);

		Join<Skill, Topic> join1 = from.join("topic");
		SetJoin<Skill, Keyword> join4 = from.joinSet("keywords", JoinType.LEFT);
		Join<Topic, ClassificationTopic> join2 = join1.join("classificationTopic");
		Join<ClassificationTopic, MainClassification> join3 = join2.join("mainClassification");

		if (chkAsc == 0) {
			select.orderBy(criteriaBuilder.asc(join1.get("id")), criteriaBuilder.asc(from.get("shortcut")));
		} else if (chkAsc == 1) {
			select.orderBy(criteriaBuilder.desc(join1.get("id")), criteriaBuilder.desc(from.get("shortcut")));
		}

		List<Predicate> predicateList = new ArrayList<Predicate>();

		Predicate predicate1 = null;
		Predicate predicate2 = null;
		Predicate predicate3 = null;

		if (topicId != null) // Topic
		{
			predicate1 = criteriaBuilder.equal(from.get("topic").get("id"), topicId);
			predicateList.add(predicate1);
		}

		if (classificationTopicId != null) // ClassificationTopic
		{
			predicate2 = criteriaBuilder.equal(join2.get("id"), classificationTopicId);
			predicateList.add(predicate2);
		}

		if (mainClassificationId != null) // main classification
		{
			predicate3 = criteriaBuilder.equal(join3.get("id"), mainClassificationId);
			predicateList.add(predicate3);
		}

		if (fulltextSearch != "" && (!fulltextSearch.equals("")) && fulltextSearch != null) {

			fulltextSearch = fulltextSearch.trim();
			Expression<String> skillDescExp = from.get("description");
			Expression<String> germanTestExp = from.get("german_text");

			Expression<String> keywordDesc = join4.get("name");

			Predicate pre1 = criteriaBuilder.like(skillDescExp, "%" + fulltextSearch + "%");
			Predicate pre2 = criteriaBuilder.like(germanTestExp, "%" + fulltextSearch + "%");
			Predicate pre3 = criteriaBuilder.like(keywordDesc, "%" + fulltextSearch + "%");

			Predicate orPre = criteriaBuilder.or(pre1, pre2, pre3);

			predicateList.add(orPre);
		}

		if (predicateList.size() > 0)
			criteriaQuery.where(criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()])));

		TypedQuery<Skill> result = entityManager().createQuery(criteriaQuery);

		Log.debug("Critera query is :" + result.unwrap(Query.class).getQueryString());

		List<Skill> skillresultList = new ArrayList<Skill>();

		int totalSize = 0;

		totalSize = result.getResultList().size();

		skillresultList = result.getResultList();

		Log.debug("RESULTLISTSIZE : " + skillresultList.size());

		SkillFilteredResult finalresult = new SkillFilteredResult();

		finalresult.setTotalSkill(totalSize);
		finalresult.setSkillList(skillresultList);

		return finalresult;
	}

	public static String findProgressOfMainClassification(MainClassification mainClassification, Long studentId) {

		List<ClassificationTopic> cts = mainClassification.getClassificationTopics();
		Long aquiredSkillCount = 0l;
		Long totalSkill = 0l;
		for (int i = 0; i < cts.size(); i++) {
			ClassificationTopic ctopic = cts.get(i);

			List<Topic> topics = ctopic.getTopics();

			for (int j = 0; j < topics.size(); j++) {
				Topic topic = topics.get(j);
				aquiredSkillCount = aquiredSkillCount + findTotalSkillAcquiredByTopicAndStudent(topic.getId(), studentId);

				totalSkill = totalSkill + topic.getSkills().size();
			}
		}

		return aquiredSkillCount + "/" + totalSkill.toString();
	}

	public static String findProgressOfClassificationTopic(ClassificationTopic classificationTopic, Long studentId) {

		List<Topic> ts = classificationTopic.getTopics();
		Long aquiredSkillCount = 0l;
		Long totalSkill = 0l;
		for (int i = 0; i < ts.size(); i++) {
			Topic topic = ts.get(i);

			aquiredSkillCount = aquiredSkillCount + findTotalSkillAcquiredByTopicAndStudent(topic.getId(), studentId);

			totalSkill = totalSkill + topic.getSkills().size();

		}

		return aquiredSkillCount + "/" + totalSkill.toString();
	}

	public static String findProgressOfTopic(Topic topic, Long studentId) {

		Long aquiredSkillCount = 0l;
		Integer totalSkill = topic.getSkills().size();

		aquiredSkillCount = aquiredSkillCount + findTotalSkillAcquiredByTopicAndStudent(topic.getId(), studentId);

		return aquiredSkillCount + "/" + totalSkill.toString();
	}

	public static Long findTotalSkillAcquiredByTopicAndStudent(long topicId, long studentId) {
		Long count = SkillAcquired.findTotalSkillAcquiredByTopicAndStudent(topicId, studentId);
		return count;
	}

	public static Integer findSkillLevelAcquired(long studentId, long skillId) {
		EntityManager em = entityManager();
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<SkillAcquired> criteriaQuery = criteriaBuilder.createQuery(SkillAcquired.class);
		Root<SkillAcquired> from = criteriaQuery.from(SkillAcquired.class);
		CriteriaQuery<SkillAcquired> select = criteriaQuery.select(from);
		Predicate p1 = criteriaBuilder.and(criteriaBuilder.equal(from.get("student").get("id"), studentId));
		Predicate p2 = criteriaBuilder.and(criteriaBuilder.equal(from.get("skill").get("id"), skillId));
		Predicate p = criteriaBuilder.and(p1, p2);
		select.where(p);

		TypedQuery<SkillAcquired> result = em.createQuery(criteriaQuery);

		if (result.getResultList().size() > 0)
			return result.getResultList().get(0).getSkillLevel().getLevelNumber();
		else
			return null;
	}

	private static List<String> findSkillCommentByStudent(List<Skill> skillresultList, Long studentId) {

		List<String> result = new ArrayList<String>();

		for (Skill skill : skillresultList) {
			try {

				result.add(getCommentOfStudentForSkill(skill.getId(), studentId));

			} catch (Exception e) {
				Log.debug("Error" + e.getStackTrace());
			}
		}

		return result;
	}

	private static List<SkillLevels> findSkillAcquiredByStudents(List<Skill> skillresultList, Long studentId) {

		List<SkillLevels> result = new ArrayList<SkillLevels>();

		for (Skill skill : skillresultList) {

			try {

				result.add(getSkillAcquiredbyStudentAtThisLevel(studentId, skill.getId()));

			} catch (Exception e) {
				Log.debug("Error" + e.getStackTrace());
			}
		}

		return result;
	}

	public static String retrieveHtmlFile(Long studentId, Long mainClassificationId, Long classificationTopicId, Long topicId, String fulltextSearch, int chkAsc) {

		try {
			String File_To_Convert = createHtml(Skill.findMainClassificatonBySearchCriteria(studentId, mainClassificationId, classificationTopicId, topicId, fulltextSearch, chkAsc), studentId);

			return FileUtils.readFileToString(new File(File_To_Convert));
		} catch (Exception e) {

			return "No data found";
		}
	}

	public static Document createDocument() {
		try {
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static Element createChildNode(String nodeName, String nodeValue, Document doc, Element parent) {
		Element element = doc.createElement(nodeName);// create node
		parent.appendChild(element); // append to its parent
		Text text2 = doc.createTextNode(nodeValue); // create Text node/ value
		element.appendChild(text2);
		return element;
	}

	public static Element createEmptyChildNode(String nodeName, Document doc, Element parent) {
		Element element = doc.createElement(nodeName);// create node
		parent.appendChild(element); // append to its parent
		return element;
	}

	public static String createHtml(SkillFilteredResult result, Long studentId) {
		Document doc = createDocument();

		Element root = doc.createElement("mainClassifications");

		// append root to document
		doc.appendChild(root);
		List<Skill> skills = result.getSkillList();

		Element classificationTopicsElement = null;
		Element topicsElement = null;
		Element skillsElement = null;

		for (int i = 0; i < skills.size(); i++) {
			Skill skill = skills.get(i);
			String topicDescription = skill.getTopic().getTopicDescription();
			String ctopicDescription = skill.getTopic().getClassificationTopic().getDescription();
			String mDescription = (skill.getTopic().getClassificationTopic().getMainClassification().getDescription());

			if (i == 0) {
				Element mainClassificationElement = createEmptyChildNode("mainClassification", doc, root);
				createChildNode("description", mDescription, doc, mainClassificationElement);

				classificationTopicsElement = createEmptyChildNode("classificationTopics", doc, mainClassificationElement);
				Element classificationTopicElement = createEmptyChildNode("classificationTopic", doc, classificationTopicsElement);
				createChildNode("description", ctopicDescription, doc, classificationTopicElement);

				topicsElement = createEmptyChildNode("topics", doc, classificationTopicElement);
				Element topicElement = createEmptyChildNode("topic", doc, topicsElement);
				createChildNode("description", topicDescription, doc, topicElement);
				skillsElement = createEmptyChildNode("skills", doc, topicElement);

			} else {
				if ((skill.getTopic().getClassificationTopic().getMainClassification().getId() != skills.get(i - 1).getTopic().getClassificationTopic().getMainClassification().getId())) {
					Element mainClassificationElement = createEmptyChildNode("mainClassification", doc, root);
					createChildNode("description", mDescription, doc, mainClassificationElement);

					classificationTopicsElement = createEmptyChildNode("classificationTopics", doc, mainClassificationElement);
					Element classificationTopicElement = createEmptyChildNode("classificationTopic", doc, classificationTopicsElement);
					createChildNode("description", ctopicDescription, doc, classificationTopicElement);

					topicsElement = createEmptyChildNode("topics", doc, classificationTopicElement);
					Element topicElement = createEmptyChildNode("topic", doc, topicsElement);
					createChildNode("description", topicDescription, doc, topicElement);
					skillsElement = createEmptyChildNode("skills", doc, topicElement);
				}

				else if ((skill.getTopic().getClassificationTopic().getId() != skills.get(i - 1).getTopic().getClassificationTopic().getId())) {
					if (!skill.getTopic().getClassificationTopic().getDescription().equals("Blank")) {

						Element classificationTopicElement = createEmptyChildNode("classificationTopic", doc, classificationTopicsElement);
						createChildNode("description", ctopicDescription, doc, classificationTopicElement);

						topicsElement = createEmptyChildNode("topics", doc, classificationTopicElement);
						Element topicElement = createEmptyChildNode("topic", doc, topicsElement);
						createChildNode("description", topicDescription, doc, topicElement);
						skillsElement = createEmptyChildNode("skills", doc, topicElement);
					}
				}

				else if ((skill.getTopic().getId() != skills.get(i - 1).getTopic().getId())) {

					Element topicElement = createEmptyChildNode("topic", doc, topicsElement);
					createChildNode("description", topicDescription, doc, topicElement);
					skillsElement = createEmptyChildNode("skills", doc, topicElement);

				}
			}

			Element skillElement = createEmptyChildNode("skill", doc, skillsElement);
			createChildNode("description", skill.getDescription(), doc, skillElement);

			String ctopicShortCut = "";
			String mainClassificationShortcut = "";
			if (skill.getTopic().getClassificationTopic().getShortcut() != null)
				ctopicShortCut = skill.getTopic().getClassificationTopic().getShortcut();

			if (skill.getTopic().getClassificationTopic().getMainClassification().getShortcut() != null)
				mainClassificationShortcut = skill.getTopic().getClassificationTopic().getMainClassification().getShortcut();

			createChildNode("shortcut", mainClassificationShortcut + " " + ctopicShortCut + " " + skill.getShortcut(), doc, skillElement);

			if (skill.getSkillLevel() != null)
				createChildNode("skillLevel", skill.getSkillLevel().getLevelNumber().toString(), doc, skillElement);
			else
				createChildNode("skillLevel", "-", doc, skillElement);

			Integer levelNum = Skill.findSkillLevelAcquired(studentId, skill.getId());
			if (levelNum != null)
				createChildNode("skillLevelAcquired", levelNum.toString(), doc, skillElement);
			else
				createChildNode("skillLevelAcquired", "-", doc, skillElement);
		}

		return saveXML(doc);

	}

	public static String saveXML(Document doc) {
		try {
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			StringWriter sw = new StringWriter();
			StreamResult result = new StreamResult(sw);
			DOMSource source = new DOMSource(doc);
			transformer.transform(source, result);
			String xmlString = sw.toString();

			String path = RequestFactoryServlet.getThreadLocalRequest().getSession().getServletContext().getRealPath("/logbook/");
			String fileName = path + "/" + System.currentTimeMillis() + ".xml";
			Log.debug("Path: " + fileName);

			File file = new File(fileName);
			file.createNewFile();
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8"));
			bw.write(xmlString);
			bw.flush();
			bw.close();

			String htmlFileName = convertXmlToHtml(fileName);

			return htmlFileName;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String convertXmlToHtml(String fileName) {
		try {
			TransformerFactory tFactory = TransformerFactory.newInstance();
			String xslPath = RequestFactoryServlet.getThreadLocalRequest().getSession().getServletContext().getRealPath("/logbook/skill.xsl");
			Source xslDoc = new StreamSource(xslPath);
			Source xmlDoc = new StreamSource(fileName);

			String path = RequestFactoryServlet.getThreadLocalRequest().getSession().getServletContext().getRealPath("/logbook/");
			String outputFileName = path + "/" + System.currentTimeMillis() + ".html";
			Log.debug("Path: " + outputFileName);
			OutputStream htmlFile = new FileOutputStream(outputFileName);

			Transformer transformer = tFactory.newTransformer(xslDoc);

			transformer.transform(xmlDoc, new StreamResult(htmlFile));
			htmlFile.close();
			File xmlFile = new File(fileName);
			xmlFile.delete();
			return outputFileName;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static SkillLevels getSkillAcquiredbyStudentAtThisLevel(Long studentID, Long skillID) {

		Log.debug("Inside isSkillAcquiredbyStudentAtFirstLevel with student " + studentID + " skill : " + skillID);
		EntityManager em = entityManager();

		String query = "SELECT sa.skillLevel from SkillAcquired as sa where sa.student=" + studentID + " and sa.skill=" + skillID;
		Log.debug("Query is :" + query);
		TypedQuery<SkillLevel> result = em.createQuery(query, SkillLevel.class);
		if (result.getResultList().size() == 0) {
			return SkillLevels.NONE;
		} else {

			if (result.getResultList().get(0).getLevelNumber() == 1) {
				return SkillLevels.SOME_PRACTICLE_EXPERIENCE;
			} else if (result.getResultList().get(0).getLevelNumber() == 2) {
				return SkillLevels.ROUTINE;
			}
		}

		return SkillLevels.NONE;
	}

	public static Long findTotalSkillByTopic(long topicId) {
		CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<Skill> from = criteriaQuery.from(Skill.class);
		criteriaQuery.select(criteriaBuilder.count(from));
		criteriaQuery.where(criteriaBuilder.equal(from.get("topic"), topicId));
		TypedQuery<Long> result = entityManager().createQuery(criteriaQuery);
		return result.getSingleResult();
	}

	public static List<Skill> findAllSkillforCsvexport() {

		CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
		CriteriaQuery<Skill> criteriaQuery = criteriaBuilder.createQuery(Skill.class);
		Root<Skill> from = criteriaQuery.from(Skill.class);
		CriteriaQuery<Skill> select = criteriaQuery.select(from);

		Join<Skill, Topic> join1 = from.join("topic");
		Join<Topic, ClassificationTopic> join2 = join1.join("classificationTopic");
		Join<ClassificationTopic, MainClassification> join3 = join2.join("mainClassification");

		select.orderBy(criteriaBuilder.asc(join1.get("id")), criteriaBuilder.asc(from.get("shortcut")));

		TypedQuery<Skill> result = entityManager().createQuery(criteriaQuery);

		Log.debug("Critera query is :" + result.unwrap(Query.class).getQueryString());

		return result.getResultList();
	}

	public static List<Student> findAllFinalizedStudent() {

		CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
		CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
		Root<Student> from = criteriaQuery.from(Student.class);
		CriteriaQuery<Student> select = criteriaQuery.select(from);

		criteriaQuery.where(criteriaBuilder.equal(from.get("studentStatus"), StudentStatus.Fianllized));
		TypedQuery<Student> result = entityManager().createQuery(criteriaQuery);

		return result.getResultList();
	}

	public static String addCommnets(Long skillId, Long studentId, String comment) {

		String result;
		try {

			List<SkillComment> skillCommentList = getTotalComment(skillId, studentId);
			if (skillCommentList.size() == 0) {

				Skill skill = Skill.findSkill(skillId);

				SkillComment skillComment = new SkillComment();
				skillComment.setSkill(skill);
				skillComment.setStudent(Student.findStudent(studentId));
				skillComment.setComment(comment);
				skillComment.persist();

				skill.persist();

				result = "INSERT";
			} else {

				SkillComment skillComment = skillCommentList.get(0);
				skillComment.setComment(comment);
				skillComment.persist();

				result = "EDIT";
			}
		} catch (Exception e) {
			Log.debug("asdkh " + e.getStackTrace());
			result = "FAILURE";
		}
		return result;

	}

	public static List<SkillComment> getTotalComment(Long skillId, Long studentId) {

		CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
		CriteriaQuery<SkillComment> criteriaQuery = criteriaBuilder.createQuery(SkillComment.class);
		Root<SkillComment> from = criteriaQuery.from(SkillComment.class);
		CriteriaQuery<SkillComment> select = criteriaQuery.select(from);

		Predicate p1 = criteriaBuilder.and(criteriaBuilder.equal(from.get("student").get("id"), studentId));
		Predicate p2 = criteriaBuilder.and(criteriaBuilder.equal(from.get("skill").get("id"), skillId));

		criteriaQuery.where(criteriaBuilder.and(p1, p2));

		TypedQuery<SkillComment> result = entityManager().createQuery(criteriaQuery);

		Log.debug("Query is :" + result.unwrap(Query.class).getQueryString());

		return result.getResultList();
	}

	public static String getCommentOfStudentForSkill(Long skillId, Long studentId) {

		CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
		CriteriaQuery<SkillComment> criteriaQuery = criteriaBuilder.createQuery(SkillComment.class);
		Root<SkillComment> from = criteriaQuery.from(SkillComment.class);
		CriteriaQuery<SkillComment> select = criteriaQuery.select(from);

		Predicate p1 = criteriaBuilder.and(criteriaBuilder.equal(from.get("student").get("id"), studentId));
		Predicate p2 = criteriaBuilder.and(criteriaBuilder.equal(from.get("skill").get("id"), skillId));

		criteriaQuery.where(criteriaBuilder.and(p1, p2));

		TypedQuery<SkillComment> result = entityManager().createQuery(criteriaQuery);

		Log.debug("Query is :" + result.unwrap(Query.class).getQueryString());

		if (result.getResultList().size() > 0 && result.getResultList().get(0).getComment() != null)
			return result.getResultList().get(0).getComment();
		else
			return "";
	}

	public static final EntityManager entityManager() {
		EntityManager em = new Skill().entityManager;
		if (em == null)
			throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
		return em;
	}

	public static long countSkills() {
		return entityManager().createQuery("SELECT COUNT(o) FROM Skill o", Long.class).getSingleResult();
	}

	public static List<Skill> findAllSkills() {
		return entityManager().createQuery("SELECT o FROM Skill o", Skill.class).getResultList();
	}

	public static Skill findSkill(Long id) {
		if (id == null)
			return null;
		return entityManager().find(Skill.class, id);
	}

	public static List<Skill> findSkillEntries(int firstResult, int maxResults) {
		return entityManager().createQuery("SELECT o FROM Skill o", Skill.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
	}

	@Transactional
	public void persist() {
		if (this.entityManager == null)
			this.entityManager = entityManager();
		this.entityManager.persist(this);
	}

	@Transactional
	public void remove() {
		if (this.entityManager == null)
			this.entityManager = entityManager();
		if (this.entityManager.contains(this)) {
			this.entityManager.remove(this);
		} else {
			Skill attached = Skill.findSkill(this.id);
			this.entityManager.remove(attached);
		}
	}

	@Transactional
	public void flush() {
		if (this.entityManager == null)
			this.entityManager = entityManager();
		this.entityManager.flush();
	}

	@Transactional
	public void clear() {
		if (this.entityManager == null)
			this.entityManager = entityManager();
		this.entityManager.clear();
	}

	@Transactional
	public Skill merge() {
		if (this.entityManager == null)
			this.entityManager = entityManager();
		Skill merged = this.entityManager.merge(this);
		this.entityManager.flush();
		return merged;
	}

	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
