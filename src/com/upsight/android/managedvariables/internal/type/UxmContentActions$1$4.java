package com.upsight.android.managedvariables.internal.type;

import com.fasterxml.jackson.databind.JsonNode;
import com.upsight.android.analytics.internal.action.Action;

class UxmContentActions$1$4
  implements UxmContentActions.InternalFactory
{
  UxmContentActions$1$4(UxmContentActions.1 param1) {}
  
  public Action<UxmContent, UxmContentActions.UxmContentActionContext> create(UxmContentActions.UxmContentActionContext paramUxmContentActionContext, String paramString, JsonNode paramJsonNode)
  {
    return new UxmContentActions.NotifyUxmValuesSynchronized(paramUxmContentActionContext, paramString, paramJsonNode, null);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.UxmContentActions.1.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */