package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.zzgr;

@zzgr
public final class zzc
  extends zzo.zza
{
  private final AdListener zzsz;
  
  public zzc(AdListener paramAdListener)
  {
    zzsz = paramAdListener;
  }
  
  public void onAdClosed()
  {
    zzsz.onAdClosed();
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    zzsz.onAdFailedToLoad(paramInt);
  }
  
  public void onAdLeftApplication()
  {
    zzsz.onAdLeftApplication();
  }
  
  public void onAdLoaded()
  {
    zzsz.onAdLoaded();
  }
  
  public void onAdOpened()
  {
    zzsz.onAdOpened();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */