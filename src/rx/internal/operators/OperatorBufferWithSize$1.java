package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import rx.Producer;
import rx.Subscriber;

class OperatorBufferWithSize$1
  extends Subscriber<T>
{
  List<T> buffer;
  
  OperatorBufferWithSize$1(OperatorBufferWithSize paramOperatorBufferWithSize, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    List localList = buffer;
    buffer = null;
    if (localList != null) {}
    try
    {
      val$child.onNext(localList);
      val$child.onCompleted();
      return;
    }
    catch (Throwable localThrowable)
    {
      onError(localThrowable);
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    buffer = null;
    val$child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    if (buffer == null) {
      buffer = new ArrayList(this$0.count);
    }
    buffer.add(paramT);
    if (buffer.size() == this$0.count)
    {
      paramT = buffer;
      buffer = null;
      val$child.onNext(paramT);
    }
  }
  
  public void setProducer(final Producer paramProducer)
  {
    val$child.setProducer(new Producer()
    {
      private volatile boolean infinite = false;
      
      public void request(long paramAnonymousLong)
      {
        if (infinite) {
          return;
        }
        if (paramAnonymousLong >= Long.MAX_VALUE / this$0.count)
        {
          infinite = true;
          paramProducer.request(Long.MAX_VALUE);
          return;
        }
        paramProducer.request(this$0.count * paramAnonymousLong);
      }
    });
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorBufferWithSize.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */