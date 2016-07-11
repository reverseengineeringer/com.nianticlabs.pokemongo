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
import rx.subscriptions.SerialSubscription;

final class OnSubscribeJoin$ResultSink$RightSubscriber
  extends Subscriber<TRight>
{
  OnSubscribeJoin$ResultSink$RightSubscriber(OnSubscribeJoin.ResultSink paramResultSink) {}
  
  void expire(int paramInt, Subscription paramSubscription)
  {
    int j = 0;
    Object localObject = this$1.guard;
    int i = j;
    try
    {
      if (this$1.rightMap.remove(Integer.valueOf(paramInt)) != null)
      {
        i = j;
        if (this$1.rightMap.isEmpty())
        {
          i = j;
          if (this$1.rightDone) {
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
        this$1.rightDone = true;
        if ((this$1.leftDone) || (this$1.rightMap.isEmpty())) {
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
  
  public void onNext(TRight paramTRight)
  {
    Object localObject2;
    synchronized (this$1.guard)
    {
      localObject2 = this$1;
      int i = rightId;
      rightId = (i + 1);
      this$1.rightMap.put(Integer.valueOf(i), paramTRight);
      int j = this$1.leftId;
      ??? = new SerialSubscription();
      this$1.group.add((Subscription)???);
      try
      {
        ??? = (Observable)this$1.this$0.rightDurationSelector.call(paramTRight);
        localObject2 = new RightDurationSubscriber(i);
        this$1.group.add((Subscription)localObject2);
        ((Observable)???).unsafeSubscribe((Subscriber)localObject2);
        localObject2 = new ArrayList();
        synchronized (this$1.guard)
        {
          Iterator localIterator = this$1.leftMap.entrySet().iterator();
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
      catch (Throwable paramTRight)
      {
        onError(paramTRight);
      }
    }
    ??? = ((List)localObject2).iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = ((Iterator)???).next();
      localObject2 = this$1.this$0.resultSelector.call(localObject2, paramTRight);
      this$1.subscriber.onNext(localObject2);
    }
  }
  
  final class RightDurationSubscriber
    extends Subscriber<TRightDuration>
  {
    final int id;
    boolean once = true;
    
    public RightDurationSubscriber(int paramInt)
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
      OnSubscribeJoin.ResultSink.RightSubscriber.this.onError(paramThrowable);
    }
    
    public void onNext(TRightDuration paramTRightDuration)
    {
      onCompleted();
    }
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeJoin.ResultSink.RightSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */