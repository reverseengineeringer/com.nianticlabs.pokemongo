package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface zzw
  extends IInterface
{
  public abstract void zza()
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzw
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }
    
    public static zzw zzo(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
      if ((localIInterface != null) && ((localIInterface instanceof zzw))) {
        return (zzw)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
      zza();
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class zza
      implements zzw
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
      
      public void zza()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
          zznJ.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
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
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */