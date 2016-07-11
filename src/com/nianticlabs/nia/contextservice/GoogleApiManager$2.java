package com.nianticlabs.nia.contextservice;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

class GoogleApiManager$2
  implements GoogleApiClient.OnConnectionFailedListener
{
  GoogleApiManager$2(GoogleApiManager paramGoogleApiManager) {}
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    ContextService.assertOnServiceThread();
    GoogleApiManager.access$300(this$0, paramConnectionResult);
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.contextservice.GoogleApiManager.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */