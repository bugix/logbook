// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package logbook.server.domain;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import logbook.server.domain.SkillComment;
import org.springframework.transaction.annotation.Transactional;

privileged aspect SkillComment_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager SkillComment.entityManager;
    
    public static final EntityManager SkillComment.entityManager() {
        EntityManager em = new SkillComment().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long SkillComment.countSkillComments() {
        return entityManager().createQuery("SELECT COUNT(o) FROM SkillComment o", Long.class).getSingleResult();
    }
    
    public static List<SkillComment> SkillComment.findAllSkillComments() {
        return entityManager().createQuery("SELECT o FROM SkillComment o", SkillComment.class).getResultList();
    }
    
    public static SkillComment SkillComment.findSkillComment(Long id) {
        if (id == null) return null;
        return entityManager().find(SkillComment.class, id);
    }
    
    public static List<SkillComment> SkillComment.findSkillCommentEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM SkillComment o", SkillComment.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void SkillComment.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void SkillComment.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            SkillComment attached = SkillComment.findSkillComment(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void SkillComment.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void SkillComment.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public SkillComment SkillComment.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        SkillComment merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
