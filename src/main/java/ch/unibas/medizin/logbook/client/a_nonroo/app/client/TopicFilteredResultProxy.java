package ch.unibas.medizin.logbook.client.a_nonroo.app.client;

import java.util.List;

import ch.unibas.medizin.logbook.client.managed.proxy.TopicProxy;
import ch.unibas.medizin.logbook.shared.TopicFilteredResult;

import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.ValueProxy;

@ProxyFor(value = TopicFilteredResult.class )
public interface TopicFilteredResultProxy extends ValueProxy {

	
	public List<TopicProxy> getTopicList();
	
	public List<Long> getTopicAcquiredList();
	
	public List<Long> getTotalTopicList();
	
	public void setTotalTopicList(List<Long> totalTopicList);
	
	public void setTopicAcquiredList(List<Long> topicAcquiredList);
	
	public void setTopicList(List<TopicProxy> topicList);
	
	public Integer getTotalTopics();
	
	public void setTotalTopics(Integer totalTopics);
	
}
