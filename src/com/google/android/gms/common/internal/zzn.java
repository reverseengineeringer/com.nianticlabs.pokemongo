package com.google.android.gms.common.internal;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;

public class zzn
{
  private static final Uri zzagi = Uri.parse("http://plus.google.com/");
  private static final Uri zzagj = zzagi.buildUpon().appendPath("circles").appendPath("find").build();
  
  public static Intent zzco(String paramString)
  {
    paramString = Uri.fromParts("package", paramString, null);
    Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
    localIntent.setData(paramString);
    return localIntent;
  }
  
  public static Intent zzpo()
  {
    Intent localIntent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
    localIntent.setPackage("com.google.android.wearable.app");
    return localIntent;
  }
  
  private static Uri zzv(String paramString1, String paramString2)
  {
    paramString1 = Uri.parse("market://details").buildUpon().appendQueryParameter("id", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1.appendQueryParameter("pcampaignid", paramString2);
    }
    return paramString1.build();
  }
  
  public static Intent zzw(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(zzv(paramString1, paramString2));
    localIntent.setPackage("com.android.vending");
    localIntent.addFlags(524288);
    return localIntent;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */