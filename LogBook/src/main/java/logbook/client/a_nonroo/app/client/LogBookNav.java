package logbook.client.a_nonroo.app.client;




import logbook.client.a_nonroo.app.LogBookShell;
import logbook.client.a_nonroo.app.activities.LogBookActivityMapper;
import logbook.client.a_nonroo.app.client.place.LoginPlace;
import logbook.client.a_nonroo.app.client.place.ProgressPlace;
import logbook.client.a_nonroo.app.client.place.SkillPlace;
import logbook.client.a_nonroo.app.request.LogBookRequestFactory;
import logbook.shared.i18n.LogBookConstants;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.activity.shared.CachingActivityMapper;
import com.google.gwt.activity.shared.FilteredActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
/**
 * The applications main navigation element, shown on the left hand side of the user interface.
 * @author milan
 *
 */
public class LogBookNav extends Composite {

	LogBookConstants constants = GWT.create(LogBookConstants.class);
	
	private static LogBookNavUiBinder uiBinder = GWT
			.create(LogBookNavUiBinder.class);

	interface LogBookNavUiBinder extends UiBinder<Widget, LogBookNav> {
	}
	
	public LogBookNav() {
		initWidget(uiBinder.createAndBindUi(this));
		
	}
	
	public ActivityManager masterActivityManager=null;
	
	private LogBookRequestFactory requests;
	private PlaceController placeController;
	private LogBookShell shell;
	
	public static LogBookNav logBookNav;
	
	@UiField
	TabLayoutPanel mainLoogBookTabpanel;
	
	public TabLayoutPanel getMainLoogBookTabpanel() {
		return mainLoogBookTabpanel;
	}

	@UiField
	Label login;
	
	@UiField
	Label skill;
	
	@UiField
	Label progress;
	
	@UiField
	Label logout;

	
	@Inject
	public LogBookNav(LogBookRequestFactory requests, PlaceController placeController,final PlaceHistoryHandler placeHistoryHandler,LogBookActivityMapper mcAppActivitiesMapper,EventBus eventBus) {
        
		initWidget(uiBinder.createAndBindUi(this));
		this.requests = requests;
        this.placeController = placeController;
      
        login.setText(constants.login());
		skill.setText(constants.skill());
		progress.setText(constants.progress());
		logout.setText(constants.logout());
		
		logBookNav=this;
		
		SkillPlace.nav=logBookNav;
		
		

		
		CachingActivityMapper cached = new CachingActivityMapper(mcAppActivitiesMapper);
		FilterForMainPlaces filterForMainPlaces = new FilterForMainPlaces();
		ActivityMapper masterActivityMap = new FilteredActivityMapper(filterForMainPlaces, cached);
		 masterActivityManager = new ActivityManager(masterActivityMap, eventBus);
		 masterActivityManager.setDisplay((SimplePanel)mainLoogBookTabpanel.getWidget(mainLoogBookTabpanel.getSelectedIndex()));
		
		
		 //Fix in default style( without it tab content will not show properly)
		 mainLoogBookTabpanel.getElement().getChild(2).getChild(0).getParentElement().getStyle().setPosition(Position.RELATIVE);
		 Element element=mainLoogBookTabpanel.getElement().getChild(2).getChild(0).getParentElement();	
		 element.getChild(0).getChild(2).getChild(0).getParentElement().getStyle().setPosition(Position.RELATIVE);	 
		 Log.info("HTML :"+element.getChild(0).getChild(2).getChild(0).getParentElement());
		 
		
		 //Log.info("HTML :"+mainLoogBookTabpanel.getElement().getChild(2).getChild(1).getParentElement());
		// Log.info("HTML :" +mainLoogBookTabpanel.getElement().getChild(1).getChild(1).getParentElement().getChild(0).getChild(0).getChild(0).getParentElement());
		  
		 /* if(mainLoogBookTabpanel.getSelectedIndex() == 0)
		 {
			 logBookNav.placeController.goTo(new LoginPlace("LoginPlace"));
		 }*/
	//	 masterActivityManager.setDisplay((SimplePanel)mainLoogBookTabpanel.getWidget(mainLoogBookTabpanel.getSelectedIndex()));
		 
		 
		/* mainLoogBookTabpanel.addSelectionHandler(new SelectionHandler<Integer>() {
			
			@Override
			public void onSelection(SelectionEvent<Integer> event) {
				 masterActivityManager.setDisplay((SimplePanel)mainLoogBookTabpanel.getWidget(event.getSelectedItem()));
				 if(event.getSelectedItem() == 0)
				 {
					 logBookNav.placeController.goTo(new LoginPlace("LoginPlace"));
				 }
				 else if(event.getSelectedItem() ==1)
				 {
					 logBookNav.placeController.goTo(new SkillPlace());
				 }
				 else if(event.getSelectedItem() ==2)
				 {
					 logBookNav.placeController.goTo(new ProgressPlace());
				 }
				
			}
		});*/
		 
		
		 //placeHistoryHandler.handleCurrentHistory();
		 
    }
	
	
	private int both = 0;
	
	private void displayMenue(){

	}
	
	protected void changeMenue(Place place){
		
	}
		
	@UiHandler("login")
	public void loginClicked(ClickEvent event){
		/*masterActivityManager.setDisplay((SimplePanel)mainLoogBookTabpanel.getWidget(mainLoogBookTabpanel.getSelectedIndex()));
		placeController.goTo(new LoginPlace("LoginPlace"));*/
	}
	@UiHandler("skill")
	public void skillClicked(ClickEvent event){
		/*masterActivityManager.setDisplay((SimplePanel)mainLoogBookTabpanel.getWidget(mainLoogBookTabpanel.getSelectedIndex()));
		placeController.goTo(new SkillPlace());*/
		
	}
	@UiHandler("progress")
	public void progressClicked(ClickEvent event){
	/*	masterActivityManager.setDisplay((SimplePanel)mainLoogBookTabpanel.getWidget(mainLoogBookTabpanel.getSelectedIndex()));
	placeController.goTo(new ProgressPlace());	*/
	}
	
	@UiHandler("mainLoogBookTabpanel")
	public void tabSelectionChanged(SelectionEvent<Integer> event)
	{
		 masterActivityManager.setDisplay((SimplePanel)mainLoogBookTabpanel.getWidget(event.getSelectedItem()));
		 if(event.getSelectedItem() == 0)
		 {
			 logBookNav.placeController.goTo(new LoginPlace("LoginPlace"));
		 }
		 else if(event.getSelectedItem() ==1)
		 {
			/* if(SkillPlace.tabIndex==0)
			 {
				 mainLoogBookTabpanel.selectTab(1);
			 }
			 
			 SkillPlace.tabIndex=1;*/
			 logBookNav.placeController.goTo(new SkillPlace());
		 }
		 else if(event.getSelectedItem() ==2)
		 {
			 logBookNav.placeController.goTo(new ProgressPlace());
		 }
		
	}
	

	//	@UiHandler("logout")
//	public void logoutClicked(ClickEvent event){
//		Window.alert("Jay");
//	}
	

}
