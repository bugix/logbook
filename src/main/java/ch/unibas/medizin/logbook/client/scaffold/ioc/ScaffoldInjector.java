package ch.unibas.medizin.logbook.client.scaffold.ioc;

import ch.unibas.medizin.logbook.client.scaffold.ScaffoldApp;
import com.google.gwt.inject.client.Ginjector;

public interface ScaffoldInjector extends Ginjector {

	ScaffoldApp getScaffoldApp();
}
