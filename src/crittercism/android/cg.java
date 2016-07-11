package crittercism.android;

import java.util.Locale;

public final class cg
{
  public static final cg a = new cg();
  private volatile int b = 1;
  private final long c = System.currentTimeMillis();
  
  private int b()
  {
    try
    {
      int i = b;
      b = (i + 1);
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String a()
  {
    return String.format(Locale.US, "%d.%d.%09d", new Object[] { Integer.valueOf(1), Long.valueOf(c), Integer.valueOf(b()) });
  }
}

/* Location:
 * Qualified Name:     crittercism.android.cg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */