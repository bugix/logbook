package logbook.client.a_nonroo.app.client.ui;



import java.util.List;

import logbook.client.a_nonroo.app.client.SkillFilteredResultProxy;
import logbook.client.a_nonroo.app.client.activity.SkillActivity;
import logbook.client.a_nonroo.app.client.ui.custom.widget.CustomPager;
import logbook.client.managed.proxy.ClassificationTopicProxy;
import logbook.client.managed.proxy.MainClassificationProxy;
import logbook.client.managed.proxy.SkillProxy;
import logbook.client.managed.proxy.StudentProxy;
import logbook.client.managed.proxy.TopicProxy;
import logbook.client.style.widgetsnewcustomsuggestbox.test.client.ui.widget.suggest.EventHandlingValueHolderItem;
import logbook.client.style.widgetsnewcustomsuggestbox.test.client.ui.widget.suggest.impl.DefaultSuggestBox;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public interface SkillView extends IsWidget{
	 /* * Implemented by the owner of the view.
	 */
	interface Delegate {

		void mainClassificationSuggestboxChanged(Long id);

		void classificationTopicSuggestboxChanged(Long id);

		void topicSuggestboxChanged(Long id);

		void resetButtonClicked();

		void showButtonClicked();

		void generatePdfClicked();

		void printPdfClicked();
		
		void refreshFlextable(FlexTable table,int start,int length);

	void findProgressOfMainClassification(MainClassificationProxy mProxy,
				int row, int i, StudentProxy student);

		void findProgressOfClassificationTopic(ClassificationTopicProxy cProxy,
				int row, int i, StudentProxy student);

		void findProgressOfTopic(TopicProxy tproxy, int row, int i,
				StudentProxy student);

		void shortCutClicked();
		
		void exportPDF();
		//Boolean isSkillAcquiredbyStudentAtFirstLevel(Long studentID,Long skillId,Long skillLevelID);
		
		
	}
	
	interface presenter {
		
		void goTo(Place place);
		
	}

	void setPresenter(presenter presenter);

	void setDelegate(Delegate loginActivity);
	
	public FlexTable getSkillFlexTable();
	
	public void setSkillFlexTable(FlexTable skillFlexTable);

	DefaultSuggestBox<MainClassificationProxy, EventHandlingValueHolderItem<MainClassificationProxy>> getMainClassificationSuggestBox();

	void setMainClassificationSuggestBox(
			DefaultSuggestBox<MainClassificationProxy, EventHandlingValueHolderItem<MainClassificationProxy>> mainClassificationSuggestBox);

	void setClassificationTopicSuggestBox(
			DefaultSuggestBox<ClassificationTopicProxy, EventHandlingValueHolderItem<ClassificationTopicProxy>> classificationTopicSuggestBox);

	DefaultSuggestBox<TopicProxy, EventHandlingValueHolderItem<TopicProxy>> getTopicSuggestBox();

	void setTopicSuggestBox(
			DefaultSuggestBox<TopicProxy, EventHandlingValueHolderItem<TopicProxy>> topicSuggestBox);

	DefaultSuggestBox<ClassificationTopicProxy, EventHandlingValueHolderItem<ClassificationTopicProxy>> getClassificationTopicSuggestBox();

	TextBox getFullTextSearchBox();

	void setFullTextSearchBox(String value);
	
	public void createHeader(FlexTable flexTable);
	
	public void setSource(SkillFilteredResultProxy data);
	
	public void setDefaultMessageOfSuggestionbox();

	StudentProxy getStudent();

	void setStudent(StudentProxy student);
	
	public SkillActivity getSkillActivity();

	public void setSkillActivity(SkillActivity skillActivity);
	
	public Widget createProgressBar(int maxProgress,int progress);
	
	public CustomPager getPager();

	public int getIsAsc();
	
	public void setIsAsc(int isAsc);
	public HorizontalPanel getSortcutHP();
	
	public void setSortcutHP(HorizontalPanel sortcutHP);
	
	public DivElement getLblErrorMessage();
	
	public HTMLPanel getHpErrorMessage();
	/*public FocusPanel getShortCut();
	
	public void setShortCut(FocusPanel shortCut);*/
}
