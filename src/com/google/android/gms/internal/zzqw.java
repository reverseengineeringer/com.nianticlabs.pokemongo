package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.signin.internal.zze;
import java.util.Set;

public abstract interface zzqw
  extends Api.zzb
{
  public abstract void connect();
  
  public abstract void zzCe();
  
  public abstract void zza(zzp paramzzp, Set<Scope> paramSet, zze paramzze);
  
  public abstract void zza(zzp paramzzp, boolean paramBoolean);
  
  public abstract void zza(zzt paramzzt);
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */