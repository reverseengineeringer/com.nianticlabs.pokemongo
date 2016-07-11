package com.upsight.android.analytics.internal.dispatcher.delivery;

import rx.functions.Action0;

class BatchSender$2
  implements Action0
{
  BatchSender$2(BatchSender paramBatchSender, BatchSender.Request paramRequest) {}
  
  public void call()
  {
    new BatchSender.RetryTask(this$0, val$request).run();
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.delivery.BatchSender.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */