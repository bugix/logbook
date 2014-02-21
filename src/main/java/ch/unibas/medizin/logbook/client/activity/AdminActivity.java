package ch.unibas.medizin.logbook.client.activity;

import java.util.Set;

import javax.validation.ConstraintViolation;

import ch.unibas.medizin.logbook.client.event.ApplicationLoadingScreenEvent;
import ch.unibas.medizin.logbook.client.place.LoginPlace;
import ch.unibas.medizin.logbook.client.proxy.AdministratorProxy;
import ch.unibas.medizin.logbook.client.service.CsvFileGeneratorService;
import ch.unibas.medizin.logbook.client.service.CsvFileGeneratorServiceAsync;
import ch.unibas.medizin.logbook.client.ui.AdminView;
import ch.unibas.medizin.logbook.client.ui.AdminViewImpl;
import ch.unibas.medizin.logbook.shared.CsvFileGeneratorEvent;
import ch.unibas.medizin.logbook.shared.CsvFileGeneratorListener;
import ch.unibas.medizin.logbook.shared.i18n.LogBookConstants;
import ch.unibas.medizin.logbook.shared.request.LogBookRequestFactory;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

import de.novanic.eventservice.client.event.RemoteEventService;
import de.novanic.eventservice.client.event.RemoteEventServiceFactory;
import de.novanic.eventservice.client.event.domain.Domain;
import de.novanic.eventservice.client.event.domain.DomainFactory;

public class AdminActivity extends AbstractActivity implements AdminView.presenter, AdminView.Delegate {

	private LogBookRequestFactory requests;

	private AcceptsOneWidget widget;

	private AdminView view;

	public HandlerManager handlerManager;

	private static final Domain DOMAIN = DomainFactory.getDomain("localhost");

	private CsvFileGeneratorServiceAsync csvFileGeneratorServiceService = GWT.create(CsvFileGeneratorService.class);

	LogBookConstants constants = GWT.create(LogBookConstants.class);

	public AdminActivity(LogBookRequestFactory requests, PlaceController placeController, LoginPlace loginPlace) {
		Log.info("Call Activity Login");

		this.requests = requests;
		handlerManager = loginPlace.handler;

	}

	public AdminActivity(LogBookRequestFactory requests, PlaceController placeController) {
		Log.info("Call Admin Activity");
		this.requests = requests;
	}

	@Override
	public void onStop() {
		widget.setWidget(null);
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		Log.info("SystemStartActivity.start()");
		widget = panel;
		init();

	}

	private void init() {
		AdminView systemStartView = new AdminViewImpl();
		systemStartView.setPresenter(this);
		view = systemStartView;

		widget.setWidget(systemStartView.asWidget());

		// Fix in default style( without it tab content will not show properly)
		Log.info("HTML :" + systemStartView.asWidget().getElement().getParentElement().getParentElement());
		systemStartView.asWidget().getElement().getParentElement().getParentElement().getStyle().setPosition(Position.RELATIVE);

		view.setDelegate(this);

		initAdminDetails();

	}

	private void initAdminDetails() {

		requests.administratorRequestNonRoo().findAdministratorFromSession().fire(new Receiver<AdministratorProxy>() {

			@Override
			public void onSuccess(AdministratorProxy response) {
				if (response != null) {
					view.getLblNameVal().setText(response.getName() != null ? response.getName() : "");
					view.getLblPrenameVal().setText(response.getPreName() != null ? response.getPreName() : "");
					view.getLblEmailVal().setText(response.getEmail() != null ? response.getEmail() : "");
				}

			}

			@Override
			public void onFailure(ServerFailure error) {
				Log.info("~~~~Error");
			}

			@Override
			public void onConstraintViolation(Set<ConstraintViolation<?>> violations) {
				Log.info("~~~~Error~~~~");
			}
		});

	}

	@Override
	public void goTo(Place place) {

	}

	@Override
	public void exportStudentClicked(boolean checkboxSelected) {

		showApplicationLoading(true);
		RemoteEventServiceFactory theEventServiceFactory = RemoteEventServiceFactory.getInstance();
		final RemoteEventService theEventService = theEventServiceFactory.getRemoteEventService();

		theEventService.addListener(DOMAIN, new CsvFileGeneratorListener() {
			@Override
			public void csvFileGeneratorEvent(CsvFileGeneratorEvent event) {
				if (event.getResult() == true) {

					showApplicationLoading(false);
					theEventService.removeListeners();
					String url = GWT.getHostPageBaseURL() + "exportCSV";
					Log.info("URL :" + url);
					Window.open(url, "", "");

				} else {
					showApplicationLoading(false);
					Log.info("Error during file generation");
				}

			}
		});

		csvFileGeneratorServiceService.csvFileGeneratorClicked(checkboxSelected, new AsyncCallback<Void>() {

			@Override
			public void onSuccess(Void result) {
				Log.info("Returened Response still file generation process is in execution");

			}

			@Override
			public void onFailure(Throwable caught) {
				showApplicationLoading(false);
				theEventService.removeListeners();
				Log.info("CsvFile generator  Request Failed Due to" + caught.getMessage());
				caught.printStackTrace();

			}
		});

	}

	public void showApplicationLoading(Boolean show) {
		requests.getEventBus().fireEvent(new ApplicationLoadingScreenEvent(show));

	}
}
