package com.upsight.android.analytics.internal.dispatcher.delivery;

import rx.functions.Action0;

class BatchSender$1
  implements Action0
{
  BatchSender$1(BatchSender paramBatchSender, BatchSender.Request paramRequest) {}
  
  public void call()
  {
    new BatchSender.BatchSendTask(this$0, val$request).run();
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.delivery.BatchSender.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */