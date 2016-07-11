package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;

public abstract interface CustomEventNative
  extends CustomEvent
{
  public abstract void requestNativeAd(Context paramContext, CustomEventNativeListener paramCustomEventNativeListener, String paramString, NativeMediationAdRequest paramNativeMediationAdRequest, Bundle paramBundle);
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.mediation.customevent.CustomEventNative
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */