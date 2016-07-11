package crittercism.android;

import android.os.MessageQueue.IdleHandler;

final class az$a
  implements MessageQueue.IdleHandler
{
  private boolean a = false;
  
  public final boolean queueIdle()
  {
    try
    {
      if (!a)
      {
        a = true;
        bg.g();
      }
      return true;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     crittercism.android.az.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */