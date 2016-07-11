package com.upsight.android.managedvariables.internal.type;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.squareup.otto.Bus;
import com.upsight.android.analytics.internal.action.Action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class UxmContentActions$NotifyUxmValuesSynchronized
  extends Action<UxmContent, UxmContentActions.UxmContentActionContext>
{
  private static final String TAGS = "tags";
  
  private UxmContentActions$NotifyUxmValuesSynchronized(UxmContentActions.UxmContentActionContext paramUxmContentActionContext, String paramString, JsonNode paramJsonNode)
  {
    super(paramUxmContentActionContext, paramString, paramJsonNode);
  }
  
  public void execute(UxmContent paramUxmContent)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = optParamJsonArray("tags");
    if ((paramUxmContent.shouldApplyBundle()) && (localObject != null))
    {
      localObject = ((ArrayNode)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        JsonNode localJsonNode = (JsonNode)((Iterator)localObject).next();
        if (localJsonNode.isTextual()) {
          localArrayList.add(localJsonNode.asText());
        }
      }
    }
    localObject = getActionContextmBus;
    ((Bus)localObject).post(new UxmContentActions.ScheduleSyncNotificationEvent(paramUxmContent.getId(), localArrayList, null));
    paramUxmContent.signalActionCompleted((Bus)localObject);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.UxmContentActions.NotifyUxmValuesSynchronized
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */