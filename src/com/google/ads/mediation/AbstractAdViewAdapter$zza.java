package com.google.ads.mediation;

import android.view.View;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;

class AbstractAdViewAdapter$zza
  extends NativeAppInstallAdMapper
{
  private final NativeAppInstallAd zzaN;
  
  public AbstractAdViewAdapter$zza(NativeAppInstallAd paramNativeAppInstallAd)
  {
    zzaN = paramNativeAppInstallAd;
    setHeadline(paramNativeAppInstallAd.getHeadline().toString());
    setImages(paramNativeAppInstallAd.getImages());
    setBody(paramNativeAppInstallAd.getBody().toString());
    setIcon(paramNativeAppInstallAd.getIcon());
    setCallToAction(paramNativeAppInstallAd.getCallToAction().toString());
    setStarRating(paramNativeAppInstallAd.getStarRating().doubleValue());
    setStore(paramNativeAppInstallAd.getStore().toString());
    setPrice(paramNativeAppInstallAd.getPrice().toString());
    setOverrideImpressionRecording(true);
    setOverrideClickHandling(true);
  }
  
  public void trackView(View paramView)
  {
    if ((paramView instanceof NativeAdView)) {
      ((NativeAdView)paramView).setNativeAd(zzaN);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.ads.mediation.AbstractAdViewAdapter.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */