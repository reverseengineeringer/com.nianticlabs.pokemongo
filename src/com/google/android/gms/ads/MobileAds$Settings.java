package com.google.android.gms.ads;

import com.google.android.gms.ads.internal.client.zzac;

public final class MobileAds$Settings
{
  private final zzac zznV = new zzac();
  
  @Deprecated
  public String getTrackingId()
  {
    return zznV.getTrackingId();
  }
  
  @Deprecated
  public boolean isGoogleAnalyticsEnabled()
  {
    return zznV.isGoogleAnalyticsEnabled();
  }
  
  @Deprecated
  public Settings setGoogleAnalyticsEnabled(boolean paramBoolean)
  {
    zznV.zzk(paramBoolean);
    return this;
  }
  
  @Deprecated
  public Settings setTrackingId(String paramString)
  {
    zznV.zzO(paramString);
    return this;
  }
  
  zzac zzaG()
  {
    return zznV;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.MobileAds.Settings
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */