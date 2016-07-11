package com.google.android.gms.location.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

class zzh$zza$zza
  implements zzh
{
  private IBinder zznJ;
  
  zzh$zza$zza(IBinder paramIBinder)
  {
    zznJ = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return zznJ;
  }
  
  /* Error */
  public void zza(int paramInt, android.app.PendingIntent paramPendingIntent)
    throws RemoteException
  {
    // Byte code:
    //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: aload_3
    //   5: ldc 32
    //   7: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_3
    //   11: iload_1
    //   12: invokevirtual 40	android/os/Parcel:writeInt	(I)V
    //   15: aload_2
    //   16: ifnull +33 -> 49
    //   19: aload_3
    //   20: iconst_1
    //   21: invokevirtual 40	android/os/Parcel:writeInt	(I)V
    //   24: aload_2
    //   25: aload_3
    //   26: iconst_0
    //   27: invokevirtual 46	android/app/PendingIntent:writeToParcel	(Landroid/os/Parcel;I)V
    //   30: aload_0
    //   31: getfield 18	com/google/android/gms/location/internal/zzh$zza$zza:zznJ	Landroid/os/IBinder;
    //   34: iconst_3
    //   35: aload_3
    //   36: aconst_null
    //   37: iconst_1
    //   38: invokeinterface 52 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 55	android/os/Parcel:recycle	()V
    //   48: return
    //   49: aload_3
    //   50: iconst_0
    //   51: invokevirtual 40	android/os/Parcel:writeInt	(I)V
    //   54: goto -24 -> 30
    //   57: astore_2
    //   58: aload_3
    //   59: invokevirtual 55	android/os/Parcel:recycle	()V
    //   62: aload_2
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	zza
    //   0	64	1	paramInt	int
    //   0	64	2	paramPendingIntent	android.app.PendingIntent
    //   3	56	3	localParcel	Parcel
    // Exception table:
    //   from	to	target	type
    //   4	15	57	finally
    //   19	30	57	finally
    //   30	44	57	finally
    //   49	54	57	finally
  }
  
  public void zza(int paramInt, String[] paramArrayOfString)
    throws RemoteException
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
      localParcel.writeInt(paramInt);
      localParcel.writeStringArray(paramArrayOfString);
      zznJ.transact(1, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void zzb(int paramInt, String[] paramArrayOfString)
    throws RemoteException
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
      localParcel.writeInt(paramInt);
      localParcel.writeStringArray(paramArrayOfString);
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
 * Qualified Name:     com.google.android.gms.location.internal.zzh.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */