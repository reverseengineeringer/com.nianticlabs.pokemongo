package com.upsight.android.analytics.internal.action;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public abstract class Action<T extends Actionable, U extends ActionContext>
{
  private U mActionContext;
  private JsonNode mParams;
  private String mType;
  
  protected Action(U paramU, String paramString, JsonNode paramJsonNode)
  {
    mActionContext = paramU;
    mType = paramString;
    mParams = paramJsonNode;
  }
  
  public abstract void execute(T paramT);
  
  public U getActionContext()
  {
    return mActionContext;
  }
  
  public String getType()
  {
    return mType;
  }
  
  protected int optParamInt(String paramString)
  {
    if (mParams != null)
    {
      paramString = mParams.get(paramString);
      if ((paramString != null) && (paramString.isInt())) {
        return paramString.asInt();
      }
    }
    return 0;
  }
  
  protected ArrayNode optParamJsonArray(String paramString)
  {
    if (mParams != null)
    {
      paramString = mParams.get(paramString);
      if ((paramString != null) && (paramString.isArray())) {
        return (ArrayNode)paramString;
      }
    }
    return null;
  }
  
  protected ObjectNode optParamJsonObject(String paramString)
  {
    if (mParams != null)
    {
      paramString = mParams.get(paramString);
      if ((paramString != null) && (paramString.isObject())) {
        return (ObjectNode)paramString;
      }
    }
    return null;
  }
  
  protected String optParamString(String paramString)
  {
    if (mParams != null)
    {
      paramString = mParams.get(paramString);
      if ((paramString != null) && (paramString.isTextual())) {
        return paramString.asText();
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.action.Action
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */