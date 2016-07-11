package com.google.android.gms.ads.internal.overlay;

import android.os.Handler;
import com.google.android.gms.internal.zzid;

class zzq
  implements Runnable
{
  private boolean mCancelled = false;
  private zzk zzCo;
  
  zzq(zzk paramzzk)
  {
    zzCo = paramzzk;
  }
  
  public void cancel()
  {
    mCancelled = true;
    zzid.zzIE.removeCallbacks(this);
  }
  
  public void run()
  {
    if (!mCancelled)
    {
      zzCo.zzeX();
      zzfg();
    }
  }
  
  public void zzfg()
  {
    zzid.zzIE.postDelayed(this, 250L);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */