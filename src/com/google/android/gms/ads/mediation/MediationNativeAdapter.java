package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.os.Bundle;

public abstract interface MediationNativeAdapter
  extends MediationAdapter
{
  public abstract void requestNativeAd(Context paramContext, MediationNativeListener paramMediationNativeListener, Bundle paramBundle1, NativeMediationAdRequest paramNativeMediationAdRequest, Bundle paramBundle2);
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.mediation.MediationNativeAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */