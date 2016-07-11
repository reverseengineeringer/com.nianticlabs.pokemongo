package com.upsight.android.googlepushservices;

import com.upsight.android.UpsightException;

public abstract interface UpsightGooglePushServices$OnUnregisterListener
{
  public abstract void onFailure(UpsightException paramUpsightException);
  
  public abstract void onSuccess();
}

/* Location:
 * Qualified Name:     com.upsight.android.googlepushservices.UpsightGooglePushServices.OnUnregisterListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */