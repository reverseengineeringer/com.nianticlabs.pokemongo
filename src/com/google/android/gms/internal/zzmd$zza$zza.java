package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

class zzmd$zza$zza
  implements zzmd
{
  private IBinder zznJ;
  
  zzmd$zza$zza(IBinder paramIBinder)
  {
    zznJ = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return zznJ;
  }
  
  public void zza(zzmc paramzzmc)
    throws RemoteException
  {
    IBinder localIBinder = null;
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.common.internal.service.ICommonService");
      if (paramzzmc != null) {
        localIBinder = paramzzmc.asBinder();
      }
      localParcel.writeStrongBinder(localIBinder);
      zznJ.transact(1, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzmd.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */