package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;

@zzgr
final class zzht$zza
{
  private long zzHN = -1L;
  private long zzHO = -1L;
  
  public Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("topen", zzHN);
    localBundle.putLong("tclose", zzHO);
    return localBundle;
  }
  
  public long zzgi()
  {
    return zzHO;
  }
  
  public void zzgj()
  {
    zzHO = SystemClock.elapsedRealtime();
  }
  
  public void zzgk()
  {
    zzHN = SystemClock.elapsedRealtime();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzht.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */