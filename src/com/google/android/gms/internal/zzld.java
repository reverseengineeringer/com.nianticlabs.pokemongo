package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;

public abstract class zzld<L>
  implements zzlm.zzb<L>
{
  private final DataHolder zzabq;
  
  protected zzld(DataHolder paramDataHolder)
  {
    zzabq = paramDataHolder;
  }
  
  protected abstract void zza(L paramL, DataHolder paramDataHolder);
  
  public void zznN()
  {
    if (zzabq != null) {
      zzabq.close();
    }
  }
  
  public final void zzq(L paramL)
  {
    zza(paramL, zzabq);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzld
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */