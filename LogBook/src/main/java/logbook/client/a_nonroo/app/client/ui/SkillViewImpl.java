package logbook.client.a_nonroo.app.client.ui;

import java.util.ArrayList;
import java.util.List;

import logbook.client.a_nonroo.app.client.SkillFilteredResultProxy;
import logbook.client.a_nonroo.app.client.activity.SkillActivity;
import logbook.client.a_nonroo.app.client.ui.custom.widget.CustomPager;
import logbook.client.a_nonroo.app.client.ui.custom.widget.CustomPager.RangeChangeListener;
import logbook.client.a_nonroo.app.client.ui.custom.widget.CustomProgressbar;
import logbook.client.managed.proxy.ClassificationTopicProxy;
import logbook.client.managed.proxy.MainClassificationProxy;
import logbook.client.managed.proxy.SkillProxy;
import logbook.client.managed.proxy.StudentProxy;
import logbook.client.managed.proxy.TopicProxy;
import logbook.client.style.widgetsnewcustomsuggestbox.test.client.ui.widget.suggest.EventHandlingValueHolderItem;
import logbook.client.style.widgetsnewcustomsuggestbox.test.client.ui.widget.suggest.impl.DefaultSuggestBox;
import logbook.shared.SkillLevels;
import logbook.shared.i18n.LogBookConstants;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.MouseWheelEvent;
import com.google.gwt.event.dom.client.MouseWheelHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class SkillViewImpl extends Composite implements SkillView {

	private static SkillViewImpllUiBinder uiBinder = GWT
			.create(SkillViewImpllUiBinder.class);

	interface SkillViewImpllUiBinder extends UiBinder<Widget, SkillViewImpl> {
	}

	private Delegate delegate;

	private presenter presenter;

	private SkillViewImpl skillview;
	
	SkillActivity skillActivity;
	
	public SkillActivity getSkillActivity() {
		return skillActivity;
	}

	public void setSkillActivity(SkillActivity skillActivity) {
		this.skillActivity = skillActivity;
	}
	LogBookConstants constants = GWT.create(LogBookConstants.class);

	@UiField(provided = true)
	FlexTable skillFlexTable;

	@UiField
	Label mainClassificationLabel;

	@UiField
	Label classificationTopic;

	@UiField
	Label topic;
	
	@UiField
	Label fullTextSearch;
	
	@UiField
	FocusPanel focusPanel;
	
	private List<String> levelList = new ArrayList<String>();
	
	private StudentProxy student;
	
	private Image downArrow;
	
	private HorizontalPanel sortcutHP;
	
	private Label sortcutLabel;
	
	public Image getDownArrow() {
		return downArrow;
	}

	public void setDownArrow(Image downArrow) {
		this.downArrow = downArrow;
	}

	public Image getUpArrow() {
		return upArrow;
	}

	public void setUpArrow(Image upArrow) {
		this.upArrow = upArrow;
	}
	private Image upArrow;
	
	private int isAsc;
	
	public int getIsAsc() {
		return isAsc;
	}

	public void setIsAsc(int isAsc) {
		this.isAsc = isAsc;
	}

	@Override
	public StudentProxy getStudent() {
		return student;
	}

	@Override
	public void setStudent(StudentProxy student) {
		this.student = student;
	}
	@UiField
	DefaultSuggestBox<MainClassificationProxy, EventHandlingValueHolderItem<MainClassificationProxy>> mainClassificationSuggestBox;
	
	 @UiField
	public DefaultSuggestBox<ClassificationTopicProxy, EventHandlingValueHolderItem<ClassificationTopicProxy>> classificationTopicSuggestBox;

	 @UiField
	 public DefaultSuggestBox<TopicProxy, EventHandlingValueHolderItem<TopicProxy>> topicSuggestBox;
	 
	 public static DefaultSuggestBox<MainClassificationProxy, EventHandlingValueHolderItem<MainClassificationProxy>> mainClassificationSuggestBoxPopup;
	 public static DefaultSuggestBox<ClassificationTopicProxy, EventHandlingValueHolderItem<ClassificationTopicProxy>> classificationTopicSuggestBoxPopup;
	 public static DefaultSuggestBox<TopicProxy, EventHandlingValueHolderItem<TopicProxy>> topicSuggestBoxPoopup;
	 
	/* @UiField
	 public DefaultSuggestBox<String, EventHandlingValueHolderItem<String>> levelSuggestBox;*/
	 
	 @UiField
	 public  TextBox fullTextSearchBox;
	 
	 @UiField
	 CustomPager pager;
	 
	public CustomPager getPager() {
		return pager;
	}

	public Label getmainClassificationLabel() {
		return mainClassificationLabel;
	}

	
	@Override
	public TextBox getFullTextSearchBox() {
		return fullTextSearchBox;
	}
	
	@Override
	public void setFullTextSearchBox(String value) {
		this.fullTextSearchBox.setValue(value);
	}

	public void setmainClassificationLabel(Label mainClassificationLabel) {
		this.mainClassificationLabel = mainClassificationLabel;
	}

	public Label getclassificationTopic() {
		return classificationTopic;
	}

	public void setclassificationTopic(Label classificationTopic) {
		this.classificationTopic = classificationTopic;
	}

	public Label gettopic() {
		return topic;
	}

	public void setLblShow(Label topic) {
		this.topic = topic;
	}

	public Button getBtnShow() {
		return btnShow;
	}

	public void setBtnShow(Button btnShow) {
		this.btnShow = btnShow;
	}

	public Button getBtnReset() {
		return btnReset;
	}

	public void setBtnReset(Button btnReset) {
		this.btnReset = btnReset;
	}

	public Image getImgPrint() {
		return imgPrint;
	}

	public void setImgPrint(Image imgPrint) {
		this.imgPrint = imgPrint;
	}

	public Anchor getHyperLnkPrint() {
		return hyperLnkPrint;
	}

	public void setHyperLnkPrint(Anchor hyperLnkPrint) {
		this.hyperLnkPrint = hyperLnkPrint;
	}

	public Image getImgpdf() {
		return imgpdf;
	}

	public void setImgpdf(Image imgpdf) {
		this.imgpdf = imgpdf;
	}

	public Anchor getHyperlnkSavePDF() {
		return hyperlnkSavePDF;
	}

	public void setHyperlnkSavePDF(Anchor hyperlnkSavePDF) {
		this.hyperlnkSavePDF = hyperlnkSavePDF;
	}

	@Override
	public FlexTable getSkillFlexTable() {
		return skillFlexTable;
	}

	@Override
	public void setSkillFlexTable(FlexTable skillFlexTable) {
		this.skillFlexTable = skillFlexTable;
	}
	@UiField
	Button btnShow;

	@UiHandler("btnReset")
	public void resetButtonClicked(ClickEvent event){
		delegate.resetButtonClicked();
	}
	@UiHandler("btnShow")
	public void showButtonClicked(ClickEvent event){
		delegate.showButtonClicked();
	}
	@UiField
	Button btnReset;

	@UiField
	Image imgPrint;

	/*@UiField
	Label levelLabel;*/
	
	@UiField
	Anchor hyperLnkPrint;

	@UiField
	Image imgpdf;

	@UiField
	Anchor hyperlnkSavePDF;
	
	@UiField
	DivElement lblErrorMessage;
	
	@UiField
	HTMLPanel hpErrorMessage;

	@UiHandler("hyperlnkSavePDF")
	public void savePdfClicked(ClickEvent event){
		event.preventDefault();
		event.stopPropagation();
	delegate.exportPDF();
	}
	
	@UiHandler("hyperLnkPrint")
	public void printPdfClicked(ClickEvent event){
		delegate.printPdfClicked();
	}
	
	

	public HTMLPanel getHpErrorMessage() {
		return hpErrorMessage;
	}

	public void setHpErrorMessage(HTMLPanel hpErrorMessage) {
		this.hpErrorMessage = hpErrorMessage;
	}

	public DivElement getLblErrorMessage() {
		return lblErrorMessage;
	}

	public void setLblErrorMessage(DivElement lblErrorMessage) {
		this.lblErrorMessage = lblErrorMessage;
	}

	public SkillViewImpl() {

		
		skillFlexTable = new FlexTable();
		skillFlexTable.setCellPadding(1);
		skillFlexTable.setCellSpacing(1);
		skillFlexTable.setWidth("100%");
		isAsc=0;
		
		//shortcut=new SimplePanel();
		
		downArrow =new Image("applicationScaffold/gwt/logbook/images/down.png");//
		upArrow = new Image("applicationScaffold/gwt/logbook/images/up.png");
		 
		sortcutHP = new HorizontalPanel();
		sortcutLabel= new Label(constants.shortcut());
		
		ClickHandler clickevent = new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				//Window.alert("Clicked");
				
				if(isAsc==0){
					isAsc=1;
				}
				else
					isAsc=0;
				
				delegate.shortCutClicked();
			}
		};
		
		sortcutHP.addDomHandler(clickevent, ClickEvent.getType());
		
		createHeader(skillFlexTable);
		
		skillview=this;
		
		 
		 
		initWidget(uiBinder.createAndBindUi(this));
		
		init(); // Initialize Skill Data
		
		pager.setLength(20);
		
		focusPanel.addMouseWheelHandler(new MouseWheelHandler() {
			
			@Override
			public void onMouseWheel(MouseWheelEvent event) {
				mainClassificationSuggestBox.getSuggestWidget().hide();
				classificationTopicSuggestBox.getSuggestWidget().hide();
				topicSuggestBox.getSuggestWidget().hide();
			}
		});
		
		pager.addRangeChangeListener(new RangeChangeListener() {
			
			@Override
			public void onRangeChange() {
				Log.info("pager start :"+pager.getStart());
				Log.info("pager Length :" + pager.getLength());
				delegate.refreshFlextable(skillFlexTable, pager.getStart(), pager.getLength());
			}
		});
		
	

	}
	
	public HorizontalPanel getSortcutHP() {
		return sortcutHP;
	}

	public void setSortcutHP(HorizontalPanel sortcutHP) {
		this.sortcutHP = sortcutHP;
	}

	public void createHeader(FlexTable flexTable)
	{
		flexTable.setText(0, 0, constants.name());
		flexTable.getCellFormatter().addStyleName(0, 0, "flexTable-header");
		flexTable.getFlexCellFormatter().setWidth(0, 0, "70%");
		//HorizontalPanel sortcutHP = new HorizontalPanel();
		
		//Label sortcutLabel= new Label(constants.shortcut());
		sortcutHP.clear();
		sortcutHP.add(sortcutLabel);
		if(isAsc==0){
			sortcutHP.add(downArrow);
		}else{
			sortcutHP.add(upArrow);
		}
		
	//	 downArrow =new Image("public/images/down.png");//
	//	 upArrow = new Image("public/images/up.png");
		
		//flexTable.setText(0, 1, constants.shortcut());

		flexTable.setWidget(0,1,sortcutHP);
		
		flexTable.getCellFormatter().addStyleName(0, 1, "flexTable-header");
		flexTable.setText(0, 2, constants.l1());
		flexTable.getFlexCellFormatter().setWidth(0, 1, "10%");
		flexTable.getCellFormatter().addStyleName(0, 2, "flexTable-header");
		flexTable.setText(0, 3, constants.l2());
		flexTable.getFlexCellFormatter().setWidth(0, 2, "10%");
		flexTable.getCellFormatter().addStyleName(0, 3, "flexTable-header");
		flexTable.getFlexCellFormatter().setWidth(0, 3, "10%");
	}
	
	private void setSkillFlexTableStyles() {
		
		skillFlexTable.getCellFormatter().addStyleName(0, 0, "flexTableColumnHeader ");
		skillFlexTable.getRowFormatter().addStyleName(0, "flexTableHeader");
		
		
		skillFlexTable.getCellFormatter().addStyleName(0, 0, "flexTableFirstColumnHeader");
		skillFlexTable.getCellFormatter().addStyleName(0, 1, "flexTableColumnHeader");
		skillFlexTable.getCellFormatter().addStyleName(0, 2, "flexTableColumnHeader");		
		
		skillFlexTable.getCellFormatter().addStyleName(0, 3, "flexTableColumnHeader");		
		skillFlexTable.getCellFormatter().addStyleName(0, 4, "flexTableLastColumnHeader");
		
	}

	private void setSkillFlexTableHeaders() {
		
		String textHeader[] = { "   ", constants.name(), constants.shortcut(), constants.level1(), constants.level2() };
		
		for (int i = 0; i < textHeader.length; i++) {

			skillFlexTable.setText(0, i, textHeader[i]);
		}

	}

	private void init() {
		mainClassificationSuggestBoxPopup= mainClassificationSuggestBox;
		classificationTopicSuggestBoxPopup=classificationTopicSuggestBox;
		topicSuggestBoxPoopup=topicSuggestBox;
		
		
		mainClassificationLabel.setText(constants.mainClassification() + "    ");
		classificationTopic.setText(constants.classificationTopic() + "   ");
		topic.setText(constants.topic() + "   ");

		btnShow.setText(constants.show());
		btnReset.setText(constants.reset());

		fullTextSearch.setText(constants.fullTextSearch());
		fullTextSearchBox.addKeyPressHandler(new KeyPressHandler() {
			
			@Override
			public void onKeyPress(KeyPressEvent event) {
				boolean value=KeyCodes.KEY_ENTER == event.getNativeEvent().getKeyCode();
				if(value){
					btnShow.click();
				}
				
			}
		});
		
		imgPrint.setAltText(constants.imageNotFound());
		imgPrint.setUrl("applicationScaffold/gwt/logbook/images/print.png");

		imgpdf.setAltText(constants.imageNotFound());
		imgpdf.setUrl("applicationScaffold/gwt/logbook/images/pdf.png");

		hyperLnkPrint.setText(constants.print());
		hyperlnkSavePDF.setText(constants.saveAsPdf());

		hpErrorMessage.setVisible(false);
		//lblError.setText("Error...");
		
		//levelLabel.setText(constants.level());
		
		initSkillSuggesstions();

	}

	private void initSkillSuggesstions() {
		mainClassificationSuggestBox.setWidth(400);
		classificationTopicSuggestBox.setWidth(350);
		topicSuggestBox.setWidth(350);
		fullTextSearchBox.setWidth("350px");
		fullTextSearchBox.addStyleName("fullTextBoxsearchStyle");
		//levelSuggestBox.setWidth(350);
		levelList.add(constants.level1());
		levelList.add(constants.level2());
		

		setDefaultMessageOfSuggestionbox();
		//DefaultSuggestOracle<String> suggestOracle = (DefaultSuggestOracle<String>) levelSuggestBox.getSuggestOracle();
		//suggestOracle.setPossiblilities(levelList);
		/*levelSuggestBox.setSuggestOracle(suggestOracle);
		
		levelSuggestBox.setRenderer(new AbstractRenderer<String>() {

			@Override
			public String render(String value) {
				if (value != null)
					return value;
				else
					return "";
			}
		});*/

		
		 mainClassificationSuggestBox.addHandler(new ChangeHandler() {
				
				
				@Override
				public void onChange(ChangeEvent event) {
					if (mainClassificationSuggestBox.getSelected() != null)
					{
						//System.out.println("MAIN CLASSI : " + mainClassificationSuggestBox.getSelected().getId());
						delegate.mainClassificationSuggestboxChanged(mainClassificationSuggestBox.getSelected().getId());
					}
					else
					{
						//System.out.println("MAIN CLASSI : " + mainClassificationSuggestBox.getSelected().getId());
						setDefaultMessageOfSuggestionbox();
						delegate.mainClassificationSuggestboxChanged(null);
						
					}
				}
			});
		 
		 classificationTopicSuggestBox.addHandler(new ChangeHandler() {
				
				@Override
				public void onChange(ChangeEvent event) {
					if (classificationTopicSuggestBox.getSelected() != null)
						delegate.classificationTopicSuggestboxChanged(classificationTopicSuggestBox.getSelected().getId());
					else{
						setDefaultMessageOfSuggestionbox();	
						delegate.classificationTopicSuggestboxChanged(null);
							
					}
				}
			});
		 
		 topicSuggestBox.addHandler(new ChangeHandler() {			
				@Override
				public void onChange(ChangeEvent event) {
					if (topicSuggestBox.getSelected() != null)
						delegate.topicSuggestboxChanged(topicSuggestBox.getSelected().getId());
					else{
						setDefaultMessageOfSuggestionbox();
						delegate.topicSuggestboxChanged(null);
					}
				}
			});
		 
	}
	public void setDefaultMessageOfSuggestionbox() {

		if(mainClassificationSuggestBox.getSelected()==null || mainClassificationSuggestBox.getTextField().advancedTextBox.getText()=="")
		mainClassificationSuggestBox.getTextField().advancedTextBox.setText(constants.allMainClassifications());
		
		if(classificationTopicSuggestBox.getSelected()==null || classificationTopicSuggestBox.getTextField().advancedTextBox.getText()=="")
		classificationTopicSuggestBox.getTextField().advancedTextBox.setText(constants.allClassificationTopics());
		
		if(topicSuggestBox.getSelected()==null || topicSuggestBox.getTextField().advancedTextBox.getText()=="")
		topicSuggestBox.getTextField().advancedTextBox.setText(constants.allTopics());
		
	}

	@Override
	public DefaultSuggestBox<MainClassificationProxy, EventHandlingValueHolderItem<MainClassificationProxy>> getMainClassificationSuggestBox() {
		return mainClassificationSuggestBox;
	}
	@Override
	public void setMainClassificationSuggestBox(
			DefaultSuggestBox<MainClassificationProxy, EventHandlingValueHolderItem<MainClassificationProxy>> mainClassificationSuggestBox) {
		this.mainClassificationSuggestBox = mainClassificationSuggestBox;
	}
	@Override
	public DefaultSuggestBox<ClassificationTopicProxy, EventHandlingValueHolderItem<ClassificationTopicProxy>> getClassificationTopicSuggestBox() {
		return classificationTopicSuggestBox;
	}

	@Override
	public void setClassificationTopicSuggestBox(
			DefaultSuggestBox<ClassificationTopicProxy, EventHandlingValueHolderItem<ClassificationTopicProxy>> classificationTopicSuggestBox) {
		this.classificationTopicSuggestBox = classificationTopicSuggestBox;
	}

	@Override
	public DefaultSuggestBox<TopicProxy, EventHandlingValueHolderItem<TopicProxy>> getTopicSuggestBox() {
		return topicSuggestBox;
	}
	
	@Override
	public void setTopicSuggestBox(
			DefaultSuggestBox<TopicProxy, EventHandlingValueHolderItem<TopicProxy>> topicSuggestBox) {
		topicSuggestBox = topicSuggestBox;
	}
	

	@Override
	public void setPresenter(presenter presenter) {
		this.presenter = presenter;

	}

	@Override
	public void setDelegate(Delegate delegate) {
		this.delegate = delegate;

	}
	
	
	public Widget createMainClassificationWidget(MainClassificationProxy mProxy)
	{
		Label mainSkillLbl=new Label();
		String mainClassificationText="";
		if(mProxy.getDescription()!=null)
			mainClassificationText=mProxy.getDescription();
		if( mProxy.getShortcut()!=null)
			mainClassificationText+=" ( " + mProxy.getShortcut() + " ) ";
		
		mainSkillLbl.setText(mainClassificationText);
		mainSkillLbl.setWidth("97%");
		mainSkillLbl.addStyleName("mainClassificationDescription");
		Label skillProgress=new Label("0/0");
		//skillProgress.setWidth("10%");
		skillProgress.getElement().getStyle().setFloat(com.google.gwt.dom.client.Style.Float.RIGHT);
		skillProgress.addStyleName("skillCountPadding");
		//skillProgress.getElement().getStyle().setPaddingRight(8, Unit.PX);
		HorizontalPanel hp=new HorizontalPanel();
		hp.add(mainSkillLbl);
		hp.add(skillProgress);
		hp.setWidth("100%");
		hp.addStyleName("mainClassificationRow");
		return hp;
	}
	
	public Widget createClassificationTopicWidget(ClassificationTopicProxy tProxy)
	{
		Label mainSkillLbl=new Label();
		mainSkillLbl.setText(tProxy.getDescription());
		mainSkillLbl.setWidth("90%");
		mainSkillLbl.addStyleName("classificationDescription");
		Label skillProgress=new Label("5/20");
		//skillProgress.setWidth("10%");
		skillProgress.getElement().getStyle().setFloat(com.google.gwt.dom.client.Style.Float.RIGHT);
		//skillProgress.getElement().getStyle().setPaddingRight(8, Unit.PX);
		skillProgress.addStyleName("skillCountPadding");
		HorizontalPanel hp=new HorizontalPanel();
		hp.add(mainSkillLbl);
		hp.add(skillProgress);
		hp.setWidth("100%");
		hp.addStyleName("classificationTopicRow");
		return hp;
	}
	
	public Widget createTopicWidget(TopicProxy tProxy)
	{
		Label mainSkillLbl=new Label();
		mainSkillLbl.setText(tProxy.getTopicDescription());
		mainSkillLbl.setWidth("90%");
		mainSkillLbl.addStyleName("topicDescription");
		
		Label skillProgress=new Label("5/20");
		//skillProgress.setWidth("10%");
		skillProgress.getElement().getStyle().setFloat(com.google.gwt.dom.client.Style.Float.RIGHT);
		//skillProgress.getElement().getStyle().setPaddingRight(8, Unit.PX);
		skillProgress.addStyleName("skillCountPadding");
		HorizontalPanel hp=new HorizontalPanel();
		hp.add(mainSkillLbl);
		hp.add(skillProgress);
		hp.setWidth("100%");
		hp.addStyleName("topicRow");
		return hp;
	}
	public Widget createSkillWidget(SkillProxy sProxy)
	{
		Label mainSkillLbl=new Label();
		mainSkillLbl.setText(sProxy.getDescription());
		
		mainSkillLbl.addStyleName("skillDescription");
		
		
		return mainSkillLbl;
	}

	public Widget createProgressBar(int maxProgress,int progress)
	{
		CustomProgressbar mainClassificationProgressBar=new CustomProgressbar();
		mainClassificationProgressBar.setMaxProgress(maxProgress);
		mainClassificationProgressBar.setProgress(progress);
		mainClassificationProgressBar.setHeight("20px");
		mainClassificationProgressBar.addStyleName("mainClassificationSkillProgress");
		return mainClassificationProgressBar;
	}
	public void setSource(SkillFilteredResultProxy result)
	{
		List<SkillProxy> data = result.getSkillList();
		List<SkillLevels> skillAcquiredList = result.getSkilltLevelsAcquiredList();
		
		int row=0;
		int mainClassificationRow=0;
		int topicRow=0;
		int classificationTopicRow=0;
		
		for(int i=0;i<data.size();i++)
		{
			SkillProxy sproxy=data.get(i);
			TopicProxy tproxy=sproxy.getTopic();
			ClassificationTopicProxy ctProxy=tproxy.getClassificationTopic();
			MainClassificationProxy mProxy=ctProxy.getMainClassification();
			SkillLevels skillLevel = skillAcquiredList.get(i);
			
			if(i==0)
			{
				skillFlexTable.setWidget(++row, 0, createMainClassificationWidget(mProxy));
				delegate.findProgressOfMainClassification(mProxy,row,1,student);
				/*int mIndex=result.getMainClassificationkey().indexOf("m"+mProxy);
				String mprogress=result.getMainClassificationProgress().get(mIndex);
				String mP[]=mprogress.split("//");
				skillFlexTable.setWidget(row, 1, createProgressBar(new Integer(mP[0]),new Integer(mP[1])));*/
				//skillFlexTable.setText(row, 1, mProxy.getDescription());
				//skillFlexTable.setWidget(row, 1, createProgressBar(20,5));
				skillFlexTable.getFlexCellFormatter().setColSpan(row, 1, 3);
				skillFlexTable.getFlexCellFormatter().addStyleName(row, 1, "mainClassificationBG");
				mainClassificationRow=row;
				
				if(!ctProxy.getDescription().equals("Blank"))
				{
					skillFlexTable.setWidget(++row, 0, createClassificationTopicWidget(ctProxy));
					delegate.findProgressOfClassificationTopic(ctProxy,row,1,student);
					//skillFlexTable.setWidget(row, 1, createProgressBar(20,5));
					skillFlexTable.getFlexCellFormatter().setColSpan(row, 1, 3);
					skillFlexTable.getFlexCellFormatter().addStyleName(row, 1, "classificationTopicBG");
					classificationTopicRow=row;
				}
				
				skillFlexTable.setWidget(++row,0,createTopicWidget(tproxy));
				delegate.findProgressOfTopic(tproxy,row,1,student);
				//skillFlexTable.setWidget(row, 1, createProgressBar(20,5));
				skillFlexTable.getFlexCellFormatter().setColSpan(row, 1, 3);
				skillFlexTable.getFlexCellFormatter().addStyleName(row, 1, "topicBG");
				topicRow=row;
				
			}
			else
			{
		         	/*if( ( tproxy.getId() != data.get(i-1).getTopic().getId()))
				{
					skillFlexTable.setWidget(++row,0,createTopicWidget(tproxy));
					delegate.findProgressOfTopic(tproxy,row,1,student);
					//skillFlexTable.setWidget(row, 1, createProgressBar(20,5));
					skillFlexTable.getFlexCellFormatter().setColSpan(row, 1, 3);
					skillFlexTable.getFlexCellFormatter().addStyleName(row, 1, "topicBG");
					topicRow=row;
				}
				else if( ( ctProxy.getId() != data.get(i-1).getTopic().getClassificationTopic().getId()))
					{
					if(!ctProxy.getDescription().equals("Blank"))
					{
						skillFlexTable.setWidget(++row, 0, createClassificationTopicWidget(ctProxy));
						delegate.findProgressOfClassificationTopic(ctProxy,row,1,student);
						//skillFlexTable.setWidget(row, 1, createProgressBar(20,5));
						skillFlexTable.getFlexCellFormatter().setColSpan(row, 1, 3);
						skillFlexTable.getFlexCellFormatter().addStyleName(row, 1, "classificationTopicBG");
						classificationTopicRow=row;
					}
					}
				else if( ( mProxy.getId() != data.get(i-1).getTopic().getClassificationTopic().getMainClassification().getId()))
				{
					skillFlexTable.setWidget(++row, 0, createMainClassificationWidget(mProxy));
					delegate.findProgressOfMainClassification(mProxy,row,1,student);
					//skillFlexTable.setWidget(row, 1, createProgressBar(20,5));
					skillFlexTable.getFlexCellFormatter().setColSpan(row, 1, 3);
					skillFlexTable.getFlexCellFormatter().addStyleName(row, 1, "mainClassificationBG");
					mainClassificationRow=row;
				}*/
				if( ( tproxy.getId() != data.get(i-1).getTopic().getId())){
					
					if( ( ctProxy.getId() != data.get(i-1).getTopic().getClassificationTopic().getId())){
						
						if( ( mProxy.getId() != data.get(i-1).getTopic().getClassificationTopic().getMainClassification().getId())){
							skillFlexTable.setWidget(++row, 0, createMainClassificationWidget(mProxy));
							delegate.findProgressOfMainClassification(mProxy,row,1,student);
							//skillFlexTable.setWidget(row, 1, createProgressBar(20,5));
							skillFlexTable.getFlexCellFormatter().setColSpan(row, 1, 3);
							skillFlexTable.getFlexCellFormatter().addStyleName(row, 1, "mainClassificationBG");
							mainClassificationRow=row;
						}
						if(!ctProxy.getDescription().equals("Blank"))
						{
							skillFlexTable.setWidget(++row, 0, createClassificationTopicWidget(ctProxy));
							delegate.findProgressOfClassificationTopic(ctProxy,row,1,student);
							//skillFlexTable.setWidget(row, 1, createProgressBar(20,5));
							skillFlexTable.getFlexCellFormatter().setColSpan(row, 1, 3);
							skillFlexTable.getFlexCellFormatter().addStyleName(row, 1, "classificationTopicBG");
							classificationTopicRow=row;
						}
						
					}
					skillFlexTable.setWidget(++row,0,createTopicWidget(tproxy));
					delegate.findProgressOfTopic(tproxy,row,1,student);
					//skillFlexTable.setWidget(row, 1, createProgressBar(20,5));
					skillFlexTable.getFlexCellFormatter().setColSpan(row, 1, 3);
					skillFlexTable.getFlexCellFormatter().addStyleName(row, 1, "topicBG");
					topicRow=row;
				}
						
			}
			 
			
			
			skillFlexTable.setWidget(++row,0,createSkillWidget(sproxy));
			skillFlexTable.getRowFormatter().addStyleName(row, "redBG");
			//flexTable.getFlexCellFormatter().addStyleName(row, 0, "skillDescription");
			String shortcut="";
			if(mProxy.getShortcut()!=null)
			shortcut+=mProxy.getShortcut();
			if(ctProxy.getShortcut() !=null)
			shortcut+=" "+ctProxy.getShortcut();
			if(sproxy.getShortcut() !=null)
			shortcut+=" "+sproxy.getShortcut();
			
			skillFlexTable.setText(row,1,shortcut);
			skillFlexTable.getFlexCellFormatter().addStyleName(row, 1, "skillDescription");
			skillFlexTable.getFlexCellFormatter().getElement(row, 1).setPropertyString("textAlign", "center");
			
			SkillLevelCheckboxViewImpl checkBox=new SkillLevelCheckboxViewImpl();
			checkBox.setSkillProxy(sproxy);
			checkBox.setLevel1(true);
			checkBox.setDelegate(skillActivity);
			checkBox.setRow(row);
			checkBox.setColumn(2);
			checkBox.setMainClassificationRow(mainClassificationRow);
			checkBox.setClassificationTopicRow(classificationTopicRow);
			checkBox.setTopicRow(topicRow);
			skillFlexTable.setWidget(row,2, checkBox);
			skillFlexTable.getFlexCellFormatter().addStyleName(row, 2, "skillChkBox");
			
			SkillLevelCheckboxViewImpl checkBox2=new SkillLevelCheckboxViewImpl();
			checkBox2.setSkillProxy(sproxy);
			checkBox2.setLevel1(false);
			checkBox2.setDelegate(skillActivity);
			checkBox2.setRow(row);
			checkBox2.setColumn(3);
			checkBox2.setMainClassificationRow(mainClassificationRow);
			checkBox2.setClassificationTopicRow(classificationTopicRow);
			checkBox2.setTopicRow(topicRow);
			skillFlexTable.setWidget(row,3, checkBox2);
			skillFlexTable.getFlexCellFormatter().addStyleName(row, 3, "skillChkBox");
			
			if(skillLevel==SkillLevels.SOME_PRACTICLE_EXPERIENCE){
				checkBox.getCheckbox().setValue(true);
			}
			else if(skillLevel==SkillLevels.ROUTINE){
				checkBox2.getCheckbox().setValue(true);
			}
			
			int skillSkillLevel;
			
			if(sproxy.getSkillLevel()==null){
			
				skillSkillLevel=0;
				checkBox.setVisible(false);
				checkBox2.setVisible(false);
			}
			
			
			else
			skillSkillLevel=sproxy.getSkillLevel().getLevelNumber();
			
			
			if(skillLevel==SkillLevels.SOME_PRACTICLE_EXPERIENCE && skillSkillLevel==2)
			{
				skillFlexTable.getRowFormatter().removeStyleName(row, "redBG");
				skillFlexTable.getRowFormatter().removeStyleName(row, "greenBG");
				skillFlexTable.getRowFormatter().addStyleName(row, "yellowBG");
			}
			else if(skillLevel==SkillLevels.SOME_PRACTICLE_EXPERIENCE && skillSkillLevel==1)
			{
				skillFlexTable.getRowFormatter().removeStyleName(row, "redBG");
				skillFlexTable.getRowFormatter().removeStyleName(row, "yellowBG");
				skillFlexTable.getRowFormatter().addStyleName(row, "greenBG");
				
			}
			else if(skillLevel==SkillLevels.ROUTINE)
			{
				skillFlexTable.getRowFormatter().removeStyleName(row, "redBG");
				skillFlexTable.getRowFormatter().removeStyleName(row, "yellowBG");
				skillFlexTable.getRowFormatter().addStyleName(row, "greenBG");
				
			}
			else
			{
				skillFlexTable.getRowFormatter().removeStyleName(row, "yellowBG");
				skillFlexTable.getRowFormatter().removeStyleName(row, "greenBG");
				skillFlexTable.getRowFormatter().addStyleName(row, "redBG");
			}
			
		}
	}
	
	@UiHandler("imgpdf")
	public void pdfClicked(ClickEvent event)
	{
		delegate.exportPDF();
	}
	
	
}
