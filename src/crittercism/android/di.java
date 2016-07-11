package crittercism.android;

public abstract class di
  implements Runnable
{
  public abstract void a();
  
  public final void run()
  {
    try
    {
      a();
      return;
    }
    catch (ThreadDeath localThreadDeath)
    {
      throw localThreadDeath;
    }
    catch (Throwable localThrowable)
    {
      dx.a(localThrowable);
    }
  }
}

/* Location:
 * Qualified Name:     crittercism.android.di
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */