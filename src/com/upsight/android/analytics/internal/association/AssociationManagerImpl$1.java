package com.upsight.android.analytics.internal.association;

import rx.functions.Action1;

class AssociationManagerImpl$1
  implements Action1<Association>
{
  AssociationManagerImpl$1(AssociationManagerImpl paramAssociationManagerImpl) {}
  
  public void call(Association paramAssociation)
  {
    this$0.addAssociation(paramAssociation.getWith(), paramAssociation);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.association.AssociationManagerImpl.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */