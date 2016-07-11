package com.google.android.gms.internal;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.auth.api.consent.GetConsentIntentRequest;

class zzkg$zza$zza
  implements zzkg
{
  private IBinder zznJ;
  
  zzkg$zza$zza(IBinder paramIBinder)
  {
    zznJ = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return zznJ;
  }
  
  public Intent zza(GetConsentIntentRequest paramGetConsentIntentRequest)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.auth.api.consent.internal.IConsentService");
        if (paramGetConsentIntentRequest != null)
        {
          localParcel1.writeInt(1);
          paramGetConsentIntentRequest.writeToParcel(localParcel1, 0);
          zznJ.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramGetConsentIntentRequest = (Intent)Intent.CREATOR.createFromParcel(localParcel2);
            return paramGetConsentIntentRequest;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramGetConsentIntentRequest = null;
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
 * Qualified Name:     com.google.android.gms.internal.zzkg.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */