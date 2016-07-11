package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.ads.internal.zzg;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

@zzgr
public final class zzch
  extends zzcj.zza
{
  private final zzg zzvW;
  private final String zzvX;
  private final String zzvY;
  
  public zzch(zzg paramzzg, String paramString1, String paramString2)
  {
    zzvW = paramzzg;
    zzvX = paramString1;
    zzvY = paramString2;
  }
  
  public String getContent()
  {
    return zzvY;
  }
  
  public void recordClick()
  {
    zzvW.recordClick();
  }
  
  public void recordImpression()
  {
    zzvW.recordImpression();
  }
  
  public void zza(zzd paramzzd)
  {
    if (paramzzd == null) {
      return;
    }
    zzvW.zzc((View)zze.zzp(paramzzd));
  }
  
  public String zzdr()
  {
    return zzvX;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzch
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */