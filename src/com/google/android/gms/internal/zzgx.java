package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@zzgr
class zzgx
{
  private final String zzBY;
  private int zzDv;
  private String zzF;
  private final List<String> zzGl;
  private final List<String> zzGm;
  private final String zzGn;
  private final String zzGo;
  private final String zzGp;
  private final String zzGq;
  private final boolean zzGr;
  
  public zzgx(int paramInt, Map<String, String> paramMap)
  {
    zzF = ((String)paramMap.get("url"));
    zzGo = ((String)paramMap.get("base_uri"));
    zzGp = ((String)paramMap.get("post_parameters"));
    zzGr = parseBoolean((String)paramMap.get("drt_include"));
    zzGn = ((String)paramMap.get("activation_overlay_url"));
    zzGm = zzat((String)paramMap.get("check_packages"));
    zzBY = ((String)paramMap.get("request_id"));
    zzGq = ((String)paramMap.get("type"));
    zzGl = zzat((String)paramMap.get("errors"));
    zzDv = paramInt;
  }
  
  private static boolean parseBoolean(String paramString)
  {
    return (paramString != null) && ((paramString.equals("1")) || (paramString.equals("true")));
  }
  
  private List<String> zzat(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Arrays.asList(paramString.split(","));
  }
  
  public int getErrorCode()
  {
    return zzDv;
  }
  
  public String getRequestId()
  {
    return zzBY;
  }
  
  public String getType()
  {
    return zzGq;
  }
  
  public String getUrl()
  {
    return zzF;
  }
  
  public void setUrl(String paramString)
  {
    zzF = paramString;
  }
  
  public List<String> zzfU()
  {
    return zzGl;
  }
  
  public String zzfV()
  {
    return zzGp;
  }
  
  public boolean zzfW()
  {
    return zzGr;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */