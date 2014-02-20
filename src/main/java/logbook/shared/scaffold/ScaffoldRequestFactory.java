package logbook.shared.scaffold;

import logbook.client.managed.request.AdministratorRequest;
import logbook.client.managed.request.ClassificationTopicRequest;
import logbook.client.managed.request.MainClassificationRequest;
import logbook.client.managed.request.SkillAcquiredRequest;
import logbook.client.managed.request.SkillRequest;
import logbook.client.managed.request.StudentRequest;
import logbook.client.managed.request.TopicRequest;

import com.google.web.bindery.requestfactory.shared.LoggingRequest;
import com.google.web.bindery.requestfactory.shared.RequestFactory;

/**
 * The base request factory interface for this app. Add
 * new custom request types here without fear of them
 * being managed away by Roo.
 */
public interface ScaffoldRequestFactory extends RequestFactory {
	
	/**
	 * Return a GWT logging request.
	 */
	LoggingRequest loggingRequest();
	
	StudentRequestNonRoo studentRequestNonRoo();
ClassificationTopicRequestNonRoo classificationTopicRequestNonRoo(); 
TopicRequestNonRoo  topicRequestNonRoo();
	
	SkillRequestNonRoo skillRequestNonRoo();
	
	SkillAcquiredRequestNonRoo skillAcquiredRequestNonRoo();
	
	AdministratorRequestNonRoo administratorRequestNonRoo();
	
	
	
	StudentRequest studentRequest();
	ClassificationTopicRequest classificationTopicRequest(); 
	TopicRequest  topicRequest();

	
	SkillRequest skillRequest();
	
	SkillAcquiredRequest skillAcquiredRequest();
	
	AdministratorRequest administratorRequest();
	
	MainClassificationRequest mainClassificationRequest();
	
}
