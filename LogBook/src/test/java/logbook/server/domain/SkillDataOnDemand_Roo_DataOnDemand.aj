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
import logbook.server.domain.Skill;
import logbook.server.domain.SkillDataOnDemand;
import logbook.server.domain.SkillLevelDataOnDemand;
import logbook.server.domain.TopicDataOnDemand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect SkillDataOnDemand_Roo_DataOnDemand {
    
    declare @type: SkillDataOnDemand: @Component;
    
    private Random SkillDataOnDemand.rnd = new SecureRandom();
    
    private List<Skill> SkillDataOnDemand.data;
    
    @Autowired
    SkillLevelDataOnDemand SkillDataOnDemand.skillLevelDataOnDemand;
    
    @Autowired
    TopicDataOnDemand SkillDataOnDemand.topicDataOnDemand;
    
    public Skill SkillDataOnDemand.getNewTransientSkill(int index) {
        Skill obj = new Skill();
        setDescription(obj, index);
        setGerman_text(obj, index);
        setShortcut(obj, index);
        return obj;
    }
    
    public void SkillDataOnDemand.setDescription(Skill obj, int index) {
        String description = "description_" + index;
        if (description.length() > 1024) {
            description = description.substring(0, 1024);
        }
        obj.setDescription(description);
    }
    
    public void SkillDataOnDemand.setGerman_text(Skill obj, int index) {
        String german_text = "german_text_" + index;
        if (german_text.length() > 255) {
            german_text = german_text.substring(0, 255);
        }
        obj.setGerman_text(german_text);
    }
    
    public void SkillDataOnDemand.setShortcut(Skill obj, int index) {
        Integer shortcut = new Integer(index);
        obj.setShortcut(shortcut);
    }
    
    public Skill SkillDataOnDemand.getSpecificSkill(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Skill obj = data.get(index);
        Long id = obj.getId();
        return Skill.findSkill(id);
    }
    
    public Skill SkillDataOnDemand.getRandomSkill() {
        init();
        Skill obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return Skill.findSkill(id);
    }
    
    public boolean SkillDataOnDemand.modifySkill(Skill obj) {
        return false;
    }
    
    public void SkillDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = Skill.findSkillEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Skill' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Skill>();
        for (int i = 0; i < 10; i++) {
            Skill obj = getNewTransientSkill(i);
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
