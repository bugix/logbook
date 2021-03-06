// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package logbook.server.domain;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import logbook.server.domain.ClassificationTopicDataOnDemand;
import logbook.server.domain.Topic;
import logbook.server.domain.TopicDataOnDemand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect TopicDataOnDemand_Roo_DataOnDemand {
    
    declare @type: TopicDataOnDemand: @Component;
    
    private Random TopicDataOnDemand.rnd = new SecureRandom();
    
    private List<Topic> TopicDataOnDemand.data;
    
    @Autowired
    private ClassificationTopicDataOnDemand TopicDataOnDemand.classificationTopicDataOnDemand;
    
    public Topic TopicDataOnDemand.getNewTransientTopic(int index) {
        Topic obj = new Topic();
        setTopicDescription(obj, index);
        return obj;
    }
    
    public void TopicDataOnDemand.setTopicDescription(Topic obj, int index) {
        String topicDescription = "topicDescription_" + index;
        if (topicDescription.length() > 1024) {
            topicDescription = topicDescription.substring(0, 1024);
        }
        obj.setTopicDescription(topicDescription);
    }
    
    public Topic TopicDataOnDemand.getSpecificTopic(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Topic obj = data.get(index);
        Long id = obj.getId();
        return Topic.findTopic(id);
    }
    
    public Topic TopicDataOnDemand.getRandomTopic() {
        init();
        Topic obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return Topic.findTopic(id);
    }
    
    public boolean TopicDataOnDemand.modifyTopic(Topic obj) {
        return false;
    }
    
    public void TopicDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = Topic.findTopicEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Topic' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Topic>();
        for (int i = 0; i < 10; i++) {
            Topic obj = getNewTransientTopic(i);
            try {
                obj.persist();
            } catch (ConstraintViolationException e) {
                StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getConstraintDescriptor()).append(":").append(cv.getMessage()).append("=").append(cv.getInvalidValue()).append("]");
                }
                throw new RuntimeException(msg.toString(), e);
            }
            obj.flush();
            data.add(obj);
        }
    }
    
}
