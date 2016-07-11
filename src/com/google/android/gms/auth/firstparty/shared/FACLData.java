package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FACLData
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  final int version;
  FACLConfig zzTD;
  String zzTE;
  boolean zzTF;
  String zzTG;
  
  FACLData(int paramInt, FACLConfig paramFACLConfig, String paramString1, boolean paramBoolean, String paramString2)
  {
    version = paramInt;
    zzTD = paramFACLConfig;
    zzTE = paramString1;
    zzTF = paramBoolean;
    zzTG = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.firstparty.shared.FACLData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */