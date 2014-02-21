package ch.unibas.medizin.logbook.server.locator;

import org.springframework.stereotype.Component;

import ch.unibas.medizin.logbook.server.domain.Student;

import com.google.web.bindery.requestfactory.shared.Locator;

@Component
public class StudentLocator extends Locator<Student, Long> {

	@Override
	public Student create(Class<? extends Student> clazz) {
		return new Student();
	}

	@Override
	public Student find(Class<? extends Student> clazz, Long id) {
		return Student.findStudent(id);
	}

	@Override
	public Class<Student> getDomainType() {
		return Student.class;
	}

	@Override
	public Long getId(Student student) {
		return student.getId();
	}

	@Override
	public Class<Long> getIdType() {
		return Long.class;
	}

	@Override
	public Object getVersion(Student student) {
		return student.getVersion();
	}
}
