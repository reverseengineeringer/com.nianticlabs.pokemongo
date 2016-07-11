package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.signin.internal.AuthAccountResult;
import com.google.android.gms.signin.internal.zzb;
import java.lang.ref.WeakReference;

class zzlg$zza
  extends zzb
{
  private final WeakReference<zzlg> zzabM;
  
  zzlg$zza(zzlg paramzzlg)
  {
    zzabM = new WeakReference(paramzzlg);
  }
  
  public void zza(final ConnectionResult paramConnectionResult, final AuthAccountResult paramAuthAccountResult)
  {
    paramAuthAccountResult = (zzlg)zzabM.get();
    if (paramAuthAccountResult == null) {
      return;
    }
    zzlg.zzd(paramAuthAccountResult).zza(new zzli.zzb(paramAuthAccountResult)
    {
      public void zznO()
      {
        zzlg.zzc(paramAuthAccountResult, paramConnectionResult);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlg.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */