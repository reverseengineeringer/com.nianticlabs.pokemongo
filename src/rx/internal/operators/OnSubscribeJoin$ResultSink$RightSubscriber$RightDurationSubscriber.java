package rx.internal.operators;

import rx.Subscriber;

final class OnSubscribeJoin$ResultSink$RightSubscriber$RightDurationSubscriber
  extends Subscriber<TRightDuration>
{
  final int id;
  boolean once = true;
  
  public OnSubscribeJoin$ResultSink$RightSubscriber$RightDurationSubscriber(OnSubscribeJoin.ResultSink.RightSubscriber paramRightSubscriber, int paramInt)
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
  
  public void onNext(TRightDuration paramTRightDuration)
  {
    onCompleted();
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeJoin.ResultSink.RightSubscriber.RightDurationSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */