package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;
import java.util.ArrayList;
import java.util.List;

class zzcq$zza$zza
  implements zzcq
{
  private IBinder zznJ;
  
  zzcq$zza$zza(IBinder paramIBinder)
  {
    zznJ = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return zznJ;
  }
  
  public String getBody()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
      zznJ.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public String getCallToAction()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
      zznJ.transact(7, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public android.os.Bundle getExtras()
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
    //   15: getfield 18	com/google/android/gms/internal/zzcq$zza$zza:zznJ	Landroid/os/IBinder;
    //   18: bipush 11
    //   20: aload_2
    //   21: aload_3
    //   22: iconst_0
    //   23: invokeinterface 43 5 0
    //   28: pop
    //   29: aload_3
    //   30: invokevirtual 46	android/os/Parcel:readException	()V
    //   33: aload_3
    //   34: invokevirtual 60	android/os/Parcel:readInt	()I
    //   37: ifeq +26 -> 63
    //   40: getstatic 66	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
    //   43: aload_3
    //   44: invokeinterface 72 2 0
    //   49: checkcast 62	android/os/Bundle
    //   52: astore_1
    //   53: aload_3
    //   54: invokevirtual 52	android/os/Parcel:recycle	()V
    //   57: aload_2
    //   58: invokevirtual 52	android/os/Parcel:recycle	()V
    //   61: aload_1
    //   62: areturn
    //   63: aconst_null
    //   64: astore_1
    //   65: goto -12 -> 53
    //   68: astore_1
    //   69: aload_3
    //   70: invokevirtual 52	android/os/Parcel:recycle	()V
    //   73: aload_2
    //   74: invokevirtual 52	android/os/Parcel:recycle	()V
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	zza
    //   52	13	1	localBundle	android.os.Bundle
    //   68	10	1	localObject	Object
    //   3	71	2	localParcel1	Parcel
    //   7	63	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	53	68	finally
  }
  
  public String getHeadline()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
      zznJ.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public List getImages()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
      zznJ.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      ArrayList localArrayList = localParcel2.readArrayList(getClass().getClassLoader());
      return localArrayList;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public String getPrice()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
      zznJ.transact(10, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public double getStarRating()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
      zznJ.transact(8, localParcel1, localParcel2, 0);
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
  
  public String getStore()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
      zznJ.transact(9, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public zzcm zzdw()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
      zznJ.transact(6, localParcel1, localParcel2, 0);
      localParcel2.readException();
      zzcm localzzcm = zzcm.zza.zzt(localParcel2.readStrongBinder());
      return localzzcm;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public zzd zzdx()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
      zznJ.transact(2, localParcel1, localParcel2, 0);
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
 * Qualified Name:     com.google.android.gms.internal.zzcq.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */