package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.GoogleApiAvailability;

class zzp$zza
  implements Runnable
{
  private zzp$zza(zzp paramzzp) {}
  
  public void run()
  {
    synchronized (zzp.zzb(zzaHK))
    {
      Intent localIntent = new Intent("com.google.android.location.places.METHOD_CALL");
      localIntent.setPackage("com.google.android.gms");
      localIntent.putStringArrayListExtra("PLACE_IDS", zzp.zzc(zzaHK));
      localIntent.putStringArrayListExtra("METHOD_NAMES", zzp.zzd(zzaHK));
      localIntent.putExtra("PACKAGE_NAME", zzp.zze(zzaHK).getPackageName());
      localIntent.putExtra("CLIENT_VERSION", GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE);
      zzp.zze(zzaHK).sendBroadcast(localIntent);
      zzp.zza(zzaHK, null);
      zzp.zzb(zzaHK, null);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzp.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */