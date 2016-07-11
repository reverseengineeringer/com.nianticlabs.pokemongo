package com.google.android.gms.location.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;

class zzk$zza$1
  extends Handler
{
  zzk$zza$1(zzk.zza paramzza, Looper paramLooper, LocationCallback paramLocationCallback)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (what)
    {
    default: 
      return;
    case 0: 
      zzaFh.onLocationResult((LocationResult)obj);
      return;
    }
    zzaFh.onLocationAvailability((LocationAvailability)obj);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzk.zza.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */