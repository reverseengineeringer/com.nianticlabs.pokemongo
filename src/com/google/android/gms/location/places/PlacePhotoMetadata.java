package com.google.android.gms.location.places;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.data.Freezable;

public abstract interface PlacePhotoMetadata
  extends Freezable<PlacePhotoMetadata>
{
  public abstract CharSequence getAttributions();
  
  public abstract int getMaxHeight();
  
  public abstract int getMaxWidth();
  
  public abstract PendingResult<PlacePhotoResult> getPhoto(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<PlacePhotoResult> getScaledPhoto(GoogleApiClient paramGoogleApiClient, int paramInt1, int paramInt2);
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.PlacePhotoMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */