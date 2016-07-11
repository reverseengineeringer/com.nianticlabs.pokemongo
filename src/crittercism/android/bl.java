package crittercism.android;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bl
  extends ci
{
  private String a = cg.a.a();
  private String b = ed.a.a();
  private a c;
  
  public bl(a parama)
  {
    c = parama;
  }
  
  public final JSONArray a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", c.a());
    return new JSONArray().put(b).put(3).put(new JSONObject(localHashMap));
  }
  
  public final String e()
  {
    return a;
  }
  
  public static enum a
  {
    private String c;
    
    private a(String paramString1)
    {
      c = paramString1;
    }
    
    public final String a()
    {
      return c;
    }
  }
}

/* Location:
 * Qualified Name:     crittercism.android.bl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */