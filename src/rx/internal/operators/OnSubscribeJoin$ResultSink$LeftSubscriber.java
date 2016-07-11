package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.subscriptions.CompositeSubscription;

final class OnSubscribeJoin$ResultSink$LeftSubscriber
  extends Subscriber<TLeft>
{
  OnSubscribeJoin$ResultSink$LeftSubscriber(OnSubscribeJoin.ResultSink paramResultSink) {}
  
  protected void expire(int paramInt, Subscription paramSubscription)
  {
    int j = 0;
    Object localObject = this$1.guard;
    int i = j;
    try
    {
      if (this$1.leftMap.remove(Integer.valueOf(paramInt)) != null)
      {
        i = j;
        if (this$1.leftMap.isEmpty())
        {
          i = j;
          if (this$1.leftDone) {
            i = 1;
          }
        }
      }
      if (i != 0)
      {
        this$1.subscriber.onCompleted();
        this$1.subscriber.unsubscribe();
        return;
      }
    }
    finally {}
    this$1.group.remove(paramSubscription);
  }
  
  public void onCompleted()
  {
    for (int i = 0;; i = 1)
    {
      synchronized (this$1.guard)
      {
        this$1.leftDone = true;
        if ((this$1.rightDone) || (this$1.leftMap.isEmpty())) {
          continue;
        }
        if (i != 0)
        {
          this$1.subscriber.onCompleted();
          this$1.subscriber.unsubscribe();
          return;
        }
      }
      this$1.group.remove(this);
      return;
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    this$1.subscriber.onError(paramThrowable);
    this$1.subscriber.unsubscribe();
  }
  
  public void onNext(TLeft paramTLeft)
  {
    Object localObject2;
    synchronized (this$1.guard)
    {
      localObject2 = this$1;
      int i = leftId;
      leftId = (i + 1);
      this$1.leftMap.put(Integer.valueOf(i), paramTLeft);
      int j = this$1.rightId;
      try
      {
        ??? = (Observable)this$1.this$0.leftDurationSelector.call(paramTLeft);
        localObject2 = new LeftDurationSubscriber(i);
        this$1.group.add((Subscription)localObject2);
        ((Observable)???).unsafeSubscribe((Subscriber)localObject2);
        localObject2 = new ArrayList();
        synchronized (this$1.guard)
        {
          Iterator localIterator = this$1.rightMap.entrySet().iterator();
          Map.Entry localEntry;
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localEntry = (Map.Entry)localIterator.next();
          } while (((Integer)localEntry.getKey()).intValue() >= j);
          ((List)localObject2).add(localEntry.getValue());
        }
        return;
      }
      catch (Throwable paramTLeft)
      {
        onError(paramTLeft);
      }
    }
    ??? = ((List)localObject2).iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = ((Iterator)???).next();
      localObject2 = this$1.this$0.resultSelector.call(paramTLeft, localObject2);
      this$1.subscriber.onNext(localObject2);
    }
  }
  
  final class LeftDurationSubscriber
    extends Subscriber<TLeftDuration>
  {
    final int id;
    boolean once = true;
    
    public LeftDurationSubscriber(int paramInt)
    {
      id = paramInt;
    }
    
    public void onCompleted()
    {
      if (once)
      {
        once = false;
        expire(id, this);
      }
    }
    
    public void onError(Throwable paramThrowable)
    {
      OnSubscribeJoin.ResultSink.LeftSubscriber.this.onError(paramThrowable);
    }
    
    public void onNext(TLeftDuration paramTLeftDuration)
    {
      onCompleted();
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeJoin.ResultSink.LeftSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */