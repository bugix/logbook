package logbook.client.a_nonroo.app;

import logbook.client.a_nonroo.app.ioc.LogBookInjector;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
/**
 * Startingpoint of the application, starts application.
 * @author milan
 *
 */

public class ApplicationEntry implements EntryPoint {

	final private LogBookInjector injectorWrapper = GWT.create(LogBookInjector.class);

	@SuppressWarnings("deprecation")
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
		// new McAppFactory().getMcApp().run(RootLayoutPanel.get());

	}
}
