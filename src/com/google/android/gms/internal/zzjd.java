package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
class zzjd
  extends WebView
  implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zziz
{
  private int zzAD = -1;
  private int zzAE = -1;
  private int zzAG = -1;
  private int zzAH = -1;
  private String zzBY = "";
  private Boolean zzHZ;
  private Map<String, zzdv> zzKA;
  private final zza zzKm;
  private zzja zzKn;
  private com.google.android.gms.ads.internal.overlay.zzd zzKo;
  private boolean zzKp;
  private boolean zzKq;
  private boolean zzKr;
  private boolean zzKs;
  private int zzKt;
  private boolean zzKu = true;
  private zzce zzKv;
  private zzce zzKw;
  private zzce zzKx;
  private zzcf zzKy;
  private com.google.android.gms.ads.internal.overlay.zzd zzKz;
  private final com.google.android.gms.ads.internal.zzd zzow;
  private final VersionInfoParcel zzpb;
  private final Object zzpd = new Object();
  private zzim zzqR;
  private final WindowManager zzri;
  private final zzan zzwL;
  private AdSizeParcel zzzm;
  
  protected zzjd(zza paramzza, AdSizeParcel paramAdSizeParcel, boolean paramBoolean1, boolean paramBoolean2, zzan paramzzan, VersionInfoParcel paramVersionInfoParcel, zzcg paramzzcg, com.google.android.gms.ads.internal.zzd paramzzd)
  {
    super(paramzza);
    zzKm = paramzza;
    zzzm = paramAdSizeParcel;
    zzKr = paramBoolean1;
    zzKt = -1;
    zzwL = paramzzan;
    zzpb = paramVersionInfoParcel;
    zzow = paramzzd;
    zzri = ((WindowManager)getContext().getSystemService("window"));
    setBackgroundColor(0);
    paramAdSizeParcel = getSettings();
    paramAdSizeParcel.setJavaScriptEnabled(true);
    paramAdSizeParcel.setSavePassword(false);
    paramAdSizeParcel.setSupportMultipleWindows(true);
    paramAdSizeParcel.setJavaScriptCanOpenWindowsAutomatically(true);
    if (Build.VERSION.SDK_INT >= 21) {
      paramAdSizeParcel.setMixedContentMode(0);
    }
    zzp.zzbv().zza(paramzza, zzJu, paramAdSizeParcel);
    zzp.zzbx().zza(getContext(), paramAdSizeParcel);
    setDownloadListener(this);
    zzhz();
    if (zzmx.zzqz()) {
      addJavascriptInterface(new zzje(this), "googleAdsJsInterface");
    }
    zzqR = new zzim(zzKm.zzgZ(), this, null);
    zzd(paramzzcg);
  }
  
  static zzjd zzb(Context paramContext, AdSizeParcel paramAdSizeParcel, boolean paramBoolean1, boolean paramBoolean2, zzan paramzzan, VersionInfoParcel paramVersionInfoParcel, zzcg paramzzcg, com.google.android.gms.ads.internal.zzd paramzzd)
  {
    return new zzjd(new zza(paramContext), paramAdSizeParcel, paramBoolean1, paramBoolean2, paramzzan, paramVersionInfoParcel, paramzzcg, paramzzd);
  }
  
  private void zzd(zzcg paramzzcg)
  {
    zzhD();
    zzKy = new zzcf(new zzcg(true, "make_wv", zzzm.zzte));
    zzKy.zzdm().zzc(paramzzcg);
    zzKw = zzcc.zzb(zzKy.zzdm());
    zzKy.zza("native:view_create", zzKw);
    zzKx = null;
    zzKv = null;
  }
  
  private void zzhA()
  {
    synchronized (zzpd)
    {
      if (!zzKs) {
        zzp.zzbx().zzm(this);
      }
      zzKs = true;
      return;
    }
  }
  
  private void zzhB()
  {
    synchronized (zzpd)
    {
      if (zzKs) {
        zzp.zzbx().zzl(this);
      }
      zzKs = false;
      return;
    }
  }
  
  private void zzhC()
  {
    synchronized (zzpd)
    {
      if (zzKA != null)
      {
        Iterator localIterator = zzKA.values().iterator();
        if (localIterator.hasNext()) {
          ((zzdv)localIterator.next()).release();
        }
      }
    }
  }
  
  private void zzhD()
  {
    if (zzKy == null) {}
    zzcg localzzcg;
    do
    {
      return;
      localzzcg = zzKy.zzdm();
    } while ((localzzcg == null) || (zzp.zzby().zzgo() == null));
    zzp.zzby().zzgo().zza(localzzcg);
  }
  
  private void zzhy()
  {
    synchronized (zzpd)
    {
      zzHZ = zzp.zzby().zzgs();
      Boolean localBoolean = zzHZ;
      if (localBoolean == null) {}
      try
      {
        evaluateJavascript("(function(){})()", null);
        zzb(Boolean.valueOf(true));
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          zzb(Boolean.valueOf(false));
        }
      }
    }
  }
  
  private void zzhz()
  {
    for (;;)
    {
      synchronized (zzpd)
      {
        if ((zzKr) || (zzzm.zztf))
        {
          if (Build.VERSION.SDK_INT < 14)
          {
            zzb.zzaF("Disabling hardware acceleration on an overlay.");
            zzhA();
            return;
          }
          zzb.zzaF("Enabling hardware acceleration on an overlay.");
          zzhB();
        }
      }
      if (Build.VERSION.SDK_INT < 18)
      {
        zzb.zzaF("Disabling hardware acceleration on an AdView.");
        zzhA();
      }
      else
      {
        zzb.zzaF("Enabling hardware acceleration on an AdView.");
        zzhB();
      }
    }
  }
  
  public void destroy()
  {
    synchronized (zzpd)
    {
      zzhD();
      zzqR.zzgP();
      if (zzKo != null)
      {
        zzKo.close();
        zzKo.onDestroy();
        zzKo = null;
      }
      zzKn.reset();
      if (zzKq) {
        return;
      }
      zzp.zzbI().zza(this);
      zzhC();
      zzKq = true;
      zzb.v("Initiating WebView self destruct sequence in 3...");
      zzKn.zzhs();
      return;
    }
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    synchronized (zzpd)
    {
      if (isDestroyed())
      {
        zzb.zzaH("The webview is destroyed. Ignoring action.");
        if (paramValueCallback != null) {
          paramValueCallback.onReceiveValue(null);
        }
        return;
      }
      super.evaluateJavascript(paramString, paramValueCallback);
      return;
    }
  }
  
  public String getRequestId()
  {
    synchronized (zzpd)
    {
      String str = zzBY;
      return str;
    }
  }
  
  public int getRequestedOrientation()
  {
    synchronized (zzpd)
    {
      int i = zzKt;
      return i;
    }
  }
  
  public View getView()
  {
    return this;
  }
  
  public WebView getWebView()
  {
    return this;
  }
  
  public boolean isDestroyed()
  {
    synchronized (zzpd)
    {
      boolean bool = zzKq;
      return bool;
    }
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    synchronized (zzpd)
    {
      if (!isDestroyed())
      {
        super.loadData(paramString1, paramString2, paramString3);
        return;
      }
      zzb.zzaH("The webview is destroyed. Ignoring action.");
    }
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    synchronized (zzpd)
    {
      if (!isDestroyed())
      {
        super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
        return;
      }
      zzb.zzaH("The webview is destroyed. Ignoring action.");
    }
  }
  
  public void loadUrl(String paramString)
  {
    for (;;)
    {
      synchronized (zzpd)
      {
        boolean bool = isDestroyed();
        if (!bool) {
          try
          {
            super.loadUrl(paramString);
            return;
          }
          catch (Throwable paramString)
          {
            zzb.zzaH("Could not call loadUrl. " + paramString);
            continue;
          }
        }
      }
      zzb.zzaH("The webview is destroyed. Ignoring action.");
    }
  }
  
  protected void onAttachedToWindow()
  {
    synchronized (zzpd)
    {
      super.onAttachedToWindow();
      if (!isDestroyed()) {
        zzqR.onAttachedToWindow();
      }
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    synchronized (zzpd)
    {
      if (!isDestroyed()) {
        zzqR.onDetachedFromWindow();
      }
      super.onDetachedFromWindow();
      return;
    }
  }
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    try
    {
      paramString2 = new Intent("android.intent.action.VIEW");
      paramString2.setDataAndType(Uri.parse(paramString1), paramString4);
      zzp.zzbv().zzb(getContext(), paramString2);
      return;
    }
    catch (ActivityNotFoundException paramString2)
    {
      zzb.zzaF("Couldn't find an Activity to view url/mimetype: " + paramString1 + " / " + paramString4);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (isDestroyed()) {}
    while ((Build.VERSION.SDK_INT == 21) && (paramCanvas.isHardwareAccelerated()) && (!isAttachedToWindow())) {
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void onGlobalLayout()
  {
    boolean bool = zzhx();
    com.google.android.gms.ads.internal.overlay.zzd localzzd = zzhc();
    if ((localzzd != null) && (bool)) {
      localzzd.zzeI();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = Integer.MAX_VALUE;
    synchronized (zzpd)
    {
      if (isDestroyed())
      {
        setMeasuredDimension(0, 0);
        return;
      }
      if ((isInEditMode()) || (zzKr) || (zzzm.zzth) || (zzzm.zzti))
      {
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
    }
    if (zzzm.zztf)
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      zzri.getDefaultDisplay().getMetrics(localDisplayMetrics);
      setMeasuredDimension(widthPixels, heightPixels);
      return;
    }
    int n = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt2);
    if (n != Integer.MIN_VALUE) {
      if (n == 1073741824) {
        break label368;
      }
    }
    for (;;)
    {
      if ((zzzm.widthPixels > paramInt1) || (zzzm.heightPixels > paramInt2))
      {
        float f = zzKm.getResources().getDisplayMetrics().density;
        zzb.zzaH("Not enough space to show ad. Needs " + (int)(zzzm.widthPixels / f) + "x" + (int)(zzzm.heightPixels / f) + " dp, but only has " + (int)(i / f) + "x" + (int)(k / f) + " dp.");
        if (getVisibility() != 8) {
          setVisibility(4);
        }
        setMeasuredDimension(0, 0);
      }
      for (;;)
      {
        return;
        if (getVisibility() != 8) {
          setVisibility(0);
        }
        setMeasuredDimension(zzzm.widthPixels, zzzm.heightPixels);
      }
      paramInt1 = Integer.MAX_VALUE;
      break label371;
      label368:
      paramInt1 = i;
      label371:
      if (m != Integer.MIN_VALUE)
      {
        paramInt2 = j;
        if (m != 1073741824) {}
      }
      else
      {
        paramInt2 = k;
      }
    }
  }
  
  public void onPause()
  {
    if (isDestroyed()) {}
    for (;;)
    {
      return;
      try
      {
        if (zzmx.zzqu())
        {
          super.onPause();
          return;
        }
      }
      catch (Exception localException)
      {
        zzb.zzb("Could not pause webview.", localException);
      }
    }
  }
  
  public void onResume()
  {
    if (isDestroyed()) {}
    for (;;)
    {
      return;
      try
      {
        if (zzmx.zzqu())
        {
          super.onResume();
          return;
        }
      }
      catch (Exception localException)
      {
        zzb.zzb("Could not resume webview.", localException);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (zzwL != null) {
      zzwL.zza(paramMotionEvent);
    }
    if (isDestroyed()) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setContext(Context paramContext)
  {
    zzKm.setBaseContext(paramContext);
    zzqR.zzk(zzKm.zzgZ());
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    synchronized (zzpd)
    {
      zzKt = paramInt;
      if (zzKo != null) {
        zzKo.setRequestedOrientation(zzKt);
      }
      return;
    }
  }
  
  public void setWebViewClient(WebViewClient paramWebViewClient)
  {
    super.setWebViewClient(paramWebViewClient);
    if ((paramWebViewClient instanceof zzja)) {
      zzKn = ((zzja)paramWebViewClient);
    }
  }
  
  public void stopLoading()
  {
    if (isDestroyed()) {
      return;
    }
    try
    {
      super.stopLoading();
      return;
    }
    catch (Exception localException)
    {
      zzb.zzb("Could not stop loading webview.", localException);
    }
  }
  
  public void zzC(boolean paramBoolean)
  {
    synchronized (zzpd)
    {
      zzKr = paramBoolean;
      zzhz();
      return;
    }
  }
  
  public void zzD(boolean paramBoolean)
  {
    synchronized (zzpd)
    {
      if (zzKo != null)
      {
        zzKo.zza(zzKn.zzbY(), paramBoolean);
        return;
      }
      zzKp = paramBoolean;
    }
  }
  
  public void zzE(boolean paramBoolean)
  {
    synchronized (zzpd)
    {
      zzKu = paramBoolean;
      return;
    }
  }
  
  public void zza(Context paramContext, AdSizeParcel paramAdSizeParcel, zzcg paramzzcg)
  {
    synchronized (zzpd)
    {
      zzqR.zzgP();
      setContext(paramContext);
      zzKo = null;
      zzzm = paramAdSizeParcel;
      zzKr = false;
      zzKp = false;
      zzBY = "";
      zzKt = -1;
      zzp.zzbx().zzb(this);
      loadUrl("about:blank");
      zzKn.reset();
      setOnTouchListener(null);
      setOnClickListener(null);
      zzKu = true;
      zzd(paramzzcg);
      return;
    }
  }
  
  public void zza(AdSizeParcel paramAdSizeParcel)
  {
    synchronized (zzpd)
    {
      zzzm = paramAdSizeParcel;
      requestLayout();
      return;
    }
  }
  
  public void zza(zzaz paramzzaz, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (paramzzaz = "1";; paramzzaz = "0")
    {
      localHashMap.put("isVisible", paramzzaz);
      zzb("onAdVisibilityChanged", localHashMap);
      return;
    }
  }
  
  protected void zza(String paramString, ValueCallback<String> paramValueCallback)
  {
    synchronized (zzpd)
    {
      if (!isDestroyed()) {
        evaluateJavascript(paramString, paramValueCallback);
      }
      do
      {
        return;
        zzb.zzaH("The webview is destroyed. Ignoring action.");
      } while (paramValueCallback == null);
      paramValueCallback.onReceiveValue(null);
    }
  }
  
  public void zza(String paramString1, String paramString2)
  {
    zzaM(paramString1 + "(" + paramString2 + ");");
  }
  
  public void zza(String paramString, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    zza(paramString, localJSONObject.toString());
  }
  
  public void zzaI(String paramString)
  {
    synchronized (zzpd)
    {
      try
      {
        super.loadUrl(paramString);
        return;
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          zzb.zzaH("Could not call loadUrl. " + paramString);
        }
      }
    }
  }
  
  public void zzaJ(String paramString)
  {
    Object localObject = zzpd;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    try
    {
      zzBY = str;
      return;
    }
    finally {}
  }
  
  protected void zzaL(String paramString)
  {
    synchronized (zzpd)
    {
      if (!isDestroyed())
      {
        loadUrl(paramString);
        return;
      }
      zzb.zzaH("The webview is destroyed. Ignoring action.");
    }
  }
  
  protected void zzaM(String paramString)
  {
    if (zzmx.zzqB())
    {
      if (zzgs() == null) {
        zzhy();
      }
      if (zzgs().booleanValue())
      {
        zza(paramString, null);
        return;
      }
      zzaL("javascript:" + paramString);
      return;
    }
    zzaL("javascript:" + paramString);
  }
  
  public AdSizeParcel zzaN()
  {
    synchronized (zzpd)
    {
      AdSizeParcel localAdSizeParcel = zzzm;
      return localAdSizeParcel;
    }
  }
  
  public void zzb(com.google.android.gms.ads.internal.overlay.zzd paramzzd)
  {
    synchronized (zzpd)
    {
      zzKo = paramzzd;
      return;
    }
  }
  
  void zzb(Boolean paramBoolean)
  {
    zzHZ = paramBoolean;
    zzp.zzby().zzb(paramBoolean);
  }
  
  public void zzb(String paramString, Map<String, ?> paramMap)
  {
    try
    {
      paramMap = zzp.zzbv().zzz(paramMap);
      zzb(paramString, paramMap);
      return;
    }
    catch (JSONException paramString)
    {
      zzb.zzaH("Could not convert parameters to JSON.");
    }
  }
  
  public void zzb(String paramString, JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject;
    if (paramJSONObject == null) {
      localObject = new JSONObject();
    }
    paramJSONObject = ((JSONObject)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("AFMA_ReceiveMessage('");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("'");
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramJSONObject);
    ((StringBuilder)localObject).append(");");
    zzb.v("Dispatching AFMA event: " + ((StringBuilder)localObject).toString());
    zzaM(((StringBuilder)localObject).toString());
  }
  
  public void zzc(com.google.android.gms.ads.internal.overlay.zzd paramzzd)
  {
    synchronized (zzpd)
    {
      zzKz = paramzzd;
      return;
    }
  }
  
  public void zzeJ()
  {
    if (zzKv != null)
    {
      zzcc.zza(zzKy.zzdm(), zzKx, new String[] { "aes" });
      zzKv = zzcc.zzb(zzKy.zzdm());
      zzKy.zza("native:view_show", zzKx);
    }
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", zzpb.zzJu);
    zzb("onshow", localHashMap);
  }
  
  public void zzgY()
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", zzpb.zzJu);
    zzb("onhide", localHashMap);
  }
  
  public Activity zzgZ()
  {
    return zzKm.zzgZ();
  }
  
  Boolean zzgs()
  {
    synchronized (zzpd)
    {
      Boolean localBoolean = zzHZ;
      return localBoolean;
    }
  }
  
  public Context zzha()
  {
    return zzKm.zzha();
  }
  
  public com.google.android.gms.ads.internal.zzd zzhb()
  {
    return zzow;
  }
  
  public com.google.android.gms.ads.internal.overlay.zzd zzhc()
  {
    synchronized (zzpd)
    {
      com.google.android.gms.ads.internal.overlay.zzd localzzd = zzKo;
      return localzzd;
    }
  }
  
  public com.google.android.gms.ads.internal.overlay.zzd zzhd()
  {
    synchronized (zzpd)
    {
      com.google.android.gms.ads.internal.overlay.zzd localzzd = zzKz;
      return localzzd;
    }
  }
  
  public zzja zzhe()
  {
    return zzKn;
  }
  
  public boolean zzhf()
  {
    return zzKp;
  }
  
  public zzan zzhg()
  {
    return zzwL;
  }
  
  public VersionInfoParcel zzhh()
  {
    return zzpb;
  }
  
  public boolean zzhi()
  {
    synchronized (zzpd)
    {
      boolean bool = zzKr;
      return bool;
    }
  }
  
  public void zzhj()
  {
    synchronized (zzpd)
    {
      zzb.v("Destroying WebView!");
      zzid.zzIE.post(new Runnable()
      {
        public void run()
        {
          zzjd.zza(zzjd.this);
        }
      });
      return;
    }
  }
  
  public boolean zzhk()
  {
    synchronized (zzpd)
    {
      boolean bool = zzKu;
      return bool;
    }
  }
  
  public zziy zzhl()
  {
    return null;
  }
  
  public zzce zzhm()
  {
    return zzKx;
  }
  
  public zzcf zzhn()
  {
    return zzKy;
  }
  
  public void zzho()
  {
    zzqR.zzgO();
  }
  
  public void zzhp()
  {
    if ((zzKx == null) && (!"about:blank".equals(getUrl())))
    {
      zzKx = zzcc.zzb(zzKy.zzdm());
      zzKy.zza("native:view_load", zzKx);
    }
  }
  
  public boolean zzhx()
  {
    if (!zzhe().zzbY()) {
      return false;
    }
    DisplayMetrics localDisplayMetrics = zzp.zzbv().zza(zzri);
    int k = zzl.zzcF().zzb(localDisplayMetrics, widthPixels);
    int m = zzl.zzcF().zzb(localDisplayMetrics, heightPixels);
    Object localObject = zzgZ();
    int j;
    int i;
    if ((localObject == null) || (((Activity)localObject).getWindow() == null))
    {
      j = m;
      i = k;
      label77:
      if ((zzAD == k) && (zzAE == m) && (zzAG == i) && (zzAH == j)) {
        break label224;
      }
      if ((zzAD == k) && (zzAE == m)) {
        break label226;
      }
    }
    label224:
    label226:
    for (boolean bool = true;; bool = false)
    {
      zzAD = k;
      zzAE = m;
      zzAG = i;
      zzAH = j;
      new zzfh(this).zza(k, m, i, j, density, zzri.getDefaultDisplay().getRotation());
      return bool;
      localObject = zzp.zzbv().zzg((Activity)localObject);
      i = zzl.zzcF().zzb(localDisplayMetrics, localObject[0]);
      j = zzl.zzcF().zzb(localDisplayMetrics, localObject[1]);
      break label77;
      break;
    }
  }
  
  public void zzv(int paramInt)
  {
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("closetype", String.valueOf(paramInt));
    localHashMap.put("version", zzpb.zzJu);
    zzb("onhide", localHashMap);
  }
  
  @zzgr
  public static class zza
    extends MutableContextWrapper
  {
    private Activity zzJn;
    private Context zzKC;
    private Context zzqZ;
    
    public zza(Context paramContext)
    {
      super();
      setBaseContext(paramContext);
    }
    
    public Object getSystemService(String paramString)
    {
      return zzKC.getSystemService(paramString);
    }
    
    public void setBaseContext(Context paramContext)
    {
      zzqZ = paramContext.getApplicationContext();
      if ((paramContext instanceof Activity)) {}
      for (Activity localActivity = (Activity)paramContext;; localActivity = null)
      {
        zzJn = localActivity;
        zzKC = paramContext;
        super.setBaseContext(zzqZ);
        return;
      }
    }
    
    public void startActivity(Intent paramIntent)
    {
      if ((zzJn != null) && (!zzmx.isAtLeastL()))
      {
        zzJn.startActivity(paramIntent);
        return;
      }
      paramIntent.setFlags(268435456);
      zzqZ.startActivity(paramIntent);
    }
    
    public Activity zzgZ()
    {
      return zzJn;
    }
    
    public Context zzha()
    {
      return zzKC;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzjd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */