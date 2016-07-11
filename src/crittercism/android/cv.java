package crittercism.android;

public final class cv
{
  private long a = 0L;
  private long b;
  
  public cv(long paramLong)
  {
    b = paramLong;
  }
  
  /* Error */
  public final boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 24	java/lang/System:nanoTime	()J
    //   5: lstore_1
    //   6: aload_0
    //   7: getfield 14	crittercism/android/cv:a	J
    //   10: lstore_3
    //   11: aload_0
    //   12: getfield 16	crittercism/android/cv:b	J
    //   15: lstore 5
    //   17: lload_1
    //   18: lload_3
    //   19: lsub
    //   20: lload 5
    //   22: lcmp
    //   23: ifle +11 -> 34
    //   26: iconst_1
    //   27: istore 7
    //   29: aload_0
    //   30: monitorexit
    //   31: iload 7
    //   33: ireturn
    //   34: iconst_0
    //   35: istore 7
    //   37: goto -8 -> 29
    //   40: astore 8
    //   42: aload_0
    //   43: monitorexit
    //   44: aload 8
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	cv
    //   5	13	1	l1	long
    //   10	9	3	l2	long
    //   15	6	5	l3	long
    //   27	9	7	bool	boolean
    //   40	5	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	40	finally
  }
  
  public final void b()
  {
    try
    {
      a = System.nanoTime();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     crittercism.android.cv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */