package crittercism.android;

import android.os.ConditionVariable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class g
  implements f, Runnable
{
  private List a = new LinkedList();
  private URL b = null;
  private long c = System.currentTimeMillis();
  private ConditionVariable d = new ConditionVariable(false);
  private au e;
  private ConditionVariable f = new ConditionVariable(false);
  private volatile boolean g = false;
  private final Object h = new Object();
  private int i = 50;
  private volatile long j = 10000L;
  
  public g(au paramau, URL paramURL)
  {
    this(paramau, paramURL, (byte)0);
  }
  
  private g(au paramau, URL paramURL, byte paramByte)
  {
    e = paramau;
    b = paramURL;
    i = 50;
    j = 10000L;
  }
  
  private static boolean a(HttpURLConnection paramHttpURLConnection, JSONObject paramJSONObject)
  {
    boolean bool = false;
    try
    {
      paramHttpURLConnection.getOutputStream().write(paramJSONObject.toString().getBytes("UTF8"));
      int k = paramHttpURLConnection.getResponseCode();
      paramHttpURLConnection.disconnect();
      if (k == 202) {
        bool = true;
      }
      return bool;
    }
    catch (IOException paramJSONObject)
    {
      new StringBuilder("Request failed for ").append(paramHttpURLConnection.getURL().toExternalForm());
      dx.a();
      return false;
    }
    catch (Exception paramJSONObject)
    {
      new StringBuilder("Request failed for ").append(paramHttpURLConnection.getURL().toExternalForm());
      dx.a();
    }
    return false;
  }
  
  private long b()
  {
    long l2 = 0L;
    long l3 = j;
    long l4 = System.currentTimeMillis() - c;
    long l1 = l3;
    if (l4 > 0L)
    {
      l3 -= l4;
      l1 = l3;
      if (l3 < 0L) {
        l1 = l2;
      }
    }
    for (;;)
    {
      l2 = j;
      return l1;
    }
  }
  
  /* Error */
  private HttpURLConnection c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	crittercism/android/g:b	Ljava/net/URL;
    //   4: invokevirtual 140	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   7: checkcast 78	java/net/HttpURLConnection
    //   10: astore_2
    //   11: aload_2
    //   12: sipush 2500
    //   15: invokevirtual 144	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   18: aload_2
    //   19: ldc -110
    //   21: ldc -108
    //   23: invokevirtual 152	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: aload_2
    //   27: ldc -102
    //   29: ldc -100
    //   31: invokevirtual 152	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: aload_2
    //   35: iconst_1
    //   36: invokevirtual 159	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   39: aload_2
    //   40: ldc -95
    //   42: invokevirtual 164	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   45: aload_2
    //   46: instanceof 166
    //   49: ifeq +54 -> 103
    //   52: aload_2
    //   53: checkcast 166	javax/net/ssl/HttpsURLConnection
    //   56: astore 4
    //   58: ldc -88
    //   60: invokestatic 174	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   63: astore_1
    //   64: aload_1
    //   65: aconst_null
    //   66: aconst_null
    //   67: aconst_null
    //   68: invokevirtual 178	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   71: aload_1
    //   72: invokevirtual 182	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   75: astore_3
    //   76: aload_3
    //   77: ifnull +26 -> 103
    //   80: aload_3
    //   81: astore_1
    //   82: aload_3
    //   83: instanceof 184
    //   86: ifeq +11 -> 97
    //   89: aload_3
    //   90: checkcast 184	crittercism/android/ab
    //   93: invokevirtual 186	crittercism/android/ab:a	()Ljavax/net/ssl/SSLSocketFactory;
    //   96: astore_1
    //   97: aload 4
    //   99: aload_1
    //   100: invokevirtual 190	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   103: aload_2
    //   104: areturn
    //   105: astore_2
    //   106: aconst_null
    //   107: astore_1
    //   108: new 111	java/lang/StringBuilder
    //   111: dup
    //   112: ldc -64
    //   114: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: aload_2
    //   118: invokevirtual 195	java/io/IOException:getMessage	()Ljava/lang/String;
    //   121: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 198	crittercism/android/dx:b	(Ljava/lang/String;)V
    //   130: aload_1
    //   131: areturn
    //   132: astore_1
    //   133: new 111	java/lang/StringBuilder
    //   136: dup
    //   137: ldc -64
    //   139: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   142: aload_1
    //   143: invokevirtual 199	java/security/GeneralSecurityException:getMessage	()Ljava/lang/String;
    //   146: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 198	crittercism/android/dx:b	(Ljava/lang/String;)V
    //   155: aconst_null
    //   156: areturn
    //   157: astore_3
    //   158: aload_2
    //   159: astore_1
    //   160: aload_3
    //   161: astore_2
    //   162: goto -54 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	g
    //   63	68	1	localObject1	Object
    //   132	11	1	localGeneralSecurityException	java.security.GeneralSecurityException
    //   159	1	1	localIOException1	IOException
    //   10	94	2	localHttpURLConnection	HttpURLConnection
    //   105	54	2	localIOException2	IOException
    //   161	1	2	localObject2	Object
    //   75	15	3	localSSLSocketFactory	javax.net.ssl.SSLSocketFactory
    //   157	4	3	localIOException3	IOException
    //   56	42	4	localHttpsURLConnection	javax.net.ssl.HttpsURLConnection
    // Exception table:
    //   from	to	target	type
    //   0	11	105	java/io/IOException
    //   0	11	132	java/security/GeneralSecurityException
    //   11	76	132	java/security/GeneralSecurityException
    //   82	97	132	java/security/GeneralSecurityException
    //   97	103	132	java/security/GeneralSecurityException
    //   11	76	157	java/io/IOException
    //   82	97	157	java/io/IOException
    //   97	103	157	java/io/IOException
  }
  
  private boolean d()
  {
    return (!g) && (a.size() < i);
  }
  
  public final void a()
  {
    f.open();
  }
  
  public final void a(int paramInt, TimeUnit paramTimeUnit)
  {
    j = paramTimeUnit.toMillis(paramInt);
  }
  
  public final void a(c paramc)
  {
    int k = 0;
    if (!d()) {
      return;
    }
    synchronized (h)
    {
      if (!d()) {
        return;
      }
    }
    a.add(paramc);
    String str = b.getHost();
    if (paramc.a().contains(str)) {}
    for (;;)
    {
      if (k != 0) {
        d.open();
      }
      return;
      paramc = f;
      if (paramc != null)
      {
        boolean bool = paramc.toLowerCase().equals("connect");
        if (bool) {}
      }
      else
      {
        k = 1;
      }
    }
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 61	crittercism/android/g:g	Z
    //   4: ifne +176 -> 180
    //   7: aload_0
    //   8: getfield 59	crittercism/android/g:f	Landroid/os/ConditionVariable;
    //   11: invokevirtual 250	android/os/ConditionVariable:block	()V
    //   14: aload_0
    //   15: getfield 57	crittercism/android/g:d	Landroid/os/ConditionVariable;
    //   18: invokevirtual 250	android/os/ConditionVariable:block	()V
    //   21: aload_0
    //   22: getfield 61	crittercism/android/g:g	Z
    //   25: istore_1
    //   26: iload_1
    //   27: ifne +153 -> 180
    //   30: aload_0
    //   31: invokespecial 252	crittercism/android/g:b	()J
    //   34: lconst_0
    //   35: lcmp
    //   36: ifle +10 -> 46
    //   39: aload_0
    //   40: invokespecial 252	crittercism/android/g:b	()J
    //   43: invokestatic 258	java/lang/Thread:sleep	(J)V
    //   46: aload_0
    //   47: invokestatic 48	java/lang/System:currentTimeMillis	()J
    //   50: putfield 50	crittercism/android/g:c	J
    //   53: aload_0
    //   54: invokespecial 260	crittercism/android/g:c	()Ljava/net/HttpURLConnection;
    //   57: astore_2
    //   58: aload_2
    //   59: ifnonnull +15 -> 74
    //   62: aload_0
    //   63: iconst_1
    //   64: putfield 61	crittercism/android/g:g	Z
    //   67: ldc_w 262
    //   70: invokestatic 198	crittercism/android/dx:b	(Ljava/lang/String;)V
    //   73: return
    //   74: aload_0
    //   75: getfield 63	crittercism/android/g:h	Ljava/lang/Object;
    //   78: astore_3
    //   79: aload_3
    //   80: monitorenter
    //   81: aload_0
    //   82: getfield 40	crittercism/android/g:a	Ljava/util/List;
    //   85: astore 4
    //   87: aload_0
    //   88: new 37	java/util/LinkedList
    //   91: dup
    //   92: invokespecial 38	java/util/LinkedList:<init>	()V
    //   95: putfield 40	crittercism/android/g:a	Ljava/util/List;
    //   98: aload_0
    //   99: getfield 57	crittercism/android/g:d	Landroid/os/ConditionVariable;
    //   102: invokevirtual 265	android/os/ConditionVariable:close	()V
    //   105: aload_3
    //   106: monitorexit
    //   107: aload_0
    //   108: getfield 71	crittercism/android/g:e	Lcrittercism/android/au;
    //   111: aload 4
    //   113: invokestatic 270	crittercism/android/a:a	(Lcrittercism/android/au;Ljava/util/List;)Lcrittercism/android/a;
    //   116: astore_3
    //   117: aload_3
    //   118: ifnonnull +46 -> 164
    //   121: aload_0
    //   122: iconst_1
    //   123: putfield 61	crittercism/android/g:g	Z
    //   126: ldc_w 272
    //   129: invokestatic 198	crittercism/android/dx:b	(Ljava/lang/String;)V
    //   132: return
    //   133: astore_2
    //   134: ldc_w 274
    //   137: new 111	java/lang/StringBuilder
    //   140: dup
    //   141: ldc_w 276
    //   144: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   147: aload_2
    //   148: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 284	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   157: pop
    //   158: return
    //   159: astore_2
    //   160: aload_3
    //   161: monitorexit
    //   162: aload_2
    //   163: athrow
    //   164: aload_2
    //   165: aload_3
    //   166: getfield 287	crittercism/android/a:a	Lorg/json/JSONObject;
    //   169: invokestatic 289	crittercism/android/g:a	(Ljava/net/HttpURLConnection;Lorg/json/JSONObject;)Z
    //   172: pop
    //   173: goto -173 -> 0
    //   176: astore_2
    //   177: goto -131 -> 46
    //   180: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	g
    //   25	2	1	bool	boolean
    //   57	2	2	localHttpURLConnection1	HttpURLConnection
    //   133	15	2	localException	Exception
    //   159	6	2	localHttpURLConnection2	HttpURLConnection
    //   176	1	2	localInterruptedException	InterruptedException
    //   85	27	4	localList	List
    // Exception table:
    //   from	to	target	type
    //   0	26	133	java/lang/Exception
    //   30	46	133	java/lang/Exception
    //   46	58	133	java/lang/Exception
    //   62	73	133	java/lang/Exception
    //   74	81	133	java/lang/Exception
    //   107	117	133	java/lang/Exception
    //   121	132	133	java/lang/Exception
    //   160	164	133	java/lang/Exception
    //   164	173	133	java/lang/Exception
    //   81	107	159	finally
    //   30	46	176	java/lang/InterruptedException
  }
}

/* Location:
 * Qualified Name:     crittercism.android.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */