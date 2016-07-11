package com.upsight.android.managedvariables.internal.type;

import com.fasterxml.jackson.databind.JsonNode;
import com.upsight.android.analytics.internal.action.Action;
import java.util.HashMap;

final class UxmContentActions$1
  extends HashMap<String, UxmContentActions.InternalFactory>
{
  UxmContentActions$1()
  {
    put("action_uxm_enumerate", new UxmContentActions.InternalFactory()
    {
      public Action<UxmContent, UxmContentActions.UxmContentActionContext> create(UxmContentActions.UxmContentActionContext paramAnonymousUxmContentActionContext, String paramAnonymousString, JsonNode paramAnonymousJsonNode)
      {
        return new UxmContentActions.UxmEnumerate(paramAnonymousUxmContentActionContext, paramAnonymousString, paramAnonymousJsonNode, null);
      }
    });
    put("action_set_bundle_id", new UxmContentActions.InternalFactory()
    {
      public Action<UxmContent, UxmContentActions.UxmContentActionContext> create(UxmContentActions.UxmContentActionContext paramAnonymousUxmContentActionContext, String paramAnonymousString, JsonNode paramAnonymousJsonNode)
      {
        return new UxmContentActions.SetBundleId(paramAnonymousUxmContentActionContext, paramAnonymousString, paramAnonymousJsonNode, null);
      }
    });
    put("action_modify_value", new UxmContentActions.InternalFactory()
    {
      public Action<UxmContent, UxmContentActions.UxmContentActionContext> create(UxmContentActions.UxmContentActionContext paramAnonymousUxmContentActionContext, String paramAnonymousString, JsonNode paramAnonymousJsonNode)
      {
        return new UxmContentActions.ModifyValue(paramAnonymousUxmContentActionContext, paramAnonymousString, paramAnonymousJsonNode, null);
      }
    });
    put("action_notify_uxm_values_synchronized", new UxmContentActions.InternalFactory()
    {
      public Action<UxmContent, UxmContentActions.UxmContentActionContext> create(UxmContentActions.UxmContentActionContext paramAnonymousUxmContentActionContext, String paramAnonymousString, JsonNode paramAnonymousJsonNode)
      {
        return new UxmContentActions.NotifyUxmValuesSynchronized(paramAnonymousUxmContentActionContext, paramAnonymousString, paramAnonymousJsonNode, null);
      }
    });
    put("action_destroy", new UxmContentActions.InternalFactory()
    {
      public Action<UxmContent, UxmContentActions.UxmContentActionContext> create(UxmContentActions.UxmContentActionContext paramAnonymousUxmContentActionContext, String paramAnonymousString, JsonNode paramAnonymousJsonNode)
      {
        return new UxmContentActions.Destroy(paramAnonymousUxmContentActionContext, paramAnonymousString, paramAnonymousJsonNode, null);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.UxmContentActions.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */