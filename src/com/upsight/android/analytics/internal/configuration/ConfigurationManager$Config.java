package com.upsight.android.analytics.internal.configuration;

public final class ConfigurationManager$Config
{
  public final long requestInterval;
  
  ConfigurationManager$Config(long paramLong)
  {
    requestInterval = paramLong;
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
    } while (requestInterval == requestInterval);
    return false;
  }
  
  public boolean isValid()
  {
    return requestInterval > 0L;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.configuration.ConfigurationManager.Config
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */