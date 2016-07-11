package com.google.android.gms.auth.api.signin.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInConfig;

public abstract interface zze
  extends IInterface
{
  public abstract void zza(zzd paramzzd, GoogleSignInConfig paramGoogleSignInConfig)
    throws RemoteException;
  
  public abstract void zza(zzd paramzzd, SignInConfiguration paramSignInConfiguration)
    throws RemoteException;
  
  public abstract void zzb(zzd paramzzd, GoogleSignInConfig paramGoogleSignInConfig)
    throws RemoteException;
  
  public abstract void zzb(zzd paramzzd, SignInConfiguration paramSignInConfiguration)
    throws RemoteException;
  
  public abstract void zzc(zzd paramzzd, GoogleSignInConfig paramGoogleSignInConfig)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zze
  {
    public static zze zzaz(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
      if ((localIInterface != null) && ((localIInterface instanceof zze))) {
        return (zze)localIInterface;
      }
      return new zza(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      zzd localzzd1 = null;
      zzd localzzd2 = null;
      Object localObject2 = null;
      Object localObject3 = null;
      Object localObject1 = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.auth.api.signin.internal.ISignInService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        localzzd1 = zzd.zza.zzay(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0) {
          localObject1 = (SignInConfiguration)SignInConfiguration.CREATOR.createFromParcel(paramParcel1);
        }
        zza(localzzd1, (SignInConfiguration)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        localzzd2 = zzd.zza.zzay(paramParcel1.readStrongBinder());
        localObject1 = localzzd1;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (SignInConfiguration)SignInConfiguration.CREATOR.createFromParcel(paramParcel1);
        }
        zzb(localzzd2, (SignInConfiguration)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 101: 
        paramParcel1.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        localzzd1 = zzd.zza.zzay(paramParcel1.readStrongBinder());
        localObject1 = localzzd2;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (GoogleSignInConfig)GoogleSignInConfig.CREATOR.createFromParcel(paramParcel1);
        }
        zza(localzzd1, (GoogleSignInConfig)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 102: 
        paramParcel1.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        localzzd1 = zzd.zza.zzay(paramParcel1.readStrongBinder());
        localObject1 = localObject2;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (GoogleSignInConfig)GoogleSignInConfig.CREATOR.createFromParcel(paramParcel1);
        }
        zzb(localzzd1, (GoogleSignInConfig)localObject1);
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
      localzzd1 = zzd.zza.zzay(paramParcel1.readStrongBinder());
      localObject1 = localObject3;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (GoogleSignInConfig)GoogleSignInConfig.CREATOR.createFromParcel(paramParcel1);
      }
      zzc(localzzd1, (GoogleSignInConfig)localObject1);
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class zza
      implements zze
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
      
      /* Error */
      public void zza(zzd paramzzd, GoogleSignInConfig paramGoogleSignInConfig)
        throws RemoteException
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
        //   16: ifnull +61 -> 77
        //   19: aload_1
        //   20: invokeinterface 40 1 0
        //   25: astore_1
        //   26: aload_3
        //   27: aload_1
        //   28: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   31: aload_2
        //   32: ifnull +50 -> 82
        //   35: aload_3
        //   36: iconst_1
        //   37: invokevirtual 47	android/os/Parcel:writeInt	(I)V
        //   40: aload_2
        //   41: aload_3
        //   42: iconst_0
        //   43: invokevirtual 53	com/google/android/gms/auth/api/signin/GoogleSignInConfig:writeToParcel	(Landroid/os/Parcel;I)V
        //   46: aload_0
        //   47: getfield 18	com/google/android/gms/auth/api/signin/internal/zze$zza$zza:zznJ	Landroid/os/IBinder;
        //   50: bipush 101
        //   52: aload_3
        //   53: aload 4
        //   55: iconst_0
        //   56: invokeinterface 59 5 0
        //   61: pop
        //   62: aload 4
        //   64: invokevirtual 62	android/os/Parcel:readException	()V
        //   67: aload 4
        //   69: invokevirtual 65	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 65	android/os/Parcel:recycle	()V
        //   76: return
        //   77: aconst_null
        //   78: astore_1
        //   79: goto -53 -> 26
        //   82: aload_3
        //   83: iconst_0
        //   84: invokevirtual 47	android/os/Parcel:writeInt	(I)V
        //   87: goto -41 -> 46
        //   90: astore_1
        //   91: aload 4
        //   93: invokevirtual 65	android/os/Parcel:recycle	()V
        //   96: aload_3
        //   97: invokevirtual 65	android/os/Parcel:recycle	()V
        //   100: aload_1
        //   101: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	102	0	this	zza
        //   0	102	1	paramzzd	zzd
        //   0	102	2	paramGoogleSignInConfig	GoogleSignInConfig
        //   3	94	3	localParcel1	Parcel
        //   7	85	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	15	90	finally
        //   19	26	90	finally
        //   26	31	90	finally
        //   35	46	90	finally
        //   46	67	90	finally
        //   82	87	90	finally
      }
      
      /* Error */
      public void zza(zzd paramzzd, SignInConfiguration paramSignInConfiguration)
        throws RemoteException
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
        //   43: invokevirtual 70	com/google/android/gms/auth/api/signin/internal/SignInConfiguration:writeToParcel	(Landroid/os/Parcel;I)V
        //   46: aload_0
        //   47: getfield 18	com/google/android/gms/auth/api/signin/internal/zze$zza$zza:zznJ	Landroid/os/IBinder;
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
        //   0	101	1	paramzzd	zzd
        //   0	101	2	paramSignInConfiguration	SignInConfiguration
        //   3	93	3	localParcel1	Parcel
        //   7	84	4	localParcel2	Parcel
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
      public void zzb(zzd paramzzd, GoogleSignInConfig paramGoogleSignInConfig)
        throws RemoteException
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
        //   16: ifnull +61 -> 77
        //   19: aload_1
        //   20: invokeinterface 40 1 0
        //   25: astore_1
        //   26: aload_3
        //   27: aload_1
        //   28: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   31: aload_2
        //   32: ifnull +50 -> 82
        //   35: aload_3
        //   36: iconst_1
        //   37: invokevirtual 47	android/os/Parcel:writeInt	(I)V
        //   40: aload_2
        //   41: aload_3
        //   42: iconst_0
        //   43: invokevirtual 53	com/google/android/gms/auth/api/signin/GoogleSignInConfig:writeToParcel	(Landroid/os/Parcel;I)V
        //   46: aload_0
        //   47: getfield 18	com/google/android/gms/auth/api/signin/internal/zze$zza$zza:zznJ	Landroid/os/IBinder;
        //   50: bipush 102
        //   52: aload_3
        //   53: aload 4
        //   55: iconst_0
        //   56: invokeinterface 59 5 0
        //   61: pop
        //   62: aload 4
        //   64: invokevirtual 62	android/os/Parcel:readException	()V
        //   67: aload 4
        //   69: invokevirtual 65	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 65	android/os/Parcel:recycle	()V
        //   76: return
        //   77: aconst_null
        //   78: astore_1
        //   79: goto -53 -> 26
        //   82: aload_3
        //   83: iconst_0
        //   84: invokevirtual 47	android/os/Parcel:writeInt	(I)V
        //   87: goto -41 -> 46
        //   90: astore_1
        //   91: aload 4
        //   93: invokevirtual 65	android/os/Parcel:recycle	()V
        //   96: aload_3
        //   97: invokevirtual 65	android/os/Parcel:recycle	()V
        //   100: aload_1
        //   101: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	102	0	this	zza
        //   0	102	1	paramzzd	zzd
        //   0	102	2	paramGoogleSignInConfig	GoogleSignInConfig
        //   3	94	3	localParcel1	Parcel
        //   7	85	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	15	90	finally
        //   19	26	90	finally
        //   26	31	90	finally
        //   35	46	90	finally
        //   46	67	90	finally
        //   82	87	90	finally
      }
      
      /* Error */
      public void zzb(zzd paramzzd, SignInConfiguration paramSignInConfiguration)
        throws RemoteException
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
        //   43: invokevirtual 70	com/google/android/gms/auth/api/signin/internal/SignInConfiguration:writeToParcel	(Landroid/os/Parcel;I)V
        //   46: aload_0
        //   47: getfield 18	com/google/android/gms/auth/api/signin/internal/zze$zza$zza:zznJ	Landroid/os/IBinder;
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
        //   0	101	1	paramzzd	zzd
        //   0	101	2	paramSignInConfiguration	SignInConfiguration
        //   3	93	3	localParcel1	Parcel
        //   7	84	4	localParcel2	Parcel
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
      public void zzc(zzd paramzzd, GoogleSignInConfig paramGoogleSignInConfig)
        throws RemoteException
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
        //   16: ifnull +61 -> 77
        //   19: aload_1
        //   20: invokeinterface 40 1 0
        //   25: astore_1
        //   26: aload_3
        //   27: aload_1
        //   28: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   31: aload_2
        //   32: ifnull +50 -> 82
        //   35: aload_3
        //   36: iconst_1
        //   37: invokevirtual 47	android/os/Parcel:writeInt	(I)V
        //   40: aload_2
        //   41: aload_3
        //   42: iconst_0
        //   43: invokevirtual 53	com/google/android/gms/auth/api/signin/GoogleSignInConfig:writeToParcel	(Landroid/os/Parcel;I)V
        //   46: aload_0
        //   47: getfield 18	com/google/android/gms/auth/api/signin/internal/zze$zza$zza:zznJ	Landroid/os/IBinder;
        //   50: bipush 103
        //   52: aload_3
        //   53: aload 4
        //   55: iconst_0
        //   56: invokeinterface 59 5 0
        //   61: pop
        //   62: aload 4
        //   64: invokevirtual 62	android/os/Parcel:readException	()V
        //   67: aload 4
        //   69: invokevirtual 65	android/os/Parcel:recycle	()V
        //   72: aload_3
        //   73: invokevirtual 65	android/os/Parcel:recycle	()V
        //   76: return
        //   77: aconst_null
        //   78: astore_1
        //   79: goto -53 -> 26
        //   82: aload_3
        //   83: iconst_0
        //   84: invokevirtual 47	android/os/Parcel:writeInt	(I)V
        //   87: goto -41 -> 46
        //   90: astore_1
        //   91: aload 4
        //   93: invokevirtual 65	android/os/Parcel:recycle	()V
        //   96: aload_3
        //   97: invokevirtual 65	android/os/Parcel:recycle	()V
        //   100: aload_1
        //   101: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	102	0	this	zza
        //   0	102	1	paramzzd	zzd
        //   0	102	2	paramGoogleSignInConfig	GoogleSignInConfig
        //   3	94	3	localParcel1	Parcel
        //   7	85	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	15	90	finally
        //   19	26	90	finally
        //   26	31	90	finally
        //   35	46	90	finally
        //   46	67	90	finally
        //   82	87	90	finally
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */