package com.upsight.android.unity;

import android.util.Log;
import com.upsight.android.UpsightException;
import com.upsight.android.googlepushservices.UpsightGooglePushServices.OnUnregisterListener;

class UpsightPlugin$1
  implements UpsightGooglePushServices.OnUnregisterListener
{
  UpsightPlugin$1(UpsightPlugin paramUpsightPlugin) {}
  
  public void onFailure(UpsightException paramUpsightException)
  {
    Log.e("Upsight", "unregistration failed: " + paramUpsightException);
  }
  
  public void onSuccess()
  {
    Log.e("Upsight", "unregistration succeeded");
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.unity.UpsightPlugin.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */