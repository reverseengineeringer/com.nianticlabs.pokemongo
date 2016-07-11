package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.zzp;

@zzgr
public class zzdt
  extends zzhz
{
  final zziz zzoM;
  final zzdv zzxY;
  private final String zzxZ;
  
  zzdt(zziz paramzziz, zzdv paramzzdv, String paramString)
  {
    zzoM = paramzziz;
    zzxY = paramzzdv;
    zzxZ = paramString;
    zzp.zzbI().zza(this);
  }
  
  public void onStop()
  {
    zzxY.abort();
  }
  
  public void zzbn()
  {
    try
    {
      zzxY.zzab(zzxZ);
      return;
    }
    finally
    {
      zzid.zzIE.post(new Runnable()
      {
        public void run()
        {
          zzp.zzbI().zzb(zzdt.this);
        }
      });
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */