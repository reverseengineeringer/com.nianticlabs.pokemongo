package rx.observables;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.annotations.Experimental;
import rx.exceptions.CompositeException;
import rx.functions.Action1;
import rx.functions.Actions;
import rx.functions.Func1;
import rx.internal.operators.BackpressureUtils;

@Experimental
public abstract class AbstractOnSubscribe<T, S>
  implements Observable.OnSubscribe<T>
{
  private static final Func1<Object, Object> NULL_FUNC1 = new Func1()
  {
    public Object call(Object paramAnonymousObject)
    {
      return null;
    }
  };
  
  public static <T, S> AbstractOnSubscribe<T, S> create(Action1<SubscriptionState<T, S>> paramAction1)
  {
    return create(paramAction1, NULL_FUNC1, Actions.empty());
  }
  
  public static <T, S> AbstractOnSubscribe<T, S> create(Action1<SubscriptionState<T, S>> paramAction1, Func1<? super Subscriber<? super T>, ? extends S> paramFunc1)
  {
    return create(paramAction1, paramFunc1, Actions.empty());
  }
  
  public static <T, S> AbstractOnSubscribe<T, S> create(Action1<SubscriptionState<T, S>> paramAction1, Func1<? super Subscriber<? super T>, ? extends S> paramFunc1, Action1<? super S> paramAction11)
  {
    return new LambdaOnSubscribe(paramAction1, paramFunc1, paramAction11, null);
  }
  
  public final void call(Subscriber<? super T> paramSubscriber)
  {
    SubscriptionState localSubscriptionState = new SubscriptionState(this, paramSubscriber, onSubscribe(paramSubscriber), null);
    paramSubscriber.add(new SubscriptionCompleter(localSubscriptionState, null));
    paramSubscriber.setProducer(new SubscriptionProducer(localSubscriptionState, null));
  }
  
  protected abstract void next(SubscriptionState<T, S> paramSubscriptionState);
  
  protected S onSubscribe(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
  
  protected void onTerminated(S paramS) {}
  
  public final Observable<T> toObservable()
  {
    return Observable.create(this);
  }
  
  private static final class LambdaOnSubscribe<T, S>
    extends AbstractOnSubscribe<T, S>
  {
    final Action1<AbstractOnSubscribe.SubscriptionState<T, S>> next;
    final Func1<? super Subscriber<? super T>, ? extends S> onSubscribe;
    final Action1<? super S> onTerminated;
    
    private LambdaOnSubscribe(Action1<AbstractOnSubscribe.SubscriptionState<T, S>> paramAction1, Func1<? super Subscriber<? super T>, ? extends S> paramFunc1, Action1<? super S> paramAction11)
    {
      next = paramAction1;
      onSubscribe = paramFunc1;
      onTerminated = paramAction11;
    }
    
    protected void next(AbstractOnSubscribe.SubscriptionState<T, S> paramSubscriptionState)
    {
      next.call(paramSubscriptionState);
    }
    
    protected S onSubscribe(Subscriber<? super T> paramSubscriber)
    {
      return (S)onSubscribe.call(paramSubscriber);
    }
    
    protected void onTerminated(S paramS)
    {
      onTerminated.call(paramS);
    }
  }
  
  private static final class SubscriptionCompleter<T, S>
    extends AtomicBoolean
    implements Subscription
  {
    private static final long serialVersionUID = 7993888274897325004L;
    private final AbstractOnSubscribe.SubscriptionState<T, S> state;
    
    private SubscriptionCompleter(AbstractOnSubscribe.SubscriptionState<T, S> paramSubscriptionState)
    {
      state = paramSubscriptionState;
    }
    
    public boolean isUnsubscribed()
    {
      return get();
    }
    
    public void unsubscribe()
    {
      if (compareAndSet(false, true)) {
        state.free();
      }
    }
  }
  
  private static final class SubscriptionProducer<T, S>
    implements Producer
  {
    final AbstractOnSubscribe.SubscriptionState<T, S> state;
    
    private SubscriptionProducer(AbstractOnSubscribe.SubscriptionState<T, S> paramSubscriptionState)
    {
      state = paramSubscriptionState;
    }
    
    protected boolean doNext()
    {
      if (state.use()) {}
      try
      {
        int i = state.phase();
        AbstractOnSubscribe.SubscriptionState.access$600(state).next(state);
        if (!state.verify()) {
          throw new IllegalStateException("No event produced or stop called @ Phase: " + i + " -> " + state.phase() + ", Calls: " + state.calls());
        }
      }
      catch (Throwable localThrowable)
      {
        state.terminate();
        AbstractOnSubscribe.SubscriptionState.access$500(state).onError(localThrowable);
        return false;
        if ((state.accept()) || (state.stopRequested()))
        {
          state.terminate();
          return false;
        }
        AbstractOnSubscribe.SubscriptionState.access$708(state);
        return true;
      }
      finally
      {
        state.free();
      }
    }
    
    public void request(long paramLong)
    {
      if ((paramLong > 0L) && (BackpressureUtils.getAndAddRequest(AbstractOnSubscribe.SubscriptionState.access$400(state), paramLong) == 0L))
      {
        if (paramLong != Long.MAX_VALUE) {
          break label51;
        }
        while ((!AbstractOnSubscribe.SubscriptionState.access$500(state).isUnsubscribed()) && (doNext())) {}
      }
      label51:
      do
      {
        do
        {
          return;
          while (AbstractOnSubscribe.SubscriptionState.access$500(state).isUnsubscribed()) {}
        } while ((!doNext()) || (AbstractOnSubscribe.SubscriptionState.access$400(state).decrementAndGet() <= 0L));
      } while (!AbstractOnSubscribe.SubscriptionState.access$500(state).isUnsubscribed());
    }
  }
  
  public static final class SubscriptionState<T, S>
  {
    private long calls;
    private boolean hasCompleted;
    private boolean hasOnNext;
    private final AtomicInteger inUse;
    private final AbstractOnSubscribe<T, S> parent;
    private int phase;
    private final AtomicLong requestCount;
    private final S state;
    private boolean stopRequested;
    private final Subscriber<? super T> subscriber;
    private Throwable theException;
    private T theValue;
    
    private SubscriptionState(AbstractOnSubscribe<T, S> paramAbstractOnSubscribe, Subscriber<? super T> paramSubscriber, S paramS)
    {
      parent = paramAbstractOnSubscribe;
      subscriber = paramSubscriber;
      state = paramS;
      requestCount = new AtomicLong();
      inUse = new AtomicInteger(1);
    }
    
    protected boolean accept()
    {
      Object localObject;
      if (hasOnNext)
      {
        localObject = theValue;
        theValue = null;
        hasOnNext = false;
      }
      try
      {
        subscriber.onNext(localObject);
        if (!hasCompleted) {
          break label131;
        }
        localObject = theException;
        theException = null;
        if (localObject != null)
        {
          subscriber.onError((Throwable)localObject);
          return true;
        }
      }
      catch (Throwable localThrowable1)
      {
        hasCompleted = true;
        Throwable localThrowable2 = theException;
        theException = null;
        if (localThrowable2 == null)
        {
          subscriber.onError(localThrowable1);
          return true;
        }
        subscriber.onError(new CompositeException(Arrays.asList(new Throwable[] { localThrowable1, localThrowable2 })));
        return true;
      }
      subscriber.onCompleted();
      return true;
      label131:
      return false;
    }
    
    public void advancePhase()
    {
      advancePhaseBy(1);
    }
    
    public void advancePhaseBy(int paramInt)
    {
      phase += paramInt;
    }
    
    public long calls()
    {
      return calls;
    }
    
    protected void free()
    {
      if (inUse.get() <= 0) {}
      while (inUse.decrementAndGet() != 0) {
        return;
      }
      parent.onTerminated(state);
    }
    
    public void onCompleted()
    {
      if (hasCompleted) {
        throw new IllegalStateException("Already terminated", theException);
      }
      hasCompleted = true;
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (paramThrowable == null) {
        throw new NullPointerException("e != null required");
      }
      if (hasCompleted) {
        throw new IllegalStateException("Already terminated", theException);
      }
      theException = paramThrowable;
      hasCompleted = true;
    }
    
    public void onNext(T paramT)
    {
      if (hasOnNext) {
        throw new IllegalStateException("onNext not consumed yet!");
      }
      if (hasCompleted) {
        throw new IllegalStateException("Already terminated", theException);
      }
      theValue = paramT;
      hasOnNext = true;
    }
    
    public int phase()
    {
      return phase;
    }
    
    public void phase(int paramInt)
    {
      phase = paramInt;
    }
    
    public S state()
    {
      return (S)state;
    }
    
    public void stop()
    {
      stopRequested = true;
    }
    
    protected boolean stopRequested()
    {
      return stopRequested;
    }
    
    protected void terminate()
    {
      int i;
      do
      {
        i = inUse.get();
        if (i <= 0) {
          return;
        }
      } while (!inUse.compareAndSet(i, 0));
      parent.onTerminated(state);
    }
    
    protected boolean use()
    {
      boolean bool = true;
      int i = inUse.get();
      if (i == 0) {
        bool = false;
      }
      while ((i == 1) && (inUse.compareAndSet(1, 2))) {
        return bool;
      }
      throw new IllegalStateException("This is not reentrant nor threadsafe!");
    }
    
    protected boolean verify()
    {
      return (hasOnNext) || (hasCompleted) || (stopRequested);
    }
  }
}

/* Location:
 * Qualified Name:     rx.observables.AbstractOnSubscribe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */