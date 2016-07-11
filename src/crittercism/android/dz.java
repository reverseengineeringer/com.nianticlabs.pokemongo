package crittercism.android;

import java.util.concurrent.ThreadFactory;

public final class dz
  implements ThreadFactory
{
  public final Thread newThread(Runnable paramRunnable)
  {
    return new dy(paramRunnable);
  }
}

/* Location:
 * Qualified Name:     crittercism.android.dz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */