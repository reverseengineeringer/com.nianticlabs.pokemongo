package com.upsight.android.persistence;

public abstract interface UpsightSubscription
{
  public abstract boolean isSubscribed();
  
  public abstract void unsubscribe();
}

/* Location:
 * Qualified Name:     com.upsight.android.persistence.UpsightSubscription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */