package com.upsight.android.analytics.internal.dispatcher.delivery;

public class BatchSender$Config
{
  public final boolean countNetworkFail;
  public final int maxRetryCount;
  public final int retryInterval;
  
  public BatchSender$Config(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    countNetworkFail = paramBoolean;
    retryInterval = paramInt1;
    maxRetryCount = paramInt2;
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
    } while ((countNetworkFail == countNetworkFail) && (retryInterval == retryInterval) && (maxRetryCount == maxRetryCount));
    return false;
  }
  
  public boolean isValid()
  {
    return (retryInterval > 0) && (maxRetryCount >= 0);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.delivery.BatchSender.Config
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */