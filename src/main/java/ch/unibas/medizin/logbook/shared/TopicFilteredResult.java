package ch.unibas.medizin.logbook.shared;

import java.util.List;

import ch.unibas.medizin.logbook.server.domain.Topic;

public class TopicFilteredResult {

	List<Topic> topicList;

	List<Long> topicAcquiredList;

	List<Long> totalTopicList;

	Integer totalTopics;

	public List<Topic> getTopicList() {
		return topicList;
	}

	public void setTopicList(List<Topic> topicList) {
		this.topicList = topicList;
	}

	public List<Long> getTopicAcquiredList() {
		return topicAcquiredList;
	}

	public void setTopicAcquiredList(List<Long> totalAcquiredTopicBySkill) {
		topicAcquiredList = totalAcquiredTopicBySkill;
	}

	public List<Long> getTotalTopicList() {
		return totalTopicList;
	}

	public void setTotalTopicList(List<Long> totalTopicList) {
		this.totalTopicList = totalTopicList;
	}

	public void setTotalTopic(int size) {
		totalTopics = size;
	}

	public Integer getTotalTopics() {
		return totalTopics;
	}

	public void setTotalTopics(Integer totalTopics) {
		this.totalTopics = totalTopics;
	}

}
