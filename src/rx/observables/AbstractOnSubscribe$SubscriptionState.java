package rx.observables;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Subscriber;
import rx.exceptions.CompositeException;

public final class AbstractOnSubscribe$SubscriptionState<T, S>
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
  
  private AbstractOnSubscribe$SubscriptionState(AbstractOnSubscribe<T, S> paramAbstractOnSubscribe, Subscriber<? super T> paramSubscriber, S paramS)
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

/* Location:
 * Qualified Name:     rx.observables.AbstractOnSubscribe.SubscriptionState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */