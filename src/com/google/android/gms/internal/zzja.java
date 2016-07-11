package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

@zzgr
public class zzja
  extends WebViewClient
{
  private static final String[] zzJU = { "UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS" };
  private static final String[] zzJV = { "NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID" };
  private zzfi zzAl;
  private zza zzDn;
  private final HashMap<String, List<zzdk>> zzJW = new HashMap();
  private zzg zzJX;
  private zzb zzJY;
  private boolean zzJZ = false;
  private boolean zzKa;
  private zzn zzKb;
  private final zzfg zzKc;
  private boolean zzKd;
  private boolean zzKe;
  private boolean zzKf;
  private boolean zzKg;
  private int zzKh;
  protected zziz zzoM;
  private final Object zzpd = new Object();
  private boolean zzqW;
  private zza zzsy;
  private zzdo zzxO;
  private com.google.android.gms.ads.internal.zze zzxQ;
  private zzfc zzxR;
  private zzdm zzxT;
  private zzdg zzxn;
  
  public zzja(zziz paramzziz, boolean paramBoolean)
  {
    this(paramzziz, paramBoolean, new zzfg(paramzziz, paramzziz.zzha(), new zzbq(paramzziz.getContext())), null);
  }
  
  zzja(zziz paramzziz, boolean paramBoolean, zzfg paramzzfg, zzfc paramzzfc)
  {
    zzoM = paramzziz;
    zzqW = paramBoolean;
    zzKc = paramzzfg;
    zzxR = paramzzfc;
  }
  
  private void zza(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (!((Boolean)zzby.zzvp.get()).booleanValue()) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("err", paramString1);
    localBundle.putString("code", paramString2);
    localBundle.putString("host", zzaK(paramString3));
    zzp.zzbv().zza(paramContext, zzoM.zzhh().zzJu, "gmob-apps", localBundle, true);
  }
  
  private String zzaK(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = Uri.parse(paramString);
    if (paramString.getHost() != null) {
      return paramString.getHost();
    }
    return "";
  }
  
  private static boolean zzg(Uri paramUri)
  {
    paramUri = paramUri.getScheme();
    return ("http".equalsIgnoreCase(paramUri)) || ("https".equalsIgnoreCase(paramUri));
  }
  
  private void zzht()
  {
    synchronized (zzpd)
    {
      zzKa = true;
      zzKh += 1;
      zzhw();
      return;
    }
  }
  
  private void zzhu()
  {
    zzKh -= 1;
    zzhw();
  }
  
  private void zzhv()
  {
    zzKg = true;
    zzhw();
  }
  
  public final void onLoadResource(WebView paramWebView, String paramString)
  {
    zzb.v("Loading resource: " + paramString);
    paramWebView = Uri.parse(paramString);
    if (("gmsg".equalsIgnoreCase(paramWebView.getScheme())) && ("mobileads.google.com".equalsIgnoreCase(paramWebView.getHost()))) {
      zzh(paramWebView);
    }
  }
  
  public final void onPageFinished(WebView arg1, String paramString)
  {
    synchronized (zzpd)
    {
      if ((zzKe) && ("about:blank".equals(paramString)))
      {
        zzb.v("Blank page loaded, 1...");
        zzoM.zzhj();
        return;
      }
      zzKf = true;
      zzhw();
      return;
    }
  }
  
  public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if ((paramInt < 0) && (-paramInt - 1 < zzJU.length)) {}
    for (String str = zzJU[(-paramInt - 1)];; str = String.valueOf(paramInt))
    {
      zza(zzoM.getContext(), "http_err", str, paramString2);
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      return;
    }
  }
  
  public final void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    int i;
    if (paramSslError != null)
    {
      i = paramSslError.getPrimaryError();
      if ((i < 0) || (i >= zzJV.length)) {
        break label65;
      }
    }
    label65:
    for (String str = zzJV[i];; str = String.valueOf(i))
    {
      zza(zzoM.getContext(), "ssl_err", str, zzp.zzbx().zza(paramSslError));
      super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
      return;
    }
  }
  
  public final void reset()
  {
    synchronized (zzpd)
    {
      zzJW.clear();
      zzsy = null;
      zzJX = null;
      zzDn = null;
      zzxn = null;
      zzJZ = false;
      zzqW = false;
      zzKa = false;
      zzxT = null;
      zzKb = null;
      zzJY = null;
      if (zzxR != null)
      {
        zzxR.zzn(true);
        zzxR = null;
      }
      zzKd = false;
      return;
    }
  }
  
  public boolean shouldOverrideKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
  {
    switch (paramKeyEvent.getKeyCode())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    zzb.v("AdWebView shouldOverrideUrlLoading: " + paramString);
    Uri localUri = Uri.parse(paramString);
    if (("gmsg".equalsIgnoreCase(localUri.getScheme())) && ("mobileads.google.com".equalsIgnoreCase(localUri.getHost()))) {
      zzh(localUri);
    }
    for (;;)
    {
      return true;
      if ((zzJZ) && (paramWebView == zzoM.getWebView()) && (zzg(localUri)))
      {
        if (!zzKd)
        {
          zzKd = true;
          if ((zzsy != null) && (((Boolean)zzby.zzvd.get()).booleanValue())) {
            zzsy.onAdClicked();
          }
        }
        return super.shouldOverrideUrlLoading(paramWebView, paramString);
      }
      if (!zzoM.getWebView().willNotDraw())
      {
        try
        {
          zzan localzzan = zzoM.zzhg();
          paramWebView = localUri;
          if (localzzan != null)
          {
            paramWebView = localUri;
            if (localzzan.zzb(localUri)) {
              paramWebView = localzzan.zza(localUri, zzoM.getContext());
            }
          }
        }
        catch (zzao paramWebView)
        {
          for (;;)
          {
            zzb.zzaH("Unable to append parameter to URL: " + paramString);
            paramWebView = localUri;
          }
          zzxQ.zzp(paramString);
        }
        if ((zzxQ == null) || (zzxQ.zzbe())) {
          zza(new AdLauncherIntentInfoParcel("android.intent.action.VIEW", paramWebView.toString(), null, null, null, null, null));
        }
      }
      else
      {
        zzb.zzaH("AdWebView unable to handle URL: " + paramString);
      }
    }
  }
  
  public void zzF(boolean paramBoolean)
  {
    zzJZ = paramBoolean;
  }
  
  public void zza(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    zzKc.zze(paramInt1, paramInt2);
    if (zzxR != null) {
      zzxR.zza(paramInt1, paramInt2, paramBoolean);
    }
  }
  
  public final void zza(AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel)
  {
    zzg localzzg = null;
    boolean bool = zzoM.zzhi();
    zza localzza;
    if ((bool) && (!zzoM.zzaN().zztf))
    {
      localzza = null;
      if (!bool) {
        break label75;
      }
    }
    for (;;)
    {
      zza(new AdOverlayInfoParcel(paramAdLauncherIntentInfoParcel, localzza, localzzg, zzKb, zzoM.zzhh()));
      return;
      localzza = zzsy;
      break;
      label75:
      localzzg = zzJX;
    }
  }
  
  public void zza(AdOverlayInfoParcel paramAdOverlayInfoParcel)
  {
    boolean bool2 = false;
    if (zzxR != null) {}
    for (boolean bool1 = zzxR.zzef();; bool1 = false)
    {
      com.google.android.gms.ads.internal.overlay.zze localzze = zzp.zzbt();
      Context localContext = zzoM.getContext();
      if (!bool1) {
        bool2 = true;
      }
      localzze.zza(localContext, paramAdOverlayInfoParcel, bool2);
      return;
    }
  }
  
  public void zza(zza paramzza)
  {
    zzDn = paramzza;
  }
  
  public void zza(zzb paramzzb)
  {
    zzJY = paramzzb;
  }
  
  public final void zza(String paramString, zzdk paramzzdk)
  {
    synchronized (zzpd)
    {
      List localList = (List)zzJW.get(paramString);
      Object localObject1 = localList;
      if (localList == null)
      {
        localObject1 = new CopyOnWriteArrayList();
        zzJW.put(paramString, localObject1);
      }
      ((List)localObject1).add(paramzzdk);
      return;
    }
  }
  
  public final void zza(boolean paramBoolean, int paramInt)
  {
    if ((zzoM.zzhi()) && (!zzoM.zzaN().zztf)) {}
    for (zza localzza = null;; localzza = zzsy)
    {
      zza(new AdOverlayInfoParcel(localzza, zzJX, zzKb, zzoM, paramBoolean, paramInt, zzoM.zzhh()));
      return;
    }
  }
  
  public final void zza(boolean paramBoolean, int paramInt, String paramString)
  {
    Object localObject = null;
    boolean bool = zzoM.zzhi();
    zza localzza;
    if ((bool) && (!zzoM.zzaN().zztf))
    {
      localzza = null;
      if (!bool) {
        break label95;
      }
    }
    for (;;)
    {
      zza(new AdOverlayInfoParcel(localzza, (zzg)localObject, zzxn, zzKb, zzoM, paramBoolean, paramInt, paramString, zzoM.zzhh(), zzxT));
      return;
      localzza = zzsy;
      break;
      label95:
      localObject = new zzc(zzoM, zzJX);
    }
  }
  
  public final void zza(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    boolean bool = zzoM.zzhi();
    zza localzza;
    if ((bool) && (!zzoM.zzaN().zztf))
    {
      localzza = null;
      if (!bool) {
        break label97;
      }
    }
    label97:
    for (Object localObject = null;; localObject = new zzc(zzoM, zzJX))
    {
      zza(new AdOverlayInfoParcel(localzza, (zzg)localObject, zzxn, zzKb, zzoM, paramBoolean, paramInt, paramString1, paramString2, zzoM.zzhh(), zzxT));
      return;
      localzza = zzsy;
      break;
    }
  }
  
  public void zzb(zza paramzza, zzg paramzzg, zzdg paramzzdg, zzn paramzzn, boolean paramBoolean, zzdm paramzzdm, zzdo paramzzdo, com.google.android.gms.ads.internal.zze paramzze, zzfi paramzzfi)
  {
    com.google.android.gms.ads.internal.zze localzze = paramzze;
    if (paramzze == null) {
      localzze = new com.google.android.gms.ads.internal.zze(false);
    }
    zzxR = new zzfc(zzoM, paramzzfi);
    zza("/appEvent", new zzdf(paramzzdg));
    zza("/backButton", zzdj.zzxx);
    zza("/canOpenURLs", zzdj.zzxp);
    zza("/canOpenIntents", zzdj.zzxq);
    zza("/click", zzdj.zzxr);
    zza("/close", zzdj.zzxs);
    zza("/customClose", zzdj.zzxt);
    zza("/instrument", zzdj.zzxA);
    zza("/delayPageLoaded", new zzd(null));
    zza("/httpTrack", zzdj.zzxu);
    zza("/log", zzdj.zzxv);
    zza("/mraid", new zzdq(localzze, zzxR));
    zza("/mraidLoaded", zzKc);
    zza("/open", new zzdr(paramzzdm, localzze, zzxR));
    zza("/precache", zzdj.zzxz);
    zza("/touch", zzdj.zzxw);
    zza("/video", zzdj.zzxy);
    if (paramzzdo != null) {
      zza("/setInterstitialProperties", new zzdn(paramzzdo));
    }
    zzsy = paramzza;
    zzJX = paramzzg;
    zzxn = paramzzdg;
    zzxT = paramzzdm;
    zzKb = paramzzn;
    zzxQ = localzze;
    zzAl = paramzzfi;
    zzxO = paramzzdo;
    zzF(paramBoolean);
    zzKd = false;
  }
  
  public final void zzb(String paramString, zzdk paramzzdk)
  {
    synchronized (zzpd)
    {
      paramString = (List)zzJW.get(paramString);
      if (paramString == null) {
        return;
      }
      paramString.remove(paramzzdk);
      return;
    }
  }
  
  public boolean zzbY()
  {
    synchronized (zzpd)
    {
      boolean bool = zzqW;
      return bool;
    }
  }
  
  public void zzd(int paramInt1, int paramInt2)
  {
    if (zzxR != null) {
      zzxR.zzd(paramInt1, paramInt2);
    }
  }
  
  public void zze(zziz paramzziz)
  {
    zzoM = paramzziz;
  }
  
  public final void zzeG()
  {
    synchronized (zzpd)
    {
      zzJZ = false;
      zzqW = true;
      zzid.runOnUiThread(new Runnable()
      {
        public void run()
        {
          zzoM.zzho();
          zzd localzzd = zzoM.zzhc();
          if (localzzd != null) {
            localzzd.zzeG();
          }
          if (zzja.zzd(zzja.this) != null)
          {
            zzja.zzd(zzja.this).zzbf();
            zzja.zza(zzja.this, null);
          }
        }
      });
      return;
    }
  }
  
  public void zzh(Uri paramUri)
  {
    Object localObject2 = paramUri.getPath();
    Object localObject1 = (List)zzJW.get(localObject2);
    if (localObject1 != null)
    {
      paramUri = zzp.zzbv().zze(paramUri);
      if (zzb.zzN(2))
      {
        zzb.v("Received GMSG: " + (String)localObject2);
        localObject2 = paramUri.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          zzb.v("  " + str + ": " + (String)paramUri.get(str));
        }
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((zzdk)((Iterator)localObject1).next()).zza(zzoM, paramUri);
      }
    }
    zzb.v("No GMSG handler found for GMSG: " + paramUri);
  }
  
  public com.google.android.gms.ads.internal.zze zzhq()
  {
    return zzxQ;
  }
  
  public boolean zzhr()
  {
    synchronized (zzpd)
    {
      boolean bool = zzKa;
      return bool;
    }
  }
  
  public void zzhs()
  {
    synchronized (zzpd)
    {
      zzb.v("Loading blank page in WebView, 2...");
      zzKe = true;
      zzoM.zzaI("about:blank");
      return;
    }
  }
  
  public final void zzhw()
  {
    zza localzza;
    zziz localzziz;
    if ((zzDn != null) && (((zzKf) && (zzKh <= 0)) || (zzKg)))
    {
      localzza = zzDn;
      localzziz = zzoM;
      if (zzKg) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      localzza.zza(localzziz, bool);
      zzDn = null;
      zzoM.zzhp();
      return;
    }
  }
  
  public static abstract interface zza
  {
    public abstract void zza(zziz paramzziz, boolean paramBoolean);
  }
  
  public static abstract interface zzb
  {
    public abstract void zzbf();
  }
  
  private static class zzc
    implements zzg
  {
    private zzg zzJX;
    private zziz zzKj;
    
    public zzc(zziz paramzziz, zzg paramzzg)
    {
      zzKj = paramzziz;
      zzJX = paramzzg;
    }
    
    public void zzaV()
    {
      zzJX.zzaV();
      zzKj.zzgY();
    }
    
    public void zzaW()
    {
      zzJX.zzaW();
      zzKj.zzeJ();
    }
  }
  
  private class zzd
    implements zzdk
  {
    private zzd() {}
    
    public void zza(zziz paramzziz, Map<String, String> paramMap)
    {
      if (paramMap.keySet().contains("start")) {
        zzja.zza(zzja.this);
      }
      do
      {
        return;
        if (paramMap.keySet().contains("stop"))
        {
          zzja.zzb(zzja.this);
          return;
        }
      } while (!paramMap.keySet().contains("cancel"));
      zzja.zzc(zzja.this);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzja
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */