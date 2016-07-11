package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class zza
  extends zzp.zza
{
  private Context mContext;
  private Account zzQd;
  int zzaeG;
  
  public static Account zzb(zzp paramzzp)
  {
    Account localAccount = null;
    long l;
    if (paramzzp != null) {
      l = Binder.clearCallingIdentity();
    }
    try
    {
      localAccount = paramzzp.getAccount();
      return localAccount;
    }
    catch (RemoteException paramzzp)
    {
      Log.w("AccountAccessor", "Remote account accessor probably died");
      return null;
    }
    finally
    {
      Binder.restoreCallingIdentity(l);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zza)) {
      return false;
    }
    return zzQd.equals(zzQd);
  }
  
  public Account getAccount()
  {
    int i = Binder.getCallingUid();
    if (i == zzaeG) {
      return zzQd;
    }
    if (GooglePlayServicesUtil.zze(mContext, i))
    {
      zzaeG = i;
      return zzQd;
    }
    throw new SecurityException("Caller is not GooglePlayServices");
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */