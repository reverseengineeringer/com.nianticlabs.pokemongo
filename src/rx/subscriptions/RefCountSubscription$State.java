package rx.subscriptions;

final class RefCountSubscription$State
{
  final int children;
  final boolean isUnsubscribed;
  
  RefCountSubscription$State(boolean paramBoolean, int paramInt)
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

/* Location:
 * Qualified Name:     rx.subscriptions.RefCountSubscription.State
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */