package crittercism.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class dt
{
  public SharedPreferences a;
  
  protected dt() {}
  
  public dt(Context paramContext)
  {
    a = paramContext.getSharedPreferences("com.crittercism.ratemyapp", 0);
  }
  
  public final int a()
  {
    return a.getInt("numAppLoads", 0);
  }
  
  public final void a(boolean paramBoolean)
  {
    a.edit().putBoolean("rateMyAppEnabled", paramBoolean).commit();
  }
  
  public final String b()
  {
    return a.getString("rateAppMessage", "Would you mind taking a second to rate my app?  I would really appreciate it!");
  }
  
  public final String c()
  {
    return a.getString("rateAppTitle", "Rate My App");
  }
  
  public final void d()
  {
    a.edit().putBoolean("hasRatedApp", true).commit();
  }
}

/* Location:
 * Qualified Name:     crittercism.android.dt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */