package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

@zzgr
public final class zzgb
  extends zzfw.zza
{
  private final PlayStorePurchaseListener zztJ;
  
  public zzgb(PlayStorePurchaseListener paramPlayStorePurchaseListener)
  {
    zztJ = paramPlayStorePurchaseListener;
  }
  
  public boolean isValidPurchase(String paramString)
  {
    return zztJ.isValidPurchase(paramString);
  }
  
  public void zza(zzfv paramzzfv)
  {
    zztJ.onInAppPurchaseFinished(new zzfz(paramzzfv));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */