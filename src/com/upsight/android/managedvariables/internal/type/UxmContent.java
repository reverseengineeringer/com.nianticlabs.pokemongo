package com.upsight.android.managedvariables.internal.type;

import com.upsight.android.analytics.internal.action.ActionMap;
import com.upsight.android.analytics.internal.action.Actionable;

public class UxmContent
  extends Actionable
{
  public static final String PREFERENCES_KEY_UXM_BUNDLE_ID = "uxmBundleId";
  public static final String TRIGGER_CONTENT_RECEIVED = "content_received";
  private boolean mShouldApplyBundle;
  
  private UxmContent(String paramString, ActionMap<UxmContent, UxmContentActions.UxmContentActionContext> paramActionMap, boolean paramBoolean)
  {
    super(paramString, paramActionMap);
    mShouldApplyBundle = paramBoolean;
  }
  
  public static UxmContent create(String paramString, ActionMap<UxmContent, UxmContentActions.UxmContentActionContext> paramActionMap, boolean paramBoolean)
  {
    return new UxmContent(paramString, paramActionMap, paramBoolean);
  }
  
  public boolean shouldApplyBundle()
  {
    return mShouldApplyBundle;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.managedvariables.internal.type.UxmContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */