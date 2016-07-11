package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface zzem
  extends IInterface
{
  public abstract zzen zzae(String paramString)
    throws RemoteException;
  
  public abstract boolean zzaf(String paramString)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzem
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }
    
    public static zzem zzE(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
      if ((localIInterface != null) && ((localIInterface instanceof zzem))) {
        return (zzem)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        paramParcel1 = zzae(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (paramParcel1 != null) {}
        for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
        {
          paramParcel2.writeStrongBinder(paramParcel1);
          return true;
        }
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
      boolean bool = zzaf(paramParcel1.readString());
      paramParcel2.writeNoException();
      if (bool) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    }
    
    private static class zza
      implements zzem
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
      
      public zzen zzae(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
          localParcel1.writeString(paramString);
          zznJ.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          paramString = zzen.zza.zzF(localParcel2.readStrongBinder());
          return paramString;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean zzaf(String paramString)
        throws RemoteException
      {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
          localParcel1.writeString(paramString);
          zznJ.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
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
 * Qualified Name:     com.google.android.gms.internal.zzem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */