package com.google.android.gms.location.places;

import com.google.android.gms.common.data.Freezable;

public abstract interface PlaceLikelihood
  extends Freezable<PlaceLikelihood>
{
  public abstract float getLikelihood();
  
  public abstract Place getPlace();
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.PlaceLikelihood
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */