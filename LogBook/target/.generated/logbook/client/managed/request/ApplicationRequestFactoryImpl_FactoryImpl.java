package logbook.client.managed.request;

public class ApplicationRequestFactoryImpl_FactoryImpl extends com.google.web.bindery.autobean.gwt.client.impl.AbstractAutoBeanFactory implements logbook.client.managed.request.ApplicationRequestFactoryImpl.Factory {
  @Override protected void initializeCreatorMap(com.google.web.bindery.autobean.gwt.client.impl.JsniCreatorMap map) {
    map.add(com.google.web.bindery.requestfactory.shared.EntityProxy.class, getConstructors_com_google_web_bindery_requestfactory_shared_EntityProxy());
    map.add(logbook.client.managed.proxy.MainClassificationProxy.class, getConstructors_logbook_client_managed_proxy_MainClassificationProxy());
  }
  private native com.google.gwt.core.client.JsArray<com.google.gwt.core.client.JavaScriptObject> getConstructors_com_google_web_bindery_requestfactory_shared_EntityProxy() /*-{
    return [
      @com.google.web.bindery.requestfactory.shared.EntityProxyAutoBean_com_google_web_bindery_requestfactory_shared_impl_EntityProxyCategory_com_google_web_bindery_requestfactory_shared_impl_ValueProxyCategory_com_google_web_bindery_requestfactory_shared_impl_BaseProxyCategory::new(Lcom/google/web/bindery/autobean/shared/AutoBeanFactory;),
      @com.google.web.bindery.requestfactory.shared.EntityProxyAutoBean_com_google_web_bindery_requestfactory_shared_impl_EntityProxyCategory_com_google_web_bindery_requestfactory_shared_impl_ValueProxyCategory_com_google_web_bindery_requestfactory_shared_impl_BaseProxyCategory::new(Lcom/google/web/bindery/autobean/shared/AutoBeanFactory;Lcom/google/web/bindery/requestfactory/shared/EntityProxy;)
    ];
  }-*/;
  private native com.google.gwt.core.client.JsArray<com.google.gwt.core.client.JavaScriptObject> getConstructors_logbook_client_managed_proxy_MainClassificationProxy() /*-{
    return [
      @logbook.client.managed.proxy.MainClassificationProxyAutoBean_com_google_web_bindery_requestfactory_shared_impl_EntityProxyCategory_com_google_web_bindery_requestfactory_shared_impl_ValueProxyCategory_com_google_web_bindery_requestfactory_shared_impl_BaseProxyCategory::new(Lcom/google/web/bindery/autobean/shared/AutoBeanFactory;),
      @logbook.client.managed.proxy.MainClassificationProxyAutoBean_com_google_web_bindery_requestfactory_shared_impl_EntityProxyCategory_com_google_web_bindery_requestfactory_shared_impl_ValueProxyCategory_com_google_web_bindery_requestfactory_shared_impl_BaseProxyCategory::new(Lcom/google/web/bindery/autobean/shared/AutoBeanFactory;Llogbook/client/managed/proxy/MainClassificationProxy;)
    ];
  }-*/;
  private native com.google.gwt.core.client.JsArray<com.google.gwt.core.client.JavaScriptObject> getConstructors_com_google_web_bindery_requestfactory_shared_EntityProxyId() /*-{
    return [
      @com.google.web.bindery.requestfactory.shared.EntityProxyIdAutoBean_com_google_web_bindery_requestfactory_shared_impl_EntityProxyCategory_com_google_web_bindery_requestfactory_shared_impl_ValueProxyCategory_com_google_web_bindery_requestfactory_shared_impl_BaseProxyCategory::new(Lcom/google/web/bindery/autobean/shared/AutoBeanFactory;),
      @com.google.web.bindery.requestfactory.shared.EntityProxyIdAutoBean_com_google_web_bindery_requestfactory_shared_impl_EntityProxyCategory_com_google_web_bindery_requestfactory_shared_impl_ValueProxyCategory_com_google_web_bindery_requestfactory_shared_impl_BaseProxyCategory::new(Lcom/google/web/bindery/autobean/shared/AutoBeanFactory;Lcom/google/web/bindery/requestfactory/shared/EntityProxyId;)
    ];
  }-*/;
  @Override protected void initializeEnumMap() {
  }
  public com.google.web.bindery.autobean.shared.AutoBean com_google_web_bindery_requestfactory_shared_EntityProxy() {
    return new com.google.web.bindery.requestfactory.shared.EntityProxyAutoBean_com_google_web_bindery_requestfactory_shared_impl_EntityProxyCategory_com_google_web_bindery_requestfactory_shared_impl_ValueProxyCategory_com_google_web_bindery_requestfactory_shared_impl_BaseProxyCategory(ApplicationRequestFactoryImpl_FactoryImpl.this);
  }
  public com.google.web.bindery.autobean.shared.AutoBean logbook_client_managed_proxy_MainClassificationProxy() {
    return new logbook.client.managed.proxy.MainClassificationProxyAutoBean_com_google_web_bindery_requestfactory_shared_impl_EntityProxyCategory_com_google_web_bindery_requestfactory_shared_impl_ValueProxyCategory_com_google_web_bindery_requestfactory_shared_impl_BaseProxyCategory(ApplicationRequestFactoryImpl_FactoryImpl.this);
  }
}
