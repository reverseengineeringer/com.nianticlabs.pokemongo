package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class PeriodicTask
  extends Task
{
  public static final Parcelable.Creator<PeriodicTask> CREATOR = new Parcelable.Creator()
  {
    public PeriodicTask zzeu(Parcel paramAnonymousParcel)
    {
      return new PeriodicTask(paramAnonymousParcel, null);
    }
    
    public PeriodicTask[] zzgE(int paramAnonymousInt)
    {
      return new PeriodicTask[paramAnonymousInt];
    }
  };
  protected long mFlexInSeconds = -1L;
  protected long mIntervalInSeconds = -1L;
  
  @Deprecated
  private PeriodicTask(Parcel paramParcel)
  {
    super(paramParcel);
    mIntervalInSeconds = paramParcel.readLong();
    mFlexInSeconds = paramParcel.readLong();
  }
  
  private PeriodicTask(Builder paramBuilder)
  {
    super(paramBuilder);
    mIntervalInSeconds = Builder.zza(paramBuilder);
    mFlexInSeconds = Builder.zzb(paramBuilder);
  }
  
  public long getFlex()
  {
    return mFlexInSeconds;
  }
  
  public long getPeriod()
  {
    return mIntervalInSeconds;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putLong("period", mIntervalInSeconds);
    paramBundle.putLong("period_flex", mFlexInSeconds);
  }
  
  public String toString()
  {
    return super.toString() + " " + "period=" + getPeriod() + " " + "flex=" + getFlex();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(mIntervalInSeconds);
    paramParcel.writeLong(mFlexInSeconds);
  }
  
  public static class Builder
    extends Task.Builder
  {
    private long zzaCG = -1L;
    private long zzaCH = -1L;
    
    public Builder()
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.gcm.PeriodicTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */