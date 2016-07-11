package crittercism.android;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bj
  extends ci
{
  private String a = cg.a.a();
  private String b = ed.a.a();
  private a c;
  private String d;
  
  public bj(a parama, String paramString)
  {
    c = parama;
    d = paramString;
  }
  
  public final JSONArray a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", Integer.valueOf(c.ordinal()));
    localHashMap.put("viewName", d);
    return new JSONArray().put(b).put(5).put(new JSONObject(localHashMap));
  }
  
  public final String e()
  {
    return a;
  }
  
  public static enum a {}
}

/* Location:
 * Qualified Name:     crittercism.android.bj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */