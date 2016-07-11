package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

public abstract class zzcu$zza
  extends Binder
  implements zzcu
{
  public zzcu$zza()
  {
    attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
  }
  
  public static zzcu zzy(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    if ((localIInterface != null) && ((localIInterface instanceof zzcu))) {
      return (zzcu)localIInterface;
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
      paramParcel2.writeString("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
      paramParcel1 = zzU(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
      paramParcel1 = zzV(paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null) {}
      for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
      {
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      }
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
      paramParcel1 = getAvailableAssetNames();
      paramParcel2.writeNoException();
      paramParcel2.writeStringList(paramParcel1);
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
      paramParcel1 = getCustomTemplateId();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
      performClick(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    recordImpression();
    paramParcel2.writeNoException();
    return true;
  }
  
  private static class zza
    implements zzcu
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
    
    public List<String> getAvailableAssetNames()
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
        zznJ.transact(3, localParcel1, localParcel2, 0);
        localParcel2.readException();
        ArrayList localArrayList = localParcel2.createStringArrayList();
        return localArrayList;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
    
    public String getCustomTemplateId()
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
        zznJ.transact(4, localParcel1, localParcel2, 0);
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
    
    public void performClick(String paramString)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
        localParcel1.writeString(paramString);
        zznJ.transact(5, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
    
    public void recordImpression()
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
        zznJ.transact(6, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
    
    public String zzU(String paramString)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
        localParcel1.writeString(paramString);
        zznJ.transact(1, localParcel1, localParcel2, 0);
        localParcel2.readException();
        paramString = localParcel2.readString();
        return paramString;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
    
    public zzcm zzV(String paramString)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
        localParcel1.writeString(paramString);
        zznJ.transact(2, localParcel1, localParcel2, 0);
        localParcel2.readException();
        paramString = zzcm.zza.zzt(localParcel2.readStrongBinder());
        return paramString;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzcu.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */