package rx.subscriptions;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import rx.Subscription;

public final class RefCountSubscription
  implements Subscription
{
  static final State EMPTY_STATE = new State(false, 0);
  static final AtomicReferenceFieldUpdater<RefCountSubscription, State> STATE_UPDATER = AtomicReferenceFieldUpdater.newUpdater(RefCountSubscription.class, State.class, "state");
  private final Subscription actual;
  volatile State state = EMPTY_STATE;
  
  public RefCountSubscription(Subscription paramSubscription)
  {
    if (paramSubscription == null) {
      throw new IllegalArgumentException("s");
    }
    actual = paramSubscription;
  }
  
  private void unsubscribeActualIfApplicable(State paramState)
  {
    if ((isUnsubscribed) && (children == 0)) {
      actual.unsubscribe();
    }
  }
  
  public Subscription get()
  {
    State localState1;
    State localState2;
    do
    {
      localState1 = state;
      if (isUnsubscribed) {
        return Subscriptions.unsubscribed();
      }
      localState2 = localState1.addChild();
    } while (!STATE_UPDATER.compareAndSet(this, localState1, localState2));
    return new InnerSubscription(this);
  }
  
  public boolean isUnsubscribed()
  {
    return state.isUnsubscribed;
  }
  
  public void unsubscribe()
  {
    State localState1;
    State localState2;
    do
    {
      localState1 = state;
      if (isUnsubscribed) {
        return;
      }
      localState2 = localState1.unsubscribe();
    } while (!STATE_UPDATER.compareAndSet(this, localState1, localState2));
    unsubscribeActualIfApplicable(localState2);
  }
  
  void unsubscribeAChild()
  {
    State localState1;
    State localState2;
    do
    {
      localState1 = state;
      localState2 = localState1.removeChild();
    } while (!STATE_UPDATER.compareAndSet(this, localState1, localState2));
    unsubscribeActualIfApplicable(localState2);
  }
  
  private static final class InnerSubscription
    implements Subscription
  {
    static final AtomicIntegerFieldUpdater<InnerSubscription> INNER_DONE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(InnerSubscription.class, "innerDone");
    volatile int innerDone;
    final RefCountSubscription parent;
    
    public InnerSubscription(RefCountSubscription paramRefCountSubscription)
    {
      parent = paramRefCountSubscription;
    }
    
    public boolean isUnsubscribed()
    {
      return innerDone != 0;
    }
    
    public void unsubscribe()
    {
      if (INNER_DONE_UPDATER.compareAndSet(this, 0, 1)) {
        parent.unsubscribeAChild();
      }
    }
  }
  
  private static final class State
  {
    final int children;
    final boolean isUnsubscribed;
    
    State(boolean paramBoolean, int paramInt)
    {
      isUnsubscribed = paramBoolean;
      children = paramInt;
    }
    
    State addChild()
    {
      return new State(isUnsubscribed, children + 1);
    }
    
    State removeChild()
    {
      return new State(isUnsubscribed, children - 1);
    }
    
    State unsubscribe()
    {
      return new State(true, children);
    }
  }
}

/* Location:
 * Qualified Name:     rx.subscriptions.RefCountSubscription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */