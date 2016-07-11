package com.upsight.android.analytics.internal.dispatcher.delivery;

public class QueueConfig$Builder
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

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.delivery.QueueConfig.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */