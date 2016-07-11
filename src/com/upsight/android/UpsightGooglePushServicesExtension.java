package com.upsight.android;

import com.upsight.android.googlepushservices.UpsightGooglePushServices.OnRegisterListener;
import com.upsight.android.googlepushservices.UpsightGooglePushServicesApi;
import com.upsight.android.googlepushservices.UpsightGooglePushServicesComponent;
import com.upsight.android.googlepushservices.internal.DaggerGooglePushServicesComponent;
import com.upsight.android.googlepushservices.internal.DaggerGooglePushServicesComponent.Builder;
import com.upsight.android.googlepushservices.internal.PushModule;
import javax.inject.Inject;

public class UpsightGooglePushServicesExtension
  extends UpsightExtension<UpsightGooglePushServicesComponent, UpsightGooglePushServicesApi>
{
  public static final String EXTENSION_NAME = "com.upsight.extension.googlepushservices";
  @Inject
  UpsightGooglePushServicesApi mUpsightPush;
  
  public UpsightGooglePushServicesApi getApi()
  {
    return mUpsightPush;
  }
  
  protected void onPostCreate(UpsightContext paramUpsightContext)
  {
    mUpsightPush.register(new UpsightGooglePushServices.OnRegisterListener()
    {
      public void onFailure(UpsightException paramAnonymousUpsightException) {}
      
      public void onSuccess(String paramAnonymousString) {}
    });
  }
  
  protected UpsightGooglePushServicesComponent onResolve(UpsightContext paramUpsightContext)
  {
    return DaggerGooglePushServicesComponent.builder().pushModule(new PushModule(paramUpsightContext)).build();
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.UpsightGooglePushServicesExtension
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */