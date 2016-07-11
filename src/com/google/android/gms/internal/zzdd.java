package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;

@zzgr
public class zzdd
  extends zzcy.zza
{
  private final NativeCustomTemplateAd.OnCustomClickListener zzxl;
  
  public zzdd(NativeCustomTemplateAd.OnCustomClickListener paramOnCustomClickListener)
  {
    zzxl = paramOnCustomClickListener;
  }
  
  public void zza(zzcu paramzzcu, String paramString)
  {
    zzxl.onCustomClick(new zzcv(paramzzcu), paramString);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */