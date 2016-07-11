package com.google.android.gms.common;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

class GooglePlayServicesUtil$zza
  extends Handler
{
  private final Context zzqZ;
  
  GooglePlayServicesUtil$zza(Context paramContext) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (what)
    {
    default: 
      Log.w("GooglePlayServicesUtil", "Don't know how to handle this message: " + what);
    }
    int i;
    do
    {
      return;
      i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(zzqZ);
    } while (!GooglePlayServicesUtil.isUserRecoverableError(i));
    GooglePlayServicesUtil.zzb(i, zzqZ);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.GooglePlayServicesUtil.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */