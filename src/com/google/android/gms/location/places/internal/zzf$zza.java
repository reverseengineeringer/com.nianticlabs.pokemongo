package com.google.android.gms.location.places.internal;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.location.places.NearbyAlertRequest;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.PlaceRequest;
import com.google.android.gms.location.places.zze;
import com.google.android.gms.location.places.zzg;

public abstract class zzf$zza
  extends Binder
  implements zzf
{
  public static zzf zzce(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
    if ((localIInterface != null) && ((localIInterface instanceof zzf))) {
      return (zzf)localIInterface;
    }
    return new zza(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    PendingIntent localPendingIntent = null;
    Object localObject2 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = (PlaceRequest)PlaceRequest.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label183;
        }
        localObject2 = PlacesParams.CREATOR.zzeY(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label189;
        }
      }
      for (localPendingIntent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localPendingIntent = null)
      {
        zza((PlaceRequest)localObject1, (PlacesParams)localObject2, localPendingIntent, zzi.zza.zzch(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
        localObject1 = null;
        break;
        localObject2 = null;
        break label133;
      }
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = PlacesParams.CREATOR.zzeY(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label265;
        }
      }
      for (localObject2 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localObject2 = null)
      {
        zza((PlacesParams)localObject1, (PendingIntent)localObject2, zzi.zza.zzch(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
        localObject1 = null;
        break;
      }
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = NearbyAlertRequest.CREATOR.zzeN(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label359;
        }
        localObject2 = PlacesParams.CREATOR.zzeY(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label365;
        }
      }
      for (localPendingIntent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localPendingIntent = null)
      {
        zza((NearbyAlertRequest)localObject1, (PlacesParams)localObject2, localPendingIntent, zzi.zza.zzch(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
        localObject1 = null;
        break;
        localObject2 = null;
        break label309;
      }
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = PlacesParams.CREATOR.zzeY(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label441;
        }
      }
      for (localObject2 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localObject2 = null)
      {
        zzb((PlacesParams)localObject1, (PendingIntent)localObject2, zzi.zza.zzch(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
        localObject1 = null;
        break;
      }
    case 6: 
      label133:
      label183:
      label189:
      label265:
      label309:
      label359:
      label365:
      label441:
      paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
      if (paramParcel1.readInt() != 0) {}
      for (localObject1 = PlaceFilter.CREATOR.zzeO(paramParcel1);; localObject1 = null)
      {
        if (paramParcel1.readInt() != 0) {
          localObject2 = PlacesParams.CREATOR.zzeY(paramParcel1);
        }
        zza((PlaceFilter)localObject1, (PlacesParams)localObject2, zzi.zza.zzch(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
    }
    paramParcel1.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
    if (paramParcel1.readInt() != 0) {}
    for (Object localObject1 = (PlaceReport)PlaceReport.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
    {
      localObject2 = localPendingIntent;
      if (paramParcel1.readInt() != 0) {
        localObject2 = PlacesParams.CREATOR.zzeY(paramParcel1);
      }
      zza((PlaceReport)localObject1, (PlacesParams)localObject2, zzi.zza.zzch(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
  }
  
  private static class zza
    implements zzf
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
    
    public void zza(NearbyAlertRequest paramNearbyAlertRequest, PlacesParams paramPlacesParams, PendingIntent paramPendingIntent, zzi paramzzi)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
          if (paramNearbyAlertRequest != null)
          {
            localParcel1.writeInt(1);
            paramNearbyAlertRequest.writeToParcel(localParcel1, 0);
            if (paramPlacesParams != null)
            {
              localParcel1.writeInt(1);
              paramPlacesParams.writeToParcel(localParcel1, 0);
              if (paramPendingIntent == null) {
                break label150;
              }
              localParcel1.writeInt(1);
              paramPendingIntent.writeToParcel(localParcel1, 0);
              if (paramzzi == null) {
                break label159;
              }
              paramNearbyAlertRequest = paramzzi.asBinder();
              localParcel1.writeStrongBinder(paramNearbyAlertRequest);
              zznJ.transact(4, localParcel1, localParcel2, 0);
              localParcel2.readException();
            }
          }
          else
          {
            localParcel1.writeInt(0);
            continue;
          }
          localParcel1.writeInt(0);
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        continue;
        label150:
        localParcel1.writeInt(0);
        continue;
        label159:
        paramNearbyAlertRequest = null;
      }
    }
    
    public void zza(PlaceFilter paramPlaceFilter, PlacesParams paramPlacesParams, zzi paramzzi)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
          if (paramPlaceFilter != null)
          {
            localParcel1.writeInt(1);
            paramPlaceFilter.writeToParcel(localParcel1, 0);
            if (paramPlacesParams != null)
            {
              localParcel1.writeInt(1);
              paramPlacesParams.writeToParcel(localParcel1, 0);
              if (paramzzi == null) {
                break label132;
              }
              paramPlaceFilter = paramzzi.asBinder();
              localParcel1.writeStrongBinder(paramPlaceFilter);
              zznJ.transact(6, localParcel1, localParcel2, 0);
              localParcel2.readException();
            }
          }
          else
          {
            localParcel1.writeInt(0);
            continue;
          }
          localParcel1.writeInt(0);
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        continue;
        label132:
        paramPlaceFilter = null;
      }
    }
    
    public void zza(PlaceReport paramPlaceReport, PlacesParams paramPlacesParams, zzi paramzzi)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
          if (paramPlaceReport != null)
          {
            localParcel1.writeInt(1);
            paramPlaceReport.writeToParcel(localParcel1, 0);
            if (paramPlacesParams != null)
            {
              localParcel1.writeInt(1);
              paramPlacesParams.writeToParcel(localParcel1, 0);
              if (paramzzi == null) {
                break label132;
              }
              paramPlaceReport = paramzzi.asBinder();
              localParcel1.writeStrongBinder(paramPlaceReport);
              zznJ.transact(7, localParcel1, localParcel2, 0);
              localParcel2.readException();
            }
          }
          else
          {
            localParcel1.writeInt(0);
            continue;
          }
          localParcel1.writeInt(0);
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        continue;
        label132:
        paramPlaceReport = null;
      }
    }
    
    public void zza(PlaceRequest paramPlaceRequest, PlacesParams paramPlacesParams, PendingIntent paramPendingIntent, zzi paramzzi)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
          if (paramPlaceRequest != null)
          {
            localParcel1.writeInt(1);
            paramPlaceRequest.writeToParcel(localParcel1, 0);
            if (paramPlacesParams != null)
            {
              localParcel1.writeInt(1);
              paramPlacesParams.writeToParcel(localParcel1, 0);
              if (paramPendingIntent == null) {
                break label150;
              }
              localParcel1.writeInt(1);
              paramPendingIntent.writeToParcel(localParcel1, 0);
              if (paramzzi == null) {
                break label159;
              }
              paramPlaceRequest = paramzzi.asBinder();
              localParcel1.writeStrongBinder(paramPlaceRequest);
              zznJ.transact(2, localParcel1, localParcel2, 0);
              localParcel2.readException();
            }
          }
          else
          {
            localParcel1.writeInt(0);
            continue;
          }
          localParcel1.writeInt(0);
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        continue;
        label150:
        localParcel1.writeInt(0);
        continue;
        label159:
        paramPlaceRequest = null;
      }
    }
    
    public void zza(PlacesParams paramPlacesParams, PendingIntent paramPendingIntent, zzi paramzzi)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
          if (paramPlacesParams != null)
          {
            localParcel1.writeInt(1);
            paramPlacesParams.writeToParcel(localParcel1, 0);
            if (paramPendingIntent != null)
            {
              localParcel1.writeInt(1);
              paramPendingIntent.writeToParcel(localParcel1, 0);
              if (paramzzi == null) {
                break label131;
              }
              paramPlacesParams = paramzzi.asBinder();
              localParcel1.writeStrongBinder(paramPlacesParams);
              zznJ.transact(3, localParcel1, localParcel2, 0);
              localParcel2.readException();
            }
          }
          else
          {
            localParcel1.writeInt(0);
            continue;
          }
          localParcel1.writeInt(0);
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        continue;
        label131:
        paramPlacesParams = null;
      }
    }
    
    public void zzb(PlacesParams paramPlacesParams, PendingIntent paramPendingIntent, zzi paramzzi)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
          if (paramPlacesParams != null)
          {
            localParcel1.writeInt(1);
            paramPlacesParams.writeToParcel(localParcel1, 0);
            if (paramPendingIntent != null)
            {
              localParcel1.writeInt(1);
              paramPendingIntent.writeToParcel(localParcel1, 0);
              if (paramzzi == null) {
                break label131;
              }
              paramPlacesParams = paramzzi.asBinder();
              localParcel1.writeStrongBinder(paramPlacesParams);
              zznJ.transact(5, localParcel1, localParcel2, 0);
              localParcel2.readException();
            }
          }
          else
          {
            localParcel1.writeInt(0);
            continue;
          }
          localParcel1.writeInt(0);
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        continue;
        label131:
        paramPlacesParams = null;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzf.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */