package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;

class zzcm$zza$zza
  implements zzcm
{
  private IBinder zznJ;
  
  zzcm$zza$zza(IBinder paramIBinder)
  {
    zznJ = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return zznJ;
  }
  
  public double getScale()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
      zznJ.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      double d = localParcel2.readDouble();
      return d;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public android.net.Uri getUri()
    throws RemoteException
  {
    // Byte code:
    //   0: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 33
    //   11: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 18	com/google/android/gms/internal/zzcm$zza$zza:zznJ	Landroid/os/IBinder;
    //   18: iconst_2
    //   19: aload_2
    //   20: aload_3
    //   21: iconst_0
    //   22: invokeinterface 43 5 0
    //   27: pop
    //   28: aload_3
    //   29: invokevirtual 46	android/os/Parcel:readException	()V
    //   32: aload_3
    //   33: invokevirtual 59	android/os/Parcel:readInt	()I
    //   36: ifeq +26 -> 62
    //   39: getstatic 65	android/net/Uri:CREATOR	Landroid/os/Parcelable$Creator;
    //   42: aload_3
    //   43: invokeinterface 71 2 0
    //   48: checkcast 61	android/net/Uri
    //   51: astore_1
    //   52: aload_3
    //   53: invokevirtual 52	android/os/Parcel:recycle	()V
    //   56: aload_2
    //   57: invokevirtual 52	android/os/Parcel:recycle	()V
    //   60: aload_1
    //   61: areturn
    //   62: aconst_null
    //   63: astore_1
    //   64: goto -12 -> 52
    //   67: astore_1
    //   68: aload_3
    //   69: invokevirtual 52	android/os/Parcel:recycle	()V
    //   72: aload_2
    //   73: invokevirtual 52	android/os/Parcel:recycle	()V
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	zza
    //   51	13	1	localUri	android.net.Uri
    //   67	10	1	localObject	Object
    //   3	70	2	localParcel1	Parcel
    //   7	62	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	52	67	finally
  }
  
  public zzd zzdv()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
      zznJ.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      zzd localzzd = zzd.zza.zzbk(localParcel2.readStrongBinder());
      return localzzd;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzcm.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */