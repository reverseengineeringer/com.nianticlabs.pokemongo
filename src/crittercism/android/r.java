package crittercism.android;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Permission;
import java.util.Map;

public final class r
  extends HttpURLConnection
{
  private e a;
  private HttpURLConnection b;
  private c c;
  private d d;
  private boolean e = false;
  private boolean f = false;
  
  public r(HttpURLConnection paramHttpURLConnection, e parame, d paramd)
  {
    super(paramHttpURLConnection.getURL());
    b = paramHttpURLConnection;
    a = parame;
    d = paramd;
    c = new c(paramHttpURLConnection.getURL());
  }
  
  private void a()
  {
    try
    {
      if (!f)
      {
        f = true;
        c.f = b.getRequestMethod();
        c.b();
        c.j = d.a();
        if (bc.b()) {
          c.a(bc.a());
        }
      }
      return;
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
  
  private void a(Throwable paramThrowable)
  {
    try
    {
      if (e) {
        return;
      }
      e = true;
      c.c();
      c.a(paramThrowable);
      a.a(c);
      return;
    }
    catch (ThreadDeath paramThrowable)
    {
      throw paramThrowable;
    }
    catch (Throwable localThrowable)
    {
      dx.a(paramThrowable);
    }
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_1
    //   4: aload_0
    //   5: getfield 26	crittercism/android/r:e	Z
    //   8: ifne +151 -> 159
    //   11: aload_0
    //   12: iconst_1
    //   13: putfield 26	crittercism/android/r:e	Z
    //   16: aload_0
    //   17: getfield 39	crittercism/android/r:c	Lcrittercism/android/c;
    //   20: invokevirtual 81	crittercism/android/c:c	()V
    //   23: aload_0
    //   24: getfield 30	crittercism/android/r:b	Ljava/net/HttpURLConnection;
    //   27: invokevirtual 93	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   30: ifnull +100 -> 130
    //   33: new 95	crittercism/android/p
    //   36: dup
    //   37: aload_0
    //   38: getfield 30	crittercism/android/r:b	Ljava/net/HttpURLConnection;
    //   41: invokevirtual 93	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   44: invokespecial 98	crittercism/android/p:<init>	(Ljava/util/Map;)V
    //   47: astore 7
    //   49: aload 7
    //   51: ldc 100
    //   53: invokevirtual 103	crittercism/android/p:b	(Ljava/lang/String;)I
    //   56: istore_2
    //   57: iload_2
    //   58: iconst_m1
    //   59: if_icmpeq +14 -> 73
    //   62: aload_0
    //   63: getfield 39	crittercism/android/r:c	Lcrittercism/android/c;
    //   66: iload_2
    //   67: i2l
    //   68: invokevirtual 106	crittercism/android/c:b	(J)V
    //   71: iconst_1
    //   72: istore_1
    //   73: aload 7
    //   75: ldc 108
    //   77: invokevirtual 111	crittercism/android/p:a	(Ljava/lang/String;)J
    //   80: lstore_3
    //   81: aload 7
    //   83: ldc 113
    //   85: invokevirtual 111	crittercism/android/p:a	(Ljava/lang/String;)J
    //   88: lstore 5
    //   90: iload_1
    //   91: istore_2
    //   92: lload_3
    //   93: ldc2_w 114
    //   96: lcmp
    //   97: ifeq +33 -> 130
    //   100: iload_1
    //   101: istore_2
    //   102: lload 5
    //   104: ldc2_w 114
    //   107: lcmp
    //   108: ifeq +22 -> 130
    //   111: aload_0
    //   112: getfield 39	crittercism/android/r:c	Lcrittercism/android/c;
    //   115: lload_3
    //   116: invokevirtual 117	crittercism/android/c:e	(J)V
    //   119: aload_0
    //   120: getfield 39	crittercism/android/r:c	Lcrittercism/android/c;
    //   123: lload 5
    //   125: invokevirtual 119	crittercism/android/c:f	(J)V
    //   128: iload_1
    //   129: istore_2
    //   130: aload_0
    //   131: getfield 39	crittercism/android/r:c	Lcrittercism/android/c;
    //   134: aload_0
    //   135: getfield 30	crittercism/android/r:b	Ljava/net/HttpURLConnection;
    //   138: invokevirtual 123	java/net/HttpURLConnection:getResponseCode	()I
    //   141: putfield 126	crittercism/android/c:e	I
    //   144: iload_2
    //   145: ifeq +14 -> 159
    //   148: aload_0
    //   149: getfield 32	crittercism/android/r:a	Lcrittercism/android/e;
    //   152: aload_0
    //   153: getfield 39	crittercism/android/r:c	Lcrittercism/android/c;
    //   156: invokevirtual 87	crittercism/android/e:a	(Lcrittercism/android/c;)V
    //   159: return
    //   160: astore 7
    //   162: aload 7
    //   164: athrow
    //   165: astore 7
    //   167: aload 7
    //   169: invokestatic 79	crittercism/android/dx:a	(Ljava/lang/Throwable;)V
    //   172: return
    //   173: astore 7
    //   175: goto -31 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	r
    //   3	126	1	i	int
    //   1	144	2	j	int
    //   80	36	3	l1	long
    //   88	36	5	l2	long
    //   47	35	7	localp	p
    //   160	3	7	localThreadDeath	ThreadDeath
    //   165	3	7	localThrowable	Throwable
    //   173	1	7	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   4	23	160	java/lang/ThreadDeath
    //   23	57	160	java/lang/ThreadDeath
    //   62	71	160	java/lang/ThreadDeath
    //   73	90	160	java/lang/ThreadDeath
    //   111	128	160	java/lang/ThreadDeath
    //   130	144	160	java/lang/ThreadDeath
    //   148	159	160	java/lang/ThreadDeath
    //   4	23	165	java/lang/Throwable
    //   23	57	165	java/lang/Throwable
    //   62	71	165	java/lang/Throwable
    //   73	90	165	java/lang/Throwable
    //   111	128	165	java/lang/Throwable
    //   130	144	165	java/lang/Throwable
    //   148	159	165	java/lang/Throwable
    //   130	144	173	java/io/IOException
  }
  
  public final void addRequestProperty(String paramString1, String paramString2)
  {
    b.addRequestProperty(paramString1, paramString2);
  }
  
  public final void connect()
  {
    b.connect();
  }
  
  public final void disconnect()
  {
    b.disconnect();
    try
    {
      if ((e) && (!c.b)) {
        a.a(c);
      }
      return;
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
  
  public final boolean equals(Object paramObject)
  {
    return b.equals(paramObject);
  }
  
  public final boolean getAllowUserInteraction()
  {
    return b.getAllowUserInteraction();
  }
  
  public final int getConnectTimeout()
  {
    return b.getConnectTimeout();
  }
  
  public final Object getContent()
  {
    a();
    try
    {
      Object localObject = b.getContent();
      b();
      return localObject;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      throw localIOException;
    }
  }
  
  public final Object getContent(Class[] paramArrayOfClass)
  {
    a();
    try
    {
      paramArrayOfClass = b.getContent(paramArrayOfClass);
      b();
      return paramArrayOfClass;
    }
    catch (IOException paramArrayOfClass)
    {
      a(paramArrayOfClass);
      throw paramArrayOfClass;
    }
  }
  
  public final String getContentEncoding()
  {
    a();
    String str = b.getContentEncoding();
    b();
    return str;
  }
  
  public final int getContentLength()
  {
    return b.getContentLength();
  }
  
  public final String getContentType()
  {
    a();
    String str = b.getContentType();
    b();
    return str;
  }
  
  public final long getDate()
  {
    return b.getDate();
  }
  
  public final boolean getDefaultUseCaches()
  {
    return b.getDefaultUseCaches();
  }
  
  public final boolean getDoInput()
  {
    return b.getDoInput();
  }
  
  public final boolean getDoOutput()
  {
    return b.getDoOutput();
  }
  
  public final InputStream getErrorStream()
  {
    a();
    InputStream localInputStream = b.getErrorStream();
    b();
    if (localInputStream != null) {
      try
      {
        t localt = new t(localInputStream, a, c);
        return localt;
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
    return localThreadDeath;
  }
  
  public final long getExpiration()
  {
    return b.getExpiration();
  }
  
  public final String getHeaderField(int paramInt)
  {
    a();
    String str = b.getHeaderField(paramInt);
    b();
    return str;
  }
  
  public final String getHeaderField(String paramString)
  {
    a();
    paramString = b.getHeaderField(paramString);
    b();
    return paramString;
  }
  
  public final long getHeaderFieldDate(String paramString, long paramLong)
  {
    a();
    paramLong = b.getHeaderFieldDate(paramString, paramLong);
    b();
    return paramLong;
  }
  
  public final int getHeaderFieldInt(String paramString, int paramInt)
  {
    a();
    paramInt = b.getHeaderFieldInt(paramString, paramInt);
    b();
    return paramInt;
  }
  
  public final String getHeaderFieldKey(int paramInt)
  {
    a();
    String str = b.getHeaderFieldKey(paramInt);
    b();
    return str;
  }
  
  public final Map getHeaderFields()
  {
    a();
    Map localMap = b.getHeaderFields();
    b();
    return localMap;
  }
  
  public final long getIfModifiedSince()
  {
    return b.getIfModifiedSince();
  }
  
  /* Error */
  public final InputStream getInputStream()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 154	crittercism/android/r:a	()V
    //   4: aload_0
    //   5: getfield 30	crittercism/android/r:b	Ljava/net/HttpURLConnection;
    //   8: invokevirtual 219	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   11: astore_1
    //   12: aload_0
    //   13: invokespecial 157	crittercism/android/r:b	()V
    //   16: aload_1
    //   17: ifnull +38 -> 55
    //   20: new 189	crittercism/android/t
    //   23: dup
    //   24: aload_1
    //   25: aload_0
    //   26: getfield 32	crittercism/android/r:a	Lcrittercism/android/e;
    //   29: aload_0
    //   30: getfield 39	crittercism/android/r:c	Lcrittercism/android/c;
    //   33: invokespecial 192	crittercism/android/t:<init>	(Ljava/io/InputStream;Lcrittercism/android/e;Lcrittercism/android/c;)V
    //   36: astore_2
    //   37: aload_2
    //   38: areturn
    //   39: astore_1
    //   40: aload_0
    //   41: aload_1
    //   42: invokespecial 158	crittercism/android/r:a	(Ljava/lang/Throwable;)V
    //   45: aload_1
    //   46: athrow
    //   47: astore_1
    //   48: aload_1
    //   49: athrow
    //   50: astore_2
    //   51: aload_2
    //   52: invokestatic 79	crittercism/android/dx:a	(Ljava/lang/Throwable;)V
    //   55: aload_1
    //   56: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	r
    //   11	14	1	localInputStream	InputStream
    //   39	7	1	localIOException	IOException
    //   47	9	1	localThreadDeath	ThreadDeath
    //   36	2	2	localt	t
    //   50	2	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   4	16	39	java/io/IOException
    //   20	37	47	java/lang/ThreadDeath
    //   20	37	50	java/lang/Throwable
  }
  
  public final boolean getInstanceFollowRedirects()
  {
    return b.getInstanceFollowRedirects();
  }
  
  public final long getLastModified()
  {
    return b.getLastModified();
  }
  
  public final OutputStream getOutputStream()
  {
    OutputStream localOutputStream = b.getOutputStream();
    if (localOutputStream != null) {
      try
      {
        u localu = new u(localOutputStream, c);
        return localu;
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
    return localThreadDeath;
  }
  
  public final Permission getPermission()
  {
    return b.getPermission();
  }
  
  public final int getReadTimeout()
  {
    return b.getReadTimeout();
  }
  
  public final String getRequestMethod()
  {
    return b.getRequestMethod();
  }
  
  public final Map getRequestProperties()
  {
    return b.getRequestProperties();
  }
  
  public final String getRequestProperty(String paramString)
  {
    return b.getRequestProperty(paramString);
  }
  
  public final int getResponseCode()
  {
    a();
    try
    {
      int i = b.getResponseCode();
      b();
      return i;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      throw localIOException;
    }
  }
  
  public final String getResponseMessage()
  {
    a();
    try
    {
      String str = b.getResponseMessage();
      b();
      return str;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      throw localIOException;
    }
  }
  
  public final URL getURL()
  {
    return b.getURL();
  }
  
  public final boolean getUseCaches()
  {
    return b.getUseCaches();
  }
  
  public final int hashCode()
  {
    return b.hashCode();
  }
  
  public final void setAllowUserInteraction(boolean paramBoolean)
  {
    b.setAllowUserInteraction(paramBoolean);
  }
  
  public final void setChunkedStreamingMode(int paramInt)
  {
    b.setChunkedStreamingMode(paramInt);
  }
  
  public final void setConnectTimeout(int paramInt)
  {
    b.setConnectTimeout(paramInt);
  }
  
  public final void setDefaultUseCaches(boolean paramBoolean)
  {
    b.setDefaultUseCaches(paramBoolean);
  }
  
  public final void setDoInput(boolean paramBoolean)
  {
    b.setDoInput(paramBoolean);
  }
  
  public final void setDoOutput(boolean paramBoolean)
  {
    b.setDoOutput(paramBoolean);
  }
  
  public final void setFixedLengthStreamingMode(int paramInt)
  {
    b.setFixedLengthStreamingMode(paramInt);
  }
  
  public final void setIfModifiedSince(long paramLong)
  {
    b.setIfModifiedSince(paramLong);
  }
  
  public final void setInstanceFollowRedirects(boolean paramBoolean)
  {
    b.setInstanceFollowRedirects(paramBoolean);
  }
  
  public final void setReadTimeout(int paramInt)
  {
    b.setReadTimeout(paramInt);
  }
  
  public final void setRequestMethod(String paramString)
  {
    b.setRequestMethod(paramString);
  }
  
  public final void setRequestProperty(String paramString1, String paramString2)
  {
    b.setRequestProperty(paramString1, paramString2);
  }
  
  public final void setUseCaches(boolean paramBoolean)
  {
    b.setUseCaches(paramBoolean);
  }
  
  public final String toString()
  {
    return b.toString();
  }
  
  public final boolean usingProxy()
  {
    return b.usingProxy();
  }
}

/* Location:
 * Qualified Name:     crittercism.android.r
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */