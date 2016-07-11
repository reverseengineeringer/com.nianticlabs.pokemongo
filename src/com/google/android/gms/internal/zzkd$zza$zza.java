package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

class zzkd$zza$zza
  implements zzkd
{
  private IBinder zznJ;
  
  zzkd$zza$zza(IBinder paramIBinder)
  {
    zznJ = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return zznJ;
  }
  
  public void zza(Account paramAccount, int paramInt, zzkc paramzzkc)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusService");
        if (paramAccount != null)
        {
          localParcel1.writeInt(1);
          paramAccount.writeToParcel(localParcel1, 0);
          localParcel1.writeInt(paramInt);
          if (paramzzkc != null)
          {
            paramAccount = paramzzkc.asBinder();
            localParcel1.writeStrongBinder(paramAccount);
            zznJ.transact(1, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramAccount = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkd.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */