package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzgr
public class zzew
  extends zzer.zza
{
  private final NativeContentAdMapper zzzO;
  
  public zzew(NativeContentAdMapper paramNativeContentAdMapper)
  {
    zzzO = paramNativeContentAdMapper;
  }
  
  public String getAdvertiser()
  {
    return zzzO.getAdvertiser();
  }
  
  public String getBody()
  {
    return zzzO.getBody();
  }
  
  public String getCallToAction()
  {
    return zzzO.getCallToAction();
  }
  
  public Bundle getExtras()
  {
    return zzzO.getExtras();
  }
  
  public String getHeadline()
  {
    return zzzO.getHeadline();
  }
  
  public List getImages()
  {
    Object localObject = zzzO.getImages();
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
    return zzzO.getOverrideClickHandling();
  }
  
  public boolean getOverrideImpressionRecording()
  {
    return zzzO.getOverrideImpressionRecording();
  }
  
  public void recordImpression()
  {
    zzzO.recordImpression();
  }
  
  public void zzc(zzd paramzzd)
  {
    zzzO.handleClick((View)zze.zzp(paramzzd));
  }
  
  public void zzd(zzd paramzzd)
  {
    zzzO.trackView((View)zze.zzp(paramzzd));
  }
  
  public zzcm zzdA()
  {
    NativeAd.Image localImage = zzzO.getLogo();
    if (localImage != null) {
      return new zzc(localImage.getDrawable(), localImage.getUri(), localImage.getScale());
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzew
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */