package com.crittercism.app;

import android.app.AlertDialog;
import android.content.Context;
import android.location.Location;
import android.os.Build.VERSION;
import android.os.ConditionVariable;
import com.crittercism.integrations.PluginException;
import crittercism.android.az;
import crittercism.android.az.1;
import crittercism.android.az.7;
import crittercism.android.bb;
import crittercism.android.bc;
import crittercism.android.bg;
import crittercism.android.cf;
import crittercism.android.cf.a;
import crittercism.android.dg;
import crittercism.android.dk;
import crittercism.android.dq;
import crittercism.android.dt;
import crittercism.android.dw;
import crittercism.android.dx;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

public class Crittercism
{
  public static void _logCrashException(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    try
    {
      dx.b("Unable to handle application crash. Missing parameters");
      return;
    }
    catch (Throwable paramString1)
    {
      dx.a(paramString1);
    }
    new StringBuilder("_logCrashException(msg, stack) called: ").append(paramString1).append(" ").append(paramString2);
    dx.b();
    _logCrashException(new PluginException(paramString1, paramString2));
    return;
  }
  
  public static void _logCrashException(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {}
    try
    {
      dx.b("Unable to handle application crash. Missing parameters");
      return;
    }
    catch (Throwable paramString1)
    {
      dx.a(paramString1);
    }
    new StringBuilder("_logCrashException(name, msg, stack) called: ").append(paramString1).append(" ").append(paramString2).append(" ").append(paramString3);
    dx.b();
    _logCrashException(new PluginException(paramString1, paramString2, paramString3));
    return;
  }
  
  public static void _logCrashException(String paramString1, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, int[] paramArrayOfInt)
  {
    try
    {
      new StringBuilder("_logCrashException(String, String, String[], String[], String[], int[]) called: ").append(paramString1).append(" ").append(paramString2);
      dx.b();
      if ((paramString1 == null) || (paramString2 == null) || (paramArrayOfString1 == null) || (paramArrayOfString2 == null) || (paramArrayOfString3 == null) || (paramArrayOfInt == null))
      {
        dx.b("Unable to handle application crash. Missing parameters");
        return;
      }
      if (!a(new Object[] { paramArrayOfString1, paramArrayOfString2, paramArrayOfString3, paramArrayOfInt }))
      {
        dx.b("Unable to handle application crash. Missing stack elements");
        return;
      }
    }
    catch (Throwable paramString1)
    {
      dx.a(paramString1);
      return;
    }
    _logCrashException(new PluginException(paramString1, paramString2, paramArrayOfString1, paramArrayOfString2, paramArrayOfString3, paramArrayOfInt));
  }
  
  @Deprecated
  public static void _logCrashException(Throwable paramThrowable)
  {
    try
    {
      new StringBuilder("_logCrashException(Throwable) called with throwable: ").append(paramThrowable.getMessage());
      dx.b();
      if (!Ab)
      {
        b("_logCrashException");
        return;
      }
      az.A().a(paramThrowable);
      return;
    }
    catch (ThreadDeath paramThrowable)
    {
      throw paramThrowable;
    }
    catch (Throwable paramThrowable)
    {
      dx.a(paramThrowable);
    }
  }
  
  public static void _logHandledException(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      new StringBuilder("_logHandledException(name, msg, stack) called: ").append(paramString1).append(" ").append(paramString2).append(" ").append(paramString3);
      dx.b();
      if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null))
      {
        dx.c("Calling logHandledException with null parameter(s). Nothing will be reported to Crittercism");
        return;
      }
      logHandledException(new PluginException(paramString1, paramString2, paramString3));
      return;
    }
    catch (ThreadDeath paramString1)
    {
      throw paramString1;
    }
    catch (Throwable paramString1)
    {
      dx.a(paramString1);
    }
  }
  
  public static void _logHandledException(String paramString1, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, int[] paramArrayOfInt)
  {
    try
    {
      new StringBuilder("_logHandledException(name, msg, classes, methods, files, lines) called: ").append(paramString1);
      dx.b();
      if ((paramString1 == null) || (paramString2 == null) || (paramArrayOfString1 == null))
      {
        dx.c("Calling logHandledException with null parameter(s). Nothing will be reported to Crittercism");
        return;
      }
      logHandledException(new PluginException(paramString1, paramString2, paramArrayOfString1, paramArrayOfString2, paramArrayOfString3, paramArrayOfInt));
      return;
    }
    catch (ThreadDeath paramString1)
    {
      throw paramString1;
    }
    catch (Throwable paramString1)
    {
      dx.a(paramString1);
    }
  }
  
  private static void a(String paramString)
  {
    dx.b("Crittercism cannot be initialized", new NullPointerException(paramString + " was null"));
  }
  
  private static boolean a(Object... paramVarArgs)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramVarArgs.length <= 0) || (paramVarArgs[0] == null))
    {
      bool1 = false;
      return bool1;
    }
    int j = Array.getLength(paramVarArgs[0]);
    int i = 1;
    for (;;)
    {
      bool1 = bool2;
      if (i >= paramVarArgs.length) {
        break;
      }
      if (paramVarArgs[i] == null) {
        return false;
      }
      if (Array.getLength(paramVarArgs[i]) != j) {
        return false;
      }
      i += 1;
    }
  }
  
  private static void b(String paramString)
  {
    dx.b("Must initialize Crittercism before calling " + Crittercism.class.getName() + "." + paramString + "().  Request is being ignored...", new IllegalStateException());
  }
  
  public static void beginTransaction(String paramString)
  {
    try
    {
      az localaz = az.A();
      if (t)
      {
        dx.c("Transactions are not supported for services. Ignoring Crittercism.beginTransaction() call for " + paramString + ".");
        return;
      }
      Transaction localTransaction1 = Transaction.a(paramString);
      if ((localTransaction1 instanceof bg)) {
        synchronized (z)
        {
          Transaction localTransaction2 = (Transaction)z.remove(paramString);
          if (localTransaction2 != null) {
            ((bg)localTransaction2).h();
          }
          if (z.size() > 50)
          {
            dx.c("Crittercism only supports a maximum of 50 concurrent transactions. Ignoring Crittercism.beginTransaction() call for " + paramString + ".");
            return;
          }
        }
      }
      return;
    }
    catch (ThreadDeath paramString)
    {
      throw paramString;
      z.put(paramString, localTransaction1);
      localTransaction1.a();
      return;
    }
    catch (Throwable paramString)
    {
      dx.a(paramString);
    }
  }
  
  public static boolean didCrashOnLastLoad()
  {
    try
    {
      az localaz = az.A();
      if (!b)
      {
        b("didCrashOnLoad");
        return false;
      }
      if (!localaz.B())
      {
        e.block();
        boolean bool = dq.a;
        return bool;
      }
    }
    catch (ThreadDeath localThreadDeath)
    {
      throw localThreadDeath;
    }
    catch (Throwable localThrowable)
    {
      dx.a(localThrowable);
    }
    return false;
  }
  
  public static void endTransaction(String paramString)
  {
    try
    {
      az localaz = az.A();
      if (t)
      {
        dx.c("Transactions are not supported for services. Ignoring Crittercism.endTransaction() call for " + paramString + ".");
        return;
      }
      return;
    }
    catch (ThreadDeath paramString)
    {
      synchronized (z)
      {
        paramString = (Transaction)z.remove(paramString);
        if (paramString != null)
        {
          paramString.b();
          return;
          paramString = paramString;
          throw paramString;
        }
      }
    }
    catch (Throwable paramString)
    {
      dx.a(paramString);
    }
  }
  
  public static void failTransaction(String paramString)
  {
    try
    {
      az localaz = az.A();
      if (t)
      {
        dx.c("Transactions are not supported for services. Ignoring Crittercism.failTransaction() call for " + paramString + ".");
        return;
      }
      return;
    }
    catch (ThreadDeath paramString)
    {
      synchronized (z)
      {
        paramString = (Transaction)z.remove(paramString);
        if (paramString != null)
        {
          paramString.c();
          return;
          paramString = paramString;
          throw paramString;
        }
      }
    }
    catch (Throwable paramString)
    {
      dx.a(paramString);
    }
  }
  
  public static AlertDialog generateRateMyAppAlertDialog(Context paramContext)
  {
    for (;;)
    {
      try
      {
        az localaz = az.A();
        localObject = A;
        if (A != null)
        {
          str = A.b();
          localObject = A.c();
          paramContext = localaz.a(paramContext, (String)localObject, str);
          return paramContext;
        }
      }
      catch (ThreadDeath paramContext)
      {
        throw paramContext;
      }
      catch (Throwable paramContext)
      {
        dx.a(paramContext);
        return null;
      }
      Object localObject = null;
      String str = null;
    }
  }
  
  public static AlertDialog generateRateMyAppAlertDialog(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = az.A().a(paramContext, paramString1, paramString2);
      return paramContext;
    }
    catch (ThreadDeath paramContext)
    {
      throw paramContext;
    }
    catch (Throwable paramContext)
    {
      dx.a(paramContext);
    }
    return null;
  }
  
  public static boolean getOptOutStatus()
  {
    try
    {
      az localaz = az.A();
      if (!b)
      {
        b("getOptOutStatus");
        return false;
      }
      boolean bool = localaz.B();
      return bool;
    }
    catch (ThreadDeath localThreadDeath)
    {
      throw localThreadDeath;
    }
    catch (Throwable localThrowable)
    {
      dx.a(localThrowable);
    }
    return false;
  }
  
  public static int getTransactionValue(String paramString)
  {
    try
    {
      int i = az.A().b(paramString);
      return i;
    }
    catch (ThreadDeath paramString)
    {
      throw paramString;
    }
    catch (Throwable paramString)
    {
      dx.a(paramString);
    }
    return -1;
  }
  
  public static void initialize(Context paramContext, String paramString)
  {
    try
    {
      initialize(paramContext, paramString, new CrittercismConfig());
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  public static void initialize(Context paramContext, String paramString, CrittercismConfig paramCrittercismConfig)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: ifnonnull +15 -> 19
    //   7: ldc -28
    //   9: invokevirtual 231	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   12: invokestatic 233	com/crittercism/app/Crittercism:a	(Ljava/lang/String;)V
    //   15: ldc 2
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: ifnonnull +48 -> 68
    //   23: ldc -21
    //   25: invokevirtual 231	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   28: invokestatic 233	com/crittercism/app/Crittercism:a	(Ljava/lang/String;)V
    //   31: goto -16 -> 15
    //   34: astore_0
    //   35: new 237	java/lang/IllegalArgumentException
    //   38: dup
    //   39: new 23	java/lang/StringBuilder
    //   42: dup
    //   43: ldc -17
    //   45: invokespecial 27	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   48: aload_0
    //   49: invokevirtual 240	crittercism/android/bn$a:getMessage	()Ljava/lang/String;
    //   52: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokespecial 241	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   61: athrow
    //   62: astore_0
    //   63: ldc 2
    //   65: monitorexit
    //   66: aload_0
    //   67: athrow
    //   68: aload_2
    //   69: ifnonnull +17 -> 86
    //   72: ldc -36
    //   74: invokevirtual 231	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   77: invokestatic 233	com/crittercism/app/Crittercism:a	(Ljava/lang/String;)V
    //   80: goto -65 -> 15
    //   83: astore_0
    //   84: aload_0
    //   85: athrow
    //   86: invokestatic 75	crittercism/android/az:A	()Lcrittercism/android/az;
    //   89: getfield 78	crittercism/android/az:b	Z
    //   92: ifne -77 -> 15
    //   95: invokestatic 247	java/lang/System:nanoTime	()J
    //   98: lstore_3
    //   99: invokestatic 75	crittercism/android/az:A	()Lcrittercism/android/az;
    //   102: aload_0
    //   103: aload_1
    //   104: aload_2
    //   105: invokevirtual 249	crittercism/android/az:a	(Landroid/content/Context;Ljava/lang/String;Lcom/crittercism/app/CrittercismConfig;)V
    //   108: invokestatic 247	java/lang/System:nanoTime	()J
    //   111: lload_3
    //   112: lsub
    //   113: ldc2_w 250
    //   116: ldiv
    //   117: lstore_3
    //   118: new 23	java/lang/StringBuilder
    //   121: dup
    //   122: ldc -3
    //   124: invokespecial 27	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   127: lload_3
    //   128: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   131: ldc_w 258
    //   134: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: invokestatic 35	crittercism/android/dx:b	()V
    //   141: goto -126 -> 15
    //   144: astore_0
    //   145: aload_0
    //   146: invokestatic 45	crittercism/android/dx:a	(Ljava/lang/Throwable;)V
    //   149: goto -134 -> 15
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	paramContext	Context
    //   0	152	1	paramString	String
    //   0	152	2	paramCrittercismConfig	CrittercismConfig
    //   98	30	3	l	long
    // Exception table:
    //   from	to	target	type
    //   7	15	34	crittercism/android/bn$a
    //   23	31	34	crittercism/android/bn$a
    //   72	80	34	crittercism/android/bn$a
    //   86	141	34	crittercism/android/bn$a
    //   7	15	62	finally
    //   23	31	62	finally
    //   35	62	62	finally
    //   72	80	62	finally
    //   84	86	62	finally
    //   86	141	62	finally
    //   145	149	62	finally
    //   7	15	83	java/lang/ThreadDeath
    //   23	31	83	java/lang/ThreadDeath
    //   72	80	83	java/lang/ThreadDeath
    //   86	141	83	java/lang/ThreadDeath
    //   7	15	144	java/lang/Throwable
    //   23	31	144	java/lang/Throwable
    //   72	80	144	java/lang/Throwable
    //   86	141	144	java/lang/Throwable
  }
  
  public static void leaveBreadcrumb(String paramString)
  {
    try
    {
      if (!Ab)
      {
        b("leaveBreadcrumb");
        return;
      }
      if (paramString == null)
      {
        dx.b("Cannot leave null breadcrumb", new NullPointerException());
        return;
      }
    }
    catch (ThreadDeath paramString)
    {
      throw paramString;
      az localaz = az.A();
      if (!f.b())
      {
        az.7 local7 = new az.7(localaz, new cf(paramString, cf.a.a));
        if (!q.a(local7))
        {
          new StringBuilder("SENDING ").append(paramString).append(" TO EXECUTOR");
          dx.b();
          s.execute(local7);
          return;
        }
      }
    }
    catch (Throwable paramString)
    {
      dx.a(paramString);
    }
  }
  
  public static void logHandledException(Throwable paramThrowable)
  {
    try
    {
      if (!Ab)
      {
        b("logHandledException");
        return;
      }
      if (!Af.b())
      {
        az.A().b(paramThrowable);
        return;
      }
    }
    catch (ThreadDeath paramThrowable)
    {
      throw paramThrowable;
    }
    catch (Throwable paramThrowable)
    {
      dx.a(paramThrowable);
    }
  }
  
  public static void logNetworkRequest(String paramString, URL paramURL, long paramLong1, long paramLong2, long paramLong3, int paramInt, Exception paramException)
  {
    try
    {
      long l = System.currentTimeMillis();
      if (!Ab)
      {
        b("logEndpoint");
        return;
      }
      if (!Af.b())
      {
        az.A().a(paramString, paramURL, paramLong1, paramLong2, paramLong3, paramInt, paramException, l - paramLong1);
        return;
      }
    }
    catch (ThreadDeath paramString)
    {
      throw paramString;
    }
    catch (Throwable paramString)
    {
      dx.a(paramString);
    }
  }
  
  public static void performRateMyAppButtonAction(CritterRateMyAppButtons paramCritterRateMyAppButtons)
  {
    az localaz;
    String str;
    try
    {
      if (Af.b())
      {
        dx.c("User has opted out of crittercism.  performRateMyAppButtonAction exiting.");
        return;
      }
      localaz = az.A();
      if (Build.VERSION.SDK_INT < 5)
      {
        dx.c("Rate my app not supported below api level 5");
        return;
      }
    }
    catch (ThreadDeath paramCritterRateMyAppButtons)
    {
      throw paramCritterRateMyAppButtons;
      str = localaz.D();
      if (str == null)
      {
        dx.b("Cannot create proper URI to open app market.  Returning null.");
        return;
      }
    }
    catch (Throwable paramCritterRateMyAppButtons)
    {
      dx.a(paramCritterRateMyAppButtons);
      return;
    }
    int i = crittercism.android.az.4.a[paramCritterRateMyAppButtons.ordinal()];
    switch (i)
    {
    default: 
      return;
    case 1: 
      try
      {
        localaz.a(str);
        return;
      }
      catch (Exception paramCritterRateMyAppButtons)
      {
        dx.c("performRateMyAppButtonAction(CritterRateMyAppButtons.YES) failed.  Email support@crittercism.com.");
        dx.c();
        return;
      }
    }
    try
    {
      localaz.C();
      return;
    }
    catch (Exception paramCritterRateMyAppButtons)
    {
      dx.c("performRateMyAppButtonAction(CritterRateMyAppButtons.NO) failed.  Email support@crittercism.com.");
    }
  }
  
  public static void sendAppLoadData()
  {
    try
    {
      Object localObject = Au;
      if (localObject == null)
      {
        b("sendAppLoadData");
        return;
      }
      if (((CrittercismConfig)localObject).delaySendingAppLoad())
      {
        if (Af.b()) {
          return;
        }
        localObject = az.A();
        if (!u.delaySendingAppLoad())
        {
          dx.c("CrittercismConfig instance not set to delay sending app loads.");
          return;
        }
      }
    }
    catch (ThreadDeath localThreadDeath)
    {
      throw localThreadDeath;
      if ((t) || (C)) {
        return;
      }
      C = true;
      az.1 local1 = new az.1(localThreadDeath);
      if (q.a(local1)) {
        return;
      }
      s.execute(local1);
      return;
    }
    catch (Throwable localThrowable)
    {
      dx.a(localThrowable);
      return;
    }
    dx.a("sendAppLoadData() will only send data to Crittercism if \"delaySendingAppLoad\" is set to true in the configuration settings you include in the init call.");
  }
  
  public static void setMetadata(JSONObject paramJSONObject)
  {
    try
    {
      if (!Ab)
      {
        b("setMetadata");
        return;
      }
      az.A().a(paramJSONObject);
      return;
    }
    catch (ThreadDeath paramJSONObject)
    {
      throw paramJSONObject;
    }
    catch (Throwable paramJSONObject)
    {
      dx.a(paramJSONObject);
    }
  }
  
  public static void setOptOutStatus(boolean paramBoolean)
  {
    try
    {
      if (!Ab)
      {
        b("setOptOutStatus");
        return;
      }
      az localaz = az.A();
      dk localdk = new dk(c, localaz, paramBoolean);
      if (!q.a(localdk))
      {
        s.execute(localdk);
        return;
      }
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
  
  public static void setTransactionValue(String paramString, int paramInt)
  {
    try
    {
      az localaz = az.A();
      if (t)
      {
        dx.c("Transactions are not supported for services. Ignoring Crittercism.setTransactionValue() call for " + paramString + ".");
        return;
      }
      synchronized (z)
      {
        paramString = (Transaction)z.get(paramString);
        if (paramString != null) {
          paramString.a(paramInt);
        }
        return;
      }
      return;
    }
    catch (ThreadDeath paramString)
    {
      throw paramString;
    }
    catch (Throwable paramString)
    {
      dx.a(paramString);
    }
  }
  
  public static void setUsername(String paramString)
  {
    try
    {
      if (!Ab)
      {
        b("setUsername");
        return;
      }
      if (paramString == null)
      {
        dx.c("Crittercism.setUsername() given invalid parameter: null");
        return;
      }
    }
    catch (ThreadDeath paramString)
    {
      throw paramString;
      localJSONObject = new JSONObject();
    }
    catch (Throwable paramString)
    {
      try
      {
        JSONObject localJSONObject;
        localJSONObject.putOpt("username", paramString);
        az.A().a(localJSONObject);
        return;
      }
      catch (JSONException paramString)
      {
        dx.b("Crittercism.setUsername()", paramString);
      }
      paramString = paramString;
      dx.a(paramString);
      return;
    }
  }
  
  public static void updateLocation(Location paramLocation)
  {
    if (!Ab)
    {
      b("updateLocation");
      return;
    }
    if (paramLocation == null)
    {
      dx.b("Cannot leave null location", new NullPointerException());
      return;
    }
    bc.a(paramLocation);
  }
}

/* Location:
 * Qualified Name:     com.crittercism.app.Crittercism
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */