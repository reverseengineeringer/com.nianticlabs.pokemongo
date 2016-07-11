package com.nianticlabs.nia.contextservice;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;

class GoogleApiManager$1
  implements GoogleApiClient.ConnectionCallbacks
{
  GoogleApiManager$1(GoogleApiManager paramGoogleApiManager) {}
  
  public void onConnected(Bundle paramBundle)
  {
    ContextService.assertOnServiceThread();
    Log.v("GoogleApiManager", "onConnected");
    GoogleApiManager.access$000(this$0);
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    ContextService.assertOnServiceThread();
    Log.v("GoogleApiManager", "onConnectionSuspended");
    StringBuilder localStringBuilder;
    if (Log.isLoggable("GoogleApiManager", 3))
    {
      localStringBuilder = new StringBuilder("Connection to Google Play Services suspended. ");
      switch (paramInt)
      {
      default: 
        localStringBuilder.append("Unknown (");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(")");
      }
    }
    for (;;)
    {
      Log.d("GoogleApiManager", localStringBuilder.toString());
      Log.v("GoogleApiManager", "State " + GoogleApiManager.access$100(this$0).name() + " -> STOPPED");
      GoogleApiManager.access$102(this$0, GoogleApiManager.State.STOPPING);
      GoogleApiManager.access$200(this$0);
      return;
      localStringBuilder.append("CAUSE_NETWORK_LOST");
      continue;
      localStringBuilder.append("CAUSE_SERVICE_DISCONNECTED");
    }
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.contextservice.GoogleApiManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */