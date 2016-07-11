package com.crittercism.app;

import android.os.Build.VERSION;
import crittercism.android.dx;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public class CrittercismConfig
{
  public static final String API_VERSION = "5.0.8";
  protected String a = "com.crittercism/dumps";
  private String b = null;
  private boolean c = false;
  private boolean d = false;
  private boolean e = true;
  private boolean f = false;
  private boolean g = b();
  private String h = "Developer Reply";
  private String i = null;
  private List j = new LinkedList();
  private List k = new LinkedList();
  
  public CrittercismConfig() {}
  
  public CrittercismConfig(CrittercismConfig paramCrittercismConfig)
  {
    b = b;
    c = c;
    d = d;
    e = e;
    f = f;
    g = g;
    a = a;
    h = h;
    setURLBlacklistPatterns(j);
    setPreserveQueryStringPatterns(k);
    i = i;
  }
  
  @Deprecated
  public CrittercismConfig(JSONObject paramJSONObject)
  {
    b = a(paramJSONObject, "customVersionName", b);
    d = a(paramJSONObject, "includeVersionCode", d);
    e = a(paramJSONObject, "installNdk", e);
    c = a(paramJSONObject, "delaySendingAppLoad", c);
    f = a(paramJSONObject, "shouldCollectLogcat", f);
    a = a(paramJSONObject, "nativeDumpPath", a);
    h = a(paramJSONObject, "notificationTitle", h);
    g = a(paramJSONObject, "installApm", g);
  }
  
  private static int a(String paramString)
  {
    int m = 0;
    if (paramString != null) {
      m = paramString.hashCode();
    }
    return m;
  }
  
  private static String a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramJSONObject.has(paramString1)) {}
    try
    {
      str = paramJSONObject.getString(paramString1);
      return str;
    }
    catch (Exception paramJSONObject) {}
    return paramString2;
  }
  
  protected static boolean a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2 == null;
    }
    return paramString1.equals(paramString2);
  }
  
  private static boolean a(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramJSONObject.has(paramString)) {}
    try
    {
      bool = paramJSONObject.getBoolean(paramString);
      return bool;
    }
    catch (Exception paramJSONObject) {}
    return paramBoolean;
  }
  
  private static final boolean b()
  {
    return (Build.VERSION.SDK_INT >= 10) && (Build.VERSION.SDK_INT <= 21);
  }
  
  public List a()
  {
    return getURLBlacklistPatterns();
  }
  
  public final boolean delaySendingAppLoad()
  {
    return c;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof CrittercismConfig)) {}
    do
    {
      return false;
      paramObject = (CrittercismConfig)paramObject;
    } while ((c != c) || (f != f) || (isNdkCrashReportingEnabled() != ((CrittercismConfig)paramObject).isNdkCrashReportingEnabled()) || (isOptmzEnabled() != ((CrittercismConfig)paramObject).isOptmzEnabled()) || (isVersionCodeToBeIncludedInVersionString() != ((CrittercismConfig)paramObject).isVersionCodeToBeIncludedInVersionString()) || (!a(b, b)) || (!a(h, h)) || (!a(a, a)) || (!j.equals(j)) || (!k.equals(k)) || (!a(i, i)));
    return true;
  }
  
  public final String getCustomVersionName()
  {
    return b;
  }
  
  public List getPreserveQueryStringPatterns()
  {
    return new LinkedList(k);
  }
  
  public final String getRateMyAppTestTarget()
  {
    return i;
  }
  
  public List getURLBlacklistPatterns()
  {
    return new LinkedList(j);
  }
  
  public int hashCode()
  {
    int i3 = 1;
    int i4 = a(b);
    int i5 = a(h);
    int i6 = a(a);
    int i7 = a(i);
    int i8 = j.hashCode();
    int i9 = k.hashCode();
    int m;
    int n;
    label79:
    int i1;
    label88:
    int i2;
    if (c)
    {
      m = 1;
      if (!f) {
        break label176;
      }
      n = 1;
      if (!isNdkCrashReportingEnabled()) {
        break label181;
      }
      i1 = 1;
      if (!isOptmzEnabled()) {
        break label186;
      }
      i2 = 1;
      label98:
      if (!isVersionCodeToBeIncludedInVersionString()) {
        break label192;
      }
    }
    for (;;)
    {
      return Integer.valueOf((i2 + (i1 + (n + (m + 0 << 1) << 1) << 1) << 1) + i3).hashCode() + (i9 + (((((i4 + 0) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31) * 31;
      m = 0;
      break;
      label176:
      n = 0;
      break label79;
      label181:
      i1 = 0;
      break label88;
      label186:
      i2 = 0;
      break label98;
      label192:
      i3 = 0;
    }
  }
  
  public final boolean isLogcatReportingEnabled()
  {
    return f;
  }
  
  public final boolean isNdkCrashReportingEnabled()
  {
    return e;
  }
  
  @Deprecated
  public final boolean isOptmzEnabled()
  {
    return g;
  }
  
  public final boolean isServiceMonitoringEnabled()
  {
    return isOptmzEnabled();
  }
  
  public final boolean isVersionCodeToBeIncludedInVersionString()
  {
    return d;
  }
  
  public final void setCustomVersionName(String paramString)
  {
    b = paramString;
  }
  
  public final void setDelaySendingAppLoad(boolean paramBoolean)
  {
    c = paramBoolean;
  }
  
  public final void setLogcatReportingEnabled(boolean paramBoolean)
  {
    f = paramBoolean;
  }
  
  public final void setNdkCrashReportingEnabled(boolean paramBoolean)
  {
    e = paramBoolean;
  }
  
  @Deprecated
  public final void setOptmzEnabled(boolean paramBoolean)
  {
    if ((!b()) && (paramBoolean))
    {
      dx.a("OPTMZ is currently only allowed for api levels 10 to 21.  APM will not be installed");
      return;
    }
    g = paramBoolean;
  }
  
  public void setPreserveQueryStringPatterns(List paramList)
  {
    k.clear();
    if (paramList != null) {
      k.addAll(paramList);
    }
  }
  
  public final void setRateMyAppTestTarget(String paramString)
  {
    i = paramString;
  }
  
  public final void setServiceMonitoringEnabled(boolean paramBoolean)
  {
    setOptmzEnabled(paramBoolean);
  }
  
  public void setURLBlacklistPatterns(List paramList)
  {
    j.clear();
    if (paramList != null) {
      j.addAll(paramList);
    }
  }
  
  public final void setVersionCodeToBeIncludedInVersionString(boolean paramBoolean)
  {
    d = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     com.crittercism.app.CrittercismConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */