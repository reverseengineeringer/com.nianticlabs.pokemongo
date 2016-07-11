package crittercism.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.provider.Settings.Secure;
import java.util.UUID;

public final class dr
{
  private SharedPreferences a;
  private SharedPreferences b;
  private Context c;
  
  public dr(Context paramContext)
  {
    if (paramContext == null) {
      throw new NullPointerException("context was null");
    }
    c = paramContext;
    a = paramContext.getSharedPreferences("com.crittercism.usersettings", 0);
    b = paramContext.getSharedPreferences("com.crittercism.prefs", 0);
    if (a == null) {
      throw new NullPointerException("prefs were null");
    }
    if (b == null) {
      throw new NullPointerException("legacy prefs were null");
    }
  }
  
  private boolean a(String paramString)
  {
    SharedPreferences.Editor localEditor = a.edit();
    localEditor.putString("hashedDeviceID", paramString);
    return localEditor.commit();
  }
  
  private String b()
  {
    Object localObject3 = null;
    try
    {
      Object localObject4 = Settings.Secure.getString(c.getContentResolver(), "android_id");
      localObject1 = localObject3;
      if (localObject4 != null)
      {
        localObject1 = localObject3;
        if (((String)localObject4).length() > 0)
        {
          localObject1 = localObject3;
          if (!((String)localObject4).equals("9774d56d682e549c"))
          {
            localObject4 = UUID.nameUUIDFromBytes(((String)localObject4).getBytes("utf8"));
            localObject1 = localObject3;
            if (localObject4 != null) {
              localObject1 = ((UUID)localObject4).toString();
            }
          }
        }
      }
    }
    catch (ThreadDeath localThreadDeath1)
    {
      try
      {
        Object localObject1;
        localObject3 = UUID.randomUUID().toString();
        return (String)localObject3;
      }
      catch (ThreadDeath localThreadDeath2)
      {
        Object localObject2;
        throw localThreadDeath2;
      }
      catch (Throwable localThrowable2)
      {
        dx.a(localThrowable2);
      }
      localThreadDeath1 = localThreadDeath1;
      throw localThreadDeath1;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        label82:
        dx.a(localThrowable1);
        localObject2 = localObject3;
      }
    }
    if (localObject1 != null)
    {
      localObject3 = localObject1;
      if (((String)localObject1).length() != 0) {
        break label82;
      }
    }
    return localThreadDeath2;
  }
  
  public final String a()
  {
    Object localObject2 = a.getString("hashedDeviceID", null);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = b.getString("com.crittercism.prefs.did", null);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (a((String)localObject2))
        {
          localObject1 = b.edit();
          ((SharedPreferences.Editor)localObject1).remove("com.crittercism.prefs.did");
          ((SharedPreferences.Editor)localObject1).commit();
          localObject1 = localObject2;
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = b();
      a((String)localObject2);
    }
    return (String)localObject2;
  }
}

/* Location:
 * Qualified Name:     crittercism.android.dr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */