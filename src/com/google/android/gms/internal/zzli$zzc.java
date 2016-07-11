package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.google.android.gms.common.api.zza;
import java.lang.ref.WeakReference;

class zzli$zzc
  implements IBinder.DeathRecipient, zzli.zze
{
  private final WeakReference<zza> zzacA;
  private final WeakReference<IBinder> zzacB;
  private final WeakReference<zzli.zzf<?>> zzacz;
  
  private zzli$zzc(zzli.zzf paramzzf, zza paramzza, IBinder paramIBinder)
  {
    zzacA = new WeakReference(paramzza);
    zzacz = new WeakReference(paramzzf);
    zzacB = new WeakReference(paramIBinder);
  }
  
  private void zzoh()
  {
    Object localObject = (zzli.zzf)zzacz.get();
    zza localzza = (zza)zzacA.get();
    if ((localzza != null) && (localObject != null)) {
      localzza.remove(((zzli.zzf)localObject).zznF().intValue());
    }
    localObject = (IBinder)zzacB.get();
    if (zzacB != null) {
      ((IBinder)localObject).unlinkToDeath(this, 0);
    }
  }
  
  public void binderDied()
  {
    zzoh();
  }
  
  public void zzc(zzli.zzf<?> paramzzf)
  {
    zzoh();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzli.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */