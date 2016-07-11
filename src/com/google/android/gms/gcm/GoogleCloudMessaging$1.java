package com.google.android.gms.gcm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.concurrent.BlockingQueue;

class GoogleCloudMessaging$1
  extends Handler
{
  GoogleCloudMessaging$1(GoogleCloudMessaging paramGoogleCloudMessaging, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage == null) || (!(obj instanceof Intent))) {
      Log.w("GCM", "Dropping invalid message");
    }
    paramMessage = (Intent)obj;
    if ("com.google.android.c2dm.intent.REGISTRATION".equals(paramMessage.getAction())) {
      GoogleCloudMessaging.zza(zzaCB).add(paramMessage);
    }
    while (GoogleCloudMessaging.zza(zzaCB, paramMessage)) {
      return;
    }
    paramMessage.setPackage(GoogleCloudMessaging.zzb(zzaCB).getPackageName());
    GoogleCloudMessaging.zzb(zzaCB).sendBroadcast(paramMessage);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.gcm.GoogleCloudMessaging.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */