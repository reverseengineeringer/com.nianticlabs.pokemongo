package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.util.Patterns;
import com.google.android.gms.common.internal.zzx;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProxyRequest$Builder
{
  private String zzSL;
  private int zzSM = ProxyRequest.HTTP_METHOD_GET;
  private long zzSN = 3000L;
  private byte[] zzSO = null;
  private Bundle zzSP = new Bundle();
  
  public ProxyRequest$Builder(String paramString)
  {
    zzx.zzcr(paramString);
    if (Patterns.WEB_URL.matcher(paramString).matches())
    {
      zzSL = paramString;
      return;
    }
    throw new IllegalArgumentException("The supplied url [ " + paramString + "] is not match Patterns.WEB_URL!");
  }
  
  public ProxyRequest build()
  {
    if (zzSO == null) {
      zzSO = new byte[0];
    }
    return new ProxyRequest(2, zzSL, zzSM, zzSN, zzSO, zzSP);
  }
  
  public Builder putHeader(String paramString1, String paramString2)
  {
    zzx.zzh(paramString1, "Header name cannot be null or empty!");
    Bundle localBundle = zzSP;
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    localBundle.putString(paramString1, str);
    return this;
  }
  
  public Builder setBody(byte[] paramArrayOfByte)
  {
    zzSO = paramArrayOfByte;
    return this;
  }
  
  public Builder setHttpMethod(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= ProxyRequest.LAST_CODE)) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "Unrecognized http method code.");
      zzSM = paramInt;
      return this;
    }
  }
  
  public Builder setTimeoutMillis(long paramLong)
  {
    if (paramLong >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "The specified timeout must be non-negative.");
      zzSN = paramLong;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.proxy.ProxyRequest.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */