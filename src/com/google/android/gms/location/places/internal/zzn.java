package com.google.android.gms.location.places.internal;

import android.content.Context;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceLikelihood;

public class zzn
  extends zzu
  implements PlaceLikelihood
{
  private final Context mContext;
  
  public zzn(DataHolder paramDataHolder, int paramInt, Context paramContext)
  {
    super(paramDataHolder, paramInt);
    mContext = paramContext;
  }
  
  public float getLikelihood()
  {
    return zzb("place_likelihood", -1.0F);
  }
  
  public Place getPlace()
  {
    return new zzs(zzabq, zzadl, mContext);
  }
  
  public PlaceLikelihood zzxo()
  {
    return PlaceLikelihoodEntity.zza((PlaceImpl)getPlace().freeze(), getLikelihood());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */