package com.google.android.gms.internal;

import android.app.DownloadManager.Request;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import java.io.File;
import java.util.Set;

public class zzie$zzb
  extends zzie.zza
{
  public boolean zza(DownloadManager.Request paramRequest)
  {
    paramRequest.allowScanningByMediaScanner();
    paramRequest.setNotificationVisibility(1);
    return true;
  }
  
  public boolean zza(Context paramContext, WebSettings paramWebSettings)
  {
    if (paramContext.getCacheDir() != null)
    {
      paramWebSettings.setAppCachePath(paramContext.getCacheDir().getAbsolutePath());
      paramWebSettings.setAppCacheMaxSize(0L);
      paramWebSettings.setAppCacheEnabled(true);
    }
    paramWebSettings.setDatabasePath(paramContext.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
    paramWebSettings.setDatabaseEnabled(true);
    paramWebSettings.setDomStorageEnabled(true);
    paramWebSettings.setDisplayZoomControls(false);
    paramWebSettings.setBuiltInZoomControls(true);
    paramWebSettings.setSupportZoom(true);
    return true;
  }
  
  public boolean zza(Window paramWindow)
  {
    paramWindow.setFlags(16777216, 16777216);
    return true;
  }
  
  public zzja zzb(zziz paramzziz, boolean paramBoolean)
  {
    return new zzjg(paramzziz, paramBoolean);
  }
  
  public WebChromeClient zzf(zziz paramzziz)
  {
    return new zzjf(paramzziz);
  }
  
  public Set<String> zzf(Uri paramUri)
  {
    return paramUri.getQueryParameterNames();
  }
  
  public boolean zzl(View paramView)
  {
    paramView.setLayerType(0, null);
    return true;
  }
  
  public boolean zzm(View paramView)
  {
    paramView.setLayerType(1, null);
    return true;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzie.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */