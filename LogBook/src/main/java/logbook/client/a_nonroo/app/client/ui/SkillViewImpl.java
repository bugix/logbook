package logbook.client.a_nonroo.app.client.ui;

import java.util.ArrayList;
import java.util.List;



import logbook.client.a_nonroo.app.client.ui.custom.widget.CustomPager.RangeChangeListener;
import logbook.client.a_nonroo.app.client.ui.custom.widget.*;
import logbook.client.managed.proxy.ClassificationTopicProxy;
import logbook.client.managed.proxy.MainClassificationProxy;
import logbook.client.managed.proxy.SkillProxy;
import logbook.client.managed.proxy.TopicProxy;
import logbook.client.style.widgetsnewcustomsuggestbox.test.client.ui.widget.suggest.EventHandlingValueHolderItem;
import logbook.client.style.widgetsnewcustomsuggestbox.test.client.ui.widget.suggest.impl.DefaultSuggestBox;
import logbook.client.style.widgetsnewcustomsuggestbox.test.client.ui.widget.suggest.impl.simple.DefaultSuggestOracle;
import logbook.shared.SkillLevels;
import logbook.shared.i18n.LogBookConstants;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class SkillViewImpl extends Composite implements SkillView {

	private static SkillViewImpllUiBinder uiBinder = GWT
			.create(SkillViewImpllUiBinder.class);

	interface SkillViewImpllUiBinder extends UiBinder<Widget, SkillViewImpl> {
	}

	private Delegate delegate;

	private presenter presenter;

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
	
	private List<String> levelList = new ArrayList<String>();
	
	@UiField
	DefaultSuggestBox<MainClassificationProxy, EventHandlingValueHolderItem<MainClassificationProxy>> mainClassificationSuggestBox;
	
	 @UiField
	public DefaultSuggestBox<ClassificationTopicProxy, EventHandlingValueHolderItem<ClassificationTopicProxy>> classificationTopicSuggestBox;

	 @UiField
	 public DefaultSuggestBox<TopicProxy, EventHandlingValueHolderItem<TopicProxy>> topicSuggestBox;
	 
	 @UiField
	 public DefaultSuggestBox<String, EventHandlingValueHolderItem<String>> levelSuggestBox;
	 
	 @UiField
	 public  TextBox fullTextSearchBox;
	 
	 @UiField
	 CustomPager pager;
	 
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

	public Label getLblError() {
		return lblError;
	}

	public void setLblError(Label lblError) {
		this.lblError = lblError;
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

	@UiField
	Label levelLabel;
	
	@UiField
	Anchor hyperLnkPrint;

	@UiField
	Image imgpdf;

	@UiField
	Anchor hyperlnkSavePDF;

	@UiHandler("hyperlnkSavePDF")
	public void savePdfClicked(ClickEvent event){
		event.preventDefault();
		event.stopPropagation();
		delegate.generatePdfClicked();
	}
	
	@UiHandler("hyperLnkPrint")
	public void printPdfClicked(ClickEvent event){
		delegate.printPdfClicked();
	}
	
	@UiField
	Label lblError;

	public SkillViewImpl() {

		
		skillFlexTable = new FlexTable();
		skillFlexTable.setCellPadding(1);
		skillFlexTable.setCellSpacing(1);
		createHeader(skillFlexTable);
		
	//	setSkillFlexTableHeaders();
		
	//	setSkillFlexTableStyles();
		
		
		
//	skillFlexTable.setText(1, 0,"This is sub title of table");
	
		
//	skillFlexTable.getFlexCellFormatter().setColSpan(1, 0, 6);

//		skillFlexTable.setHTML(1, 0, "");
//		skillFlexTable.setHTML(1, 1, "Hello");
//		skillFlexTable.setHTML(1, 2, "S1");
//		skillFlexTable.setWidget(1, 3, new CheckBox());
//		skillFlexTable.setWidget(1, 4, new CheckBox());

/*		skillFlexTable.setHTML(2, 0," ");
		skillFlexTable.setHTML(2, 1, "Hello1");
		skillFlexTable.setHTML(2, 2, "S2");
		skillFlexTable.setWidget(2, 3, new CheckBox());
		skillFlexTable.setWidget(2, 4, new CheckBox());
*/
//		skillFlexTable.getFlexCellFormatter().setColSpan(2,0,1);

		initWidget(uiBinder.createAndBindUi(this));
		
		init(); // Initialize Skill Data
		
		pager.setLength(20);
		
		pager.addRangeChangeListener(new RangeChangeListener() {
			
			@Override
			public void onRangeChange() {
				Log.info("pager start :"+pager.getStart());
				Log.info("pager Length :" + pager.getLength());
				delegate.refreshFlextable(skillFlexTable, pager.getStart(), pager.getLength());
			}
		});

	}
	
	public void createHeader(FlexTable flexTable)
	{
		flexTable.setText(0, 0, constants.name());
		flexTable.getCellFormatter().addStyleName(0, 0, "flexTable-header");
		flexTable.getFlexCellFormatter().setWidth(0, 0, "70%");
		flexTable.setText(0, 1, constants.shortcut());
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
		mainClassificationLabel.setText(constants.mainClassification() + "    ");
		classificationTopic.setText(constants.classificationTopic() + "   ");
		topic.setText(constants.topic() + "   ");

		btnShow.setText(constants.show());
		btnReset.setText(constants.reset());

		fullTextSearch.setText(constants.fullTextSearch());
		
		imgPrint.setAltText(constants.imageNotFound());
		imgPrint.setUrl("/public/images/print.png");

		imgpdf.setAltText(constants.imageNotFound());
		imgpdf.setUrl("/public/images/pdf.png");

		hyperLnkPrint.setText(constants.print());
		hyperlnkSavePDF.setText(constants.saveAsPdf());

		lblError.setVisible(false);
		lblError.setText("Error...");
		
		levelLabel.setText(constants.level());
		
		initSkillSuggesstions();

	}

	private void initSkillSuggesstions() {
		mainClassificationSuggestBox.setWidth(400);
		classificationTopicSuggestBox.setWidth(350);
		topicSuggestBox.setWidth(350);
		fullTextSearchBox.setWidth("350px");
		fullTextSearchBox.addStyleName("fullTextBoxsearchStyle");
		levelSuggestBox.setWidth(350);
		levelList.add(constants.level1());
		levelList.add(constants.level2());
		
		DefaultSuggestOracle<String> suggestOracle = (DefaultSuggestOracle<String>) levelSuggestBox.getSuggestOracle();
		suggestOracle.setPossiblilities(levelList);
		levelSuggestBox.setSuggestOracle(suggestOracle);
		
		levelSuggestBox.setRenderer(new AbstractRenderer<String>() {

			@Override
			public String render(String value) {
				if (value != null)
					return value;
				else
					return "";
			}
		});

		
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
						delegate.mainClassificationSuggestboxChanged(null);
					}
				}
			});
		 
		 classificationTopicSuggestBox.addHandler(new ChangeHandler() {
				
				@Override
				public void onChange(ChangeEvent event) {
					if (classificationTopicSuggestBox.getSelected() != null)
						delegate.classificationTopicSuggestboxChanged(classificationTopicSuggestBox.getSelected().getId());
					else
						delegate.classificationTopicSuggestboxChanged(null);
				}
			});
		 
		 topicSuggestBox.addHandler(new ChangeHandler() {			
				@Override
				public void onChange(ChangeEvent event) {
					if (topicSuggestBox.getSelected() != null)
						delegate.topicSuggestboxChanged(topicSuggestBox.getSelected().getId());
					else
						delegate.topicSuggestboxChanged(null);
				}
			});
		 
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
		mainSkillLbl.setText(mProxy.getDescription());
		mainSkillLbl.setWidth("90%");
		mainSkillLbl.addStyleName("mainClassificationDescription");
		Label skillProgress=new Label("5/20");
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
	public void setSource(List<SkillProxy> data)
	{
		int row=0;
		for(int i=0;i<data.size();i++)
		{
			SkillProxy sproxy=data.get(i);
			TopicProxy tproxy=sproxy.getTopic();
			ClassificationTopicProxy ctProxy=tproxy.getClassificationTopic();
			MainClassificationProxy mProxy=ctProxy.getMainClassification();
			
			if(i==0)
			{
				skillFlexTable.setWidget(++row, 0, createMainClassificationWidget(mProxy));
				
				skillFlexTable.setWidget(row, 1, createProgressBar(20,5));
				//skillFlexTable.setText(row, 1, mProxy.getDescription());
				skillFlexTable.getFlexCellFormatter().setColSpan(row, 1, 3);
				skillFlexTable.getFlexCellFormatter().addStyleName(row, 1, "mainClassificationBG");
				
				
				if(!ctProxy.getDescription().equals("Blank"))
				{
					skillFlexTable.setWidget(++row, 0, createClassificationTopicWidget(ctProxy));
					skillFlexTable.setWidget(row, 1, createProgressBar(20,5));
					skillFlexTable.getFlexCellFormatter().setColSpan(row, 1, 3);
					skillFlexTable.getFlexCellFormatter().addStyleName(row, 1, "classificationTopicBG");
				}
				
				skillFlexTable.setWidget(++row,0,createTopicWidget(tproxy));
				skillFlexTable.setWidget(row, 1, createProgressBar(20,5));
				skillFlexTable.getFlexCellFormatter().setColSpan(row, 1, 3);
				skillFlexTable.getFlexCellFormatter().addStyleName(row, 1, "topicBG");
				
			}
			else
			{
				if( ( tproxy.getId() != data.get(i-1).getTopic().getId()))
				{
					skillFlexTable.setWidget(++row,0,createTopicWidget(tproxy));
					skillFlexTable.setWidget(row, 1, createProgressBar(20,5));
					skillFlexTable.getFlexCellFormatter().setColSpan(row, 1, 3);
					skillFlexTable.getFlexCellFormatter().addStyleName(row, 1, "topicBG");
				}
				else if( ( ctProxy.getId() != data.get(i-1).getTopic().getClassificationTopic().getId()))
					{
					if(!ctProxy.getDescription().equals("Blank"))
					{
						skillFlexTable.setWidget(++row, 0, createClassificationTopicWidget(ctProxy));
						skillFlexTable.setWidget(row, 1, createProgressBar(20,5));
						skillFlexTable.getFlexCellFormatter().setColSpan(row, 1, 3);
						skillFlexTable.getFlexCellFormatter().addStyleName(row, 1, "classificationTopicBG");
					}
					}
				else if( ( mProxy.getId() != data.get(i-1).getTopic().getClassificationTopic().getMainClassification().getId()))
				{
					skillFlexTable.setWidget(++row, 0, createMainClassificationWidget(mProxy));
					skillFlexTable.setWidget(row, 1, createProgressBar(20,5));
					skillFlexTable.getFlexCellFormatter().setColSpan(row, 1, 3);
					skillFlexTable.getFlexCellFormatter().addStyleName(row, 1, "mainClassificationBG");
				}
			}
			 
			
			
			skillFlexTable.setWidget(++row,0,createSkillWidget(sproxy));
			//flexTable.getFlexCellFormatter().addStyleName(row, 0, "skillDescription");
			skillFlexTable.setText(row,1,mProxy.getShortcut()+sproxy.getShortcut());
			skillFlexTable.getFlexCellFormatter().addStyleName(row, 1, "skillDescription");
			skillFlexTable.getFlexCellFormatter().getElement(row, 1).setPropertyString("textAlign", "center");
			
			SkillLevelCheckboxViewImpl checkBox=new SkillLevelCheckboxViewImpl();
			checkBox.setSkillProxy(sproxy);
			checkBox.setLevel1(true);			
			skillFlexTable.setWidget(row,2, checkBox);
			skillFlexTable.getFlexCellFormatter().addStyleName(row, 2, "skillChkBox");
			
			SkillLevelCheckboxViewImpl checkBox2=new SkillLevelCheckboxViewImpl();
			checkBox2.setSkillProxy(sproxy);
			checkBox2.setLevel1(false);
			skillFlexTable.setWidget(row,3, checkBox2);
			skillFlexTable.getFlexCellFormatter().addStyleName(row, 3, "skillChkBox");
		}
	}
	
	
}
