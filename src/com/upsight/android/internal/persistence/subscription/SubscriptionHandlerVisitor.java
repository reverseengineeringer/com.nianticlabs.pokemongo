package com.upsight.android.internal.persistence.subscription;

import com.upsight.android.persistence.annotation.UpsightStorableType;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

class SubscriptionHandlerVisitor
  implements ClassSubscriptionVisitor
{
  private final Set<SubscriptionHandler> mHandlers = new HashSet();
  private final Object mTarget;
  
  SubscriptionHandlerVisitor(Object paramObject)
  {
    mTarget = paramObject;
  }
  
  public Set<SubscriptionHandler> getHandlers()
  {
    return new HashSet(mHandlers);
  }
  
  public void visitCreatedSubscription(Method paramMethod, Class<?> paramClass)
  {
    paramClass = (UpsightStorableType)paramClass.getAnnotation(UpsightStorableType.class);
    if (paramClass != null) {
      mHandlers.add(new SubscriptionHandler(mTarget, paramMethod, DataStoreEvent.Action.Created, paramClass.value()));
    }
  }
  
  public void visitRemovedSubscription(Method paramMethod, Class<?> paramClass)
  {
    paramClass = (UpsightStorableType)paramClass.getAnnotation(UpsightStorableType.class);
    if (paramClass != null) {
      mHandlers.add(new SubscriptionHandler(mTarget, paramMethod, DataStoreEvent.Action.Removed, paramClass.value()));
    }
  }
  
  public void visitUpdatedSubscription(Method paramMethod, Class<?> paramClass)
  {
    paramClass = (UpsightStorableType)paramClass.getAnnotation(UpsightStorableType.class);
    if (paramClass != null) {
      mHandlers.add(new SubscriptionHandler(mTarget, paramMethod, DataStoreEvent.Action.Updated, paramClass.value()));
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.subscription.SubscriptionHandlerVisitor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */