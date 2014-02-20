package ch.unibas.medizin.logbook.client.scaffold.ioc;

import ch.unibas.medizin.logbook.client.scaffold.ScaffoldMobileApp;

import com.google.gwt.inject.client.GinModules;

@GinModules(value = {ScaffoldModule.class})
public interface MobileInjector extends ScaffoldInjector {

	ScaffoldMobileApp getScaffoldApp();
}
