package com.upsight.android.analytics.internal;

import android.os.Handler;
import com.upsight.android.analytics.internal.dispatcher.Dispatcher;

class DispatcherService$1
  implements Runnable
{
  DispatcherService$1(DispatcherService paramDispatcherService) {}
  
  public void run()
  {
    if (this$0.mDispatcher.hasPendingRecords())
    {
      DispatcherService.access$002(this$0, 0);
      DispatcherService.access$200(this$0).postDelayed(DispatcherService.access$100(this$0), 25000L);
      return;
    }
    if (DispatcherService.access$000(this$0) == 4)
    {
      this$0.stopSelf();
      return;
    }
    DispatcherService.access$008(this$0);
    DispatcherService.access$200(this$0).postDelayed(DispatcherService.access$100(this$0), 25000L);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.DispatcherService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */