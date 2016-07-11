package rx;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import rx.annotations.Experimental;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.functions.Func5;
import rx.functions.Func6;
import rx.functions.Func7;
import rx.functions.Func8;
import rx.functions.Func9;
import rx.internal.operators.OnSubscribeToObservableFuture;
import rx.internal.operators.OperatorMap;
import rx.internal.operators.OperatorObserveOn;
import rx.internal.operators.OperatorOnErrorReturn;
import rx.internal.operators.OperatorSubscribeOn;
import rx.internal.operators.OperatorTimeout;
import rx.internal.operators.OperatorZip;
import rx.internal.producers.SingleDelayedProducer;
import rx.observers.SafeSubscriber;
import rx.plugins.RxJavaObservableExecutionHook;
import rx.plugins.RxJavaPlugins;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

@Experimental
public class Single<T>
{
  private static final RxJavaObservableExecutionHook hook = RxJavaPlugins.getInstance().getObservableExecutionHook();
  final Observable.OnSubscribe<T> onSubscribe;
  
  private Single(Observable.OnSubscribe<T> paramOnSubscribe)
  {
    onSubscribe = paramOnSubscribe;
  }
  
  protected Single(final OnSubscribe<T> paramOnSubscribe)
  {
    onSubscribe = new Observable.OnSubscribe()
    {
      public void call(final Subscriber<? super T> paramAnonymousSubscriber)
      {
        final Object localObject = new SingleDelayedProducer(paramAnonymousSubscriber);
        paramAnonymousSubscriber.setProducer((Producer)localObject);
        localObject = new SingleSubscriber()
        {
          public void onError(Throwable paramAnonymous2Throwable)
          {
            paramAnonymousSubscriber.onError(paramAnonymous2Throwable);
          }
          
          public void onSuccess(T paramAnonymous2T)
          {
            localObject.setValue(paramAnonymous2T);
          }
        };
        paramAnonymousSubscriber.add((Subscription)localObject);
        paramOnSubscribe.call(localObject);
      }
    };
  }
  
  private static <T> Observable<T> asObservable(Single<T> paramSingle)
  {
    return Observable.create(onSubscribe);
  }
  
  public static final <T> Observable<T> concat(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2)
  {
    return Observable.concat(asObservable(paramSingle1), asObservable(paramSingle2));
  }
  
  public static final <T> Observable<T> concat(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3)
  {
    return Observable.concat(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3));
  }
  
  public static final <T> Observable<T> concat(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4)
  {
    return Observable.concat(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4));
  }
  
  public static final <T> Observable<T> concat(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4, Single<? extends T> paramSingle5)
  {
    return Observable.concat(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5));
  }
  
  public static final <T> Observable<T> concat(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4, Single<? extends T> paramSingle5, Single<? extends T> paramSingle6)
  {
    return Observable.concat(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5), asObservable(paramSingle6));
  }
  
  public static final <T> Observable<T> concat(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4, Single<? extends T> paramSingle5, Single<? extends T> paramSingle6, Single<? extends T> paramSingle7)
  {
    return Observable.concat(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5), asObservable(paramSingle6), asObservable(paramSingle7));
  }
  
  public static final <T> Observable<T> concat(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4, Single<? extends T> paramSingle5, Single<? extends T> paramSingle6, Single<? extends T> paramSingle7, Single<? extends T> paramSingle8)
  {
    return Observable.concat(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5), asObservable(paramSingle6), asObservable(paramSingle7), asObservable(paramSingle8));
  }
  
  public static final <T> Observable<T> concat(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4, Single<? extends T> paramSingle5, Single<? extends T> paramSingle6, Single<? extends T> paramSingle7, Single<? extends T> paramSingle8, Single<? extends T> paramSingle9)
  {
    return Observable.concat(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5), asObservable(paramSingle6), asObservable(paramSingle7), asObservable(paramSingle8), asObservable(paramSingle9));
  }
  
  public static final <T> Single<T> create(OnSubscribe<T> paramOnSubscribe)
  {
    return new Single(paramOnSubscribe);
  }
  
  public static final <T> Single<T> error(Throwable paramThrowable)
  {
    create(new OnSubscribe()
    {
      public void call(SingleSubscriber<? super T> paramAnonymousSingleSubscriber)
      {
        paramAnonymousSingleSubscriber.onError(val$exception);
      }
    });
  }
  
  public static final <T> Single<T> from(Future<? extends T> paramFuture)
  {
    return new Single(OnSubscribeToObservableFuture.toObservableFuture(paramFuture));
  }
  
  public static final <T> Single<T> from(Future<? extends T> paramFuture, long paramLong, TimeUnit paramTimeUnit)
  {
    return new Single(OnSubscribeToObservableFuture.toObservableFuture(paramFuture, paramLong, paramTimeUnit));
  }
  
  public static final <T> Single<T> from(Future<? extends T> paramFuture, Scheduler paramScheduler)
  {
    return new Single(OnSubscribeToObservableFuture.toObservableFuture(paramFuture)).subscribeOn(paramScheduler);
  }
  
  public static final <T> Single<T> just(T paramT)
  {
    create(new OnSubscribe()
    {
      public void call(SingleSubscriber<? super T> paramAnonymousSingleSubscriber)
      {
        paramAnonymousSingleSubscriber.onSuccess(val$value);
      }
    });
  }
  
  private final <R> Single<R> lift(final Observable.Operator<? extends R, ? super T> paramOperator)
  {
    new Single(new Observable.OnSubscribe()
    {
      public void call(Subscriber<? super R> paramAnonymousSubscriber)
      {
        try
        {
          Subscriber localSubscriber = (Subscriber)Single.hook.onLift(paramOperator).call(paramAnonymousSubscriber);
          try
          {
            localSubscriber.onStart();
            onSubscribe.call(localSubscriber);
            return;
          }
          catch (Throwable localThrowable2)
          {
            if (!(localThrowable2 instanceof OnErrorNotImplementedException)) {
              break label64;
            }
          }
          throw ((OnErrorNotImplementedException)localThrowable2);
        }
        catch (Throwable localThrowable1)
        {
          if ((localThrowable1 instanceof OnErrorNotImplementedException))
          {
            throw ((OnErrorNotImplementedException)localThrowable1);
            label64:
            localThrowable1.onError(localThrowable2);
            return;
          }
          paramAnonymousSubscriber.onError(localThrowable1);
        }
      }
    });
  }
  
  public static final <T> Observable<T> merge(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2)
  {
    return Observable.merge(asObservable(paramSingle1), asObservable(paramSingle2));
  }
  
  public static final <T> Observable<T> merge(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3)
  {
    return Observable.merge(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3));
  }
  
  public static final <T> Observable<T> merge(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4)
  {
    return Observable.merge(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4));
  }
  
  public static final <T> Observable<T> merge(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4, Single<? extends T> paramSingle5)
  {
    return Observable.merge(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5));
  }
  
  public static final <T> Observable<T> merge(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4, Single<? extends T> paramSingle5, Single<? extends T> paramSingle6)
  {
    return Observable.merge(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5), asObservable(paramSingle6));
  }
  
  public static final <T> Observable<T> merge(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4, Single<? extends T> paramSingle5, Single<? extends T> paramSingle6, Single<? extends T> paramSingle7)
  {
    return Observable.merge(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5), asObservable(paramSingle6), asObservable(paramSingle7));
  }
  
  public static final <T> Observable<T> merge(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4, Single<? extends T> paramSingle5, Single<? extends T> paramSingle6, Single<? extends T> paramSingle7, Single<? extends T> paramSingle8)
  {
    return Observable.merge(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5), asObservable(paramSingle6), asObservable(paramSingle7), asObservable(paramSingle8));
  }
  
  public static final <T> Observable<T> merge(Single<? extends T> paramSingle1, Single<? extends T> paramSingle2, Single<? extends T> paramSingle3, Single<? extends T> paramSingle4, Single<? extends T> paramSingle5, Single<? extends T> paramSingle6, Single<? extends T> paramSingle7, Single<? extends T> paramSingle8, Single<? extends T> paramSingle9)
  {
    return Observable.merge(asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5), asObservable(paramSingle6), asObservable(paramSingle7), asObservable(paramSingle8), asObservable(paramSingle9));
  }
  
  public static final <T> Single<T> merge(Single<? extends Single<? extends T>> paramSingle)
  {
    create(new OnSubscribe()
    {
      public void call(final SingleSubscriber<? super T> paramAnonymousSingleSubscriber)
      {
        val$source.subscribe(new SingleSubscriber()
        {
          public void onError(Throwable paramAnonymous2Throwable)
          {
            paramAnonymousSingleSubscriber.onError(paramAnonymous2Throwable);
          }
          
          public void onSuccess(Single<? extends T> paramAnonymous2Single)
          {
            paramAnonymous2Single.subscribe(paramAnonymousSingleSubscriber);
          }
        });
      }
    });
  }
  
  private final Single<Observable<T>> nest()
  {
    return just(asObservable(this));
  }
  
  public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Single<R> zip(Single<? extends T1> paramSingle, Single<? extends T2> paramSingle1, Single<? extends T3> paramSingle2, Single<? extends T4> paramSingle3, Single<? extends T5> paramSingle4, Single<? extends T6> paramSingle5, Single<? extends T7> paramSingle6, Single<? extends T8> paramSingle7, Single<? extends T9> paramSingle8, Func9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> paramFunc9)
  {
    return just(new Observable[] { asObservable(paramSingle), asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5), asObservable(paramSingle6), asObservable(paramSingle7), asObservable(paramSingle8) }).lift(new OperatorZip(paramFunc9));
  }
  
  public static final <T1, T2, T3, T4, T5, T6, T7, T8, R> Single<R> zip(Single<? extends T1> paramSingle, Single<? extends T2> paramSingle1, Single<? extends T3> paramSingle2, Single<? extends T4> paramSingle3, Single<? extends T5> paramSingle4, Single<? extends T6> paramSingle5, Single<? extends T7> paramSingle6, Single<? extends T8> paramSingle7, Func8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> paramFunc8)
  {
    return just(new Observable[] { asObservable(paramSingle), asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5), asObservable(paramSingle6), asObservable(paramSingle7) }).lift(new OperatorZip(paramFunc8));
  }
  
  public static final <T1, T2, T3, T4, T5, T6, T7, R> Single<R> zip(Single<? extends T1> paramSingle, Single<? extends T2> paramSingle1, Single<? extends T3> paramSingle2, Single<? extends T4> paramSingle3, Single<? extends T5> paramSingle4, Single<? extends T6> paramSingle5, Single<? extends T7> paramSingle6, Func7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> paramFunc7)
  {
    return just(new Observable[] { asObservable(paramSingle), asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5), asObservable(paramSingle6) }).lift(new OperatorZip(paramFunc7));
  }
  
  public static final <T1, T2, T3, T4, T5, T6, R> Single<R> zip(Single<? extends T1> paramSingle, Single<? extends T2> paramSingle1, Single<? extends T3> paramSingle2, Single<? extends T4> paramSingle3, Single<? extends T5> paramSingle4, Single<? extends T6> paramSingle5, Func6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> paramFunc6)
  {
    return just(new Observable[] { asObservable(paramSingle), asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4), asObservable(paramSingle5) }).lift(new OperatorZip(paramFunc6));
  }
  
  public static final <T1, T2, T3, T4, T5, R> Single<R> zip(Single<? extends T1> paramSingle, Single<? extends T2> paramSingle1, Single<? extends T3> paramSingle2, Single<? extends T4> paramSingle3, Single<? extends T5> paramSingle4, Func5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> paramFunc5)
  {
    return just(new Observable[] { asObservable(paramSingle), asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3), asObservable(paramSingle4) }).lift(new OperatorZip(paramFunc5));
  }
  
  public static final <T1, T2, T3, T4, R> Single<R> zip(Single<? extends T1> paramSingle, Single<? extends T2> paramSingle1, Single<? extends T3> paramSingle2, Single<? extends T4> paramSingle3, Func4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> paramFunc4)
  {
    return just(new Observable[] { asObservable(paramSingle), asObservable(paramSingle1), asObservable(paramSingle2), asObservable(paramSingle3) }).lift(new OperatorZip(paramFunc4));
  }
  
  public static final <T1, T2, T3, R> Single<R> zip(Single<? extends T1> paramSingle, Single<? extends T2> paramSingle1, Single<? extends T3> paramSingle2, Func3<? super T1, ? super T2, ? super T3, ? extends R> paramFunc3)
  {
    return just(new Observable[] { asObservable(paramSingle), asObservable(paramSingle1), asObservable(paramSingle2) }).lift(new OperatorZip(paramFunc3));
  }
  
  public static final <T1, T2, R> Single<R> zip(Single<? extends T1> paramSingle, Single<? extends T2> paramSingle1, Func2<? super T1, ? super T2, ? extends R> paramFunc2)
  {
    return just(new Observable[] { asObservable(paramSingle), asObservable(paramSingle1) }).lift(new OperatorZip(paramFunc2));
  }
  
  public <R> Single<R> compose(Transformer<? super T, ? extends R> paramTransformer)
  {
    return (Single)paramTransformer.call(this);
  }
  
  public final Observable<T> concatWith(Single<? extends T> paramSingle)
  {
    return concat(this, paramSingle);
  }
  
  public final <R> Single<R> flatMap(Func1<? super T, ? extends Single<? extends R>> paramFunc1)
  {
    return merge(map(paramFunc1));
  }
  
  public final <R> Observable<R> flatMapObservable(Func1<? super T, ? extends Observable<? extends R>> paramFunc1)
  {
    return Observable.merge(asObservable(map(paramFunc1)));
  }
  
  public final <R> Single<R> map(Func1<? super T, ? extends R> paramFunc1)
  {
    return lift(new OperatorMap(paramFunc1));
  }
  
  public final Observable<T> mergeWith(Single<? extends T> paramSingle)
  {
    return merge(this, paramSingle);
  }
  
  public final Single<T> observeOn(Scheduler paramScheduler)
  {
    return lift(new OperatorObserveOn(paramScheduler));
  }
  
  public final Single<T> onErrorReturn(Func1<Throwable, ? extends T> paramFunc1)
  {
    return lift(new OperatorOnErrorReturn(paramFunc1));
  }
  
  public final Subscription subscribe()
  {
    subscribe(new Subscriber()
    {
      public final void onCompleted() {}
      
      public final void onError(Throwable paramAnonymousThrowable)
      {
        throw new OnErrorNotImplementedException(paramAnonymousThrowable);
      }
      
      public final void onNext(T paramAnonymousT) {}
    });
  }
  
  public final Subscription subscribe(final SingleSubscriber<? super T> paramSingleSubscriber)
  {
    Subscriber local9 = new Subscriber()
    {
      public void onCompleted() {}
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        paramSingleSubscriber.onError(paramAnonymousThrowable);
      }
      
      public void onNext(T paramAnonymousT)
      {
        paramSingleSubscriber.onSuccess(paramAnonymousT);
      }
    };
    paramSingleSubscriber.add(local9);
    subscribe(local9);
    return local9;
  }
  
  public final Subscription subscribe(Subscriber<? super T> paramSubscriber)
  {
    if (paramSubscriber == null) {
      throw new IllegalArgumentException("observer can not be null");
    }
    if (onSubscribe == null) {
      throw new IllegalStateException("onSubscribe function can not be null.");
    }
    paramSubscriber.onStart();
    Object localObject = paramSubscriber;
    if (!(paramSubscriber instanceof SafeSubscriber)) {
      localObject = new SafeSubscriber(paramSubscriber);
    }
    try
    {
      onSubscribe.call(localObject);
      paramSubscriber = hook.onSubscribeReturn((Subscription)localObject);
      return paramSubscriber;
    }
    catch (Throwable paramSubscriber)
    {
      Exceptions.throwIfFatal(paramSubscriber);
      try
      {
        ((Subscriber)localObject).onError(hook.onSubscribeError(paramSubscriber));
        return Subscriptions.empty();
      }
      catch (OnErrorNotImplementedException paramSubscriber)
      {
        throw paramSubscriber;
      }
      catch (Throwable localThrowable)
      {
        paramSubscriber = new RuntimeException("Error occurred attempting to subscribe [" + paramSubscriber.getMessage() + "] and then again while trying to pass to onError.", localThrowable);
        hook.onSubscribeError(paramSubscriber);
        throw paramSubscriber;
      }
    }
  }
  
  public final Subscription subscribe(final Action1<? super T> paramAction1)
  {
    if (paramAction1 == null) {
      throw new IllegalArgumentException("onSuccess can not be null");
    }
    subscribe(new Subscriber()
    {
      public final void onCompleted() {}
      
      public final void onError(Throwable paramAnonymousThrowable)
      {
        throw new OnErrorNotImplementedException(paramAnonymousThrowable);
      }
      
      public final void onNext(T paramAnonymousT)
      {
        paramAction1.call(paramAnonymousT);
      }
    });
  }
  
  public final Subscription subscribe(final Action1<? super T> paramAction1, final Action1<Throwable> paramAction11)
  {
    if (paramAction1 == null) {
      throw new IllegalArgumentException("onSuccess can not be null");
    }
    if (paramAction11 == null) {
      throw new IllegalArgumentException("onError can not be null");
    }
    subscribe(new Subscriber()
    {
      public final void onCompleted() {}
      
      public final void onError(Throwable paramAnonymousThrowable)
      {
        paramAction11.call(paramAnonymousThrowable);
      }
      
      public final void onNext(T paramAnonymousT)
      {
        paramAction1.call(paramAnonymousT);
      }
    });
  }
  
  public final Single<T> subscribeOn(Scheduler paramScheduler)
  {
    return nest().lift(new OperatorSubscribeOn(paramScheduler));
  }
  
  public final Single<T> timeout(long paramLong, TimeUnit paramTimeUnit)
  {
    return timeout(paramLong, paramTimeUnit, null, Schedulers.computation());
  }
  
  public final Single<T> timeout(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    return timeout(paramLong, paramTimeUnit, null, paramScheduler);
  }
  
  public final Single<T> timeout(long paramLong, TimeUnit paramTimeUnit, Single<? extends T> paramSingle)
  {
    return timeout(paramLong, paramTimeUnit, paramSingle, Schedulers.computation());
  }
  
  public final Single<T> timeout(long paramLong, TimeUnit paramTimeUnit, Single<? extends T> paramSingle, Scheduler paramScheduler)
  {
    Object localObject = paramSingle;
    if (paramSingle == null) {
      localObject = error(new TimeoutException());
    }
    return lift(new OperatorTimeout(paramLong, paramTimeUnit, asObservable((Single)localObject), paramScheduler));
  }
  
  public final Observable<T> toObservable()
  {
    return asObservable(this);
  }
  
  public final void unsafeSubscribe(Subscriber<? super T> paramSubscriber)
  {
    try
    {
      paramSubscriber.onStart();
      onSubscribe.call(paramSubscriber);
      hook.onSubscribeReturn(paramSubscriber);
      return;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwIfFatal(localThrowable);
      try
      {
        paramSubscriber.onError(hook.onSubscribeError(localThrowable));
        return;
      }
      catch (OnErrorNotImplementedException paramSubscriber)
      {
        throw paramSubscriber;
      }
      catch (Throwable paramSubscriber)
      {
        paramSubscriber = new RuntimeException("Error occurred attempting to subscribe [" + localThrowable.getMessage() + "] and then again while trying to pass to onError.", paramSubscriber);
        hook.onSubscribeError(paramSubscriber);
        throw paramSubscriber;
      }
    }
  }
  
  public final <T2, R> Single<R> zipWith(Single<? extends T2> paramSingle, Func2<? super T, ? super T2, ? extends R> paramFunc2)
  {
    return zip(this, paramSingle, paramFunc2);
  }
  
  public static abstract interface OnSubscribe<T>
    extends Action1<SingleSubscriber<? super T>>
  {}
  
  public static abstract interface Transformer<T, R>
    extends Func1<Single<T>, Single<R>>
  {}
}

/* Location:
 * Qualified Name:     rx.Single
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */