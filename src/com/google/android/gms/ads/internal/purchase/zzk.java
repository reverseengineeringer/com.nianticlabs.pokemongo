package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzid;

@zzgr
public class zzk
{
  private final String zztG;
  
  public zzk(String paramString)
  {
    zztG = paramString;
  }
  
  public boolean zza(String paramString, int paramInt, Intent paramIntent)
  {
    if ((paramString == null) || (paramIntent == null)) {}
    String str;
    do
    {
      return false;
      str = zzp.zzbF().zze(paramIntent);
      paramIntent = zzp.zzbF().zzf(paramIntent);
    } while ((str == null) || (paramIntent == null));
    if (!paramString.equals(zzp.zzbF().zzao(str)))
    {
      zzb.zzaH("Developer payload not match.");
      return false;
    }
    if ((zztG != null) && (!zzl.zzc(zztG, str, paramIntent)))
    {
      zzb.zzaH("Fail to verify signature.");
      return false;
    }
    return true;
  }
  
  public String zzfq()
  {
    return zzp.zzbv().zzgD();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.purchase.zzk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */