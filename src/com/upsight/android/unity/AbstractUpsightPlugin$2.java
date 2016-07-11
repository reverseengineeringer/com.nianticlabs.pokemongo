package com.upsight.android.unity;

import android.util.Log;

class AbstractUpsightPlugin$2
  implements Runnable
{
  AbstractUpsightPlugin$2(AbstractUpsightPlugin paramAbstractUpsightPlugin, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      val$r.run();
      return;
    }
    catch (Exception localException)
    {
      Log.e("Upsight", "Exception running command on UI thread: " + localException.getMessage());
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.unity.AbstractUpsightPlugin.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */