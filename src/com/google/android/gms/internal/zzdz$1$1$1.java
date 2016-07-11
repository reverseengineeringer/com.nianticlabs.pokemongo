package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;

class zzdz$1$1$1
  implements Runnable
{
  zzdz$1$1$1(zzdz.1.1 param1) {}
  
  public void run()
  {
    synchronized (zzdz.zzc(zzyx.zzyw.zzyu))
    {
      if ((zzyx.zzyw.zzyt.getStatus() == -1) || (zzyx.zzyw.zzyt.getStatus() == 1)) {
        return;
      }
      zzyx.zzyw.zzyt.reject();
      zzid.runOnUiThread(new Runnable()
      {
        public void run()
        {
          zzyx.zzyv.destroy();
        }
      });
      zzb.v("Could not receive loaded message in a timely manner. Rejecting.");
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdz.1.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */