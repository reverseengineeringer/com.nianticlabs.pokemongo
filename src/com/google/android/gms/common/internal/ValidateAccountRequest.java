package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValidateAccountRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<ValidateAccountRequest> CREATOR = new zzad();
  final int mVersionCode;
  private final String zzSb;
  final IBinder zzaeH;
  private final Scope[] zzaeI;
  private final int zzagu;
  private final Bundle zzagv;
  
  ValidateAccountRequest(int paramInt1, int paramInt2, IBinder paramIBinder, Scope[] paramArrayOfScope, Bundle paramBundle, String paramString)
  {
    mVersionCode = paramInt1;
    zzagu = paramInt2;
    zzaeH = paramIBinder;
    zzaeI = paramArrayOfScope;
    zzagv = paramBundle;
    zzSb = paramString;
  }
  
  public ValidateAccountRequest(zzp paramzzp, Scope[] paramArrayOfScope, String paramString, Bundle paramBundle) {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getCallingPackage()
  {
    return zzSb;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzad.zza(this, paramParcel, paramInt);
  }
  
  public int zzpu()
  {
    return zzagu;
  }
  
  public Scope[] zzpv()
  {
    return zzaeI;
  }
  
  public Bundle zzpw()
  {
    return zzagv;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.ValidateAccountRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */