package com.upsight.android.googlepushservices;

import com.upsight.android.UpsightContext;
import com.upsight.android.marketing.UpsightBillboard;
import com.upsight.android.marketing.UpsightBillboard.Handler;

public abstract interface UpsightGooglePushServicesApi
{
  public abstract UpsightBillboard createPushBillboard(UpsightContext paramUpsightContext, UpsightBillboard.Handler paramHandler)
    throws IllegalArgumentException, IllegalStateException;
  
  public abstract void register(UpsightGooglePushServices.OnRegisterListener paramOnRegisterListener);
  
  public abstract void unregister(UpsightGooglePushServices.OnUnregisterListener paramOnUnregisterListener);
}

/* Location:
 * Qualified Name:     com.upsight.android.googlepushservices.UpsightGooglePushServicesApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */