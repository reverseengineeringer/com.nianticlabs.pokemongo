package crittercism.android;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class bu
  implements bv
{
  private Map a = new HashMap();
  
  public final bu a(bw parambw)
  {
    if (parambw.b() != null) {
      a.put(parambw.a(), parambw.b());
    }
    return this;
  }
  
  public final JSONObject a()
  {
    return new JSONObject(a);
  }
}

/* Location:
 * Qualified Name:     crittercism.android.bu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */