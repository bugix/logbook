package ch.unibas.medizin.logbook.client.a_nonroo.app.ioc;


import ch.unibas.medizin.logbook.client.a_nonroo.app.LogBookApplication;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules(value = {LogBookGinModule.class})
public interface LogBookInjector extends Ginjector {

	LogBookApplication getApplication();
}
