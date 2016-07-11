package com.google.android.gms.location.places;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlb.zza;
import com.google.android.gms.internal.zzmz;
import com.google.android.gms.location.places.internal.zzi.zza;
import com.google.android.gms.location.places.personalized.zzd;

public class zzl
  extends zzi.zza
{
  private static final String TAG = zzl.class.getSimpleName();
  private final Context mContext;
  private final zzd zzaGB;
  private final zza zzaGC;
  private final zze zzaGD;
  private final zzf zzaGE;
  private final zzc zzaGF;
  
  public zzl(zza paramzza)
  {
    zzaGB = null;
    zzaGC = paramzza;
    zzaGD = null;
    zzaGE = null;
    zzaGF = null;
    mContext = null;
  }
  
  public zzl(zzc paramzzc, Context paramContext)
  {
    zzaGB = null;
    zzaGC = null;
    zzaGD = null;
    zzaGE = null;
    zzaGF = paramzzc;
    mContext = paramContext;
  }
  
  public zzl(zzd paramzzd, Context paramContext)
  {
    zzaGB = paramzzd;
    zzaGC = null;
    zzaGD = null;
    zzaGE = null;
    zzaGF = null;
    mContext = paramContext;
  }
  
  public zzl(zzf paramzzf)
  {
    zzaGB = null;
    zzaGC = null;
    zzaGD = null;
    zzaGE = paramzzf;
    zzaGF = null;
    mContext = null;
  }
  
  public void zzaN(Status paramStatus)
    throws RemoteException
  {
    zzaGE.zzb(paramStatus);
  }
  
  public void zzab(DataHolder paramDataHolder)
    throws RemoteException
  {
    if (zzaGB != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "placeEstimator cannot be null");
      if (paramDataHolder != null) {
        break;
      }
      if (Log.isLoggable(TAG, 6)) {
        Log.e(TAG, "onPlaceEstimated received null DataHolder: " + zzmz.zzqF());
      }
      zzaGB.zzv(Status.zzabd);
      return;
    }
    paramDataHolder = new PlaceLikelihoodBuffer(paramDataHolder, 100, mContext);
    zzaGB.zzb(paramDataHolder);
  }
  
  public void zzac(DataHolder paramDataHolder)
    throws RemoteException
  {
    if (paramDataHolder == null)
    {
      if (Log.isLoggable(TAG, 6)) {
        Log.e(TAG, "onAutocompletePrediction received null DataHolder: " + zzmz.zzqF());
      }
      zzaGC.zzv(Status.zzabd);
      return;
    }
    zzaGC.zzb(new AutocompletePredictionBuffer(paramDataHolder));
  }
  
  public void zzad(DataHolder paramDataHolder)
    throws RemoteException
  {
    if (paramDataHolder == null)
    {
      if (Log.isLoggable(TAG, 6)) {
        Log.e(TAG, "onPlaceUserDataFetched received null DataHolder: " + zzmz.zzqF());
      }
      zzaGD.zzv(Status.zzabd);
      return;
    }
    zzaGD.zzb(new zzd(paramDataHolder));
  }
  
  public void zzae(DataHolder paramDataHolder)
    throws RemoteException
  {
    paramDataHolder = new PlaceBuffer(paramDataHolder, mContext);
    zzaGF.zzb(paramDataHolder);
  }
  
  public static abstract class zza<A extends Api.zzb>
    extends zzl.zzb<AutocompletePredictionBuffer, A>
  {
    public zza(Api.zzc<A> paramzzc, GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
    
    protected AutocompletePredictionBuffer zzaO(Status paramStatus)
    {
      return new AutocompletePredictionBuffer(DataHolder.zzbu(paramStatus.getStatusCode()));
    }
  }
  
  public static abstract class zzb<R extends Result, A extends Api.zzb>
    extends zzlb.zza<R, A>
  {
    public zzb(Api.zzc<A> paramzzc, GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
  }
  
  public static abstract class zzc<A extends Api.zzb>
    extends zzl.zzb<PlaceBuffer, A>
  {
    public zzc(Api.zzc<A> paramzzc, GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
    
    protected PlaceBuffer zzaP(Status paramStatus)
    {
      return new PlaceBuffer(DataHolder.zzbu(paramStatus.getStatusCode()), null);
    }
  }
  
  public static abstract class zzd<A extends Api.zzb>
    extends zzl.zzb<PlaceLikelihoodBuffer, A>
  {
    public zzd(Api.zzc<A> paramzzc, GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
    
    protected PlaceLikelihoodBuffer zzaQ(Status paramStatus)
    {
      return new PlaceLikelihoodBuffer(DataHolder.zzbu(paramStatus.getStatusCode()), 100, null);
    }
  }
  
  public static abstract class zze<A extends Api.zzb>
    extends zzl.zzb<zzd, A>
  {
    protected zzd zzaR(Status paramStatus)
    {
      return zzd.zzaS(paramStatus);
    }
  }
  
  public static abstract class zzf<A extends Api.zzb>
    extends zzl.zzb<Status, A>
  {
    public zzf(Api.zzc<A> paramzzc, GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
    
    protected Status zzd(Status paramStatus)
    {
      return paramStatus;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.zzl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */