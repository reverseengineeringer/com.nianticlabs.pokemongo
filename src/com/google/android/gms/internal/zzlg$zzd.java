package com.google.android.gms.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.zza;
import com.google.android.gms.common.internal.zzx;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

class zzlg$zzd
  implements GoogleApiClient.zza
{
  private final WeakReference<zzlg> zzabM;
  private final Api<?> zzabS;
  private final int zzabT;
  
  public zzlg$zzd(zzlg paramzzlg, Api<?> paramApi, int paramInt)
  {
    zzabM = new WeakReference(paramzzlg);
    zzabS = paramApi;
    zzabT = paramInt;
  }
  
  public void zza(ConnectionResult paramConnectionResult)
  {
    boolean bool = false;
    zzlg localzzlg = (zzlg)zzabM.get();
    if (localzzlg == null) {
      return;
    }
    if (Looper.myLooper() == zzlg.zzd(localzzlg).getLooper()) {
      bool = true;
    }
    zzx.zza(bool, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
    zzlg.zzc(localzzlg).lock();
    try
    {
      bool = zzlg.zza(localzzlg, 0);
      if (!bool) {
        return;
      }
      if (!paramConnectionResult.isSuccess()) {
        zzlg.zza(localzzlg, paramConnectionResult, zzabS, zzabT);
      }
      if (zzlg.zzk(localzzlg)) {
        zzlg.zzl(localzzlg);
      }
      return;
    }
    finally
    {
      zzlg.zzc(localzzlg).unlock();
    }
  }
  
  public void zzb(ConnectionResult paramConnectionResult)
  {
    boolean bool = true;
    zzlg localzzlg = (zzlg)zzabM.get();
    if (localzzlg == null) {
      return;
    }
    if (Looper.myLooper() == zzlg.zzd(localzzlg).getLooper()) {}
    for (;;)
    {
      zzx.zza(bool, "onReportAccountValidation must be called on the GoogleApiClient handler thread");
      zzlg.zzc(localzzlg).lock();
      try
      {
        bool = zzlg.zza(localzzlg, 1);
        if (!bool)
        {
          return;
          bool = false;
          continue;
        }
        if (!paramConnectionResult.isSuccess()) {
          zzlg.zza(localzzlg, paramConnectionResult, zzabS, zzabT);
        }
        if (zzlg.zzk(localzzlg)) {
          zzlg.zzm(localzzlg);
        }
        return;
      }
      finally
      {
        zzlg.zzc(localzzlg).unlock();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlg.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */