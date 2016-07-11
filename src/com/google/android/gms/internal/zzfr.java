package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface zzfr
  extends IInterface
{
  public abstract String getProductId()
    throws RemoteException;
  
  public abstract void recordPlayBillingResolution(int paramInt)
    throws RemoteException;
  
  public abstract void recordResolution(int paramInt)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzfr
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
    }
    
    public static zzfr zzO(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
      if ((localIInterface != null) && ((localIInterface instanceof zzfr))) {
        return (zzfr)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
        paramParcel1 = getProductId();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
        recordResolution(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
      recordPlayBillingResolution(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class zza
      implements zzfr
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
      
      public String getProductId()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
          zznJ.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str = localParcel2.readString();
          return str;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void recordPlayBillingResolution(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
          localParcel1.writeInt(paramInt);
          zznJ.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void recordResolution(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
          localParcel1.writeInt(paramInt);
          zznJ.transact(2, localParcel1, localParcel2, 0);
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
 * Qualified Name:     com.google.android.gms.internal.zzfr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */