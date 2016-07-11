package com.upsight.android.analytics.internal.dispatcher;

import com.upsight.android.analytics.internal.dispatcher.routing.RoutingConfig;
import com.upsight.android.analytics.internal.dispatcher.schema.IdentifierConfig;

class Config
{
  private IdentifierConfig mIdentifierConfig;
  private RoutingConfig mRoutingConfig;
  
  private Config(Builder paramBuilder)
  {
    mRoutingConfig = mRoutingConfig;
    mIdentifierConfig = mIdentifierConfig;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (Config)paramObject;
      if (mIdentifierConfig != null)
      {
        if (mIdentifierConfig.equals(mIdentifierConfig)) {}
      }
      else {
        while (mIdentifierConfig != null) {
          return false;
        }
      }
      if (mRoutingConfig == null) {
        break;
      }
    } while (mRoutingConfig.equals(mRoutingConfig));
    for (;;)
    {
      return false;
      if (mRoutingConfig == null) {
        break;
      }
    }
  }
  
  public IdentifierConfig getIdentifierConfig()
  {
    return mIdentifierConfig;
  }
  
  public RoutingConfig getRoutingConfig()
  {
    return mRoutingConfig;
  }
  
  public int hashCode()
  {
    int j = 0;
    if (mRoutingConfig != null) {}
    for (int i = mRoutingConfig.hashCode();; i = 0)
    {
      if (mIdentifierConfig != null) {
        j = mIdentifierConfig.hashCode();
      }
      return i * 31 + j;
    }
  }
  
  public boolean isValid()
  {
    return (mRoutingConfig != null) && (mRoutingConfig.isValid());
  }
  
  public static class Builder
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
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.Config
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */