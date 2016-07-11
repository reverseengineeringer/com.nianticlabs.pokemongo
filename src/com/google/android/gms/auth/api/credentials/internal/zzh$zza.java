package com.google.android.gms.auth.api.credentials.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.CredentialRequest;

public abstract class zzh$zza
  extends Binder
  implements zzh
{
  public static zzh zzat(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
    if ((localIInterface != null) && ((localIInterface instanceof zzh))) {
      return (zzh)localIInterface;
    }
    return new zza(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    zzg localzzg1 = null;
    zzg localzzg2 = null;
    Object localObject = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
      localzzg1 = zzg.zza.zzas(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0) {
        localObject = (CredentialRequest)CredentialRequest.CREATOR.createFromParcel(paramParcel1);
      }
      zza(localzzg1, (CredentialRequest)localObject);
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
      localzzg2 = zzg.zza.zzas(paramParcel1.readStrongBinder());
      localObject = localzzg1;
      if (paramParcel1.readInt() != 0) {
        localObject = (SaveRequest)SaveRequest.CREATOR.createFromParcel(paramParcel1);
      }
      zza(localzzg2, (SaveRequest)localObject);
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
      localzzg1 = zzg.zza.zzas(paramParcel1.readStrongBinder());
      localObject = localzzg2;
      if (paramParcel1.readInt() != 0) {
        localObject = (DeleteRequest)DeleteRequest.CREATOR.createFromParcel(paramParcel1);
      }
      zza(localzzg1, (DeleteRequest)localObject);
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
    zza(zzg.zza.zzas(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    return true;
  }
  
  private static class zza
    implements zzh
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
    public void zza(zzg paramzzg)
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
      //   15: ifnull +42 -> 57
      //   18: aload_1
      //   19: invokeinterface 40 1 0
      //   24: astore_1
      //   25: aload_2
      //   26: aload_1
      //   27: invokevirtual 43	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   30: aload_0
      //   31: getfield 18	com/google/android/gms/auth/api/credentials/internal/zzh$zza$zza:zznJ	Landroid/os/IBinder;
      //   34: iconst_4
      //   35: aload_2
      //   36: aload_3
      //   37: iconst_0
      //   38: invokeinterface 49 5 0
      //   43: pop
      //   44: aload_3
      //   45: invokevirtual 52	android/os/Parcel:readException	()V
      //   48: aload_3
      //   49: invokevirtual 55	android/os/Parcel:recycle	()V
      //   52: aload_2
      //   53: invokevirtual 55	android/os/Parcel:recycle	()V
      //   56: return
      //   57: aconst_null
      //   58: astore_1
      //   59: goto -34 -> 25
      //   62: astore_1
      //   63: aload_3
      //   64: invokevirtual 55	android/os/Parcel:recycle	()V
      //   67: aload_2
      //   68: invokevirtual 55	android/os/Parcel:recycle	()V
      //   71: aload_1
      //   72: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	73	0	this	zza
      //   0	73	1	paramzzg	zzg
      //   3	65	2	localParcel1	Parcel
      //   7	57	3	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   8	14	62	finally
      //   18	25	62	finally
      //   25	48	62	finally
    }
    
    /* Error */
    public void zza(zzg paramzzg, CredentialRequest paramCredentialRequest)
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
      //   37: invokevirtual 61	android/os/Parcel:writeInt	(I)V
      //   40: aload_2
      //   41: aload_3
      //   42: iconst_0
      //   43: invokevirtual 67	com/google/android/gms/auth/api/credentials/CredentialRequest:writeToParcel	(Landroid/os/Parcel;I)V
      //   46: aload_0
      //   47: getfield 18	com/google/android/gms/auth/api/credentials/internal/zzh$zza$zza:zznJ	Landroid/os/IBinder;
      //   50: iconst_1
      //   51: aload_3
      //   52: aload 4
      //   54: iconst_0
      //   55: invokeinterface 49 5 0
      //   60: pop
      //   61: aload 4
      //   63: invokevirtual 52	android/os/Parcel:readException	()V
      //   66: aload 4
      //   68: invokevirtual 55	android/os/Parcel:recycle	()V
      //   71: aload_3
      //   72: invokevirtual 55	android/os/Parcel:recycle	()V
      //   75: return
      //   76: aconst_null
      //   77: astore_1
      //   78: goto -52 -> 26
      //   81: aload_3
      //   82: iconst_0
      //   83: invokevirtual 61	android/os/Parcel:writeInt	(I)V
      //   86: goto -40 -> 46
      //   89: astore_1
      //   90: aload 4
      //   92: invokevirtual 55	android/os/Parcel:recycle	()V
      //   95: aload_3
      //   96: invokevirtual 55	android/os/Parcel:recycle	()V
      //   99: aload_1
      //   100: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	101	0	this	zza
      //   0	101	1	paramzzg	zzg
      //   0	101	2	paramCredentialRequest	CredentialRequest
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
    public void zza(zzg paramzzg, DeleteRequest paramDeleteRequest)
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
      //   37: invokevirtual 61	android/os/Parcel:writeInt	(I)V
      //   40: aload_2
      //   41: aload_3
      //   42: iconst_0
      //   43: invokevirtual 71	com/google/android/gms/auth/api/credentials/internal/DeleteRequest:writeToParcel	(Landroid/os/Parcel;I)V
      //   46: aload_0
      //   47: getfield 18	com/google/android/gms/auth/api/credentials/internal/zzh$zza$zza:zznJ	Landroid/os/IBinder;
      //   50: iconst_3
      //   51: aload_3
      //   52: aload 4
      //   54: iconst_0
      //   55: invokeinterface 49 5 0
      //   60: pop
      //   61: aload 4
      //   63: invokevirtual 52	android/os/Parcel:readException	()V
      //   66: aload 4
      //   68: invokevirtual 55	android/os/Parcel:recycle	()V
      //   71: aload_3
      //   72: invokevirtual 55	android/os/Parcel:recycle	()V
      //   75: return
      //   76: aconst_null
      //   77: astore_1
      //   78: goto -52 -> 26
      //   81: aload_3
      //   82: iconst_0
      //   83: invokevirtual 61	android/os/Parcel:writeInt	(I)V
      //   86: goto -40 -> 46
      //   89: astore_1
      //   90: aload 4
      //   92: invokevirtual 55	android/os/Parcel:recycle	()V
      //   95: aload_3
      //   96: invokevirtual 55	android/os/Parcel:recycle	()V
      //   99: aload_1
      //   100: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	101	0	this	zza
      //   0	101	1	paramzzg	zzg
      //   0	101	2	paramDeleteRequest	DeleteRequest
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
    public void zza(zzg paramzzg, SaveRequest paramSaveRequest)
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
      //   37: invokevirtual 61	android/os/Parcel:writeInt	(I)V
      //   40: aload_2
      //   41: aload_3
      //   42: iconst_0
      //   43: invokevirtual 75	com/google/android/gms/auth/api/credentials/internal/SaveRequest:writeToParcel	(Landroid/os/Parcel;I)V
      //   46: aload_0
      //   47: getfield 18	com/google/android/gms/auth/api/credentials/internal/zzh$zza$zza:zznJ	Landroid/os/IBinder;
      //   50: iconst_2
      //   51: aload_3
      //   52: aload 4
      //   54: iconst_0
      //   55: invokeinterface 49 5 0
      //   60: pop
      //   61: aload 4
      //   63: invokevirtual 52	android/os/Parcel:readException	()V
      //   66: aload 4
      //   68: invokevirtual 55	android/os/Parcel:recycle	()V
      //   71: aload_3
      //   72: invokevirtual 55	android/os/Parcel:recycle	()V
      //   75: return
      //   76: aconst_null
      //   77: astore_1
      //   78: goto -52 -> 26
      //   81: aload_3
      //   82: iconst_0
      //   83: invokevirtual 61	android/os/Parcel:writeInt	(I)V
      //   86: goto -40 -> 46
      //   89: astore_1
      //   90: aload 4
      //   92: invokevirtual 55	android/os/Parcel:recycle	()V
      //   95: aload_3
      //   96: invokevirtual 55	android/os/Parcel:recycle	()V
      //   99: aload_1
      //   100: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	101	0	this	zza
      //   0	101	1	paramzzg	zzg
      //   0	101	2	paramSaveRequest	SaveRequest
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
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.internal.zzh.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */