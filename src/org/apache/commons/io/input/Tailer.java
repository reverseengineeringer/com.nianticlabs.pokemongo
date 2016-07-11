package org.apache.commons.io.input;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Tailer
  implements Runnable
{
  private static final int DEFAULT_BUFSIZE = 4096;
  private static final int DEFAULT_DELAY_MILLIS = 1000;
  private static final String RAF_MODE = "r";
  private final long delayMillis;
  private final boolean end;
  private final File file;
  private final byte[] inbuf;
  private final TailerListener listener;
  private final boolean reOpen;
  private volatile boolean run = true;
  
  public Tailer(File paramFile, TailerListener paramTailerListener)
  {
    this(paramFile, paramTailerListener, 1000L);
  }
  
  public Tailer(File paramFile, TailerListener paramTailerListener, long paramLong)
  {
    this(paramFile, paramTailerListener, paramLong, false);
  }
  
  public Tailer(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean)
  {
    this(paramFile, paramTailerListener, paramLong, paramBoolean, 4096);
  }
  
  public Tailer(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean, int paramInt)
  {
    this(paramFile, paramTailerListener, paramLong, paramBoolean, false, paramInt);
  }
  
  public Tailer(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramFile, paramTailerListener, paramLong, paramBoolean1, paramBoolean2, 4096);
  }
  
  public Tailer(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    file = paramFile;
    delayMillis = paramLong;
    end = paramBoolean1;
    inbuf = new byte[paramInt];
    listener = paramTailerListener;
    paramTailerListener.init(this);
    reOpen = paramBoolean2;
  }
  
  public static Tailer create(File paramFile, TailerListener paramTailerListener)
  {
    return create(paramFile, paramTailerListener, 1000L, false);
  }
  
  public static Tailer create(File paramFile, TailerListener paramTailerListener, long paramLong)
  {
    return create(paramFile, paramTailerListener, paramLong, false);
  }
  
  public static Tailer create(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean)
  {
    return create(paramFile, paramTailerListener, paramLong, paramBoolean, 4096);
  }
  
  public static Tailer create(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean, int paramInt)
  {
    paramFile = new Tailer(paramFile, paramTailerListener, paramLong, paramBoolean, paramInt);
    paramTailerListener = new Thread(paramFile);
    paramTailerListener.setDaemon(true);
    paramTailerListener.start();
    return paramFile;
  }
  
  public static Tailer create(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    return create(paramFile, paramTailerListener, paramLong, paramBoolean1, paramBoolean2, 4096);
  }
  
  public static Tailer create(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    paramFile = new Tailer(paramFile, paramTailerListener, paramLong, paramBoolean1, paramBoolean2, paramInt);
    paramTailerListener = new Thread(paramFile);
    paramTailerListener.setDaemon(true);
    paramTailerListener.start();
    return paramFile;
  }
  
  private long readLines(RandomAccessFile paramRandomAccessFile)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    long l2 = paramRandomAccessFile.getFilePointer();
    long l1 = l2;
    int i = 0;
    while (run)
    {
      int m = paramRandomAccessFile.read(inbuf);
      if (m == -1) {
        break;
      }
      int k = 0;
      if (k < m)
      {
        int n = inbuf[k];
        switch (n)
        {
        case 11: 
        case 12: 
        default: 
          int j = i;
          if (i != 0)
          {
            j = 0;
            listener.handle(localStringBuilder.toString());
            localStringBuilder.setLength(0);
            l1 = k + l2 + 1L;
          }
          localStringBuilder.append((char)n);
          i = j;
        }
        for (;;)
        {
          k += 1;
          break;
          i = 0;
          listener.handle(localStringBuilder.toString());
          localStringBuilder.setLength(0);
          l1 = k + l2 + 1L;
          continue;
          if (i != 0) {
            localStringBuilder.append('\r');
          }
          i = 1;
        }
      }
      l2 = paramRandomAccessFile.getFilePointer();
    }
    paramRandomAccessFile.seek(l1);
    return l1;
  }
  
  public long getDelay()
  {
    return delayMillis;
  }
  
  public File getFile()
  {
    return file;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_3
    //   2: lconst_0
    //   3: lstore 5
    //   5: aconst_null
    //   6: astore 11
    //   8: aload 11
    //   10: astore 12
    //   12: aload 11
    //   14: astore 14
    //   16: aload_0
    //   17: getfield 50	org/apache/commons/io/input/Tailer:run	Z
    //   20: istore 9
    //   22: lload_3
    //   23: lstore 7
    //   25: lload 5
    //   27: lstore_1
    //   28: aload 11
    //   30: astore 10
    //   32: iload 9
    //   34: ifeq +175 -> 209
    //   37: lload_3
    //   38: lstore 7
    //   40: lload 5
    //   42: lstore_1
    //   43: aload 11
    //   45: astore 10
    //   47: aload 11
    //   49: ifnonnull +160 -> 209
    //   52: aload 11
    //   54: astore 12
    //   56: aload 11
    //   58: astore 14
    //   60: new 102	java/io/RandomAccessFile
    //   63: dup
    //   64: aload_0
    //   65: getfield 52	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   68: ldc 15
    //   70: invokespecial 143	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   73: astore 10
    //   75: aload 10
    //   77: ifnonnull +60 -> 137
    //   80: aload 10
    //   82: astore 11
    //   84: aload 10
    //   86: astore 12
    //   88: aload_0
    //   89: getfield 54	org/apache/commons/io/input/Tailer:delayMillis	J
    //   92: invokestatic 146	java/lang/Thread:sleep	(J)V
    //   95: aload 10
    //   97: astore 11
    //   99: goto -91 -> 8
    //   102: astore 10
    //   104: aload 11
    //   106: astore 12
    //   108: aload 11
    //   110: astore 14
    //   112: aload_0
    //   113: getfield 60	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   116: invokeinterface 149 1 0
    //   121: aload 11
    //   123: astore 10
    //   125: goto -50 -> 75
    //   128: astore 11
    //   130: aload 10
    //   132: astore 11
    //   134: goto -126 -> 8
    //   137: aload 10
    //   139: astore 11
    //   141: aload 10
    //   143: astore 12
    //   145: aload_0
    //   146: getfield 56	org/apache/commons/io/input/Tailer:end	Z
    //   149: ifeq +54 -> 203
    //   152: aload 10
    //   154: astore 11
    //   156: aload 10
    //   158: astore 12
    //   160: aload_0
    //   161: getfield 52	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   164: invokevirtual 154	java/io/File:length	()J
    //   167: lstore 5
    //   169: aload 10
    //   171: astore 11
    //   173: aload 10
    //   175: astore 12
    //   177: invokestatic 159	java/lang/System:currentTimeMillis	()J
    //   180: lstore_3
    //   181: aload 10
    //   183: astore 11
    //   185: aload 10
    //   187: astore 12
    //   189: aload 10
    //   191: lload 5
    //   193: invokevirtual 130	java/io/RandomAccessFile:seek	(J)V
    //   196: aload 10
    //   198: astore 11
    //   200: goto -192 -> 8
    //   203: lconst_0
    //   204: lstore 5
    //   206: goto -37 -> 169
    //   209: aload 10
    //   211: astore 12
    //   213: aload 10
    //   215: astore 14
    //   217: aload_0
    //   218: getfield 50	org/apache/commons/io/input/Tailer:run	Z
    //   221: ifeq +329 -> 550
    //   224: aload 10
    //   226: astore 12
    //   228: aload 10
    //   230: astore 14
    //   232: aload_0
    //   233: getfield 52	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   236: lload 7
    //   238: invokestatic 165	org/apache/commons/io/FileUtils:isFileNewer	(Ljava/io/File;J)Z
    //   241: istore 9
    //   243: aload 10
    //   245: astore 12
    //   247: aload 10
    //   249: astore 14
    //   251: aload_0
    //   252: getfield 52	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   255: invokevirtual 154	java/io/File:length	()J
    //   258: lstore_3
    //   259: lload_3
    //   260: lload_1
    //   261: lcmp
    //   262: ifge +87 -> 349
    //   265: aload 10
    //   267: astore 12
    //   269: aload 10
    //   271: astore 14
    //   273: aload_0
    //   274: getfield 60	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   277: invokeinterface 168 1 0
    //   282: aload 10
    //   284: astore 12
    //   286: aload 10
    //   288: astore 14
    //   290: new 102	java/io/RandomAccessFile
    //   293: dup
    //   294: aload_0
    //   295: getfield 52	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   298: ldc 15
    //   300: invokespecial 143	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   303: astore 13
    //   305: lconst_0
    //   306: lstore_1
    //   307: aload 13
    //   309: astore 11
    //   311: aload 13
    //   313: astore 12
    //   315: aload 10
    //   317: invokestatic 174	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   320: aload 13
    //   322: astore 10
    //   324: goto -115 -> 209
    //   327: astore 11
    //   329: aload 10
    //   331: astore 11
    //   333: aload 10
    //   335: astore 12
    //   337: aload_0
    //   338: getfield 60	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   341: invokeinterface 149 1 0
    //   346: goto -137 -> 209
    //   349: lload_3
    //   350: lload_1
    //   351: lcmp
    //   352: ifle +146 -> 498
    //   355: aload 10
    //   357: astore 12
    //   359: aload 10
    //   361: astore 14
    //   363: aload_0
    //   364: aload 10
    //   366: invokespecial 176	org/apache/commons/io/input/Tailer:readLines	(Ljava/io/RandomAccessFile;)J
    //   369: lstore_1
    //   370: aload 10
    //   372: astore 12
    //   374: aload 10
    //   376: astore 14
    //   378: invokestatic 159	java/lang/System:currentTimeMillis	()J
    //   381: lstore_3
    //   382: aload 10
    //   384: astore 12
    //   386: aload 10
    //   388: astore 14
    //   390: aload_0
    //   391: getfield 68	org/apache/commons/io/input/Tailer:reOpen	Z
    //   394: ifeq +16 -> 410
    //   397: aload 10
    //   399: astore 12
    //   401: aload 10
    //   403: astore 14
    //   405: aload 10
    //   407: invokestatic 174	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   410: aload 10
    //   412: astore 12
    //   414: aload 10
    //   416: astore 14
    //   418: aload_0
    //   419: getfield 54	org/apache/commons/io/input/Tailer:delayMillis	J
    //   422: invokestatic 146	java/lang/Thread:sleep	(J)V
    //   425: aload 10
    //   427: astore 12
    //   429: aload 10
    //   431: astore 14
    //   433: aload_0
    //   434: getfield 50	org/apache/commons/io/input/Tailer:run	Z
    //   437: ifeq +180 -> 617
    //   440: aload 10
    //   442: astore 12
    //   444: aload 10
    //   446: astore 14
    //   448: aload_0
    //   449: getfield 68	org/apache/commons/io/input/Tailer:reOpen	Z
    //   452: ifeq +165 -> 617
    //   455: aload 10
    //   457: astore 12
    //   459: aload 10
    //   461: astore 14
    //   463: new 102	java/io/RandomAccessFile
    //   466: dup
    //   467: aload_0
    //   468: getfield 52	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   471: ldc 15
    //   473: invokespecial 143	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   476: astore 10
    //   478: aload 10
    //   480: astore 11
    //   482: aload 10
    //   484: astore 12
    //   486: aload 10
    //   488: lload_1
    //   489: invokevirtual 130	java/io/RandomAccessFile:seek	(J)V
    //   492: lload_3
    //   493: lstore 7
    //   495: goto -286 -> 209
    //   498: lload 7
    //   500: lstore_3
    //   501: iload 9
    //   503: ifeq -121 -> 382
    //   506: aload 10
    //   508: astore 12
    //   510: aload 10
    //   512: astore 14
    //   514: aload 10
    //   516: lconst_0
    //   517: invokevirtual 130	java/io/RandomAccessFile:seek	(J)V
    //   520: aload 10
    //   522: astore 12
    //   524: aload 10
    //   526: astore 14
    //   528: aload_0
    //   529: aload 10
    //   531: invokespecial 176	org/apache/commons/io/input/Tailer:readLines	(Ljava/io/RandomAccessFile;)J
    //   534: lstore_1
    //   535: aload 10
    //   537: astore 12
    //   539: aload 10
    //   541: astore 14
    //   543: invokestatic 159	java/lang/System:currentTimeMillis	()J
    //   546: lstore_3
    //   547: goto -165 -> 382
    //   550: aload 10
    //   552: invokestatic 174	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   555: return
    //   556: astore 10
    //   558: aload 12
    //   560: astore 11
    //   562: aload_0
    //   563: getfield 60	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   566: aload 10
    //   568: invokeinterface 179 2 0
    //   573: aload 12
    //   575: invokestatic 174	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   578: return
    //   579: astore 10
    //   581: aload 14
    //   583: astore 11
    //   585: aload 11
    //   587: invokestatic 174	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   590: aload 10
    //   592: athrow
    //   593: astore 10
    //   595: goto -10 -> 585
    //   598: astore 10
    //   600: goto -42 -> 558
    //   603: astore 11
    //   605: goto -180 -> 425
    //   608: astore 10
    //   610: aload 13
    //   612: astore 10
    //   614: goto -285 -> 329
    //   617: goto -125 -> 492
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	620	0	this	Tailer
    //   27	508	1	l1	long
    //   1	546	3	l2	long
    //   3	202	5	l3	long
    //   23	476	7	l4	long
    //   20	482	9	bool	boolean
    //   30	66	10	localObject1	Object
    //   102	1	10	localFileNotFoundException1	java.io.FileNotFoundException
    //   123	428	10	localObject2	Object
    //   556	11	10	localException1	Exception
    //   579	12	10	localObject3	Object
    //   593	1	10	localObject4	Object
    //   598	1	10	localException2	Exception
    //   608	1	10	localFileNotFoundException2	java.io.FileNotFoundException
    //   612	1	10	localObject5	Object
    //   6	116	11	localObject6	Object
    //   128	1	11	localInterruptedException1	InterruptedException
    //   132	178	11	localObject7	Object
    //   327	1	11	localFileNotFoundException3	java.io.FileNotFoundException
    //   331	255	11	localObject8	Object
    //   603	1	11	localInterruptedException2	InterruptedException
    //   10	564	12	localObject9	Object
    //   303	308	13	localRandomAccessFile	RandomAccessFile
    //   14	568	14	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   60	75	102	java/io/FileNotFoundException
    //   88	95	128	java/lang/InterruptedException
    //   290	305	327	java/io/FileNotFoundException
    //   16	22	556	java/lang/Exception
    //   60	75	556	java/lang/Exception
    //   112	121	556	java/lang/Exception
    //   217	224	556	java/lang/Exception
    //   232	243	556	java/lang/Exception
    //   251	259	556	java/lang/Exception
    //   273	282	556	java/lang/Exception
    //   290	305	556	java/lang/Exception
    //   363	370	556	java/lang/Exception
    //   378	382	556	java/lang/Exception
    //   390	397	556	java/lang/Exception
    //   405	410	556	java/lang/Exception
    //   418	425	556	java/lang/Exception
    //   433	440	556	java/lang/Exception
    //   448	455	556	java/lang/Exception
    //   463	478	556	java/lang/Exception
    //   514	520	556	java/lang/Exception
    //   528	535	556	java/lang/Exception
    //   543	547	556	java/lang/Exception
    //   16	22	579	finally
    //   60	75	579	finally
    //   112	121	579	finally
    //   217	224	579	finally
    //   232	243	579	finally
    //   251	259	579	finally
    //   273	282	579	finally
    //   290	305	579	finally
    //   363	370	579	finally
    //   378	382	579	finally
    //   390	397	579	finally
    //   405	410	579	finally
    //   418	425	579	finally
    //   433	440	579	finally
    //   448	455	579	finally
    //   463	478	579	finally
    //   514	520	579	finally
    //   528	535	579	finally
    //   543	547	579	finally
    //   88	95	593	finally
    //   145	152	593	finally
    //   160	169	593	finally
    //   177	181	593	finally
    //   189	196	593	finally
    //   315	320	593	finally
    //   337	346	593	finally
    //   486	492	593	finally
    //   562	573	593	finally
    //   88	95	598	java/lang/Exception
    //   145	152	598	java/lang/Exception
    //   160	169	598	java/lang/Exception
    //   177	181	598	java/lang/Exception
    //   189	196	598	java/lang/Exception
    //   315	320	598	java/lang/Exception
    //   337	346	598	java/lang/Exception
    //   486	492	598	java/lang/Exception
    //   418	425	603	java/lang/InterruptedException
    //   315	320	608	java/io/FileNotFoundException
  }
  
  public void stop()
  {
    run = false;
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.input.Tailer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */