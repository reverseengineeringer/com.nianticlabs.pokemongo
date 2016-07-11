package crittercism.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class dq
{
  public static boolean a = false;
  
  public static Boolean a(Context paramContext)
  {
    return Boolean.valueOf(paramContext.getSharedPreferences("com.crittercism.usersettings", 0).getBoolean("crashedOnLastLoad", false));
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("com.crittercism.usersettings", 0).edit();
    paramContext.putBoolean("crashedOnLastLoad", paramBoolean);
    paramContext.commit();
  }
}

/* Location:
 * Qualified Name:     crittercism.android.dq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */