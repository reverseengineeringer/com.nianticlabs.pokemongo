package crittercism.android;

import java.util.HashMap;
import java.util.Map;

public final class bn
{
  private static final Map a;
  private String b;
  private String c;
  private String d;
  private String e;
  
  static
  {
    HashMap localHashMap = new HashMap();
    a = localHashMap;
    localHashMap.put("00555300", "crittercism.com");
    a.put("00555304", "crit-ci.com");
    a.put("00555305", "crit-staging.com");
    a.put("00444503", "eu.crittercism.com");
  }
  
  public bn(String paramString)
  {
    if (paramString == null) {
      throw new a("Given null appId");
    }
    if (!paramString.matches("[0-9a-fA-F]+")) {
      throw new a("Invalid appId: '" + paramString + "'. AppId must be hexadecimal characters");
    }
    if ((paramString.length() != 24) && (paramString.length() != 40)) {
      throw new a("Invalid appId: '" + paramString + "'. AppId must be either 24 or 40 characters");
    }
    String str = null;
    if (paramString.length() == 24) {
      str = "00555300";
    }
    for (;;)
    {
      str = (String)a.get(str);
      if (str != null) {
        break;
      }
      throw new a("Invalid appId: '" + paramString + "'. Invalid app locator code");
      if (paramString.length() == 40) {
        str = paramString.substring(paramString.length() - 8);
      }
    }
    b = System.getProperty("com.crittercism.apmUrl", "https://apm." + str);
    c = System.getProperty("com.crittercism.apiUrl", "https://api." + str);
    d = System.getProperty("com.crittercism.txnUrl", "https://txn.ingest." + str);
    e = System.getProperty("com.crittercism.appLoadUrl", "https://appload.ingest." + str);
  }
  
  public final String a()
  {
    return c;
  }
  
  public final String b()
  {
    return b;
  }
  
  public final String c()
  {
    return e;
  }
  
  public final String d()
  {
    return d;
  }
  
  public static final class a
    extends Exception
  {
    public a(String paramString)
    {
      super();
    }
  }
}

/* Location:
 * Qualified Name:     crittercism.android.bn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */