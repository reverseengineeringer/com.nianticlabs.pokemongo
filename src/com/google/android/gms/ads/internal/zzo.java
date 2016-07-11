package com.google.android.gms.ads.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzid;
import java.lang.ref.WeakReference;

@zzgr
public class zzo
{
  private final zza zzpG;
  private AdRequestParcel zzpH;
  private boolean zzpI = false;
  private boolean zzpJ = false;
  private long zzpK = 0L;
  private final Runnable zzx;
  
  public zzo(zza paramzza)
  {
    this(paramzza, new zza(zzid.zzIE));
  }
  
  zzo(zza paramzza, zza paramzza1)
  {
    zzpG = paramzza1;
    zzx = new Runnable()
    {
      public void run()
      {
        zzo.zza(zzo.this, false);
        zza localzza = (zza)zzpL.get();
        if (localzza != null) {
          localzza.zzd(zzo.zza(zzo.this));
        }
      }
    };
  }
  
  public void cancel()
  {
    zzpI = false;
    zzpG.removeCallbacks(zzx);
  }
  
  public void pause()
  {
    zzpJ = true;
    if (zzpI) {
      zzpG.removeCallbacks(zzx);
    }
  }
  
  public void resume()
  {
    zzpJ = false;
    if (zzpI)
    {
      zzpI = false;
      zza(zzpH, zzpK);
    }
  }
  
  public void zza(AdRequestParcel paramAdRequestParcel, long paramLong)
  {
    if (zzpI) {
      zzb.zzaH("An ad refresh is already scheduled.");
    }
    do
    {
      return;
      zzpH = paramAdRequestParcel;
      zzpI = true;
      zzpK = paramLong;
    } while (zzpJ);
    zzb.zzaG("Scheduling ad refresh " + paramLong + " milliseconds from now.");
    zzpG.postDelayed(zzx, paramLong);
  }
  
  public boolean zzbp()
  {
    return zzpI;
  }
  
  public void zzg(AdRequestParcel paramAdRequestParcel)
  {
    zza(paramAdRequestParcel, 60000L);
  }
  
  public static class zza
  {
    private final Handler mHandler;
    
    public zza(Handler paramHandler)
    {
      mHandler = paramHandler;
    }
    
    public boolean postDelayed(Runnable paramRunnable, long paramLong)
    {
      return mHandler.postDelayed(paramRunnable, paramLong);
    }
    
    public void removeCallbacks(Runnable paramRunnable)
    {
      mHandler.removeCallbacks(paramRunnable);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */