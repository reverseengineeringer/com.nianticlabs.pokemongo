package spacemadness.com.lunarconsole.utils;

import android.os.Handler;
import android.os.Looper;

public class ThreadUtils
{
  private final Handler handler = new Handler(Looper.getMainLooper());
  
  public static void cancel(Runnable paramRunnable)
  {
    Holder.INSTANCE.cancelRunnable(paramRunnable);
  }
  
  public static void cancelAll()
  {
    Holder.INSTANCE.cancelRunnables();
  }
  
  private void cancelRunnable(Runnable paramRunnable)
  {
    handler.removeCallbacks(paramRunnable);
  }
  
  private void cancelRunnables()
  {
    handler.removeCallbacks(null);
  }
  
  public static boolean isRunningOnMainThread()
  {
    return Thread.currentThread() == Looper.getMainLooper().getThread();
  }
  
  private void postRunnable(Runnable paramRunnable)
  {
    handler.post(paramRunnable);
  }
  
  private void postRunnable(Runnable paramRunnable, long paramLong)
  {
    handler.postDelayed(paramRunnable, paramLong);
  }
  
  public static void runOnUIThread(Runnable paramRunnable)
  {
    Holder.INSTANCE.postRunnable(paramRunnable);
  }
  
  public static void runOnUIThread(Runnable paramRunnable, long paramLong)
  {
    Holder.INSTANCE.postRunnable(paramRunnable, paramLong);
  }
  
  private static class Holder
  {
    private static final ThreadUtils INSTANCE = new ThreadUtils(null);
  }
}

/* Location:
 * Qualified Name:     spacemadness.com.lunarconsole.utils.ThreadUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */