package com.google.android.gms.gcm;

import android.os.Bundle;

public class PeriodicTask$Builder
  extends Task.Builder
{
  private long zzaCG = -1L;
  private long zzaCH = -1L;
  
  public PeriodicTask$Builder()
  {
    isPersisted = true;
  }
  
  public PeriodicTask build()
  {
    checkConditions();
    return new PeriodicTask(this, null);
  }
  
  protected void checkConditions()
  {
    super.checkConditions();
    if (zzaCG == -1L) {
      throw new IllegalArgumentException("Must call setPeriod(long) to establish an execution interval for this periodic task.");
    }
    if (zzaCH == -1L) {
      zzaCH = (((float)zzaCG * 0.1F));
    }
  }
  
  public Builder setExtras(Bundle paramBundle)
  {
    extras = paramBundle;
    return this;
  }
  
  public Builder setFlex(long paramLong)
  {
    zzaCH = paramLong;
    return this;
  }
  
  public Builder setPeriod(long paramLong)
  {
    zzaCG = paramLong;
    return this;
  }
  
  public Builder setPersisted(boolean paramBoolean)
  {
    isPersisted = paramBoolean;
    return this;
  }
  
  public Builder setRequiredNetwork(int paramInt)
  {
    requiredNetworkState = paramInt;
    return this;
  }
  
  public Builder setRequiresCharging(boolean paramBoolean)
  {
    requiresCharging = paramBoolean;
    return this;
  }
  
  public Builder setService(Class<? extends GcmTaskService> paramClass)
  {
    gcmTaskService = paramClass.getName();
    return this;
  }
  
  public Builder setTag(String paramString)
  {
    tag = paramString;
    return this;
  }
  
  public Builder setUpdateCurrent(boolean paramBoolean)
  {
    updateCurrent = paramBoolean;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.gcm.PeriodicTask.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */