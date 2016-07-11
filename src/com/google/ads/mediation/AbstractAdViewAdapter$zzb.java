package com.google.ads.mediation;

import android.view.View;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;

class AbstractAdViewAdapter$zzb
  extends NativeContentAdMapper
{
  private final NativeContentAd zzaO;
  
  public AbstractAdViewAdapter$zzb(NativeContentAd paramNativeContentAd)
  {
    zzaO = paramNativeContentAd;
    setHeadline(paramNativeContentAd.getHeadline().toString());
    setImages(paramNativeContentAd.getImages());
    setBody(paramNativeContentAd.getBody().toString());
    setLogo(paramNativeContentAd.getLogo());
    setCallToAction(paramNativeContentAd.getCallToAction().toString());
    setAdvertiser(paramNativeContentAd.getAdvertiser().toString());
    setOverrideImpressionRecording(true);
    setOverrideClickHandling(true);
  }
  
  public void trackView(View paramView)
  {
    if ((paramView instanceof NativeAdView)) {
      ((NativeAdView)paramView).setNativeAd(zzaO);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.ads.mediation.AbstractAdViewAdapter.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */