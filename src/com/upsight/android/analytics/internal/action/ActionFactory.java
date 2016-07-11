package com.upsight.android.analytics.internal.action;

import com.fasterxml.jackson.databind.JsonNode;
import com.upsight.android.UpsightException;

public abstract interface ActionFactory<T extends Actionable, U extends ActionContext>
{
  public static final String KEY_ACTION_PARAMS = "parameters";
  public static final String KEY_ACTION_TYPE = "action_type";
  
  public abstract Action<T, U> create(U paramU, JsonNode paramJsonNode)
    throws UpsightException;
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.action.ActionFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */