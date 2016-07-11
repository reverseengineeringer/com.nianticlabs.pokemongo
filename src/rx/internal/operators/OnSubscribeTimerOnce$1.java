package rx.internal.operators;

import rx.Subscriber;
import rx.functions.Action0;

class OnSubscribeTimerOnce$1
  implements Action0
{
  OnSubscribeTimerOnce$1(OnSubscribeTimerOnce paramOnSubscribeTimerOnce, Subscriber paramSubscriber) {}
  
  public void call()
  {
    try
    {
      val$child.onNext(Long.valueOf(0L));
      val$child.onCompleted();
      return;
    }
    catch (Throwable localThrowable)
    {
      val$child.onError(localThrowable);
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeTimerOnce.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */