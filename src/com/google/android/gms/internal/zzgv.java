package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;
import java.util.concurrent.Future;

@zzgr
public final class zzgv
{
  private String zzBY;
  private String zzFO;
  private zzin<zzgx> zzFP = new zzin();
  zzdz.zzd zzFQ;
  public final zzdk zzFR = new zzdk()
  {
    public void zza(zziz arg1, Map<String, String> paramAnonymousMap)
    {
      synchronized (zzgv.zza(zzgv.this))
      {
        if (zzgv.zzb(zzgv.this).isDone()) {
          return;
        }
        if (!zzgv.zzc(zzgv.this).equals(paramAnonymousMap.get("request_id"))) {
          return;
        }
      }
      paramAnonymousMap = new zzgx(1, paramAnonymousMap);
      zzb.zzaH("Invalid " + paramAnonymousMap.getType() + " request error: " + paramAnonymousMap.zzfU());
      zzgv.zzb(zzgv.this).zzf(paramAnonymousMap);
    }
  };
  public final zzdk zzFS = new zzdk()
  {
    public void zza(zziz paramAnonymouszziz, Map<String, String> paramAnonymousMap)
    {
      zzgx localzzgx;
      synchronized (zzgv.zza(zzgv.this))
      {
        if (zzgv.zzb(zzgv.this).isDone()) {
          return;
        }
        localzzgx = new zzgx(-2, paramAnonymousMap);
        if (!zzgv.zzc(zzgv.this).equals(localzzgx.getRequestId()))
        {
          zzb.zzaH(localzzgx.getRequestId() + " ==== " + zzgv.zzc(zzgv.this));
          return;
        }
      }
      String str = localzzgx.getUrl();
      if (str == null)
      {
        zzb.zzaH("URL missing in loadAdUrl GMSG.");
        return;
      }
      if (str.contains("%40mediation_adapters%40"))
      {
        paramAnonymouszziz = str.replaceAll("%40mediation_adapters%40", zzhy.zza(paramAnonymouszziz.getContext(), (String)paramAnonymousMap.get("check_adapters"), zzgv.zzd(zzgv.this)));
        localzzgx.setUrl(paramAnonymouszziz);
        zzb.v("Ad request URL modified to " + paramAnonymouszziz);
      }
      zzgv.zzb(zzgv.this).zzf(localzzgx);
    }
  };
  zziz zzoM;
  private final Object zzpd = new Object();
  
  public zzgv(String paramString1, String paramString2)
  {
    zzFO = paramString2;
    zzBY = paramString1;
  }
  
  public void zzb(zzdz.zzd paramzzd)
  {
    zzFQ = paramzzd;
  }
  
  public void zze(zziz paramzziz)
  {
    zzoM = paramzziz;
  }
  
  public zzdz.zzd zzfR()
  {
    return zzFQ;
  }
  
  public Future<zzgx> zzfS()
  {
    return zzFP;
  }
  
  public void zzfT()
  {
    if (zzoM != null)
    {
      zzoM.destroy();
      zzoM = null;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */