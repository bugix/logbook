package logbook.client.scaffold.ioc;

import com.google.gwt.core.client.GWT;

public class DesktopInjectorImpl implements logbook.client.scaffold.ioc.DesktopInjector {
  public logbook.client.scaffold.ScaffoldDesktopApp getScaffoldApp() {
    return get_Key$type$logbook$client$scaffold$ScaffoldDesktopApp$_annotation$$none$$();
  }
  
  
  /**
   * Binding for com.google.gwt.event.shared.SimpleEventBus declared at:
   *   Implicit binding for Key[type=com.google.gwt.event.shared.SimpleEventBus, annotation=[none]]
   */
  private void memberInject_Key$type$com$google$gwt$event$shared$SimpleEventBus$_annotation$$none$$(com.google.gwt.event.shared.SimpleEventBus injectee) {
    
  }
  
  private com.google.gwt.event.shared.SimpleEventBus create_Key$type$com$google$gwt$event$shared$SimpleEventBus$_annotation$$none$$() {
    Object created = GWT.create(com.google.gwt.event.shared.SimpleEventBus.class);
    assert created instanceof com.google.gwt.event.shared.SimpleEventBus;
    com.google.gwt.event.shared.SimpleEventBus result = (com.google.gwt.event.shared.SimpleEventBus) created;
    
    memberInject_Key$type$com$google$gwt$event$shared$SimpleEventBus$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.google.gwt.event.shared.SimpleEventBus declared at:
   *   Implicit binding for Key[type=com.google.gwt.event.shared.SimpleEventBus, annotation=[none]]
   */
  private com.google.gwt.event.shared.SimpleEventBus get_Key$type$com$google$gwt$event$shared$SimpleEventBus$_annotation$$none$$() {
    return create_Key$type$com$google$gwt$event$shared$SimpleEventBus$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.google.gwt.place.shared.PlaceController declared at:
   *   logbook.client.scaffold.ioc.ScaffoldModule.configure(ScaffoldModule.java:21)
   */
  private com.google.gwt.place.shared.PlaceController create_Key$type$com$google$gwt$place$shared$PlaceController$_annotation$$none$$() {
    return get_Key$type$logbook$client$scaffold$ioc$ScaffoldModule$PlaceControllerProvider$_annotation$$none$$().get();
  }
  
  private com.google.gwt.place.shared.PlaceController singleton_Key$type$com$google$gwt$place$shared$PlaceController$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   logbook.client.scaffold.ioc.ScaffoldModule.configure(ScaffoldModule.java:21)
   */
  private com.google.gwt.place.shared.PlaceController get_Key$type$com$google$gwt$place$shared$PlaceController$_annotation$$none$$() {
    if (singleton_Key$type$com$google$gwt$place$shared$PlaceController$_annotation$$none$$ == null) {
      singleton_Key$type$com$google$gwt$place$shared$PlaceController$_annotation$$none$$ = create_Key$type$com$google$gwt$place$shared$PlaceController$_annotation$$none$$();
    }
    return singleton_Key$type$com$google$gwt$place$shared$PlaceController$_annotation$$none$$;
  }
  
  
  /**
   * Binding for logbook.client.managed.activity.ApplicationMasterActivities declared at:
   *   Implicit binding for Key[type=logbook.client.managed.activity.ApplicationMasterActivities, annotation=[none]]
   */
  private void memberInject_Key$type$logbook$client$managed$activity$ApplicationMasterActivities$_annotation$$none$$(logbook.client.managed.activity.ApplicationMasterActivities injectee) {
    
  }
  
  private logbook.client.managed.activity.ApplicationMasterActivities logbook$client$managed$activity$ApplicationMasterActivities_ApplicationMasterActivities_methodInjection(logbook.client.managed.request.ApplicationRequestFactory _0, com.google.gwt.place.shared.PlaceController _1) {
    return new logbook.client.managed.activity.ApplicationMasterActivities(_0, _1);
  }
  
  private logbook.client.managed.activity.ApplicationMasterActivities create_Key$type$logbook$client$managed$activity$ApplicationMasterActivities$_annotation$$none$$() {
    logbook.client.managed.activity.ApplicationMasterActivities result = logbook$client$managed$activity$ApplicationMasterActivities_ApplicationMasterActivities_methodInjection(get_Key$type$logbook$client$managed$request$ApplicationRequestFactory$_annotation$$none$$(), get_Key$type$com$google$gwt$place$shared$PlaceController$_annotation$$none$$());
    memberInject_Key$type$logbook$client$managed$activity$ApplicationMasterActivities$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for logbook.client.managed.activity.ApplicationMasterActivities declared at:
   *   Implicit binding for Key[type=logbook.client.managed.activity.ApplicationMasterActivities, annotation=[none]]
   */
  private logbook.client.managed.activity.ApplicationMasterActivities get_Key$type$logbook$client$managed$activity$ApplicationMasterActivities$_annotation$$none$$() {
    return create_Key$type$logbook$client$managed$activity$ApplicationMasterActivities$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for logbook.client.scaffold.ioc.ScaffoldModule$RequestFactoryProvider declared at:
   *   Implicit binding for Key[type=logbook.client.scaffold.ioc.ScaffoldModule$RequestFactoryProvider, annotation=[none]]
   */
  private void memberInject_Key$type$logbook$client$scaffold$ioc$ScaffoldModule$RequestFactoryProvider$_annotation$$none$$(logbook.client.scaffold.ioc.ScaffoldModule.RequestFactoryProvider injectee) {
    
  }
  
  private native logbook.client.scaffold.ioc.ScaffoldModule.RequestFactoryProvider logbook$client$scaffold$ioc$ScaffoldModule$RequestFactoryProvider_RequestFactoryProvider_methodInjection(com.google.gwt.event.shared.EventBus _0) /*-{
    return @logbook.client.scaffold.ioc.ScaffoldModule.RequestFactoryProvider::new(Lcom/google/gwt/event/shared/EventBus;)(_0);
  }-*/;
  
  private logbook.client.scaffold.ioc.ScaffoldModule.RequestFactoryProvider create_Key$type$logbook$client$scaffold$ioc$ScaffoldModule$RequestFactoryProvider$_annotation$$none$$() {
    logbook.client.scaffold.ioc.ScaffoldModule.RequestFactoryProvider result = logbook$client$scaffold$ioc$ScaffoldModule$RequestFactoryProvider_RequestFactoryProvider_methodInjection(get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$());
    memberInject_Key$type$logbook$client$scaffold$ioc$ScaffoldModule$RequestFactoryProvider$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for logbook.client.scaffold.ioc.ScaffoldModule$RequestFactoryProvider declared at:
   *   Implicit binding for Key[type=logbook.client.scaffold.ioc.ScaffoldModule$RequestFactoryProvider, annotation=[none]]
   */
  private logbook.client.scaffold.ioc.ScaffoldModule.RequestFactoryProvider get_Key$type$logbook$client$scaffold$ioc$ScaffoldModule$RequestFactoryProvider$_annotation$$none$$() {
    return create_Key$type$logbook$client$scaffold$ioc$ScaffoldModule$RequestFactoryProvider$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.google.gwt.event.shared.EventBus declared at:
   *   logbook.client.scaffold.ioc.ScaffoldModule.configure(ScaffoldModule.java:19)
   */
  private com.google.gwt.event.shared.EventBus create_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$() {
    return get_Key$type$com$google$gwt$event$shared$SimpleEventBus$_annotation$$none$$();
  }
  
  private com.google.gwt.event.shared.EventBus singleton_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   logbook.client.scaffold.ioc.ScaffoldModule.configure(ScaffoldModule.java:19)
   */
  private com.google.gwt.event.shared.EventBus get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$() {
    if (singleton_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$ == null) {
      singleton_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$ = create_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$();
    }
    return singleton_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$;
  }
  
  
  /**
   * Binding for logbook.client.scaffold.gae.GaeHelper declared at:
   *   Implicit binding for Key[type=logbook.client.scaffold.gae.GaeHelper, annotation=[none]]
   */
  private void memberInject_Key$type$logbook$client$scaffold$gae$GaeHelper$_annotation$$none$$(logbook.client.scaffold.gae.GaeHelper injectee) {
    
  }
  
  private logbook.client.scaffold.gae.GaeHelper logbook$client$scaffold$gae$GaeHelper_GaeHelper_methodInjection(logbook.client.scaffold.ScaffoldDesktopShell _0, logbook.client.managed.request.ApplicationRequestFactory _1, com.google.gwt.event.shared.EventBus _2) {
    return new logbook.client.scaffold.gae.GaeHelper(_0, _1, _2);
  }
  
  private logbook.client.scaffold.gae.GaeHelper create_Key$type$logbook$client$scaffold$gae$GaeHelper$_annotation$$none$$() {
    logbook.client.scaffold.gae.GaeHelper result = logbook$client$scaffold$gae$GaeHelper_GaeHelper_methodInjection(get_Key$type$logbook$client$scaffold$ScaffoldDesktopShell$_annotation$$none$$(), get_Key$type$logbook$client$managed$request$ApplicationRequestFactory$_annotation$$none$$(), get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$());
    memberInject_Key$type$logbook$client$scaffold$gae$GaeHelper$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for logbook.client.scaffold.gae.GaeHelper declared at:
   *   Implicit binding for Key[type=logbook.client.scaffold.gae.GaeHelper, annotation=[none]]
   */
  private logbook.client.scaffold.gae.GaeHelper get_Key$type$logbook$client$scaffold$gae$GaeHelper$_annotation$$none$$() {
    return create_Key$type$logbook$client$scaffold$gae$GaeHelper$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for logbook.client.scaffold.ScaffoldDesktopShell declared at:
   *   Implicit binding for Key[type=logbook.client.scaffold.ScaffoldDesktopShell, annotation=[none]]
   */
  private void memberInject_Key$type$logbook$client$scaffold$ScaffoldDesktopShell$_annotation$$none$$(logbook.client.scaffold.ScaffoldDesktopShell injectee) {
    
  }
  
  private logbook.client.scaffold.ScaffoldDesktopShell create_Key$type$logbook$client$scaffold$ScaffoldDesktopShell$_annotation$$none$$() {
    Object created = GWT.create(logbook.client.scaffold.ScaffoldDesktopShell.class);
    assert created instanceof logbook.client.scaffold.ScaffoldDesktopShell;
    logbook.client.scaffold.ScaffoldDesktopShell result = (logbook.client.scaffold.ScaffoldDesktopShell) created;
    
    memberInject_Key$type$logbook$client$scaffold$ScaffoldDesktopShell$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for logbook.client.scaffold.ScaffoldDesktopShell declared at:
   *   Implicit binding for Key[type=logbook.client.scaffold.ScaffoldDesktopShell, annotation=[none]]
   */
  private logbook.client.scaffold.ScaffoldDesktopShell get_Key$type$logbook$client$scaffold$ScaffoldDesktopShell$_annotation$$none$$() {
    return create_Key$type$logbook$client$scaffold$ScaffoldDesktopShell$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for logbook.client.managed.activity.ApplicationDetailsActivities declared at:
   *   Implicit binding for Key[type=logbook.client.managed.activity.ApplicationDetailsActivities, annotation=[none]]
   */
  private void memberInject_Key$type$logbook$client$managed$activity$ApplicationDetailsActivities$_annotation$$none$$(logbook.client.managed.activity.ApplicationDetailsActivities injectee) {
    
  }
  
  private logbook.client.managed.activity.ApplicationDetailsActivities logbook$client$managed$activity$ApplicationDetailsActivities_ApplicationDetailsActivities_methodInjection(logbook.client.managed.request.ApplicationRequestFactory _0, com.google.gwt.place.shared.PlaceController _1) {
    return new logbook.client.managed.activity.ApplicationDetailsActivities(_0, _1);
  }
  
  private logbook.client.managed.activity.ApplicationDetailsActivities create_Key$type$logbook$client$managed$activity$ApplicationDetailsActivities$_annotation$$none$$() {
    logbook.client.managed.activity.ApplicationDetailsActivities result = logbook$client$managed$activity$ApplicationDetailsActivities_ApplicationDetailsActivities_methodInjection(get_Key$type$logbook$client$managed$request$ApplicationRequestFactory$_annotation$$none$$(), get_Key$type$com$google$gwt$place$shared$PlaceController$_annotation$$none$$());
    memberInject_Key$type$logbook$client$managed$activity$ApplicationDetailsActivities$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for logbook.client.managed.activity.ApplicationDetailsActivities declared at:
   *   Implicit binding for Key[type=logbook.client.managed.activity.ApplicationDetailsActivities, annotation=[none]]
   */
  private logbook.client.managed.activity.ApplicationDetailsActivities get_Key$type$logbook$client$managed$activity$ApplicationDetailsActivities$_annotation$$none$$() {
    return create_Key$type$logbook$client$managed$activity$ApplicationDetailsActivities$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for logbook.client.scaffold.place.PlaceHistoryFactory declared at:
   *   Implicit binding for Key[type=logbook.client.scaffold.place.PlaceHistoryFactory, annotation=[none]]
   */
  private void memberInject_Key$type$logbook$client$scaffold$place$PlaceHistoryFactory$_annotation$$none$$(logbook.client.scaffold.place.PlaceHistoryFactory injectee) {
    
  }
  
  private logbook.client.scaffold.place.PlaceHistoryFactory logbook$client$scaffold$place$PlaceHistoryFactory_PlaceHistoryFactory_methodInjection(logbook.client.managed.request.ApplicationRequestFactory _0) {
    return new logbook.client.scaffold.place.PlaceHistoryFactory(_0);
  }
  
  private logbook.client.scaffold.place.PlaceHistoryFactory create_Key$type$logbook$client$scaffold$place$PlaceHistoryFactory$_annotation$$none$$() {
    logbook.client.scaffold.place.PlaceHistoryFactory result = logbook$client$scaffold$place$PlaceHistoryFactory_PlaceHistoryFactory_methodInjection(get_Key$type$logbook$client$managed$request$ApplicationRequestFactory$_annotation$$none$$());
    memberInject_Key$type$logbook$client$scaffold$place$PlaceHistoryFactory$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for logbook.client.scaffold.place.PlaceHistoryFactory declared at:
   *   Implicit binding for Key[type=logbook.client.scaffold.place.PlaceHistoryFactory, annotation=[none]]
   */
  private logbook.client.scaffold.place.PlaceHistoryFactory get_Key$type$logbook$client$scaffold$place$PlaceHistoryFactory$_annotation$$none$$() {
    return create_Key$type$logbook$client$scaffold$place$PlaceHistoryFactory$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for logbook.client.scaffold.ioc.ScaffoldModule$PlaceControllerProvider declared at:
   *   Implicit binding for Key[type=logbook.client.scaffold.ioc.ScaffoldModule$PlaceControllerProvider, annotation=[none]]
   */
  private void memberInject_Key$type$logbook$client$scaffold$ioc$ScaffoldModule$PlaceControllerProvider$_annotation$$none$$(logbook.client.scaffold.ioc.ScaffoldModule.PlaceControllerProvider injectee) {
    
  }
  
  private native logbook.client.scaffold.ioc.ScaffoldModule.PlaceControllerProvider logbook$client$scaffold$ioc$ScaffoldModule$PlaceControllerProvider_PlaceControllerProvider_methodInjection(com.google.gwt.event.shared.EventBus _0) /*-{
    return @logbook.client.scaffold.ioc.ScaffoldModule.PlaceControllerProvider::new(Lcom/google/gwt/event/shared/EventBus;)(_0);
  }-*/;
  
  private logbook.client.scaffold.ioc.ScaffoldModule.PlaceControllerProvider create_Key$type$logbook$client$scaffold$ioc$ScaffoldModule$PlaceControllerProvider$_annotation$$none$$() {
    logbook.client.scaffold.ioc.ScaffoldModule.PlaceControllerProvider result = logbook$client$scaffold$ioc$ScaffoldModule$PlaceControllerProvider_PlaceControllerProvider_methodInjection(get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$());
    memberInject_Key$type$logbook$client$scaffold$ioc$ScaffoldModule$PlaceControllerProvider$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for logbook.client.scaffold.ioc.ScaffoldModule$PlaceControllerProvider declared at:
   *   Implicit binding for Key[type=logbook.client.scaffold.ioc.ScaffoldModule$PlaceControllerProvider, annotation=[none]]
   */
  private logbook.client.scaffold.ioc.ScaffoldModule.PlaceControllerProvider get_Key$type$logbook$client$scaffold$ioc$ScaffoldModule$PlaceControllerProvider$_annotation$$none$$() {
    return create_Key$type$logbook$client$scaffold$ioc$ScaffoldModule$PlaceControllerProvider$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for logbook.client.managed.request.ApplicationRequestFactory declared at:
   *   logbook.client.scaffold.ioc.ScaffoldModule.configure(ScaffoldModule.java:20)
   */
  private logbook.client.managed.request.ApplicationRequestFactory create_Key$type$logbook$client$managed$request$ApplicationRequestFactory$_annotation$$none$$() {
    return get_Key$type$logbook$client$scaffold$ioc$ScaffoldModule$RequestFactoryProvider$_annotation$$none$$().get();
  }
  
  private logbook.client.managed.request.ApplicationRequestFactory singleton_Key$type$logbook$client$managed$request$ApplicationRequestFactory$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   logbook.client.scaffold.ioc.ScaffoldModule.configure(ScaffoldModule.java:20)
   */
  private logbook.client.managed.request.ApplicationRequestFactory get_Key$type$logbook$client$managed$request$ApplicationRequestFactory$_annotation$$none$$() {
    if (singleton_Key$type$logbook$client$managed$request$ApplicationRequestFactory$_annotation$$none$$ == null) {
      singleton_Key$type$logbook$client$managed$request$ApplicationRequestFactory$_annotation$$none$$ = create_Key$type$logbook$client$managed$request$ApplicationRequestFactory$_annotation$$none$$();
    }
    return singleton_Key$type$logbook$client$managed$request$ApplicationRequestFactory$_annotation$$none$$;
  }
  
  
  /**
   * Binding for logbook.client.scaffold.ScaffoldDesktopApp declared at:
   *   Implicit binding for Key[type=logbook.client.scaffold.ScaffoldDesktopApp, annotation=[none]]
   */
  private void memberInject_Key$type$logbook$client$scaffold$ScaffoldDesktopApp$_annotation$$none$$(logbook.client.scaffold.ScaffoldDesktopApp injectee) {
    
  }
  
  private logbook.client.scaffold.ScaffoldDesktopApp logbook$client$scaffold$ScaffoldDesktopApp_ScaffoldDesktopApp_methodInjection(logbook.client.scaffold.ScaffoldDesktopShell _0, logbook.client.managed.request.ApplicationRequestFactory _1, com.google.gwt.event.shared.EventBus _2, com.google.gwt.place.shared.PlaceController _3, logbook.client.scaffold.place.PlaceHistoryFactory _4, logbook.client.managed.activity.ApplicationMasterActivities _5, logbook.client.managed.activity.ApplicationDetailsActivities _6, logbook.client.scaffold.gae.GaeHelper _7) {
    return new logbook.client.scaffold.ScaffoldDesktopApp(_0, _1, _2, _3, _4, _5, _6, _7);
  }
  
  private logbook.client.scaffold.ScaffoldDesktopApp create_Key$type$logbook$client$scaffold$ScaffoldDesktopApp$_annotation$$none$$() {
    logbook.client.scaffold.ScaffoldDesktopApp result = logbook$client$scaffold$ScaffoldDesktopApp_ScaffoldDesktopApp_methodInjection(get_Key$type$logbook$client$scaffold$ScaffoldDesktopShell$_annotation$$none$$(), get_Key$type$logbook$client$managed$request$ApplicationRequestFactory$_annotation$$none$$(), get_Key$type$com$google$gwt$event$shared$EventBus$_annotation$$none$$(), get_Key$type$com$google$gwt$place$shared$PlaceController$_annotation$$none$$(), get_Key$type$logbook$client$scaffold$place$PlaceHistoryFactory$_annotation$$none$$(), get_Key$type$logbook$client$managed$activity$ApplicationMasterActivities$_annotation$$none$$(), get_Key$type$logbook$client$managed$activity$ApplicationDetailsActivities$_annotation$$none$$(), get_Key$type$logbook$client$scaffold$gae$GaeHelper$_annotation$$none$$());
    memberInject_Key$type$logbook$client$scaffold$ScaffoldDesktopApp$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for logbook.client.scaffold.ScaffoldDesktopApp declared at:
   *   Implicit binding for Key[type=logbook.client.scaffold.ScaffoldDesktopApp, annotation=[none]]
   */
  private logbook.client.scaffold.ScaffoldDesktopApp get_Key$type$logbook$client$scaffold$ScaffoldDesktopApp$_annotation$$none$$() {
    return create_Key$type$logbook$client$scaffold$ScaffoldDesktopApp$_annotation$$none$$();
  }
  
  
  public DesktopInjectorImpl() {
    
  }
  
}
