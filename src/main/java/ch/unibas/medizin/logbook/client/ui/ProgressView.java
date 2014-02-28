package ch.unibas.medizin.logbook.client.ui;

import java.util.List;

import ch.unibas.medizin.logbook.client.proxy.ClassificationTopicProxy;
import ch.unibas.medizin.logbook.client.proxy.MainClassificationProxy;
import ch.unibas.medizin.logbook.client.proxy.StudentProxy;
import ch.unibas.medizin.logbook.client.proxy.TopicProxy;
import ch.unibas.medizin.logbook.client.widget.CustomPager;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public interface ProgressView extends IsWidget {
	/**
	 * Implemented by the owner of the view.
	 */
	interface Delegate {

		void findProgressOfMainClassification(MainClassificationProxy mainClassificationProxy, int row, int i, StudentProxy studentProxy);

		void findProgressOfClassificationTopic(ClassificationTopicProxy classificationTopicProxy, int row, int i, StudentProxy studentProxy);

		void refreshProgresstable(FlexTable table, int start, int length);

	}

	interface presenter {

		void goTo(Place place);

	}

	void setPresenter(presenter presenter);

	void setDelegate(Delegate loginActivity);

	FlexTable getProgressFlexTable();

	void setProgressFlexTable(FlexTable progressFlexTable);

	void createHeader(FlexTable progressFlexTable);

	void setSource(List<TopicProxy> topicProxyList, List<Long> totalSkillList, List<Long> totalAcquiredSkillList, StudentProxy studentProxy);

	public Widget createProgressBar(int maxProgress, int progress);

	StudentProxy getStudent();

	void setStudent(StudentProxy student);

	CustomPager getPager();

}
