package com.google.android.gms.gcm;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

class zzb$zza$zza
  implements zzb
{
  private IBinder zznJ;
  
  zzb$zza$zza(IBinder paramIBinder)
  {
    zznJ = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return zznJ;
  }
  
  public void zzgB(int paramInt)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.gcm.INetworkTaskCallback");
      localParcel1.writeInt(paramInt);
      zznJ.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.gcm.zzb.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */