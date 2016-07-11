package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;

@zzgr
public final class zzfx
  extends zzfs.zza
{
  private final InAppPurchaseListener zztI;
  
  public zzfx(InAppPurchaseListener paramInAppPurchaseListener)
  {
    zztI = paramInAppPurchaseListener;
  }
  
  public void zza(zzfr paramzzfr)
  {
    zztI.onInAppPurchaseRequested(new zzga(paramzzfr));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */