package rx.internal.operators;

import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;

class OnSubscribeTimerPeriodically$1
  implements Action0
{
  long counter;
  
  OnSubscribeTimerPeriodically$1(OnSubscribeTimerPeriodically paramOnSubscribeTimerPeriodically, Subscriber paramSubscriber, Scheduler.Worker paramWorker) {}
  
  public void call()
  {
    try
    {
      Subscriber localSubscriber = val$child;
      long l = counter;
      counter = (1L + l);
      localSubscriber.onNext(Long.valueOf(l));
      return;
    }
    catch (Throwable localThrowable)
    {
      try
      {
        val$child.onError(localThrowable);
        return;
      }
      finally
      {
        val$worker.unsubscribe();
      }
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeTimerPeriodically.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */