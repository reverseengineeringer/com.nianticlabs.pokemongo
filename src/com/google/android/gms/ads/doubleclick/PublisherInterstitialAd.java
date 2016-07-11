package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.internal.client.zzaa;

public final class PublisherInterstitialAd
{
  private final zzaa zznU = new zzaa(paramContext, this);
  
  public PublisherInterstitialAd(Context paramContext) {}
  
  public AdListener getAdListener()
  {
    return zznU.getAdListener();
  }
  
  public String getAdUnitId()
  {
    return zznU.getAdUnitId();
  }
  
  public AppEventListener getAppEventListener()
  {
    return zznU.getAppEventListener();
  }
  
  public String getMediationAdapterClassName()
  {
    return zznU.getMediationAdapterClassName();
  }
  
  public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener()
  {
    return zznU.getOnCustomRenderedAdLoadedListener();
  }
  
  public boolean isLoaded()
  {
    return zznU.isLoaded();
  }
  
  public void loadAd(PublisherAdRequest paramPublisherAdRequest)
  {
    zznU.zza(paramPublisherAdRequest.zzaF());
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    zznU.setAdListener(paramAdListener);
  }
  
  public void setAdUnitId(String paramString)
  {
    zznU.setAdUnitId(paramString);
  }
  
  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    zznU.setAppEventListener(paramAppEventListener);
  }
  
  public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener paramOnCustomRenderedAdLoadedListener)
  {
    zznU.setOnCustomRenderedAdLoadedListener(paramOnCustomRenderedAdLoadedListener);
  }
  
  public void show()
  {
    zznU.show();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.doubleclick.PublisherInterstitialAd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */