package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzid;

@zzgr
public class zza
{
  public boolean zza(Context paramContext, AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel, zzn paramzzn)
  {
    if (paramAdLauncherIntentInfoParcel == null)
    {
      zzb.zzaH("No intent data for launcher overlay.");
      return false;
    }
    Intent localIntent = new Intent();
    if (TextUtils.isEmpty(url))
    {
      zzb.zzaH("Open GMSG did not contain a URL.");
      return false;
    }
    if (!TextUtils.isEmpty(mimeType)) {
      localIntent.setDataAndType(Uri.parse(url), mimeType);
    }
    String[] arrayOfString;
    for (;;)
    {
      localIntent.setAction("android.intent.action.VIEW");
      if (!TextUtils.isEmpty(packageName)) {
        localIntent.setPackage(packageName);
      }
      if (TextUtils.isEmpty(zzAL)) {
        break label178;
      }
      arrayOfString = zzAL.split("/", 2);
      if (arrayOfString.length >= 2) {
        break;
      }
      zzb.zzaH("Could not parse component name from open GMSG: " + zzAL);
      return false;
      localIntent.setData(Uri.parse(url));
    }
    localIntent.setClassName(arrayOfString[0], arrayOfString[1]);
    label178:
    paramAdLauncherIntentInfoParcel = zzAM;
    if (!TextUtils.isEmpty(paramAdLauncherIntentInfoParcel)) {}
    try
    {
      i = Integer.parseInt(paramAdLauncherIntentInfoParcel);
      localIntent.addFlags(i);
    }
    catch (NumberFormatException paramAdLauncherIntentInfoParcel)
    {
      for (;;)
      {
        try
        {
          zzb.v("Launching an intent: " + localIntent.toURI());
          zzp.zzbv().zzb(paramContext, localIntent);
          if (paramzzn != null) {
            paramzzn.zzaO();
          }
          return true;
        }
        catch (ActivityNotFoundException paramContext)
        {
          int i;
          zzb.zzaH(paramContext.getMessage());
        }
        paramAdLauncherIntentInfoParcel = paramAdLauncherIntentInfoParcel;
        zzb.zzaH("Could not parse intent flags.");
        i = 0;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */