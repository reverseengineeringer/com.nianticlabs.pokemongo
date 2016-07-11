package com.nianticlabs.nia.location;

import com.google.android.gms.common.ConnectionResult;
import com.nianticlabs.nia.contextservice.GoogleApiManager.Listener;
import com.nianticlabs.nia.contextservice.ServiceStatus;

class FusedLocationProvider$1
  implements GoogleApiManager.Listener
{
  FusedLocationProvider$1(FusedLocationProvider paramFusedLocationProvider) {}
  
  public void onConnected()
  {
    FusedLocationProvider.access$002(this$0, FusedLocationProvider.GoogleApiState.STARTED);
    FusedLocationProvider.access$100(this$0, ServiceStatus.INITIALIZED);
    if (FusedLocationProvider.access$200(this$0) == FusedLocationProvider.AppState.RESUME) {
      FusedLocationProvider.access$300(this$0);
    }
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    FusedLocationProvider.access$002(this$0, FusedLocationProvider.GoogleApiState.STOPPED);
    if (paramConnectionResult != null)
    {
      switch (paramConnectionResult.getErrorCode())
      {
      default: 
        FusedLocationProvider.access$100(this$0, ServiceStatus.FAILED);
        return;
      }
      FusedLocationProvider.access$100(this$0, ServiceStatus.PERMISSION_DENIED);
      return;
    }
    FusedLocationProvider.access$100(this$0, ServiceStatus.FAILED);
  }
  
  public void onDisconnected()
  {
    FusedLocationProvider.access$002(this$0, FusedLocationProvider.GoogleApiState.STOPPED);
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.location.FusedLocationProvider.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */