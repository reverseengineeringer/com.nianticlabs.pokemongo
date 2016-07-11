package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.concurrent.atomic.AtomicBoolean;

class zzgc$1
  implements Runnable
{
  zzgc$1(zzgc paramzzgc) {}
  
  public void run()
  {
    if (!zzgc.zza(zzDj).get()) {
      return;
    }
    zzb.e("Timed out waiting for WebView to finish loading.");
    zzDj.cancel();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgc.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */