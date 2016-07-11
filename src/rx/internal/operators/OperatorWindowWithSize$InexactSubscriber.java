package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

final class OperatorWindowWithSize$InexactSubscriber
  extends Subscriber<T>
{
  final Subscriber<? super Observable<T>> child;
  final List<OperatorWindowWithSize.CountedSubject<T>> chunks = new LinkedList();
  int count;
  volatile boolean noWindow = true;
  
  public OperatorWindowWithSize$InexactSubscriber(Subscriber<? super Observable<T>> paramSubscriber)
  {
    Subscriber localSubscriber;
    child = localSubscriber;
  }
  
  OperatorWindowWithSize.CountedSubject<T> createCountedSubject()
  {
    BufferUntilSubscriber localBufferUntilSubscriber = BufferUntilSubscriber.create();
    return new OperatorWindowWithSize.CountedSubject(localBufferUntilSubscriber, localBufferUntilSubscriber);
  }
  
  void init()
  {
    child.add(Subscriptions.create(new Action0()
    {
      public void call()
      {
        if (noWindow) {
          unsubscribe();
        }
      }
    }));
    child.setProducer(new Producer()
    {
      public void request(long paramAnonymousLong)
      {
        if (paramAnonymousLong > 0L)
        {
          long l2 = paramAnonymousLong * this$0.size;
          long l1 = l2;
          if (l2 >>> 31 != 0L)
          {
            l1 = l2;
            if (l2 / paramAnonymousLong != this$0.size) {
              l1 = Long.MAX_VALUE;
            }
          }
          requestMore(l1);
        }
      }
    });
  }
  
  public void onCompleted()
  {
    Object localObject = new ArrayList(chunks);
    chunks.clear();
    noWindow = true;
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      nextconsumer.onCompleted();
    }
    child.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    Object localObject = new ArrayList(chunks);
    chunks.clear();
    noWindow = true;
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      nextconsumer.onError(paramThrowable);
    }
    child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    int i = count;
    count = (i + 1);
    if ((i % this$0.skip == 0) && (!child.isUnsubscribed()))
    {
      if (chunks.isEmpty()) {
        noWindow = false;
      }
      localObject = createCountedSubject();
      chunks.add(localObject);
      child.onNext(producer);
    }
    Object localObject = chunks.iterator();
    while (((Iterator)localObject).hasNext())
    {
      OperatorWindowWithSize.CountedSubject localCountedSubject = (OperatorWindowWithSize.CountedSubject)((Iterator)localObject).next();
      consumer.onNext(paramT);
      i = count + 1;
      count = i;
      if (i == this$0.size)
      {
        ((Iterator)localObject).remove();
        consumer.onCompleted();
      }
    }
    if (chunks.isEmpty())
    {
      noWindow = true;
      if (child.isUnsubscribed()) {
        unsubscribe();
      }
    }
  }
  
  void requestMore(long paramLong)
  {
    request(paramLong);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorWindowWithSize.InexactSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */