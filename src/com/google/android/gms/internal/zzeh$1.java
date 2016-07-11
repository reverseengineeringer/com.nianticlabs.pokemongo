package com.google.android.gms.internal;

class zzeh$1
  implements Runnable
{
  zzeh$1(zzeh paramzzeh, zzeg paramzzeg) {}
  
  public void run()
  {
    synchronized (zzeh.zza(zzzs))
    {
      if (zzeh.zzb(zzzs) != -2) {
        return;
      }
      zzeh.zza(zzzs, zzeh.zzc(zzzs));
      if (zzeh.zzd(zzzs) == null)
      {
        zzzs.zzq(4);
        return;
      }
    }
    zzzr.zza(zzzs);
    zzeh.zza(zzzs, zzzr);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzeh.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */