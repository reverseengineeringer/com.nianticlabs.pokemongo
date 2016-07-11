package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzgr
public abstract class zzgf
  extends zzhz
{
  protected final Context mContext;
  protected final zzgg.zza zzDd;
  protected final zzhs.zza zzDe;
  protected AdResponseParcel zzDf;
  protected final Object zzDh = new Object();
  protected final Object zzpd = new Object();
  
  protected zzgf(Context paramContext, zzhs.zza paramzza, zzgg.zza paramzza1)
  {
    super(true);
    mContext = paramContext;
    zzDe = paramzza;
    zzDf = zzHD;
    zzDd = paramzza1;
  }
  
  public void onStop() {}
  
  protected abstract zzhs zzA(int paramInt);
  
  public void zzbn()
  {
    for (;;)
    {
      int i;
      synchronized (zzpd)
      {
        zzb.zzaF("AdRendererBackgroundTask started.");
        i = zzDe.errorCode;
        try
        {
          zzh(SystemClock.elapsedRealtime());
          final zzhs localzzhs = zzA(i);
          zzid.zzIE.post(new Runnable()
          {
            public void run()
            {
              synchronized (zzpd)
              {
                zzi(localzzhs);
                return;
              }
            }
          });
          return;
        }
        catch (zza localzza)
        {
          i = localzza.getErrorCode();
          if (i == 3) {
            continue;
          }
        }
        if (i == -1)
        {
          zzb.zzaG(localzza.getMessage());
          if (zzDf == null)
          {
            zzDf = new AdResponseParcel(i);
            zzid.zzIE.post(new Runnable()
            {
              public void run()
              {
                onStop();
              }
            });
          }
        }
        else
        {
          zzb.zzaH(localzza.getMessage());
        }
      }
      zzDf = new AdResponseParcel(i, zzDf.zzzc);
    }
  }
  
  protected abstract void zzh(long paramLong)
    throws zzgf.zza;
  
  protected void zzi(zzhs paramzzhs)
  {
    zzDd.zzb(paramzzhs);
  }
  
  protected static final class zza
    extends Exception
  {
    private final int zzDv;
    
    public zza(String paramString, int paramInt)
    {
      super();
      zzDv = paramInt;
    }
    
    public int getErrorCode()
    {
      return zzDv;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */