package com.unity3d.player;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

class UnityWebRequest
  implements Runnable
{
  private static final String[] e = { "TLSv1.2", "TLSv1.1" };
  private static volatile SSLSocketFactory f;
  private long a;
  private String b;
  private String c;
  private Map d;
  
  UnityWebRequest(long paramLong, String paramString1, Map paramMap, String paramString2)
  {
    a = paramLong;
    b = paramString2;
    c = paramString1;
    d = paramMap;
  }
  
  private static native void contentLengthCallback(long paramLong, int paramInt);
  
  private static native boolean downloadCallback(long paramLong, ByteBuffer paramByteBuffer, int paramInt);
  
  private static native void errorCallback(long paramLong, int paramInt, String paramString);
  
  private static SSLSocketFactory getSSLSocketFactory()
  {
    if (q.g) {
      return null;
    }
    if (f != null) {
      return f;
    }
    synchronized (e)
    {
      String[] arrayOfString2 = e;
      int j = arrayOfString2.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString2[i];
        try
        {
          Object localObject2 = SSLContext.getInstance(str);
          ((SSLContext)localObject2).init(null, null, null);
          localObject2 = ((SSLContext)localObject2).getSocketFactory();
          f = (SSLSocketFactory)localObject2;
          return (SSLSocketFactory)localObject2;
        }
        catch (Exception localException)
        {
          m.Log(5, "UnityWebRequest: No support for " + str + " (" + localException.getMessage() + ")");
          i += 1;
        }
      }
      return null;
    }
  }
  
  private static native void headerCallback(long paramLong, String paramString1, String paramString2);
  
  private static native void responseCodeCallback(long paramLong, int paramInt);
  
  private static native int uploadCallback(long paramLong, ByteBuffer paramByteBuffer);
  
  protected void badProtocolCallback(String paramString)
  {
    errorCallback(a, 4, paramString);
  }
  
  protected void contentLengthCallback(int paramInt)
  {
    contentLengthCallback(a, paramInt);
  }
  
  protected boolean downloadCallback(ByteBuffer paramByteBuffer, int paramInt)
  {
    return downloadCallback(a, paramByteBuffer, paramInt);
  }
  
  protected void errorCallback(String paramString)
  {
    errorCallback(a, 2, paramString);
  }
  
  protected void headerCallback(String paramString1, String paramString2)
  {
    headerCallback(a, paramString1, paramString2);
  }
  
  protected void headerCallback(Map paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {
      return;
    }
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject = (String)localEntry.getKey();
      paramMap = (Map)localObject;
      if (localObject == null) {
        paramMap = "Status";
      }
      localObject = ((List)localEntry.getValue()).iterator();
      while (((Iterator)localObject).hasNext()) {
        headerCallback(paramMap, (String)((Iterator)localObject).next());
      }
    }
  }
  
  protected void malformattedUrlCallback(String paramString)
  {
    errorCallback(a, 5, paramString);
  }
  
  protected void responseCodeCallback(int paramInt)
  {
    responseCodeCallback(a, paramInt);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 174	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: getfield 36	com/unity3d/player/UnityWebRequest:b	Ljava/lang/String;
    //   8: invokespecial 175	java/net/URL:<init>	(Ljava/lang/String;)V
    //   11: astore_2
    //   12: aload_2
    //   13: invokevirtual 179	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   16: astore 4
    //   18: aload 4
    //   20: instanceof 181
    //   23: ifeq +20 -> 43
    //   26: invokestatic 183	com/unity3d/player/UnityWebRequest:getSSLSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   29: astore_3
    //   30: aload_3
    //   31: ifnull +12 -> 43
    //   34: aload 4
    //   36: checkcast 181	javax/net/ssl/HttpsURLConnection
    //   39: aload_3
    //   40: invokevirtual 187	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   43: aload_2
    //   44: invokevirtual 190	java/net/URL:getProtocol	()Ljava/lang/String;
    //   47: ldc -64
    //   49: invokevirtual 196	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   52: ifeq +40 -> 92
    //   55: aload_2
    //   56: invokevirtual 199	java/net/URL:getHost	()Ljava/lang/String;
    //   59: invokevirtual 202	java/lang/String:isEmpty	()Z
    //   62: ifne +30 -> 92
    //   65: aload_0
    //   66: ldc -52
    //   68: invokevirtual 206	com/unity3d/player/UnityWebRequest:malformattedUrlCallback	(Ljava/lang/String;)V
    //   71: return
    //   72: astore_2
    //   73: aload_0
    //   74: aload_2
    //   75: invokevirtual 207	java/net/MalformedURLException:toString	()Ljava/lang/String;
    //   78: invokevirtual 206	com/unity3d/player/UnityWebRequest:malformattedUrlCallback	(Ljava/lang/String;)V
    //   81: return
    //   82: astore_2
    //   83: aload_0
    //   84: aload_2
    //   85: invokevirtual 208	java/io/IOException:toString	()Ljava/lang/String;
    //   88: invokevirtual 210	com/unity3d/player/UnityWebRequest:errorCallback	(Ljava/lang/String;)V
    //   91: return
    //   92: aload 4
    //   94: instanceof 212
    //   97: ifeq +10 -> 107
    //   100: aload_0
    //   101: ldc -42
    //   103: invokevirtual 216	com/unity3d/player/UnityWebRequest:badProtocolCallback	(Ljava/lang/String;)V
    //   106: return
    //   107: aload 4
    //   109: instanceof 218
    //   112: ifeq +22 -> 134
    //   115: aload 4
    //   117: checkcast 218	java/net/HttpURLConnection
    //   120: astore_3
    //   121: aload_3
    //   122: aload_0
    //   123: getfield 38	com/unity3d/player/UnityWebRequest:c	Ljava/lang/String;
    //   126: invokevirtual 221	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   129: aload_3
    //   130: iconst_0
    //   131: invokevirtual 225	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   134: aload_0
    //   135: getfield 40	com/unity3d/player/UnityWebRequest:d	Ljava/util/Map;
    //   138: ifnull +76 -> 214
    //   141: aload_0
    //   142: getfield 40	com/unity3d/player/UnityWebRequest:d	Ljava/util/Map;
    //   145: invokeinterface 127 1 0
    //   150: invokeinterface 133 1 0
    //   155: astore_3
    //   156: aload_3
    //   157: invokeinterface 139 1 0
    //   162: ifeq +52 -> 214
    //   165: aload_3
    //   166: invokeinterface 143 1 0
    //   171: checkcast 145	java/util/Map$Entry
    //   174: astore 5
    //   176: aload 4
    //   178: aload 5
    //   180: invokeinterface 148 1 0
    //   185: checkcast 21	java/lang/String
    //   188: aload 5
    //   190: invokeinterface 153 1 0
    //   195: checkcast 21	java/lang/String
    //   198: invokevirtual 230	java/net/URLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: goto -45 -> 156
    //   204: astore_2
    //   205: aload_0
    //   206: aload_2
    //   207: invokevirtual 231	java/net/ProtocolException:toString	()Ljava/lang/String;
    //   210: invokevirtual 216	com/unity3d/player/UnityWebRequest:badProtocolCallback	(Ljava/lang/String;)V
    //   213: return
    //   214: aload_0
    //   215: aconst_null
    //   216: invokevirtual 234	com/unity3d/player/UnityWebRequest:uploadCallback	(Ljava/nio/ByteBuffer;)I
    //   219: istore_1
    //   220: iload_1
    //   221: ifle +70 -> 291
    //   224: aload 4
    //   226: iconst_1
    //   227: invokevirtual 237	java/net/URLConnection:setDoOutput	(Z)V
    //   230: iload_1
    //   231: sipush 1428
    //   234: invokestatic 243	java/lang/Math:min	(II)I
    //   237: invokestatic 249	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   240: astore_3
    //   241: aload 4
    //   243: invokevirtual 253	java/net/URLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   246: astore 5
    //   248: aload_0
    //   249: aload_3
    //   250: invokevirtual 234	com/unity3d/player/UnityWebRequest:uploadCallback	(Ljava/nio/ByteBuffer;)I
    //   253: istore_1
    //   254: iload_1
    //   255: ifle +36 -> 291
    //   258: aload 5
    //   260: aload_3
    //   261: invokevirtual 257	java/nio/ByteBuffer:array	()[B
    //   264: aload_3
    //   265: invokevirtual 260	java/nio/ByteBuffer:arrayOffset	()I
    //   268: iload_1
    //   269: invokevirtual 266	java/io/OutputStream:write	([BII)V
    //   272: aload_0
    //   273: aload_3
    //   274: invokevirtual 234	com/unity3d/player/UnityWebRequest:uploadCallback	(Ljava/nio/ByteBuffer;)I
    //   277: istore_1
    //   278: goto -24 -> 254
    //   281: astore_2
    //   282: aload_0
    //   283: aload_2
    //   284: invokevirtual 267	java/lang/Exception:toString	()Ljava/lang/String;
    //   287: invokevirtual 210	com/unity3d/player/UnityWebRequest:errorCallback	(Ljava/lang/String;)V
    //   290: return
    //   291: aload 4
    //   293: instanceof 218
    //   296: ifeq +17 -> 313
    //   299: aload 4
    //   301: checkcast 218	java/net/HttpURLConnection
    //   304: astore_3
    //   305: aload_0
    //   306: aload_3
    //   307: invokevirtual 270	java/net/HttpURLConnection:getResponseCode	()I
    //   310: invokevirtual 272	com/unity3d/player/UnityWebRequest:responseCodeCallback	(I)V
    //   313: aload 4
    //   315: invokevirtual 276	java/net/URLConnection:getHeaderFields	()Ljava/util/Map;
    //   318: astore_3
    //   319: aload_0
    //   320: aload_3
    //   321: invokevirtual 278	com/unity3d/player/UnityWebRequest:headerCallback	(Ljava/util/Map;)V
    //   324: aload_3
    //   325: ifnull +15 -> 340
    //   328: aload_3
    //   329: ldc_w 280
    //   332: invokeinterface 284 2 0
    //   337: ifne +27 -> 364
    //   340: aload 4
    //   342: invokevirtual 287	java/net/URLConnection:getContentLength	()I
    //   345: iconst_m1
    //   346: if_icmpeq +18 -> 364
    //   349: aload_0
    //   350: ldc_w 280
    //   353: aload 4
    //   355: invokevirtual 287	java/net/URLConnection:getContentLength	()I
    //   358: invokestatic 291	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   361: invokevirtual 158	com/unity3d/player/UnityWebRequest:headerCallback	(Ljava/lang/String;Ljava/lang/String;)V
    //   364: aload_3
    //   365: ifnull +15 -> 380
    //   368: aload_3
    //   369: ldc_w 293
    //   372: invokeinterface 284 2 0
    //   377: ifne +23 -> 400
    //   380: aload 4
    //   382: invokevirtual 296	java/net/URLConnection:getContentType	()Ljava/lang/String;
    //   385: ifnull +15 -> 400
    //   388: aload_0
    //   389: ldc_w 293
    //   392: aload 4
    //   394: invokevirtual 296	java/net/URLConnection:getContentType	()Ljava/lang/String;
    //   397: invokevirtual 158	com/unity3d/player/UnityWebRequest:headerCallback	(Ljava/lang/String;Ljava/lang/String;)V
    //   400: aload 4
    //   402: invokevirtual 287	java/net/URLConnection:getContentLength	()I
    //   405: istore_1
    //   406: iload_1
    //   407: ifle +8 -> 415
    //   410: aload_0
    //   411: iload_1
    //   412: invokevirtual 298	com/unity3d/player/UnityWebRequest:contentLengthCallback	(I)V
    //   415: aload_2
    //   416: invokevirtual 190	java/net/URL:getProtocol	()Ljava/lang/String;
    //   419: ldc -64
    //   421: invokevirtual 196	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   424: ifeq +173 -> 597
    //   427: iload_1
    //   428: ifne +116 -> 544
    //   431: ldc_w 299
    //   434: istore_1
    //   435: aload 4
    //   437: instanceof 218
    //   440: ifeq +152 -> 592
    //   443: aload 4
    //   445: checkcast 218	java/net/HttpURLConnection
    //   448: astore_2
    //   449: aload_0
    //   450: aload_2
    //   451: invokevirtual 270	java/net/HttpURLConnection:getResponseCode	()I
    //   454: invokevirtual 272	com/unity3d/player/UnityWebRequest:responseCodeCallback	(I)V
    //   457: aload_2
    //   458: invokevirtual 303	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   461: astore_2
    //   462: aload_2
    //   463: astore_3
    //   464: aload_2
    //   465: ifnonnull +9 -> 474
    //   468: aload 4
    //   470: invokevirtual 306	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   473: astore_3
    //   474: aload_3
    //   475: invokestatic 312	java/nio/channels/Channels:newChannel	(Ljava/io/InputStream;)Ljava/nio/channels/ReadableByteChannel;
    //   478: astore_2
    //   479: iload_1
    //   480: invokestatic 249	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   483: astore_3
    //   484: aload_2
    //   485: aload_3
    //   486: invokeinterface 317 2 0
    //   491: istore_1
    //   492: iload_1
    //   493: iconst_m1
    //   494: if_icmpeq +61 -> 555
    //   497: aload_0
    //   498: aload_3
    //   499: iload_1
    //   500: invokevirtual 319	com/unity3d/player/UnityWebRequest:downloadCallback	(Ljava/nio/ByteBuffer;I)Z
    //   503: ifeq +52 -> 555
    //   506: aload_3
    //   507: invokevirtual 323	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   510: pop
    //   511: aload_2
    //   512: aload_3
    //   513: invokeinterface 317 2 0
    //   518: istore_1
    //   519: goto -27 -> 492
    //   522: astore_3
    //   523: aload_0
    //   524: aload_3
    //   525: invokevirtual 324	java/net/UnknownHostException:toString	()Ljava/lang/String;
    //   528: invokevirtual 327	com/unity3d/player/UnityWebRequest:unknownHostCallback	(Ljava/lang/String;)V
    //   531: goto -218 -> 313
    //   534: astore_2
    //   535: aload_0
    //   536: aload_2
    //   537: invokevirtual 208	java/io/IOException:toString	()Ljava/lang/String;
    //   540: invokevirtual 210	com/unity3d/player/UnityWebRequest:errorCallback	(Ljava/lang/String;)V
    //   543: return
    //   544: iload_1
    //   545: ldc_w 299
    //   548: invokestatic 243	java/lang/Math:min	(II)I
    //   551: istore_1
    //   552: goto -117 -> 435
    //   555: aload_2
    //   556: invokeinterface 330 1 0
    //   561: return
    //   562: astore_2
    //   563: aload_0
    //   564: aload_2
    //   565: invokevirtual 324	java/net/UnknownHostException:toString	()Ljava/lang/String;
    //   568: invokevirtual 327	com/unity3d/player/UnityWebRequest:unknownHostCallback	(Ljava/lang/String;)V
    //   571: return
    //   572: astore_2
    //   573: aload_0
    //   574: aload_2
    //   575: invokevirtual 331	javax/net/ssl/SSLHandshakeException:toString	()Ljava/lang/String;
    //   578: invokevirtual 334	com/unity3d/player/UnityWebRequest:sslCannotConnectCallback	(Ljava/lang/String;)V
    //   581: return
    //   582: astore_2
    //   583: aload_0
    //   584: aload_2
    //   585: invokevirtual 267	java/lang/Exception:toString	()Ljava/lang/String;
    //   588: invokevirtual 210	com/unity3d/player/UnityWebRequest:errorCallback	(Ljava/lang/String;)V
    //   591: return
    //   592: aconst_null
    //   593: astore_2
    //   594: goto -132 -> 462
    //   597: sipush 1428
    //   600: istore_1
    //   601: goto -166 -> 435
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	604	0	this	UnityWebRequest
    //   219	382	1	i	int
    //   11	45	2	localURL	java.net.URL
    //   72	3	2	localMalformedURLException	java.net.MalformedURLException
    //   82	3	2	localIOException1	java.io.IOException
    //   204	3	2	localProtocolException	java.net.ProtocolException
    //   281	135	2	localException1	Exception
    //   448	64	2	localObject1	Object
    //   534	22	2	localIOException2	java.io.IOException
    //   562	3	2	localUnknownHostException1	java.net.UnknownHostException
    //   572	3	2	localSSLHandshakeException	javax.net.ssl.SSLHandshakeException
    //   582	3	2	localException2	Exception
    //   593	1	2	localObject2	Object
    //   29	484	3	localObject3	Object
    //   522	3	3	localUnknownHostException2	java.net.UnknownHostException
    //   16	453	4	localURLConnection	java.net.URLConnection
    //   174	85	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   0	30	72	java/net/MalformedURLException
    //   34	43	72	java/net/MalformedURLException
    //   0	30	82	java/io/IOException
    //   34	43	82	java/io/IOException
    //   115	134	204	java/net/ProtocolException
    //   230	254	281	java/lang/Exception
    //   258	278	281	java/lang/Exception
    //   305	313	522	java/net/UnknownHostException
    //   305	313	534	java/io/IOException
    //   435	462	562	java/net/UnknownHostException
    //   468	474	562	java/net/UnknownHostException
    //   474	492	562	java/net/UnknownHostException
    //   497	519	562	java/net/UnknownHostException
    //   555	561	562	java/net/UnknownHostException
    //   435	462	572	javax/net/ssl/SSLHandshakeException
    //   468	474	572	javax/net/ssl/SSLHandshakeException
    //   474	492	572	javax/net/ssl/SSLHandshakeException
    //   497	519	572	javax/net/ssl/SSLHandshakeException
    //   555	561	572	javax/net/ssl/SSLHandshakeException
    //   435	462	582	java/lang/Exception
    //   468	474	582	java/lang/Exception
    //   474	492	582	java/lang/Exception
    //   497	519	582	java/lang/Exception
    //   555	561	582	java/lang/Exception
  }
  
  protected void sslCannotConnectCallback(String paramString)
  {
    errorCallback(a, 16, paramString);
  }
  
  protected void unknownHostCallback(String paramString)
  {
    errorCallback(a, 7, paramString);
  }
  
  protected int uploadCallback(ByteBuffer paramByteBuffer)
  {
    return uploadCallback(a, paramByteBuffer);
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.UnityWebRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */