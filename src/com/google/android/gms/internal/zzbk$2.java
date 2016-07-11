package com.google.android.gms.internal;

import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;

class zzbk$2
  implements Runnable
{
  ValueCallback<String> zzsi = new ValueCallback()
  {
    public void zzy(String paramAnonymousString)
    {
      zzsh.zza(zzsj, zzsk, paramAnonymousString);
    }
  };
  
  zzbk$2(zzbk paramzzbk, zzbh paramzzbh, WebView paramWebView) {}
  
  public void run()
  {
    if (zzsk.getSettings().getJavaScriptEnabled()) {}
    try
    {
      zzsk.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", zzsi);
      return;
    }
    catch (Throwable localThrowable)
    {
      zzsi.onReceiveValue("");
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbk.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */