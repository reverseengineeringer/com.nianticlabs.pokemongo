package com.upsight.android.analytics.internal.dispatcher.delivery;

class BatchSender$RetryTask
  implements Runnable
{
  private BatchSender.Request mRequest;
  
  public BatchSender$RetryTask(BatchSender paramBatchSender, BatchSender.Request paramRequest)
  {
    mRequest = paramRequest;
  }
  
  public void run()
  {
    this$0.submitRequest(mRequest);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.delivery.BatchSender.RetryTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */