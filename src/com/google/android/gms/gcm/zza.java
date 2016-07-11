package com.google.android.gms.gcm;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.MissingFormatArgumentException;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

class zza
{
  static zza zzaCi;
  private Context mContext;
  
  private zza(Context paramContext)
  {
    mContext = paramContext.getApplicationContext();
  }
  
  private void zza(String paramString, Notification paramNotification)
  {
    if (Log.isLoggable("GcmNotification", 3)) {
      Log.d("GcmNotification", "Showing notification");
    }
    NotificationManager localNotificationManager = (NotificationManager)mContext.getSystemService("notification");
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "GCM-Notification:" + SystemClock.uptimeMillis();
    }
    localNotificationManager.notify(str, 0, paramNotification);
  }
  
  static zza zzaz(Context paramContext)
  {
    try
    {
      if (zzaCi == null) {
        zzaCi = new zza(paramContext);
      }
      paramContext = zzaCi;
      return paramContext;
    }
    finally {}
  }
  
  static String zzc(Bundle paramBundle, String paramString)
  {
    String str2 = paramBundle.getString(paramString);
    String str1 = str2;
    if (str2 == null) {
      str1 = paramBundle.getString(paramString.replace("gcm.n.", "gcm.notification."));
    }
    return str1;
  }
  
  private String zzd(Bundle paramBundle, String paramString)
  {
    String str = zzc(paramBundle, paramString);
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    str = zzc(paramBundle, paramString + "_loc_key");
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    localResources = mContext.getResources();
    j = localResources.getIdentifier(str, "string", mContext.getPackageName());
    if (j == 0) {
      throw new zza(zzdj(new StringBuilder().append(paramString).append("_loc_key").toString()) + " resource not found: " + str, null);
    }
    paramBundle = zzc(paramBundle, paramString + "_loc_args");
    if (TextUtils.isEmpty(paramBundle)) {
      return localResources.getString(j);
    }
    try
    {
      JSONArray localJSONArray = new JSONArray(paramBundle);
      paramBundle = new String[localJSONArray.length()];
      int i = 0;
      while (i < paramBundle.length)
      {
        paramBundle[i] = localJSONArray.opt(i);
        i += 1;
      }
      try
      {
        paramBundle = localResources.getString(j, paramBundle);
        return paramBundle;
      }
      catch (MissingFormatArgumentException paramBundle)
      {
        throw new zza("Missing format argument for " + localJSONException + ": " + paramBundle, null);
      }
    }
    catch (JSONException localJSONException)
    {
      throw new zza("Malformed " + zzdj(new StringBuilder().append(paramString).append("_loc_args").toString()) + ": " + paramBundle, null);
    }
  }
  
  private String zzdj(String paramString)
  {
    return paramString.substring("gcm.n.".length());
  }
  
  private int zzdk(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new zza("Missing icon", null);
    }
    Resources localResources = mContext.getResources();
    int i = localResources.getIdentifier(paramString, "drawable", mContext.getPackageName());
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = localResources.getIdentifier(paramString, "mipmap", mContext.getPackageName());
      i = j;
    } while (j != 0);
    throw new zza("Icon resource not found: " + paramString, null);
  }
  
  private Uri zzdl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if ("default".equals(paramString)) {
      return RingtoneManager.getDefaultUri(2);
    }
    throw new zza("Invalid sound: " + paramString, null);
  }
  
  static boolean zzu(Bundle paramBundle)
  {
    return zzc(paramBundle, "gcm.n.icon") != null;
  }
  
  private int zzvW()
  {
    return (int)SystemClock.uptimeMillis();
  }
  
  private Notification zzw(Bundle paramBundle)
  {
    Object localObject = zzd(paramBundle, "gcm.n.title");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      throw new zza("Missing title", null);
    }
    String str = zzd(paramBundle, "gcm.n.body");
    int i = zzdk(zzc(paramBundle, "gcm.n.icon"));
    Uri localUri = zzdl(zzc(paramBundle, "gcm.n.sound"));
    PendingIntent localPendingIntent = zzx(paramBundle);
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject = new Notification.Builder(mContext).setAutoCancel(true).setSmallIcon(i).setContentTitle((CharSequence)localObject).setContentText(str);
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramBundle = zzc(paramBundle, "gcm.n.color");
        if (!TextUtils.isEmpty(paramBundle)) {
          ((Notification.Builder)localObject).setColor(Color.parseColor(paramBundle));
        }
      }
      if (localUri != null) {
        ((Notification.Builder)localObject).setSound(localUri);
      }
      if (localPendingIntent != null) {
        ((Notification.Builder)localObject).setContentIntent(localPendingIntent);
      }
      if (Build.VERSION.SDK_INT >= 16) {
        return ((Notification.Builder)localObject).build();
      }
      return ((Notification.Builder)localObject).getNotification();
    }
    paramBundle = localPendingIntent;
    if (localPendingIntent == null)
    {
      paramBundle = new Intent();
      paramBundle.setPackage("com.google.example.invalidpackage");
      paramBundle = PendingIntent.getBroadcast(mContext, 0, paramBundle, 0);
    }
    paramBundle = new NotificationCompat.Builder(mContext).setSmallIcon(i).setAutoCancel(true).setContentIntent(paramBundle).setContentTitle((CharSequence)localObject).setContentText(str);
    if (localUri != null) {
      paramBundle.setSound(localUri);
    }
    return paramBundle.build();
  }
  
  private PendingIntent zzx(Bundle paramBundle)
  {
    Object localObject = zzc(paramBundle, "gcm.n.click_action");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    localObject = new Intent((String)localObject);
    ((Intent)localObject).setPackage(mContext.getPackageName());
    ((Intent)localObject).setFlags(268435456);
    ((Intent)localObject).putExtras(paramBundle);
    paramBundle = paramBundle.keySet().iterator();
    while (paramBundle.hasNext())
    {
      String str = (String)paramBundle.next();
      if ((str.startsWith("gcm.n.")) || (str.startsWith("gcm.notification."))) {
        ((Intent)localObject).removeExtra(str);
      }
    }
    return PendingIntent.getActivity(mContext, zzvW(), (Intent)localObject, 1073741824);
  }
  
  boolean zzv(Bundle paramBundle)
  {
    try
    {
      Notification localNotification = zzw(paramBundle);
      zza(zzc(paramBundle, "gcm.n.tag"), localNotification);
      return true;
    }
    catch (zza paramBundle)
    {
      Log.w("GcmNotification", "Failed to show notification: " + paramBundle.getMessage());
    }
    return false;
  }
  
  private class zza
    extends IllegalArgumentException
  {
    private zza(String paramString)
    {
      super();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.gcm.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */