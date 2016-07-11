package rx.internal.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.SerialSubscription;

public final class OnSubscribeJoin<TLeft, TRight, TLeftDuration, TRightDuration, R>
  implements Observable.OnSubscribe<R>
{
  final Observable<TLeft> left;
  final Func1<TLeft, Observable<TLeftDuration>> leftDurationSelector;
  final Func2<TLeft, TRight, R> resultSelector;
  final Observable<TRight> right;
  final Func1<TRight, Observable<TRightDuration>> rightDurationSelector;
  
  public OnSubscribeJoin(Observable<TLeft> paramObservable, Observable<TRight> paramObservable1, Func1<TLeft, Observable<TLeftDuration>> paramFunc1, Func1<TRight, Observable<TRightDuration>> paramFunc11, Func2<TLeft, TRight, R> paramFunc2)
  {
    left = paramObservable;
    right = paramObservable1;
    leftDurationSelector = paramFunc1;
    rightDurationSelector = paramFunc11;
    resultSelector = paramFunc2;
  }
  
  public void call(Subscriber<? super R> paramSubscriber)
  {
    new ResultSink(new SerializedSubscriber(paramSubscriber)).run();
  }
  
  final class ResultSink
  {
    final CompositeSubscription group;
    final Object guard = new Object();
    boolean leftDone;
    int leftId;
    final Map<Integer, TLeft> leftMap;
    boolean rightDone;
    int rightId;
    final Map<Integer, TRight> rightMap;
    final Subscriber<? super R> subscriber;
    
    public ResultSink()
    {
      Subscriber localSubscriber;
      subscriber = localSubscriber;
      group = new CompositeSubscription();
      leftMap = new HashMap();
      rightMap = new HashMap();
    }
    
    public void run()
    {
      subscriber.add(group);
      LeftSubscriber localLeftSubscriber = new LeftSubscriber();
      RightSubscriber localRightSubscriber = new RightSubscriber();
      group.add(localLeftSubscriber);
      group.add(localRightSubscriber);
      left.unsafeSubscribe(localLeftSubscriber);
      right.unsafeSubscribe(localRightSubscriber);
    }
    
    final class LeftSubscriber
      extends Subscriber<TLeft>
    {
      LeftSubscriber() {}
      
      protected void expire(int paramInt, Subscription paramSubscription)
      {
        int j = 0;
        Object localObject = guard;
        int i = j;
        try
        {
          if (leftMap.remove(Integer.valueOf(paramInt)) != null)
          {
            i = j;
            if (leftMap.isEmpty())
            {
              i = j;
              if (leftDone) {
                i = 1;
              }
            }
          }
          if (i != 0)
          {
            subscriber.onCompleted();
            subscriber.unsubscribe();
            return;
          }
        }
        finally {}
        group.remove(paramSubscription);
      }
      
      public void onCompleted()
      {
        for (int i = 0;; i = 1)
        {
          synchronized (guard)
          {
            leftDone = true;
            if ((rightDone) || (leftMap.isEmpty())) {
              continue;
            }
            if (i != 0)
            {
              subscriber.onCompleted();
              subscriber.unsubscribe();
              return;
            }
          }
          group.remove(this);
          return;
        }
      }
      
      public void onError(Throwable paramThrowable)
      {
        subscriber.onError(paramThrowable);
        subscriber.unsubscribe();
      }
      
      public void onNext(TLeft paramTLeft)
      {
        Object localObject2;
        synchronized (guard)
        {
          localObject2 = OnSubscribeJoin.ResultSink.this;
          int i = leftId;
          leftId = (i + 1);
          leftMap.put(Integer.valueOf(i), paramTLeft);
          int j = rightId;
          try
          {
            ??? = (Observable)leftDurationSelector.call(paramTLeft);
            localObject2 = new LeftDurationSubscriber(i);
            group.add((Subscription)localObject2);
            ((Observable)???).unsafeSubscribe((Subscriber)localObject2);
            localObject2 = new ArrayList();
            synchronized (guard)
            {
              Iterator localIterator = rightMap.entrySet().iterator();
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
          localObject2 = resultSelector.call(paramTLeft, localObject2);
          subscriber.onNext(localObject2);
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
    
    final class RightSubscriber
      extends Subscriber<TRight>
    {
      RightSubscriber() {}
      
      void expire(int paramInt, Subscription paramSubscription)
      {
        int j = 0;
        Object localObject = guard;
        int i = j;
        try
        {
          if (rightMap.remove(Integer.valueOf(paramInt)) != null)
          {
            i = j;
            if (rightMap.isEmpty())
            {
              i = j;
              if (rightDone) {
                i = 1;
              }
            }
          }
          if (i != 0)
          {
            subscriber.onCompleted();
            subscriber.unsubscribe();
            return;
          }
        }
        finally {}
        group.remove(paramSubscription);
      }
      
      public void onCompleted()
      {
        for (int i = 0;; i = 1)
        {
          synchronized (guard)
          {
            rightDone = true;
            if ((leftDone) || (rightMap.isEmpty())) {
              continue;
            }
            if (i != 0)
            {
              subscriber.onCompleted();
              subscriber.unsubscribe();
              return;
            }
          }
          group.remove(this);
          return;
        }
      }
      
      public void onError(Throwable paramThrowable)
      {
        subscriber.onError(paramThrowable);
        subscriber.unsubscribe();
      }
      
      public void onNext(TRight paramTRight)
      {
        Object localObject2;
        synchronized (guard)
        {
          localObject2 = OnSubscribeJoin.ResultSink.this;
          int i = rightId;
          rightId = (i + 1);
          rightMap.put(Integer.valueOf(i), paramTRight);
          int j = leftId;
          ??? = new SerialSubscription();
          group.add((Subscription)???);
          try
          {
            ??? = (Observable)rightDurationSelector.call(paramTRight);
            localObject2 = new RightDurationSubscriber(i);
            group.add((Subscription)localObject2);
            ((Observable)???).unsafeSubscribe((Subscriber)localObject2);
            localObject2 = new ArrayList();
            synchronized (guard)
            {
              Iterator localIterator = leftMap.entrySet().iterator();
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
          localObject2 = resultSelector.call(localObject2, paramTRight);
          subscriber.onNext(localObject2);
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
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OnSubscribeJoin
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */