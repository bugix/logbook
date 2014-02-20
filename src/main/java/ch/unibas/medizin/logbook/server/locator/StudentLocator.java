package ch.unibas.medizin.logbook.server.locator;

import com.google.web.bindery.requestfactory.shared.Locator;
import ch.unibas.medizin.logbook.server.domain.Student;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@RooGwtLocator("logbook.server.domain.Student")
@Component
public class StudentLocator extends Locator<Student, Long> {

    public Student create(Class<? extends logbook.server.domain.Student> clazz) {
        return new Student();
    }

    public Student find(Class<? extends logbook.server.domain.Student> clazz, Long id) {
        return Student.findStudent(id);
    }

    public Class<logbook.server.domain.Student> getDomainType() {
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
