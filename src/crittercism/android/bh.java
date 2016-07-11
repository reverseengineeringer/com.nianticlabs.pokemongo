package crittercism.android;

import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONException;
import org.json.JSONObject;

public final class bh
{
  public boolean a = false;
  public int b = 10;
  public int c = 3600000;
  public JSONObject d = new JSONObject();
  
  bh() {}
  
  public bh(JSONObject paramJSONObject)
  {
    a = paramJSONObject.optBoolean("enabled", false);
    b = paramJSONObject.optInt("interval", 10);
    c = paramJSONObject.optInt("defaultTimeout", 3600000);
    d = paramJSONObject.optJSONObject("transactions");
    if (d == null) {
      d = new JSONObject();
    }
  }
  
  public static bh a(Context paramContext)
  {
    Object localObject = paramContext.getSharedPreferences("com.crittercism.txn.config", 0);
    paramContext = new bh();
    a = ((SharedPreferences)localObject).getBoolean("enabled", false);
    b = ((SharedPreferences)localObject).getInt("interval", 10);
    c = ((SharedPreferences)localObject).getInt("defaultTimeout", 3600000);
    localObject = ((SharedPreferences)localObject).getString("transactions", null);
    d = new JSONObject();
    if (localObject != null) {}
    try
    {
      d = new JSONObject((String)localObject);
      return paramContext;
    }
    catch (JSONException localJSONException) {}
    return paramContext;
  }
  
  public final long a(String paramString)
  {
    paramString = d.optJSONObject(paramString);
    if (paramString != null) {
      return paramString.optLong("timeout", c);
    }
    return c;
  }
}

/* Location:
 * Qualified Name:     crittercism.android.bh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */