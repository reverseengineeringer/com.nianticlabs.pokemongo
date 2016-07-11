package crittercism.android;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class cs
  implements cw
{
  private Map a = new HashMap();
  
  private JSONArray a()
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      JSONObject localJSONObject = new JSONObject((Map)((Map.Entry)localObject).getKey());
      localObject = (a)((Map.Entry)localObject).getValue();
      try
      {
        localJSONArray.put(new JSONObject().put("appLoads", localJSONObject).put("count", b).put("current", a));
      }
      catch (JSONException localJSONException) {}
    }
    return localJSONArray;
  }
  
  public final void a(OutputStream paramOutputStream)
  {
    paramOutputStream.write(a().toString().getBytes("UTF8"));
  }
  
  public final String toString()
  {
    try
    {
      String str = a().toString(4);
      return str;
    }
    catch (JSONException localJSONException)
    {
      dx.a();
    }
    return null;
  }
  
  static final class a
  {
    boolean a = false;
    int b = 0;
    
    public a()
    {
      this((byte)0);
    }
    
    private a(byte paramByte) {}
  }
  
  public static final class b
    implements cx
  {}
}

/* Location:
 * Qualified Name:     crittercism.android.cs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */