package crittercism.android;

import java.io.OutputStream;
import org.json.JSONException;
import org.json.JSONObject;

public final class bm
  implements ch
{
  private JSONObject a;
  private String b = cg.a.a();
  
  public bm(au paramau)
  {
    try
    {
      a = new JSONObject().put("appID", paramau.a()).put("deviceID", paramau.c()).put("crPlatform", "android").put("crVersion", paramau.d()).put("deviceModel", paramau.j()).put("osName", "android").put("osVersion", paramau.k()).put("carrier", paramau.f()).put("mobileCountryCode", paramau.g()).put("mobileNetworkCode", paramau.h()).put("appVersion", paramau.b()).put("locale", bx.ka);
      return;
    }
    catch (JSONException paramau) {}
  }
  
  public final void a(OutputStream paramOutputStream)
  {
    paramOutputStream.write(a.toString().getBytes());
  }
  
  public final String e()
  {
    return b;
  }
}

/* Location:
 * Qualified Name:     crittercism.android.bm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */