package rx.observables;

import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.internal.operators.BlockingOperatorLatest;
import rx.internal.operators.BlockingOperatorMostRecent;
import rx.internal.operators.BlockingOperatorNext;
import rx.internal.operators.BlockingOperatorToFuture;
import rx.internal.operators.BlockingOperatorToIterator;
import rx.internal.util.UtilityFunctions;

public final class BlockingObservable<T>
{
  private final Observable<? extends T> o;
  
  private BlockingObservable(Observable<? extends T> paramObservable)
  {
    o = paramObservable;
  }
  
  private T blockForSingle(Observable<? extends T> paramObservable)
  {
    final AtomicReference localAtomicReference1 = new AtomicReference();
    final AtomicReference localAtomicReference2 = new AtomicReference();
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    paramObservable = paramObservable.subscribe(new Subscriber()
    {
      public void onCompleted()
      {
        localCountDownLatch.countDown();
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        localAtomicReference2.set(paramAnonymousThrowable);
        localCountDownLatch.countDown();
      }
      
      public void onNext(T paramAnonymousT)
      {
        localAtomicReference1.set(paramAnonymousT);
      }
    });
    try
    {
      localCountDownLatch.await();
      if (localAtomicReference2.get() == null) {
        break label112;
      }
      if ((localAtomicReference2.get() instanceof RuntimeException)) {
        throw ((RuntimeException)localAtomicReference2.get());
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      paramObservable.unsubscribe();
      Thread.currentThread().interrupt();
      throw new RuntimeException("Interrupted while waiting for subscription to complete.", localInterruptedException);
    }
    throw new RuntimeException((Throwable)localAtomicReference2.get());
    label112:
    return (T)localInterruptedException.get();
  }
  
  public static <T> BlockingObservable<T> from(Observable<? extends T> paramObservable)
  {
    return new BlockingObservable(paramObservable);
  }
  
  public T first()
  {
    return (T)blockForSingle(o.first());
  }
  
  public T first(Func1<? super T, Boolean> paramFunc1)
  {
    return (T)blockForSingle(o.first(paramFunc1));
  }
  
  public T firstOrDefault(T paramT)
  {
    return (T)blockForSingle(o.map(UtilityFunctions.identity()).firstOrDefault(paramT));
  }
  
  public T firstOrDefault(T paramT, Func1<? super T, Boolean> paramFunc1)
  {
    return (T)blockForSingle(o.filter(paramFunc1).map(UtilityFunctions.identity()).firstOrDefault(paramT));
  }
  
  public void forEach(final Action1<? super T> paramAction1)
  {
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    final AtomicReference localAtomicReference = new AtomicReference();
    paramAction1 = o.subscribe(new Subscriber()
    {
      public void onCompleted()
      {
        localCountDownLatch.countDown();
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        localAtomicReference.set(paramAnonymousThrowable);
        localCountDownLatch.countDown();
      }
      
      public void onNext(T paramAnonymousT)
      {
        paramAction1.call(paramAnonymousT);
      }
    });
    try
    {
      localCountDownLatch.await();
      if (localAtomicReference.get() == null) {
        return;
      }
      if ((localAtomicReference.get() instanceof RuntimeException)) {
        throw ((RuntimeException)localAtomicReference.get());
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      paramAction1.unsubscribe();
      Thread.currentThread().interrupt();
      throw new RuntimeException("Interrupted while waiting for subscription to complete.", localInterruptedException);
    }
    throw new RuntimeException((Throwable)localAtomicReference.get());
  }
  
  public Iterator<T> getIterator()
  {
    return BlockingOperatorToIterator.toIterator(o);
  }
  
  public T last()
  {
    return (T)blockForSingle(o.last());
  }
  
  public T last(Func1<? super T, Boolean> paramFunc1)
  {
    return (T)blockForSingle(o.last(paramFunc1));
  }
  
  public T lastOrDefault(T paramT)
  {
    return (T)blockForSingle(o.map(UtilityFunctions.identity()).lastOrDefault(paramT));
  }
  
  public T lastOrDefault(T paramT, Func1<? super T, Boolean> paramFunc1)
  {
    return (T)blockForSingle(o.filter(paramFunc1).map(UtilityFunctions.identity()).lastOrDefault(paramT));
  }
  
  public Iterable<T> latest()
  {
    return BlockingOperatorLatest.latest(o);
  }
  
  public Iterable<T> mostRecent(T paramT)
  {
    return BlockingOperatorMostRecent.mostRecent(o, paramT);
  }
  
  public Iterable<T> next()
  {
    return BlockingOperatorNext.next(o);
  }
  
  public T single()
  {
    return (T)blockForSingle(o.single());
  }
  
  public T single(Func1<? super T, Boolean> paramFunc1)
  {
    return (T)blockForSingle(o.single(paramFunc1));
  }
  
  public T singleOrDefault(T paramT)
  {
    return (T)blockForSingle(o.map(UtilityFunctions.identity()).singleOrDefault(paramT));
  }
  
  public T singleOrDefault(T paramT, Func1<? super T, Boolean> paramFunc1)
  {
    return (T)blockForSingle(o.filter(paramFunc1).map(UtilityFunctions.identity()).singleOrDefault(paramT));
  }
  
  public Future<T> toFuture()
  {
    return BlockingOperatorToFuture.toFuture(o);
  }
  
  public Iterable<T> toIterable()
  {
    new Iterable()
    {
      public Iterator<T> iterator()
      {
        return getIterator();
      }
    };
  }
}

/* Location:
 * Qualified Name:     rx.observables.BlockingObservable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */