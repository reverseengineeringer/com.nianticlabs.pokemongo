package com.google.android.gms.location.places.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.NearbyAlertRequest;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.PlaceRequest;
import com.google.android.gms.location.places.UserDataType;
import com.google.android.gms.location.places.personalized.PlaceAlias;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;

class zzg$zza$zza
  implements zzg
{
  private IBinder zznJ;
  
  zzg$zza$zza(IBinder paramIBinder)
  {
    zznJ = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return zznJ;
  }
  
  public void zza(AddPlaceRequest paramAddPlaceRequest, PlacesParams paramPlacesParams, zzi paramzzi)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (paramAddPlaceRequest != null)
        {
          localParcel1.writeInt(1);
          paramAddPlaceRequest.writeToParcel(localParcel1, 0);
          if (paramPlacesParams != null)
          {
            localParcel1.writeInt(1);
            paramPlacesParams.writeToParcel(localParcel1, 0);
            if (paramzzi == null) {
              break label132;
            }
            paramAddPlaceRequest = paramzzi.asBinder();
            localParcel1.writeStrongBinder(paramAddPlaceRequest);
            zznJ.transact(14, localParcel1, localParcel2, 0);
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
      paramAddPlaceRequest = null;
    }
  }
  
  public void zza(NearbyAlertRequest paramNearbyAlertRequest, PlacesParams paramPlacesParams, PendingIntent paramPendingIntent)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (paramNearbyAlertRequest != null)
        {
          localParcel1.writeInt(1);
          paramNearbyAlertRequest.writeToParcel(localParcel1, 0);
          if (paramPlacesParams != null)
          {
            localParcel1.writeInt(1);
            paramPlacesParams.writeToParcel(localParcel1, 0);
            if (paramPendingIntent == null) {
              break label132;
            }
            localParcel1.writeInt(1);
            paramPendingIntent.writeToParcel(localParcel1, 0);
            zznJ.transact(11, localParcel1, localParcel2, 0);
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
      localParcel1.writeInt(0);
    }
  }
  
  public void zza(PlaceReport paramPlaceReport, PlacesParams paramPlacesParams)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (paramPlaceReport != null)
        {
          localParcel1.writeInt(1);
          paramPlaceReport.writeToParcel(localParcel1, 0);
          if (paramPlacesParams != null)
          {
            localParcel1.writeInt(1);
            paramPlacesParams.writeToParcel(localParcel1, 0);
            zznJ.transact(15, localParcel1, localParcel2, 0);
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
    }
  }
  
  public void zza(PlaceRequest paramPlaceRequest, PlacesParams paramPlacesParams, PendingIntent paramPendingIntent)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (paramPlaceRequest != null)
        {
          localParcel1.writeInt(1);
          paramPlaceRequest.writeToParcel(localParcel1, 0);
          if (paramPlacesParams != null)
          {
            localParcel1.writeInt(1);
            paramPlacesParams.writeToParcel(localParcel1, 0);
            if (paramPendingIntent == null) {
              break label132;
            }
            localParcel1.writeInt(1);
            paramPendingIntent.writeToParcel(localParcel1, 0);
            zznJ.transact(9, localParcel1, localParcel2, 0);
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
      localParcel1.writeInt(0);
    }
  }
  
  public void zza(UserDataType paramUserDataType, LatLngBounds paramLatLngBounds, List<String> paramList, PlacesParams paramPlacesParams, zzi paramzzi)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (paramUserDataType != null)
        {
          localParcel1.writeInt(1);
          paramUserDataType.writeToParcel(localParcel1, 0);
          if (paramLatLngBounds != null)
          {
            localParcel1.writeInt(1);
            paramLatLngBounds.writeToParcel(localParcel1, 0);
            localParcel1.writeStringList(paramList);
            if (paramPlacesParams == null) {
              break label159;
            }
            localParcel1.writeInt(1);
            paramPlacesParams.writeToParcel(localParcel1, 0);
            if (paramzzi == null) {
              break label168;
            }
            paramUserDataType = paramzzi.asBinder();
            localParcel1.writeStrongBinder(paramUserDataType);
            zznJ.transact(8, localParcel1, localParcel2, 0);
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
      label159:
      localParcel1.writeInt(0);
      continue;
      label168:
      paramUserDataType = null;
    }
  }
  
  public void zza(PlacesParams paramPlacesParams, PendingIntent paramPendingIntent)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (paramPlacesParams != null)
        {
          localParcel1.writeInt(1);
          paramPlacesParams.writeToParcel(localParcel1, 0);
          if (paramPendingIntent != null)
          {
            localParcel1.writeInt(1);
            paramPendingIntent.writeToParcel(localParcel1, 0);
            zznJ.transact(10, localParcel1, localParcel2, 0);
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
    }
  }
  
  public void zza(PlaceAlias paramPlaceAlias, String paramString1, String paramString2, PlacesParams paramPlacesParams, zzi paramzzi)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (paramPlaceAlias != null)
        {
          localParcel1.writeInt(1);
          paramPlaceAlias.writeToParcel(localParcel1, 0);
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          if (paramPlacesParams != null)
          {
            localParcel1.writeInt(1);
            paramPlacesParams.writeToParcel(localParcel1, 0);
            if (paramzzi == null) {
              break label148;
            }
            paramPlaceAlias = paramzzi.asBinder();
            localParcel1.writeStrongBinder(paramPlaceAlias);
            zznJ.transact(16, localParcel1, localParcel2, 0);
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
      label148:
      paramPlaceAlias = null;
    }
  }
  
  public void zza(LatLng paramLatLng, PlaceFilter paramPlaceFilter, PlacesParams paramPlacesParams, zzi paramzzi)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (paramLatLng != null)
        {
          localParcel1.writeInt(1);
          paramLatLng.writeToParcel(localParcel1, 0);
          if (paramPlaceFilter != null)
          {
            localParcel1.writeInt(1);
            paramPlaceFilter.writeToParcel(localParcel1, 0);
            if (paramPlacesParams == null) {
              break label150;
            }
            localParcel1.writeInt(1);
            paramPlacesParams.writeToParcel(localParcel1, 0);
            if (paramzzi == null) {
              break label159;
            }
            paramLatLng = paramzzi.asBinder();
            localParcel1.writeStrongBinder(paramLatLng);
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
      paramLatLng = null;
    }
  }
  
  public void zza(LatLngBounds paramLatLngBounds, int paramInt, String paramString, PlaceFilter paramPlaceFilter, PlacesParams paramPlacesParams, zzi paramzzi)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (paramLatLngBounds != null)
        {
          localParcel1.writeInt(1);
          paramLatLngBounds.writeToParcel(localParcel1, 0);
          localParcel1.writeInt(paramInt);
          localParcel1.writeString(paramString);
          if (paramPlaceFilter != null)
          {
            localParcel1.writeInt(1);
            paramPlaceFilter.writeToParcel(localParcel1, 0);
            if (paramPlacesParams == null) {
              break label166;
            }
            localParcel1.writeInt(1);
            paramPlacesParams.writeToParcel(localParcel1, 0);
            if (paramzzi == null) {
              break label175;
            }
            paramLatLngBounds = paramzzi.asBinder();
            localParcel1.writeStrongBinder(paramLatLngBounds);
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
      label166:
      localParcel1.writeInt(0);
      continue;
      label175:
      paramLatLngBounds = null;
    }
  }
  
  public void zza(String paramString, int paramInt1, int paramInt2, int paramInt3, PlacesParams paramPlacesParams, zzh paramzzh)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        localParcel1.writeString(paramString);
        localParcel1.writeInt(paramInt1);
        localParcel1.writeInt(paramInt2);
        localParcel1.writeInt(paramInt3);
        if (paramPlacesParams != null)
        {
          localParcel1.writeInt(1);
          paramPlacesParams.writeToParcel(localParcel1, 0);
          if (paramzzh != null)
          {
            paramString = paramzzh.asBinder();
            localParcel1.writeStrongBinder(paramString);
            zznJ.transact(20, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramString = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public void zza(String paramString, int paramInt, PlacesParams paramPlacesParams, zzi paramzzi)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        localParcel1.writeString(paramString);
        localParcel1.writeInt(paramInt);
        if (paramPlacesParams != null)
        {
          localParcel1.writeInt(1);
          paramPlacesParams.writeToParcel(localParcel1, 0);
          if (paramzzi != null)
          {
            paramString = paramzzi.asBinder();
            localParcel1.writeStrongBinder(paramString);
            zznJ.transact(18, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramString = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public void zza(String paramString, PlacesParams paramPlacesParams, zzh paramzzh)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        localParcel1.writeString(paramString);
        if (paramPlacesParams != null)
        {
          localParcel1.writeInt(1);
          paramPlacesParams.writeToParcel(localParcel1, 0);
          if (paramzzh != null)
          {
            paramString = paramzzh.asBinder();
            localParcel1.writeStrongBinder(paramString);
            zznJ.transact(19, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramString = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public void zza(String paramString, PlacesParams paramPlacesParams, zzi paramzzi)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        localParcel1.writeString(paramString);
        if (paramPlacesParams != null)
        {
          localParcel1.writeInt(1);
          paramPlacesParams.writeToParcel(localParcel1, 0);
          if (paramzzi != null)
          {
            paramString = paramzzi.asBinder();
            localParcel1.writeStrongBinder(paramString);
            zznJ.transact(3, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramString = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public void zza(String paramString, LatLngBounds paramLatLngBounds, AutocompleteFilter paramAutocompleteFilter, PlacesParams paramPlacesParams, zzi paramzzi)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        localParcel1.writeString(paramString);
        if (paramLatLngBounds != null)
        {
          localParcel1.writeInt(1);
          paramLatLngBounds.writeToParcel(localParcel1, 0);
          if (paramAutocompleteFilter != null)
          {
            localParcel1.writeInt(1);
            paramAutocompleteFilter.writeToParcel(localParcel1, 0);
            if (paramPlacesParams == null) {
              break label159;
            }
            localParcel1.writeInt(1);
            paramPlacesParams.writeToParcel(localParcel1, 0);
            if (paramzzi == null) {
              break label168;
            }
            paramString = paramzzi.asBinder();
            localParcel1.writeStrongBinder(paramString);
            zznJ.transact(13, localParcel1, localParcel2, 0);
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
      label159:
      localParcel1.writeInt(0);
      continue;
      label168:
      paramString = null;
    }
  }
  
  public void zza(List<String> paramList, PlacesParams paramPlacesParams, zzi paramzzi)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        localParcel1.writeStringList(paramList);
        if (paramPlacesParams != null)
        {
          localParcel1.writeInt(1);
          paramPlacesParams.writeToParcel(localParcel1, 0);
          if (paramzzi != null)
          {
            paramList = paramzzi.asBinder();
            localParcel1.writeStrongBinder(paramList);
            zznJ.transact(7, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramList = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public void zzb(PlaceFilter paramPlaceFilter, PlacesParams paramPlacesParams, zzi paramzzi)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (paramPlaceFilter != null)
        {
          localParcel1.writeInt(1);
          paramPlaceFilter.writeToParcel(localParcel1, 0);
          if (paramPlacesParams != null)
          {
            localParcel1.writeInt(1);
            paramPlacesParams.writeToParcel(localParcel1, 0);
            if (paramzzi == null) {
              break label131;
            }
            paramPlaceFilter = paramzzi.asBinder();
            localParcel1.writeStrongBinder(paramPlaceFilter);
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
      paramPlaceFilter = null;
    }
  }
  
  public void zzb(PlacesParams paramPlacesParams, PendingIntent paramPendingIntent)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (paramPlacesParams != null)
        {
          localParcel1.writeInt(1);
          paramPlacesParams.writeToParcel(localParcel1, 0);
          if (paramPendingIntent != null)
          {
            localParcel1.writeInt(1);
            paramPendingIntent.writeToParcel(localParcel1, 0);
            zznJ.transact(12, localParcel1, localParcel2, 0);
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
    }
  }
  
  public void zzb(String paramString, PlacesParams paramPlacesParams, zzi paramzzi)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        localParcel1.writeString(paramString);
        if (paramPlacesParams != null)
        {
          localParcel1.writeInt(1);
          paramPlacesParams.writeToParcel(localParcel1, 0);
          if (paramzzi != null)
          {
            paramString = paramzzi.asBinder();
            localParcel1.writeStrongBinder(paramString);
            zznJ.transact(6, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramString = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public void zzb(List<String> paramList, PlacesParams paramPlacesParams, zzi paramzzi)
    throws RemoteException
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
        localParcel1.writeStringList(paramList);
        if (paramPlacesParams != null)
        {
          localParcel1.writeInt(1);
          paramPlacesParams.writeToParcel(localParcel1, 0);
          if (paramzzi != null)
          {
            paramList = paramzzi.asBinder();
            localParcel1.writeStrongBinder(paramList);
            zznJ.transact(17, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramList = null;
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
 * Qualified Name:     com.google.android.gms.location.places.internal.zzg.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */