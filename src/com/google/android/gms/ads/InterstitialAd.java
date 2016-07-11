package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzaa;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

public final class InterstitialAd
{
  private final zzaa zznU;
  
  public InterstitialAd(Context paramContext)
  {
    zznU = new zzaa(paramContext);
  }
  
  public AdListener getAdListener()
  {
    return zznU.getAdListener();
  }
  
  public String getAdUnitId()
  {
    return zznU.getAdUnitId();
  }
  
  public InAppPurchaseListener getInAppPurchaseListener()
  {
    return zznU.getInAppPurchaseListener();
  }
  
  public String getMediationAdapterClassName()
  {
    return zznU.getMediationAdapterClassName();
  }
  
  public boolean isLoaded()
  {
    return zznU.isLoaded();
  }
  
  public boolean isLoading()
  {
    return zznU.isLoading();
  }
  
  public void loadAd(AdRequest paramAdRequest)
  {
    zznU.zza(paramAdRequest.zzaF());
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    zznU.setAdListener(paramAdListener);
    if ((paramAdListener != null) && ((paramAdListener instanceof zza))) {
      zznU.zza((zza)paramAdListener);
    }
    while (paramAdListener != null) {
      return;
    }
    zznU.zza(null);
  }
  
  public void setAdUnitId(String paramString)
  {
    zznU.setAdUnitId(paramString);
  }
  
  public void setInAppPurchaseListener(InAppPurchaseListener paramInAppPurchaseListener)
  {
    zznU.setInAppPurchaseListener(paramInAppPurchaseListener);
  }
  
  public void setPlayStorePurchaseParams(PlayStorePurchaseListener paramPlayStorePurchaseListener, String paramString)
  {
    zznU.setPlayStorePurchaseParams(paramPlayStorePurchaseListener, paramString);
  }
  
  public void show()
  {
    zznU.show();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.InterstitialAd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */