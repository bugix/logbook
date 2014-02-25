package ch.unibas.medizin.logbook.client.request;

import com.google.web.bindery.requestfactory.shared.LoggingRequest;
import com.google.web.bindery.requestfactory.shared.RequestFactory;

/**
 * The base request factory interface for this app. Add new custom request types
 * here without fear of them being managed away by Roo.
 */
public interface LogBookRequestFactory extends RequestFactory {

	/**
	 * Return a GWT logging request.
	 */
	LoggingRequest loggingRequest();

	StudentRequest studentRequest();

	ClassificationTopicRequest classificationTopicRequest();

	TopicRequest topicRequest();

	SkillRequest skillRequest();

	SkillAcquiredRequest skillAcquiredRequest();

	AdministratorRequest administratorRequest();

	MainClassificationRequest mainClassificationRequest();

}
