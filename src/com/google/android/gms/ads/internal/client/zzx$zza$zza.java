package com.google.android.gms.ads.internal.client;

import android.os.IBinder;

class zzx$zza$zza
  implements zzx
{
  private IBinder zznJ;
  
  zzx$zza$zza(IBinder paramIBinder)
  {
    zznJ = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return zznJ;
  }
  
  /* Error */
  public IBinder zza(com.google.android.gms.dynamic.zzd paramzzd, int paramInt)
    throws android.os.RemoteException
  {
    // Byte code:
    //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 32
    //   12: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: ifnull +57 -> 73
    //   19: aload_1
    //   20: invokeinterface 40 1 0
    //   25: astore_1
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   31: aload_3
    //   32: iload_2
    //   33: invokevirtual 47	android/os/Parcel:writeInt	(I)V
    //   36: aload_0
    //   37: getfield 18	com/google/android/gms/ads/internal/client/zzx$zza$zza:zznJ	Landroid/os/IBinder;
    //   40: iconst_1
    //   41: aload_3
    //   42: aload 4
    //   44: iconst_0
    //   45: invokeinterface 53 5 0
    //   50: pop
    //   51: aload 4
    //   53: invokevirtual 56	android/os/Parcel:readException	()V
    //   56: aload 4
    //   58: invokevirtual 59	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   61: astore_1
    //   62: aload 4
    //   64: invokevirtual 62	android/os/Parcel:recycle	()V
    //   67: aload_3
    //   68: invokevirtual 62	android/os/Parcel:recycle	()V
    //   71: aload_1
    //   72: areturn
    //   73: aconst_null
    //   74: astore_1
    //   75: goto -49 -> 26
    //   78: astore_1
    //   79: aload 4
    //   81: invokevirtual 62	android/os/Parcel:recycle	()V
    //   84: aload_3
    //   85: invokevirtual 62	android/os/Parcel:recycle	()V
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	zza
    //   0	90	1	paramzzd	com.google.android.gms.dynamic.zzd
    //   0	90	2	paramInt	int
    //   3	82	3	localParcel1	android.os.Parcel
    //   7	73	4	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	78	finally
    //   19	26	78	finally
    //   26	62	78	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzx.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */