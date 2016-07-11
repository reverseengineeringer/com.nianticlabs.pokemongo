package com.nianticlabs.nia.location;

import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.nianticlabs.nia.contextservice.ServiceStatus;

class FusedLocationProvider$2
  implements ResultCallback<Status>
{
  FusedLocationProvider$2(FusedLocationProvider paramFusedLocationProvider) {}
  
  public void onResult(Status paramStatus)
  {
    if (paramStatus.isSuccess())
    {
      FusedLocationProvider.access$100(this$0, ServiceStatus.RUNNING);
      return;
    }
    FusedLocationProvider.access$100(this$0, ServiceStatus.FAILED);
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.location.FusedLocationProvider.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */