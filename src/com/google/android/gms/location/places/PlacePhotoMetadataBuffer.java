package com.google.android.gms.location.places;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.internal.zzr;

public class PlacePhotoMetadataBuffer
  extends AbstractDataBuffer<PlacePhotoMetadata>
{
  public PlacePhotoMetadataBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  public PlacePhotoMetadata get(int paramInt)
  {
    return new zzr(zzabq, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.PlacePhotoMetadataBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */