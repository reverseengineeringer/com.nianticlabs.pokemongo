package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

class zzfv$zza$zza
  implements zzfv
{
  private IBinder zznJ;
  
  zzfv$zza$zza(IBinder paramIBinder)
  {
    zznJ = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return zznJ;
  }
  
  public void finishPurchase()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
      zznJ.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public String getProductId()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
      zznJ.transact(1, localParcel1, localParcel2, 0);
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
  public android.content.Intent getPurchaseData()
    throws RemoteException
  {
    // Byte code:
    //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 32
    //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 18	com/google/android/gms/internal/zzfv$zza$zza:zznJ	Landroid/os/IBinder;
    //   18: iconst_2
    //   19: aload_2
    //   20: aload_3
    //   21: iconst_0
    //   22: invokeinterface 42 5 0
    //   27: pop
    //   28: aload_3
    //   29: invokevirtual 45	android/os/Parcel:readException	()V
    //   32: aload_3
    //   33: invokevirtual 60	android/os/Parcel:readInt	()I
    //   36: ifeq +26 -> 62
    //   39: getstatic 66	android/content/Intent:CREATOR	Landroid/os/Parcelable$Creator;
    //   42: aload_3
    //   43: invokeinterface 72 2 0
    //   48: checkcast 62	android/content/Intent
    //   51: astore_1
    //   52: aload_3
    //   53: invokevirtual 48	android/os/Parcel:recycle	()V
    //   56: aload_2
    //   57: invokevirtual 48	android/os/Parcel:recycle	()V
    //   60: aload_1
    //   61: areturn
    //   62: aconst_null
    //   63: astore_1
    //   64: goto -12 -> 52
    //   67: astore_1
    //   68: aload_3
    //   69: invokevirtual 48	android/os/Parcel:recycle	()V
    //   72: aload_2
    //   73: invokevirtual 48	android/os/Parcel:recycle	()V
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	zza
    //   51	13	1	localIntent	android.content.Intent
    //   67	10	1	localObject	Object
    //   3	70	2	localParcel1	Parcel
    //   7	62	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	52	67	finally
  }
  
  public int getResultCode()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
      zznJ.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean isVerified()
    throws RemoteException
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
      zznJ.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfv.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */