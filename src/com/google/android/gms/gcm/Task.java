package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.Set;

public abstract class Task
  implements Parcelable
{
  public static final int EXTRAS_LIMIT_BYTES = 10240;
  public static final int NETWORK_STATE_ANY = 2;
  public static final int NETWORK_STATE_CONNECTED = 0;
  public static final int NETWORK_STATE_UNMETERED = 1;
  protected static final long UNINITIALIZED = -1L;
  private final Bundle mExtras;
  private final String mTag;
  private final String zzaCN;
  private final boolean zzaCO;
  private final boolean zzaCP;
  private final int zzaCQ;
  private final boolean zzaCR;
  private final zzc zzaCS;
  
  @Deprecated
  Task(Parcel paramParcel)
  {
    Log.e("Task", "Constructing a Task object using a parcel.");
    zzaCN = paramParcel.readString();
    mTag = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      zzaCO = bool1;
      if (paramParcel.readInt() != 1) {
        break label88;
      }
    }
    label88:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzaCP = bool1;
      zzaCQ = 2;
      zzaCR = false;
      zzaCS = zzc.zzaCI;
      mExtras = null;
      return;
      bool1 = false;
      break;
    }
  }
  
  Task(Builder paramBuilder)
  {
    zzaCN = gcmTaskService;
    mTag = tag;
    zzaCO = updateCurrent;
    zzaCP = isPersisted;
    zzaCQ = requiredNetworkState;
    zzaCR = requiresCharging;
    zzaCS = zzaCT;
    mExtras = extras;
  }
  
  public static void zzA(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      Object localObject = Parcel.obtain();
      paramBundle.writeToParcel((Parcel)localObject, 0);
      int i = ((Parcel)localObject).dataSize();
      if (i > 10240)
      {
        ((Parcel)localObject).recycle();
        throw new IllegalArgumentException("Extras exceeding maximum size(10240 bytes): " + i);
      }
      ((Parcel)localObject).recycle();
      localObject = paramBundle.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!zzz(paramBundle.get((String)((Iterator)localObject).next()))) {
          throw new IllegalArgumentException("Only the following extra parameter types are supported: Integer, Long, Double, String, and Boolean. ");
        }
      }
    }
  }
  
  public static void zza(zzc paramzzc)
  {
    if (paramzzc != null)
    {
      int i = paramzzc.zzvZ();
      if ((i != 1) && (i != 0)) {
        throw new IllegalArgumentException("Must provide a valid RetryPolicy: " + i);
      }
      int j = paramzzc.zzwa();
      int k = paramzzc.zzwb();
      if ((i == 0) && (j < 0)) {
        throw new IllegalArgumentException("InitialBackoffSeconds can't be negative: " + j);
      }
      if ((i == 1) && (j < 10)) {
        throw new IllegalArgumentException("RETRY_POLICY_LINEAR must have an initial backoff at least 10 seconds.");
      }
      if (k < j) {
        throw new IllegalArgumentException("MaximumBackoffSeconds must be greater than InitialBackoffSeconds: " + paramzzc.zzwb());
      }
    }
  }
  
  private static boolean zzz(Object paramObject)
  {
    return ((paramObject instanceof Integer)) || ((paramObject instanceof Long)) || ((paramObject instanceof Double)) || ((paramObject instanceof String)) || ((paramObject instanceof Boolean));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Bundle getExtras()
  {
    return mExtras;
  }
  
  public int getRequiredNetwork()
  {
    return zzaCQ;
  }
  
  public boolean getRequiresCharging()
  {
    return zzaCR;
  }
  
  public String getServiceName()
  {
    return zzaCN;
  }
  
  public String getTag()
  {
    return mTag;
  }
  
  public boolean isPersisted()
  {
    return zzaCP;
  }
  
  public boolean isUpdateCurrent()
  {
    return zzaCO;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    paramBundle.putString("tag", mTag);
    paramBundle.putBoolean("update_current", zzaCO);
    paramBundle.putBoolean("persisted", zzaCP);
    paramBundle.putString("service", zzaCN);
    paramBundle.putInt("requiredNetwork", zzaCQ);
    paramBundle.putBoolean("requiresCharging", zzaCR);
    paramBundle.putBundle("retryStrategy", zzaCS.zzz(new Bundle()));
    paramBundle.putBundle("extras", mExtras);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(zzaCN);
    paramParcel.writeString(mTag);
    if (zzaCO)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!zzaCP) {
        break label52;
      }
    }
    label52:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
    }
  }
  
  public static abstract class Builder
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.gcm.Task
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */