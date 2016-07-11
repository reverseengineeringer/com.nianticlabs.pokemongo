package com.google.android.gms.location.places;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.location.places.internal.zzn;

public class PlaceLikelihoodBuffer
  extends AbstractDataBuffer<PlaceLikelihood>
  implements Result
{
  private final Context mContext;
  private final Status zzSC;
  private final String zzaGk;
  private final int zzaGp;
  
  public PlaceLikelihoodBuffer(DataHolder paramDataHolder, int paramInt, Context paramContext)
  {
    super(paramDataHolder);
    mContext = paramContext;
    zzSC = PlacesStatusCodes.zzhp(paramDataHolder.getStatusCode());
    zzaGp = zza.zzhk(paramInt);
    if ((paramDataHolder != null) && (paramDataHolder.zzor() != null))
    {
      zzaGk = paramDataHolder.zzor().getString("com.google.android.gms.location.places.PlaceLikelihoodBuffer.ATTRIBUTIONS_EXTRA_KEY");
      return;
    }
    zzaGk = null;
  }
  
  public PlaceLikelihood get(int paramInt)
  {
    return new zzn(zzabq, paramInt, mContext);
  }
  
  public CharSequence getAttributions()
  {
    return zzaGk;
  }
  
  public Status getStatus()
  {
    return zzSC;
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("status", getStatus()).zzg("attributions", zzaGk).toString();
  }
  
  public static class zza
  {
    static int zzhk(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("invalid source: " + paramInt);
      }
      return paramInt;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.PlaceLikelihoodBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */