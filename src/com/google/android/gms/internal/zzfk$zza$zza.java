package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

class zzfk$zza$zza
  implements zzfk
{
  private IBinder zznJ;
  
  zzfk$zza$zza(IBinder paramIBinder)
  {
    zznJ = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return zznJ;
  }
  
  public void onBackPressed()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
      zznJ.transact(10, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public void onCreate(android.os.Bundle paramBundle)
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
    //   14: aload_1
    //   15: ifnull +41 -> 56
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 55	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 61	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 18	com/google/android/gms/internal/zzfk$zza$zza:zznJ	Landroid/os/IBinder;
    //   33: iconst_1
    //   34: aload_2
    //   35: aload_3
    //   36: iconst_0
    //   37: invokeinterface 42 5 0
    //   42: pop
    //   43: aload_3
    //   44: invokevirtual 45	android/os/Parcel:readException	()V
    //   47: aload_3
    //   48: invokevirtual 48	android/os/Parcel:recycle	()V
    //   51: aload_2
    //   52: invokevirtual 48	android/os/Parcel:recycle	()V
    //   55: return
    //   56: aload_2
    //   57: iconst_0
    //   58: invokevirtual 55	android/os/Parcel:writeInt	(I)V
    //   61: goto -32 -> 29
    //   64: astore_1
    //   65: aload_3
    //   66: invokevirtual 48	android/os/Parcel:recycle	()V
    //   69: aload_2
    //   70: invokevirtual 48	android/os/Parcel:recycle	()V
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	zza
    //   0	75	1	paramBundle	android.os.Bundle
    //   3	67	2	localParcel1	Parcel
    //   7	59	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	64	finally
    //   18	29	64	finally
    //   29	47	64	finally
    //   56	61	64	finally
  }
  
  public void onDestroy()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
      zznJ.transact(8, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void onPause()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
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
  
  public void onRestart()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
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
  
  public void onResume()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
      zznJ.transact(4, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public void onSaveInstanceState(android.os.Bundle paramBundle)
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
    //   14: aload_1
    //   15: ifnull +54 -> 69
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 55	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 61	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 18	com/google/android/gms/internal/zzfk$zza$zza:zznJ	Landroid/os/IBinder;
    //   33: bipush 6
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 42 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 45	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 70	android/os/Parcel:readInt	()I
    //   52: ifeq +8 -> 60
    //   55: aload_1
    //   56: aload_3
    //   57: invokevirtual 74	android/os/Bundle:readFromParcel	(Landroid/os/Parcel;)V
    //   60: aload_3
    //   61: invokevirtual 48	android/os/Parcel:recycle	()V
    //   64: aload_2
    //   65: invokevirtual 48	android/os/Parcel:recycle	()V
    //   68: return
    //   69: aload_2
    //   70: iconst_0
    //   71: invokevirtual 55	android/os/Parcel:writeInt	(I)V
    //   74: goto -45 -> 29
    //   77: astore_1
    //   78: aload_3
    //   79: invokevirtual 48	android/os/Parcel:recycle	()V
    //   82: aload_2
    //   83: invokevirtual 48	android/os/Parcel:recycle	()V
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	zza
    //   0	88	1	paramBundle	android.os.Bundle
    //   3	80	2	localParcel1	Parcel
    //   7	72	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	77	finally
    //   18	29	77	finally
    //   29	60	77	finally
    //   69	74	77	finally
  }
  
  public void onStart()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
      zznJ.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void onStop()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
      zznJ.transact(7, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void zzaE()
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
      zznJ.transact(9, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public boolean zzeF()
    throws RemoteException
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
      zznJ.transact(11, localParcel1, localParcel2, 0);
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
 * Qualified Name:     com.google.android.gms.internal.zzfk.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */