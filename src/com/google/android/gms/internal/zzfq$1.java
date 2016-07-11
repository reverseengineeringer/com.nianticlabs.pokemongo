package com.google.android.gms.internal;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Set;

class zzfq$1
  implements Runnable
{
  zzfq$1(zzfq paramzzfq, String paramString1, String paramString2) {}
  
  public void run()
  {
    final WebView localWebView = zzCu.zzfh();
    localWebView.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        zzb.zzaF("Loading assets have finished");
        zzCu.zzCr.remove(localWebView);
      }
      
      public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        zzb.zzaH("Loading assets have failed.");
        zzCu.zzCr.remove(localWebView);
      }
    });
    zzCu.zzCr.add(localWebView);
    localWebView.loadDataWithBaseURL(zzCs, zzCt, "text/html", "UTF-8", null);
    zzb.zzaF("Fetching assets finished.");
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfq.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */