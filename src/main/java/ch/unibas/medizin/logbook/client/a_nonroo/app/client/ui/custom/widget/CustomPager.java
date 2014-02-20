package ch.unibas.medizin.logbook.client.a_nonroo.app.client.ui.custom.widget;

import java.util.ArrayList;
import java.util.Iterator;

import ch.unibas.medizin.logbook.shared.i18n.LogBookConstants;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class CustomPager extends Composite implements ClickHandler {
	
	private static LogBookConstants constants = GWT.create(LogBookConstants.class);
	
	// public class CustomPager extends Widget implements ClickHandler {
	private Button first = new Button("");
	private Button next = new Button("");
	private Button last = new Button("");
	private Button previous = new Button("");
	private Label recordDisplay = new Label();
	private HorizontalPanel labelContainer = new HorizontalPanel();
	private HorizontalPanel buttonContainer = new HorizontalPanel();
	
	private HorizontalPanel container = new HorizontalPanel();
	int totalrecord = 100;
	
	int range = 5;
	int start = 1;
	int end = start + range - 1;
	 private ArrayList    listeners    = new ArrayList();
	public CustomPager() {

		labelContainer.add(recordDisplay);
		first.addStyleName("pagerFirstButton");
		last.addStyleName("pagerLastButton");
		next.addStyleName("pagerNextButton");
		previous.addStyleName("pagerPreviousButton");
		
		 
		buttonContainer.add(first);
		buttonContainer.add(previous);
		buttonContainer.add(next);
		buttonContainer.add(last);
		recordDisplay.addStyleName("labelForPager");
		first.setEnabled(false);
		first.setStylePrimaryName("pagerFirstButtonDisable");
		previous.setEnabled(false);
		previous.setStylePrimaryName("pagerPreviousButtonDisable");
		container.add(buttonContainer);
		container.add(labelContainer);
		
		first.addClickHandler(this);
		next.addClickHandler(this);
		previous.addClickHandler(this);
		last.addClickHandler(this);
		
		first.setTitle(constants.first());
		next.setTitle(constants.next());
		previous.setTitle(constants.previous());
		last.setTitle(constants.last());
		
		recordDisplay.setText(start + "-" + end + " of " + totalrecord);
		// setElement(container.getElement());
		initWidget(container);
		// intiClickEvent();

	}


	public void setRowCount(int totalRecord) {
		
		
		this.totalrecord = totalRecord;
		//recordDisplay.setText(start + "-" + end + " of " + totalrecord);
		next.setStylePrimaryName("pagerNextButton");
		last.setStylePrimaryName("pagerLastButton");
		
		start = 1;
		end = start + range - 1;
		recordDisplay.setText(start + "-" + end + " of " + totalrecord);
		next.setEnabled(true);
		next.setStylePrimaryName("pagerNextButton");
		last.setEnabled(true);
		last.setStylePrimaryName("pagerLastButton");
		first.setEnabled(false);
		first.setStylePrimaryName("pagerFirstButtonDisable");
		previous.setEnabled(false);
		previous.setStylePrimaryName("pagerPreviousButtonDisable");
		//first.setEnabled(true);
		//previous.setEnabled(true);
		//start = end + 1;
		//end = end + range;
		if (end >=totalrecord) {
			end = totalrecord;
			//start = end - range + 1;
			recordDisplay.setText(start + "-" + end + " of " + totalrecord);
			next.setEnabled(false);
			next.setStylePrimaryName("pagerNextButtonDisable");
			last.setEnabled(false);
			last.setStylePrimaryName("pagerLastButtonDisable");
		}
		//recordDisplay.setText(start + "-" + end + " of " + totalrecord);
		
	/*	start = 1;
		end = start + range - 1;
	
		if (end >=totalrecord) {
			end = totalrecord;
			start = end - range + 1;
			recordDisplay.setText(start + "-" + end + " of " + totalrecord);
			next.setEnabled(false);
			last.setEnabled(false);
		}
	 */
		
	}
	
	

	public int getStart() {
		return this.start;
	}

	public int getLength() {
		return this.range;
	}
	
	public void setStart(int val) {
		this.start = val;
	}
	
	public void  setLength(int length) {
		 this.range=length;
		 end = start + range - 1;
		 recordDisplay.setText(start + "-" + end + " of " + totalrecord);
		 if (end >=totalrecord) {
				end = totalrecord;
				start = end - range + 1;
				recordDisplay.setText(start + "-" + end + " of " + totalrecord);
				next.setEnabled(false);
				next.setStylePrimaryName("pagerNextButtonDisable");
				last.setEnabled(false);
				last.setStylePrimaryName("pagerLastButtonDisable");
			}
		 
		 if (start <=1) {
				start = 1;
				end = start + range - 1;
				recordDisplay.setText(start + "-" + end + " of " + totalrecord);
				first.setEnabled(false);
				first.setStylePrimaryName("pagerFirstButtonDisable");
				previous.setEnabled(false);
				previous.setStylePrimaryName("pagerPreviousButtonDisable");
			}
		 
	}

	private void firstClick() {
		start = 1;
		end = start + range - 1;
		recordDisplay.setText(start + "-" + end + " of " + totalrecord);
		
		next.setEnabled(true);
		next.setStylePrimaryName("pagerNextButton");
		last.setEnabled(true);
		last.setStylePrimaryName("pagerLastButton");
		first.setEnabled(false);
		first.setStylePrimaryName("pagerFirstButtonDisable");
		previous.setEnabled(false);
		previous.setStylePrimaryName("pagerPreviousButtonDisable");
	}

	private void nextClick() {
		
		first.setEnabled(true);
		first.setStylePrimaryName("pagerFirstButton");
		previous.setEnabled(true);
		previous.setStylePrimaryName("pagerPreviousButton");
		start = end + 1;
		end = end + range;
		if (end >=totalrecord) {
			end = totalrecord;
			start = end - range + 1;
			recordDisplay.setText(start + "-" + end + " of " + totalrecord);
			next.setEnabled(false);
			next.setStylePrimaryName("pagerNextButtonDisable");
			last.setEnabled(false);
			last.setStylePrimaryName("pagerLastButtonDisable");
		}
		recordDisplay.setText(start + "-" + end + " of " + totalrecord);
	}

	private void lastClick() {
		end = totalrecord;
		start = end - range + 1;
		recordDisplay.setText(start + "-" + end + " of " + totalrecord);
		next.setEnabled(false);
		next.setStylePrimaryName("pagerNextButtonDisable");
		last.setEnabled(false);
		last.setStylePrimaryName("pagerLastButtonDisable");
		
		first.setEnabled(true);
		first.setStylePrimaryName("pagerFirstButton");
		previous.setEnabled(true);
		previous.setStylePrimaryName("pagerPreviousButton");
	}

	private void previousClick() {
		
		next.setEnabled(true);
		next.setStylePrimaryName("pagerNextButton");
		last.setEnabled(true);
		last.setStylePrimaryName("pagerLastButton");
		end = start - 1;
		start = end - range + 1;
		if (start <=1) {
			start = 1;
			end = start + range - 1;
			recordDisplay.setText(start + "-" + end + " of " + totalrecord);
			first.setEnabled(false);
			first.setStylePrimaryName("pagerFirstButtonDisable");
			previous.setEnabled(false);
			previous.setStylePrimaryName("pagerPreviousButtonDisable");
		}
		recordDisplay.setText(start + "-" + end + " of " + totalrecord);
	}

	// @Override
	public void onClick(ClickEvent event) {
		// TODO Auto-generated method stub

		Widget sender = (Widget) event.getSource();

		if (sender == first) {
			firstClick();
			//Log.info("first Click");
		} else if (sender == next) {
			nextClick();
			//Log.info("next click");

		} else if (sender == previous) {
			previousClick();
			//Log.info("previous Click");
		} else if (sender == last) {
			lastClick();
			//Log.info("last Click");
		}

		onRangeChange();

	}

	public void addRangeChangeListener(RangeChangeListener listener)
    {
        listeners.add(listener);
    }
	
	public void removeRangeChangeListener(RangeChangeListener listener)
    {
        listeners.remove(listener);
    }
	
	private final  void onRangeChange()
    {
        for(Iterator it = listeners.iterator(); it.hasNext();)
        {
            RangeChangeListener listener = (RangeChangeListener) it.next();
            listener.onRangeChange();
        }
    }
	
	public interface RangeChangeListener extends java.util.EventListener
	{
	    void onRangeChange();
	}
	
	
	
}
