package com.google.android.gms.ads.internal.request;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzj$zza
  extends Binder
  implements zzj
{
  public zzj$zza()
  {
    attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
  }
  
  public static zzj zzX(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
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
    Object localObject2 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
      if (paramParcel1.readInt() != 0) {
        localObject1 = AdRequestInfoParcel.CREATOR.zzi(paramParcel1);
      }
      paramParcel1 = zze((AdRequestInfoParcel)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        paramParcel2.writeInt(0);
      }
    }
    paramParcel1.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
    localObject1 = localObject2;
    if (paramParcel1.readInt() != 0) {
      localObject1 = AdRequestInfoParcel.CREATOR.zzi(paramParcel1);
    }
    zza((AdRequestInfoParcel)localObject1, zzk.zza.zzY(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    return true;
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
    
    public void zza(AdRequestInfoParcel paramAdRequestInfoParcel, zzk paramzzk)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
          if (paramAdRequestInfoParcel != null)
          {
            localParcel1.writeInt(1);
            paramAdRequestInfoParcel.writeToParcel(localParcel1, 0);
            if (paramzzk != null)
            {
              paramAdRequestInfoParcel = paramzzk.asBinder();
              localParcel1.writeStrongBinder(paramAdRequestInfoParcel);
              zznJ.transact(2, localParcel1, localParcel2, 0);
              localParcel2.readException();
            }
          }
          else
          {
            localParcel1.writeInt(0);
            continue;
          }
          paramAdRequestInfoParcel = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
    
    public AdResponseParcel zze(AdRequestInfoParcel paramAdRequestInfoParcel)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
          if (paramAdRequestInfoParcel != null)
          {
            localParcel1.writeInt(1);
            paramAdRequestInfoParcel.writeToParcel(localParcel1, 0);
            zznJ.transact(1, localParcel1, localParcel2, 0);
            localParcel2.readException();
            if (localParcel2.readInt() != 0)
            {
              paramAdRequestInfoParcel = AdResponseParcel.CREATOR.zzj(localParcel2);
              return paramAdRequestInfoParcel;
            }
          }
          else
          {
            localParcel1.writeInt(0);
            continue;
          }
          paramAdRequestInfoParcel = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzj.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */