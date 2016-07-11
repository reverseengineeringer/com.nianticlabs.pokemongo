package com.google.android.gms.ads.internal.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CapabilityParcel
  implements SafeParcelable
{
  public static final Parcelable.Creator<CapabilityParcel> CREATOR = new zzi();
  public final int versionCode;
  public final boolean zzFa;
  public final boolean zzFb;
  
  CapabilityParcel(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    versionCode = paramInt;
    zzFa = paramBoolean1;
    zzFb = paramBoolean2;
  }
  
  public CapabilityParcel(boolean paramBoolean1, boolean paramBoolean2)
  {
    this(1, paramBoolean1, paramBoolean2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("iap_supported", zzFa);
    localBundle.putBoolean("default_iap_supported", zzFb);
    return localBundle;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.CapabilityParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */