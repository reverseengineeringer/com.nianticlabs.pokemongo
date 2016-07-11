package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.zzgr;

@zzgr
public final class zzj
  extends zzu.zza
{
  private final AppEventListener zztj;
  
  public zzj(AppEventListener paramAppEventListener)
  {
    zztj = paramAppEventListener;
  }
  
  public void onAppEvent(String paramString1, String paramString2)
  {
    zztj.onAppEvent(paramString1, paramString2);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */