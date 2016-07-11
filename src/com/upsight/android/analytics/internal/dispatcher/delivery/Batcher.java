package com.upsight.android.analytics.internal.dispatcher.delivery;

import com.upsight.android.analytics.internal.dispatcher.routing.Packet;
import com.upsight.android.analytics.internal.dispatcher.schema.Schema;
import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;

public class Batcher
{
  private static final int DISABLE_AGING_MAX_AGE = 0;
  private Scheduler mAgingExecutor;
  private Action0 mAgingRunnable = new Action0()
  {
    public void call()
    {
      Batcher.this.sendCurrentBatch();
    }
  };
  private Subscription mAgingTask;
  private BatchSender mBatchSender;
  private Config mConfig;
  private Batch mCurrentBatch;
  private Schema mSchema;
  
  Batcher(Config paramConfig, Schema paramSchema, BatchSender paramBatchSender, Scheduler paramScheduler)
  {
    mSchema = paramSchema;
    mBatchSender = paramBatchSender;
    mConfig = paramConfig;
    mAgingExecutor = paramScheduler;
  }
  
  private void sendCurrentBatch()
  {
    try
    {
      Batch localBatch = mCurrentBatch;
      if (localBatch != null)
      {
        mCurrentBatch = null;
        if (mAgingTask != null)
        {
          mAgingTask.unsubscribe();
          mAgingTask = null;
        }
        mBatchSender.submitRequest(new BatchSender.Request(localBatch, mSchema));
      }
      return;
    }
    finally {}
  }
  
  public void addPacket(Packet paramPacket)
  {
    try
    {
      if (mCurrentBatch == null)
      {
        mCurrentBatch = new Batch(mConfig.batchCapacity);
        if (mConfig.maxBatchAge != 0) {
          mAgingTask = mAgingExecutor.createWorker().schedule(mAgingRunnable, mConfig.maxBatchAge, TimeUnit.SECONDS);
        }
      }
      mCurrentBatch.addPacket(paramPacket);
      if (mCurrentBatch.capacityLeft() == 0) {
        sendCurrentBatch();
      }
      return;
    }
    finally {}
  }
  
  public static class Config
  {
    public final int batchCapacity;
    public final int maxBatchAge;
    
    public Config(int paramInt1, int paramInt2)
    {
      batchCapacity = paramInt1;
      maxBatchAge = paramInt2;
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
      } while ((batchCapacity == batchCapacity) && (maxBatchAge == maxBatchAge));
      return false;
    }
    
    public boolean isValid()
    {
      return (maxBatchAge >= 0) && (batchCapacity > 0);
    }
  }
  
  public static abstract interface Factory
  {
    public abstract Batcher create(Schema paramSchema, BatchSender paramBatchSender);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.delivery.Batcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */