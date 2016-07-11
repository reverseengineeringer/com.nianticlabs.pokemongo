package com.google.android.gms.ads.internal;

import android.content.Intent;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.purchase.zzi;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zziz;

class zzb$1
  implements Runnable
{
  zzb$1(zzb paramzzb, Intent paramIntent) {}
  
  public void run()
  {
    int i = zzp.zzbF().zzd(zzoz);
    zzp.zzbF();
    if ((i == 0) && (zzoA.zzot.zzqo != null) && (zzoA.zzot.zzqo.zzBD != null) && (zzoA.zzot.zzqo.zzBD.zzhc() != null)) {
      zzoA.zzot.zzqo.zzBD.zzhc().close();
    }
    zzoA.zzot.zzqI = false;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzb.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */