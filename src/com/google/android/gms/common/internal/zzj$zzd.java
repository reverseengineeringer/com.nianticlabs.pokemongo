package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;

public final class zzj$zzd
  extends zzr.zza
{
  private zzj zzafM;
  private final int zzafN;
  
  public zzj$zzd(zzj paramzzj, int paramInt)
  {
    zzafM = paramzzj;
    zzafN = paramInt;
  }
  
  private void zzpj()
  {
    zzafM = null;
  }
  
  public void zza(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    zzx.zzb(zzafM, "onPostInitComplete can be called only once per call to getRemoteService");
    zzafM.zza(paramInt, paramIBinder, paramBundle, zzafN);
    zzpj();
  }
  
  public void zzb(int paramInt, Bundle paramBundle)
  {
    zzx.zzb(zzafM, "onAccountValidationComplete can be called only once per call to validateAccount");
    zzafM.zza(paramInt, paramBundle, zzafN);
    zzpj();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzj.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */