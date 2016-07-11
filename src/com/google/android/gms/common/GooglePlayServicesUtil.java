package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.UserManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.R.drawable;
import com.google.android.gms.R.string;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzml;
import com.google.android.gms.internal.zzmx;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public final class GooglePlayServicesUtil
{
  public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
  @Deprecated
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  @Deprecated
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = ;
  public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
  public static boolean zzaal = false;
  public static boolean zzaam = false;
  private static int zzaan = -1;
  private static String zzaao = null;
  private static Integer zzaap = null;
  static final AtomicBoolean zzaaq = new AtomicBoolean();
  private static final AtomicBoolean zzaar = new AtomicBoolean();
  private static final Object zzpy = new Object();
  
  @Deprecated
  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2)
  {
    return getErrorDialog(paramInt1, paramActivity, paramInt2, null);
  }
  
  @Deprecated
  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return zza(paramInt1, paramActivity, null, paramInt2, paramOnCancelListener);
  }
  
  @Deprecated
  public static PendingIntent getErrorPendingIntent(int paramInt1, Context paramContext, int paramInt2)
  {
    return GoogleApiAvailability.getInstance().getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2);
  }
  
  @Deprecated
  public static String getErrorString(int paramInt)
  {
    return ConnectionResult.getStatusString(paramInt);
  }
  
  @Deprecated
  public static String getOpenSourceSoftwareLicenseInfo(Context paramContext)
  {
    Object localObject = new Uri.Builder().scheme("android.resource").authority("com.google.android.gms").appendPath("raw").appendPath("oss_notice").build();
    try
    {
      InputStream localInputStream = paramContext.getContentResolver().openInputStream((Uri)localObject);
      try
      {
        paramContext = new Scanner(localInputStream).useDelimiter("\\A").next();
        localObject = paramContext;
        if (localInputStream != null)
        {
          localInputStream.close();
          return paramContext;
        }
      }
      catch (NoSuchElementException paramContext)
      {
        paramContext = paramContext;
        if (localInputStream == null) {
          break label97;
        }
        localInputStream.close();
        break label97;
      }
      finally
      {
        paramContext = finally;
        if (localInputStream != null) {
          localInputStream.close();
        }
        throw paramContext;
      }
      return (String)localObject;
    }
    catch (Exception paramContext)
    {
      localObject = null;
    }
    label97:
    return null;
  }
  
  public static Context getRemoteContext(Context paramContext)
  {
    try
    {
      paramContext = paramContext.createPackageContext("com.google.android.gms", 3);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  public static Resources getRemoteResource(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getResourcesForApplication("com.google.android.gms");
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  @Deprecated
  public static int isGooglePlayServicesAvailable(Context paramContext)
  {
    if (com.google.android.gms.common.internal.zzd.zzaeK) {
      return 0;
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    zzd localzzd;
    try
    {
      paramContext.getResources().getString(R.string.common_google_play_services_unknown_issue);
      if (!"com.google.android.gms".equals(paramContext.getPackageName())) {
        zzad(paramContext);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          PackageInfo localPackageInfo = localPackageManager.getPackageInfo("com.google.android.gms", 64);
          localzzd = zzd.zznu();
          if ((!zzml.zzcb(versionCode)) && (!zzml.zzan(paramContext))) {
            break;
          }
          if (localzzd.zza(localPackageInfo, zzc.zzbz.zzaak) != null) {
            break label193;
          }
          Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
          return 9;
        }
        catch (PackageManager.NameNotFoundException paramContext)
        {
          Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
          return 1;
        }
        localThrowable = localThrowable;
        Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
      }
    }
    try
    {
      paramContext = localzzd.zza(localPackageManager.getPackageInfo("com.android.vending", 8256), zzc.zzbz.zzaak);
      if (paramContext == null)
      {
        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
        return 9;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.w("GooglePlayServicesUtil", "Google Play Store is neither installed nor updating.");
      return 9;
    }
    if (localzzd.zza(localThrowable, new zzc.zza[] { paramContext }) == null)
    {
      Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
      return 9;
    }
    label193:
    int i = zzml.zzca(GOOGLE_PLAY_SERVICES_VERSION_CODE);
    if (zzml.zzca(versionCode) < i)
    {
      Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires " + GOOGLE_PLAY_SERVICES_VERSION_CODE + " but found " + versionCode);
      return 2;
    }
    ApplicationInfo localApplicationInfo = applicationInfo;
    paramContext = localApplicationInfo;
    if (localApplicationInfo == null) {}
    try
    {
      paramContext = localPackageManager.getApplicationInfo("com.google.android.gms", 0);
      if (!enabled) {
        return 3;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", paramContext);
      return 1;
    }
    return 0;
  }
  
  @Deprecated
  public static boolean isUserRecoverableError(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return false;
    }
    return true;
  }
  
  @Deprecated
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, int paramInt2)
  {
    return showErrorDialogFragment(paramInt1, paramActivity, paramInt2, null);
  }
  
  @Deprecated
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return showErrorDialogFragment(paramInt1, paramActivity, null, paramInt2, paramOnCancelListener);
  }
  
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    paramFragment = zza(paramInt1, paramActivity, paramFragment, paramInt2, paramOnCancelListener);
    if (paramFragment == null) {
      return false;
    }
    zza(paramActivity, paramOnCancelListener, "GooglePlayServicesErrorDialog", paramFragment);
    return true;
  }
  
  @Deprecated
  public static void showErrorNotification(int paramInt, Context paramContext)
  {
    int i = paramInt;
    if (zzml.zzan(paramContext))
    {
      i = paramInt;
      if (paramInt == 2) {
        i = 42;
      }
    }
    if ((zzd(paramContext, i)) || (zzf(paramContext, i)))
    {
      zzae(paramContext);
      return;
    }
    zza(i, paramContext);
  }
  
  private static Dialog zza(int paramInt1, Activity paramActivity, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Object localObject2 = null;
    if (paramInt1 == 0) {
      return null;
    }
    int i = paramInt1;
    if (zzml.zzan(paramActivity))
    {
      i = paramInt1;
      if (paramInt1 == 2) {
        i = 42;
      }
    }
    Object localObject1 = localObject2;
    if (zzmx.zzqx())
    {
      TypedValue localTypedValue = new TypedValue();
      paramActivity.getTheme().resolveAttribute(16843529, localTypedValue, true);
      localObject1 = localObject2;
      if ("Theme.Dialog.Alert".equals(paramActivity.getResources().getResourceEntryName(resourceId))) {
        localObject1 = new AlertDialog.Builder(paramActivity, 5);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new AlertDialog.Builder(paramActivity);
    }
    ((AlertDialog.Builder)localObject2).setMessage(zzg.zzc(paramActivity, i, zzaf(paramActivity)));
    if (paramOnCancelListener != null) {
      ((AlertDialog.Builder)localObject2).setOnCancelListener(paramOnCancelListener);
    }
    paramOnCancelListener = GoogleApiAvailability.getInstance().zza(paramActivity, i, "d");
    if (paramFragment == null) {}
    for (paramFragment = new zzh(paramActivity, paramOnCancelListener, paramInt2);; paramFragment = new zzh(paramFragment, paramOnCancelListener, paramInt2))
    {
      paramOnCancelListener = zzg.zzh(paramActivity, i);
      if (paramOnCancelListener != null) {
        ((AlertDialog.Builder)localObject2).setPositiveButton(paramOnCancelListener, paramFragment);
      }
      paramActivity = zzg.zzg(paramActivity, i);
      if (paramActivity != null) {
        ((AlertDialog.Builder)localObject2).setTitle(paramActivity);
      }
      return ((AlertDialog.Builder)localObject2).create();
    }
  }
  
  private static void zza(int paramInt, Context paramContext)
  {
    zza(paramInt, paramContext, null);
  }
  
  private static void zza(int paramInt, Context paramContext, String paramString)
  {
    Object localObject2 = paramContext.getResources();
    Object localObject3 = zzaf(paramContext);
    String str = zzg.zzi(paramContext, paramInt);
    Object localObject1 = str;
    if (str == null) {
      localObject1 = ((Resources)localObject2).getString(R.string.common_google_play_services_notification_ticker);
    }
    str = zzg.zzd(paramContext, paramInt, (String)localObject3);
    localObject3 = GoogleApiAvailability.getInstance().zza(paramContext, paramInt, 0, "n");
    if (zzml.zzan(paramContext))
    {
      zzx.zzZ(zzmx.zzqy());
      localObject1 = new Notification.Builder(paramContext).setSmallIcon(R.drawable.common_ic_googleplayservices).setPriority(2).setAutoCancel(true).setStyle(new Notification.BigTextStyle().bigText((String)localObject1 + " " + str)).addAction(R.drawable.common_full_open_on_phone, ((Resources)localObject2).getString(R.string.common_open_on_phone), (PendingIntent)localObject3).build();
      if (!zzbk(paramInt)) {
        break label367;
      }
      zzaaq.set(false);
    }
    label367:
    for (paramInt = 10436;; paramInt = 39789)
    {
      paramContext = (NotificationManager)paramContext.getSystemService("notification");
      if (paramString == null) {
        break label374;
      }
      paramContext.notify(paramString, paramInt, (Notification)localObject1);
      return;
      localObject2 = ((Resources)localObject2).getString(R.string.common_google_play_services_notification_ticker);
      if (zzmx.zzqu())
      {
        localObject1 = new Notification.Builder(paramContext).setSmallIcon(17301642).setContentTitle((CharSequence)localObject1).setContentText(str).setContentIntent((PendingIntent)localObject3).setTicker((CharSequence)localObject2).setAutoCancel(true);
        if (zzmx.zzqC()) {
          ((Notification.Builder)localObject1).setLocalOnly(true);
        }
        if (zzmx.zzqy()) {
          ((Notification.Builder)localObject1).setStyle(new Notification.BigTextStyle().bigText(str));
        }
        for (localObject1 = ((Notification.Builder)localObject1).build();; localObject1 = ((Notification.Builder)localObject1).getNotification())
        {
          if (Build.VERSION.SDK_INT == 19) {
            extras.putBoolean("android.support.localOnly", true);
          }
          break;
        }
      }
      localObject1 = new NotificationCompat.Builder(paramContext).setSmallIcon(17301642).setTicker((CharSequence)localObject2).setWhen(System.currentTimeMillis()).setAutoCancel(true).setContentIntent((PendingIntent)localObject3).setContentTitle((CharSequence)localObject1).setContentText(str).build();
      break;
    }
    label374:
    paramContext.notify(paramInt, (Notification)localObject1);
  }
  
  public static void zza(Activity paramActivity, DialogInterface.OnCancelListener paramOnCancelListener, String paramString, Dialog paramDialog)
  {
    try
    {
      bool = paramActivity instanceof FragmentActivity;
      if (bool)
      {
        paramActivity = ((FragmentActivity)paramActivity).getSupportFragmentManager();
        SupportErrorDialogFragment.newInstance(paramDialog, paramOnCancelListener).show(paramActivity, paramString);
        return;
      }
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      for (;;)
      {
        boolean bool = false;
      }
      if (zzmx.zzqu())
      {
        paramActivity = paramActivity.getFragmentManager();
        ErrorDialogFragment.newInstance(paramDialog, paramOnCancelListener).show(paramActivity, paramString);
        return;
      }
      throw new RuntimeException("This Activity does not support Fragments.");
    }
  }
  
  @Deprecated
  public static void zzaa(Context paramContext)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    int i = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(paramContext);
    if (i != 0)
    {
      paramContext = GoogleApiAvailability.getInstance().zza(paramContext, i, "e");
      Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + i);
      if (paramContext == null) {
        throw new GooglePlayServicesNotAvailableException(i);
      }
      throw new GooglePlayServicesRepairableException(i, "Google Play Services not available", paramContext);
    }
  }
  
  @Deprecated
  public static void zzac(Context paramContext)
  {
    if (zzaaq.getAndSet(true)) {
      return;
    }
    try
    {
      ((NotificationManager)paramContext.getSystemService("notification")).cancel(10436);
      return;
    }
    catch (SecurityException paramContext) {}
  }
  
  private static void zzad(Context paramContext)
  {
    if (zzaar.get()) {}
    do
    {
      return;
      for (;;)
      {
        synchronized (zzpy)
        {
          if (zzaao == null)
          {
            zzaao = paramContext.getPackageName();
            try
            {
              paramContext = getPackageManagergetApplicationInfogetPackageName128metaData;
              if (paramContext == null) {
                continue;
              }
              zzaap = Integer.valueOf(paramContext.getInt("com.google.android.gms.version"));
            }
            catch (PackageManager.NameNotFoundException paramContext)
            {
              Log.wtf("GooglePlayServicesUtil", "This should never happen.", paramContext);
              continue;
            }
            paramContext = zzaap;
            if (paramContext != null) {
              break;
            }
            throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            zzaap = null;
          }
        }
        if (!zzaao.equals(paramContext.getPackageName())) {
          throw new IllegalArgumentException("isGooglePlayServicesAvailable should only be called with Context from your application's package. A previous call used package '" + zzaao + "' and this call used package '" + paramContext.getPackageName() + "'.");
        }
      }
    } while (paramContext.intValue() == GOOGLE_PLAY_SERVICES_VERSION_CODE);
    throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + GOOGLE_PLAY_SERVICES_VERSION_CODE + " but" + " found " + paramContext + ".  You must have the" + " following declaration within the <application> element: " + "    <meta-data android:name=\"" + "com.google.android.gms.version" + "\" android:value=\"@integer/google_play_services_version\" />");
  }
  
  private static void zzae(Context paramContext)
  {
    paramContext = new zza(paramContext);
    paramContext.sendMessageDelayed(paramContext.obtainMessage(1), 120000L);
  }
  
  public static String zzaf(Context paramContext)
  {
    Object localObject2 = getApplicationInfoname;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = paramContext.getPackageName();
      localObject2 = paramContext.getApplicationContext().getPackageManager();
    }
    try
    {
      paramContext = ((PackageManager)localObject2).getApplicationInfo(paramContext.getPackageName(), 0);
      if (paramContext != null) {
        localObject1 = ((PackageManager)localObject2).getApplicationLabel(paramContext).toString();
      }
      return (String)localObject1;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
  }
  
  public static boolean zzag(Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    return (zzmx.zzqD()) && (paramContext.hasSystemFeature("com.google.sidewinder"));
  }
  
  public static boolean zzah(Context paramContext)
  {
    if (zzmx.zzqA())
    {
      paramContext = ((UserManager)paramContext.getSystemService("user")).getApplicationRestrictions(paramContext.getPackageName());
      if ((paramContext != null) && ("true".equals(paramContext.getString("restricted_profile")))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean zzb(Context paramContext, int paramInt, String paramString)
  {
    boolean bool2 = false;
    if (zzmx.zzqB()) {
      paramContext = (AppOpsManager)paramContext.getSystemService("appops");
    }
    for (;;)
    {
      try
      {
        paramContext.checkPackage(paramInt, paramString);
        bool1 = true;
        return bool1;
      }
      catch (SecurityException paramContext) {}
      paramContext = paramContext.getPackageManager().getPackagesForUid(paramInt);
      boolean bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramContext != null)
        {
          paramInt = 0;
          for (;;)
          {
            bool1 = bool2;
            if (paramInt >= paramContext.length) {
              break;
            }
            if (paramString.equals(paramContext[paramInt])) {
              return true;
            }
            paramInt += 1;
          }
        }
      }
    }
    return false;
  }
  
  public static boolean zzb(PackageManager paramPackageManager)
  {
    for (boolean bool = true;; bool = false) {
      synchronized (zzpy)
      {
        int i = zzaan;
        if (i == -1) {}
        try
        {
          paramPackageManager = paramPackageManager.getPackageInfo("com.google.android.gms", 64);
          if (zzd.zznu().zza(paramPackageManager, new zzc.zza[] { zzc.zzaad[1] }) != null) {}
          for (zzaan = 1; zzaan != 0; zzaan = 0) {
            return bool;
          }
        }
        catch (PackageManager.NameNotFoundException paramPackageManager)
        {
          for (;;)
          {
            zzaan = 0;
          }
        }
      }
    }
  }
  
  @Deprecated
  public static boolean zzb(PackageManager paramPackageManager, String paramString)
  {
    return zzd.zznu().zzb(paramPackageManager, paramString);
  }
  
  @Deprecated
  public static Intent zzbj(int paramInt)
  {
    return GoogleApiAvailability.getInstance().zza(null, paramInt, null);
  }
  
  private static boolean zzbk(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean zzc(PackageManager paramPackageManager)
  {
    return (zzb(paramPackageManager)) || (!zznt());
  }
  
  @Deprecated
  public static boolean zzd(Context paramContext, int paramInt)
  {
    if (paramInt == 18) {
      return true;
    }
    if (paramInt == 1) {
      return zzj(paramContext, "com.google.android.gms");
    }
    return false;
  }
  
  public static boolean zze(Context paramContext, int paramInt)
  {
    return (zzb(paramContext, paramInt, "com.google.android.gms")) && (zzb(paramContext.getPackageManager(), "com.google.android.gms"));
  }
  
  @Deprecated
  public static boolean zzf(Context paramContext, int paramInt)
  {
    if (paramInt == 9) {
      return zzj(paramContext, "com.android.vending");
    }
    return false;
  }
  
  static boolean zzj(Context paramContext, String paramString)
  {
    if (zzmx.zzqD())
    {
      Iterator localIterator = paramContext.getPackageManager().getPackageInstaller().getAllSessions().iterator();
      while (localIterator.hasNext()) {
        if (paramString.equals(((PackageInstaller.SessionInfo)localIterator.next()).getAppPackageName())) {
          return true;
        }
      }
    }
    if (zzah(paramContext)) {
      return false;
    }
    paramContext = paramContext.getPackageManager();
    try
    {
      boolean bool = getApplicationInfo8192enabled;
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  private static int zzns()
  {
    return 8115000;
  }
  
  public static boolean zznt()
  {
    if (zzaal) {
      return zzaam;
    }
    return "user".equals(Build.TYPE);
  }
  
  private static class zza
    extends Handler
  {
    private final Context zzqZ;
    
    zza(Context paramContext) {}
    
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.GooglePlayServicesUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */