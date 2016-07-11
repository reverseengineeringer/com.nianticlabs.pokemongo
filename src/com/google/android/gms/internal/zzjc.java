package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;
import org.json.JSONObject;

@zzgr
class zzjc
  extends FrameLayout
  implements zziz
{
  private final zziz zzKk;
  private final zziy zzKl;
  
  public zzjc(zziz paramzziz)
  {
    super(paramzziz.zzha());
    zzKk = paramzziz;
    zzKl = new zziy(paramzziz.zzha(), this, this);
    paramzziz = zzKk.zzhe();
    if (paramzziz != null) {
      paramzziz.zze(this);
    }
    addView(zzKk.getView());
  }
  
  public void clearCache(boolean paramBoolean)
  {
    zzKk.clearCache(paramBoolean);
  }
  
  public void destroy()
  {
    zzKk.destroy();
  }
  
  public String getRequestId()
  {
    return zzKk.getRequestId();
  }
  
  public int getRequestedOrientation()
  {
    return zzKk.getRequestedOrientation();
  }
  
  public View getView()
  {
    return this;
  }
  
  public WebView getWebView()
  {
    return zzKk.getWebView();
  }
  
  public boolean isDestroyed()
  {
    return zzKk.isDestroyed();
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    zzKk.loadData(paramString1, paramString2, paramString3);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    zzKk.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadUrl(String paramString)
  {
    zzKk.loadUrl(paramString);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    zzKk.setBackgroundColor(paramInt);
  }
  
  public void setContext(Context paramContext)
  {
    zzKk.setContext(paramContext);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    zzKk.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    zzKk.setOnTouchListener(paramOnTouchListener);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    zzKk.setRequestedOrientation(paramInt);
  }
  
  public void setWebChromeClient(WebChromeClient paramWebChromeClient)
  {
    zzKk.setWebChromeClient(paramWebChromeClient);
  }
  
  public void setWebViewClient(WebViewClient paramWebViewClient)
  {
    zzKk.setWebViewClient(paramWebViewClient);
  }
  
  public void stopLoading()
  {
    zzKk.stopLoading();
  }
  
  public void zzC(boolean paramBoolean)
  {
    zzKk.zzC(paramBoolean);
  }
  
  public void zzD(boolean paramBoolean)
  {
    zzKk.zzD(paramBoolean);
  }
  
  public void zzE(boolean paramBoolean)
  {
    zzKk.zzE(paramBoolean);
  }
  
  public void zza(Context paramContext, AdSizeParcel paramAdSizeParcel, zzcg paramzzcg)
  {
    zzKk.zza(paramContext, paramAdSizeParcel, paramzzcg);
  }
  
  public void zza(AdSizeParcel paramAdSizeParcel)
  {
    zzKk.zza(paramAdSizeParcel);
  }
  
  public void zza(zzaz paramzzaz, boolean paramBoolean)
  {
    zzKk.zza(paramzzaz, paramBoolean);
  }
  
  public void zza(String paramString1, String paramString2)
  {
    zzKk.zza(paramString1, paramString2);
  }
  
  public void zza(String paramString, JSONObject paramJSONObject)
  {
    zzKk.zza(paramString, paramJSONObject);
  }
  
  public void zzaI(String paramString)
  {
    zzKk.zzaI(paramString);
  }
  
  public void zzaJ(String paramString)
  {
    zzKk.zzaJ(paramString);
  }
  
  public AdSizeParcel zzaN()
  {
    return zzKk.zzaN();
  }
  
  public void zzb(com.google.android.gms.ads.internal.overlay.zzd paramzzd)
  {
    zzKk.zzb(paramzzd);
  }
  
  public void zzb(String paramString, Map<String, ?> paramMap)
  {
    zzKk.zzb(paramString, paramMap);
  }
  
  public void zzb(String paramString, JSONObject paramJSONObject)
  {
    zzKk.zzb(paramString, paramJSONObject);
  }
  
  public void zzc(com.google.android.gms.ads.internal.overlay.zzd paramzzd)
  {
    zzKk.zzc(paramzzd);
  }
  
  public void zzeJ()
  {
    zzKk.zzeJ();
  }
  
  public void zzgY()
  {
    zzKk.zzgY();
  }
  
  public Activity zzgZ()
  {
    return zzKk.zzgZ();
  }
  
  public Context zzha()
  {
    return zzKk.zzha();
  }
  
  public com.google.android.gms.ads.internal.zzd zzhb()
  {
    return zzKk.zzhb();
  }
  
  public com.google.android.gms.ads.internal.overlay.zzd zzhc()
  {
    return zzKk.zzhc();
  }
  
  public com.google.android.gms.ads.internal.overlay.zzd zzhd()
  {
    return zzKk.zzhd();
  }
  
  public zzja zzhe()
  {
    return zzKk.zzhe();
  }
  
  public boolean zzhf()
  {
    return zzKk.zzhf();
  }
  
  public zzan zzhg()
  {
    return zzKk.zzhg();
  }
  
  public VersionInfoParcel zzhh()
  {
    return zzKk.zzhh();
  }
  
  public boolean zzhi()
  {
    return zzKk.zzhi();
  }
  
  public void zzhj()
  {
    zzKl.onDestroy();
    zzKk.zzhj();
  }
  
  public boolean zzhk()
  {
    return zzKk.zzhk();
  }
  
  public zziy zzhl()
  {
    return zzKl;
  }
  
  public zzce zzhm()
  {
    return zzKk.zzhm();
  }
  
  public zzcf zzhn()
  {
    return zzKk.zzhn();
  }
  
  public void zzho()
  {
    zzKk.zzho();
  }
  
  public void zzhp()
  {
    zzKk.zzhp();
  }
  
  public void zzv(int paramInt)
  {
    zzKk.zzv(paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzjc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */