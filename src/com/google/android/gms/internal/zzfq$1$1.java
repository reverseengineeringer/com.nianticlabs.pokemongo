package com.google.android.gms.internal;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Set;

class zzfq$1$1
  extends WebViewClient
{
  zzfq$1$1(zzfq.1 param1, WebView paramWebView) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    zzb.zzaF("Loading assets have finished");
    zzCv.zzCu.zzCr.remove(zzsk);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    zzb.zzaH("Loading assets have failed.");
    zzCv.zzCu.zzCr.remove(zzsk);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfq.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */