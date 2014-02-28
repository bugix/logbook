package ch.unibas.medizin.logbook.client.application;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import ch.unibas.medizin.logbook.client.activity.LogBookActivityMapper;
import ch.unibas.medizin.logbook.client.navigation.LogBookAdminNav;
import ch.unibas.medizin.logbook.client.navigation.LogBookNav;
import ch.unibas.medizin.logbook.client.place.AdminPlace;
import ch.unibas.medizin.logbook.client.place.LogBookPlaceHistoryFactory;
import ch.unibas.medizin.logbook.client.place.LogBookPlaceHistoryMapper;
import ch.unibas.medizin.logbook.client.place.LoginPlace;
import ch.unibas.medizin.logbook.client.request.LogBookRequestFactory;
import ch.unibas.medizin.logbook.client.request.RequestEvent;
import ch.unibas.medizin.logbook.client.shell.LogBookAdminShell;
import ch.unibas.medizin.logbook.client.shell.LogBookShell;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.logging.client.LogConfiguration;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryLogHandler;
import com.google.web.bindery.requestfactory.shared.LoggingRequest;
import com.google.web.bindery.requestfactory.shared.Receiver;

/**
 * The applications core. Is instantiated by GIN.
 */
public class LogBookApplication {

	private static final Logger log = Logger.getLogger(LogBookApplication.class.getName());

	private final LogBookShell studentShell;
	private final LogBookAdminShell adminShell;
	private final LogBookRequestFactory requestFactory;
	private final EventBus eventBus;
	private final PlaceController placeController;
	private final LogBookPlaceHistoryFactory logBookPlaceHistoryFactory;
	private final LogBookActivityMapper mcAppActivitiesMapper;

	@Inject
	public LogBookApplication(LogBookShell shell, LogBookAdminShell adminShell, LogBookRequestFactory requestFactory, EventBus eventBus, PlaceController placeController, LogBookPlaceHistoryFactory oscePlaceHistoryFactory, LogBookActivityMapper applicationMainActivitiesMapper) {
		Log.debug("LogBookApp.LogBookApp");
		this.studentShell = shell;
		this.requestFactory = requestFactory;
		this.eventBus = eventBus;
		this.placeController = placeController;
		this.logBookPlaceHistoryFactory = oscePlaceHistoryFactory;
		this.mcAppActivitiesMapper = applicationMainActivitiesMapper;
		this.adminShell = adminShell;
	}

	public void run() {

		Log.debug("McApp.run()");

		/* Add handlers, setup activities */
		requestFactory.studentRequest().isCurrentUserStudent().fire(new Receiver<Boolean>() {

			@Override
			public void onSuccess(Boolean isStudent) {
				if (isStudent == null) {
				} else if (isStudent == true) {
					initStudent();
					RootLayoutPanel.get().clear();
					RootLayoutPanel.get().add(studentShell);
				} else if (isStudent == false) {
					initAdmin();
					RootLayoutPanel.get().clear();
					RootLayoutPanel.get().add(adminShell);
				}

			}
		});

		/* And show the user the shell */
		Log.debug("McApp.addPanlel");
		Log.debug("McApp.addPanlel.after");
	}

	private void initAdmin() {
		Log.debug("McApp.initAdmin()");
		GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {
			public void onUncaughtException(Throwable e) {
				Log.warn("Fehler im Exception Handler: " + e.getMessage(), e);
				log.log(Level.SEVERE, e.getMessage(), e);
			}
		});

		if (LogConfiguration.loggingIsEnabled()) {
			// Add remote logging handler
			RequestFactoryLogHandler.LoggingRequestProvider provider = new RequestFactoryLogHandler.LoggingRequestProvider() {
				public LoggingRequest getLoggingRequest() {
					return requestFactory.loggingRequest();
				}
			};
			Logger.getLogger("").addHandler(new RequestFactoryLogHandler(provider, Level.WARNING, new ArrayList<String>()));
		}

		RequestEvent.register(eventBus, new RequestEvent.Handler() {
			public void onRequestEvent(RequestEvent requestEvent) {
				if (requestEvent.getState() == RequestEvent.State.SENT) {
					// shell.getMole().showDelayed(LOADING_TIMEOUT);
				} else {
					// shell.getMole().hide();
				}
			}
		});

		Log.debug("McApp.Mapper");
		Log.debug("LogBook.History");

		/* Browser history integration */
		LogBookPlaceHistoryMapper mapper = GWT.create(LogBookPlaceHistoryMapper.class);
		mapper.setFactory(logBookPlaceHistoryFactory);
		PlaceHistoryHandler placeHistoryHandler = new PlaceHistoryHandler(mapper);

		LogBookAdminNav adminNav = new LogBookAdminNav(requestFactory, placeController, placeHistoryHandler, mcAppActivitiesMapper, eventBus);
		adminShell.setNavigation(adminNav);

		placeHistoryHandler.register(placeController, eventBus, new AdminPlace());

		placeHistoryHandler.handleCurrentHistory();

		Log.debug("McApp.initAdminAfter");
	}

	private void initStudent() {
		Log.debug("McApp.initStudent()");
		GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {
			public void onUncaughtException(Throwable e) {
				Log.warn("Fehler im Exception Handler: " + e.getMessage(), e);
				log.log(Level.SEVERE, e.getMessage(), e);
			}
		});

		if (LogConfiguration.loggingIsEnabled()) {
			// Add remote logging handler
			RequestFactoryLogHandler.LoggingRequestProvider provider = new RequestFactoryLogHandler.LoggingRequestProvider() {
				public LoggingRequest getLoggingRequest() {
					return requestFactory.loggingRequest();
				}
			};
			Logger.getLogger("").addHandler(new RequestFactoryLogHandler(provider, Level.WARNING, new ArrayList<String>()));
		}

		/*
		RequestEvent.register(eventBus, new RequestEvent.Handler() {
			// Only show loading status if a request isn't serviced in 250ms.
			private static final int LOADING_TIMEOUT = 250;

			public void onRequestEvent(RequestEvent requestEvent) {
				if (requestEvent.getState() == RequestEvent.State.SENT) {
					// shell.getMole().showDelayed(LOADING_TIMEOUT);
				} else {
					// shell.getMole().hide();
				}
			}
		});
		*/

		Log.debug("LogBook.History");
		/* Browser history integration */
		LogBookPlaceHistoryMapper mapper = GWT.create(LogBookPlaceHistoryMapper.class);
		mapper.setFactory(logBookPlaceHistoryFactory);
		PlaceHistoryHandler placeHistoryHandler = new PlaceHistoryHandler(mapper);

		LogBookNav nav = new LogBookNav(requestFactory, placeController, placeHistoryHandler, mcAppActivitiesMapper, eventBus);
		studentShell.setNavigation(nav);
		placeHistoryHandler.register(placeController, eventBus, new LoginPlace());

		placeHistoryHandler.handleCurrentHistory();

		Log.debug("McApp.initStudentAfter");
	}

}
