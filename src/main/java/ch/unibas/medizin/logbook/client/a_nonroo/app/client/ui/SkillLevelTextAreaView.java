package ch.unibas.medizin.logbook.client.a_nonroo.app.client.ui;



import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface SkillLevelTextAreaView extends IsWidget{
	 /* * Implemented by the owner of the view.
	 */
	interface Delegate {

		//void chekBoxSelected(SkillProxy skillProxy, boolean isLevel1,SkillLevelCheckboxViewImpl skillLevelCheckboxViewImpl);
		
	}
	
	interface presenter {
		
		void goTo(Place place);
		
	}

	void setPresenter(presenter presenter);

	void setDelegate(Delegate loginActivity);
	
	
	
	/*public int getClassificationTopicRow();

	public void setClassificationTopicRow(int classificationTopicRow);

	public int getTopicRow();

	public void setTopicRow(int topicRow);

	public int getMainClassificationRow();

	public void setMainClassificationRow(int mainClassificationRow);
*/
}
