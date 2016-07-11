package com.upsight.android.managedvariables.internal.type;

import com.fasterxml.jackson.databind.JsonNode;
import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightExtension;
import com.upsight.android.analytics.event.uxm.UpsightUxmEnumerateEvent;
import com.upsight.android.analytics.event.uxm.UpsightUxmEnumerateEvent.Builder;
import com.upsight.android.analytics.internal.action.Action;
import com.upsight.android.analytics.internal.action.ActionContext;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.managedvariables.UpsightManagedVariablesComponent;
import org.json.JSONArray;
import org.json.JSONException;

class UxmContentActions$UxmEnumerate
  extends Action<UxmContent, UxmContentActions.UxmContentActionContext>
{
  private UxmContentActions$UxmEnumerate(UxmContentActions.UxmContentActionContext paramUxmContentActionContext, String paramString, JsonNode paramJsonNode)
  {
    super(paramUxmContentActionContext, paramString, paramJsonNode);
  }
  
  public void execute(UxmContent paramUxmContent)
  {
    ActionContext localActionContext = getActionContext();
    String str = mUpsight.getUpsightExtension("com.upsight.extension.managedvariables").getComponent()).uxmSchema().mSchemaJsonString;
    try
    {
      UpsightUxmEnumerateEvent.createBuilder(new JSONArray(str)).record(mUpsight);
      paramUxmContent.signalActionCompleted(mBus);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        mUpsight.getLogger().e("Upsight", localJSONException, "Failed to send UXM enumerate event", new Object[0]);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.UxmContentActions.UxmEnumerate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */