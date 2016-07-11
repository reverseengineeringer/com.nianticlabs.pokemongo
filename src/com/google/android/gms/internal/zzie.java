package com.google.android.gms.internal;

import android.app.Activity;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.io.File;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@zzgr
public class zzie
{
  public static zzie zzM(int paramInt)
  {
    if (paramInt >= 19) {
      return new zzg();
    }
    if (paramInt >= 18) {
      return new zze();
    }
    if (paramInt >= 17) {
      return new zzd();
    }
    if (paramInt >= 16) {
      return new zzf();
    }
    if (paramInt >= 14) {
      return new zzc();
    }
    if (paramInt >= 11) {
      return new zzb();
    }
    if (paramInt >= 9) {
      return new zza();
    }
    return new zzie();
  }
  
  public String getDefaultUserAgent(Context paramContext)
  {
    return "";
  }
  
  public boolean isAttachedToWindow(View paramView)
  {
    return (paramView.getWindowToken() != null) || (paramView.getWindowVisibility() != 8);
  }
  
  public Drawable zza(Context paramContext, Bitmap paramBitmap, boolean paramBoolean, float paramFloat)
  {
    return new BitmapDrawable(paramContext.getResources(), paramBitmap);
  }
  
  public String zza(SslError paramSslError)
  {
    return "";
  }
  
  public void zza(View paramView, Drawable paramDrawable)
  {
    paramView.setBackgroundDrawable(paramDrawable);
  }
  
  public void zza(ViewTreeObserver paramViewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    paramViewTreeObserver.removeGlobalOnLayoutListener(paramOnGlobalLayoutListener);
  }
  
  public boolean zza(DownloadManager.Request paramRequest)
  {
    return false;
  }
  
  public boolean zza(Context paramContext, WebSettings paramWebSettings)
  {
    return false;
  }
  
  public boolean zza(Window paramWindow)
  {
    return false;
  }
  
  public boolean zza(WebView paramWebView)
  {
    if (paramWebView == null) {
      return false;
    }
    paramWebView.onPause();
    return true;
  }
  
  public zzja zzb(zziz paramzziz, boolean paramBoolean)
  {
    return new zzja(paramzziz, paramBoolean);
  }
  
  public void zzb(Activity paramActivity, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    paramActivity = paramActivity.getWindow();
    if ((paramActivity != null) && (paramActivity.getDecorView() != null) && (paramActivity.getDecorView().getViewTreeObserver() != null)) {
      zza(paramActivity.getDecorView().getViewTreeObserver(), paramOnGlobalLayoutListener);
    }
  }
  
  public boolean zzb(WebView paramWebView)
  {
    if (paramWebView == null) {
      return false;
    }
    paramWebView.onResume();
    return true;
  }
  
  public WebChromeClient zzf(zziz paramzziz)
  {
    return null;
  }
  
  public Set<String> zzf(Uri paramUri)
  {
    if (paramUri.isOpaque()) {
      return Collections.emptySet();
    }
    paramUri = paramUri.getEncodedQuery();
    if (paramUri == null) {
      return Collections.emptySet();
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    int j = 0;
    int i;
    do
    {
      int k = paramUri.indexOf('&', j);
      i = k;
      if (k == -1) {
        i = paramUri.length();
      }
      int m = paramUri.indexOf('=', j);
      if (m <= i)
      {
        k = m;
        if (m != -1) {}
      }
      else
      {
        k = i;
      }
      localLinkedHashSet.add(Uri.decode(paramUri.substring(j, k)));
      i += 1;
      j = i;
    } while (i < paramUri.length());
    return Collections.unmodifiableSet(localLinkedHashSet);
  }
  
  public int zzgG()
  {
    return 0;
  }
  
  public int zzgH()
  {
    return 1;
  }
  
  public int zzgI()
  {
    return 5;
  }
  
  public ViewGroup.LayoutParams zzgJ()
  {
    return new ViewGroup.LayoutParams(-2, -2);
  }
  
  public boolean zzl(View paramView)
  {
    return false;
  }
  
  public boolean zzm(View paramView)
  {
    return false;
  }
  
  public static class zza
    extends zzie
  {
    public zza()
    {
      super();
    }
    
    public boolean zza(DownloadManager.Request paramRequest)
    {
      paramRequest.setShowRunningNotification(true);
      return true;
    }
    
    public int zzgG()
    {
      return 6;
    }
    
    public int zzgH()
    {
      return 7;
    }
  }
  
  public static class zzb
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
  
  public static class zzc
    extends zzie.zzb
  {
    public String zza(SslError paramSslError)
    {
      return paramSslError.getUrl();
    }
    
    public WebChromeClient zzf(zziz paramzziz)
    {
      return new zzjh(paramzziz);
    }
  }
  
  public static class zzd
    extends zzie.zzf
  {
    public String getDefaultUserAgent(Context paramContext)
    {
      return WebSettings.getDefaultUserAgent(paramContext);
    }
    
    public Drawable zza(Context paramContext, Bitmap paramBitmap, boolean paramBoolean, float paramFloat)
    {
      if ((!paramBoolean) || (paramFloat <= 0.0F) || (paramFloat > 25.0F)) {
        return new BitmapDrawable(paramContext.getResources(), paramBitmap);
      }
      try
      {
        Object localObject3 = Bitmap.createScaledBitmap(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight(), false);
        Object localObject1 = Bitmap.createBitmap((Bitmap)localObject3);
        Object localObject2 = RenderScript.create(paramContext);
        ScriptIntrinsicBlur localScriptIntrinsicBlur = ScriptIntrinsicBlur.create((RenderScript)localObject2, Element.U8_4((RenderScript)localObject2));
        localObject3 = Allocation.createFromBitmap((RenderScript)localObject2, (Bitmap)localObject3);
        localObject2 = Allocation.createFromBitmap((RenderScript)localObject2, (Bitmap)localObject1);
        localScriptIntrinsicBlur.setRadius(paramFloat);
        localScriptIntrinsicBlur.setInput((Allocation)localObject3);
        localScriptIntrinsicBlur.forEach((Allocation)localObject2);
        ((Allocation)localObject2).copyTo((Bitmap)localObject1);
        localObject1 = new BitmapDrawable(paramContext.getResources(), (Bitmap)localObject1);
        return (Drawable)localObject1;
      }
      catch (RuntimeException localRuntimeException) {}
      return new BitmapDrawable(paramContext.getResources(), paramBitmap);
    }
    
    public boolean zza(Context paramContext, WebSettings paramWebSettings)
    {
      super.zza(paramContext, paramWebSettings);
      paramWebSettings.setMediaPlaybackRequiresUserGesture(false);
      return true;
    }
  }
  
  public static class zze
    extends zzie.zzd
  {
    public boolean isAttachedToWindow(View paramView)
    {
      return (super.isAttachedToWindow(paramView)) || (paramView.getWindowId() != null);
    }
    
    public int zzgI()
    {
      return 14;
    }
  }
  
  public static class zzf
    extends zzie.zzc
  {
    public void zza(View paramView, Drawable paramDrawable)
    {
      paramView.setBackground(paramDrawable);
    }
    
    public void zza(ViewTreeObserver paramViewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
    {
      paramViewTreeObserver.removeOnGlobalLayoutListener(paramOnGlobalLayoutListener);
    }
    
    public void zzb(Activity paramActivity, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
    {
      paramActivity = paramActivity.getWindow();
      if ((paramActivity != null) && (paramActivity.getDecorView() != null) && (paramActivity.getDecorView().getViewTreeObserver() != null)) {
        zza(paramActivity.getDecorView().getViewTreeObserver(), paramOnGlobalLayoutListener);
      }
    }
  }
  
  public static class zzg
    extends zzie.zze
  {
    public boolean isAttachedToWindow(View paramView)
    {
      return paramView.isAttachedToWindow();
    }
    
    public ViewGroup.LayoutParams zzgJ()
    {
      return new ViewGroup.LayoutParams(-1, -1);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzie
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */