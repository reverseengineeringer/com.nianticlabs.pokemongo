package crittercism.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class dv
{
  private SharedPreferences a;
  
  public dv(Context paramContext, String paramString)
  {
    a = paramContext.getSharedPreferences("com.crittercism." + paramString + ".usermetadata", 0);
    if (!a.contains("data")) {
      paramContext = new JSONObject();
    }
    try
    {
      paramContext.putOpt("username", "anonymous");
      a(paramContext);
      return;
    }
    catch (JSONException paramContext) {}
  }
  
  private void b(JSONObject paramJSONObject)
  {
    SharedPreferences.Editor localEditor = a.edit();
    localEditor.putString("data", paramJSONObject.toString());
    localEditor.commit();
  }
  
  public final JSONObject a()
  {
    Object localObject = a.getString("data", "{}");
    try
    {
      localObject = new JSONObject((String)localObject);
      return (JSONObject)localObject;
    }
    catch (JSONException localJSONException) {}
    return new JSONObject();
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = a();
    if (localJSONObject.length() == 0)
    {
      if (paramJSONObject.length() > 0)
      {
        b(paramJSONObject);
        a(true);
      }
      return;
    }
    Iterator localIterator = paramJSONObject.keys();
    int j = 0;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        Object localObject1 = paramJSONObject.opt(str1);
        Object localObject2 = localJSONObject.opt(str1);
        int i;
        if (localObject2 == null)
        {
          i = 1;
          label86:
          if (localObject2 != null)
          {
            if ((!(localObject1 instanceof JSONObject)) && (!(localObject1 instanceof JSONArray))) {
              break label158;
            }
            String str2 = localObject1.toString();
            if (localObject2.toString().equals(str2)) {
              break label153;
            }
            i = 1;
          }
        }
        for (;;)
        {
          if (i == 0) {
            break label176;
          }
          try
          {
            localJSONObject.put(str1, localObject1);
            j = 1;
          }
          catch (JSONException localJSONException) {}
          i = 0;
          break label86;
          label153:
          i = 0;
          continue;
          label158:
          if (!localObject2.equals(localObject1)) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
      else
      {
        label176:
        if (j == 0) {
          break;
        }
        b(localJSONObject);
        a(true);
        return;
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    a.edit().putBoolean("dirty", paramBoolean).commit();
  }
  
  public final boolean b()
  {
    return a.getBoolean("dirty", false);
  }
}

/* Location:
 * Qualified Name:     crittercism.android.dv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */