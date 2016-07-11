package rx.observers;

import rx.Observer;
import rx.Subscriber;
import rx.annotations.Experimental;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action0;
import rx.functions.Action1;

public final class Subscribers
{
  private Subscribers()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static final <T> Subscriber<T> create(Action1<? super T> paramAction1)
  {
    if (paramAction1 == null) {
      throw new IllegalArgumentException("onNext can not be null");
    }
    new Subscriber()
    {
      public final void onCompleted() {}
      
      public final void onError(Throwable paramAnonymousThrowable)
      {
        throw new OnErrorNotImplementedException(paramAnonymousThrowable);
      }
      
      public final void onNext(T paramAnonymousT)
      {
        val$onNext.call(paramAnonymousT);
      }
    };
  }
  
  public static final <T> Subscriber<T> create(final Action1<? super T> paramAction1, Action1<Throwable> paramAction11)
  {
    if (paramAction1 == null) {
      throw new IllegalArgumentException("onNext can not be null");
    }
    if (paramAction11 == null) {
      throw new IllegalArgumentException("onError can not be null");
    }
    new Subscriber()
    {
      public final void onCompleted() {}
      
      public final void onError(Throwable paramAnonymousThrowable)
      {
        val$onError.call(paramAnonymousThrowable);
      }
      
      public final void onNext(T paramAnonymousT)
      {
        paramAction1.call(paramAnonymousT);
      }
    };
  }
  
  public static final <T> Subscriber<T> create(final Action1<? super T> paramAction1, final Action1<Throwable> paramAction11, Action0 paramAction0)
  {
    if (paramAction1 == null) {
      throw new IllegalArgumentException("onNext can not be null");
    }
    if (paramAction11 == null) {
      throw new IllegalArgumentException("onError can not be null");
    }
    if (paramAction0 == null) {
      throw new IllegalArgumentException("onComplete can not be null");
    }
    new Subscriber()
    {
      public final void onCompleted()
      {
        val$onComplete.call();
      }
      
      public final void onError(Throwable paramAnonymousThrowable)
      {
        paramAction11.call(paramAnonymousThrowable);
      }
      
      public final void onNext(T paramAnonymousT)
      {
        paramAction1.call(paramAnonymousT);
      }
    };
  }
  
  public static <T> Subscriber<T> empty()
  {
    return from(Observers.empty());
  }
  
  public static <T> Subscriber<T> from(Observer<? super T> paramObserver)
  {
    new Subscriber()
    {
      public void onCompleted()
      {
        val$o.onCompleted();
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        val$o.onError(paramAnonymousThrowable);
      }
      
      public void onNext(T paramAnonymousT)
      {
        val$o.onNext(paramAnonymousT);
      }
    };
  }
  
  @Experimental
  public static <T> Subscriber<T> wrap(final Subscriber<? super T> paramSubscriber)
  {
    new Subscriber(paramSubscriber)
    {
      public void onCompleted()
      {
        paramSubscriber.onCompleted();
      }
      
      public void onError(Throwable paramAnonymousThrowable)
      {
        paramSubscriber.onError(paramAnonymousThrowable);
      }
      
      public void onNext(T paramAnonymousT)
      {
        paramSubscriber.onNext(paramAnonymousT);
      }
    };
  }
}

/* Location:
 * Qualified Name:     rx.observers.Subscribers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */