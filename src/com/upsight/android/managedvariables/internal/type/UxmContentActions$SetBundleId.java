package com.upsight.android.managedvariables.internal.type;

import com.fasterxml.jackson.databind.JsonNode;
import com.upsight.android.analytics.internal.action.Action;
import com.upsight.android.internal.util.PreferencesHelper;

class UxmContentActions$SetBundleId
  extends Action<UxmContent, UxmContentActions.UxmContentActionContext>
{
  private static final String BUNDLE_ID = "bundle.id";
  
  private UxmContentActions$SetBundleId(UxmContentActions.UxmContentActionContext paramUxmContentActionContext, String paramString, JsonNode paramJsonNode)
  {
    super(paramUxmContentActionContext, paramString, paramJsonNode);
  }
  
  public void execute(UxmContent paramUxmContent)
  {
    if (paramUxmContent.shouldApplyBundle()) {
      PreferencesHelper.putString(getActionContextmUpsight, "uxmBundleId", optParamString("bundle.id"));
    }
    paramUxmContent.signalActionCompleted(getActionContextmBus);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.UxmContentActions.SetBundleId
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */