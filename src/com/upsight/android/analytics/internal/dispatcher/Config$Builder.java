package com.upsight.android.analytics.internal.dispatcher;

import com.upsight.android.analytics.internal.dispatcher.routing.RoutingConfig;
import com.upsight.android.analytics.internal.dispatcher.schema.IdentifierConfig;

public class Config$Builder
{
  private IdentifierConfig mIdentifierConfig;
  private RoutingConfig mRoutingConfig;
  
  public Config build()
  {
    return new Config(this, null);
  }
  
  public Builder setIdentifierConfig(IdentifierConfig paramIdentifierConfig)
  {
    mIdentifierConfig = paramIdentifierConfig;
    return this;
  }
  
  public Builder setRoutingConfig(RoutingConfig paramRoutingConfig)
  {
    mRoutingConfig = paramRoutingConfig;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.Config.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */