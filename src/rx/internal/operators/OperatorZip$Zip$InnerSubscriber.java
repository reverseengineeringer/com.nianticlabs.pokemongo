package rx.internal.operators;

import rx.Observer;
import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.RxRingBuffer;

final class OperatorZip$Zip$InnerSubscriber
  extends Subscriber
{
  final RxRingBuffer items = RxRingBuffer.getSpmcInstance();
  
  OperatorZip$Zip$InnerSubscriber(OperatorZip.Zip paramZip) {}
  
  public void onCompleted()
  {
    items.onCompleted();
    this$0.tick();
  }
  
  public void onError(Throwable paramThrowable)
  {
    OperatorZip.Zip.access$000(this$0).onError(paramThrowable);
  }
  
  public void onNext(Object paramObject)
  {
    try
    {
      items.onNext(paramObject);
      this$0.tick();
      return;
    }
    catch (MissingBackpressureException paramObject)
    {
      for (;;)
      {
        onError((Throwable)paramObject);
      }
    }
  }
  
  public void onStart()
  {
    request(RxRingBuffer.SIZE);
  }
  
  public void requestMore(long paramLong)
  {
    request(paramLong);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorZip.Zip.InnerSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */