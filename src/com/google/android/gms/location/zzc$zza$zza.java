package com.google.android.gms.location;

import android.os.IBinder;

class zzc$zza$zza
  implements zzc
{
  private IBinder zznJ;
  
  zzc$zza$zza(IBinder paramIBinder)
  {
    zznJ = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return zznJ;
  }
  
  /* Error */
  public void onLocationAvailability(LocationAvailability paramLocationAvailability)
    throws android.os.RemoteException
  {
    // Byte code:
    //   0: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: aload_2
    //   5: ldc 33
    //   7: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_1
    //   11: ifnull +33 -> 44
    //   14: aload_2
    //   15: iconst_1
    //   16: invokevirtual 41	android/os/Parcel:writeInt	(I)V
    //   19: aload_1
    //   20: aload_2
    //   21: iconst_0
    //   22: invokevirtual 47	com/google/android/gms/location/LocationAvailability:writeToParcel	(Landroid/os/Parcel;I)V
    //   25: aload_0
    //   26: getfield 18	com/google/android/gms/location/zzc$zza$zza:zznJ	Landroid/os/IBinder;
    //   29: iconst_2
    //   30: aload_2
    //   31: aconst_null
    //   32: iconst_1
    //   33: invokeinterface 53 5 0
    //   38: pop
    //   39: aload_2
    //   40: invokevirtual 56	android/os/Parcel:recycle	()V
    //   43: return
    //   44: aload_2
    //   45: iconst_0
    //   46: invokevirtual 41	android/os/Parcel:writeInt	(I)V
    //   49: goto -24 -> 25
    //   52: astore_1
    //   53: aload_2
    //   54: invokevirtual 56	android/os/Parcel:recycle	()V
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	zza
    //   0	59	1	paramLocationAvailability	LocationAvailability
    //   3	51	2	localParcel	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   4	10	52	finally
    //   14	25	52	finally
    //   25	39	52	finally
    //   44	49	52	finally
  }
  
  /* Error */
  public void onLocationResult(LocationResult paramLocationResult)
    throws android.os.RemoteException
  {
    // Byte code:
    //   0: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: aload_2
    //   5: ldc 33
    //   7: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_1
    //   11: ifnull +33 -> 44
    //   14: aload_2
    //   15: iconst_1
    //   16: invokevirtual 41	android/os/Parcel:writeInt	(I)V
    //   19: aload_1
    //   20: aload_2
    //   21: iconst_0
    //   22: invokevirtual 62	com/google/android/gms/location/LocationResult:writeToParcel	(Landroid/os/Parcel;I)V
    //   25: aload_0
    //   26: getfield 18	com/google/android/gms/location/zzc$zza$zza:zznJ	Landroid/os/IBinder;
    //   29: iconst_1
    //   30: aload_2
    //   31: aconst_null
    //   32: iconst_1
    //   33: invokeinterface 53 5 0
    //   38: pop
    //   39: aload_2
    //   40: invokevirtual 56	android/os/Parcel:recycle	()V
    //   43: return
    //   44: aload_2
    //   45: iconst_0
    //   46: invokevirtual 41	android/os/Parcel:writeInt	(I)V
    //   49: goto -24 -> 25
    //   52: astore_1
    //   53: aload_2
    //   54: invokevirtual 56	android/os/Parcel:recycle	()V
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	zza
    //   0	59	1	paramLocationResult	LocationResult
    //   3	51	2	localParcel	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   4	10	52	finally
    //   14	25	52	finally
    //   25	39	52	finally
    //   44	49	52	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.zzc.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */