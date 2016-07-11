package com.upsight.android.analytics.internal.action;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.upsight.android.persistence.annotation.UpsightStorableIdentifier;
import com.upsight.android.persistence.annotation.UpsightStorableType;

@UpsightStorableType("upsight.action_map")
public final class ActionMapResponse
{
  @JsonProperty("action_factory")
  String actionFactory;
  @JsonProperty("action_map")
  JsonNode actionMap;
  @JsonProperty("id")
  String actionMapId;
  @UpsightStorableIdentifier
  String id;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (ActionMapResponse)paramObject;
      if (id == null) {
        break;
      }
    } while (id.equals(id));
    for (;;)
    {
      return false;
      if (id == null) {
        break;
      }
    }
  }
  
  public String getActionFactory()
  {
    return actionFactory;
  }
  
  public JsonNode getActionMap()
  {
    return actionMap;
  }
  
  public String getActionMapId()
  {
    return actionMapId;
  }
  
  public int hashCode()
  {
    if (id != null) {
      return id.hashCode();
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.action.ActionMapResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */