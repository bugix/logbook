package  logbook.client.a_nonroo.app.client.ui;

 
import logbook.shared.i18n.LogBookConstants;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;


public class AdminViewImpl extends Composite implements AdminView{
	
	private static AdminViewImpllUiBinder uiBinder = GWT
			.create(AdminViewImpllUiBinder.class);

	interface AdminViewImpllUiBinder extends UiBinder<Widget, AdminViewImpl> {
	}

	private Delegate delegate;
	
	private presenter presenter;

		LogBookConstants constants = GWT.create(LogBookConstants.class);
	
	public AdminViewImpl() {
	
		initWidget(uiBinder.createAndBindUi(this));
		init();
	}

	private void init() 
	{
			
	}
	
	private void initLoginData() 
	{		
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
