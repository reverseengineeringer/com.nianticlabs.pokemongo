package com.google.android.gms.internal;

import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

public final class zzw$zza
  extends HttpEntityEnclosingRequestBase
{
  public zzw$zza() {}
  
  public zzw$zza(String paramString)
  {
    setURI(URI.create(paramString));
  }
  
  public String getMethod()
  {
    return "PATCH";
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzw.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */