package logbook.client.a_nonroo.app.client.ui;



import logbook.client.a_nonroo.app.client.ui.custom.widget.CustomProgressbar;
import logbook.client.managed.proxy.SkillAcquiredProxy;
import logbook.client.managed.proxy.SkillProxy;
import logbook.client.managed.proxy.StudentProxy;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;

public interface StudentInformationView extends IsWidget{
	 /* * Implemented by the owner of the view.
	 */
	interface Delegate {
		public void changeStudentInformationClicked(ClickEvent event);

		public void finalizeLogBookClick(StudentProxy studentProxy);
	}
	
	interface presenter {
		
		void goTo(Place place);
		
	}

	void setPresenter(presenter presenter);

	void setDelegate(Delegate loginActivity);
	
	public Label getLblPersonnelInformation();
	public void setLblPersonnelInformation(Label lblPersonnelInformation);
	public Label getLblName();
	public void setLblName(Label lblName); 
	public Label getLblNameVal() ;
	public void setLblNameVal(Label lblNameVal) ;
	public Label getLblStudentId() ;
	public void setLblStudentId(Label blStudentId) ;
	public Label getLblStudentIdVal(); 
	public void setLblStudentIdVal(Label lblStudentIdVal) ;
	public Label getLblStudyYear();
	public void setLblStudyYear(Label lblStudyYear) ;
	public Label getLblStudeyYearvalue() ;
	public void setLblStudeyYearvalue(Label lblStudeyYearvalue) ;
	public Label getLblEmail() ;
	public void setLblEmail(Label lblEmail) ;
	public Label getLblEmailVal();
	public void setLblEmailVal(Label lblEmailVal) ;
	public Label getLblCurrentProgress() ;
	public void setLblCurrentProgress(Label lblCurrentProgress) ;
	public Label getLblTotalProgress() ;
	public void setLblTotalProgress(Label lblTotalProgress) ;	
	public Button getBtnFinalizeLogBook() ;
	public void setBtnFinalizeLogBook(Button btnFinalizeLogBook) ;
	public Anchor getBtnChange() ;
	public void setBtnChange(Anchor btnChange) ;
	public Label getLblLatestAcquiredSkill() ;
	public void setLblLatestAcquiredSkill(Label lblLaestAcquiredSkill) ;
	public void setTable(CellTable<SkillAcquiredProxy> table) ;
	public Label getLblLevel1Progress();
	public void setLblLevel1Progress(Label lblLevel1Progress);
	public Label getLblLevel2Progress();
	public void setLblLevel2Progress(Label lblLevel1Progress);
	public DivElement getLblErrorMessage();
	public HTMLPanel getHpErrorMessage();
	StudentProxy getStudentProxy();

	void setStudentProxy(StudentProxy studentProxy);

	CellTable<SkillAcquiredProxy> getTable();

	CustomProgressbar getPrgBarLevel1();

	void setPrgBarLevel1(CustomProgressbar prgBarLevel1);

	CustomProgressbar getPrgBarLevel2();

	void setPrgBarLevel2(CustomProgressbar prgBarLevel2);

	CustomProgressbar getPrgBarTotal();

	FocusPanel getStudentFocusPanel();

	void setStudentFocusPanel(FocusPanel studentFocusPanel);
	
	

}
