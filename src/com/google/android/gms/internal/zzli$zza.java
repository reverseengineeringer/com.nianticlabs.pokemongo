package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

final class zzli$zza
  extends Handler
{
  zzli$zza(zzli paramzzli, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (what)
    {
    default: 
      Log.w("GoogleApiClientImpl", "Unknown message id: " + what);
      return;
    case 1: 
      zzli.zze(zzacr);
      return;
    case 2: 
      zzli.zzd(zzacr);
      return;
    case 3: 
      ((zzli.zzb)obj).zzg(zzacr);
      return;
    }
    throw ((RuntimeException)obj);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzli.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */