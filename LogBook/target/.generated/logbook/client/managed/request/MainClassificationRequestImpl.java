package logbook.client.managed.request;

public class MainClassificationRequestImpl extends com.google.web.bindery.requestfactory.shared.impl.AbstractRequestContext implements logbook.client.managed.request.MainClassificationRequest {
  public MainClassificationRequestImpl(com.google.web.bindery.requestfactory.shared.impl.AbstractRequestFactory requestFactory) {super(requestFactory, com.google.web.bindery.requestfactory.shared.impl.AbstractRequestContext.Dialect.STANDARD);}
  @com.google.web.bindery.autobean.shared.AutoBeanFactory.Category({com.google.web.bindery.requestfactory.shared.impl.EntityProxyCategory.class, com.google.web.bindery.requestfactory.shared.impl.ValueProxyCategory.class, com.google.web.bindery.requestfactory.shared.impl.BaseProxyCategory.class})
  @com.google.web.bindery.autobean.shared.AutoBeanFactory.NoWrap(com.google.web.bindery.requestfactory.shared.EntityProxyId.class)
  interface Factory extends com.google.web.bindery.autobean.shared.AutoBeanFactory {
    com.google.web.bindery.autobean.shared.AutoBean<logbook.client.managed.proxy.MainClassificationProxy> logbook_client_managed_proxy_MainClassificationProxy();
  }
  public static Factory FACTORY;
  @Override public Factory getAutoBeanFactory() {
    if (FACTORY == null) {
      FACTORY = com.google.gwt.core.client.GWT.create(Factory.class);
    }
    return FACTORY;
  }
  public  com.google.web.bindery.requestfactory.shared.Request<java.lang.Long> countMainClassifications() {
    class X extends com.google.web.bindery.requestfactory.shared.impl.AbstractRequest<java.lang.Long> implements com.google.web.bindery.requestfactory.shared.Request<java.lang.Long> {
      public X() { super(MainClassificationRequestImpl.this);}
      @Override public X with(String... paths) {super.with(paths); return this;}
      @Override protected com.google.web.bindery.requestfactory.shared.impl.RequestData makeRequestData() {
        return new com.google.web.bindery.requestfactory.shared.impl.RequestData("D5u$aZBjv$BJDgR4kZIOE$_2dpQ=", new Object[] {}, propertyRefs, java.lang.Long.class, null);
      }
    }
    X x = new X();
    addInvocation(x);
    return x;
  }
  public  com.google.web.bindery.requestfactory.shared.Request<java.util.List<logbook.client.managed.proxy.MainClassificationProxy>> findAllMainClassifications() {
    class X extends com.google.web.bindery.requestfactory.shared.impl.AbstractRequest<java.util.List<logbook.client.managed.proxy.MainClassificationProxy>> implements com.google.web.bindery.requestfactory.shared.Request<java.util.List<logbook.client.managed.proxy.MainClassificationProxy>> {
      public X() { super(MainClassificationRequestImpl.this);}
      @Override public X with(String... paths) {super.with(paths); return this;}
      @Override protected com.google.web.bindery.requestfactory.shared.impl.RequestData makeRequestData() {
        return new com.google.web.bindery.requestfactory.shared.impl.RequestData("vhh_tI$7gFR93rnMqHZoveA4TSs=", new Object[] {}, propertyRefs, java.util.List.class, logbook.client.managed.proxy.MainClassificationProxy.class);
      }
    }
    X x = new X();
    addInvocation(x);
    return x;
  }
  public  com.google.web.bindery.requestfactory.shared.Request<logbook.client.managed.proxy.MainClassificationProxy> findMainClassification(final java.lang.Long id) {
    class X extends com.google.web.bindery.requestfactory.shared.impl.AbstractRequest<logbook.client.managed.proxy.MainClassificationProxy> implements com.google.web.bindery.requestfactory.shared.Request<logbook.client.managed.proxy.MainClassificationProxy> {
      public X() { super(MainClassificationRequestImpl.this);}
      @Override public X with(String... paths) {super.with(paths); return this;}
      @Override protected com.google.web.bindery.requestfactory.shared.impl.RequestData makeRequestData() {
        return new com.google.web.bindery.requestfactory.shared.impl.RequestData("bnc4yU7er1ZffuiUJkfUcJy5PKM=", new Object[] {id}, propertyRefs, logbook.client.managed.proxy.MainClassificationProxy.class, null);
      }
    }
    X x = new X();
    addInvocation(x);
    return x;
  }
  public  com.google.web.bindery.requestfactory.shared.Request<java.util.List<logbook.client.managed.proxy.MainClassificationProxy>> findMainClassificationEntries(final int firstResult,final int maxResults) {
    class X extends com.google.web.bindery.requestfactory.shared.impl.AbstractRequest<java.util.List<logbook.client.managed.proxy.MainClassificationProxy>> implements com.google.web.bindery.requestfactory.shared.Request<java.util.List<logbook.client.managed.proxy.MainClassificationProxy>> {
      public X() { super(MainClassificationRequestImpl.this);}
      @Override public X with(String... paths) {super.with(paths); return this;}
      @Override protected com.google.web.bindery.requestfactory.shared.impl.RequestData makeRequestData() {
        return new com.google.web.bindery.requestfactory.shared.impl.RequestData("6$ab3e4SO_xQtVghKCQVtZt1W8s=", new Object[] {firstResult,maxResults}, propertyRefs, java.util.List.class, logbook.client.managed.proxy.MainClassificationProxy.class);
      }
    }
    X x = new X();
    addInvocation(x);
    return x;
  }
  public  com.google.web.bindery.requestfactory.shared.InstanceRequest<logbook.client.managed.proxy.MainClassificationProxy, java.lang.Void> persist() {
    class X extends com.google.web.bindery.requestfactory.shared.impl.AbstractRequest<java.lang.Void> implements com.google.web.bindery.requestfactory.shared.InstanceRequest<logbook.client.managed.proxy.MainClassificationProxy, java.lang.Void> {
      public X() { super(MainClassificationRequestImpl.this);}
      @Override public X with(String... paths) {super.with(paths); return this;}
      @Override protected com.google.web.bindery.requestfactory.shared.impl.RequestData makeRequestData() {
        return new com.google.web.bindery.requestfactory.shared.impl.RequestData("fihp2TOXDJTSIzF4_5J3F5Zj718=", new Object[] {null}, propertyRefs, java.lang.Void.class, null);
      }
    }
    X x = new X();
    return x;
  }
  public  com.google.web.bindery.requestfactory.shared.InstanceRequest<logbook.client.managed.proxy.MainClassificationProxy, java.lang.Void> remove() {
    class X extends com.google.web.bindery.requestfactory.shared.impl.AbstractRequest<java.lang.Void> implements com.google.web.bindery.requestfactory.shared.InstanceRequest<logbook.client.managed.proxy.MainClassificationProxy, java.lang.Void> {
      public X() { super(MainClassificationRequestImpl.this);}
      @Override public X with(String... paths) {super.with(paths); return this;}
      @Override protected com.google.web.bindery.requestfactory.shared.impl.RequestData makeRequestData() {
        return new com.google.web.bindery.requestfactory.shared.impl.RequestData("KKvPXBJFtpu0zjqD1e$AjehGTA4=", new Object[] {null}, propertyRefs, java.lang.Void.class, null);
      }
    }
    X x = new X();
    return x;
  }
}
