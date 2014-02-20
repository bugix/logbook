package ch.unibas.medizin.logbook.server.locator;

import org.springframework.stereotype.Component;

import ch.unibas.medizin.logbook.server.domain.Student;

import com.google.web.bindery.requestfactory.shared.Locator;

@Component
public class StudentLocator extends Locator<Student, Long> {

    public Student create(Class<? extends Student> clazz) {
        return new Student();
    }

    public Student find(Class<? extends Student> clazz, Long id) {
        return Student.findStudent(id);
    }

    public Class<Student> getDomainType() {
        return Student.class;
    }

    public Long getId(Student student) {
        return student.getId();
    }

    public Class<java.lang.Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(Student student) {
        return student.getVersion();
    }
}
