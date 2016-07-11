package com.upsight.android.analytics.internal.dispatcher.delivery;

import com.upsight.android.analytics.internal.dispatcher.schema.Schema;

class QueueBuilder$BatcherFactory
  implements Batcher.Factory
{
  private Batcher.Config mConfig;
  
  public QueueBuilder$BatcherFactory(QueueBuilder paramQueueBuilder, Batcher.Config paramConfig)
  {
    mConfig = paramConfig;
  }
  
  public Batcher create(Schema paramSchema, BatchSender paramBatchSender)
  {
    return new Batcher(mConfig, paramSchema, paramBatchSender, QueueBuilder.access$000(this$0));
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.delivery.QueueBuilder.BatcherFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */