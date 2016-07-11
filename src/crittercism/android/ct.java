package crittercism.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public final class ct
  extends da
{
  private au a;
  private Context b;
  private String c;
  private JSONObject d;
  private JSONObject e;
  private boolean f;
  
  public ct(bs parambs1, bs parambs2, String paramString, Context paramContext, au paramau)
  {
    super(parambs1, parambs2);
    c = paramString;
    b = paramContext;
    a = paramau;
  }
  
  public final void a(boolean paramBoolean, int paramInt, JSONObject paramJSONObject)
  {
    super.a(paramBoolean, paramInt, paramJSONObject);
    if (paramJSONObject != null)
    {
      if (!paramJSONObject.optBoolean("internalExceptionReporting", false)) {
        break label421;
      }
      dx.a = dx.a.b;
      i.d();
    }
    for (;;)
    {
      Object localObject1 = a.m();
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = paramJSONObject.optJSONObject("rateMyApp");
        if (localObject2 == null) {
          ((dt)localObject1).a(false);
        }
      }
      else if (paramJSONObject.optInt("needPkg", 0) != 1) {}
      try
      {
        new dj(new cu(a).a("device_name", a.i()).a("pkg", b.getPackageName()), new dc(new db(c, "/android_v2/update_package_name").a()), null).run();
        f = true;
        d = paramJSONObject.optJSONObject("apm");
        if (d != null)
        {
          localObject1 = new h(d);
          localObject2 = b;
          if (c)
          {
            h.b((Context)localObject2);
            localObject2 = ((Context)localObject2).getSharedPreferences("com.crittercism.optmz.config", 0).edit();
            if (!b) {
              break label665;
            }
            ((SharedPreferences.Editor)localObject2).putBoolean("enabled", a);
            ((SharedPreferences.Editor)localObject2).putBoolean("kill", c);
            ((SharedPreferences.Editor)localObject2).putBoolean("persist", b);
            ((SharedPreferences.Editor)localObject2).putInt("interval", d);
            ((SharedPreferences.Editor)localObject2).commit();
            az.A().a((h)localObject1);
          }
        }
        else
        {
          e = paramJSONObject.optJSONObject("txnConfig");
          if (e != null)
          {
            paramJSONObject = new bh(e);
            localObject1 = b.getSharedPreferences("com.crittercism.txn.config", 0).edit();
            ((SharedPreferences.Editor)localObject1).putBoolean("enabled", a);
            ((SharedPreferences.Editor)localObject1).putInt("interval", b);
            ((SharedPreferences.Editor)localObject1).putInt("defaultTimeout", c);
            ((SharedPreferences.Editor)localObject1).putString("transactions", d.toString());
            ((SharedPreferences.Editor)localObject1).commit();
            az.A().a(paramJSONObject);
          }
          return;
          label421:
          dx.a = dx.a.c;
          continue;
          try
          {
            int i = ((JSONObject)localObject2).getInt("rateAfterLoadNum");
            paramInt = i;
            if (i < 0) {
              paramInt = 0;
            }
            a.edit().putInt("rateAfterNumLoads", paramInt).commit();
            i = ((JSONObject)localObject2).getInt("remindAfterLoadNum");
            paramInt = i;
            if (i <= 0) {
              paramInt = 1;
            }
            a.edit().putInt("remindAfterNumLoads", paramInt).commit();
            localObject3 = ((JSONObject)localObject2).getString("message");
            a.edit().putString("rateAppMessage", (String)localObject3).commit();
            localObject2 = ((JSONObject)localObject2).getString("title");
            a.edit().putString("rateAppTitle", (String)localObject2).commit();
            ((dt)localObject1).a(true);
          }
          catch (JSONException localJSONException)
          {
            ((dt)localObject1).a(false);
          }
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          new StringBuilder("IOException in handleResponse(): ").append(localIOException.getMessage());
          dx.b();
          dx.c();
          continue;
          Object localObject3 = h.a(localJSONException);
          if ((!((File)localObject3).delete()) && (((File)localObject3).exists()))
          {
            dx.b("Unable to reenable OPTMZ instrumentation");
            continue;
            label665:
            localJSONException.clear();
          }
        }
      }
    }
  }
  
  public static final class a
    implements cz
  {}
}

/* Location:
 * Qualified Name:     crittercism.android.ct
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */