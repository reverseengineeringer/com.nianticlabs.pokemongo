package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.List;

public class GcmNetworkManager
{
  public static final int RESULT_FAILURE = 2;
  public static final int RESULT_RESCHEDULE = 1;
  public static final int RESULT_SUCCESS = 0;
  private static GcmNetworkManager zzaCh;
  private Context mContext;
  private final PendingIntent mPendingIntent;
  
  private GcmNetworkManager(Context paramContext)
  {
    mContext = paramContext;
    mPendingIntent = PendingIntent.getBroadcast(mContext, 0, new Intent(), 0);
  }
  
  public static GcmNetworkManager getInstance(Context paramContext)
  {
    if (zzaCh == null) {
      zzaCh = new GcmNetworkManager(paramContext.getApplicationContext());
    }
    return zzaCh;
  }
  
  static void zzdh(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("Must provide a valid tag.");
    }
    if (100 < paramString.length()) {
      throw new IllegalArgumentException("Tag is larger than max permissible tag length (100)");
    }
  }
  
  private void zzdi(String paramString)
  {
    boolean bool2 = true;
    zzx.zzb(paramString, "GcmTaskService must not be null.");
    Object localObject = new Intent("com.google.android.gms.gcm.ACTION_TASK_READY");
    ((Intent)localObject).setPackage(mContext.getPackageName());
    localObject = mContext.getPackageManager().queryIntentServices((Intent)localObject, 0);
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      bool1 = true;
      zzx.zzb(bool1, "There is no GcmTaskService component registered within this package. Have you extended GcmTaskService correctly?");
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!nextserviceInfo.name.equals(paramString));
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzx.zzb(bool1, "The GcmTaskService class you provided " + paramString + " does not seem to support receiving" + " com.google.android.gms.gcm.ACTION_TASK_READY.");
      return;
      bool1 = false;
      break;
    }
  }
  
  private Intent zzvV()
  {
    int i = GoogleCloudMessaging.zzaB(mContext);
    if (i < GoogleCloudMessaging.zzaCs)
    {
      Log.e("GcmNetworkManager", "Google Play Services is not available, dropping GcmNetworkManager request. code=" + i);
      return null;
    }
    Intent localIntent = new Intent("com.google.android.gms.gcm.ACTION_SCHEDULE");
    localIntent.setPackage(GoogleCloudMessaging.zzaA(mContext));
    localIntent.putExtra("app", mPendingIntent);
    return localIntent;
  }
  
  public void cancelAllTasks(Class<? extends GcmTaskService> paramClass)
  {
    zzdi(paramClass.getName());
    Intent localIntent = zzvV();
    if (localIntent == null) {
      return;
    }
    localIntent.putExtra("scheduler_action", "CANCEL_ALL");
    localIntent.putExtra("component", new ComponentName(mContext, paramClass));
    mContext.sendBroadcast(localIntent);
  }
  
  public void cancelTask(String paramString, Class<? extends GcmTaskService> paramClass)
  {
    zzdh(paramString);
    zzdi(paramClass.getName());
    Intent localIntent = zzvV();
    if (localIntent == null) {
      return;
    }
    localIntent.putExtra("scheduler_action", "CANCEL_TASK");
    localIntent.putExtra("tag", paramString);
    localIntent.putExtra("component", new ComponentName(mContext, paramClass));
    mContext.sendBroadcast(localIntent);
  }
  
  public void schedule(Task paramTask)
  {
    zzdi(paramTask.getServiceName());
    Intent localIntent = zzvV();
    if (localIntent == null) {
      return;
    }
    Bundle localBundle = localIntent.getExtras();
    localBundle.putString("scheduler_action", "SCHEDULE_TASK");
    paramTask.toBundle(localBundle);
    localIntent.putExtras(localBundle);
    mContext.sendBroadcast(localIntent);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.gcm.GcmNetworkManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */