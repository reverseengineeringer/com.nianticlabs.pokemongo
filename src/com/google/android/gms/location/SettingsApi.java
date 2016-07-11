package com.google.android.gms.location;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

public abstract interface SettingsApi
{
  public abstract PendingResult<LocationSettingsResult> checkLocationSettings(GoogleApiClient paramGoogleApiClient, LocationSettingsRequest paramLocationSettingsRequest);
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.SettingsApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */