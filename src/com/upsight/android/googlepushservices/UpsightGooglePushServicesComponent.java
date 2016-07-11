package com.upsight.android.googlepushservices;

import com.upsight.android.UpsightExtension.BaseComponent;
import com.upsight.android.UpsightGooglePushServicesExtension;
import com.upsight.android.googlepushservices.internal.PushClickIntentService;
import com.upsight.android.googlepushservices.internal.PushIntentService;

public abstract interface UpsightGooglePushServicesComponent
  extends UpsightExtension.BaseComponent<UpsightGooglePushServicesExtension>
{
  public abstract void inject(PushClickIntentService paramPushClickIntentService);
  
  public abstract void inject(PushIntentService paramPushIntentService);
}

/* Location:
 * Qualified Name:     com.upsight.android.googlepushservices.UpsightGooglePushServicesComponent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */