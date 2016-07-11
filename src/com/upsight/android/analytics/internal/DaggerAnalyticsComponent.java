package com.upsight.android.analytics.internal;

import android.app.Application.ActivityLifecycleCallbacks;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.upsight.android.UpsightAnalyticsExtension;
import com.upsight.android.UpsightAnalyticsExtension_MembersInjector;
import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.UpsightAnalyticsApi;
import com.upsight.android.analytics.UpsightGooglePlayHelper;
import com.upsight.android.analytics.internal.association.AssociationManager;
import com.upsight.android.analytics.internal.association.AssociationModule;
import com.upsight.android.analytics.internal.association.AssociationModule_ProvideAssociationManagerFactory;
import com.upsight.android.analytics.internal.configuration.ConfigurationManager;
import com.upsight.android.analytics.internal.configuration.ConfigurationModule;
import com.upsight.android.analytics.internal.configuration.ConfigurationModule_ProvideConfigurationManagerFactory;
import com.upsight.android.analytics.internal.configuration.ConfigurationResponseParser;
import com.upsight.android.analytics.internal.configuration.ConfigurationResponseParser_Factory;
import com.upsight.android.analytics.internal.configuration.ManagerConfigParser;
import com.upsight.android.analytics.internal.configuration.ManagerConfigParser_Factory;
import com.upsight.android.analytics.internal.dispatcher.DispatchModule;
import com.upsight.android.analytics.internal.dispatcher.DispatchModule_ProvideDispatcherFactory;
import com.upsight.android.analytics.internal.dispatcher.Dispatcher;
import com.upsight.android.analytics.internal.dispatcher.delivery.DeliveryModule;
import com.upsight.android.analytics.internal.dispatcher.delivery.DeliveryModule_ProvideQueueBuilderFactory;
import com.upsight.android.analytics.internal.dispatcher.delivery.DeliveryModule_ProvideResponseVerifierFactory;
import com.upsight.android.analytics.internal.dispatcher.delivery.QueueBuilder;
import com.upsight.android.analytics.internal.dispatcher.delivery.ResponseParser_Factory;
import com.upsight.android.analytics.internal.dispatcher.delivery.SignatureVerifier;
import com.upsight.android.analytics.internal.dispatcher.routing.RouterBuilder;
import com.upsight.android.analytics.internal.dispatcher.routing.RoutingModule;
import com.upsight.android.analytics.internal.dispatcher.routing.RoutingModule_ProvideRouterBuilderFactory;
import com.upsight.android.analytics.internal.dispatcher.schema.SchemaModule;
import com.upsight.android.analytics.internal.dispatcher.schema.SchemaModule_ProvideSchemaSelectorBuilderFactory;
import com.upsight.android.analytics.internal.dispatcher.schema.SchemaSelectorBuilder;
import com.upsight.android.analytics.internal.provider.LocationTracker_Factory;
import com.upsight.android.analytics.internal.provider.OptOutStatus_Factory;
import com.upsight.android.analytics.internal.provider.ProviderModule;
import com.upsight.android.analytics.internal.provider.ProviderModule_ProvidesOptOutStatusFactory;
import com.upsight.android.analytics.internal.provider.ProviderModule_ProvidesUpsightLocationTrackerFactory;
import com.upsight.android.analytics.internal.provider.ProviderModule_ProvidesUpsightUserAttributesFactory;
import com.upsight.android.analytics.internal.provider.UserAttributes_Factory;
import com.upsight.android.analytics.internal.session.ActivityLifecycleTracker;
import com.upsight.android.analytics.internal.session.ActivityLifecycleTracker_Factory;
import com.upsight.android.analytics.internal.session.Clock;
import com.upsight.android.analytics.internal.session.LifecycleTrackerModule;
import com.upsight.android.analytics.internal.session.LifecycleTrackerModule_ProvideUpsightLifeCycleCallbacksFactory;
import com.upsight.android.analytics.internal.session.ManualTracker_Factory;
import com.upsight.android.analytics.internal.session.SessionManager;
import com.upsight.android.analytics.internal.session.SessionManagerImpl;
import com.upsight.android.analytics.internal.session.SessionModule;
import com.upsight.android.analytics.internal.session.SessionModule_ProvidesSessionManagerFactory;
import com.upsight.android.analytics.internal.session.SessionModule_ProvidesSessionManagerImplFactory;
import com.upsight.android.analytics.provider.UpsightLocationTracker;
import com.upsight.android.analytics.provider.UpsightOptOutStatus;
import com.upsight.android.analytics.provider.UpsightUserAttributes;
import com.upsight.android.internal.util.Opt;
import dagger.MembersInjector;
import dagger.internal.MembersInjectors;
import dagger.internal.ScopedProvider;
import javax.inject.Provider;
import rx.Scheduler;

public final class DaggerAnalyticsComponent
  implements AnalyticsComponent
{
  private Provider<ActivityLifecycleTracker> activityLifecycleTrackerProvider;
  private Provider<AnalyticsContext> analyticsContextProvider;
  private Provider<Analytics> analyticsProvider;
  private final com.upsight.android.analytics.internal.dispatcher.DaggerAnalyticsComponent_PackageProxy com_upsight_android_analytics_internal_dispatcher_Proxy = new com.upsight.android.analytics.internal.dispatcher.DaggerAnalyticsComponent_PackageProxy();
  private final com.upsight.android.analytics.internal.dispatcher.delivery.DaggerAnalyticsComponent_PackageProxy com_upsight_android_analytics_internal_dispatcher_delivery_Proxy = new com.upsight.android.analytics.internal.dispatcher.delivery.DaggerAnalyticsComponent_PackageProxy();
  private final com.upsight.android.analytics.internal.provider.DaggerAnalyticsComponent_PackageProxy com_upsight_android_analytics_internal_provider_Proxy = new com.upsight.android.analytics.internal.provider.DaggerAnalyticsComponent_PackageProxy();
  private final com.upsight.android.analytics.internal.session.DaggerAnalyticsComponent_PackageProxy com_upsight_android_analytics_internal_session_Proxy = new com.upsight.android.analytics.internal.session.DaggerAnalyticsComponent_PackageProxy();
  private Provider<ConfigurationResponseParser> configurationResponseParserProvider;
  private MembersInjector<DispatcherService> dispatcherServiceMembersInjector;
  private Provider<ManagerConfigParser> managerConfigParserProvider;
  private Provider<AssociationManager> provideAssociationManagerProvider;
  private Provider<Clock> provideClockProvider;
  private Provider<ObjectMapper> provideConfigMapperProvider;
  private Provider<ConfigurationManager> provideConfigurationManagerProvider;
  private Provider<Dispatcher> provideDispatcherProvider;
  private Provider<UpsightGooglePlayHelper> provideGooglePlayHelperProvider;
  private Provider<QueueBuilder> provideQueueBuilderProvider;
  private Provider<SignatureVerifier> provideResponseVerifierProvider;
  private Provider<RouterBuilder> provideRouterBuilderProvider;
  private Provider<Scheduler> provideSchedulingExecutorProvider;
  private Provider<SchemaSelectorBuilder> provideSchemaSelectorBuilderProvider;
  private Provider<Scheduler> provideSendingExecutorProvider;
  private Provider<Opt<Thread.UncaughtExceptionHandler>> provideUncaughtExceptionHandlerProvider;
  private Provider<UpsightAnalyticsApi> provideUpsightAnalyticsApiProvider;
  private Provider<UpsightContext> provideUpsightContextProvider;
  private Provider<Application.ActivityLifecycleCallbacks> provideUpsightLifeCycleCallbacksProvider;
  private Provider<UpsightOptOutStatus> providesOptOutStatusProvider;
  private Provider<SessionManagerImpl> providesSessionManagerImplProvider;
  private Provider<SessionManager> providesSessionManagerProvider;
  private Provider<UpsightLocationTracker> providesUpsightLocationTrackerProvider;
  private Provider<UpsightUserAttributes> providesUpsightUserAttributesProvider;
  private MembersInjector<UpsightAnalyticsExtension> upsightAnalyticsExtensionMembersInjector;
  
  static
  {
    if (!DaggerAnalyticsComponent.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private DaggerAnalyticsComponent(Builder paramBuilder)
  {
    assert (paramBuilder != null);
    initialize(paramBuilder);
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  private void initialize(Builder paramBuilder)
  {
    provideUncaughtExceptionHandlerProvider = ScopedProvider.create(BaseAnalyticsModule_ProvideUncaughtExceptionHandlerFactory.create(baseAnalyticsModule));
    provideUpsightContextProvider = ScopedProvider.create(BaseAnalyticsModule_ProvideUpsightContextFactory.create(baseAnalyticsModule));
    provideConfigMapperProvider = ScopedProvider.create(ConfigObjectMapperModule_ProvideConfigMapperFactory.create(configObjectMapperModule, provideUpsightContextProvider));
    com_upsight_android_analytics_internal_session_Proxy.configParserProvider = com.upsight.android.analytics.internal.session.ConfigParser_Factory.create(provideConfigMapperProvider);
    provideClockProvider = ScopedProvider.create(BaseAnalyticsModule_ProvideClockFactory.create(baseAnalyticsModule));
    providesSessionManagerImplProvider = ScopedProvider.create(SessionModule_ProvidesSessionManagerImplFactory.create(sessionModule, provideUpsightContextProvider, com_upsight_android_analytics_internal_session_Proxy.configParserProvider, provideClockProvider));
    providesSessionManagerProvider = ScopedProvider.create(SessionModule_ProvidesSessionManagerFactory.create(sessionModule, providesSessionManagerImplProvider));
    provideSchemaSelectorBuilderProvider = ScopedProvider.create(SchemaModule_ProvideSchemaSelectorBuilderFactory.create(schemaModule, provideUpsightContextProvider));
    provideAssociationManagerProvider = ScopedProvider.create(AssociationModule_ProvideAssociationManagerFactory.create(associationModule, provideUpsightContextProvider, provideClockProvider));
    com_upsight_android_analytics_internal_provider_Proxy.optOutStatusProvider = ScopedProvider.create(OptOutStatus_Factory.create(MembersInjectors.noOp(), provideUpsightContextProvider));
    providesOptOutStatusProvider = ScopedProvider.create(ProviderModule_ProvidesOptOutStatusFactory.create(providerModule, com_upsight_android_analytics_internal_provider_Proxy.optOutStatusProvider));
    com_upsight_android_analytics_internal_provider_Proxy.locationTrackerProvider = ScopedProvider.create(LocationTracker_Factory.create(MembersInjectors.noOp(), provideUpsightContextProvider));
    providesUpsightLocationTrackerProvider = ScopedProvider.create(ProviderModule_ProvidesUpsightLocationTrackerFactory.create(providerModule, com_upsight_android_analytics_internal_provider_Proxy.locationTrackerProvider));
    com_upsight_android_analytics_internal_provider_Proxy.userAttributesProvider = ScopedProvider.create(UserAttributes_Factory.create(MembersInjectors.noOp(), provideUpsightContextProvider));
    providesUpsightUserAttributesProvider = ScopedProvider.create(ProviderModule_ProvidesUpsightUserAttributesFactory.create(providerModule, com_upsight_android_analytics_internal_provider_Proxy.userAttributesProvider));
    provideGooglePlayHelperProvider = ScopedProvider.create(BaseAnalyticsModule_ProvideGooglePlayHelperFactory.create(baseAnalyticsModule, provideUpsightContextProvider));
    analyticsProvider = ScopedProvider.create(Analytics_Factory.create(provideUpsightContextProvider, providesSessionManagerProvider, provideSchemaSelectorBuilderProvider, provideAssociationManagerProvider, providesOptOutStatusProvider, providesUpsightLocationTrackerProvider, providesUpsightUserAttributesProvider, provideGooglePlayHelperProvider));
    provideUpsightAnalyticsApiProvider = ScopedProvider.create(AnalyticsApiModule_ProvideUpsightAnalyticsApiFactory.create(analyticsApiModule, analyticsProvider));
    com_upsight_android_analytics_internal_session_Proxy.manualTrackerProvider = ScopedProvider.create(ManualTracker_Factory.create(providesSessionManagerProvider, provideUpsightContextProvider));
    activityLifecycleTrackerProvider = ActivityLifecycleTracker_Factory.create(com_upsight_android_analytics_internal_session_Proxy.manualTrackerProvider);
    provideUpsightLifeCycleCallbacksProvider = ScopedProvider.create(LifecycleTrackerModule_ProvideUpsightLifeCycleCallbacksFactory.create(lifecycleTrackerModule, activityLifecycleTrackerProvider));
    upsightAnalyticsExtensionMembersInjector = UpsightAnalyticsExtension_MembersInjector.create(MembersInjectors.noOp(), provideUncaughtExceptionHandlerProvider, provideUpsightAnalyticsApiProvider, provideClockProvider, provideUpsightLifeCycleCallbacksProvider, provideAssociationManagerProvider);
    configurationResponseParserProvider = ScopedProvider.create(ConfigurationResponseParser_Factory.create(provideConfigMapperProvider, providesSessionManagerProvider));
    managerConfigParserProvider = ScopedProvider.create(ManagerConfigParser_Factory.create(provideConfigMapperProvider));
    provideConfigurationManagerProvider = ScopedProvider.create(ConfigurationModule_ProvideConfigurationManagerFactory.create(configurationModule, provideUpsightContextProvider, configurationResponseParserProvider, managerConfigParserProvider));
    analyticsContextProvider = AnalyticsContext_Factory.create(MembersInjectors.noOp(), provideUpsightContextProvider);
    com_upsight_android_analytics_internal_dispatcher_Proxy.configParserProvider = ScopedProvider.create(com.upsight.android.analytics.internal.dispatcher.ConfigParser_Factory.create(provideUpsightContextProvider, provideConfigMapperProvider));
    provideSendingExecutorProvider = ScopedProvider.create(AnalyticsSchedulersModule_ProvideSendingExecutorFactory.create(analyticsSchedulersModule));
    provideSchedulingExecutorProvider = ScopedProvider.create(AnalyticsSchedulersModule_ProvideSchedulingExecutorFactory.create(analyticsSchedulersModule));
    provideResponseVerifierProvider = ScopedProvider.create(DeliveryModule_ProvideResponseVerifierFactory.create(deliveryModule, provideUpsightContextProvider));
    com_upsight_android_analytics_internal_dispatcher_delivery_Proxy.responseParserProvider = ResponseParser_Factory.create(provideConfigMapperProvider);
    provideQueueBuilderProvider = ScopedProvider.create(DeliveryModule_ProvideQueueBuilderFactory.create(deliveryModule, provideUpsightContextProvider, provideClockProvider, provideSendingExecutorProvider, provideSchedulingExecutorProvider, provideResponseVerifierProvider, com_upsight_android_analytics_internal_dispatcher_delivery_Proxy.responseParserProvider));
    provideRouterBuilderProvider = ScopedProvider.create(RoutingModule_ProvideRouterBuilderFactory.create(routingModule, provideUpsightContextProvider, provideQueueBuilderProvider));
    provideDispatcherProvider = ScopedProvider.create(DispatchModule_ProvideDispatcherFactory.create(dispatchModule, provideUpsightContextProvider, providesSessionManagerProvider, analyticsContextProvider, com_upsight_android_analytics_internal_dispatcher_Proxy.configParserProvider, provideRouterBuilderProvider, provideSchemaSelectorBuilderProvider));
    dispatcherServiceMembersInjector = DispatcherService_MembersInjector.create(MembersInjectors.noOp(), provideConfigurationManagerProvider, provideDispatcherProvider);
  }
  
  public Clock clock()
  {
    return (Clock)provideClockProvider.get();
  }
  
  public void inject(UpsightAnalyticsExtension paramUpsightAnalyticsExtension)
  {
    upsightAnalyticsExtensionMembersInjector.injectMembers(paramUpsightAnalyticsExtension);
  }
  
  public void inject(DispatcherService paramDispatcherService)
  {
    dispatcherServiceMembersInjector.injectMembers(paramDispatcherService);
  }
  
  public SessionManager sessionManager()
  {
    return (SessionManager)providesSessionManagerProvider.get();
  }
  
  public static final class Builder
  {
    private AnalyticsApiModule analyticsApiModule;
    private AnalyticsModule analyticsModule;
    private AnalyticsSchedulersModule analyticsSchedulersModule;
    private AssociationModule associationModule;
    private BaseAnalyticsModule baseAnalyticsModule;
    private ConfigObjectMapperModule configObjectMapperModule;
    private ConfigurationModule configurationModule;
    private DeliveryModule deliveryModule;
    private DispatchModule dispatchModule;
    private LifecycleTrackerModule lifecycleTrackerModule;
    private ProviderModule providerModule;
    private RoutingModule routingModule;
    private SchemaModule schemaModule;
    private SessionModule sessionModule;
    
    public Builder analyticsApiModule(AnalyticsApiModule paramAnalyticsApiModule)
    {
      if (paramAnalyticsApiModule == null) {
        throw new NullPointerException("analyticsApiModule");
      }
      analyticsApiModule = paramAnalyticsApiModule;
      return this;
    }
    
    public Builder analyticsModule(AnalyticsModule paramAnalyticsModule)
    {
      if (paramAnalyticsModule == null) {
        throw new NullPointerException("analyticsModule");
      }
      analyticsModule = paramAnalyticsModule;
      return this;
    }
    
    public Builder analyticsSchedulersModule(AnalyticsSchedulersModule paramAnalyticsSchedulersModule)
    {
      if (paramAnalyticsSchedulersModule == null) {
        throw new NullPointerException("analyticsSchedulersModule");
      }
      analyticsSchedulersModule = paramAnalyticsSchedulersModule;
      return this;
    }
    
    public Builder associationModule(AssociationModule paramAssociationModule)
    {
      if (paramAssociationModule == null) {
        throw new NullPointerException("associationModule");
      }
      associationModule = paramAssociationModule;
      return this;
    }
    
    public Builder baseAnalyticsModule(BaseAnalyticsModule paramBaseAnalyticsModule)
    {
      if (paramBaseAnalyticsModule == null) {
        throw new NullPointerException("baseAnalyticsModule");
      }
      baseAnalyticsModule = paramBaseAnalyticsModule;
      return this;
    }
    
    public AnalyticsComponent build()
    {
      if (analyticsModule == null) {
        analyticsModule = new AnalyticsModule();
      }
      if (analyticsApiModule == null) {
        analyticsApiModule = new AnalyticsApiModule();
      }
      if (analyticsSchedulersModule == null) {
        analyticsSchedulersModule = new AnalyticsSchedulersModule();
      }
      if (configObjectMapperModule == null) {
        configObjectMapperModule = new ConfigObjectMapperModule();
      }
      if (dispatchModule == null) {
        dispatchModule = new DispatchModule();
      }
      if (deliveryModule == null) {
        deliveryModule = new DeliveryModule();
      }
      if (routingModule == null) {
        routingModule = new RoutingModule();
      }
      if (schemaModule == null) {
        schemaModule = new SchemaModule();
      }
      if (configurationModule == null) {
        configurationModule = new ConfigurationModule();
      }
      if (sessionModule == null) {
        sessionModule = new SessionModule();
      }
      if (lifecycleTrackerModule == null) {
        lifecycleTrackerModule = new LifecycleTrackerModule();
      }
      if (providerModule == null) {
        providerModule = new ProviderModule();
      }
      if (associationModule == null) {
        associationModule = new AssociationModule();
      }
      if (baseAnalyticsModule == null) {
        throw new IllegalStateException("baseAnalyticsModule must be set");
      }
      return new DaggerAnalyticsComponent(this, null);
    }
    
    public Builder configObjectMapperModule(ConfigObjectMapperModule paramConfigObjectMapperModule)
    {
      if (paramConfigObjectMapperModule == null) {
        throw new NullPointerException("configObjectMapperModule");
      }
      configObjectMapperModule = paramConfigObjectMapperModule;
      return this;
    }
    
    public Builder configurationModule(ConfigurationModule paramConfigurationModule)
    {
      if (paramConfigurationModule == null) {
        throw new NullPointerException("configurationModule");
      }
      configurationModule = paramConfigurationModule;
      return this;
    }
    
    public Builder deliveryModule(DeliveryModule paramDeliveryModule)
    {
      if (paramDeliveryModule == null) {
        throw new NullPointerException("deliveryModule");
      }
      deliveryModule = paramDeliveryModule;
      return this;
    }
    
    public Builder dispatchModule(DispatchModule paramDispatchModule)
    {
      if (paramDispatchModule == null) {
        throw new NullPointerException("dispatchModule");
      }
      dispatchModule = paramDispatchModule;
      return this;
    }
    
    public Builder lifecycleTrackerModule(LifecycleTrackerModule paramLifecycleTrackerModule)
    {
      if (paramLifecycleTrackerModule == null) {
        throw new NullPointerException("lifecycleTrackerModule");
      }
      lifecycleTrackerModule = paramLifecycleTrackerModule;
      return this;
    }
    
    public Builder providerModule(ProviderModule paramProviderModule)
    {
      if (paramProviderModule == null) {
        throw new NullPointerException("providerModule");
      }
      providerModule = paramProviderModule;
      return this;
    }
    
    public Builder routingModule(RoutingModule paramRoutingModule)
    {
      if (paramRoutingModule == null) {
        throw new NullPointerException("routingModule");
      }
      routingModule = paramRoutingModule;
      return this;
    }
    
    public Builder schemaModule(SchemaModule paramSchemaModule)
    {
      if (paramSchemaModule == null) {
        throw new NullPointerException("schemaModule");
      }
      schemaModule = paramSchemaModule;
      return this;
    }
    
    public Builder sessionModule(SessionModule paramSessionModule)
    {
      if (paramSessionModule == null) {
        throw new NullPointerException("sessionModule");
      }
      sessionModule = paramSessionModule;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.DaggerAnalyticsComponent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */