package rx.android.plugins;

import rx.Scheduler;
import rx.functions.Action0;

public class RxAndroidSchedulersHook
{
  private static final RxAndroidSchedulersHook DEFAULT_INSTANCE = new RxAndroidSchedulersHook();
  
  public static RxAndroidSchedulersHook getDefaultInstance()
  {
    return DEFAULT_INSTANCE;
  }
  
  public Scheduler getMainThreadScheduler()
  {
    return null;
  }
  
  public Action0 onSchedule(Action0 paramAction0)
  {
    return paramAction0;
  }
}

/* Location:
 * Qualified Name:     rx.android.plugins.RxAndroidSchedulersHook
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */