package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzmd$zza
  extends Binder
  implements zzmd
{
  public static zzmd zzaQ(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
    if ((localIInterface != null) && ((localIInterface instanceof zzmd))) {
      return (zzmd)localIInterface;
    }
    return new zza(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.common.internal.service.ICommonService");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.common.internal.service.ICommonService");
    zza(zzmc.zza.zzaP(paramParcel1.readStrongBinder()));
    return true;
  }
  
  private static class zza
    implements zzmd
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
    
    public void zza(zzmc paramzzmc)
      throws RemoteException
    {
      IBinder localIBinder = null;
      Parcel localParcel = Parcel.obtain();
      try
      {
        localParcel.writeInterfaceToken("com.google.android.gms.common.internal.service.ICommonService");
        if (paramzzmc != null) {
          localIBinder = paramzzmc.asBinder();
        }
        localParcel.writeStrongBinder(localIBinder);
        zznJ.transact(1, localParcel, null, 1);
        return;
      }
      finally
      {
        localParcel.recycle();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzmd.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */