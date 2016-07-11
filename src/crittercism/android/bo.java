package crittercism.android;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public final class bo
{
  public JSONArray a = new JSONArray();
  
  public bo(bs parambs)
  {
    parambs = parambs.c().iterator();
    while (parambs.hasNext())
    {
      Object localObject = ((bq)parambs.next()).a();
      if (localObject != null) {
        a.put(localObject);
      }
    }
  }
}

/* Location:
 * Qualified Name:     crittercism.android.bo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */