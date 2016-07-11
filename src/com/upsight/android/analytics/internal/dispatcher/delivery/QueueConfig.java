package com.upsight.android.analytics.internal.dispatcher.delivery;

import java.net.MalformedURLException;
import java.net.URL;

public class QueueConfig
{
  private BatchSender.Config mBatchSenderConfig;
  private Batcher.Config mBatcherConfig;
  private String mEndpointAddress;
  
  private QueueConfig(Builder paramBuilder)
  {
    mEndpointAddress = mEndpointAddress;
    mBatchSenderConfig = mBatchSenderConfig;
    mBatcherConfig = mBatcherConfig;
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
      paramObject = (QueueConfig)paramObject;
      if (mBatchSenderConfig != null)
      {
        if (mBatchSenderConfig.equals(mBatchSenderConfig)) {}
      }
      else {
        while (mBatchSenderConfig != null) {
          return false;
        }
      }
      if (mBatcherConfig != null)
      {
        if (mBatcherConfig.equals(mBatcherConfig)) {}
      }
      else {
        while (mBatcherConfig != null) {
          return false;
        }
      }
      if (mEndpointAddress == null) {
        break;
      }
    } while (mEndpointAddress.equals(mEndpointAddress));
    for (;;)
    {
      return false;
      if (mEndpointAddress == null) {
        break;
      }
    }
  }
  
  public BatchSender.Config getBatchSenderConfig()
  {
    return mBatchSenderConfig;
  }
  
  public Batcher.Config getBatcherConfig()
  {
    return mBatcherConfig;
  }
  
  public String getEndpointAddress()
  {
    return mEndpointAddress;
  }
  
  public int hashCode()
  {
    int k = 0;
    int i;
    if (mEndpointAddress != null)
    {
      i = mEndpointAddress.hashCode();
      if (mBatchSenderConfig == null) {
        break label64;
      }
    }
    label64:
    for (int j = mBatchSenderConfig.hashCode();; j = 0)
    {
      if (mBatcherConfig != null) {
        k = mBatcherConfig.hashCode();
      }
      return (i * 31 + j) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public boolean isValid()
  {
    boolean bool2 = false;
    try
    {
      new URL(mEndpointAddress);
      boolean bool1 = bool2;
      if (mBatcherConfig != null)
      {
        bool1 = bool2;
        if (mBatcherConfig.isValid())
        {
          bool1 = bool2;
          if (mBatchSenderConfig != null)
          {
            boolean bool3 = mBatchSenderConfig.isValid();
            bool1 = bool2;
            if (bool3) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    catch (MalformedURLException localMalformedURLException) {}
    return false;
  }
  
  public static class Builder
  {
    private BatchSender.Config mBatchSenderConfig;
    private Batcher.Config mBatcherConfig;
    private String mEndpointAddress;
    
    public QueueConfig build()
    {
      return new QueueConfig(this, null);
    }
    
    public Builder setBatchSenderConfig(BatchSender.Config paramConfig)
    {
      mBatchSenderConfig = paramConfig;
      return this;
    }
    
    public Builder setBatcherConfig(Batcher.Config paramConfig)
    {
      mBatcherConfig = paramConfig;
      return this;
    }
    
    public Builder setEndpointAddress(String paramString)
    {
      mEndpointAddress = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.delivery.QueueConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */