package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.location.places.internal.zzb;

public class AutocompletePredictionBuffer
  extends AbstractDataBuffer<AutocompletePrediction>
  implements Result
{
  public AutocompletePredictionBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  public AutocompletePrediction get(int paramInt)
  {
    return new zzb(zzabq, paramInt);
  }
  
  public Status getStatus()
  {
    return PlacesStatusCodes.zzhp(zzabq.getStatusCode());
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("status", getStatus()).toString();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.AutocompletePredictionBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */