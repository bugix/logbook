package logbook.client.scaffold.place;

import com.google.gwt.place.impl.AbstractPlaceHistoryMapper;
import logbook.client.scaffold.place.ScaffoldPlaceHistoryMapper;
import logbook.client.scaffold.place.PlaceHistoryFactory;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.impl.AbstractPlaceHistoryMapper.PrefixAndToken;
import com.google.gwt.core.client.GWT;

public class ScaffoldPlaceHistoryMapperImpl extends AbstractPlaceHistoryMapper<PlaceHistoryFactory> implements ScaffoldPlaceHistoryMapper {
  
  protected PrefixAndToken getPrefixAndToken(Place newPlace) {
    if (newPlace instanceof logbook.client.scaffold.place.ProxyListPlace) {
      logbook.client.scaffold.place.ProxyListPlace place = (logbook.client.scaffold.place.ProxyListPlace) newPlace;
      return new PrefixAndToken("ProxyListPlace", factory.getProxyListPlaceTokenizer().getToken(place));
    }
    if (newPlace instanceof logbook.client.scaffold.place.ProxyPlace) {
      logbook.client.scaffold.place.ProxyPlace place = (logbook.client.scaffold.place.ProxyPlace) newPlace;
      return new PrefixAndToken("ProxyPlace", factory.getProxyPlaceTokenizer().getToken(place));
    }
    return null;
  }
  
  protected PlaceTokenizer<?> getTokenizer(String prefix) {
    if ("ProxyListPlace".equals(prefix)) {
      return factory.getProxyListPlaceTokenizer();
    }
    if ("ProxyPlace".equals(prefix)) {
      return factory.getProxyPlaceTokenizer();
    }
    return null;
  }

}
