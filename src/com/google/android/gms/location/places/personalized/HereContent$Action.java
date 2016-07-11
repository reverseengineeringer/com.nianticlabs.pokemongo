package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;

public final class HereContent$Action
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  final int mVersionCode;
  private final String zzQg;
  private final String zzajf;
  
  HereContent$Action(int paramInt, String paramString1, String paramString2)
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

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.personalized.HereContent.Action
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */