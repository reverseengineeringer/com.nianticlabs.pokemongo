package rx.internal.operators;

import rx.Subscriber;

final class OperatorSwitch$SwitchSubscriber$InnerSubscriber
  extends Subscriber<T>
{
  private final int id;
  private final long initialRequested;
  private long requested = 0L;
  
  public OperatorSwitch$SwitchSubscriber$InnerSubscriber(OperatorSwitch.SwitchSubscriber paramSwitchSubscriber, int paramInt, long paramLong)
  {
    id = paramInt;
    initialRequested = paramLong;
  }
  
  public void onCompleted()
  {
    this$0.complete(id);
  }
  
  public void onError(Throwable paramThrowable)
  {
    this$0.error(paramThrowable, id);
  }
  
  public void onNext(T paramT)
  {
    this$0.emit(paramT, id, this);
  }
  
  public void onStart()
  {
    requestMore(initialRequested);
  }
  
  public void requestMore(long paramLong)
  {
    request(paramLong);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSwitch.SwitchSubscriber.InnerSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */