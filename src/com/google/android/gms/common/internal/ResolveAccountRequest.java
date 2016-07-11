package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ResolveAccountRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<ResolveAccountRequest> CREATOR = new zzy();
  final int mVersionCode;
  private final Account zzQd;
  private final int zzagp;
  
  ResolveAccountRequest(int paramInt1, Account paramAccount, int paramInt2)
  {
    mVersionCode = paramInt1;
    zzQd = paramAccount;
    zzagp = paramInt2;
  }
  
  public ResolveAccountRequest(Account paramAccount, int paramInt)
  {
    this(1, paramAccount, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Account getAccount()
  {
    return zzQd;
  }
  
  public int getSessionId()
  {
    return zzagp;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzy.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.ResolveAccountRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */