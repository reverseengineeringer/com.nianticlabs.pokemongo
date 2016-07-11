package com.google.android.gms.iid;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.gcm.GcmReceiver;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import java.io.IOException;

public class InstanceIDListenerService
  extends Service
{
  static String ACTION = "action";
  private static String zzaCn = "gcm.googleapis.com/refresh";
  private static String zzaDF = "google.com/iid";
  private static String zzaDG = "CMD";
  MessengerCompat zzaDD = new MessengerCompat(new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      InstanceIDListenerService.zza(InstanceIDListenerService.this, paramAnonymousMessage, MessengerCompat.zzc(paramAnonymousMessage));
    }
  });
  BroadcastReceiver zzaDE = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (Log.isLoggable("InstanceID", 3))
      {
        paramAnonymousIntent.getStringExtra("registration_id");
        Log.d("InstanceID", "Received GSF callback using dynamic receiver: " + paramAnonymousIntent.getExtras());
      }
      zzn(paramAnonymousIntent);
      stop();
    }
  };
  int zzaDH;
  int zzaDI;
  
  static void zza(Context paramContext, zzd paramzzd)
  {
    paramzzd.zzwt();
    paramzzd = new Intent("com.google.android.gms.iid.InstanceID");
    paramzzd.putExtra(zzaDG, "RST");
    paramzzd.setPackage(paramContext.getPackageName());
    paramContext.startService(paramzzd);
  }
  
  private void zza(Message paramMessage, int paramInt)
  {
    zzc.zzaE(this);
    getPackageManager();
    if ((paramInt != zzc.zzaDP) && (paramInt != zzc.zzaDO))
    {
      Log.w("InstanceID", "Message from unexpected caller " + paramInt + " mine=" + zzc.zzaDO + " appid=" + zzc.zzaDP);
      return;
    }
    zzn((Intent)obj);
  }
  
  static void zzaD(Context paramContext)
  {
    Intent localIntent = new Intent("com.google.android.gms.iid.InstanceID");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra(zzaDG, "SYNC");
    paramContext.startService(localIntent);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.google.android.gms.iid.InstanceID".equals(paramIntent.getAction()))) {
      return zzaDD.getBinder();
    }
    return null;
  }
  
  public void onCreate()
  {
    IntentFilter localIntentFilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
    localIntentFilter.addCategory(getPackageName());
    registerReceiver(zzaDE, localIntentFilter, "com.google.android.c2dm.permission.RECEIVE", null);
  }
  
  public void onDestroy()
  {
    unregisterReceiver(zzaDE);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    zzgI(paramInt2);
    if (paramIntent == null)
    {
      stop();
      return 2;
    }
    try
    {
      if ("com.google.android.gms.iid.InstanceID".equals(paramIntent.getAction()))
      {
        if (Build.VERSION.SDK_INT <= 18)
        {
          Intent localIntent = (Intent)paramIntent.getParcelableExtra("GSF");
          if (localIntent != null)
          {
            startService(localIntent);
            return 1;
          }
        }
        zzn(paramIntent);
      }
      stop();
      if (paramIntent.getStringExtra("from") != null) {
        GcmReceiver.completeWakefulIntent(paramIntent);
      }
      return 2;
    }
    finally
    {
      stop();
    }
  }
  
  public void onTokenRefresh() {}
  
  void stop()
  {
    try
    {
      zzaDH -= 1;
      if (zzaDH == 0) {
        stopSelf(zzaDI);
      }
      if (Log.isLoggable("InstanceID", 3)) {
        Log.d("InstanceID", "Stop " + zzaDH + " " + zzaDI);
      }
      return;
    }
    finally {}
  }
  
  public void zzag(boolean paramBoolean)
  {
    onTokenRefresh();
  }
  
  void zzgI(int paramInt)
  {
    try
    {
      zzaDH += 1;
      if (paramInt > zzaDI) {
        zzaDI = paramInt;
      }
      return;
    }
    finally {}
  }
  
  public void zzn(Intent paramIntent)
  {
    String str2 = paramIntent.getStringExtra("subtype");
    Object localObject;
    String str1;
    if (str2 == null)
    {
      localObject = InstanceID.getInstance(this);
      str1 = paramIntent.getStringExtra(zzaDG);
      if ((paramIntent.getStringExtra("error") == null) && (paramIntent.getStringExtra("registration_id") == null)) {
        break label116;
      }
      if (Log.isLoggable("InstanceID", 3)) {
        Log.d("InstanceID", "Register result in service " + str2);
      }
      ((InstanceID)localObject).zzwp().zzr(paramIntent);
    }
    label116:
    label298:
    do
    {
      do
      {
        return;
        localObject = new Bundle();
        ((Bundle)localObject).putString("subtype", str2);
        localObject = InstanceID.zza(this, (Bundle)localObject);
        break;
        if (Log.isLoggable("InstanceID", 3)) {
          Log.d("InstanceID", "Service command " + str2 + " " + str1 + " " + paramIntent.getExtras());
        }
        if (paramIntent.getStringExtra("unregistered") != null)
        {
          zzd localzzd = ((InstanceID)localObject).zzwo();
          str1 = str2;
          if (str2 == null) {
            str1 = "";
          }
          localzzd.zzds(str1);
          ((InstanceID)localObject).zzwp().zzr(paramIntent);
          return;
        }
        if (zzaCn.equals(paramIntent.getStringExtra("from")))
        {
          ((InstanceID)localObject).zzwo().zzds(str2);
          zzag(false);
          return;
        }
        if ("RST".equals(str1))
        {
          ((InstanceID)localObject).zzwn();
          zzag(true);
          return;
        }
        if (!"RST_FULL".equals(str1)) {
          break label298;
        }
      } while (((InstanceID)localObject).zzwo().isEmpty());
      ((InstanceID)localObject).zzwo().zzwt();
      zzag(true);
      return;
      if ("SYNC".equals(str1))
      {
        ((InstanceID)localObject).zzwo().zzds(str2);
        zzag(false);
        return;
      }
    } while (!"PING".equals(str1));
    try
    {
      GoogleCloudMessaging.getInstance(this).send(zzaDF, zzc.zzws(), 0L, paramIntent.getExtras());
      return;
    }
    catch (IOException paramIntent)
    {
      Log.w("InstanceID", "Failed to send ping response");
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.iid.InstanceIDListenerService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */