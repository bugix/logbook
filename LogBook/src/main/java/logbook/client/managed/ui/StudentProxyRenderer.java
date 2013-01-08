package logbook.client.managed.ui;

import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import java.util.Set;
import logbook.client.managed.proxy.SkillAcquiredProxy;
import logbook.client.managed.proxy.StudentProxy;
import logbook.shared.Gender;
import logbook.shared.StudentStatus;
import logbook.shared.StudyYears;

public class StudentProxyRenderer extends ProxyRenderer<StudentProxy> {

    private static logbook.client.managed.ui.StudentProxyRenderer INSTANCE;

    protected StudentProxyRenderer() {
        super(new String[] { "studentId" });
    }

    public static logbook.client.managed.ui.StudentProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new StudentProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(StudentProxy object) {
        if (object == null) {
            return "";
        }
        return object.getStudentId() + " (" + object.getStudentId() + ")";
    }
}
