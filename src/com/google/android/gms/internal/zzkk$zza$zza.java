package com.google.android.gms.internal;

import android.os.IBinder;

class zzkk$zza$zza
  implements zzkk
{
  private IBinder zznJ;
  
  zzkk$zza$zza(IBinder paramIBinder)
  {
    zznJ = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return zznJ;
  }
  
  /* Error */
  public void zza(zzkj paramzzkj, com.google.android.gms.auth.api.proxy.ProxyGrpcRequest paramProxyGrpcRequest)
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
    //   16: ifnull +60 -> 76
    //   19: aload_1
    //   20: invokeinterface 40 1 0
    //   25: astore_1
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   31: aload_2
    //   32: ifnull +49 -> 81
    //   35: aload_3
    //   36: iconst_1
    //   37: invokevirtual 47	android/os/Parcel:writeInt	(I)V
    //   40: aload_2
    //   41: aload_3
    //   42: iconst_0
    //   43: invokevirtual 53	com/google/android/gms/auth/api/proxy/ProxyGrpcRequest:writeToParcel	(Landroid/os/Parcel;I)V
    //   46: aload_0
    //   47: getfield 18	com/google/android/gms/internal/zzkk$zza$zza:zznJ	Landroid/os/IBinder;
    //   50: iconst_2
    //   51: aload_3
    //   52: aload 4
    //   54: iconst_0
    //   55: invokeinterface 59 5 0
    //   60: pop
    //   61: aload 4
    //   63: invokevirtual 62	android/os/Parcel:readException	()V
    //   66: aload 4
    //   68: invokevirtual 65	android/os/Parcel:recycle	()V
    //   71: aload_3
    //   72: invokevirtual 65	android/os/Parcel:recycle	()V
    //   75: return
    //   76: aconst_null
    //   77: astore_1
    //   78: goto -52 -> 26
    //   81: aload_3
    //   82: iconst_0
    //   83: invokevirtual 47	android/os/Parcel:writeInt	(I)V
    //   86: goto -40 -> 46
    //   89: astore_1
    //   90: aload 4
    //   92: invokevirtual 65	android/os/Parcel:recycle	()V
    //   95: aload_3
    //   96: invokevirtual 65	android/os/Parcel:recycle	()V
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	zza
    //   0	101	1	paramzzkj	zzkj
    //   0	101	2	paramProxyGrpcRequest	com.google.android.gms.auth.api.proxy.ProxyGrpcRequest
    //   3	93	3	localParcel1	android.os.Parcel
    //   7	84	4	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	89	finally
    //   19	26	89	finally
    //   26	31	89	finally
    //   35	46	89	finally
    //   46	66	89	finally
    //   81	86	89	finally
  }
  
  /* Error */
  public void zza(zzkj paramzzkj, com.google.android.gms.auth.api.proxy.ProxyRequest paramProxyRequest)
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
    //   16: ifnull +60 -> 76
    //   19: aload_1
    //   20: invokeinterface 40 1 0
    //   25: astore_1
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   31: aload_2
    //   32: ifnull +49 -> 81
    //   35: aload_3
    //   36: iconst_1
    //   37: invokevirtual 47	android/os/Parcel:writeInt	(I)V
    //   40: aload_2
    //   41: aload_3
    //   42: iconst_0
    //   43: invokevirtual 70	com/google/android/gms/auth/api/proxy/ProxyRequest:writeToParcel	(Landroid/os/Parcel;I)V
    //   46: aload_0
    //   47: getfield 18	com/google/android/gms/internal/zzkk$zza$zza:zznJ	Landroid/os/IBinder;
    //   50: iconst_1
    //   51: aload_3
    //   52: aload 4
    //   54: iconst_0
    //   55: invokeinterface 59 5 0
    //   60: pop
    //   61: aload 4
    //   63: invokevirtual 62	android/os/Parcel:readException	()V
    //   66: aload 4
    //   68: invokevirtual 65	android/os/Parcel:recycle	()V
    //   71: aload_3
    //   72: invokevirtual 65	android/os/Parcel:recycle	()V
    //   75: return
    //   76: aconst_null
    //   77: astore_1
    //   78: goto -52 -> 26
    //   81: aload_3
    //   82: iconst_0
    //   83: invokevirtual 47	android/os/Parcel:writeInt	(I)V
    //   86: goto -40 -> 46
    //   89: astore_1
    //   90: aload 4
    //   92: invokevirtual 65	android/os/Parcel:recycle	()V
    //   95: aload_3
    //   96: invokevirtual 65	android/os/Parcel:recycle	()V
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	zza
    //   0	101	1	paramzzkj	zzkj
    //   0	101	2	paramProxyRequest	com.google.android.gms.auth.api.proxy.ProxyRequest
    //   3	93	3	localParcel1	android.os.Parcel
    //   7	84	4	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	89	finally
    //   19	26	89	finally
    //   26	31	89	finally
    //   35	46	89	finally
    //   46	66	89	finally
    //   81	86	89	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkk.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */