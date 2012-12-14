package logbook.client.managed.request;

public class ApplicationRequestFactoryImpl extends com.google.web.bindery.requestfactory.gwt.client.impl.AbstractClientRequestFactory implements logbook.client.managed.request.ApplicationRequestFactory {
  @com.google.web.bindery.autobean.shared.AutoBeanFactory.Category({com.google.web.bindery.requestfactory.shared.impl.EntityProxyCategory.class, com.google.web.bindery.requestfactory.shared.impl.ValueProxyCategory.class, com.google.web.bindery.requestfactory.shared.impl.BaseProxyCategory.class})
  @com.google.web.bindery.autobean.shared.AutoBeanFactory.NoWrap(com.google.web.bindery.requestfactory.shared.EntityProxyId.class)
  interface Factory extends com.google.web.bindery.autobean.shared.AutoBeanFactory {
    com.google.web.bindery.autobean.shared.AutoBean<com.google.web.bindery.requestfactory.shared.EntityProxy> com_google_web_bindery_requestfactory_shared_EntityProxy();
    com.google.web.bindery.autobean.shared.AutoBean<logbook.client.managed.proxy.MainClassificationProxy> logbook_client_managed_proxy_MainClassificationProxy();
  }
  public static Factory FACTORY;
  @Override public Factory getAutoBeanFactory() {
    if (FACTORY == null) {
      FACTORY = com.google.gwt.core.client.GWT.create(Factory.class);
    }
    return FACTORY;
  }
  public com.google.web.bindery.requestfactory.shared.LoggingRequestImpl loggingRequest() {
    return new com.google.web.bindery.requestfactory.shared.LoggingRequestImpl(this);
  }
  public logbook.client.managed.request.MainClassificationRequestImpl mainClassificationRequest() {
    return new logbook.client.managed.request.MainClassificationRequestImpl(this);
  }
  private static final java.util.HashMap<String, Class<?>> tokensToTypes = new java.util.HashMap<String, Class<?>>();
  private static final java.util.HashMap<Class<?>, String> typesToTokens = new java.util.HashMap<Class<?>, String>();
  private static final java.util.HashSet<Class<?>> entityProxyTypes = new java.util.HashSet<Class<?>>();
  private static final java.util.HashSet<Class<?>> valueProxyTypes = new java.util.HashSet<Class<?>>();
  static {
    tokensToTypes.put("w1Qg$YHpDaNcHrR5HZ$23y518nA=", com.google.web.bindery.requestfactory.shared.EntityProxy.class);
    typesToTokens.put(com.google.web.bindery.requestfactory.shared.EntityProxy.class, "w1Qg$YHpDaNcHrR5HZ$23y518nA=");
    entityProxyTypes.add(com.google.web.bindery.requestfactory.shared.EntityProxy.class);
    tokensToTypes.put("A6afo7ZrCJjElKMctWUKWwb97tQ=", logbook.client.managed.proxy.MainClassificationProxy.class);
    typesToTokens.put(logbook.client.managed.proxy.MainClassificationProxy.class, "A6afo7ZrCJjElKMctWUKWwb97tQ=");
    entityProxyTypes.add(logbook.client.managed.proxy.MainClassificationProxy.class);
  }
  @Override public String getFactoryTypeToken() {
    return "logbook.client.managed.request.ApplicationRequestFactory";
  }
  @Override protected Class getTypeFromToken(String typeToken) {
    return tokensToTypes.get(typeToken);
  }
  @Override protected String getTypeToken(Class type) {
    return typesToTokens.get(type);
  }
  @Override public boolean isEntityType(Class<?> type) {
    return entityProxyTypes.contains(type);
  }
  @Override public boolean isValueType(Class<?> type) {
    return valueProxyTypes.contains(type);
  }
}
