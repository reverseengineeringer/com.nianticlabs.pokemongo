package crittercism.android;

final class i$a
  implements Runnable
{
  private boolean a;
  private boolean b = false;
  private i c;
  
  public i$a(i parami)
  {
    c = parami;
    a = true;
  }
  
  public final boolean a()
  {
    return b;
  }
  
  public final void run()
  {
    if (a)
    {
      b = c.c();
      return;
    }
    c.b();
  }
}

/* Location:
 * Qualified Name:     crittercism.android.i.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */