package crittercism.android;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  JSONObject a = new JSONObject();
  
  private a(au paramau, List paramList)
  {
    paramList.size();
    JSONArray localJSONArray1 = new JSONArray();
    JSONArray localJSONArray2 = new JSONArray();
    localJSONArray2.put(paramau.a());
    localJSONArray2.put(paramau.b());
    localJSONArray2.put(paramau.c());
    localJSONArray2.put("5.0.8");
    localJSONArray2.put(paramau.e());
    localJSONArray1.put(localJSONArray2);
    localJSONArray2 = new JSONArray();
    localJSONArray2.put(ed.a.a());
    localJSONArray2.put(paramau.f());
    localJSONArray2.put(paramau.j());
    localJSONArray2.put(paramau.i());
    localJSONArray2.put(paramau.k());
    localJSONArray2.put(paramau.g());
    localJSONArray2.put(paramau.h());
    localJSONArray1.put(localJSONArray2);
    paramau = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramau.put(((c)paramList.next()).d());
    }
    localJSONArray1.put(paramau);
    a.put("d", localJSONArray1);
  }
  
  public static a a(au paramau, List paramList)
  {
    try
    {
      paramau = new a(paramau, paramList);
      return paramau;
    }
    catch (JSONException paramau)
    {
      dx.b("Unable to generate APM request's JSON: " + paramau);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     crittercism.android.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */