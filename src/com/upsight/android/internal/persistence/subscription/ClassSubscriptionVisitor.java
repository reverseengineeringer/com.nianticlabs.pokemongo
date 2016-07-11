package com.upsight.android.internal.persistence.subscription;

import java.lang.reflect.Method;

abstract interface ClassSubscriptionVisitor
{
  public abstract void visitCreatedSubscription(Method paramMethod, Class<?> paramClass);
  
  public abstract void visitRemovedSubscription(Method paramMethod, Class<?> paramClass);
  
  public abstract void visitUpdatedSubscription(Method paramMethod, Class<?> paramClass);
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.subscription.ClassSubscriptionVisitor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */