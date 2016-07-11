package com.google.android.gms.internal;

import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzt.zza;
import java.lang.ref.WeakReference;

class zzlg$zzb
  extends zzt.zza
{
  private final WeakReference<zzlg> zzabM;
  
  zzlg$zzb(zzlg paramzzlg)
  {
    zzabM = new WeakReference(paramzzlg);
  }
  
  public void zzb(final ResolveAccountResponse paramResolveAccountResponse)
  {
    final zzlg localzzlg = (zzlg)zzabM.get();
    if (localzzlg == null) {
      return;
    }
    zzlg.zzd(localzzlg).zza(new zzli.zzb(localzzlg)
    {
      public void zznO()
      {
        zzlg.zza(localzzlg, paramResolveAccountResponse);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlg.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */