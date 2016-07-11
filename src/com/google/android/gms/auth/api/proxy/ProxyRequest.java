package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Patterns;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProxyRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<ProxyRequest> CREATOR = new zzb();
  public static final int HTTP_METHOD_DELETE;
  public static final int HTTP_METHOD_GET = 0;
  public static final int HTTP_METHOD_HEAD;
  public static final int HTTP_METHOD_OPTIONS;
  public static final int HTTP_METHOD_PATCH = 7;
  public static final int HTTP_METHOD_POST = 1;
  public static final int HTTP_METHOD_PUT = 2;
  public static final int HTTP_METHOD_TRACE;
  public static final int LAST_CODE = 7;
  public static final int VERSION_CODE = 2;
  public final byte[] body;
  public final int httpMethod;
  public final long timeoutMillis;
  public final String url;
  final int versionCode;
  Bundle zzSK;
  
  static
  {
    HTTP_METHOD_DELETE = 3;
    HTTP_METHOD_HEAD = 4;
    HTTP_METHOD_OPTIONS = 5;
    HTTP_METHOD_TRACE = 6;
  }
  
  ProxyRequest(int paramInt1, String paramString, int paramInt2, long paramLong, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    versionCode = paramInt1;
    url = paramString;
    httpMethod = paramInt2;
    timeoutMillis = paramLong;
    body = paramArrayOfByte;
    zzSK = paramBundle;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Map<String, String> getHeaderMap()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(zzSK.size());
    Iterator localIterator = zzSK.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localLinkedHashMap.put(str, zzSK.getString(str));
    }
    return Collections.unmodifiableMap(localLinkedHashMap);
  }
  
  public String toString()
  {
    return "ProxyRequest[ url: " + url + ", method: " + httpMethod + " ]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private String zzSL;
    private int zzSM = ProxyRequest.HTTP_METHOD_GET;
    private long zzSN = 3000L;
    private byte[] zzSO = null;
    private Bundle zzSP = new Bundle();
    
    public Builder(String paramString)
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.proxy.ProxyRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */