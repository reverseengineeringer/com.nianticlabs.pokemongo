package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.identity.intents.UserAddressRequest;

class zzpa$zza$zza
  implements zzpa
{
  private IBinder zznJ;
  
  zzpa$zza$zza(IBinder paramIBinder)
  {
    zznJ = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return zznJ;
  }
  
  public void zza(zzoz paramzzoz, UserAddressRequest paramUserAddressRequest, Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    label127:
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.identity.intents.internal.IAddressService");
        if (paramzzoz != null)
        {
          paramzzoz = paramzzoz.asBinder();
          localParcel1.writeStrongBinder(paramzzoz);
          if (paramUserAddressRequest != null)
          {
            localParcel1.writeInt(1);
            paramUserAddressRequest.writeToParcel(localParcel1, 0);
            if (paramBundle == null) {
              break label127;
            }
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
            zznJ.transact(2, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          paramzzoz = null;
          continue;
        }
        localParcel1.writeInt(0);
        continue;
        localParcel1.writeInt(0);
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
 * Qualified Name:     com.google.android.gms.internal.zzpa.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */