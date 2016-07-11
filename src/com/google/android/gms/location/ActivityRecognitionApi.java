package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public abstract interface ActivityRecognitionApi
{
  public abstract PendingResult<Status> removeActivityUpdates(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent);
  
  public abstract PendingResult<Status> requestActivityUpdates(GoogleApiClient paramGoogleApiClient, long paramLong, PendingIntent paramPendingIntent);
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.ActivityRecognitionApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */