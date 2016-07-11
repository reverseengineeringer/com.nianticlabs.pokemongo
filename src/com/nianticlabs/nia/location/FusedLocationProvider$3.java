package com.nianticlabs.nia.location;

import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.nianticlabs.nia.contextservice.ServiceStatus;

class FusedLocationProvider$3
  implements ResultCallback<Status>
{
  FusedLocationProvider$3(FusedLocationProvider paramFusedLocationProvider) {}
  
  public void onResult(Status paramStatus)
  {
    if (paramStatus.isSuccess()) {
      FusedLocationProvider.access$100(this$0, ServiceStatus.STOPPED);
    }
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.location.FusedLocationProvider.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */