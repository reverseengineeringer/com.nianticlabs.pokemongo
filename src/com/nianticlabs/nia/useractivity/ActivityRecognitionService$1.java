package com.nianticlabs.nia.useractivity;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.location.ActivityRecognition;
import com.google.android.gms.location.ActivityRecognitionApi;

class ActivityRecognitionService$1
  implements GoogleApiClient.ConnectionCallbacks
{
  ActivityRecognitionService$1(ActivityRecognitionService paramActivityRecognitionService) {}
  
  public void onConnected(Bundle arg1)
  {
    synchronized ()
    {
      if (NianticActivityManager.getInstance() == null)
      {
        PendingIntent localPendingIntent = NianticActivityManager.createPendingIntent(this$0);
        ActivityRecognition.ActivityRecognitionApi.removeActivityUpdates(ActivityRecognitionService.access$000(this$0), localPendingIntent);
        ActivityRecognitionService.access$000(this$0).disconnect();
      }
      return;
    }
  }
  
  public void onConnectionSuspended(int paramInt) {}
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.useractivity.ActivityRecognitionService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */