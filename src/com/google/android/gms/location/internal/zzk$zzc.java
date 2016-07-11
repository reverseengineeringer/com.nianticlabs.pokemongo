package com.google.android.gms.location.internal;

import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.zzd.zza;

class zzk$zzc
  extends zzd.zza
{
  private Handler zzaFy;
  
  zzk$zzc(LocationListener paramLocationListener, Looper paramLooper)
  {
    boolean bool;
    if (paramLooper == null)
    {
      if (Looper.myLooper() != null)
      {
        bool = true;
        zzx.zza(bool, "Can't create handler inside thread that has not called Looper.prepare()");
      }
    }
    else {
      if (paramLooper != null) {
        break label46;
      }
    }
    label46:
    for (paramLocationListener = new zzk.zzb(paramLocationListener);; paramLocationListener = new zzk.zzb(paramLocationListener, paramLooper))
    {
      zzaFy = paramLocationListener;
      return;
      bool = false;
      break;
    }
  }
  
  public void onLocationChanged(Location paramLocation)
  {
    if (zzaFy == null)
    {
      Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
      return;
    }
    Message localMessage = Message.obtain();
    what = 1;
    obj = paramLocation;
    zzaFy.sendMessage(localMessage);
  }
  
  public void release()
  {
    zzaFy = null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzk.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */