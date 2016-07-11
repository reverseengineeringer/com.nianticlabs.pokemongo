package com.upsight.android.analytics.internal.provider;

import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.provider.UpsightOptOutStatus;
import com.upsight.android.internal.util.PreferencesHelper;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
final class OptOutStatus
  extends UpsightOptOutStatus
{
  private static final String PREFERENCES_KEY_OPT_OUT = "optOut";
  UpsightContext mUpsight;
  
  @Inject
  OptOutStatus(UpsightContext paramUpsightContext)
  {
    mUpsight = paramUpsightContext;
  }
  
  public boolean get()
  {
    return PreferencesHelper.getBoolean(mUpsight, "optOut", false);
  }
  
  public void set(boolean paramBoolean)
  {
    PreferencesHelper.putBoolean(mUpsight, "optOut", paramBoolean);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.provider.OptOutStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */