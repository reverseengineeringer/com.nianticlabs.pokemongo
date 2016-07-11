package com.google.android.gms.ads.internal.overlay;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgr;

@zzgr
public final class AdLauncherIntentInfoParcel
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  public final String intentAction;
  public final String mimeType;
  public final String packageName;
  public final String url;
  public final int versionCode;
  public final String zzAL;
  public final String zzAM;
  public final String zzAN;
  
  public AdLauncherIntentInfoParcel(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    versionCode = paramInt;
    intentAction = paramString1;
    url = paramString2;
    mimeType = paramString3;
    packageName = paramString4;
    zzAL = paramString5;
    zzAM = paramString6;
    zzAN = paramString7;
  }
  
  public AdLauncherIntentInfoParcel(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this(1, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
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
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */