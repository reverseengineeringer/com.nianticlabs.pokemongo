package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.List;

@Deprecated
public final class PlaceLocalization
  implements SafeParcelable
{
  public static final zzo CREATOR = new zzo();
  public final String address;
  public final String name;
  public final int versionCode;
  public final String zzaHC;
  public final String zzaHD;
  public final List<String> zzaHE;
  
  public PlaceLocalization(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, List<String> paramList)
  {
    versionCode = paramInt;
    name = paramString1;
    address = paramString2;
    zzaHC = paramString3;
    zzaHD = paramString4;
    zzaHE = paramList;
  }
  
  public static PlaceLocalization zza(String paramString1, String paramString2, String paramString3, String paramString4, List<String> paramList)
  {
    return new PlaceLocalization(0, paramString1, paramString2, paramString3, paramString4, paramList);
  }
  
  public int describeContents()
  {
    zzo localzzo = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof PlaceLocalization)) {
        return false;
      }
      paramObject = (PlaceLocalization)paramObject;
    } while ((zzw.equal(name, name)) && (zzw.equal(address, address)) && (zzw.equal(zzaHC, zzaHC)) && (zzw.equal(zzaHD, zzaHD)) && (zzw.equal(zzaHE, zzaHE)));
    return false;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { name, address, zzaHC, zzaHD });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("name", name).zzg("address", address).zzg("internationalPhoneNumber", zzaHC).zzg("regularOpenHours", zzaHD).zzg("attributions", zzaHE).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzo localzzo = CREATOR;
    zzo.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.PlaceLocalization
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */