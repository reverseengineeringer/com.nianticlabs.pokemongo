package crittercism.android;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ce
  extends ci
{
  private String a;
  private String b;
  private a c;
  private String d;
  private String e;
  private String f;
  
  public ce(a parama)
  {
    if (parama != a.a) {
      a locala = a.b;
    }
    a = cg.a.a();
    b = ed.a.a();
    c = parama;
  }
  
  public ce(a parama, String paramString)
  {
    if (parama != a.c) {
      a locala = a.d;
    }
    a = cg.a.a();
    b = ed.a.a();
    c = parama;
    d = paramString;
  }
  
  public ce(a parama, String paramString1, String paramString2)
  {
    a locala = a.e;
    a = cg.a.a();
    b = ed.a.a();
    c = parama;
    e = paramString1;
    f = paramString2;
  }
  
  public final JSONArray a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("change", Integer.valueOf(c.ordinal()));
    if ((c == a.c) || (c == a.d)) {
      localHashMap.put("type", d);
    }
    for (;;)
    {
      return new JSONArray().put(b).put(4).put(new JSONObject(localHashMap));
      if (c == a.e)
      {
        localHashMap.put("oldType", e);
        localHashMap.put("newType", f);
      }
    }
  }
  
  public final String e()
  {
    return a;
  }
  
  public static enum a {}
}

/* Location:
 * Qualified Name:     crittercism.android.ce
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */