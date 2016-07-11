package com.upsight.android.managedvariables.internal.type;

import com.fasterxml.jackson.databind.JsonNode;
import com.upsight.android.analytics.internal.action.Action;

abstract interface UxmContentActions$InternalFactory
{
  public abstract Action<UxmContent, UxmContentActions.UxmContentActionContext> create(UxmContentActions.UxmContentActionContext paramUxmContentActionContext, String paramString, JsonNode paramJsonNode);
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.UxmContentActions.InternalFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */