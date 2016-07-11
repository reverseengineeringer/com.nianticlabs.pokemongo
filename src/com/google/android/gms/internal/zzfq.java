package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzgr
public class zzfq
  implements zzfo
{
  private final Context mContext;
  final Set<WebView> zzCr = Collections.synchronizedSet(new HashSet());
  
  public zzfq(Context paramContext)
  {
    mContext = paramContext;
  }
  
  public void zza(String paramString1, final String paramString2, final String paramString3)
  {
    zzb.zzaF("Fetching assets for the given html");
    zzid.zzIE.post(new Runnable()
    {
      public void run()
      {
        final WebView localWebView = zzfh();
        localWebView.setWebViewClient(new WebViewClient()
        {
          public void onPageFinished(WebView paramAnonymous2WebView, String paramAnonymous2String)
          {
            zzb.zzaF("Loading assets have finished");
            zzCr.remove(localWebView);
          }
          
          public void onReceivedError(WebView paramAnonymous2WebView, int paramAnonymous2Int, String paramAnonymous2String1, String paramAnonymous2String2)
          {
            zzb.zzaH("Loading assets have failed.");
            zzCr.remove(localWebView);
          }
        });
        zzCr.add(localWebView);
        localWebView.loadDataWithBaseURL(paramString2, paramString3, "text/html", "UTF-8", null);
        zzb.zzaF("Fetching assets finished.");
      }
    });
  }
  
  public WebView zzfh()
  {
    WebView localWebView = new WebView(mContext);
    localWebView.getSettings().setJavaScriptEnabled(true);
    return localWebView;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */