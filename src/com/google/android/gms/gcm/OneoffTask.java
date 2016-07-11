package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class OneoffTask
  extends Task
{
  public static final Parcelable.Creator<OneoffTask> CREATOR = new Parcelable.Creator()
  {
    public OneoffTask zzes(Parcel paramAnonymousParcel)
    {
      return new OneoffTask(paramAnonymousParcel, null);
    }
    
    public OneoffTask[] zzgC(int paramAnonymousInt)
    {
      return new OneoffTask[paramAnonymousInt];
    }
  };
  private final long zzaCC;
  private final long zzaCD;
  
  @Deprecated
  private OneoffTask(Parcel paramParcel)
  {
    super(paramParcel);
    zzaCC = paramParcel.readLong();
    zzaCD = paramParcel.readLong();
  }
  
  private OneoffTask(Builder paramBuilder)
  {
    super(paramBuilder);
    zzaCC = Builder.zza(paramBuilder);
    zzaCD = Builder.zzb(paramBuilder);
  }
  
  public long getWindowEnd()
  {
    return zzaCD;
  }
  
  public long getWindowStart()
  {
    return zzaCC;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putLong("window_start", zzaCC);
    paramBundle.putLong("window_end", zzaCD);
  }
  
  public String toString()
  {
    return super.toString() + " " + "windowStart=" + getWindowStart() + " " + "windowEnd=" + getWindowEnd();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(zzaCC);
    paramParcel.writeLong(zzaCD);
  }
  
  public static class Builder
    extends Task.Builder
  {
    private long zzaCE = -1L;
    private long zzaCF = -1L;
    
    public Builder()
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.gcm.OneoffTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */