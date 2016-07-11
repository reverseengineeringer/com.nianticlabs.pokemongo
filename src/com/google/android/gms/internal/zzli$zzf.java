package com.google.android.gms.internal;

import android.os.DeadObjectException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Status;

abstract interface zzli$zzf<A extends Api.zzb>
{
  public abstract void cancel();
  
  public abstract boolean isReady();
  
  public abstract void zza(zzli.zze paramzze);
  
  public abstract void zzb(A paramA)
    throws DeadObjectException;
  
  public abstract Integer zznF();
  
  public abstract void zznJ();
  
  public abstract int zznK();
  
  public abstract Api.zzc<A> zznx();
  
  public abstract void zzv(Status paramStatus);
  
  public abstract void zzw(Status paramStatus);
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzli.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */