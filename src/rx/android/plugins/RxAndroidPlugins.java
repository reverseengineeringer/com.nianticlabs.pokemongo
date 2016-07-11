package rx.android.plugins;

import java.util.concurrent.atomic.AtomicReference;
import rx.annotations.Beta;

public final class RxAndroidPlugins
{
  private static final RxAndroidPlugins INSTANCE = new RxAndroidPlugins();
  private final AtomicReference<RxAndroidSchedulersHook> schedulersHook = new AtomicReference();
  
  public static RxAndroidPlugins getInstance()
  {
    return INSTANCE;
  }
  
  public RxAndroidSchedulersHook getSchedulersHook()
  {
    if (schedulersHook.get() == null) {
      schedulersHook.compareAndSet(null, RxAndroidSchedulersHook.getDefaultInstance());
    }
    return (RxAndroidSchedulersHook)schedulersHook.get();
  }
  
  public void registerSchedulersHook(RxAndroidSchedulersHook paramRxAndroidSchedulersHook)
  {
    if (!schedulersHook.compareAndSet(null, paramRxAndroidSchedulersHook)) {
      throw new IllegalStateException("Another strategy was already registered: " + schedulersHook.get());
    }
  }
  
  @Beta
  public void reset()
  {
    schedulersHook.set(null);
  }
}

/* Location:
 * Qualified Name:     rx.android.plugins.RxAndroidPlugins
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */