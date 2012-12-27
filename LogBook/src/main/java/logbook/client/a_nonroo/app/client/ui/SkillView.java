package logbook.client.a_nonroo.app.client.ui;



import java.util.List;

import logbook.client.managed.proxy.ClassificationTopicProxy;
import logbook.client.managed.proxy.MainClassificationProxy;
import logbook.client.managed.proxy.SkillProxy;
import logbook.client.managed.proxy.TopicProxy;
import logbook.client.style.widgetsnewcustomsuggestbox.test.client.ui.widget.suggest.EventHandlingValueHolderItem;
import logbook.client.style.widgetsnewcustomsuggestbox.test.client.ui.widget.suggest.impl.DefaultSuggestBox;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TextBox;

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
	
	public void setSource(List<SkillProxy> data);

}
