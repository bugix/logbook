package ch.unibas.medizin.logbook.client.ui;



import ch.unibas.medizin.logbook.client.activity.SkillActivity;
import ch.unibas.medizin.logbook.client.proxy.ClassificationTopicProxy;
import ch.unibas.medizin.logbook.client.proxy.MainClassificationProxy;
import ch.unibas.medizin.logbook.client.proxy.SkillFilteredResultProxy;
import ch.unibas.medizin.logbook.client.proxy.SkillProxy;
import ch.unibas.medizin.logbook.client.proxy.StudentProxy;
import ch.unibas.medizin.logbook.client.proxy.TopicProxy;
import ch.unibas.medizin.logbook.client.suggest.DefaultSuggestBox;
import ch.unibas.medizin.logbook.client.suggest.EventHandlingValueHolderItem;
import ch.unibas.medizin.logbook.client.widget.CustomPager;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
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

		void iconButtonClicked(SkillProxy skillProxy, SkillLevelIconButtonViewImpl editButton);

		
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
