package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

class zzq$zza$zza
  implements zzq
{
  private IBinder zznJ;
  
  zzq$zza$zza(IBinder paramIBinder)
  {
    zznJ = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return zznJ;
  }
  
  public void cancel()
    throws RemoteException
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.common.internal.ICancelToken");
      zznJ.transact(2, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzq.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */