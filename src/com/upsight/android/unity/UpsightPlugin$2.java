package com.upsight.android.unity;

import android.util.Log;
import com.upsight.android.UpsightException;
import com.upsight.android.googlepushservices.UpsightGooglePushServices.OnRegisterListener;

class UpsightPlugin$2
  implements UpsightGooglePushServices.OnRegisterListener
{
  UpsightPlugin$2(UpsightPlugin paramUpsightPlugin) {}
  
  public void onFailure(UpsightException paramUpsightException)
  {
    Log.e("Upsight", "registration failed: " + paramUpsightException);
  }
  
  public void onSuccess(String paramString)
  {
    Log.e("Upsight", "registration succeeded");
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.unity.UpsightPlugin.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */