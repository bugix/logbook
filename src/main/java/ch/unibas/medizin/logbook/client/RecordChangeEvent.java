package ch.unibas.medizin.logbook.client;



import ch.unibas.medizin.logbook.shared.scaffold.LogBookConstant;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Cookies;

public class RecordChangeEvent extends GwtEvent<RecordChangeHandler> {

	private static final Type TYPE = new Type<RecordChangeHandler>();
	
	private String recordValue;
	
	public RecordChangeEvent(String val)
	{
		this.recordValue = val;
		Cookies.setCookie("user", val);
		
		if (recordValue != "ALL")
		{
			LogBookConstant.TABLE_PAGE_SIZE = Integer.parseInt(this.recordValue);
		}
	}
	
	public String getRecordValue() {
		return recordValue;
	}

	public static Type getType() {
		return TYPE;
	}

	@Override
	protected void dispatch(RecordChangeHandler handler) {
		handler.onRecordChange(this);
	}
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<RecordChangeHandler> getAssociatedType() {
		return TYPE;
	}
	
	public static HandlerRegistration register(EventBus eventBus,
			RecordChangeHandler handler) {
		return eventBus.addHandler(TYPE, handler);
	}
}
