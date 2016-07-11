package rx.internal.operators;

import rx.Subscriber;

final class OnSubscribeJoin$ResultSink$LeftSubscriber$LeftDurationSubscriber
  extends Subscriber<TLeftDuration>
{
  final int id;
  boolean once = true;
  
  public OnSubscribeJoin$ResultSink$LeftSubscriber$LeftDurationSubscriber(OnSubscribeJoin.ResultSink.LeftSubscriber paramLeftSubscriber, int paramInt)
  {
    id = paramInt;
  }
  
  public void onCompleted()
  {
    if (once)
    {
      once = false;
      this$2.expire(id, this);
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    this$2.onError(paramThrowable);
  }
  
  public void onNext(TLeftDuration paramTLeftDuration)
  {
    onCompleted();
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeJoin.ResultSink.LeftSubscriber.LeftDurationSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */