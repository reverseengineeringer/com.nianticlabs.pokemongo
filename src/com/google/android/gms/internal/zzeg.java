package com.google.android.gms.internal;

@zzgr
public final class zzeg
  extends zzeo.zza
{
  private final Object zzpd = new Object();
  private zzei.zza zzzh;
  private zzef zzzi;
  
  public void onAdClicked()
  {
    synchronized (zzpd)
    {
      if (zzzi != null) {
        zzzi.zzaX();
      }
      return;
    }
  }
  
  public void onAdClosed()
  {
    synchronized (zzpd)
    {
      if (zzzi != null) {
        zzzi.zzaY();
      }
      return;
    }
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    for (;;)
    {
      synchronized (zzpd)
      {
        if (zzzh != null)
        {
          if (paramInt == 3)
          {
            paramInt = 1;
            zzzh.zzq(paramInt);
            zzzh = null;
          }
        }
        else {
          return;
        }
      }
      paramInt = 2;
    }
  }
  
  public void onAdLeftApplication()
  {
    synchronized (zzpd)
    {
      if (zzzi != null) {
        zzzi.zzaZ();
      }
      return;
    }
  }
  
  public void onAdLoaded()
  {
    synchronized (zzpd)
    {
      if (zzzh != null)
      {
        zzzh.zzq(0);
        zzzh = null;
        return;
      }
      if (zzzi != null) {
        zzzi.zzbb();
      }
      return;
    }
  }
  
  public void onAdOpened()
  {
    synchronized (zzpd)
    {
      if (zzzi != null) {
        zzzi.zzba();
      }
      return;
    }
  }
  
  public void zza(zzef paramzzef)
  {
    synchronized (zzpd)
    {
      zzzi = paramzzef;
      return;
    }
  }
  
  public void zza(zzei.zza paramzza)
  {
    synchronized (zzpd)
    {
      zzzh = paramzza;
      return;
    }
  }
  
  public void zza(zzep paramzzep)
  {
    synchronized (zzpd)
    {
      if (zzzh != null)
      {
        zzzh.zza(0, paramzzep);
        zzzh = null;
        return;
      }
      if (zzzi != null) {
        zzzi.zzbb();
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzeg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */