package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgr;

@zzgr
public final class VersionInfoParcel
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  public final int versionCode;
  public String zzJu;
  public int zzJv;
  public int zzJw;
  public boolean zzJx;
  
  public VersionInfoParcel(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  VersionInfoParcel(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    versionCode = paramInt1;
    zzJu = paramString;
    zzJv = paramInt2;
    zzJw = paramInt3;
    zzJx = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.util.client.VersionInfoParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */