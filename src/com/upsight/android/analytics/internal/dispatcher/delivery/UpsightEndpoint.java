package com.upsight.android.analytics.internal.dispatcher.delivery;

import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Base64;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.upsight.android.internal.util.GzipHelper;
import com.upsight.android.logger.UpsightLogger;
import java.io.IOException;
import java.net.HttpURLConnection;
import org.apache.commons.io.IOUtils;

class UpsightEndpoint
{
  private static final String CONNECTION_CLOSE = "close";
  private static final int CONNECTION_TIMEOUT_MS = 30000;
  private static final String CONTENT_ENCODING_GZIP = "gzip";
  private static final String CONTENT_TYPE_APPLICATION_JSON = "application/json";
  private static final String EMPTY_STRING = "";
  static final String HTTP_HEADER_REF_ID = "X-US-Ref-Id";
  static final String HTTP_HEADER_US_DIGEST = "X-US-DIGEST";
  public static final String LOG_TEXT_POSTING = "POSTING:       ";
  public static final String LOG_TEXT_RECEIVING = "RECEIVING:     ";
  public static final String LOG_TEXT_REQUEST_BODY = "\nREQUEST BODY:  ";
  public static final String LOG_TEXT_RESPONSE_BODY = "\nRESPONSE BODY: ";
  public static final String LOG_TEXT_RESPONSE_BODY_NONE = "[NONE]";
  public static final String LOG_TEXT_STATUS_CODE = "\nSTATUS CODE:   ";
  public static final String LOG_TEXT_TO = "\nTO:            ";
  private static final String POST_METHOD_NAME = "POST";
  public static final String SIGNED_MESSAGE_SEPARATOR = ":";
  private static final String USER_AGENT_ANDROID = "Android-" + Build.VERSION.SDK_INT;
  private static final boolean USE_GZIP = false;
  private String mEndpointAddress;
  private UpsightLogger mLogger;
  private ObjectMapper mMapper;
  private SignatureVerifier mSignatureVerifier;
  
  public UpsightEndpoint(String paramString, SignatureVerifier paramSignatureVerifier, ObjectMapper paramObjectMapper, UpsightLogger paramUpsightLogger)
  {
    mEndpointAddress = paramString;
    mSignatureVerifier = paramSignatureVerifier;
    mMapper = paramObjectMapper;
    mLogger = paramUpsightLogger;
  }
  
  private byte[] getRequestBodyBytes(String paramString, boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean) {
      return GzipHelper.compress(paramString);
    }
    return paramString.getBytes();
  }
  
  private String getVerifiedResponse(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    String str1 = "";
    Object localObject2 = paramHttpURLConnection.getRequestProperty("X-US-Ref-Id");
    String str2 = paramHttpURLConnection.getHeaderField("X-US-DIGEST");
    Object localObject1 = str1;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = str1;
      if (!TextUtils.isEmpty(str2))
      {
        paramHttpURLConnection = paramHttpURLConnection.getInputStream();
        localObject1 = str1;
        if (paramHttpURLConnection != null)
        {
          paramHttpURLConnection = IOUtils.toString(paramHttpURLConnection);
          localObject1 = str1;
          if (!TextUtils.isEmpty(paramHttpURLConnection)) {
            localObject1 = (paramHttpURLConnection + ":" + (String)localObject2).getBytes();
          }
        }
      }
    }
    try
    {
      localObject2 = Base64.decode(str2, 8);
      boolean bool = mSignatureVerifier.verify((byte[])localObject1, (byte[])localObject2);
      localObject1 = str1;
      if (bool) {
        localObject1 = paramHttpURLConnection;
      }
      return (String)localObject1;
    }
    catch (IllegalArgumentException paramHttpURLConnection)
    {
      mLogger.e("Upsight", paramHttpURLConnection, "Message signature is not valid Base64. X-US-DIGEST: " + str2, new Object[0]);
    }
    return "";
  }
  
  /* Error */
  public Response send(UpsightRequest paramUpsightRequest)
    throws IOException
  {
    // Byte code:
    //   0: invokestatic 180	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   3: invokevirtual 181	java/util/UUID:toString	()Ljava/lang/String;
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 4
    //   11: aload 4
    //   13: astore_3
    //   14: aload_0
    //   15: getfield 103	com/upsight/android/analytics/internal/dispatcher/delivery/UpsightEndpoint:mMapper	Lcom/fasterxml/jackson/databind/ObjectMapper;
    //   18: aload_1
    //   19: invokevirtual 187	com/fasterxml/jackson/databind/ObjectMapper:writeValueAsString	(Ljava/lang/Object;)Ljava/lang/String;
    //   22: astore_1
    //   23: aload 4
    //   25: astore_3
    //   26: new 71	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   33: ldc 32
    //   35: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload 6
    //   40: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc 50
    //   45: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_0
    //   49: getfield 99	com/upsight/android/analytics/internal/dispatcher/delivery/UpsightEndpoint:mEndpointAddress	Ljava/lang/String;
    //   52: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc 38
    //   57: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_1
    //   61: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: astore 5
    //   66: aload 4
    //   68: astore_3
    //   69: aload_0
    //   70: getfield 105	com/upsight/android/analytics/internal/dispatcher/delivery/UpsightEndpoint:mLogger	Lcom/upsight/android/logger/UpsightLogger;
    //   73: ldc -92
    //   75: aload 5
    //   77: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: iconst_0
    //   81: anewarray 4	java/lang/Object
    //   84: invokeinterface 191 4 0
    //   89: aload 4
    //   91: astore_3
    //   92: aload_0
    //   93: aload_1
    //   94: iconst_0
    //   95: invokespecial 193	com/upsight/android/analytics/internal/dispatcher/delivery/UpsightEndpoint:getRequestBodyBytes	(Ljava/lang/String;Z)[B
    //   98: astore_1
    //   99: aload 4
    //   101: astore_3
    //   102: new 195	java/net/URL
    //   105: dup
    //   106: aload_0
    //   107: getfield 99	com/upsight/android/analytics/internal/dispatcher/delivery/UpsightEndpoint:mEndpointAddress	Ljava/lang/String;
    //   110: invokespecial 198	java/net/URL:<init>	(Ljava/lang/String;)V
    //   113: invokevirtual 202	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   116: checkcast 128	java/net/HttpURLConnection
    //   119: astore 5
    //   121: aload 5
    //   123: astore_3
    //   124: aload 5
    //   126: ldc 53
    //   128: invokevirtual 205	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   131: aload 5
    //   133: astore_3
    //   134: aload 5
    //   136: ldc 26
    //   138: aload 6
    //   140: invokevirtual 209	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: aload 5
    //   145: astore_3
    //   146: aload 5
    //   148: ldc -45
    //   150: ldc 20
    //   152: invokevirtual 209	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload 5
    //   157: astore_3
    //   158: aload 5
    //   160: ldc -43
    //   162: getstatic 94	com/upsight/android/analytics/internal/dispatcher/delivery/UpsightEndpoint:USER_AGENT_ANDROID	Ljava/lang/String;
    //   165: invokevirtual 209	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: aload 5
    //   170: astore_3
    //   171: aload 5
    //   173: ldc -41
    //   175: ldc 11
    //   177: invokevirtual 209	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: aload 5
    //   182: astore_3
    //   183: aload 5
    //   185: sipush 30000
    //   188: invokevirtual 219	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   191: aload 5
    //   193: astore_3
    //   194: aload 5
    //   196: sipush 30000
    //   199: invokevirtual 222	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   202: aload 5
    //   204: astore_3
    //   205: aload 5
    //   207: iconst_1
    //   208: invokevirtual 226	java/net/HttpURLConnection:setDoInput	(Z)V
    //   211: aload 5
    //   213: astore_3
    //   214: aload 5
    //   216: iconst_1
    //   217: invokevirtual 229	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   220: aload 5
    //   222: astore_3
    //   223: aload 5
    //   225: aload_1
    //   226: arraylength
    //   227: invokevirtual 232	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   230: aload 5
    //   232: astore_3
    //   233: aload_1
    //   234: aload 5
    //   236: invokevirtual 236	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   239: invokestatic 240	org/apache/commons/io/IOUtils:write	([BLjava/io/OutputStream;)V
    //   242: aconst_null
    //   243: astore_1
    //   244: aload 5
    //   246: astore_3
    //   247: aload 5
    //   249: invokevirtual 244	java/net/HttpURLConnection:getResponseCode	()I
    //   252: istore_2
    //   253: aload 5
    //   255: astore_3
    //   256: new 71	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   263: ldc 35
    //   265: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload 6
    //   270: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: ldc 47
    //   275: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: iload_2
    //   279: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   282: astore 6
    //   284: iload_2
    //   285: sipush 200
    //   288: if_icmpne +50 -> 338
    //   291: aload 5
    //   293: astore_3
    //   294: aload_0
    //   295: aload 5
    //   297: invokespecial 246	com/upsight/android/analytics/internal/dispatcher/delivery/UpsightEndpoint:getVerifiedResponse	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   300: astore_1
    //   301: aload 5
    //   303: astore_3
    //   304: aload 6
    //   306: ldc 41
    //   308: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: astore 7
    //   313: aload 5
    //   315: astore_3
    //   316: aload_1
    //   317: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   320: ifeq +66 -> 386
    //   323: ldc 44
    //   325: astore 4
    //   327: aload 5
    //   329: astore_3
    //   330: aload 7
    //   332: aload 4
    //   334: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload 5
    //   340: astore_3
    //   341: aload_0
    //   342: getfield 105	com/upsight/android/analytics/internal/dispatcher/delivery/UpsightEndpoint:mLogger	Lcom/upsight/android/logger/UpsightLogger;
    //   345: ldc -92
    //   347: aload 6
    //   349: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: iconst_0
    //   353: anewarray 4	java/lang/Object
    //   356: invokeinterface 191 4 0
    //   361: aload 5
    //   363: astore_3
    //   364: new 6	com/upsight/android/analytics/internal/dispatcher/delivery/UpsightEndpoint$Response
    //   367: dup
    //   368: iload_2
    //   369: aload_1
    //   370: invokespecial 249	com/upsight/android/analytics/internal/dispatcher/delivery/UpsightEndpoint$Response:<init>	(ILjava/lang/String;)V
    //   373: astore_1
    //   374: aload 5
    //   376: ifnull +8 -> 384
    //   379: aload 5
    //   381: invokevirtual 252	java/net/HttpURLConnection:disconnect	()V
    //   384: aload_1
    //   385: areturn
    //   386: aload_1
    //   387: astore 4
    //   389: goto -62 -> 327
    //   392: astore_1
    //   393: aload_3
    //   394: ifnull +7 -> 401
    //   397: aload_3
    //   398: invokevirtual 252	java/net/HttpURLConnection:disconnect	()V
    //   401: aload_1
    //   402: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	403	0	this	UpsightEndpoint
    //   0	403	1	paramUpsightRequest	UpsightRequest
    //   252	117	2	i	int
    //   13	385	3	localObject1	Object
    //   9	379	4	localObject2	Object
    //   64	316	5	localObject3	Object
    //   6	342	6	localObject4	Object
    //   311	20	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   14	23	392	finally
    //   26	66	392	finally
    //   69	89	392	finally
    //   92	99	392	finally
    //   102	121	392	finally
    //   124	131	392	finally
    //   134	143	392	finally
    //   146	155	392	finally
    //   158	168	392	finally
    //   171	180	392	finally
    //   183	191	392	finally
    //   194	202	392	finally
    //   205	211	392	finally
    //   214	220	392	finally
    //   223	230	392	finally
    //   233	242	392	finally
    //   247	253	392	finally
    //   256	284	392	finally
    //   294	301	392	finally
    //   304	313	392	finally
    //   316	323	392	finally
    //   330	338	392	finally
    //   341	361	392	finally
    //   364	374	392	finally
  }
  
  public static class Response
  {
    public final String body;
    public final int statusCode;
    
    public Response(int paramInt, String paramString)
    {
      statusCode = paramInt;
      body = paramString;
    }
    
    public boolean isOk()
    {
      return statusCode == 200;
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.delivery.UpsightEndpoint
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */