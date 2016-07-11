package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.Producer;
import rx.Subscriber;

class OperatorBufferWithSize$2
  extends Subscriber<T>
{
  final List<List<T>> chunks = new LinkedList();
  int index;
  
  OperatorBufferWithSize$2(OperatorBufferWithSize paramOperatorBufferWithSize, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    try
    {
      Iterator localIterator = chunks.iterator();
      while (localIterator.hasNext())
      {
        List localList = (List)localIterator.next();
        try
        {
          val$child.onNext(localList);
        }
        catch (Throwable localThrowable)
        {
          onError(localThrowable);
          return;
        }
      }
      val$child.onCompleted();
      return;
    }
    finally
    {
      chunks.clear();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    chunks.clear();
    val$child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    int i = index;
    index = (i + 1);
    if (i % this$0.skip == 0) {
      chunks.add(new ArrayList(this$0.count));
    }
    Iterator localIterator = chunks.iterator();
    while (localIterator.hasNext())
    {
      List localList = (List)localIterator.next();
      localList.add(paramT);
      if (localList.size() == this$0.count)
      {
        localIterator.remove();
        val$child.onNext(localList);
      }
    }
  }
  
  public void setProducer(final Producer paramProducer)
  {
    val$child.setProducer(new Producer()
    {
      private volatile boolean firstRequest = true;
      private volatile boolean infinite = false;
      
      private void requestInfinite()
      {
        infinite = true;
        paramProducer.request(Long.MAX_VALUE);
      }
      
      public void request(long paramAnonymousLong)
      {
        if (paramAnonymousLong == 0L) {}
        do
        {
          return;
          if (paramAnonymousLong < 0L) {
            throw new IllegalArgumentException("request a negative number: " + paramAnonymousLong);
          }
        } while (infinite);
        if (paramAnonymousLong == Long.MAX_VALUE)
        {
          requestInfinite();
          return;
        }
        if (firstRequest)
        {
          firstRequest = false;
          if (paramAnonymousLong - 1L >= (Long.MAX_VALUE - this$0.count) / this$0.skip)
          {
            requestInfinite();
            return;
          }
          paramProducer.request(this$0.count + this$0.skip * (paramAnonymousLong - 1L));
          return;
        }
        if (paramAnonymousLong >= Long.MAX_VALUE / this$0.skip)
        {
          requestInfinite();
          return;
        }
        paramProducer.request(this$0.skip * paramAnonymousLong);
      }
    });
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorBufferWithSize.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */