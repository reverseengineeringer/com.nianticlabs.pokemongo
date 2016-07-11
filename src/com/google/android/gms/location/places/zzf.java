package com.google.android.gms.location.places;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.internal.zzh.zza;

public class zzf
  extends zzh.zza
{
  private final zzb zzaGi;
  private final zza zzaGj;
  
  public zzf(zza paramzza)
  {
    zzaGi = null;
    zzaGj = paramzza;
  }
  
  public zzf(zzb paramzzb)
  {
    zzaGi = paramzzb;
    zzaGj = null;
  }
  
  public void zza(PlacePhotoMetadataResult paramPlacePhotoMetadataResult)
    throws RemoteException
  {
    zzaGi.zzb(paramPlacePhotoMetadataResult);
  }
  
  public void zza(PlacePhotoResult paramPlacePhotoResult)
    throws RemoteException
  {
    zzaGj.zzb(paramPlacePhotoResult);
  }
  
  public static abstract class zza<A extends Api.zzb>
    extends zzl.zzb<PlacePhotoResult, A>
  {
    public zza(Api.zzc<A> paramzzc, GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
    
    protected PlacePhotoResult zzaL(Status paramStatus)
    {
      return new PlacePhotoResult(paramStatus, null);
    }
  }
  
  public static abstract class zzb<A extends Api.zzb>
    extends zzl.zzb<PlacePhotoMetadataResult, A>
  {
    public zzb(Api.zzc<A> paramzzc, GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
    
    protected PlacePhotoMetadataResult zzaM(Status paramStatus)
    {
      return new PlacePhotoMetadataResult(paramStatus, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */