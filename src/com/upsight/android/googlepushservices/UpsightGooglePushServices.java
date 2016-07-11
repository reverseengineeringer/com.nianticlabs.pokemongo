package com.upsight.android.googlepushservices;

import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightException;
import com.upsight.android.UpsightGooglePushServicesExtension;
import com.upsight.android.logger.UpsightLogger;

public abstract class UpsightGooglePushServices
{
  public static void register(UpsightContext paramUpsightContext, OnRegisterListener paramOnRegisterListener)
  {
    UpsightGooglePushServicesExtension localUpsightGooglePushServicesExtension = (UpsightGooglePushServicesExtension)paramUpsightContext.getUpsightExtension("com.upsight.extension.googlepushservices");
    if (localUpsightGooglePushServicesExtension != null)
    {
      localUpsightGooglePushServicesExtension.getApi().register(paramOnRegisterListener);
      return;
    }
    paramUpsightContext.getLogger().e("Upsight", "com.upsight.extension.googlepushservices must be registered in your Android Manifest", new Object[0]);
  }
  
  public static void unregister(UpsightContext paramUpsightContext, OnUnregisterListener paramOnUnregisterListener)
  {
    UpsightGooglePushServicesExtension localUpsightGooglePushServicesExtension = (UpsightGooglePushServicesExtension)paramUpsightContext.getUpsightExtension("com.upsight.extension.googlepushservices");
    if (localUpsightGooglePushServicesExtension != null)
    {
      localUpsightGooglePushServicesExtension.getApi().unregister(paramOnUnregisterListener);
      return;
    }
    paramUpsightContext.getLogger().e("Upsight", "com.upsight.extension.googlepushservices must be registered in your Android Manifest", new Object[0]);
  }
  
  public static abstract interface OnRegisterListener
  {
    public abstract void onFailure(UpsightException paramUpsightException);
    
    public abstract void onSuccess(String paramString);
  }
  
  public static abstract interface OnUnregisterListener
  {
    public abstract void onFailure(UpsightException paramUpsightException);
    
    public abstract void onSuccess();
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.googlepushservices.UpsightGooglePushServices
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */