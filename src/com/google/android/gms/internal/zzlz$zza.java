package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

class zzlz$zza
  extends zzlw
{
  private final zzlb.zzb<Status> zzagy;
  
  public zzlz$zza(zzlb.zzb<Status> paramzzb)
  {
    zzagy = paramzzb;
  }
  
  public void zzbN(int paramInt)
    throws RemoteException
  {
    zzagy.zzp(new Status(paramInt));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlz.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */