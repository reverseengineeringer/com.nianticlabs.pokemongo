package com.google.android.gms.playlog.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public abstract interface zza
  extends IInterface
{
  public abstract void zza(String paramString, PlayLoggerContext paramPlayLoggerContext, LogEvent paramLogEvent)
    throws RemoteException;
  
  public abstract void zza(String paramString, PlayLoggerContext paramPlayLoggerContext, List<LogEvent> paramList)
    throws RemoteException;
  
  public abstract void zza(String paramString, PlayLoggerContext paramPlayLoggerContext, byte[] paramArrayOfByte)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zza
  {
    public static zza zzdz(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.playlog.internal.IPlayLogService");
      if ((localIInterface != null) && ((localIInterface instanceof zza))) {
        return (zza)localIInterface;
      }
      return new zza(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      String str = null;
      Object localObject2 = null;
      Object localObject1 = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.playlog.internal.IPlayLogService");
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
        str = paramParcel1.readString();
        if (paramParcel1.readInt() != 0) {}
        for (paramParcel2 = PlayLoggerContext.CREATOR.zzgj(paramParcel1);; paramParcel2 = null)
        {
          if (paramParcel1.readInt() != 0) {
            localObject1 = LogEvent.CREATOR.zzgi(paramParcel1);
          }
          zza(str, paramParcel2, (LogEvent)localObject1);
          return true;
        }
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
        localObject1 = paramParcel1.readString();
        paramParcel2 = str;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = PlayLoggerContext.CREATOR.zzgj(paramParcel1);
        }
        zza((String)localObject1, paramParcel2, paramParcel1.createTypedArrayList(LogEvent.CREATOR));
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
      localObject1 = paramParcel1.readString();
      paramParcel2 = (Parcel)localObject2;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = PlayLoggerContext.CREATOR.zzgj(paramParcel1);
      }
      zza((String)localObject1, paramParcel2, paramParcel1.createByteArray());
      return true;
    }
    
    private static class zza
      implements zza
    {
      private IBinder zznJ;
      
      zza(IBinder paramIBinder)
      {
        zznJ = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return zznJ;
      }
      
      public void zza(String paramString, PlayLoggerContext paramPlayLoggerContext, LogEvent paramLogEvent)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
            localParcel.writeString(paramString);
            if (paramPlayLoggerContext != null)
            {
              localParcel.writeInt(1);
              paramPlayLoggerContext.writeToParcel(localParcel, 0);
              if (paramLogEvent != null)
              {
                localParcel.writeInt(1);
                paramLogEvent.writeToParcel(localParcel, 0);
                zznJ.transact(2, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
            localParcel.writeInt(0);
          }
          finally
          {
            localParcel.recycle();
          }
        }
      }
      
      /* Error */
      public void zza(String paramString, PlayLoggerContext paramPlayLoggerContext, List<LogEvent> paramList)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: aload 4
        //   7: ldc 32
        //   9: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   12: aload 4
        //   14: aload_1
        //   15: invokevirtual 39	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   18: aload_2
        //   19: ifnull +43 -> 62
        //   22: aload 4
        //   24: iconst_1
        //   25: invokevirtual 43	android/os/Parcel:writeInt	(I)V
        //   28: aload_2
        //   29: aload 4
        //   31: iconst_0
        //   32: invokevirtual 49	com/google/android/gms/playlog/internal/PlayLoggerContext:writeToParcel	(Landroid/os/Parcel;I)V
        //   35: aload 4
        //   37: aload_3
        //   38: invokevirtual 67	android/os/Parcel:writeTypedList	(Ljava/util/List;)V
        //   41: aload_0
        //   42: getfield 18	com/google/android/gms/playlog/internal/zza$zza$zza:zznJ	Landroid/os/IBinder;
        //   45: iconst_3
        //   46: aload 4
        //   48: aconst_null
        //   49: iconst_1
        //   50: invokeinterface 58 5 0
        //   55: pop
        //   56: aload 4
        //   58: invokevirtual 61	android/os/Parcel:recycle	()V
        //   61: return
        //   62: aload 4
        //   64: iconst_0
        //   65: invokevirtual 43	android/os/Parcel:writeInt	(I)V
        //   68: goto -33 -> 35
        //   71: astore_1
        //   72: aload 4
        //   74: invokevirtual 61	android/os/Parcel:recycle	()V
        //   77: aload_1
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	zza
        //   0	79	1	paramString	String
        //   0	79	2	paramPlayLoggerContext	PlayLoggerContext
        //   0	79	3	paramList	List<LogEvent>
        //   3	70	4	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   5	18	71	finally
        //   22	35	71	finally
        //   35	56	71	finally
        //   62	68	71	finally
      }
      
      /* Error */
      public void zza(String paramString, PlayLoggerContext paramPlayLoggerContext, byte[] paramArrayOfByte)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: aload 4
        //   7: ldc 32
        //   9: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   12: aload 4
        //   14: aload_1
        //   15: invokevirtual 39	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   18: aload_2
        //   19: ifnull +43 -> 62
        //   22: aload 4
        //   24: iconst_1
        //   25: invokevirtual 43	android/os/Parcel:writeInt	(I)V
        //   28: aload_2
        //   29: aload 4
        //   31: iconst_0
        //   32: invokevirtual 49	com/google/android/gms/playlog/internal/PlayLoggerContext:writeToParcel	(Landroid/os/Parcel;I)V
        //   35: aload 4
        //   37: aload_3
        //   38: invokevirtual 74	android/os/Parcel:writeByteArray	([B)V
        //   41: aload_0
        //   42: getfield 18	com/google/android/gms/playlog/internal/zza$zza$zza:zznJ	Landroid/os/IBinder;
        //   45: iconst_4
        //   46: aload 4
        //   48: aconst_null
        //   49: iconst_1
        //   50: invokeinterface 58 5 0
        //   55: pop
        //   56: aload 4
        //   58: invokevirtual 61	android/os/Parcel:recycle	()V
        //   61: return
        //   62: aload 4
        //   64: iconst_0
        //   65: invokevirtual 43	android/os/Parcel:writeInt	(I)V
        //   68: goto -33 -> 35
        //   71: astore_1
        //   72: aload 4
        //   74: invokevirtual 61	android/os/Parcel:recycle	()V
        //   77: aload_1
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	zza
        //   0	79	1	paramString	String
        //   0	79	2	paramPlayLoggerContext	PlayLoggerContext
        //   0	79	3	paramArrayOfByte	byte[]
        //   3	70	4	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   5	18	71	finally
        //   22	35	71	finally
        //   35	56	71	finally
        //   62	68	71	finally
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.playlog.internal.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */