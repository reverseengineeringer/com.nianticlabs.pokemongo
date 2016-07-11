package com.nianticlabs.nia.network;

import android.util.Log;
import java.net.HttpURLConnection;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NiaNet
{
  private static final int CHUNK_SIZE = 32768;
  private static final int HTTP_BAD_REQUEST = 400;
  private static final int HTTP_OK = 200;
  private static final String IF_MODIFIED_SINCE = "If-Modified-Since";
  private static final int METHOD_DELETE = 4;
  private static final int METHOD_GET = 0;
  private static final int METHOD_HEAD = 1;
  private static final int METHOD_OPTIONS = 5;
  private static final int METHOD_POST = 2;
  private static final int METHOD_PUT = 3;
  private static final int METHOD_TRACE = 6;
  private static final int NETWORK_TIMEOUT_MS = 15000;
  private static final int POOL_THREAD_NUM = 6;
  private static final String TAG = "NiaNet";
  private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(6, 12, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  private static Set<Integer> pendingRequestIds = new HashSet();
  static ThreadLocal<ByteBuffer> readBuffer = new ThreadLocal()
  {
    protected ByteBuffer initialValue()
    {
      return ByteBuffer.allocateDirect(32768);
    }
  };
  private static final ThreadLocal<byte[]> threadChunk = new ThreadLocal()
  {
    protected byte[] initialValue()
    {
      return new byte[32768];
    }
  };
  
  public static void cancel(int paramInt)
  {
    synchronized (pendingRequestIds)
    {
      pendingRequestIds.remove(Integer.valueOf(paramInt));
      return;
    }
  }
  
  /* Error */
  private static void doSyncRequest(long paramLong, int paramInt1, String paramString1, int paramInt2, String paramString2, ByteBuffer paramByteBuffer, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: getstatic 78	com/nianticlabs/nia/network/NiaNet:pendingRequestIds	Ljava/util/Set;
    //   3: astore 10
    //   5: aload 10
    //   7: monitorenter
    //   8: getstatic 78	com/nianticlabs/nia/network/NiaNet:pendingRequestIds	Ljava/util/Set;
    //   11: iload_2
    //   12: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   15: invokeinterface 110 2 0
    //   20: ifne +569 -> 589
    //   23: iconst_1
    //   24: istore 9
    //   26: iload 9
    //   28: ifeq +7 -> 35
    //   31: aload 10
    //   33: monitorexit
    //   34: return
    //   35: getstatic 78	com/nianticlabs/nia/network/NiaNet:pendingRequestIds	Ljava/util/Set;
    //   38: iload_2
    //   39: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   42: invokeinterface 105 2 0
    //   47: pop
    //   48: aload 10
    //   50: monitorexit
    //   51: aconst_null
    //   52: astore 12
    //   54: aconst_null
    //   55: astore 11
    //   57: sipush 400
    //   60: istore 9
    //   62: aconst_null
    //   63: astore 13
    //   65: iload 9
    //   67: istore_2
    //   68: aload 13
    //   70: astore 10
    //   72: new 112	java/net/URL
    //   75: dup
    //   76: aload_3
    //   77: invokespecial 115	java/net/URL:<init>	(Ljava/lang/String;)V
    //   80: invokevirtual 119	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   83: checkcast 121	java/net/HttpURLConnection
    //   86: checkcast 121	java/net/HttpURLConnection
    //   89: astore_3
    //   90: iload 9
    //   92: istore_2
    //   93: aload 13
    //   95: astore 10
    //   97: aload_3
    //   98: astore 11
    //   100: aload_3
    //   101: astore 12
    //   103: aload_3
    //   104: aload 5
    //   106: invokestatic 125	com/nianticlabs/nia/network/NiaNet:setHeaders	(Ljava/net/HttpURLConnection;Ljava/lang/String;)V
    //   109: iload 9
    //   111: istore_2
    //   112: aload 13
    //   114: astore 10
    //   116: aload_3
    //   117: astore 11
    //   119: aload_3
    //   120: astore 12
    //   122: aload_3
    //   123: sipush 15000
    //   126: invokevirtual 128	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   129: iload 9
    //   131: istore_2
    //   132: aload 13
    //   134: astore 10
    //   136: aload_3
    //   137: astore 11
    //   139: aload_3
    //   140: astore 12
    //   142: aload_3
    //   143: ldc -126
    //   145: ldc -124
    //   147: invokevirtual 136	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: iload 9
    //   152: istore_2
    //   153: aload 13
    //   155: astore 10
    //   157: aload_3
    //   158: astore 11
    //   160: aload_3
    //   161: astore 12
    //   163: iconst_0
    //   164: invokestatic 140	java/net/HttpURLConnection:setFollowRedirects	(Z)V
    //   167: iload 9
    //   169: istore_2
    //   170: aload 13
    //   172: astore 10
    //   174: aload_3
    //   175: astore 11
    //   177: aload_3
    //   178: astore 12
    //   180: aload_3
    //   181: iload 4
    //   183: invokestatic 144	com/nianticlabs/nia/network/NiaNet:getMethodString	(I)Ljava/lang/String;
    //   186: invokevirtual 147	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   189: aload 6
    //   191: ifnull +91 -> 282
    //   194: iload 8
    //   196: ifle +86 -> 282
    //   199: iload 9
    //   201: istore_2
    //   202: aload 13
    //   204: astore 10
    //   206: aload_3
    //   207: astore 11
    //   209: aload_3
    //   210: astore 12
    //   212: aload_3
    //   213: iconst_1
    //   214: invokevirtual 150	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   217: iload 9
    //   219: istore_2
    //   220: aload 13
    //   222: astore 10
    //   224: aload_3
    //   225: astore 11
    //   227: aload_3
    //   228: astore 12
    //   230: aload_3
    //   231: invokevirtual 154	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   234: astore 5
    //   236: aload 6
    //   238: invokevirtual 160	java/nio/ByteBuffer:hasArray	()Z
    //   241: ifeq +163 -> 404
    //   244: aload 5
    //   246: aload 6
    //   248: invokevirtual 164	java/nio/ByteBuffer:array	()[B
    //   251: aload 6
    //   253: invokevirtual 168	java/nio/ByteBuffer:arrayOffset	()I
    //   256: iload 7
    //   258: iadd
    //   259: iload 8
    //   261: invokevirtual 174	java/io/OutputStream:write	([BII)V
    //   264: iload 9
    //   266: istore_2
    //   267: aload 13
    //   269: astore 10
    //   271: aload_3
    //   272: astore 11
    //   274: aload_3
    //   275: astore 12
    //   277: aload 5
    //   279: invokevirtual 177	java/io/OutputStream:close	()V
    //   282: iload 9
    //   284: istore_2
    //   285: aload 13
    //   287: astore 10
    //   289: aload_3
    //   290: astore 11
    //   292: aload_3
    //   293: astore 12
    //   295: aload_3
    //   296: invokevirtual 180	java/net/HttpURLConnection:getResponseCode	()I
    //   299: istore 4
    //   301: iload 4
    //   303: istore_2
    //   304: aload 13
    //   306: astore 10
    //   308: aload_3
    //   309: astore 11
    //   311: aload_3
    //   312: astore 12
    //   314: aload_3
    //   315: invokestatic 184	com/nianticlabs/nia/network/NiaNet:joinHeaders	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   318: astore 5
    //   320: iload 4
    //   322: istore_2
    //   323: aload 5
    //   325: astore 10
    //   327: aload_3
    //   328: astore 11
    //   330: aload_3
    //   331: astore 12
    //   333: aload_3
    //   334: invokestatic 188	com/nianticlabs/nia/network/NiaNet:readDataSteam	(Ljava/net/HttpURLConnection;)I
    //   337: istore 7
    //   339: iload 7
    //   341: istore_2
    //   342: iload 4
    //   344: istore 7
    //   346: aload 5
    //   348: astore 6
    //   350: iload_2
    //   351: istore 8
    //   353: aload_3
    //   354: ifnull +18 -> 372
    //   357: aload_3
    //   358: invokevirtual 191	java/net/HttpURLConnection:disconnect	()V
    //   361: iload_2
    //   362: istore 8
    //   364: aload 5
    //   366: astore 6
    //   368: iload 4
    //   370: istore 7
    //   372: iload 8
    //   374: ifle +203 -> 577
    //   377: lload_0
    //   378: iload 7
    //   380: aload 6
    //   382: getstatic 84	com/nianticlabs/nia/network/NiaNet:readBuffer	Ljava/lang/ThreadLocal;
    //   385: invokevirtual 197	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   388: checkcast 156	java/nio/ByteBuffer
    //   391: iconst_0
    //   392: iload 8
    //   394: invokestatic 201	com/nianticlabs/nia/network/NiaNet:nativeCallback	(JILjava/lang/String;Ljava/nio/ByteBuffer;II)V
    //   397: return
    //   398: astore_3
    //   399: aload 10
    //   401: monitorexit
    //   402: aload_3
    //   403: athrow
    //   404: getstatic 81	com/nianticlabs/nia/network/NiaNet:threadChunk	Ljava/lang/ThreadLocal;
    //   407: invokevirtual 197	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   410: checkcast 203	[B
    //   413: astore 10
    //   415: aload 6
    //   417: invokevirtual 206	java/nio/ByteBuffer:hasRemaining	()Z
    //   420: ifeq -156 -> 264
    //   423: aload 6
    //   425: invokevirtual 209	java/nio/ByteBuffer:remaining	()I
    //   428: aload 10
    //   430: arraylength
    //   431: invokestatic 215	java/lang/Math:min	(II)I
    //   434: istore_2
    //   435: aload 6
    //   437: aload 10
    //   439: iconst_0
    //   440: iload_2
    //   441: invokevirtual 218	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   444: pop
    //   445: aload 5
    //   447: aload 10
    //   449: iconst_0
    //   450: iload_2
    //   451: invokevirtual 174	java/io/OutputStream:write	([BII)V
    //   454: goto -39 -> 415
    //   457: astore 6
    //   459: iload 9
    //   461: istore_2
    //   462: aload 13
    //   464: astore 10
    //   466: aload_3
    //   467: astore 11
    //   469: aload_3
    //   470: astore 12
    //   472: aload 5
    //   474: invokevirtual 177	java/io/OutputStream:close	()V
    //   477: iload 9
    //   479: istore_2
    //   480: aload 13
    //   482: astore 10
    //   484: aload_3
    //   485: astore 11
    //   487: aload_3
    //   488: astore 12
    //   490: aload 6
    //   492: athrow
    //   493: astore_3
    //   494: aload 11
    //   496: astore 12
    //   498: ldc 41
    //   500: new 220	java/lang/StringBuilder
    //   503: dup
    //   504: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   507: ldc -33
    //   509: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: aload_3
    //   513: invokevirtual 231	java/io/IOException:getMessage	()Ljava/lang/String;
    //   516: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: invokestatic 240	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   525: pop
    //   526: iconst_0
    //   527: istore 4
    //   529: iload_2
    //   530: istore 7
    //   532: aload 10
    //   534: astore 6
    //   536: iload 4
    //   538: istore 8
    //   540: aload 11
    //   542: ifnull -170 -> 372
    //   545: aload 11
    //   547: invokevirtual 191	java/net/HttpURLConnection:disconnect	()V
    //   550: iload_2
    //   551: istore 7
    //   553: aload 10
    //   555: astore 6
    //   557: iload 4
    //   559: istore 8
    //   561: goto -189 -> 372
    //   564: astore_3
    //   565: aload 12
    //   567: ifnull +8 -> 575
    //   570: aload 12
    //   572: invokevirtual 191	java/net/HttpURLConnection:disconnect	()V
    //   575: aload_3
    //   576: athrow
    //   577: lload_0
    //   578: iload 7
    //   580: aload 6
    //   582: aconst_null
    //   583: iconst_0
    //   584: iconst_0
    //   585: invokestatic 201	com/nianticlabs/nia/network/NiaNet:nativeCallback	(JILjava/lang/String;Ljava/nio/ByteBuffer;II)V
    //   588: return
    //   589: iconst_0
    //   590: istore 9
    //   592: goto -566 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	595	0	paramLong	long
    //   0	595	2	paramInt1	int
    //   0	595	3	paramString1	String
    //   0	595	4	paramInt2	int
    //   0	595	5	paramString2	String
    //   0	595	6	paramByteBuffer	ByteBuffer
    //   0	595	7	paramInt3	int
    //   0	595	8	paramInt4	int
    //   24	567	9	i	int
    //   3	551	10	localObject1	Object
    //   55	491	11	str	String
    //   52	519	12	localObject2	Object
    //   63	418	13	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   8	23	398	finally
    //   31	34	398	finally
    //   35	51	398	finally
    //   399	402	398	finally
    //   236	264	457	finally
    //   404	415	457	finally
    //   415	454	457	finally
    //   72	90	493	java/io/IOException
    //   103	109	493	java/io/IOException
    //   122	129	493	java/io/IOException
    //   142	150	493	java/io/IOException
    //   163	167	493	java/io/IOException
    //   180	189	493	java/io/IOException
    //   212	217	493	java/io/IOException
    //   230	236	493	java/io/IOException
    //   277	282	493	java/io/IOException
    //   295	301	493	java/io/IOException
    //   314	320	493	java/io/IOException
    //   333	339	493	java/io/IOException
    //   472	477	493	java/io/IOException
    //   490	493	493	java/io/IOException
    //   72	90	564	finally
    //   103	109	564	finally
    //   122	129	564	finally
    //   142	150	564	finally
    //   163	167	564	finally
    //   180	189	564	finally
    //   212	217	564	finally
    //   230	236	564	finally
    //   277	282	564	finally
    //   295	301	564	finally
    //   314	320	564	finally
    //   333	339	564	finally
    //   472	477	564	finally
    //   490	493	564	finally
    //   498	526	564	finally
  }
  
  private static String getMethodString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      Log.e("NiaNet", "Unsupported HTTP method " + paramInt + ", using GET.");
      return "GET";
    case 0: 
      return "GET";
    case 1: 
      return "HEAD";
    case 2: 
      return "POST";
    case 3: 
      return "PUT";
    }
    return "DELETE";
  }
  
  private static String joinHeaders(HttpURLConnection paramHttpURLConnection)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    for (;;)
    {
      String str1 = paramHttpURLConnection.getHeaderFieldKey(i);
      if (str1 == null) {
        break;
      }
      String str2 = paramHttpURLConnection.getHeaderField(i);
      if (str2 == null) {
        break;
      }
      localStringBuilder.append(str1);
      localStringBuilder.append(": ");
      localStringBuilder.append(str2);
      localStringBuilder.append("\n");
      i += 1;
    }
    if (localStringBuilder.length() == 0) {
      return null;
    }
    return localStringBuilder.toString();
  }
  
  private static native void nativeCallback(long paramLong, int paramInt1, String paramString, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3);
  
  private static long parseHttpDateTime(String paramString)
    throws ParseException
  {
    return new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz").parse(paramString).getTime();
  }
  
  /* Error */
  private static int readDataSteam(HttpURLConnection paramHttpURLConnection)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 180	java/net/HttpURLConnection:getResponseCode	()I
    //   4: sipush 200
    //   7: if_icmpne +14 -> 21
    //   10: aload_0
    //   11: invokevirtual 294	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   14: astore_0
    //   15: aload_0
    //   16: ifnonnull +13 -> 29
    //   19: iconst_0
    //   20: ireturn
    //   21: aload_0
    //   22: invokevirtual 297	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   25: astore_0
    //   26: goto -11 -> 15
    //   29: getstatic 84	com/nianticlabs/nia/network/NiaNet:readBuffer	Ljava/lang/ThreadLocal;
    //   32: invokevirtual 197	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   35: checkcast 156	java/nio/ByteBuffer
    //   38: astore 8
    //   40: aload 8
    //   42: invokevirtual 164	java/nio/ByteBuffer:array	()[B
    //   45: astore 7
    //   47: aload 8
    //   49: invokevirtual 168	java/nio/ByteBuffer:arrayOffset	()I
    //   52: istore 5
    //   54: iload 5
    //   56: istore_1
    //   57: iconst_1
    //   58: istore_3
    //   59: aload_0
    //   60: invokevirtual 302	java/io/InputStream:available	()I
    //   63: istore 6
    //   65: iload 5
    //   67: istore 4
    //   69: aload 7
    //   71: astore 8
    //   73: iload_1
    //   74: istore_2
    //   75: aload 7
    //   77: arraylength
    //   78: iload 6
    //   80: iload_1
    //   81: iadd
    //   82: if_icmpgt +68 -> 150
    //   85: iload 6
    //   87: iload_1
    //   88: iadd
    //   89: iload 5
    //   91: isub
    //   92: iconst_2
    //   93: imul
    //   94: invokestatic 306	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   97: astore 9
    //   99: iload_1
    //   100: iload 5
    //   102: isub
    //   103: istore_2
    //   104: aload 9
    //   106: invokevirtual 168	java/nio/ByteBuffer:arrayOffset	()I
    //   109: istore_1
    //   110: iload_2
    //   111: ifle +17 -> 128
    //   114: aload 7
    //   116: iload 5
    //   118: aload 9
    //   120: invokevirtual 164	java/nio/ByteBuffer:array	()[B
    //   123: iload_1
    //   124: iload_2
    //   125: invokestatic 312	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   128: iload_1
    //   129: istore 4
    //   131: iload_2
    //   132: iload_1
    //   133: iadd
    //   134: istore_2
    //   135: aload 9
    //   137: invokevirtual 164	java/nio/ByteBuffer:array	()[B
    //   140: astore 8
    //   142: getstatic 84	com/nianticlabs/nia/network/NiaNet:readBuffer	Ljava/lang/ThreadLocal;
    //   145: aload 9
    //   147: invokevirtual 316	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   150: aload_0
    //   151: aload 8
    //   153: iload_2
    //   154: aload 8
    //   156: arraylength
    //   157: iload_2
    //   158: isub
    //   159: invokevirtual 320	java/io/InputStream:read	([BII)I
    //   162: istore_1
    //   163: iload_1
    //   164: iflt +37 -> 201
    //   167: iload_2
    //   168: iload_1
    //   169: iadd
    //   170: istore_2
    //   171: iload_3
    //   172: istore 6
    //   174: iload 4
    //   176: istore 5
    //   178: aload 8
    //   180: astore 7
    //   182: iload 6
    //   184: istore_3
    //   185: iload_2
    //   186: istore_1
    //   187: iload 6
    //   189: ifne -130 -> 59
    //   192: aload_0
    //   193: invokevirtual 321	java/io/InputStream:close	()V
    //   196: iload_2
    //   197: iload 4
    //   199: isub
    //   200: ireturn
    //   201: iconst_0
    //   202: istore 6
    //   204: goto -30 -> 174
    //   207: astore 7
    //   209: aload_0
    //   210: invokevirtual 321	java/io/InputStream:close	()V
    //   213: aload 7
    //   215: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	paramHttpURLConnection	HttpURLConnection
    //   56	131	1	i	int
    //   74	126	2	j	int
    //   58	127	3	k	int
    //   67	133	4	m	int
    //   52	125	5	n	int
    //   63	140	6	i1	int
    //   45	136	7	localObject1	Object
    //   207	7	7	localObject2	Object
    //   38	141	8	localObject3	Object
    //   97	49	9	localByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   40	54	207	finally
    //   59	65	207	finally
    //   75	99	207	finally
    //   104	110	207	finally
    //   114	128	207	finally
    //   135	150	207	finally
    //   150	163	207	finally
  }
  
  public static void request(long paramLong, int paramInt1, final String paramString1, final int paramInt2, final String paramString2, final ByteBuffer paramByteBuffer, final int paramInt3, final int paramInt4)
  {
    synchronized (pendingRequestIds)
    {
      pendingRequestIds.add(Integer.valueOf(paramInt1));
      executor.execute(new Runnable()
      {
        public void run()
        {
          NiaNet.doSyncRequest(val$object, paramString1, paramInt2, paramString2, paramByteBuffer, paramInt3, paramInt4, val$bodySize);
        }
      });
      return;
    }
  }
  
  private static void setHeaders(HttpURLConnection paramHttpURLConnection, String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      return;
    }
    int i = 0;
    int k = paramString.indexOf('\n', i);
    int j = k;
    if (k < 0) {
      j = paramString.length();
    }
    int m = paramString.indexOf(':', i);
    k = m;
    if (m < 0) {
      k = paramString.length();
    }
    String str1 = paramString.substring(i, k);
    String str2 = paramString.substring(k + 1, j);
    if ("If-Modified-Since".equals(str1)) {}
    for (;;)
    {
      try
      {
        paramHttpURLConnection.setIfModifiedSince(parseHttpDateTime(str2));
        j += 1;
        i = j;
        if (j < paramString.length()) {
          break;
        }
        return;
      }
      catch (ParseException localParseException)
      {
        Log.e("NiaNet", "If-Modified-Since Date/Time parse failed. " + localParseException.getMessage());
        continue;
      }
      paramHttpURLConnection.setRequestProperty(localParseException, str2);
    }
  }
}

/* Location:
 * Qualified Name:     com.nianticlabs.nia.network.NiaNet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */