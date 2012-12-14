package com.google.web.bindery.requestfactory.shared;

public class LoggingRequestImpl extends com.google.web.bindery.requestfactory.shared.impl.AbstractRequestContext implements com.google.web.bindery.requestfactory.shared.LoggingRequest {
  public LoggingRequestImpl(com.google.web.bindery.requestfactory.shared.impl.AbstractRequestFactory requestFactory) {super(requestFactory, com.google.web.bindery.requestfactory.shared.impl.AbstractRequestContext.Dialect.STANDARD);}
  @com.google.web.bindery.autobean.shared.AutoBeanFactory.Category({com.google.web.bindery.requestfactory.shared.impl.EntityProxyCategory.class, com.google.web.bindery.requestfactory.shared.impl.ValueProxyCategory.class, com.google.web.bindery.requestfactory.shared.impl.BaseProxyCategory.class})
  @com.google.web.bindery.autobean.shared.AutoBeanFactory.NoWrap(com.google.web.bindery.requestfactory.shared.EntityProxyId.class)
  interface Factory extends com.google.web.bindery.autobean.shared.AutoBeanFactory {
  }
  public static Factory FACTORY;
  @Override public Factory getAutoBeanFactory() {
    if (FACTORY == null) {
      FACTORY = com.google.gwt.core.client.GWT.create(Factory.class);
    }
    return FACTORY;
  }
  public  com.google.web.bindery.requestfactory.shared.Request<java.lang.Void> logMessage(final java.lang.String serializedLogRecordString) {
    class X extends com.google.web.bindery.requestfactory.shared.impl.AbstractRequest<java.lang.Void> implements com.google.web.bindery.requestfactory.shared.Request<java.lang.Void> {
      public X() { super(LoggingRequestImpl.this);}
      @Override public X with(String... paths) {super.with(paths); return this;}
      @Override protected com.google.web.bindery.requestfactory.shared.impl.RequestData makeRequestData() {
        return new com.google.web.bindery.requestfactory.shared.impl.RequestData("Rvm1kRBIqadzRZRDxLBeb__sHZw=", new Object[] {serializedLogRecordString}, propertyRefs, java.lang.Void.class, null);
      }
    }
    X x = new X();
    addInvocation(x);
    return x;
  }
}
