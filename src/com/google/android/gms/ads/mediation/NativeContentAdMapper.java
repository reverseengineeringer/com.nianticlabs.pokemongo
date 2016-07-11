package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.List;

public abstract class NativeContentAdMapper
  extends NativeAdMapper
{
  private NativeAd.Image zzKK;
  private String zzwo;
  private List<NativeAd.Image> zzwp;
  private String zzwq;
  private String zzws;
  private String zzwz;
  
  public final String getAdvertiser()
  {
    return zzwz;
  }
  
  public final String getBody()
  {
    return zzwq;
  }
  
  public final String getCallToAction()
  {
    return zzws;
  }
  
  public final String getHeadline()
  {
    return zzwo;
  }
  
  public final List<NativeAd.Image> getImages()
  {
    return zzwp;
  }
  
  public final NativeAd.Image getLogo()
  {
    return zzKK;
  }
  
  public final void setAdvertiser(String paramString)
  {
    zzwz = paramString;
  }
  
  public final void setBody(String paramString)
  {
    zzwq = paramString;
  }
  
  public final void setCallToAction(String paramString)
  {
    zzws = paramString;
  }
  
  public final void setHeadline(String paramString)
  {
    zzwo = paramString;
  }
  
  public final void setImages(List<NativeAd.Image> paramList)
  {
    zzwp = paramList;
  }
  
  public final void setLogo(NativeAd.Image paramImage)
  {
    zzKK = paramImage;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.mediation.NativeContentAdMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */