package com.upsight.android.managedvariables.internal.type;

import com.fasterxml.jackson.databind.JsonNode;
import com.squareup.otto.Bus;
import com.upsight.android.analytics.internal.action.Action;

class UxmContentActions$Destroy
  extends Action<UxmContent, UxmContentActions.UxmContentActionContext>
{
  private UxmContentActions$Destroy(UxmContentActions.UxmContentActionContext paramUxmContentActionContext, String paramString, JsonNode paramJsonNode)
  {
    super(paramUxmContentActionContext, paramString, paramJsonNode);
  }
  
  public void execute(UxmContent paramUxmContent)
  {
    Bus localBus = getActionContextmBus;
    paramUxmContent.signalActionCompleted(localBus);
    paramUxmContent.signalActionMapCompleted(localBus);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.UxmContentActions.Destroy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */