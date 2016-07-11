package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient.zza;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class zzlg$zze
  extends zzlg.zzi
{
  private final Map<Api.zzb, GoogleApiClient.zza> zzabU;
  
  public zzlg$zze(Map<Api.zzb, GoogleApiClient.zza> paramMap)
  {
    super(paramMap, null);
    Map localMap;
    zzabU = localMap;
  }
  
  public void zznO()
  {
    int i = zzlg.zzb(zzabL).isGooglePlayServicesAvailable(zzlg.zza(zzabL));
    final Object localObject;
    if (i != 0)
    {
      localObject = new ConnectionResult(i, null);
      zzlg.zzd(zzabL).zza(new zzli.zzb(zzabL)
      {
        public void zznO()
        {
          zzlg.zza(zzabL, localObject);
        }
      });
    }
    for (;;)
    {
      return;
      if (zzlg.zze(zzabL)) {
        zzlg.zzf(zzabL).connect();
      }
      localObject = zzabU.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Api.zzb localzzb = (Api.zzb)((Iterator)localObject).next();
        localzzb.zza((GoogleApiClient.zza)zzabU.get(localzzb));
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlg.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */