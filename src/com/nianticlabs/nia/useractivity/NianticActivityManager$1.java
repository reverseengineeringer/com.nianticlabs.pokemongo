package com.nianticlabs.nia.useractivity;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.nianticlabs.nia.contextservice.GoogleApiManager.Listener;
import com.nianticlabs.nia.contextservice.ServiceStatus;

class NianticActivityManager$1
  implements GoogleApiManager.Listener
{
  NianticActivityManager$1(NianticActivityManager paramNianticActivityManager) {}
  
  public void onConnected()
  {
    if (NianticActivityManager.access$000(this$0) == NianticActivityManager.AppState.RESUME) {
      NianticActivityManager.access$100(this$0);
    }
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    NianticActivityManager.access$202(this$0, NianticActivityManager.GoogleApiState.STOPPED);
    switch (paramConnectionResult.getErrorCode())
    {
    default: 
      NianticActivityManager.access$302(this$0, ServiceStatus.FAILED);
    }
    for (;;)
    {
      if (NianticActivityManager.access$300(this$0) != ServiceStatus.INITIALIZED) {
        Log.e("NianticActivityManager", "Connection to activity recognition failed: " + paramConnectionResult.getErrorMessage());
      }
      Log.d("NianticActivityManager", "Connection failed, updating status.");
      NianticActivityManager.access$400(this$0, null, NianticActivityManager.access$300(this$0).ordinal());
      return;
      NianticActivityManager.access$302(this$0, ServiceStatus.INITIALIZED);
      continue;
      NianticActivityManager.access$302(this$0, ServiceStatus.PERMISSION_DENIED);
    }
  }
  
  public void onDisconnected()
  {
    NianticActivityManager.access$202(this$0, NianticActivityManager.GoogleApiState.STOPPED);
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.useractivity.NianticActivityManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */