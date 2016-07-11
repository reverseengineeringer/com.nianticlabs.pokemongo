package crittercism.android;

import android.location.Location;

public final class bc
{
  private static Location a;
  
  public static Location a()
  {
    try
    {
      Location localLocation = a;
      return localLocation;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void a(Location paramLocation)
  {
    if (paramLocation == null) {}
    for (;;)
    {
      try
      {
        a = paramLocation;
        return;
      }
      finally {}
      paramLocation = new Location(paramLocation);
    }
  }
  
  /* Error */
  public static boolean b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 9	crittercism/android/bc:a	Landroid/location/Location;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +10 -> 18
    //   11: iconst_1
    //   12: istore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: iload_0
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_0
    //   20: goto -7 -> 13
    //   23: astore_1
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	8	0	bool	boolean
    //   6	2	1	localLocation	Location
    //   23	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	23	finally
  }
}

/* Location:
 * Qualified Name:     crittercism.android.bc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */