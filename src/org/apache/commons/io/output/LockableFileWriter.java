package org.apache.commons.io.output;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;

public class LockableFileWriter
  extends Writer
{
  private static final String LCK = ".lck";
  private final File lockFile;
  private final Writer out;
  
  public LockableFileWriter(File paramFile)
    throws IOException
  {
    this(paramFile, false, null);
  }
  
  public LockableFileWriter(File paramFile, String paramString)
    throws IOException
  {
    this(paramFile, paramString, false, null);
  }
  
  public LockableFileWriter(File paramFile, String paramString1, boolean paramBoolean, String paramString2)
    throws IOException
  {
    this(paramFile, Charsets.toCharset(paramString1), paramBoolean, paramString2);
  }
  
  public LockableFileWriter(File paramFile, Charset paramCharset)
    throws IOException
  {
    this(paramFile, paramCharset, false, null);
  }
  
  public LockableFileWriter(File paramFile, Charset paramCharset, boolean paramBoolean, String paramString)
    throws IOException
  {
    File localFile = paramFile.getAbsoluteFile();
    if (localFile.getParentFile() != null) {
      FileUtils.forceMkdir(localFile.getParentFile());
    }
    if (localFile.isDirectory()) {
      throw new IOException("File specified is a directory");
    }
    paramFile = paramString;
    if (paramString == null) {
      paramFile = System.getProperty("java.io.tmpdir");
    }
    paramFile = new File(paramFile);
    FileUtils.forceMkdir(paramFile);
    testLockDir(paramFile);
    lockFile = new File(paramFile, localFile.getName() + ".lck");
    createLock();
    out = initWriter(localFile, paramCharset, paramBoolean);
  }
  
  public LockableFileWriter(File paramFile, boolean paramBoolean)
    throws IOException
  {
    this(paramFile, paramBoolean, null);
  }
  
  public LockableFileWriter(File paramFile, boolean paramBoolean, String paramString)
    throws IOException
  {
    this(paramFile, Charset.defaultCharset(), paramBoolean, paramString);
  }
  
  public LockableFileWriter(String paramString)
    throws IOException
  {
    this(paramString, false, null);
  }
  
  public LockableFileWriter(String paramString, boolean paramBoolean)
    throws IOException
  {
    this(paramString, paramBoolean, null);
  }
  
  public LockableFileWriter(String paramString1, boolean paramBoolean, String paramString2)
    throws IOException
  {
    this(new File(paramString1), paramBoolean, paramString2);
  }
  
  private void createLock()
    throws IOException
  {
    try
    {
      if (!lockFile.createNewFile()) {
        throw new IOException("Can't write file, lock " + lockFile.getAbsolutePath() + " exists");
      }
    }
    finally {}
    lockFile.deleteOnExit();
  }
  
  /* Error */
  private Writer initWriter(File paramFile, Charset paramCharset, boolean paramBoolean)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 129	java/io/File:exists	()Z
    //   4: istore 4
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 6
    //   12: new 131	java/io/FileOutputStream
    //   15: dup
    //   16: aload_1
    //   17: invokevirtual 119	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   20: iload_3
    //   21: invokespecial 133	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   24: astore 5
    //   26: new 135	java/io/OutputStreamWriter
    //   29: dup
    //   30: aload 5
    //   32: aload_2
    //   33: invokestatic 138	org/apache/commons/io/Charsets:toCharset	(Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;
    //   36: invokespecial 141	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   39: astore_2
    //   40: aload_2
    //   41: areturn
    //   42: astore_2
    //   43: aload 6
    //   45: astore 5
    //   47: aconst_null
    //   48: invokestatic 147	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/Writer;)V
    //   51: aload 5
    //   53: invokestatic 150	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   56: aload_0
    //   57: getfield 91	org/apache/commons/io/output/LockableFileWriter:lockFile	Ljava/io/File;
    //   60: invokestatic 154	org/apache/commons/io/FileUtils:deleteQuietly	(Ljava/io/File;)Z
    //   63: pop
    //   64: iload 4
    //   66: ifne +8 -> 74
    //   69: aload_1
    //   70: invokestatic 154	org/apache/commons/io/FileUtils:deleteQuietly	(Ljava/io/File;)Z
    //   73: pop
    //   74: aload_2
    //   75: athrow
    //   76: astore_2
    //   77: aload 7
    //   79: astore 5
    //   81: aconst_null
    //   82: invokestatic 147	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/Writer;)V
    //   85: aload 5
    //   87: invokestatic 150	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   90: aload_0
    //   91: getfield 91	org/apache/commons/io/output/LockableFileWriter:lockFile	Ljava/io/File;
    //   94: invokestatic 154	org/apache/commons/io/FileUtils:deleteQuietly	(Ljava/io/File;)Z
    //   97: pop
    //   98: iload 4
    //   100: ifne +8 -> 108
    //   103: aload_1
    //   104: invokestatic 154	org/apache/commons/io/FileUtils:deleteQuietly	(Ljava/io/File;)Z
    //   107: pop
    //   108: aload_2
    //   109: athrow
    //   110: astore_2
    //   111: goto -30 -> 81
    //   114: astore_2
    //   115: goto -68 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	LockableFileWriter
    //   0	118	1	paramFile	File
    //   0	118	2	paramCharset	Charset
    //   0	118	3	paramBoolean	boolean
    //   4	95	4	bool	boolean
    //   24	62	5	localObject1	Object
    //   10	34	6	localObject2	Object
    //   7	71	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   12	26	42	java/io/IOException
    //   12	26	76	java/lang/RuntimeException
    //   26	40	110	java/lang/RuntimeException
    //   26	40	114	java/io/IOException
  }
  
  private void testLockDir(File paramFile)
    throws IOException
  {
    if (!paramFile.exists()) {
      throw new IOException("Could not find lockDir: " + paramFile.getAbsolutePath());
    }
    if (!paramFile.canWrite()) {
      throw new IOException("Could not write to lockDir: " + paramFile.getAbsolutePath());
    }
  }
  
  public void close()
    throws IOException
  {
    try
    {
      out.close();
      return;
    }
    finally
    {
      lockFile.delete();
    }
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
 * Qualified Name:     org.apache.commons.io.output.LockableFileWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */