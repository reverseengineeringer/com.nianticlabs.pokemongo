package com.google.android.gms.common.api;

class Batch$1
  implements PendingResult.zza
{
  Batch$1(Batch paramBatch) {}
  
  public void zzt(Status paramStatus)
  {
    for (;;)
    {
      synchronized (Batch.zza(zzaaC))
      {
        if (zzaaC.isCanceled()) {
          return;
        }
        if (paramStatus.isCanceled())
        {
          Batch.zza(zzaaC, true);
          Batch.zzb(zzaaC);
          if (Batch.zzc(zzaaC) == 0)
          {
            if (!Batch.zzd(zzaaC)) {
              break;
            }
            Batch.zze(zzaaC);
          }
          return;
        }
      }
      if (!paramStatus.isSuccess()) {
        Batch.zzb(zzaaC, true);
      }
    }
    if (Batch.zzf(zzaaC)) {}
    for (paramStatus = new Status(13);; paramStatus = Status.zzabb)
    {
      zzaaC.zzb(new BatchResult(paramStatus, Batch.zzg(zzaaC)));
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.Batch.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */