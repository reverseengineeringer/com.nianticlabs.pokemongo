package crittercism.android;

public final class ay
  implements Thread.UncaughtExceptionHandler
{
  private Thread.UncaughtExceptionHandler a;
  private final az b;
  
  public ay(az paramaz, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    b = paramaz;
    a = paramUncaughtExceptionHandler;
  }
  
  /* Error */
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	crittercism/android/ay:b	Lcrittercism/android/az;
    //   4: aload_2
    //   5: invokevirtual 31	crittercism/android/az:a	(Ljava/lang/Throwable;)V
    //   8: aload_0
    //   9: getfield 19	crittercism/android/ay:a	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   12: ifnull +26 -> 38
    //   15: aload_0
    //   16: getfield 19	crittercism/android/ay:a	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   19: instanceof 2
    //   22: ifne +16 -> 38
    //   25: aload_0
    //   26: getfield 19	crittercism/android/ay:a	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   29: invokestatic 37	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   32: aload_2
    //   33: invokeinterface 39 3 0
    //   38: return
    //   39: astore_1
    //   40: aload_1
    //   41: athrow
    //   42: astore_1
    //   43: aload_0
    //   44: getfield 19	crittercism/android/ay:a	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   47: ifnull +26 -> 73
    //   50: aload_0
    //   51: getfield 19	crittercism/android/ay:a	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   54: instanceof 2
    //   57: ifne +16 -> 73
    //   60: aload_0
    //   61: getfield 19	crittercism/android/ay:a	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   64: invokestatic 37	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   67: aload_2
    //   68: invokeinterface 39 3 0
    //   73: aload_1
    //   74: athrow
    //   75: astore_1
    //   76: ldc 41
    //   78: aload_1
    //   79: invokestatic 46	crittercism/android/dx:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   82: aload_0
    //   83: getfield 19	crittercism/android/ay:a	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   86: ifnull -48 -> 38
    //   89: aload_0
    //   90: getfield 19	crittercism/android/ay:a	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   93: instanceof 2
    //   96: ifne -58 -> 38
    //   99: aload_0
    //   100: getfield 19	crittercism/android/ay:a	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   103: invokestatic 37	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   106: aload_2
    //   107: invokeinterface 39 3 0
    //   112: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	ay
    //   0	113	1	paramThread	Thread
    //   0	113	2	paramThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	8	39	java/lang/ThreadDeath
    //   0	8	42	finally
    //   40	42	42	finally
    //   76	82	42	finally
    //   0	8	75	java/lang/Throwable
  }
}

/* Location:
 * Qualified Name:     crittercism.android.ay
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */