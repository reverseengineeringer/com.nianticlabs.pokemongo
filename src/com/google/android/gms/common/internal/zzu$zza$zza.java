package com.google.android.gms.common.internal;

import android.os.IBinder;

class zzu$zza$zza
  implements zzu
{
  private IBinder zznJ;
  
  zzu$zza$zza(IBinder paramIBinder)
  {
    zznJ = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return zznJ;
  }
  
  /* Error */
  public com.google.android.gms.dynamic.zzd zza(com.google.android.gms.dynamic.zzd paramzzd, int paramInt1, int paramInt2)
    throws android.os.RemoteException
  {
    // Byte code:
    //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 4
    //   5: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 5
    //   10: aload 4
    //   12: ldc 32
    //   14: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload_1
    //   18: ifnull +70 -> 88
    //   21: aload_1
    //   22: invokeinterface 40 1 0
    //   27: astore_1
    //   28: aload 4
    //   30: aload_1
    //   31: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   34: aload 4
    //   36: iload_2
    //   37: invokevirtual 47	android/os/Parcel:writeInt	(I)V
    //   40: aload 4
    //   42: iload_3
    //   43: invokevirtual 47	android/os/Parcel:writeInt	(I)V
    //   46: aload_0
    //   47: getfield 18	com/google/android/gms/common/internal/zzu$zza$zza:zznJ	Landroid/os/IBinder;
    //   50: iconst_1
    //   51: aload 4
    //   53: aload 5
    //   55: iconst_0
    //   56: invokeinterface 53 5 0
    //   61: pop
    //   62: aload 5
    //   64: invokevirtual 56	android/os/Parcel:readException	()V
    //   67: aload 5
    //   69: invokevirtual 59	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   72: invokestatic 65	com/google/android/gms/dynamic/zzd$zza:zzbk	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/zzd;
    //   75: astore_1
    //   76: aload 5
    //   78: invokevirtual 68	android/os/Parcel:recycle	()V
    //   81: aload 4
    //   83: invokevirtual 68	android/os/Parcel:recycle	()V
    //   86: aload_1
    //   87: areturn
    //   88: aconst_null
    //   89: astore_1
    //   90: goto -62 -> 28
    //   93: astore_1
    //   94: aload 5
    //   96: invokevirtual 68	android/os/Parcel:recycle	()V
    //   99: aload 4
    //   101: invokevirtual 68	android/os/Parcel:recycle	()V
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	zza
    //   0	106	1	paramzzd	com.google.android.gms.dynamic.zzd
    //   0	106	2	paramInt1	int
    //   0	106	3	paramInt2	int
    //   3	97	4	localParcel1	android.os.Parcel
    //   8	87	5	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   10	17	93	finally
    //   21	28	93	finally
    //   28	76	93	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzu.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */