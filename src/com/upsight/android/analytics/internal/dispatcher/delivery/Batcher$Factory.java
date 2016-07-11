package com.upsight.android.analytics.internal.dispatcher.delivery;

import com.upsight.android.analytics.internal.dispatcher.schema.Schema;

public abstract interface Batcher$Factory
{
  public abstract Batcher create(Schema paramSchema, BatchSender paramBatchSender);
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.delivery.Batcher.Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */