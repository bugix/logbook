package logbook.server;
/**
 * @author Manish
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.List;

import logbook.client.CsvFileGeneratorService;
import logbook.server.domain.ClassificationTopic;
import logbook.server.domain.MainClassification;
import logbook.server.domain.Skill;
import logbook.server.domain.SkillAcquired;
import logbook.server.domain.Student;
import logbook.server.domain.Topic;
import logbook.shared.CsvFileGeneratorEvent;
import logbook.shared.StudentStatus;

import com.csvreader.CsvWriter;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;


import de.novanic.eventservice.client.event.domain.Domain;
import de.novanic.eventservice.client.event.domain.DomainFactory;
import de.novanic.eventservice.service.RemoteEventServiceServlet;


@SuppressWarnings("serial")
@Transactional
public class CsvFileGeneratorServiceImpl  extends RemoteEventServiceServlet implements CsvFileGeneratorService,Runnable{
	
	private static Logger Log = Logger.getLogger(CsvFileGeneratorServiceImpl.class);
	
	
	private static final Domain DOMAIN = DomainFactory.getDomain("localhost");
	private boolean isChangeFinalizeToExportdSelected;
	@Override
	
	public void csvFileGeneratorClicked(boolean isChangeFinalizeToExportdSelected) {
		this.isChangeFinalizeToExportdSelected=isChangeFinalizeToExportdSelected;
		
		Log.info("Inside csvFileGeneratorClicked ");
		
		this.csvFileGenerator2();
		return;
	}
	public void csvFileGenerator2(){
		
		Log.info("Inside csvFileGenerator2 To execute file generation in seprate thread");
		Thread t = new Thread(this);
		t.start();
	}
	
	@Override
	public void run() {
	
		Log.info("Inside run()");
		boolean isException=false;
		
		try{
		
	    		System.out.println("Inside Student");
				List<Skill> allSkills=Skill.findAllSkillforCsvexport();
				String string;
				
				int counter=0;
				
				String fileSeparator = System.getProperty("file.separator");
				//String fileName = RequestFactoryServlet.getThreadLocalServletContext().getRealPath(fileSeparator) +  "public/test.csv";
				String fileName = getServletContext().getRealPath(fileSeparator) +  "public/test.csv";

				File csvFile = new File(fileName);
				
				FileUtils.touch(csvFile);
				
				CsvWriter writer = new CsvWriter(new FileWriter(fileName),',');

				writer.write("Student ID");
				
				System.out.println("Skills " + allSkills.size());
				
				for(Skill skill : allSkills){
					
					
					Topic t =skill.getTopic();
					ClassificationTopic ct = t.getClassificationTopic();
					MainClassification m = ct.getMainClassification();
				
					writer.write(m.getShortcut()+" " + ct.getShortcut() + " " + skill.getShortcut());
					counter++;
					
				}
				
				//System.out.println("Count is :" + counter);
				
				writer.endRecord();
				
				List<Student> allFinalizedStudent = Skill.findAllFinalizedStudent();
				
				System.out.println("All finalized student  " + allFinalizedStudent.size());
				
				for(Student student : allFinalizedStudent){
					
					writer.write(""+student.getId());
					
					int [] acquiredArray = new int[allSkills.size()];
					
					List<SkillAcquired> skillAcquiredByStudent =SkillAcquired.findSkillAcquiredByStudent(student.getId());
					
					System.out.println("skillAcquiredByStudent Length : " + skillAcquiredByStudent.size());
					
					for(SkillAcquired skillacquired : skillAcquiredByStudent){
						
						acquiredArray[allSkills.indexOf(skillacquired.getSkill())]=skillacquired.getSkillLevel().getLevelNumber();
					}
					
					System.out.println("acquiredArray.length" + acquiredArray.length);
					
					for(int i=0;i<acquiredArray.length;i++){
						
						writer.write(""+acquiredArray[i]);
					}
					
					writer.endRecord();
					
				}
				
				if(isChangeFinalizeToExportdSelected){
				//changeStudentStatusExported(allFinalizedStudent);
				
					for(Student student : allFinalizedStudent){
						student.setStudentStatus(StudentStatus.Exported);
						student.persist();
					}
				}
				
				writer.close();
				
			
		}catch(Exception e){
			Log.info("Error is : " + e.getMessage());
			e.printStackTrace();
			isException=true;
			this.addEvent(DOMAIN, new CsvFileGeneratorEvent(false));
		}
		if(!isException)
			this.addEvent(DOMAIN, new CsvFileGeneratorEvent(true));
	}
	
}
