package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.List;

public class HereContent
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  final int mVersionCode;
  private final String zzaHW;
  private final List<Action> zzaHX;
  
  HereContent(int paramInt, String paramString, List<Action> paramList)
  {
    mVersionCode = paramInt;
    zzaHW = paramString;
    zzaHX = paramList;
  }
  
  public int describeContents()
  {
    zzb localzzb = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof HereContent)) {
        return false;
      }
      paramObject = (HereContent)paramObject;
    } while ((zzw.equal(zzaHW, zzaHW)) && (zzw.equal(zzaHX, zzaHX)));
    return false;
  }
  
  public List<Action> getActions()
  {
    return zzaHX;
  }
  
  public String getData()
  {
    return zzaHW;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { zzaHW, zzaHX });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("data", zzaHW).zzg("actions", zzaHX).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb localzzb = CREATOR;
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public static final class Action
    implements SafeParcelable
  {
    public static final zza CREATOR = new zza();
    final int mVersionCode;
    private final String zzQg;
    private final String zzajf;
    
    Action(int paramInt, String paramString1, String paramString2)
    {
      mVersionCode = paramInt;
      zzajf = paramString1;
      zzQg = paramString2;
    }
    
    public int describeContents()
    {
      zza localzza = CREATOR;
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof Action)) {
          return false;
        }
        paramObject = (Action)paramObject;
      } while ((zzw.equal(zzajf, zzajf)) && (zzw.equal(zzQg, zzQg)));
      return false;
    }
    
    public String getTitle()
    {
      return zzajf;
    }
    
    public String getUri()
    {
      return zzQg;
    }
    
    public int hashCode()
    {
      return zzw.hashCode(new Object[] { zzajf, zzQg });
    }
    
    public String toString()
    {
      return zzw.zzv(this).zzg("title", zzajf).zzg("uri", zzQg).toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zza localzza = CREATOR;
      zza.zza(this, paramParcel, paramInt);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.personalized.HereContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */