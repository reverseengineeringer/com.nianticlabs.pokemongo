package com.google.android.gms.location.places.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zze;

public abstract class zzi$zza
  extends Binder
  implements zzi
{
  public zzi$zza()
  {
    attachInterface(this, "com.google.android.gms.location.places.internal.IPlacesCallbacks");
  }
  
  public static zzi zzch(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
    if ((localIInterface != null) && ((localIInterface instanceof zzi))) {
      return (zzi)localIInterface;
    }
    return new zza(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.location.places.internal.IPlacesCallbacks");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
      paramParcel2 = (Parcel)localObject1;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = DataHolder.CREATOR.zzag(paramParcel1);
      }
      zzab(paramParcel2);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
      paramParcel2 = (Parcel)localObject2;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = DataHolder.CREATOR.zzag(paramParcel1);
      }
      zzac(paramParcel2);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
      paramParcel2 = (Parcel)localObject3;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = DataHolder.CREATOR.zzag(paramParcel1);
      }
      zzad(paramParcel2);
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
      paramParcel2 = (Parcel)localObject4;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (Status)Status.CREATOR.createFromParcel(paramParcel1);
      }
      zzaN(paramParcel2);
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
    paramParcel2 = (Parcel)localObject5;
    if (paramParcel1.readInt() != 0) {
      paramParcel2 = DataHolder.CREATOR.zzag(paramParcel1);
    }
    zzae(paramParcel2);
    return true;
  }
  
  private static class zza
    implements zzi
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
    public void zzaN(Status paramStatus)
      throws RemoteException
    {
      // Byte code:
      //   0: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore_2
      //   4: aload_2
      //   5: ldc 33
      //   7: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   10: aload_1
      //   11: ifnull +33 -> 44
      //   14: aload_2
      //   15: iconst_1
      //   16: invokevirtual 41	android/os/Parcel:writeInt	(I)V
      //   19: aload_1
      //   20: aload_2
      //   21: iconst_0
      //   22: invokevirtual 47	com/google/android/gms/common/api/Status:writeToParcel	(Landroid/os/Parcel;I)V
      //   25: aload_0
      //   26: getfield 18	com/google/android/gms/location/places/internal/zzi$zza$zza:zznJ	Landroid/os/IBinder;
      //   29: iconst_4
      //   30: aload_2
      //   31: aconst_null
      //   32: iconst_1
      //   33: invokeinterface 53 5 0
      //   38: pop
      //   39: aload_2
      //   40: invokevirtual 56	android/os/Parcel:recycle	()V
      //   43: return
      //   44: aload_2
      //   45: iconst_0
      //   46: invokevirtual 41	android/os/Parcel:writeInt	(I)V
      //   49: goto -24 -> 25
      //   52: astore_1
      //   53: aload_2
      //   54: invokevirtual 56	android/os/Parcel:recycle	()V
      //   57: aload_1
      //   58: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	59	0	this	zza
      //   0	59	1	paramStatus	Status
      //   3	51	2	localParcel	Parcel
      // Exception table:
      //   from	to	target	type
      //   4	10	52	finally
      //   14	25	52	finally
      //   25	39	52	finally
      //   44	49	52	finally
    }
    
    /* Error */
    public void zzab(DataHolder paramDataHolder)
      throws RemoteException
    {
      // Byte code:
      //   0: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore_2
      //   4: aload_2
      //   5: ldc 33
      //   7: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   10: aload_1
      //   11: ifnull +33 -> 44
      //   14: aload_2
      //   15: iconst_1
      //   16: invokevirtual 41	android/os/Parcel:writeInt	(I)V
      //   19: aload_1
      //   20: aload_2
      //   21: iconst_0
      //   22: invokevirtual 62	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
      //   25: aload_0
      //   26: getfield 18	com/google/android/gms/location/places/internal/zzi$zza$zza:zznJ	Landroid/os/IBinder;
      //   29: iconst_1
      //   30: aload_2
      //   31: aconst_null
      //   32: iconst_1
      //   33: invokeinterface 53 5 0
      //   38: pop
      //   39: aload_2
      //   40: invokevirtual 56	android/os/Parcel:recycle	()V
      //   43: return
      //   44: aload_2
      //   45: iconst_0
      //   46: invokevirtual 41	android/os/Parcel:writeInt	(I)V
      //   49: goto -24 -> 25
      //   52: astore_1
      //   53: aload_2
      //   54: invokevirtual 56	android/os/Parcel:recycle	()V
      //   57: aload_1
      //   58: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	59	0	this	zza
      //   0	59	1	paramDataHolder	DataHolder
      //   3	51	2	localParcel	Parcel
      // Exception table:
      //   from	to	target	type
      //   4	10	52	finally
      //   14	25	52	finally
      //   25	39	52	finally
      //   44	49	52	finally
    }
    
    /* Error */
    public void zzac(DataHolder paramDataHolder)
      throws RemoteException
    {
      // Byte code:
      //   0: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore_2
      //   4: aload_2
      //   5: ldc 33
      //   7: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   10: aload_1
      //   11: ifnull +33 -> 44
      //   14: aload_2
      //   15: iconst_1
      //   16: invokevirtual 41	android/os/Parcel:writeInt	(I)V
      //   19: aload_1
      //   20: aload_2
      //   21: iconst_0
      //   22: invokevirtual 62	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
      //   25: aload_0
      //   26: getfield 18	com/google/android/gms/location/places/internal/zzi$zza$zza:zznJ	Landroid/os/IBinder;
      //   29: iconst_2
      //   30: aload_2
      //   31: aconst_null
      //   32: iconst_1
      //   33: invokeinterface 53 5 0
      //   38: pop
      //   39: aload_2
      //   40: invokevirtual 56	android/os/Parcel:recycle	()V
      //   43: return
      //   44: aload_2
      //   45: iconst_0
      //   46: invokevirtual 41	android/os/Parcel:writeInt	(I)V
      //   49: goto -24 -> 25
      //   52: astore_1
      //   53: aload_2
      //   54: invokevirtual 56	android/os/Parcel:recycle	()V
      //   57: aload_1
      //   58: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	59	0	this	zza
      //   0	59	1	paramDataHolder	DataHolder
      //   3	51	2	localParcel	Parcel
      // Exception table:
      //   from	to	target	type
      //   4	10	52	finally
      //   14	25	52	finally
      //   25	39	52	finally
      //   44	49	52	finally
    }
    
    /* Error */
    public void zzad(DataHolder paramDataHolder)
      throws RemoteException
    {
      // Byte code:
      //   0: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore_2
      //   4: aload_2
      //   5: ldc 33
      //   7: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   10: aload_1
      //   11: ifnull +33 -> 44
      //   14: aload_2
      //   15: iconst_1
      //   16: invokevirtual 41	android/os/Parcel:writeInt	(I)V
      //   19: aload_1
      //   20: aload_2
      //   21: iconst_0
      //   22: invokevirtual 62	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
      //   25: aload_0
      //   26: getfield 18	com/google/android/gms/location/places/internal/zzi$zza$zza:zznJ	Landroid/os/IBinder;
      //   29: iconst_3
      //   30: aload_2
      //   31: aconst_null
      //   32: iconst_1
      //   33: invokeinterface 53 5 0
      //   38: pop
      //   39: aload_2
      //   40: invokevirtual 56	android/os/Parcel:recycle	()V
      //   43: return
      //   44: aload_2
      //   45: iconst_0
      //   46: invokevirtual 41	android/os/Parcel:writeInt	(I)V
      //   49: goto -24 -> 25
      //   52: astore_1
      //   53: aload_2
      //   54: invokevirtual 56	android/os/Parcel:recycle	()V
      //   57: aload_1
      //   58: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	59	0	this	zza
      //   0	59	1	paramDataHolder	DataHolder
      //   3	51	2	localParcel	Parcel
      // Exception table:
      //   from	to	target	type
      //   4	10	52	finally
      //   14	25	52	finally
      //   25	39	52	finally
      //   44	49	52	finally
    }
    
    /* Error */
    public void zzae(DataHolder paramDataHolder)
      throws RemoteException
    {
      // Byte code:
      //   0: invokestatic 31	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore_2
      //   4: aload_2
      //   5: ldc 33
      //   7: invokevirtual 37	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   10: aload_1
      //   11: ifnull +33 -> 44
      //   14: aload_2
      //   15: iconst_1
      //   16: invokevirtual 41	android/os/Parcel:writeInt	(I)V
      //   19: aload_1
      //   20: aload_2
      //   21: iconst_0
      //   22: invokevirtual 62	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
      //   25: aload_0
      //   26: getfield 18	com/google/android/gms/location/places/internal/zzi$zza$zza:zznJ	Landroid/os/IBinder;
      //   29: iconst_5
      //   30: aload_2
      //   31: aconst_null
      //   32: iconst_1
      //   33: invokeinterface 53 5 0
      //   38: pop
      //   39: aload_2
      //   40: invokevirtual 56	android/os/Parcel:recycle	()V
      //   43: return
      //   44: aload_2
      //   45: iconst_0
      //   46: invokevirtual 41	android/os/Parcel:writeInt	(I)V
      //   49: goto -24 -> 25
      //   52: astore_1
      //   53: aload_2
      //   54: invokevirtual 56	android/os/Parcel:recycle	()V
      //   57: aload_1
      //   58: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	59	0	this	zza
      //   0	59	1	paramDataHolder	DataHolder
      //   3	51	2	localParcel	Parcel
      // Exception table:
      //   from	to	target	type
      //   4	10	52	finally
      //   14	25	52	finally
      //   25	39	52	finally
      //   44	49	52	finally
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzi.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */