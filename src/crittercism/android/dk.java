package crittercism.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.json.JSONException;
import org.json.JSONObject;

public final class dk
  extends di
{
  private ax a;
  private final boolean b;
  private Context c;
  
  public dk(Context paramContext, ax paramax, boolean paramBoolean)
  {
    a = paramax;
    b = paramBoolean;
    c = paramContext;
  }
  
  public final void a()
  {
    new StringBuilder("Setting opt out status to ").append(b).append(".  This will take effect in the next user session.");
    dx.b();
    boolean bool = b;
    Object localObject = a;
    String str1 = cq.i.a();
    String str2 = cq.i.b();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("optOutStatus", bool).put("optOutStatusSet", true);
      ((ax)localObject).a(str1, str2, localJSONObject.toString());
      if (b)
      {
        localObject = c.getSharedPreferences("com.crittercism.optmz.config", 0).edit();
        ((SharedPreferences.Editor)localObject).clear();
        ((SharedPreferences.Editor)localObject).commit();
        h.b(c);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     crittercism.android.dk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */