package com.crittercism.app;

import crittercism.android.az;
import crittercism.android.dl;
import crittercism.android.dw;
import java.util.HashMap;
import java.util.Map;

public class CritterUserDataRequest
{
  private final CritterCallback a;
  private az b;
  private Map c;
  private dl d;
  
  public CritterUserDataRequest(CritterCallback paramCritterCallback)
  {
    a = paramCritterCallback;
    b = az.A();
    c = new HashMap();
    d = new dl(b);
  }
  
  /* Error */
  public void makeRequest()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 29	com/crittercism/app/CritterUserDataRequest:b	Lcrittercism/android/az;
    //   6: getfield 52	crittercism/android/az:q	Lcrittercism/android/dg;
    //   9: astore_1
    //   10: aload_1
    //   11: ifnonnull +45 -> 56
    //   14: new 54	java/lang/IllegalStateException
    //   17: dup
    //   18: invokespecial 55	java/lang/IllegalStateException:<init>	()V
    //   21: astore_1
    //   22: new 57	java/lang/StringBuilder
    //   25: dup
    //   26: ldc 59
    //   28: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   31: aload_0
    //   32: invokevirtual 66	java/lang/Object:getClass	()Ljava/lang/Class;
    //   35: invokevirtual 72	java/lang/Class:getName	()Ljava/lang/String;
    //   38: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 78
    //   43: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: aload_1
    //   50: invokestatic 86	crittercism/android/dx:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   53: aload_0
    //   54: monitorexit
    //   55: return
    //   56: new 6	com/crittercism/app/CritterUserDataRequest$1
    //   59: dup
    //   60: aload_0
    //   61: invokespecial 89	com/crittercism/app/CritterUserDataRequest$1:<init>	(Lcom/crittercism/app/CritterUserDataRequest;)V
    //   64: astore_2
    //   65: aload_1
    //   66: aload_2
    //   67: invokevirtual 94	crittercism/android/dg:a	(Ljava/lang/Runnable;)Z
    //   70: ifne -17 -> 53
    //   73: new 96	crittercism/android/dy
    //   76: dup
    //   77: aload_2
    //   78: invokespecial 99	crittercism/android/dy:<init>	(Ljava/lang/Runnable;)V
    //   81: invokevirtual 102	crittercism/android/dy:start	()V
    //   84: goto -31 -> 53
    //   87: astore_1
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	CritterUserDataRequest
    //   9	57	1	localObject1	Object
    //   87	4	1	localObject2	Object
    //   64	14	2	local1	1
    // Exception table:
    //   from	to	target	type
    //   2	10	87	finally
    //   14	53	87	finally
    //   56	84	87	finally
  }
  
  public CritterUserDataRequest requestDidCrashOnLastLoad()
  {
    d.c();
    return this;
  }
  
  public CritterUserDataRequest requestOptOutStatus()
  {
    d.b();
    return this;
  }
  
  public CritterUserDataRequest requestRateMyAppInfo()
  {
    d.e();
    return this;
  }
  
  public CritterUserDataRequest requestUserUUID()
  {
    d.d();
    return this;
  }
}

/* Location:
 * Qualified Name:     com.crittercism.app.CritterUserDataRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */