package crittercism.android;

import org.json.JSONException;
import org.json.JSONObject;

public final class ds$a
{
  public static ds a(ax paramax)
  {
    Object localObject1 = null;
    Object localObject2 = paramax.a(cq.i.a(), cq.i.b());
    if (localObject2 != null) {}
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException)
      {
        dx.b();
        continue;
        boolean bool = paramax.c(cq.l.a(), cq.l.b());
        continue;
        bool = false;
        continue;
      }
      if (localObject1 != null)
      {
        bool = ((JSONObject)localObject1).optBoolean("optOutStatusSet", false);
        if (bool)
        {
          bool = ((JSONObject)localObject1).optBoolean("optOutStatus", false);
          return new ds(bool);
        }
      }
      localObject1 = null;
    }
  }
}

/* Location:
 * Qualified Name:     crittercism.android.ds.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */