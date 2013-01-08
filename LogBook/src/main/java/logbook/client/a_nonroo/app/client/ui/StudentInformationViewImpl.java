package  logbook.client.a_nonroo.app.client.ui;

 
import java.util.HashSet;
import java.util.Set;

import logbook.client.a_nonroo.app.client.MyCellTableResources;
import logbook.client.a_nonroo.app.client.ui.custom.widget.CustomProgressbar;
import logbook.client.managed.proxy.SkillAcquiredProxy;
import logbook.client.managed.proxy.StudentProxy;
import logbook.client.style.Resources.MySimplePagerResources;
import logbook.shared.SkillLevels;
import logbook.shared.i18n.LogBookConstants;
import logbook.shared.scaffold.LogBookConstant;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;


public class StudentInformationViewImpl extends Composite implements StudentInformationView{
	
	private static StudentInformationViewImpllUiBinder uiBinder = GWT
			.create(StudentInformationViewImpllUiBinder.class);

	interface StudentInformationViewImpllUiBinder extends UiBinder<Widget, StudentInformationViewImpl> {
	}

	private Delegate delegate;
	
	private presenter presenter;
	
	StudentProxy studentProxy;


	/**
	 * 
	 */
	@UiField
	Label lblPersonnelInformation;
	
	@UiField
	Label lblName;
	
	@UiField
	Label lblNameVal;
	
	@UiField
	Label lblStudentId;
	
	@UiField
	Label lblStudentIdVal;
	
	@UiField
	Label lblStudyYear;
	
	@UiField
	Label lblStudeyYearvalue;
	
	@UiField
	Label lblEmail;
	
	@UiField
	Label lblEmailVal;
	
	@UiField
	Label lblCurrentProgress;
	
	@UiField
	Label lblTotalProgress;
	
	@UiField
	Label lblLevel1Progress;
	
	@UiField
	Label lblLevel2Progress;
	
	@UiField
	Button btnFinalizeLogBook;
	
	@UiField
	Anchor btnChange;
	
	@UiField
	Label lblLatestAcquiredSkill;
	
	@UiField
	CustomProgressbar prgBarLevel1;
	
	@UiField
	CustomProgressbar prgBarLevel2;
	
	@UiField
	CustomProgressbar prgBarTotal;
	
	@UiField(provided=true)
	CellTable<SkillAcquiredProxy> table;
	
	@UiField(provided = true)
	public SimplePager pager;
	
	@UiField
	Label lblError;

	@UiHandler("btnFinalizeLogBook")
	public void btnFinalizeLogBookClicked(ClickEvent event)
	{
		Log.info("Finalize Student Clicked.");
		delegate.finalizeLogBookClick(studentProxy);
	}
	
	@UiHandler("btnChange")
	public void btnChangeClicked(ClickEvent event)
	{
		delegate.changeStudentInformationClicked(event);
	}
	
	
	protected Set<String> paths = new HashSet<String>();
	
	LogBookConstants constants = GWT.create(LogBookConstants.class);
	
	@Override
	public Label getLblPersonnelInformation() {
		return lblPersonnelInformation;
	}
	
	@Override
	public void setLblPersonnelInformation(Label lblPersonnelInformation) {
		this.lblPersonnelInformation = lblPersonnelInformation;
	}

	@Override
	public Label getLblName() {
		return lblName;
	}

	@Override
	public void setLblName(Label lblName) {
		this.lblName = lblName;
	}

	@Override
	public Label getLblNameVal() {
		return lblNameVal;
	}

	@Override
	public void setLblNameVal(Label lblNameVal) {
		this.lblNameVal = lblNameVal;
	}
	
	@Override
	public Label getLblStudentId() {
		return lblStudentId;
	}

	@Override
	public void setLblStudentId(Label lblStudentId) {
		this.lblStudentId = lblStudentId;
	}
	
	@Override
	public Label getLblStudentIdVal() {
		return lblStudentIdVal;
	}

	@Override
	public void setLblStudentIdVal(Label lblStudentIdVal) {
		this.lblStudentIdVal = lblStudentIdVal;
	}

	@Override
	public Label getLblStudyYear() {
		return lblStudyYear;
	}

	@Override
	public void setLblStudyYear(Label lblStudyYear) {
		this.lblStudyYear = lblStudyYear;
	}

	@Override
	public Label getLblStudeyYearvalue() {
		return lblStudeyYearvalue;
	}

	@Override
	public void setLblStudeyYearvalue(Label lblStudeyYearvalue) {
		this.lblStudeyYearvalue = lblStudeyYearvalue;
	}

	@Override
	public Label getLblEmail() {
		return lblEmail;
	}

	@Override
	public void setLblEmail(Label lblEmail) {
		this.lblEmail = lblEmail;
	}

	@Override
	public Label getLblEmailVal() {
		return lblEmailVal;
	}

	@Override
	public void setLblEmailVal(Label lblEmailVal) {
		this.lblEmailVal = lblEmailVal;
	}

	@Override
	public Label getLblCurrentProgress() {
		return lblCurrentProgress;
	}

	@Override
	public void setLblCurrentProgress(Label lblCurrentProgress) {
		this.lblCurrentProgress = lblCurrentProgress;
	}

	@Override
	public Label getLblTotalProgress() {
		return lblTotalProgress;
	}

	@Override
	public void setLblTotalProgress(Label lblTotalProgress) {
		this.lblTotalProgress = lblTotalProgress;
	}

	@Override
	public Button getBtnFinalizeLogBook() {
		return btnFinalizeLogBook;
	}

	@Override
	public void setBtnFinalizeLogBook(Button btnFinalizeLogBook) {
		this.btnFinalizeLogBook = btnFinalizeLogBook;
	}

	@Override
	public Anchor  getBtnChange() {
		return btnChange;
	}

	@Override
	public void setBtnChange(Anchor btnChange) {
		this.btnChange = btnChange;
	}

	@Override
	public Label getLblLatestAcquiredSkill() {
		return lblLatestAcquiredSkill;
	}

	@Override
	public void setLblLatestAcquiredSkill(Label lblLatestAcquiredSkill) {
		this.lblLatestAcquiredSkill = lblLatestAcquiredSkill;
	}
	
	@Override
	public Label getLblLevel1Progress() {
		return lblLevel1Progress;
	}

	@Override
	public void setLblLevel1Progress(Label lblLevel1Progress) {
		this.lblLevel1Progress = lblLevel1Progress;
	}

	@Override
	public Label getLblLevel2Progress() {
		return lblLevel2Progress;
	}

	@Override
	public void setLblLevel2Progress(Label lblLevel2Progress) {
		this.lblLevel2Progress = lblLevel2Progress;
	}
	
	@Override
	public void setTable(CellTable<SkillAcquiredProxy> table) {
		this.table = table;
	}
	
	@Override
	public StudentProxy getStudentProxy() {
		return studentProxy;
	}

	@Override
	public void setStudentProxy(StudentProxy studentProxy) {
		this.studentProxy = studentProxy;
	}
	
	@Override
	public CustomProgressbar getPrgBarLevel1() {
		return prgBarLevel1;
	}

	@Override
	public void setPrgBarLevel1(CustomProgressbar prgBarLevel1) {
		this.prgBarLevel1 = prgBarLevel1;
	}

	@Override
	public CustomProgressbar getPrgBarLevel2() {
		return prgBarLevel2;
	}

	@Override
	public void setPrgBarLevel2(CustomProgressbar prgBarLevel2) {
		this.prgBarLevel2 = prgBarLevel2;
	}

	@Override
	public CustomProgressbar getPrgBarTotal() {
		return prgBarTotal;
	}

	public void setPrgBarTotal(CustomProgressbar prgBarTotal) {
		this.prgBarTotal = prgBarTotal;
	}
	public Label getLblError() {
		return lblError;
	}

	public void setLblError(Label lblError) {
		this.lblError = lblError;
	}


	
	public StudentInformationViewImpl() {
	
		CellTable.Resources tableResources = GWT.create(MyCellTableResources.class);
		SimplePager.Resources pagerResources = GWT.create(MySimplePagerResources.class);
		table = new CellTable<SkillAcquiredProxy>(LogBookConstant.TABLE_PAGE_SIZE, tableResources);
		pager = new SimplePager(SimplePager.TextLocation.RIGHT, pagerResources, true, LogBookConstant.TABLE_JUMP_SIZE, true);
		
		 final NodeList<com.google.gwt.dom.client.Element> tdElems = pager.getElement().getElementsByTagName("td");
			for (int i = 0; i < tdElems.getLength(); i++) {

	  final String toolTipText;

	  if (i == 0)
	    toolTipText = constants.first();
	  else if (i == 1)
	    toolTipText = constants.previous();
	  else if (i == 2)
		  toolTipText = constants.next();
	  else if (i == 3)
		  toolTipText = constants.fastForward();
	  else if (i == 4)
	    toolTipText = constants.last();
	  else
	    continue;

	  tdElems.getItem(i).setTitle(toolTipText);
	}

		
		initWidget(uiBinder.createAndBindUi(this));
		
		init();	// Initialize Personnel and Current Progress Data
		initTable(); // Initialize Table View

	}

	private void init() 
	{
		lblPersonnelInformation.setText(constants.personnelInformation());
		lblName.setText(constants.name()+": ");
		lblStudentId.setText(constants.studentId()+":");
		lblStudyYear.setText(constants.studyYear()+": ");
		lblEmail.setText(constants.email()+": ");
		lblCurrentProgress.setText(constants.currentProgress());
		
		btnChange.setText(constants.change());
		btnFinalizeLogBook.setText(constants.finalizeLogBook());
		
		intiProgressBar(prgBarLevel1);
		intiProgressBar(prgBarLevel2);
		intiProgressBar(prgBarTotal);
		
		lblError.setVisible(false);
			
	}
	
	private void intiProgressBar(CustomProgressbar progressBar) 
	{
		progressBar.setHeight("13px");
		progressBar.setWidth("180px");
		progressBar.setMinProgress(0);
		progressBar.setMaxProgress(100);
		progressBar.setProgress(0);	
	}

	private void initTable() 
	{
		 	paths.add("description");
	        table.addColumn(new TextColumn<SkillAcquiredProxy>() {

	            Renderer<java.lang.String> renderer = new AbstractRenderer<java.lang.String>() {

	                public String render(java.lang.String obj) {
	                    return obj == null ? "" : String.valueOf(obj);
	                }
	            };

	            @Override
	            public String getValue(SkillAcquiredProxy object) {
	                if(object.getSkill()!=null && object.getSkill().getDescription()!=null)
	                	return renderer.render(object.getSkill().getDescription());
	                else
	                	return renderer.render("");
	            }
	        }, "Name");
	        paths.add("skillLevel");
	        table.addColumn(new TextColumn<SkillAcquiredProxy>() {

	            Renderer<java.lang.String> renderer = new AbstractRenderer<java.lang.String>() {

	                public String render(java.lang.String obj) {
	                    return obj == null ? "" : String.valueOf(obj);
	                }
	            };

	            @Override
	            public String getValue(SkillAcquiredProxy object) {
	            	String category="";
	            	
	            	if(object.getSkill()!=null && object.getSkill().getTopic()!=null && object.getSkill().getTopic().getClassificationTopic()!=null && object.getSkill().getTopic().getClassificationTopic().getMainClassification()!=null && object.getSkill().getTopic().getClassificationTopic().getMainClassification().getDescription()!=null)
	            	{
	            		category=" " + object.getSkill().getTopic().getClassificationTopic().getMainClassification().getDescription();
	            		if(object.getSkill().getTopic().getClassificationTopic().getMainClassification().getShortcut()!=null)
	            		{
	            			category+=" (" +object.getSkill().getTopic().getClassificationTopic().getMainClassification().getShortcut()+ ") ";
	            		}
	            	}
	            	if(object.getSkill()!=null && object.getSkill().getTopic()!=null && object.getSkill().getTopic().getTopicDescription()!=null)
	            	{
	            		category+=" - "+object.getSkill().getTopic().getTopicDescription() + " ";
	            	}
	            	if(object.getSkillLevel()!=null && object.getSkillLevel().getLevelNumber()!=null)
	            	{
	            		  //return renderer.render(object.getSkill().getTopic().getClassificationTopic().getMainClassification().getDescription());
	            		  category+=constants.level()+" "+ object.getSkillLevel().getLevelNumber() + " - " + SkillLevels.getSkillLevels(SkillLevels.values()[object.getSkillLevel().getLevelNumber()-1]);
	            	}
	            	return renderer.render(category);	            	 	            	
	            }
	        }, "Category");
	        paths.add("shortcut");
	        table.addColumn(new TextColumn<SkillAcquiredProxy>() {
	        	/*{
	        		this.setSortable(true);
	        	}*/
	            Renderer<java.lang.String> renderer = new AbstractRenderer<java.lang.String>() {

	                public String render(java.lang.String obj) {
	                    return obj == null ? "" : String.valueOf(obj);
	                }
	            };

	            @Override
	            public String getValue(SkillAcquiredProxy object) {
	            	 if(object.getSkill()!=null && object.getSkill().getShortcut()!=null)
	            		 return renderer.render("S "+object.getSkill().getShortcut());
	            	 else
	            		 return renderer.render("");
	            }
	        }, "Shortcut");
	}
	
	@Override
	public CellTable<SkillAcquiredProxy> getTable() 
	{
		return table;
	}		

	public String[] getPaths() {
		
		 return paths.toArray(new String[paths.size()]);
	}

	@Override
	public void setPresenter(presenter presenter) {
		this.presenter=presenter;
		
	}

	@Override
	public void setDelegate(Delegate delegate) {
		this.delegate=delegate;
		
	}

}
