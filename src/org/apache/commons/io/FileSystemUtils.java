package org.apache.commons.io;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

public class FileSystemUtils
{
  private static final String DF;
  private static final int INIT_PROBLEM = -1;
  private static final FileSystemUtils INSTANCE = new FileSystemUtils();
  private static final int OS;
  private static final int OTHER = 0;
  private static final int POSIX_UNIX = 3;
  private static final int UNIX = 2;
  private static final int WINDOWS = 1;
  
  static
  {
    String str1 = "df";
    int i;
    try
    {
      String str2 = System.getProperty("os.name");
      if (str2 == null) {
        throw new IOException("os.name not found");
      }
    }
    catch (Exception localException)
    {
      i = -1;
    }
    for (;;)
    {
      OS = i;
      DF = str1;
      return;
      String str3 = localException.toLowerCase(Locale.ENGLISH);
      if (str3.indexOf("windows") != -1)
      {
        i = 1;
      }
      else
      {
        if ((str3.indexOf("linux") == -1) && (str3.indexOf("mpe/ix") == -1) && (str3.indexOf("freebsd") == -1) && (str3.indexOf("irix") == -1) && (str3.indexOf("digital unix") == -1) && (str3.indexOf("unix") == -1) && (str3.indexOf("mac os x") == -1))
        {
          if ((str3.indexOf("sun os") == -1) && (str3.indexOf("sunos") == -1) && (str3.indexOf("solaris") == -1))
          {
            if (str3.indexOf("hp-ux") == -1)
            {
              i = str3.indexOf("aix");
              if (i == -1) {}
            }
            else
            {
              i = 3;
              continue;
            }
            i = 0;
          }
        }
        else
        {
          i = 2;
          continue;
        }
        i = 3;
        str1 = "/usr/xpg4/bin/df";
      }
    }
  }
  
  @Deprecated
  public static long freeSpace(String paramString)
    throws IOException
  {
    return INSTANCE.freeSpaceOS(paramString, OS, false, -1L);
  }
  
  public static long freeSpaceKb()
    throws IOException
  {
    return freeSpaceKb(-1L);
  }
  
  public static long freeSpaceKb(long paramLong)
    throws IOException
  {
    return freeSpaceKb(new File(".").getAbsolutePath(), paramLong);
  }
  
  public static long freeSpaceKb(String paramString)
    throws IOException
  {
    return freeSpaceKb(paramString, -1L);
  }
  
  public static long freeSpaceKb(String paramString, long paramLong)
    throws IOException
  {
    return INSTANCE.freeSpaceOS(paramString, OS, true, paramLong);
  }
  
  long freeSpaceOS(String paramString, int paramInt, boolean paramBoolean, long paramLong)
    throws IOException
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Path must not be empty");
    }
    switch (paramInt)
    {
    default: 
      throw new IllegalStateException("Exception caught when determining operating system");
    case 1: 
      if (paramBoolean) {
        return freeSpaceWindows(paramString, paramLong) / 1024L;
      }
      return freeSpaceWindows(paramString, paramLong);
    case 2: 
      return freeSpaceUnix(paramString, paramBoolean, false, paramLong);
    case 3: 
      return freeSpaceUnix(paramString, paramBoolean, true, paramLong);
    }
    throw new IllegalStateException("Unsupported operating system");
  }
  
  long freeSpaceUnix(String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
    throws IOException
  {
    if (paramString.length() == 0) {
      throw new IllegalArgumentException("Path must not be empty");
    }
    Object localObject1 = "-";
    if (paramBoolean1) {
      localObject1 = "-" + "k";
    }
    Object localObject2 = localObject1;
    if (paramBoolean2) {
      localObject2 = (String)localObject1 + "P";
    }
    if (((String)localObject2).length() > 1)
    {
      localObject1 = new String[3];
      localObject1[0] = DF;
      localObject1[1] = localObject2;
      localObject1[2] = paramString;
    }
    for (;;)
    {
      localObject2 = performCommand((String[])localObject1, 3, paramLong);
      if (((List)localObject2).size() >= 2) {
        break;
      }
      throw new IOException("Command line '" + DF + "' did not return info as expected " + "for path '" + paramString + "'- response was " + localObject2);
      localObject1 = new String[2];
      localObject1[0] = DF;
      localObject1[1] = paramString;
    }
    localObject1 = new StringTokenizer((String)((List)localObject2).get(1), " ");
    if (((StringTokenizer)localObject1).countTokens() < 4) {
      if ((((StringTokenizer)localObject1).countTokens() == 1) && (((List)localObject2).size() >= 3)) {
        localObject1 = new StringTokenizer((String)((List)localObject2).get(2), " ");
      }
    }
    for (;;)
    {
      ((StringTokenizer)localObject1).nextToken();
      ((StringTokenizer)localObject1).nextToken();
      return parseBytes(((StringTokenizer)localObject1).nextToken(), paramString);
      throw new IOException("Command line '" + DF + "' did not return data as expected " + "for path '" + paramString + "'- check path is valid");
      ((StringTokenizer)localObject1).nextToken();
    }
  }
  
  long freeSpaceWindows(String paramString, long paramLong)
    throws IOException
  {
    Object localObject = FilenameUtils.normalize(paramString, false);
    paramString = (String)localObject;
    if (((String)localObject).length() > 0)
    {
      paramString = (String)localObject;
      if (((String)localObject).charAt(0) != '"') {
        paramString = "\"" + (String)localObject + "\"";
      }
    }
    localObject = performCommand(new String[] { "cmd.exe", "/C", "dir /a /-c " + paramString }, Integer.MAX_VALUE, paramLong);
    int i = ((List)localObject).size() - 1;
    while (i >= 0)
    {
      String str = (String)((List)localObject).get(i);
      if (str.length() > 0) {
        return parseDir(str, paramString);
      }
      i -= 1;
    }
    throw new IOException("Command line 'dir /-c' did not return any info for path '" + paramString + "'");
  }
  
  Process openProcess(String[] paramArrayOfString)
    throws IOException
  {
    return Runtime.getRuntime().exec(paramArrayOfString);
  }
  
  long parseBytes(String paramString1, String paramString2)
    throws IOException
  {
    long l;
    try
    {
      l = Long.parseLong(paramString1);
      if (l < 0L) {
        throw new IOException("Command line '" + DF + "' did not find free space in response " + "for path '" + paramString2 + "'- check path is valid");
      }
    }
    catch (NumberFormatException paramString1)
    {
      throw new IOExceptionWithCause("Command line '" + DF + "' did not return numeric data as expected " + "for path '" + paramString2 + "'- check path is valid", paramString1);
    }
    return l;
  }
  
  long parseDir(String paramString1, String paramString2)
    throws IOException
  {
    int m = 0;
    int n = 0;
    int i = paramString1.length() - 1;
    int j = n;
    int k = i;
    if (i >= 0)
    {
      if (!Character.isDigit(paramString1.charAt(i))) {
        break label128;
      }
      j = i + 1;
      k = i;
    }
    for (;;)
    {
      i = m;
      if (k >= 0)
      {
        char c = paramString1.charAt(k);
        if ((!Character.isDigit(c)) && (c != ',') && (c != '.')) {
          i = k + 1;
        }
      }
      else
      {
        if (k >= 0) {
          break label146;
        }
        throw new IOException("Command line 'dir /-c' did not return valid info for path '" + paramString2 + "'");
        label128:
        i -= 1;
        break;
      }
      k -= 1;
    }
    label146:
    paramString1 = new StringBuilder(paramString1.substring(i, j));
    for (i = 0; i < paramString1.length(); i = j + 1) {
      if (paramString1.charAt(i) != ',')
      {
        j = i;
        if (paramString1.charAt(i) != '.') {}
      }
      else
      {
        paramString1.deleteCharAt(i);
        j = i - 1;
      }
    }
    return parseBytes(paramString1.toString(), paramString2);
  }
  
  /* Error */
  List<String> performCommand(String[] paramArrayOfString, int paramInt, long paramLong)
    throws IOException
  {
    // Byte code:
    //   0: new 286	java/util/ArrayList
    //   3: dup
    //   4: bipush 20
    //   6: invokespecial 289	java/util/ArrayList:<init>	(I)V
    //   9: astore 24
    //   11: aconst_null
    //   12: astore 23
    //   14: aconst_null
    //   15: astore 6
    //   17: aconst_null
    //   18: astore 22
    //   20: aconst_null
    //   21: astore 8
    //   23: aconst_null
    //   24: astore 21
    //   26: aconst_null
    //   27: astore 9
    //   29: aconst_null
    //   30: astore 20
    //   32: aconst_null
    //   33: astore 11
    //   35: aconst_null
    //   36: astore 18
    //   38: aconst_null
    //   39: astore 19
    //   41: aload 11
    //   43: astore 5
    //   45: aload 8
    //   47: astore 7
    //   49: aload 18
    //   51: astore 13
    //   53: aload 9
    //   55: astore 10
    //   57: aload 6
    //   59: astore 12
    //   61: aload 20
    //   63: astore 17
    //   65: aload 22
    //   67: astore 16
    //   69: aload 21
    //   71: astore 15
    //   73: aload 23
    //   75: astore 14
    //   77: lload_3
    //   78: invokestatic 295	org/apache/commons/io/ThreadMonitor:start	(J)Ljava/lang/Thread;
    //   81: astore 25
    //   83: aload 11
    //   85: astore 5
    //   87: aload 8
    //   89: astore 7
    //   91: aload 18
    //   93: astore 13
    //   95: aload 9
    //   97: astore 10
    //   99: aload 6
    //   101: astore 12
    //   103: aload 20
    //   105: astore 17
    //   107: aload 22
    //   109: astore 16
    //   111: aload 21
    //   113: astore 15
    //   115: aload 23
    //   117: astore 14
    //   119: aload_0
    //   120: aload_1
    //   121: invokevirtual 297	org/apache/commons/io/FileSystemUtils:openProcess	([Ljava/lang/String;)Ljava/lang/Process;
    //   124: astore 6
    //   126: aload 11
    //   128: astore 5
    //   130: aload 8
    //   132: astore 7
    //   134: aload 18
    //   136: astore 13
    //   138: aload 9
    //   140: astore 10
    //   142: aload 6
    //   144: astore 12
    //   146: aload 20
    //   148: astore 17
    //   150: aload 22
    //   152: astore 16
    //   154: aload 21
    //   156: astore 15
    //   158: aload 6
    //   160: astore 14
    //   162: aload 6
    //   164: invokevirtual 303	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   167: astore 8
    //   169: aload 11
    //   171: astore 5
    //   173: aload 8
    //   175: astore 7
    //   177: aload 18
    //   179: astore 13
    //   181: aload 9
    //   183: astore 10
    //   185: aload 6
    //   187: astore 12
    //   189: aload 20
    //   191: astore 17
    //   193: aload 8
    //   195: astore 16
    //   197: aload 21
    //   199: astore 15
    //   201: aload 6
    //   203: astore 14
    //   205: aload 6
    //   207: invokevirtual 307	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   210: astore 9
    //   212: aload 11
    //   214: astore 5
    //   216: aload 8
    //   218: astore 7
    //   220: aload 18
    //   222: astore 13
    //   224: aload 9
    //   226: astore 10
    //   228: aload 6
    //   230: astore 12
    //   232: aload 20
    //   234: astore 17
    //   236: aload 8
    //   238: astore 16
    //   240: aload 9
    //   242: astore 15
    //   244: aload 6
    //   246: astore 14
    //   248: aload 6
    //   250: invokevirtual 310	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   253: astore 11
    //   255: aload 11
    //   257: astore 5
    //   259: aload 8
    //   261: astore 7
    //   263: aload 18
    //   265: astore 13
    //   267: aload 9
    //   269: astore 10
    //   271: aload 6
    //   273: astore 12
    //   275: aload 11
    //   277: astore 17
    //   279: aload 8
    //   281: astore 16
    //   283: aload 9
    //   285: astore 15
    //   287: aload 6
    //   289: astore 14
    //   291: new 312	java/io/BufferedReader
    //   294: dup
    //   295: new 314	java/io/InputStreamReader
    //   298: dup
    //   299: aload 8
    //   301: invokespecial 317	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   304: invokespecial 320	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   307: astore 18
    //   309: aload 18
    //   311: invokevirtual 323	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   314: astore 5
    //   316: aload 5
    //   318: ifnull +43 -> 361
    //   321: aload 24
    //   323: invokeinterface 174 1 0
    //   328: iload_2
    //   329: if_icmpge +32 -> 361
    //   332: aload 24
    //   334: aload 5
    //   336: getstatic 56	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   339: invokevirtual 62	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   342: invokevirtual 326	java/lang/String:trim	()Ljava/lang/String;
    //   345: invokeinterface 330 2 0
    //   350: pop
    //   351: aload 18
    //   353: invokevirtual 323	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   356: astore 5
    //   358: goto -42 -> 316
    //   361: aload 6
    //   363: invokevirtual 333	java/lang/Process:waitFor	()I
    //   366: pop
    //   367: aload 25
    //   369: invokestatic 337	org/apache/commons/io/ThreadMonitor:stop	(Ljava/lang/Thread;)V
    //   372: aload 6
    //   374: invokevirtual 340	java/lang/Process:exitValue	()I
    //   377: ifeq +158 -> 535
    //   380: new 41	java/io/IOException
    //   383: dup
    //   384: new 153	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   391: ldc_w 342
    //   394: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload 6
    //   399: invokevirtual 340	java/lang/Process:exitValue	()I
    //   402: invokevirtual 344	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   405: ldc_w 346
    //   408: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aload_1
    //   412: invokestatic 352	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   415: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   418: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: invokespecial 46	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   424: athrow
    //   425: astore 5
    //   427: aload 18
    //   429: astore 13
    //   431: aload 8
    //   433: astore 7
    //   435: aload 5
    //   437: astore 8
    //   439: aload 11
    //   441: astore 5
    //   443: aload 9
    //   445: astore 10
    //   447: aload 6
    //   449: astore 12
    //   451: new 258	org/apache/commons/io/IOExceptionWithCause
    //   454: dup
    //   455: new 153	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   462: ldc_w 354
    //   465: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: aload_1
    //   469: invokestatic 352	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   472: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   475: ldc_w 356
    //   478: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: lload_3
    //   482: invokevirtual 359	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   485: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: aload 8
    //   490: invokespecial 263	org/apache/commons/io/IOExceptionWithCause:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   493: athrow
    //   494: astore_1
    //   495: aload 12
    //   497: astore 6
    //   499: aload 10
    //   501: astore 9
    //   503: aload 7
    //   505: invokestatic 364	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   508: aload 9
    //   510: invokestatic 367	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   513: aload 5
    //   515: invokestatic 364	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   518: aload 13
    //   520: invokestatic 369	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   523: aload 6
    //   525: ifnull +8 -> 533
    //   528: aload 6
    //   530: invokevirtual 372	java/lang/Process:destroy	()V
    //   533: aload_1
    //   534: athrow
    //   535: aload 24
    //   537: invokeinterface 376 1 0
    //   542: ifeq +50 -> 592
    //   545: new 41	java/io/IOException
    //   548: dup
    //   549: new 153	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   556: ldc_w 378
    //   559: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: aload_1
    //   563: invokestatic 352	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   566: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   569: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   572: invokespecial 46	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   575: athrow
    //   576: astore_1
    //   577: aload 18
    //   579: astore 13
    //   581: aload 11
    //   583: astore 5
    //   585: aload 8
    //   587: astore 7
    //   589: goto -86 -> 503
    //   592: aload 8
    //   594: invokestatic 364	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   597: aload 9
    //   599: invokestatic 367	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   602: aload 11
    //   604: invokestatic 364	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   607: aload 18
    //   609: invokestatic 369	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   612: aload 6
    //   614: ifnull +8 -> 622
    //   617: aload 6
    //   619: invokevirtual 372	java/lang/Process:destroy	()V
    //   622: aload 24
    //   624: areturn
    //   625: astore 8
    //   627: aload 17
    //   629: astore 5
    //   631: aload 16
    //   633: astore 7
    //   635: aload 19
    //   637: astore 13
    //   639: aload 15
    //   641: astore 9
    //   643: aload 14
    //   645: astore 6
    //   647: goto -204 -> 443
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	650	0	this	FileSystemUtils
    //   0	650	1	paramArrayOfString	String[]
    //   0	650	2	paramInt	int
    //   0	650	3	paramLong	long
    //   43	314	5	localObject1	Object
    //   425	11	5	localInterruptedException1	InterruptedException
    //   441	189	5	localObject2	Object
    //   15	631	6	localObject3	Object
    //   47	587	7	localObject4	Object
    //   21	572	8	localObject5	Object
    //   625	1	8	localInterruptedException2	InterruptedException
    //   27	615	9	localObject6	Object
    //   55	445	10	localObject7	Object
    //   33	570	11	localInputStream	java.io.InputStream
    //   59	437	12	localObject8	Object
    //   51	587	13	localObject9	Object
    //   75	569	14	localObject10	Object
    //   71	569	15	localObject11	Object
    //   67	565	16	localObject12	Object
    //   63	565	17	localObject13	Object
    //   36	572	18	localBufferedReader	java.io.BufferedReader
    //   39	597	19	localObject14	Object
    //   30	203	20	localObject15	Object
    //   24	174	21	localObject16	Object
    //   18	133	22	localObject17	Object
    //   12	104	23	localObject18	Object
    //   9	614	24	localArrayList	java.util.ArrayList
    //   81	287	25	localThread	Thread
    // Exception table:
    //   from	to	target	type
    //   309	316	425	java/lang/InterruptedException
    //   321	358	425	java/lang/InterruptedException
    //   361	425	425	java/lang/InterruptedException
    //   535	576	425	java/lang/InterruptedException
    //   77	83	494	finally
    //   119	126	494	finally
    //   162	169	494	finally
    //   205	212	494	finally
    //   248	255	494	finally
    //   291	309	494	finally
    //   451	494	494	finally
    //   309	316	576	finally
    //   321	358	576	finally
    //   361	425	576	finally
    //   535	576	576	finally
    //   77	83	625	java/lang/InterruptedException
    //   119	126	625	java/lang/InterruptedException
    //   162	169	625	java/lang/InterruptedException
    //   205	212	625	java/lang/InterruptedException
    //   248	255	625	java/lang/InterruptedException
    //   291	309	625	java/lang/InterruptedException
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.FileSystemUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */