package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.Observable;
import rx.Observable.Operator;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

public final class OperatorWindowWithSize<T>
  implements Observable.Operator<Observable<T>, T>
{
  final int size;
  final int skip;
  
  public OperatorWindowWithSize(int paramInt1, int paramInt2)
  {
    size = paramInt1;
    skip = paramInt2;
  }
  
  public Subscriber<? super T> call(Subscriber<? super Observable<T>> paramSubscriber)
  {
    if (skip == size)
    {
      paramSubscriber = new ExactSubscriber(paramSubscriber);
      paramSubscriber.init();
      return paramSubscriber;
    }
    paramSubscriber = new InexactSubscriber(paramSubscriber);
    paramSubscriber.init();
    return paramSubscriber;
  }
  
  static final class CountedSubject<T>
  {
    final Observer<T> consumer;
    int count;
    final Observable<T> producer;
    
    public CountedSubject(Observer<T> paramObserver, Observable<T> paramObservable)
    {
      consumer = paramObserver;
      producer = paramObservable;
    }
  }
  
  final class ExactSubscriber
    extends Subscriber<T>
  {
    final Subscriber<? super Observable<T>> child;
    int count;
    volatile boolean noWindow = true;
    BufferUntilSubscriber<T> window;
    
    public ExactSubscriber()
    {
      Subscriber localSubscriber;
      child = localSubscriber;
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
            long l2 = paramAnonymousLong * size;
            long l1 = l2;
            if (l2 >>> 31 != 0L)
            {
              l1 = l2;
              if (l2 / paramAnonymousLong != size) {
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
      if (window != null) {
        window.onCompleted();
      }
      child.onCompleted();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (window != null) {
        window.onError(paramThrowable);
      }
      child.onError(paramThrowable);
    }
    
    public void onNext(T paramT)
    {
      if (window == null)
      {
        noWindow = false;
        window = BufferUntilSubscriber.create();
        child.onNext(window);
      }
      window.onNext(paramT);
      int i = count + 1;
      count = i;
      if (i % size == 0)
      {
        window.onCompleted();
        window = null;
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
  
  final class InexactSubscriber
    extends Subscriber<T>
  {
    final Subscriber<? super Observable<T>> child;
    final List<OperatorWindowWithSize.CountedSubject<T>> chunks = new LinkedList();
    int count;
    volatile boolean noWindow = true;
    
    public InexactSubscriber()
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
            long l2 = paramAnonymousLong * size;
            long l1 = l2;
            if (l2 >>> 31 != 0L)
            {
              l1 = l2;
              if (l2 / paramAnonymousLong != size) {
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
      if ((i % skip == 0) && (!child.isUnsubscribed()))
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
        if (i == size)
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
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorWindowWithSize
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */