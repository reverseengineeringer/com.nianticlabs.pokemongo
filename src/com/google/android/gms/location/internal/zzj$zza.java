package com.google.android.gms.location.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.location.LocationSettingsResult;

public abstract class zzj$zza
  extends Binder
  implements zzj
{
  public zzj$zza()
  {
    attachInterface(this, "com.google.android.gms.location.internal.ISettingsCallbacks");
  }
  
  public static zzj zzcc(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.location.internal.ISettingsCallbacks");
    if ((localIInterface != null) && ((localIInterface instanceof zzj))) {
      return (zzj)localIInterface;
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
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.location.internal.ISettingsCallbacks");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.location.internal.ISettingsCallbacks");
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (LocationSettingsResult)LocationSettingsResult.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      zza(paramParcel1);
      return true;
    }
  }
  
  private static class zza
    implements zzj
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
    public void zza(LocationSettingsResult paramLocationSettingsResult)
      throws RemoteException
    {
      // Byte code:
      //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore_2
      //   4: aload_2
      //   5: ldc 32
      //   7: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   10: aload_1
      //   11: ifnull +33 -> 44
      //   14: aload_2
      //   15: iconst_1
      //   16: invokevirtual 40	android/os/Parcel:writeInt	(I)V
      //   19: aload_1
      //   20: aload_2
      //   21: iconst_0
      //   22: invokevirtual 46	com/google/android/gms/location/LocationSettingsResult:writeToParcel	(Landroid/os/Parcel;I)V
      //   25: aload_0
      //   26: getfield 18	com/google/android/gms/location/internal/zzj$zza$zza:zznJ	Landroid/os/IBinder;
      //   29: iconst_1
      //   30: aload_2
      //   31: aconst_null
      //   32: iconst_1
      //   33: invokeinterface 52 5 0
      //   38: pop
      //   39: aload_2
      //   40: invokevirtual 55	android/os/Parcel:recycle	()V
      //   43: return
      //   44: aload_2
      //   45: iconst_0
      //   46: invokevirtual 40	android/os/Parcel:writeInt	(I)V
      //   49: goto -24 -> 25
      //   52: astore_1
      //   53: aload_2
      //   54: invokevirtual 55	android/os/Parcel:recycle	()V
      //   57: aload_1
      //   58: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	59	0	this	zza
      //   0	59	1	paramLocationSettingsResult	LocationSettingsResult
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
 * Qualified Name:     com.google.android.gms.location.internal.zzj.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */