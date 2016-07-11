package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;
import org.json.JSONObject;

@zzgr
public abstract interface zziz
  extends zzaw
{
  public abstract void clearCache(boolean paramBoolean);
  
  public abstract void destroy();
  
  public abstract Context getContext();
  
  public abstract ViewGroup.LayoutParams getLayoutParams();
  
  public abstract void getLocationOnScreen(int[] paramArrayOfInt);
  
  public abstract int getMeasuredHeight();
  
  public abstract int getMeasuredWidth();
  
  public abstract ViewParent getParent();
  
  public abstract String getRequestId();
  
  public abstract int getRequestedOrientation();
  
  public abstract View getView();
  
  public abstract WebView getWebView();
  
  public abstract boolean isDestroyed();
  
  public abstract void loadData(String paramString1, String paramString2, String paramString3);
  
  public abstract void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract void loadUrl(String paramString);
  
  public abstract void measure(int paramInt1, int paramInt2);
  
  public abstract void setBackgroundColor(int paramInt);
  
  public abstract void setContext(Context paramContext);
  
  public abstract void setOnClickListener(View.OnClickListener paramOnClickListener);
  
  public abstract void setOnTouchListener(View.OnTouchListener paramOnTouchListener);
  
  public abstract void setRequestedOrientation(int paramInt);
  
  public abstract void setWebChromeClient(WebChromeClient paramWebChromeClient);
  
  public abstract void setWebViewClient(WebViewClient paramWebViewClient);
  
  public abstract void stopLoading();
  
  public abstract void zzC(boolean paramBoolean);
  
  public abstract void zzD(boolean paramBoolean);
  
  public abstract void zzE(boolean paramBoolean);
  
  public abstract void zza(Context paramContext, AdSizeParcel paramAdSizeParcel, zzcg paramzzcg);
  
  public abstract void zza(AdSizeParcel paramAdSizeParcel);
  
  public abstract void zza(String paramString1, String paramString2);
  
  public abstract void zza(String paramString, JSONObject paramJSONObject);
  
  public abstract void zzaI(String paramString);
  
  public abstract void zzaJ(String paramString);
  
  public abstract AdSizeParcel zzaN();
  
  public abstract void zzb(com.google.android.gms.ads.internal.overlay.zzd paramzzd);
  
  public abstract void zzb(String paramString, Map<String, ?> paramMap);
  
  public abstract void zzb(String paramString, JSONObject paramJSONObject);
  
  public abstract void zzc(com.google.android.gms.ads.internal.overlay.zzd paramzzd);
  
  public abstract void zzeJ();
  
  public abstract void zzgY();
  
  public abstract Activity zzgZ();
  
  public abstract Context zzha();
  
  public abstract com.google.android.gms.ads.internal.zzd zzhb();
  
  public abstract com.google.android.gms.ads.internal.overlay.zzd zzhc();
  
  public abstract com.google.android.gms.ads.internal.overlay.zzd zzhd();
  
  public abstract zzja zzhe();
  
  public abstract boolean zzhf();
  
  public abstract zzan zzhg();
  
  public abstract VersionInfoParcel zzhh();
  
  public abstract boolean zzhi();
  
  public abstract void zzhj();
  
  public abstract boolean zzhk();
  
  public abstract zziy zzhl();
  
  public abstract zzce zzhm();
  
  public abstract zzcf zzhn();
  
  public abstract void zzho();
  
  public abstract void zzhp();
  
  public abstract void zzv(int paramInt);
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zziz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */