package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzgr
public class zzev
  extends zzeq.zza
{
  private final NativeAppInstallAdMapper zzzN;
  
  public zzev(NativeAppInstallAdMapper paramNativeAppInstallAdMapper)
  {
    zzzN = paramNativeAppInstallAdMapper;
  }
  
  public String getBody()
  {
    return zzzN.getBody();
  }
  
  public String getCallToAction()
  {
    return zzzN.getCallToAction();
  }
  
  public Bundle getExtras()
  {
    return zzzN.getExtras();
  }
  
  public String getHeadline()
  {
    return zzzN.getHeadline();
  }
  
  public List getImages()
  {
    Object localObject = zzzN.getImages();
    if (localObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        NativeAd.Image localImage = (NativeAd.Image)((Iterator)localObject).next();
        localArrayList.add(new zzc(localImage.getDrawable(), localImage.getUri(), localImage.getScale()));
      }
      return localArrayList;
    }
    return null;
  }
  
  public boolean getOverrideClickHandling()
  {
    return zzzN.getOverrideClickHandling();
  }
  
  public boolean getOverrideImpressionRecording()
  {
    return zzzN.getOverrideImpressionRecording();
  }
  
  public String getPrice()
  {
    return zzzN.getPrice();
  }
  
  public double getStarRating()
  {
    return zzzN.getStarRating();
  }
  
  public String getStore()
  {
    return zzzN.getStore();
  }
  
  public void recordImpression()
  {
    zzzN.recordImpression();
  }
  
  public void zzc(zzd paramzzd)
  {
    zzzN.handleClick((View)zze.zzp(paramzzd));
  }
  
  public void zzd(zzd paramzzd)
  {
    zzzN.trackView((View)zze.zzp(paramzzd));
  }
  
  public zzcm zzdw()
  {
    NativeAd.Image localImage = zzzN.getIcon();
    if (localImage != null) {
      return new zzc(localImage.getDrawable(), localImage.getUri(), localImage.getScale());
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzev
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */