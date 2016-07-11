package com.google.android.gms.location.places.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.places.NearbyAlertRequest;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.PlaceRequest;

class zzf$zza$zza
  implements zzf
{
  private IBinder zznJ;
  
  zzf$zza$zza(IBinder paramIBinder)
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

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzf.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */