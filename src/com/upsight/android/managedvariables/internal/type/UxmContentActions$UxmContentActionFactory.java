package com.upsight.android.managedvariables.internal.type;

import com.fasterxml.jackson.databind.JsonNode;
import com.upsight.android.UpsightException;
import com.upsight.android.analytics.internal.action.Action;
import com.upsight.android.analytics.internal.action.ActionFactory;
import java.util.Map;

public class UxmContentActions$UxmContentActionFactory
  implements ActionFactory<UxmContent, UxmContentActions.UxmContentActionContext>
{
  public static final String TYPE = "datastore_factory";
  
  public Action<UxmContent, UxmContentActions.UxmContentActionContext> create(UxmContentActions.UxmContentActionContext paramUxmContentActionContext, JsonNode paramJsonNode)
    throws UpsightException
  {
    if (paramJsonNode == null) {
      throw new UpsightException("Failed to create Action. JSON is null.", new Object[0]);
    }
    String str = paramJsonNode.get("action_type").asText();
    paramJsonNode = paramJsonNode.get("parameters");
    UxmContentActions.InternalFactory localInternalFactory = (UxmContentActions.InternalFactory)UxmContentActions.access$500().get(str);
    if (localInternalFactory == null) {
      throw new UpsightException("Failed to create Action. Unknown action type.", new Object[0]);
    }
    return localInternalFactory.create(paramUxmContentActionContext, str, paramJsonNode);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.UxmContentActions.UxmContentActionFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */