package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RecordConsentRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<RecordConsentRequest> CREATOR = new zzg();
  final int mVersionCode;
  private final Account zzQd;
  private final String zzTl;
  private final Scope[] zzaVk;
  
  RecordConsentRequest(int paramInt, Account paramAccount, Scope[] paramArrayOfScope, String paramString)
  {
    mVersionCode = paramInt;
    zzQd = paramAccount;
    zzaVk = paramArrayOfScope;
    zzTl = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Account getAccount()
  {
    return zzQd;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
  
  public Scope[] zzCj()
  {
    return zzaVk;
  }
  
  public String zzmb()
  {
    return zzTl;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.signin.internal.RecordConsentRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */