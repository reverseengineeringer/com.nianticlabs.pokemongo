package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.List;

public abstract class NativeAppInstallAdMapper
  extends NativeAdMapper
{
  private NativeAd.Image zzKJ;
  private String zzwo;
  private List<NativeAd.Image> zzwp;
  private String zzwq;
  private String zzws;
  private double zzwt;
  private String zzwu;
  private String zzwv;
  
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
  
  public final NativeAd.Image getIcon()
  {
    return zzKJ;
  }
  
  public final List<NativeAd.Image> getImages()
  {
    return zzwp;
  }
  
  public final String getPrice()
  {
    return zzwv;
  }
  
  public final double getStarRating()
  {
    return zzwt;
  }
  
  public final String getStore()
  {
    return zzwu;
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
  
  public final void setIcon(NativeAd.Image paramImage)
  {
    zzKJ = paramImage;
  }
  
  public final void setImages(List<NativeAd.Image> paramList)
  {
    zzwp = paramList;
  }
  
  public final void setPrice(String paramString)
  {
    zzwv = paramString;
  }
  
  public final void setStarRating(double paramDouble)
  {
    zzwt = paramDouble;
  }
  
  public final void setStore(String paramString)
  {
    zzwu = paramString;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.mediation.NativeAppInstallAdMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */