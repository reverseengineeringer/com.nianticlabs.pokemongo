package com.google.android.gms.gcm;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;

public abstract class Task$Builder
{
  protected Bundle extras;
  protected String gcmTaskService;
  protected boolean isPersisted;
  protected int requiredNetworkState;
  protected boolean requiresCharging;
  protected String tag;
  protected boolean updateCurrent;
  protected zzc zzaCT = zzc.zzaCI;
  
  public abstract Task build();
  
  protected void checkConditions()
  {
    if (gcmTaskService != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "Must provide an endpoint for this task by calling setService(ComponentName).");
      GcmNetworkManager.zzdh(tag);
      Task.zza(zzaCT);
      if (isPersisted) {
        Task.zzA(extras);
      }
      return;
    }
  }
  
  public abstract Builder setExtras(Bundle paramBundle);
  
  public abstract Builder setPersisted(boolean paramBoolean);
  
  public abstract Builder setRequiredNetwork(int paramInt);
  
  public abstract Builder setRequiresCharging(boolean paramBoolean);
  
  public abstract Builder setService(Class<? extends GcmTaskService> paramClass);
  
  public abstract Builder setTag(String paramString);
  
  public abstract Builder setUpdateCurrent(boolean paramBoolean);
}

/* Location:
 * Qualified Name:     com.google.android.gms.gcm.Task.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */