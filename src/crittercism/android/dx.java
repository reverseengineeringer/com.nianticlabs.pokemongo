package crittercism.android;

import android.util.Log;
import java.util.concurrent.ExecutorService;

public final class dx
{
  public static a a = a.a;
  private static ec b;
  
  public static void a() {}
  
  public static void a(ec paramec)
  {
    b = paramec;
  }
  
  public static void a(String paramString)
  {
    Log.i("Crittercism", paramString);
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    Log.e("Crittercism", paramString, paramThrowable);
  }
  
  public static void a(Throwable paramThrowable)
  {
    if (!(paramThrowable instanceof cp)) {}
    try
    {
      ec localec = b;
      if ((b != null) && (a == a.b))
      {
        localec = b;
        paramThrowable = new ec.1(localec, paramThrowable, Thread.currentThread().getId());
        if (!c.a(paramThrowable)) {
          b.execute(paramThrowable);
        }
      }
      return;
    }
    catch (ThreadDeath paramThrowable)
    {
      throw paramThrowable;
    }
    catch (Throwable paramThrowable) {}
  }
  
  public static void b() {}
  
  public static void b(String paramString)
  {
    Log.e("Crittercism", paramString);
  }
  
  public static void b(String paramString, Throwable paramThrowable)
  {
    Log.w("Crittercism", paramString, paramThrowable);
  }
  
  public static void c() {}
  
  public static void c(String paramString)
  {
    Log.w("Crittercism", paramString);
  }
  
  public static enum a {}
}

/* Location:
 * Qualified Name:     crittercism.android.dx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */