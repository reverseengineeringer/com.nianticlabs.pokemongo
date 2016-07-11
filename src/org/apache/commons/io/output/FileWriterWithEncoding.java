package org.apache.commons.io.output;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class FileWriterWithEncoding
  extends Writer
{
  private final Writer out;
  
  public FileWriterWithEncoding(File paramFile, String paramString)
    throws IOException
  {
    this(paramFile, paramString, false);
  }
  
  public FileWriterWithEncoding(File paramFile, String paramString, boolean paramBoolean)
    throws IOException
  {
    out = initWriter(paramFile, paramString, paramBoolean);
  }
  
  public FileWriterWithEncoding(File paramFile, Charset paramCharset)
    throws IOException
  {
    this(paramFile, paramCharset, false);
  }
  
  public FileWriterWithEncoding(File paramFile, Charset paramCharset, boolean paramBoolean)
    throws IOException
  {
    out = initWriter(paramFile, paramCharset, paramBoolean);
  }
  
  public FileWriterWithEncoding(File paramFile, CharsetEncoder paramCharsetEncoder)
    throws IOException
  {
    this(paramFile, paramCharsetEncoder, false);
  }
  
  public FileWriterWithEncoding(File paramFile, CharsetEncoder paramCharsetEncoder, boolean paramBoolean)
    throws IOException
  {
    out = initWriter(paramFile, paramCharsetEncoder, paramBoolean);
  }
  
  public FileWriterWithEncoding(String paramString1, String paramString2)
    throws IOException
  {
    this(new File(paramString1), paramString2, false);
  }
  
  public FileWriterWithEncoding(String paramString1, String paramString2, boolean paramBoolean)
    throws IOException
  {
    this(new File(paramString1), paramString2, paramBoolean);
  }
  
  public FileWriterWithEncoding(String paramString, Charset paramCharset)
    throws IOException
  {
    this(new File(paramString), paramCharset, false);
  }
  
  public FileWriterWithEncoding(String paramString, Charset paramCharset, boolean paramBoolean)
    throws IOException
  {
    this(new File(paramString), paramCharset, paramBoolean);
  }
  
  public FileWriterWithEncoding(String paramString, CharsetEncoder paramCharsetEncoder)
    throws IOException
  {
    this(new File(paramString), paramCharsetEncoder, false);
  }
  
  public FileWriterWithEncoding(String paramString, CharsetEncoder paramCharsetEncoder, boolean paramBoolean)
    throws IOException
  {
    this(new File(paramString), paramCharsetEncoder, paramBoolean);
  }
  
  /* Error */
  private static Writer initWriter(File paramFile, Object paramObject, boolean paramBoolean)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +13 -> 14
    //   4: new 47	java/lang/NullPointerException
    //   7: dup
    //   8: ldc 49
    //   10: invokespecial 50	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: aload_1
    //   15: ifnonnull +13 -> 28
    //   18: new 47	java/lang/NullPointerException
    //   21: dup
    //   22: ldc 52
    //   24: invokespecial 50	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   27: athrow
    //   28: aload_0
    //   29: invokevirtual 56	java/io/File:exists	()Z
    //   32: istore_3
    //   33: aconst_null
    //   34: astore 6
    //   36: aconst_null
    //   37: astore 5
    //   39: new 58	java/io/FileOutputStream
    //   42: dup
    //   43: aload_0
    //   44: iload_2
    //   45: invokespecial 61	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   48: astore 4
    //   50: aload_1
    //   51: instanceof 63
    //   54: ifeq +17 -> 71
    //   57: new 65	java/io/OutputStreamWriter
    //   60: dup
    //   61: aload 4
    //   63: aload_1
    //   64: checkcast 63	java/nio/charset/Charset
    //   67: invokespecial 68	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   70: areturn
    //   71: aload_1
    //   72: instanceof 70
    //   75: ifeq +17 -> 92
    //   78: new 65	java/io/OutputStreamWriter
    //   81: dup
    //   82: aload 4
    //   84: aload_1
    //   85: checkcast 70	java/nio/charset/CharsetEncoder
    //   88: invokespecial 73	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/CharsetEncoder;)V
    //   91: areturn
    //   92: new 65	java/io/OutputStreamWriter
    //   95: dup
    //   96: aload 4
    //   98: aload_1
    //   99: checkcast 75	java/lang/String
    //   102: invokespecial 78	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   105: astore_1
    //   106: aload_1
    //   107: areturn
    //   108: astore_1
    //   109: aload 5
    //   111: astore 4
    //   113: aconst_null
    //   114: invokestatic 84	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/Writer;)V
    //   117: aload 4
    //   119: invokestatic 87	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   122: iload_3
    //   123: ifne +8 -> 131
    //   126: aload_0
    //   127: invokestatic 93	org/apache/commons/io/FileUtils:deleteQuietly	(Ljava/io/File;)Z
    //   130: pop
    //   131: aload_1
    //   132: athrow
    //   133: astore_1
    //   134: aload 6
    //   136: astore 4
    //   138: aconst_null
    //   139: invokestatic 84	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/Writer;)V
    //   142: aload 4
    //   144: invokestatic 87	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   147: iload_3
    //   148: ifne +8 -> 156
    //   151: aload_0
    //   152: invokestatic 93	org/apache/commons/io/FileUtils:deleteQuietly	(Ljava/io/File;)Z
    //   155: pop
    //   156: aload_1
    //   157: athrow
    //   158: astore_1
    //   159: goto -21 -> 138
    //   162: astore_1
    //   163: goto -50 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	paramFile	File
    //   0	166	1	paramObject	Object
    //   0	166	2	paramBoolean	boolean
    //   32	116	3	bool	boolean
    //   48	95	4	localObject1	Object
    //   37	73	5	localObject2	Object
    //   34	101	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   39	50	108	java/io/IOException
    //   39	50	133	java/lang/RuntimeException
    //   50	71	158	java/lang/RuntimeException
    //   71	92	158	java/lang/RuntimeException
    //   92	106	158	java/lang/RuntimeException
    //   50	71	162	java/io/IOException
    //   71	92	162	java/io/IOException
    //   92	106	162	java/io/IOException
  }
  
  public void close()
    throws IOException
  {
    out.close();
  }
  
  public void flush()
    throws IOException
  {
    out.flush();
  }
  
  public void write(int paramInt)
    throws IOException
  {
    out.write(paramInt);
  }
  
  public void write(String paramString)
    throws IOException
  {
    out.write(paramString);
  }
  
  public void write(String paramString, int paramInt1, int paramInt2)
    throws IOException
  {
    out.write(paramString, paramInt1, paramInt2);
  }
  
  public void write(char[] paramArrayOfChar)
    throws IOException
  {
    out.write(paramArrayOfChar);
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    out.write(paramArrayOfChar, paramInt1, paramInt2);
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.output.FileWriterWithEncoding
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */