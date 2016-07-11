package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.gms.R.string;
import com.google.android.gms.common.internal.zzn;

public class GoogleApiAvailability
{
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  private static final GoogleApiAvailability zzaab = new GoogleApiAvailability();
  
  public static GoogleApiAvailability getInstance()
  {
    return zzaab;
  }
  
  private String zzk(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gcore_");
    localStringBuilder.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
    localStringBuilder.append("-");
    if (!TextUtils.isEmpty(paramString)) {
      localStringBuilder.append(paramString);
    }
    localStringBuilder.append("-");
    if (paramContext != null) {
      localStringBuilder.append(paramContext.getPackageName());
    }
    localStringBuilder.append("-");
    if (paramContext != null) {}
    try
    {
      localStringBuilder.append(getPackageManagergetPackageInfogetPackageName0versionCode);
      return localStringBuilder.toString();
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
  }
  
  public Dialog getErrorDialog(Activity paramActivity, int paramInt1, int paramInt2)
  {
    return GooglePlayServicesUtil.getErrorDialog(paramInt1, paramActivity, paramInt2);
  }
  
  public Dialog getErrorDialog(Activity paramActivity, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return GooglePlayServicesUtil.getErrorDialog(paramInt1, paramActivity, paramInt2, paramOnCancelListener);
  }
  
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, int paramInt1, int paramInt2)
  {
    return zza(paramContext, paramInt1, paramInt2, null);
  }
  
  public final String getErrorString(int paramInt)
  {
    return GooglePlayServicesUtil.getErrorString(paramInt);
  }
  
  public String getOpenSourceSoftwareLicenseInfo(Context paramContext)
  {
    return GooglePlayServicesUtil.getOpenSourceSoftwareLicenseInfo(paramContext);
  }
  
  public int isGooglePlayServicesAvailable(Context paramContext)
  {
    int j = GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext);
    int i = j;
    if (GooglePlayServicesUtil.zzd(paramContext, j)) {
      i = 18;
    }
    return i;
  }
  
  public final boolean isUserResolvableError(int paramInt)
  {
    return GooglePlayServicesUtil.isUserRecoverableError(paramInt);
  }
  
  public boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, int paramInt2)
  {
    return GooglePlayServicesUtil.showErrorDialogFragment(paramInt1, paramActivity, paramInt2);
  }
  
  public boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return GooglePlayServicesUtil.showErrorDialogFragment(paramInt1, paramActivity, paramInt2, paramOnCancelListener);
  }
  
  public void showErrorNotification(Context paramContext, int paramInt)
  {
    GooglePlayServicesUtil.showErrorNotification(paramInt, paramContext);
  }
  
  public Dialog zza(Activity paramActivity, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Object localObject2 = new ProgressBar(paramActivity, null, 16842874);
    ((ProgressBar)localObject2).setIndeterminate(true);
    ((ProgressBar)localObject2).setVisibility(0);
    Object localObject1 = new AlertDialog.Builder(paramActivity);
    ((AlertDialog.Builder)localObject1).setView((View)localObject2);
    localObject2 = GooglePlayServicesUtil.zzaf(paramActivity);
    ((AlertDialog.Builder)localObject1).setMessage(paramActivity.getResources().getString(R.string.common_google_play_services_updating_text, new Object[] { localObject2 }));
    ((AlertDialog.Builder)localObject1).setTitle(R.string.common_google_play_services_updating_title);
    ((AlertDialog.Builder)localObject1).setPositiveButton("", null);
    localObject1 = ((AlertDialog.Builder)localObject1).create();
    GooglePlayServicesUtil.zza(paramActivity, paramOnCancelListener, "GooglePlayServicesUpdatingDialog", (Dialog)localObject1);
    return (Dialog)localObject1;
  }
  
  public PendingIntent zza(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    paramString = zza(paramContext, paramInt1, paramString);
    if (paramString == null) {
      return null;
    }
    return PendingIntent.getActivity(paramContext, paramInt2, paramString, 268435456);
  }
  
  public Intent zza(Context paramContext, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
    case 2: 
      return zzn.zzw("com.google.android.gms", zzk(paramContext, paramString));
    case 42: 
      return zzn.zzpo();
    }
    return zzn.zzco("com.google.android.gms");
  }
  
  public void zzab(Context paramContext)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    GooglePlayServicesUtil.zzaa(paramContext);
  }
  
  public void zzac(Context paramContext)
  {
    GooglePlayServicesUtil.zzac(paramContext);
  }
  
  @Deprecated
  public Intent zzbi(int paramInt)
  {
    return zza(null, paramInt, null);
  }
  
  public boolean zzd(Context paramContext, int paramInt)
  {
    return GooglePlayServicesUtil.zzd(paramContext, paramInt);
  }
  
  public boolean zzj(Context paramContext, String paramString)
  {
    return GooglePlayServicesUtil.zzj(paramContext, paramString);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.GoogleApiAvailability
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */