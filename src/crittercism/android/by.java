package crittercism.android;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class by
  extends ci
{
  private String a = cg.a.a();
  private String b = ed.a.a();
  private String c;
  private String d;
  
  public by(String paramString1, String paramString2)
  {
    c = paramString1;
    d = paramString2;
  }
  
  public final JSONArray a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("name", c);
    localHashMap.put("reason", d);
    return new JSONArray().put(b).put(6).put(new JSONObject(localHashMap));
  }
  
  public final String e()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     crittercism.android.by
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */