package ch.unibas.medizin.logbook.server;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import ch.unibas.medizin.logbook.client.service.CsvFileGeneratorService;
import ch.unibas.medizin.logbook.server.domain.ClassificationTopic;
import ch.unibas.medizin.logbook.server.domain.MainClassification;
import ch.unibas.medizin.logbook.server.domain.Skill;
import ch.unibas.medizin.logbook.server.domain.SkillAcquired;
import ch.unibas.medizin.logbook.server.domain.Student;
import ch.unibas.medizin.logbook.server.domain.Topic;
import ch.unibas.medizin.logbook.shared.CsvFileGeneratorEvent;
import ch.unibas.medizin.logbook.shared.enums.StudentStatus;

import com.csvreader.CsvWriter;

import de.novanic.eventservice.client.event.domain.Domain;
import de.novanic.eventservice.client.event.domain.DomainFactory;
import de.novanic.eventservice.service.RemoteEventServiceServlet;

@SuppressWarnings("serial")
@Transactional
public class CsvFileGeneratorServiceImpl extends RemoteEventServiceServlet implements CsvFileGeneratorService, Runnable {

	private final Logger logger = LoggerFactory.getLogger(CsvFileGeneratorServiceImpl.class);

	private static final Domain DOMAIN = DomainFactory.getDomain("localhost");
	private boolean isChangeFinalizeToExportdSelected;

	@Override
	public void csvFileGeneratorClicked(boolean isChangeFinalizeToExportdSelected) {
		this.isChangeFinalizeToExportdSelected = isChangeFinalizeToExportdSelected;

		logger.debug("Inside csvFileGeneratorClicked ");

		csvFileGenerator2();
		return;
	}

	public void csvFileGenerator2() {

		logger.debug("Inside csvFileGenerator2 To execute file generation in seprate thread");
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {

		logger.debug("Inside run()");
		boolean isException = false;

		try {

			logger.debug("Inside Student");
			List<Skill> allSkills = Skill.findAllSkillforCsvexport();

			String fileSeparator = System.getProperty("file.separator");

			String fileName = getServletContext().getRealPath(fileSeparator) + "public/test.csv";

			File csvFile = new File(fileName);

			FileUtils.touch(csvFile);

			CsvWriter writer = new CsvWriter(new FileWriter(fileName), ',');

			writer.write("Student ID");

			writer.write("Email");

			logger.debug("Skills " + allSkills.size());

			for (Skill skill : allSkills) {
				Topic t = skill.getTopic();
				ClassificationTopic ct = t.getClassificationTopic();
				MainClassification m = ct.getMainClassification();

				writer.write(m.getShortcut() + " " + ct.getShortcut() + " " + skill.getShortcut());
			}

			writer.endRecord();

			List<Student> allFinalizedStudent = Skill.findAllFinalizedStudent();

			logger.debug("All finalized student  " + allFinalizedStudent.size());

			for (Student student : allFinalizedStudent) {

				writer.write(student.getStudentId() != null ? student.getStudentId() : null);
				writer.write(student.getEmail() != null ? student.getEmail() : null);

				int[] acquiredArray = new int[allSkills.size()];

				List<SkillAcquired> skillAcquiredByStudent = SkillAcquired.findSkillAcquiredByStudent(student.getId());

				logger.debug("skillAcquiredByStudent Length : " + skillAcquiredByStudent.size());

				for (SkillAcquired skillacquired : skillAcquiredByStudent) {

					acquiredArray[allSkills.indexOf(skillacquired.getSkill())] = skillacquired.getSkillLevel().getLevelNumber();
				}

				logger.debug("acquiredArray.length" + acquiredArray.length);

				for (int element : acquiredArray) {

					writer.write("" + element);
				}

				writer.endRecord();

			}

			writer.write(null);
			writer.write(null);

			for (Skill skill : allSkills) {
				writer.write("" + skill.getSkillLevel().getLevelNumber());
			}
			writer.endRecord();

			writer.close();

			if (isChangeFinalizeToExportdSelected) {
				for (Student student : allFinalizedStudent) {
					student.setStudentStatus(StudentStatus.Exported);
					student.persist();
				}
			}

		} catch (Exception e) {
			logger.debug("Error is : " + e.getMessage());
			e.printStackTrace();
			isException = true;
			addEvent(DOMAIN, new CsvFileGeneratorEvent(false));
		}
		if (!isException) {
			addEvent(DOMAIN, new CsvFileGeneratorEvent(true));
		}
	}
}
