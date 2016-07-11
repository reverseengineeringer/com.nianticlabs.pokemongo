package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzw.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzgr;

@zzgr
public class zzm
  extends zzw.zza
{
  private static final Object zzpy = new Object();
  private static zzm zzpz;
  private final Context mContext;
  private boolean zzpA;
  
  zzm(Context paramContext)
  {
    mContext = paramContext;
    zzpA = false;
  }
  
  public static zzm zzq(Context paramContext)
  {
    synchronized (zzpy)
    {
      if (zzpz == null) {
        zzpz = new zzm(paramContext.getApplicationContext());
      }
      paramContext = zzpz;
      return paramContext;
    }
  }
  
  public void zza()
  {
    synchronized (zzpy)
    {
      if (zzpA)
      {
        zzb.zzaH("Mobile ads is initialized already.");
        return;
      }
      zzpA = true;
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */