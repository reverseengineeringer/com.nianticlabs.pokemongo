package crittercism.android;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import java.util.List;

public final class bx$a
  implements bw
{
  private String a = null;
  
  public bx$a()
  {
    bx.c();
    bx.b();
    if (cb) {
      str = bgetSystemService"activity"getRunningTasks1get0topActivity.flattenToShortString().replace("/", "");
    }
    a = str;
  }
  
  public final String a()
  {
    return "activity";
  }
}

/* Location:
 * Qualified Name:     crittercism.android.bx.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */