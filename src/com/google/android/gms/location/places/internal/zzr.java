package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoResult;

public class zzr
  extends zzu
  implements PlacePhotoMetadata
{
  private final String zzaHL = getString("photo_fife_url");
  
  public zzr(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  public CharSequence getAttributions()
  {
    return zzF("photo_attributions", null);
  }
  
  public int getMaxHeight()
  {
    return zzz("photo_max_height", 0);
  }
  
  public int getMaxWidth()
  {
    return zzz("photo_max_width", 0);
  }
  
  public PendingResult<PlacePhotoResult> getPhoto(GoogleApiClient paramGoogleApiClient)
  {
    return getScaledPhoto(paramGoogleApiClient, getMaxWidth(), getMaxHeight());
  }
  
  public PendingResult<PlacePhotoResult> getScaledPhoto(GoogleApiClient paramGoogleApiClient, int paramInt1, int paramInt2)
  {
    return zzxp().getScaledPhoto(paramGoogleApiClient, paramInt1, paramInt2);
  }
  
  public PlacePhotoMetadata zzxp()
  {
    return new zzq(zzaHL, getMaxWidth(), getMaxHeight(), getAttributions(), zzadl);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */