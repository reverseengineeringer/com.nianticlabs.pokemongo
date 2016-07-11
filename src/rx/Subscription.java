package rx;

public abstract interface Subscription
{
  public abstract boolean isUnsubscribed();
  
  public abstract void unsubscribe();
}

/* Location:
 * Qualified Name:     rx.Subscription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */