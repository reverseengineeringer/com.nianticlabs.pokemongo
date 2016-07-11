package com.google.android.gms.location.places;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.internal.zzs;

public class PlaceBuffer
  extends AbstractDataBuffer<Place>
  implements Result
{
  private final Context mContext;
  private final Status zzSC;
  private final String zzaGk;
  
  public PlaceBuffer(DataHolder paramDataHolder, Context paramContext)
  {
    super(paramDataHolder);
    mContext = paramContext;
    zzSC = PlacesStatusCodes.zzhp(paramDataHolder.getStatusCode());
    if ((paramDataHolder != null) && (paramDataHolder.zzor() != null))
    {
      zzaGk = paramDataHolder.zzor().getString("com.google.android.gms.location.places.PlaceBuffer.ATTRIBUTIONS_EXTRA_KEY");
      return;
    }
    zzaGk = null;
  }
  
  public Place get(int paramInt)
  {
    return new zzs(zzabq, paramInt, mContext);
  }
  
  public CharSequence getAttributions()
  {
    return zzaGk;
  }
  
  public Status getStatus()
  {
    return zzSC;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.PlaceBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */