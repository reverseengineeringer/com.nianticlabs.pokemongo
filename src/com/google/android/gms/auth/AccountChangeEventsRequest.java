package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountChangeEventsRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<AccountChangeEventsRequest> CREATOR = new zzb();
  final int mVersion;
  Account zzQd;
  @Deprecated
  String zzRs;
  int zzRu;
  
  public AccountChangeEventsRequest()
  {
    mVersion = 1;
  }
  
  AccountChangeEventsRequest(int paramInt1, int paramInt2, String paramString, Account paramAccount)
  {
    mVersion = paramInt1;
    zzRu = paramInt2;
    zzRs = paramString;
    if ((paramAccount == null) && (!TextUtils.isEmpty(paramString)))
    {
      zzQd = new Account(paramString, "com.google");
      return;
    }
    zzQd = paramAccount;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Account getAccount()
  {
    return zzQd;
  }
  
  public String getAccountName()
  {
    return zzRs;
  }
  
  public int getEventIndex()
  {
    return zzRu;
  }
  
  public AccountChangeEventsRequest setAccount(Account paramAccount)
  {
    zzQd = paramAccount;
    return this;
  }
  
  public AccountChangeEventsRequest setAccountName(String paramString)
  {
    zzRs = paramString;
    return this;
  }
  
  public AccountChangeEventsRequest setEventIndex(int paramInt)
  {
    zzRu = paramInt;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.AccountChangeEventsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */