package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.zzp;

@zzgr
public class zzhx
{
  private final String zzHG;
  private int zzIi;
  private int zzIj;
  private final zzhu zzpV;
  private final Object zzpd = new Object();
  
  zzhx(zzhu paramzzhu, String paramString)
  {
    zzpV = paramzzhu;
    zzHG = paramString;
  }
  
  public zzhx(String paramString)
  {
    this(zzp.zzby(), paramString);
  }
  
  public Bundle toBundle()
  {
    synchronized (zzpd)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("pmnli", zzIi);
      localBundle.putInt("pmnll", zzIj);
      return localBundle;
    }
  }
  
  public void zzf(int paramInt1, int paramInt2)
  {
    synchronized (zzpd)
    {
      zzIi = paramInt1;
      zzIj = paramInt2;
      zzpV.zza(zzHG, this);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */