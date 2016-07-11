package com.google.android.gms.auth.api.consent;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.ScopeDetail;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class GetConsentIntentRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetConsentIntentRequest> CREATOR = new zzb();
  private final int mVersionCode;
  private final Account zzQd;
  private final String zzSb;
  private final int zzSc;
  private final String zzSd;
  final ScopeDetail[] zzSe;
  private final boolean zzSf;
  private final int zzSg;
  
  GetConsentIntentRequest(int paramInt1, String paramString1, int paramInt2, String paramString2, Account paramAccount, ScopeDetail[] paramArrayOfScopeDetail, boolean paramBoolean, int paramInt3)
  {
    mVersionCode = paramInt1;
    zzSb = paramString1;
    zzSc = paramInt2;
    zzSd = paramString2;
    zzQd = ((Account)zzx.zzw(paramAccount));
    zzSe = paramArrayOfScopeDetail;
    zzSf = paramBoolean;
    zzSg = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Account getAccount()
  {
    return zzQd;
  }
  
  public String getCallingPackage()
  {
    return zzSb;
  }
  
  public int getCallingUid()
  {
    return zzSc;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public String zzlF()
  {
    return zzSd;
  }
  
  public boolean zzlG()
  {
    return zzSf;
  }
  
  public int zzlH()
  {
    return zzSg;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.consent.GetConsentIntentRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */