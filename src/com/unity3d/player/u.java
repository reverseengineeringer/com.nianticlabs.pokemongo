package com.unity3d.player;

import android.os.Build;

final class u
  implements Thread.UncaughtExceptionHandler
{
  private volatile Thread.UncaughtExceptionHandler a;
  
  /* Error */
  final boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 20	java/lang/Thread:getDefaultUncaughtExceptionHandler	()Ljava/lang/Thread$UncaughtExceptionHandler;
    //   5: astore_2
    //   6: aload_2
    //   7: aload_0
    //   8: if_acmpne +9 -> 17
    //   11: iconst_0
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: aload_2
    //   19: putfield 22	com/unity3d/player/u:a	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   22: aload_0
    //   23: invokestatic 26	java/lang/Thread:setDefaultUncaughtExceptionHandler	(Ljava/lang/Thread$UncaughtExceptionHandler;)V
    //   26: iconst_1
    //   27: istore_1
    //   28: goto -15 -> 13
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	u
    //   12	16	1	bool	boolean
    //   5	14	2	localUncaughtExceptionHandler	Thread.UncaughtExceptionHandler
    //   31	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	6	31	finally
    //   17	26	31	finally
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      Error localError = new Error(String.format("FATAL EXCEPTION [%s]\n", new Object[] { paramThread.getName() }) + String.format("Unity version     : %s\n", new Object[] { "5.3.5f1" }) + String.format("Device model      : %s %s\n", new Object[] { Build.MANUFACTURER, Build.MODEL }) + String.format("Device fingerprint: %s\n", new Object[] { Build.FINGERPRINT }));
      localError.setStackTrace(new StackTraceElement[0]);
      localError.initCause(paramThrowable);
      a.uncaughtException(paramThread, localError);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a.uncaughtException(paramThread, paramThrowable);
      }
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.u
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */