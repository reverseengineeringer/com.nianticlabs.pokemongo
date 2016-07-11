package com.google.android.gms.internal;

import android.net.http.SslError;
import android.webkit.WebChromeClient;

public class zzie$zzc
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

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzie.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */