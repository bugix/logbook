package ch.unibas.medizin.logbook.client.application;

import ch.unibas.medizin.logbook.client.ioc.LogBookInjector;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;

/**
 * Startingpoint of the application, starts application.
 */
@SuppressWarnings("deprecation")
public class ApplicationEntry implements EntryPoint {

	final private LogBookInjector injectorWrapper = GWT.create(LogBookInjector.class);

	@Override
	public void onModuleLoad() {

		/*
		 * Install an UncaughtExceptionHandler which will produce
		 * <code>FATAL</code> log messages
		 */
		Log.setUncaughtExceptionHandler();

		/*
		 * Use a deferred command so that the UncaughtExceptionHandler catches
		 * any exceptions in onModuleLoad2()
		 */
		DeferredCommand.addCommand(new Command() {
			public void execute() {
				onModuleLoad2();
			}

		});
	}

	private void onModuleLoad2() {
		Log.debug("Application starts...");
		injectorWrapper.getApplication().run();
	}
}
