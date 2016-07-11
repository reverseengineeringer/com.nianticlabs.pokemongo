package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class IdToken
  implements SafeParcelable
{
  public static final Parcelable.Creator<IdToken> CREATOR = new zzd();
  final int mVersionCode;
  private final String zzSk;
  private final String zzSs;
  
  IdToken(int paramInt, String paramString1, String paramString2)
  {
    mVersionCode = paramInt;
    zzSk = paramString1;
    zzSs = paramString2;
  }
  
  public IdToken(String paramString1, String paramString2)
  {
    this(1, paramString1, paramString2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAccountType()
  {
    return zzSk;
  }
  
  public String getIdToken()
  {
    return zzSs;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.IdToken
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */