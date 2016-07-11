package crittercism.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import org.json.JSONException;
import org.json.JSONObject;

class bx$g
  implements bw
{
  private JSONObject a = null;
  
  public bx$g(int paramInt)
  {
    bx.b();
    bx.c();
    a = a(paramInt);
  }
  
  private static JSONObject a(int paramInt)
  {
    int j = 1;
    int i = 1;
    Object localObject1;
    if (!cc)
    {
      localObject1 = null;
      return (JSONObject)localObject1;
    }
    if (!ConnectivityManager.isNetworkTypeValid(paramInt)) {
      return null;
    }
    NetworkInfo localNetworkInfo = ((ConnectivityManager)bx.b().getSystemService("connectivity")).getNetworkInfo(paramInt);
    JSONObject localJSONObject = new JSONObject();
    if (localNetworkInfo != null) {
      for (;;)
      {
        try
        {
          localJSONObject.put("available", localNetworkInfo.isAvailable());
          localJSONObject.put("connected", localNetworkInfo.isConnected());
          if (!localNetworkInfo.isConnected()) {
            localJSONObject.put("connecting", localNetworkInfo.isConnectedOrConnecting());
          }
          localJSONObject.put("failover", localNetworkInfo.isFailover());
          if (paramInt == 0)
          {
            paramInt = i;
            localObject1 = localJSONObject;
            if (paramInt == 0) {
              break;
            }
            localJSONObject.put("roaming", localNetworkInfo.isRoaming());
            return localJSONObject;
          }
        }
        catch (JSONException localJSONException)
        {
          dx.c();
          return null;
        }
        paramInt = 0;
      }
    }
    localJSONObject.put("available", false);
    localJSONObject.put("connected", false);
    localJSONObject.put("connecting", false);
    localJSONObject.put("failover", false);
    if (paramInt == 0) {}
    for (paramInt = j;; paramInt = 0)
    {
      Object localObject2 = localJSONObject;
      if (paramInt == 0) {
        break;
      }
      localJSONObject.put("roaming", false);
      return localJSONObject;
    }
  }
  
  public String a()
  {
    return null;
  }
  
  public JSONObject c()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     crittercism.android.bx.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */