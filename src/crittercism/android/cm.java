package crittercism.android;

import java.util.HashMap;

public enum cm
{
  private static HashMap C;
  private int D;
  private String E;
  
  private cm(int paramInt1, String paramString1)
  {
    D = paramInt1;
    E = paramString1;
  }
  
  public static cm a(Throwable paramThrowable)
  {
    if (C == null) {
      b();
    }
    Object localObject = null;
    if (paramThrowable != null) {
      localObject = paramThrowable.getClass().getName();
    }
    localObject = (cm)C.get(localObject);
    paramThrowable = (Throwable)localObject;
    if (localObject == null) {
      paramThrowable = B;
    }
    return paramThrowable;
  }
  
  /* Error */
  private static void b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 226	crittercism/android/cm:C	Ljava/util/HashMap;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: new 242	java/util/HashMap
    //   18: dup
    //   19: invokespecial 248	java/util/HashMap:<init>	()V
    //   22: astore_2
    //   23: invokestatic 252	crittercism/android/cm:values	()[Lcrittercism/android/cm;
    //   26: astore_3
    //   27: aload_3
    //   28: arraylength
    //   29: istore_1
    //   30: iconst_0
    //   31: istore_0
    //   32: iload_0
    //   33: iload_1
    //   34: if_icmpge +27 -> 61
    //   37: aload_3
    //   38: iload_0
    //   39: aaload
    //   40: astore 4
    //   42: aload_2
    //   43: aload 4
    //   45: getfield 223	crittercism/android/cm:E	Ljava/lang/String;
    //   48: aload 4
    //   50: invokevirtual 256	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   53: pop
    //   54: iload_0
    //   55: iconst_1
    //   56: iadd
    //   57: istore_0
    //   58: goto -26 -> 32
    //   61: aload_2
    //   62: putstatic 226	crittercism/android/cm:C	Ljava/util/HashMap;
    //   65: goto -54 -> 11
    //   68: astore_2
    //   69: ldc 2
    //   71: monitorexit
    //   72: aload_2
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   31	27	0	i1	int
    //   29	6	1	i2	int
    //   6	56	2	localHashMap	HashMap
    //   68	5	2	localObject	Object
    //   26	12	3	arrayOfcm	cm[]
    //   40	9	4	localcm	cm
    // Exception table:
    //   from	to	target	type
    //   3	7	68	finally
    //   15	30	68	finally
    //   42	54	68	finally
    //   61	65	68	finally
  }
  
  public final int a()
  {
    return D;
  }
}

/* Location:
 * Qualified Name:     crittercism.android.cm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */