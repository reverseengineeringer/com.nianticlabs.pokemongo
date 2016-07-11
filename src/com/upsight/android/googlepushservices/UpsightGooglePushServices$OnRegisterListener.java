package com.upsight.android.googlepushservices;

import com.upsight.android.UpsightException;

public abstract interface UpsightGooglePushServices$OnRegisterListener
{
  public abstract void onFailure(UpsightException paramUpsightException);
  
  public abstract void onSuccess(String paramString);
}

/* Location:
 * Qualified Name:     com.upsight.android.googlepushservices.UpsightGooglePushServices.OnRegisterListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */