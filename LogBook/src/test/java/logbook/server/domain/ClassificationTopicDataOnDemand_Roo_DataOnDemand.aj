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
import logbook.server.domain.ClassificationTopic;
import logbook.server.domain.ClassificationTopicDataOnDemand;
import logbook.server.domain.MainClassification;
import org.springframework.stereotype.Component;

privileged aspect ClassificationTopicDataOnDemand_Roo_DataOnDemand {
    
    declare @type: ClassificationTopicDataOnDemand: @Component;
    
    private Random ClassificationTopicDataOnDemand.rnd = new SecureRandom();
    
    private List<ClassificationTopic> ClassificationTopicDataOnDemand.data;
    
    public ClassificationTopic ClassificationTopicDataOnDemand.getNewTransientClassificationTopic(int index) {
        ClassificationTopic obj = new ClassificationTopic();
        setDescription(obj, index);
        setMainClassification(obj, index);
        setShortcut(obj, index);
        return obj;
    }
    
    public void ClassificationTopicDataOnDemand.setDescription(ClassificationTopic obj, int index) {
        String description = "description_" + index;
        if (description.length() > 255) {
            description = description.substring(0, 255);
        }
        obj.setDescription(description);
    }
    
    public void ClassificationTopicDataOnDemand.setMainClassification(ClassificationTopic obj, int index) {
        MainClassification mainClassification = null;
        obj.setMainClassification(mainClassification);
    }
    
    public void ClassificationTopicDataOnDemand.setShortcut(ClassificationTopic obj, int index) {
        String shortcut = "shortc_" + index;
        if (shortcut.length() > 8) {
            shortcut = shortcut.substring(0, 8);
        }
        obj.setShortcut(shortcut);
    }
    
    public ClassificationTopic ClassificationTopicDataOnDemand.getSpecificClassificationTopic(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        ClassificationTopic obj = data.get(index);
        Long id = obj.getId();
        return ClassificationTopic.findClassificationTopic(id);
    }
    
    public ClassificationTopic ClassificationTopicDataOnDemand.getRandomClassificationTopic() {
        init();
        ClassificationTopic obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return ClassificationTopic.findClassificationTopic(id);
    }
    
    public boolean ClassificationTopicDataOnDemand.modifyClassificationTopic(ClassificationTopic obj) {
        return false;
    }
    
    public void ClassificationTopicDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = ClassificationTopic.findClassificationTopicEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'ClassificationTopic' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<ClassificationTopic>();
        for (int i = 0; i < 10; i++) {
            ClassificationTopic obj = getNewTransientClassificationTopic(i);
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