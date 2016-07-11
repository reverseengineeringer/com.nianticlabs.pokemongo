package com.upsight.android.analytics.internal;

import com.upsight.android.analytics.internal.association.AssociationModule;
import com.upsight.android.analytics.internal.configuration.ConfigurationModule;
import com.upsight.android.analytics.internal.dispatcher.DispatchModule;
import com.upsight.android.analytics.internal.dispatcher.delivery.DeliveryModule;
import com.upsight.android.analytics.internal.dispatcher.routing.RoutingModule;
import com.upsight.android.analytics.internal.dispatcher.schema.SchemaModule;
import com.upsight.android.analytics.internal.provider.ProviderModule;
import com.upsight.android.analytics.internal.session.LifecycleTrackerModule;
import com.upsight.android.analytics.internal.session.SessionModule;

public final class DaggerAnalyticsComponent$Builder
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

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.DaggerAnalyticsComponent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */