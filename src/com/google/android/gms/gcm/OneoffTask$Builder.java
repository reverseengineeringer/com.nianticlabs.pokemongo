package com.google.android.gms.gcm;

import android.os.Bundle;

public class OneoffTask$Builder
  extends Task.Builder
{
  private long zzaCE = -1L;
  private long zzaCF = -1L;
  
  public OneoffTask$Builder()
  {
    isPersisted = false;
  }
  
  public OneoffTask build()
  {
    checkConditions();
    return new OneoffTask(this, null);
  }
  
  protected void checkConditions()
  {
    super.checkConditions();
    if ((zzaCE == -1L) || (zzaCF == -1L)) {
      throw new IllegalArgumentException("Must specify an execution window using setExecutionWindow.");
    }
    if (zzaCE >= zzaCF) {
      throw new IllegalArgumentException("Window start must be shorter than window end.");
    }
  }
  
  public Builder setExecutionWindow(long paramLong1, long paramLong2)
  {
    zzaCE = paramLong1;
    zzaCF = paramLong2;
    return this;
  }
  
  public Builder setExtras(Bundle paramBundle)
  {
    extras = paramBundle;
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
 * Qualified Name:     com.google.android.gms.gcm.OneoffTask.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */