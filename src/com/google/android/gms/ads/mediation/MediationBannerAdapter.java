package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;

public abstract interface MediationBannerAdapter
  extends MediationAdapter
{
  public abstract View getBannerView();
  
  public abstract void requestBannerAd(Context paramContext, MediationBannerListener paramMediationBannerListener, Bundle paramBundle1, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2);
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.mediation.MediationBannerAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */