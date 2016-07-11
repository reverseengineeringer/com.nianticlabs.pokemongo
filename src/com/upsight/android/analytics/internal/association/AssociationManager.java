package com.upsight.android.analytics.internal.association;

import com.fasterxml.jackson.databind.node.ObjectNode;

public abstract interface AssociationManager
{
  public abstract void associate(String paramString, ObjectNode paramObjectNode);
  
  public abstract void launch();
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.association.AssociationManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */