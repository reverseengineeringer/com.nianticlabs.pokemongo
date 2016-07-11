package org.apache.commons.io;

import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.CRC32;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

public class FileUtils
{
  public static final File[] EMPTY_FILE_ARRAY = new File[0];
  private static final long FILE_COPY_BUFFER_SIZE = 31457280L;
  public static final long ONE_EB = 1152921504606846976L;
  public static final BigInteger ONE_EB_BI;
  public static final long ONE_GB = 1073741824L;
  public static final BigInteger ONE_GB_BI;
  public static final long ONE_KB = 1024L;
  public static final BigInteger ONE_KB_BI = BigInteger.valueOf(1024L);
  public static final long ONE_MB = 1048576L;
  public static final BigInteger ONE_MB_BI = ONE_KB_BI.multiply(ONE_KB_BI);
  public static final long ONE_PB = 1125899906842624L;
  public static final BigInteger ONE_PB_BI;
  public static final long ONE_TB = 1099511627776L;
  public static final BigInteger ONE_TB_BI;
  public static final BigInteger ONE_YB;
  public static final BigInteger ONE_ZB;
  private static final Charset UTF8 = Charset.forName("UTF-8");
  
  static
  {
    ONE_GB_BI = ONE_KB_BI.multiply(ONE_MB_BI);
    ONE_TB_BI = ONE_KB_BI.multiply(ONE_GB_BI);
    ONE_PB_BI = ONE_KB_BI.multiply(ONE_TB_BI);
    ONE_EB_BI = ONE_KB_BI.multiply(ONE_PB_BI);
    ONE_ZB = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(1152921504606846976L));
    ONE_YB = ONE_KB_BI.multiply(ONE_ZB);
  }
  
  public static String byteCountToDisplaySize(long paramLong)
  {
    return byteCountToDisplaySize(BigInteger.valueOf(paramLong));
  }
  
  public static String byteCountToDisplaySize(BigInteger paramBigInteger)
  {
    if (paramBigInteger.divide(ONE_EB_BI).compareTo(BigInteger.ZERO) > 0) {
      return String.valueOf(paramBigInteger.divide(ONE_EB_BI)) + " EB";
    }
    if (paramBigInteger.divide(ONE_PB_BI).compareTo(BigInteger.ZERO) > 0) {
      return String.valueOf(paramBigInteger.divide(ONE_PB_BI)) + " PB";
    }
    if (paramBigInteger.divide(ONE_TB_BI).compareTo(BigInteger.ZERO) > 0) {
      return String.valueOf(paramBigInteger.divide(ONE_TB_BI)) + " TB";
    }
    if (paramBigInteger.divide(ONE_GB_BI).compareTo(BigInteger.ZERO) > 0) {
      return String.valueOf(paramBigInteger.divide(ONE_GB_BI)) + " GB";
    }
    if (paramBigInteger.divide(ONE_MB_BI).compareTo(BigInteger.ZERO) > 0) {
      return String.valueOf(paramBigInteger.divide(ONE_MB_BI)) + " MB";
    }
    if (paramBigInteger.divide(ONE_KB_BI).compareTo(BigInteger.ZERO) > 0) {
      return String.valueOf(paramBigInteger.divide(ONE_KB_BI)) + " KB";
    }
    return String.valueOf(paramBigInteger) + " bytes";
  }
  
  private static void checkDirectory(File paramFile)
  {
    if (!paramFile.exists()) {
      throw new IllegalArgumentException(paramFile + " does not exist");
    }
    if (!paramFile.isDirectory()) {
      throw new IllegalArgumentException(paramFile + " is not a directory");
    }
  }
  
  /* Error */
  public static java.util.zip.Checksum checksum(File paramFile, java.util.zip.Checksum paramChecksum)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 149	java/io/File:isDirectory	()Z
    //   4: ifeq +13 -> 17
    //   7: new 138	java/lang/IllegalArgumentException
    //   10: dup
    //   11: ldc -99
    //   13: invokespecial 146	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: aconst_null
    //   18: astore_2
    //   19: new 159	java/util/zip/CheckedInputStream
    //   22: dup
    //   23: new 161	java/io/FileInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 163	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: aload_1
    //   32: invokespecial 166	java/util/zip/CheckedInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Checksum;)V
    //   35: astore_0
    //   36: aload_0
    //   37: new 168	org/apache/commons/io/output/NullOutputStream
    //   40: dup
    //   41: invokespecial 169	org/apache/commons/io/output/NullOutputStream:<init>	()V
    //   44: invokestatic 175	org/apache/commons/io/IOUtils:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   47: pop
    //   48: aload_0
    //   49: invokestatic 179	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   52: aload_1
    //   53: areturn
    //   54: astore_1
    //   55: aload_2
    //   56: astore_0
    //   57: aload_0
    //   58: invokestatic 179	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   61: aload_1
    //   62: athrow
    //   63: astore_1
    //   64: goto -7 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramFile	File
    //   0	67	1	paramChecksum	java.util.zip.Checksum
    //   18	38	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   19	36	54	finally
    //   36	48	63	finally
  }
  
  public static long checksumCRC32(File paramFile)
    throws IOException
  {
    CRC32 localCRC32 = new CRC32();
    checksum(paramFile, localCRC32);
    return localCRC32.getValue();
  }
  
  public static void cleanDirectory(File paramFile)
    throws IOException
  {
    if (!paramFile.exists()) {
      throw new IllegalArgumentException(paramFile + " does not exist");
    }
    if (!paramFile.isDirectory()) {
      throw new IllegalArgumentException(paramFile + " is not a directory");
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null) {
      throw new IOException("Failed to list contents of " + paramFile);
    }
    paramFile = null;
    int j = arrayOfFile.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        File localFile = arrayOfFile[i];
        try
        {
          forceDelete(localFile);
          i += 1;
        }
        catch (IOException paramFile)
        {
          for (;;) {}
        }
      }
    }
    if (paramFile != null) {
      throw paramFile;
    }
  }
  
  private static void cleanDirectoryOnExit(File paramFile)
    throws IOException
  {
    if (!paramFile.exists()) {
      throw new IllegalArgumentException(paramFile + " does not exist");
    }
    if (!paramFile.isDirectory()) {
      throw new IllegalArgumentException(paramFile + " is not a directory");
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null) {
      throw new IOException("Failed to list contents of " + paramFile);
    }
    paramFile = null;
    int j = arrayOfFile.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        File localFile = arrayOfFile[i];
        try
        {
          forceDeleteOnExit(localFile);
          i += 1;
        }
        catch (IOException paramFile)
        {
          for (;;) {}
        }
      }
    }
    if (paramFile != null) {
      throw paramFile;
    }
  }
  
  /* Error */
  public static boolean contentEquals(File paramFile1, File paramFile2)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 136	java/io/File:exists	()Z
    //   4: istore_2
    //   5: iload_2
    //   6: aload_1
    //   7: invokevirtual 136	java/io/File:exists	()Z
    //   10: if_icmpeq +5 -> 15
    //   13: iconst_0
    //   14: ireturn
    //   15: iload_2
    //   16: ifne +5 -> 21
    //   19: iconst_1
    //   20: ireturn
    //   21: aload_0
    //   22: invokevirtual 149	java/io/File:isDirectory	()Z
    //   25: ifne +10 -> 35
    //   28: aload_1
    //   29: invokevirtual 149	java/io/File:isDirectory	()Z
    //   32: ifeq +13 -> 45
    //   35: new 155	java/io/IOException
    //   38: dup
    //   39: ldc -46
    //   41: invokespecial 199	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   44: athrow
    //   45: aload_0
    //   46: invokevirtual 213	java/io/File:length	()J
    //   49: aload_1
    //   50: invokevirtual 213	java/io/File:length	()J
    //   53: lcmp
    //   54: ifne -41 -> 13
    //   57: aload_0
    //   58: invokevirtual 217	java/io/File:getCanonicalFile	()Ljava/io/File;
    //   61: aload_1
    //   62: invokevirtual 217	java/io/File:getCanonicalFile	()Ljava/io/File;
    //   65: invokevirtual 221	java/io/File:equals	(Ljava/lang/Object;)Z
    //   68: ifeq +5 -> 73
    //   71: iconst_1
    //   72: ireturn
    //   73: aconst_null
    //   74: astore 4
    //   76: aconst_null
    //   77: astore_3
    //   78: new 161	java/io/FileInputStream
    //   81: dup
    //   82: aload_0
    //   83: invokespecial 163	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   86: astore_0
    //   87: new 161	java/io/FileInputStream
    //   90: dup
    //   91: aload_1
    //   92: invokespecial 163	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   95: astore 4
    //   97: aload_0
    //   98: aload 4
    //   100: invokestatic 224	org/apache/commons/io/IOUtils:contentEquals	(Ljava/io/InputStream;Ljava/io/InputStream;)Z
    //   103: istore_2
    //   104: aload_0
    //   105: invokestatic 179	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   108: aload 4
    //   110: invokestatic 179	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   113: iload_2
    //   114: ireturn
    //   115: astore_1
    //   116: aload 4
    //   118: astore_0
    //   119: aload_0
    //   120: invokestatic 179	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   123: aload_3
    //   124: invokestatic 179	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   127: aload_1
    //   128: athrow
    //   129: astore_1
    //   130: goto -11 -> 119
    //   133: astore_1
    //   134: aload 4
    //   136: astore_3
    //   137: goto -18 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	paramFile1	File
    //   0	140	1	paramFile2	File
    //   4	110	2	bool	boolean
    //   77	60	3	localObject	Object
    //   74	61	4	localFileInputStream	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   78	87	115	finally
    //   87	97	129	finally
    //   97	104	133	finally
  }
  
  public static boolean contentEqualsIgnoreEOL(File paramFile1, File paramFile2, String paramString)
    throws IOException
  {
    boolean bool2 = true;
    boolean bool3 = paramFile1.exists();
    boolean bool1;
    if (bool3 != paramFile2.exists()) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!bool3);
      if ((paramFile1.isDirectory()) || (paramFile2.isDirectory())) {
        throw new IOException("Can't compare directories, only files");
      }
      bool1 = bool2;
    } while (paramFile1.getCanonicalFile().equals(paramFile2.getCanonicalFile()));
    localFile = null;
    localObject2 = null;
    localObject1 = null;
    if (paramString == null) {}
    for (;;)
    {
      try
      {
        paramString = new InputStreamReader(new FileInputStream(paramFile1));
        paramFile1 = paramString;
      }
      finally {}
      try
      {
        paramFile2 = new InputStreamReader(new FileInputStream(paramFile2));
        paramFile1 = paramString;
        localFile = paramFile1;
        localObject1 = paramFile2;
        bool1 = IOUtils.contentEqualsIgnoreEOL(paramFile1, paramFile2);
        IOUtils.closeQuietly(paramFile1);
        IOUtils.closeQuietly(paramFile2);
        return bool1;
      }
      finally
      {
        for (;;)
        {
          localFile = paramFile1;
          localObject1 = localObject2;
          paramFile1 = paramFile2;
        }
      }
      InputStreamReader localInputStreamReader = new InputStreamReader(new FileInputStream(paramFile1), paramString);
      paramFile1 = localInputStreamReader;
      paramFile2 = new InputStreamReader(new FileInputStream(paramFile2), paramString);
      paramFile1 = localInputStreamReader;
    }
    IOUtils.closeQuietly(localFile);
    IOUtils.closeQuietly((Reader)localObject1);
    throw paramFile1;
  }
  
  public static File[] convertFileCollectionToFileArray(Collection<File> paramCollection)
  {
    return (File[])paramCollection.toArray(new File[paramCollection.size()]);
  }
  
  public static void copyDirectory(File paramFile1, File paramFile2)
    throws IOException
  {
    copyDirectory(paramFile1, paramFile2, true);
  }
  
  public static void copyDirectory(File paramFile1, File paramFile2, FileFilter paramFileFilter)
    throws IOException
  {
    copyDirectory(paramFile1, paramFile2, paramFileFilter, true);
  }
  
  public static void copyDirectory(File paramFile1, File paramFile2, FileFilter paramFileFilter, boolean paramBoolean)
    throws IOException
  {
    if (paramFile1 == null) {
      throw new NullPointerException("Source must not be null");
    }
    if (paramFile2 == null) {
      throw new NullPointerException("Destination must not be null");
    }
    if (!paramFile1.exists()) {
      throw new FileNotFoundException("Source '" + paramFile1 + "' does not exist");
    }
    if (!paramFile1.isDirectory()) {
      throw new IOException("Source '" + paramFile1 + "' exists but is not a directory");
    }
    if (paramFile1.getCanonicalPath().equals(paramFile2.getCanonicalPath())) {
      throw new IOException("Source '" + paramFile1 + "' and destination '" + paramFile2 + "' are the same");
    }
    ArrayList localArrayList2 = null;
    ArrayList localArrayList1 = localArrayList2;
    if (paramFile2.getCanonicalPath().startsWith(paramFile1.getCanonicalPath()))
    {
      if (paramFileFilter == null) {}
      for (File[] arrayOfFile = paramFile1.listFiles();; arrayOfFile = paramFile1.listFiles(paramFileFilter))
      {
        localArrayList1 = localArrayList2;
        if (arrayOfFile == null) {
          break;
        }
        localArrayList1 = localArrayList2;
        if (arrayOfFile.length <= 0) {
          break;
        }
        localArrayList2 = new ArrayList(arrayOfFile.length);
        int j = arrayOfFile.length;
        int i = 0;
        for (;;)
        {
          localArrayList1 = localArrayList2;
          if (i >= j) {
            break;
          }
          localArrayList2.add(new File(paramFile2, arrayOfFile[i].getName()).getCanonicalPath());
          i += 1;
        }
      }
    }
    doCopyDirectory(paramFile1, paramFile2, paramFileFilter, paramBoolean, localArrayList1);
  }
  
  public static void copyDirectory(File paramFile1, File paramFile2, boolean paramBoolean)
    throws IOException
  {
    copyDirectory(paramFile1, paramFile2, null, paramBoolean);
  }
  
  public static void copyDirectoryToDirectory(File paramFile1, File paramFile2)
    throws IOException
  {
    if (paramFile1 == null) {
      throw new NullPointerException("Source must not be null");
    }
    if ((paramFile1.exists()) && (!paramFile1.isDirectory())) {
      throw new IllegalArgumentException("Source '" + paramFile2 + "' is not a directory");
    }
    if (paramFile2 == null) {
      throw new NullPointerException("Destination must not be null");
    }
    if ((paramFile2.exists()) && (!paramFile2.isDirectory())) {
      throw new IllegalArgumentException("Destination '" + paramFile2 + "' is not a directory");
    }
    copyDirectory(paramFile1, new File(paramFile2, paramFile1.getName()), true);
  }
  
  public static long copyFile(File paramFile, OutputStream paramOutputStream)
    throws IOException
  {
    paramFile = new FileInputStream(paramFile);
    try
    {
      long l = IOUtils.copyLarge(paramFile, paramOutputStream);
      return l;
    }
    finally
    {
      paramFile.close();
    }
  }
  
  public static void copyFile(File paramFile1, File paramFile2)
    throws IOException
  {
    copyFile(paramFile1, paramFile2, true);
  }
  
  public static void copyFile(File paramFile1, File paramFile2, boolean paramBoolean)
    throws IOException
  {
    if (paramFile1 == null) {
      throw new NullPointerException("Source must not be null");
    }
    if (paramFile2 == null) {
      throw new NullPointerException("Destination must not be null");
    }
    if (!paramFile1.exists()) {
      throw new FileNotFoundException("Source '" + paramFile1 + "' does not exist");
    }
    if (paramFile1.isDirectory()) {
      throw new IOException("Source '" + paramFile1 + "' exists but is a directory");
    }
    if (paramFile1.getCanonicalPath().equals(paramFile2.getCanonicalPath())) {
      throw new IOException("Source '" + paramFile1 + "' and destination '" + paramFile2 + "' are the same");
    }
    File localFile = paramFile2.getParentFile();
    if ((localFile != null) && (!localFile.mkdirs()) && (!localFile.isDirectory())) {
      throw new IOException("Destination '" + localFile + "' directory cannot be created");
    }
    if ((paramFile2.exists()) && (!paramFile2.canWrite())) {
      throw new IOException("Destination '" + paramFile2 + "' exists but is read-only");
    }
    doCopyFile(paramFile1, paramFile2, paramBoolean);
  }
  
  public static void copyFileToDirectory(File paramFile1, File paramFile2)
    throws IOException
  {
    copyFileToDirectory(paramFile1, paramFile2, true);
  }
  
  public static void copyFileToDirectory(File paramFile1, File paramFile2, boolean paramBoolean)
    throws IOException
  {
    if (paramFile2 == null) {
      throw new NullPointerException("Destination must not be null");
    }
    if ((paramFile2.exists()) && (!paramFile2.isDirectory())) {
      throw new IllegalArgumentException("Destination '" + paramFile2 + "' is not a directory");
    }
    copyFile(paramFile1, new File(paramFile2, paramFile1.getName()), paramBoolean);
  }
  
  /* Error */
  public static void copyInputStreamToFile(InputStream paramInputStream, File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 357	org/apache/commons/io/FileUtils:openOutputStream	(Ljava/io/File;)Ljava/io/FileOutputStream;
    //   4: astore_1
    //   5: aload_0
    //   6: aload_1
    //   7: invokestatic 175	org/apache/commons/io/IOUtils:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   10: pop
    //   11: aload_1
    //   12: invokevirtual 360	java/io/FileOutputStream:close	()V
    //   15: aload_1
    //   16: invokestatic 363	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   19: aload_0
    //   20: invokestatic 179	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   23: return
    //   24: astore_2
    //   25: aload_1
    //   26: invokestatic 363	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   29: aload_2
    //   30: athrow
    //   31: astore_1
    //   32: aload_0
    //   33: invokestatic 179	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	paramInputStream	InputStream
    //   0	38	1	paramFile	File
    //   24	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	15	24	finally
    //   0	5	31	finally
    //   15	19	31	finally
    //   25	31	31	finally
  }
  
  public static void copyURLToFile(URL paramURL, File paramFile)
    throws IOException
  {
    copyInputStreamToFile(paramURL.openStream(), paramFile);
  }
  
  public static void copyURLToFile(URL paramURL, File paramFile, int paramInt1, int paramInt2)
    throws IOException
  {
    paramURL = paramURL.openConnection();
    paramURL.setConnectTimeout(paramInt1);
    paramURL.setReadTimeout(paramInt2);
    copyInputStreamToFile(paramURL.getInputStream(), paramFile);
  }
  
  static String decodeUrl(String paramString)
  {
    Object localObject1 = paramString;
    Object localObject2 = localObject1;
    if (paramString != null)
    {
      localObject2 = localObject1;
      if (paramString.indexOf('%') >= 0)
      {
        int m = paramString.length();
        localObject1 = new StringBuffer();
        localObject2 = ByteBuffer.allocate(m);
        int i = 0;
        while (i < m)
        {
          int j = i;
          int k;
          if (paramString.charAt(i) == '%')
          {
            k = i;
            label68:
            i = k;
          }
          try
          {
            ((ByteBuffer)localObject2).put((byte)Integer.parseInt(paramString.substring(k + 1, k + 3), 16));
            j = k + 3;
            if (j < m)
            {
              i = j;
              int n = paramString.charAt(j);
              k = j;
              if (n == 37) {
                break label68;
              }
            }
            i = j;
            if (((ByteBuffer)localObject2).position() > 0)
            {
              ((ByteBuffer)localObject2).flip();
              ((StringBuffer)localObject1).append(UTF8.decode((ByteBuffer)localObject2).toString());
              ((ByteBuffer)localObject2).clear();
              i = j;
            }
          }
          catch (RuntimeException localRuntimeException)
          {
            j = i;
            if (((ByteBuffer)localObject2).position() > 0)
            {
              ((ByteBuffer)localObject2).flip();
              ((StringBuffer)localObject1).append(UTF8.decode((ByteBuffer)localObject2).toString());
              ((ByteBuffer)localObject2).clear();
              j = i;
            }
            ((StringBuffer)localObject1).append(paramString.charAt(j));
            i = j + 1;
          }
          finally
          {
            if (((ByteBuffer)localObject2).position() > 0)
            {
              ((ByteBuffer)localObject2).flip();
              ((StringBuffer)localObject1).append(UTF8.decode((ByteBuffer)localObject2).toString());
              ((ByteBuffer)localObject2).clear();
            }
          }
        }
        localObject2 = ((StringBuffer)localObject1).toString();
      }
    }
    return (String)localObject2;
  }
  
  public static void deleteDirectory(File paramFile)
    throws IOException
  {
    if (!paramFile.exists()) {}
    do
    {
      return;
      if (!isSymlink(paramFile)) {
        cleanDirectory(paramFile);
      }
    } while (paramFile.delete());
    throw new IOException("Unable to delete directory " + paramFile + ".");
  }
  
  private static void deleteDirectoryOnExit(File paramFile)
    throws IOException
  {
    if (!paramFile.exists()) {}
    do
    {
      return;
      paramFile.deleteOnExit();
    } while (isSymlink(paramFile));
    cleanDirectoryOnExit(paramFile);
  }
  
  public static boolean deleteQuietly(File paramFile)
  {
    if (paramFile == null) {
      return false;
    }
    try
    {
      if (paramFile.isDirectory()) {
        cleanDirectory(paramFile);
      }
      try
      {
        boolean bool = paramFile.delete();
        return bool;
      }
      catch (Exception paramFile)
      {
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public static boolean directoryContains(File paramFile1, File paramFile2)
    throws IOException
  {
    if (paramFile1 == null) {
      throw new IllegalArgumentException("Directory must not be null");
    }
    if (!paramFile1.isDirectory()) {
      throw new IllegalArgumentException("Not a directory: " + paramFile1);
    }
    if (paramFile2 == null) {}
    while ((!paramFile1.exists()) || (!paramFile2.exists())) {
      return false;
    }
    return FilenameUtils.directoryContains(paramFile1.getCanonicalPath(), paramFile2.getCanonicalPath());
  }
  
  private static void doCopyDirectory(File paramFile1, File paramFile2, FileFilter paramFileFilter, boolean paramBoolean, List<String> paramList)
    throws IOException
  {
    if (paramFileFilter == null) {}
    for (File[] arrayOfFile = paramFile1.listFiles(); arrayOfFile == null; arrayOfFile = paramFile1.listFiles(paramFileFilter)) {
      throw new IOException("Failed to list contents of " + paramFile1);
    }
    if (paramFile2.exists())
    {
      if (!paramFile2.isDirectory()) {
        throw new IOException("Destination '" + paramFile2 + "' exists but is not a directory");
      }
    }
    else if ((!paramFile2.mkdirs()) && (!paramFile2.isDirectory())) {
      throw new IOException("Destination '" + paramFile2 + "' directory cannot be created");
    }
    if (!paramFile2.canWrite()) {
      throw new IOException("Destination '" + paramFile2 + "' cannot be written to");
    }
    int j = arrayOfFile.length;
    int i = 0;
    if (i < j)
    {
      File localFile1 = arrayOfFile[i];
      File localFile2 = new File(paramFile2, localFile1.getName());
      if ((paramList == null) || (!paramList.contains(localFile1.getCanonicalPath())))
      {
        if (!localFile1.isDirectory()) {
          break label274;
        }
        doCopyDirectory(localFile1, localFile2, paramFileFilter, paramBoolean, paramList);
      }
      for (;;)
      {
        i += 1;
        break;
        label274:
        doCopyFile(localFile1, localFile2, paramBoolean);
      }
    }
    if (paramBoolean) {
      paramFile2.setLastModified(paramFile1.lastModified());
    }
  }
  
  private static void doCopyFile(File paramFile1, File paramFile2, boolean paramBoolean)
    throws IOException
  {
    if ((paramFile2.exists()) && (paramFile2.isDirectory())) {
      throw new IOException("Destination '" + paramFile2 + "' exists but is a directory");
    }
    localFileOutputStream = null;
    localFileChannel2 = null;
    Object localObject5 = null;
    Object localObject2 = null;
    FileChannel localFileChannel3 = null;
    FileChannel localFileChannel1 = null;
    for (;;)
    {
      try
      {
        localObject3 = new FileInputStream(paramFile1);
      }
      finally
      {
        Object localObject1;
        localObject3 = localFileChannel2;
        paramFile1 = localFileOutputStream;
        IOUtils.closeQuietly(localFileChannel1);
        IOUtils.closeQuietly((OutputStream)localObject3);
        IOUtils.closeQuietly((Closeable)localObject2);
        IOUtils.closeQuietly(paramFile1);
      }
      try
      {
        localFileOutputStream = new FileOutputStream(paramFile2);
        localFileChannel1 = localFileChannel3;
        localObject2 = localObject5;
      }
      finally
      {
        paramFile1 = (File)localObject3;
        localObject3 = localFileChannel2;
        continue;
      }
      try
      {
        localFileChannel2 = ((FileInputStream)localObject3).getChannel();
        localFileChannel1 = localFileChannel3;
        localObject2 = localFileChannel2;
        localFileChannel3 = localFileOutputStream.getChannel();
        localFileChannel1 = localFileChannel3;
        localObject2 = localFileChannel2;
        l3 = localFileChannel2.size();
        l1 = 0L;
      }
      finally
      {
        paramFile2 = localFileOutputStream;
        paramFile1 = (File)localObject3;
        localObject3 = paramFile2;
        paramFile2 = (File)localObject4;
        continue;
        if (l1 >= l3) {
          continue;
        }
        if (l3 - l1 <= 31457280L) {
          continue;
        }
        l2 = 31457280L;
        continue;
      }
      localFileChannel1 = localFileChannel3;
      localObject2 = localFileChannel2;
      l2 = localFileChannel3.transferFrom(localFileChannel2, l1, localObject1);
      l1 += l2;
      break label320;
      l2 = l3 - l1;
      continue;
      IOUtils.closeQuietly(localFileChannel3);
      IOUtils.closeQuietly(localFileOutputStream);
      IOUtils.closeQuietly(localFileChannel2);
      IOUtils.closeQuietly((InputStream)localObject3);
      if (paramFile1.length() != paramFile2.length()) {
        throw new IOException("Failed to copy full contents from '" + paramFile1 + "' to '" + paramFile2 + "'");
      }
    }
    if (paramBoolean) {
      paramFile2.setLastModified(paramFile1.lastModified());
    }
  }
  
  public static void forceDelete(File paramFile)
    throws IOException
  {
    if (paramFile.isDirectory()) {
      deleteDirectory(paramFile);
    }
    boolean bool;
    do
    {
      return;
      bool = paramFile.exists();
    } while (paramFile.delete());
    if (!bool) {
      throw new FileNotFoundException("File does not exist: " + paramFile);
    }
    throw new IOException("Unable to delete file: " + paramFile);
  }
  
  public static void forceDeleteOnExit(File paramFile)
    throws IOException
  {
    if (paramFile.isDirectory())
    {
      deleteDirectoryOnExit(paramFile);
      return;
    }
    paramFile.deleteOnExit();
  }
  
  public static void forceMkdir(File paramFile)
    throws IOException
  {
    if (paramFile.exists())
    {
      if (!paramFile.isDirectory()) {
        throw new IOException("File " + paramFile + " exists and is " + "not a directory. Unable to create directory.");
      }
    }
    else if ((!paramFile.mkdirs()) && (!paramFile.isDirectory())) {
      throw new IOException("Unable to create directory " + paramFile);
    }
  }
  
  public static File getFile(File paramFile, String... paramVarArgs)
  {
    if (paramFile == null) {
      throw new NullPointerException("directorydirectory must not be null");
    }
    if (paramVarArgs == null) {
      throw new NullPointerException("names must not be null");
    }
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramFile = new File(paramFile, paramVarArgs[i]);
      i += 1;
    }
    return paramFile;
  }
  
  public static File getFile(String... paramVarArgs)
  {
    if (paramVarArgs == null) {
      throw new NullPointerException("names must not be null");
    }
    int j = paramVarArgs.length;
    int i = 0;
    File localFile = null;
    if (i < j)
    {
      String str = paramVarArgs[i];
      if (localFile == null) {}
      for (localFile = new File(str);; localFile = new File(localFile, str))
      {
        i += 1;
        break;
      }
    }
    return localFile;
  }
  
  public static File getTempDirectory()
  {
    return new File(getTempDirectoryPath());
  }
  
  public static String getTempDirectoryPath()
  {
    return System.getProperty("java.io.tmpdir");
  }
  
  public static File getUserDirectory()
  {
    return new File(getUserDirectoryPath());
  }
  
  public static String getUserDirectoryPath()
  {
    return System.getProperty("user.home");
  }
  
  private static void innerListFiles(Collection<File> paramCollection, File paramFile, IOFileFilter paramIOFileFilter, boolean paramBoolean)
  {
    paramFile = paramFile.listFiles(paramIOFileFilter);
    if (paramFile != null)
    {
      int j = paramFile.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramFile[i];
        if (((File)localObject).isDirectory())
        {
          if (paramBoolean) {
            paramCollection.add(localObject);
          }
          innerListFiles(paramCollection, (File)localObject, paramIOFileFilter, paramBoolean);
        }
        for (;;)
        {
          i += 1;
          break;
          paramCollection.add(localObject);
        }
      }
    }
  }
  
  public static boolean isFileNewer(File paramFile, long paramLong)
  {
    if (paramFile == null) {
      throw new IllegalArgumentException("No specified file");
    }
    if (!paramFile.exists()) {}
    while (paramFile.lastModified() <= paramLong) {
      return false;
    }
    return true;
  }
  
  public static boolean isFileNewer(File paramFile1, File paramFile2)
  {
    if (paramFile2 == null) {
      throw new IllegalArgumentException("No specified reference file");
    }
    if (!paramFile2.exists()) {
      throw new IllegalArgumentException("The reference file '" + paramFile2 + "' doesn't exist");
    }
    return isFileNewer(paramFile1, paramFile2.lastModified());
  }
  
  public static boolean isFileNewer(File paramFile, Date paramDate)
  {
    if (paramDate == null) {
      throw new IllegalArgumentException("No specified date");
    }
    return isFileNewer(paramFile, paramDate.getTime());
  }
  
  public static boolean isFileOlder(File paramFile, long paramLong)
  {
    if (paramFile == null) {
      throw new IllegalArgumentException("No specified file");
    }
    if (!paramFile.exists()) {}
    while (paramFile.lastModified() >= paramLong) {
      return false;
    }
    return true;
  }
  
  public static boolean isFileOlder(File paramFile1, File paramFile2)
  {
    if (paramFile2 == null) {
      throw new IllegalArgumentException("No specified reference file");
    }
    if (!paramFile2.exists()) {
      throw new IllegalArgumentException("The reference file '" + paramFile2 + "' doesn't exist");
    }
    return isFileOlder(paramFile1, paramFile2.lastModified());
  }
  
  public static boolean isFileOlder(File paramFile, Date paramDate)
  {
    if (paramDate == null) {
      throw new IllegalArgumentException("No specified date");
    }
    return isFileOlder(paramFile, paramDate.getTime());
  }
  
  public static boolean isSymlink(File paramFile)
    throws IOException
  {
    if (paramFile == null) {
      throw new NullPointerException("File must not be null");
    }
    if (FilenameUtils.isSystemWindows()) {}
    for (;;)
    {
      return false;
      if (paramFile.getParent() == null) {}
      while (!paramFile.getCanonicalFile().equals(paramFile.getAbsoluteFile()))
      {
        return true;
        paramFile = new File(paramFile.getParentFile().getCanonicalFile(), paramFile.getName());
      }
    }
  }
  
  public static Iterator<File> iterateFiles(File paramFile, IOFileFilter paramIOFileFilter1, IOFileFilter paramIOFileFilter2)
  {
    return listFiles(paramFile, paramIOFileFilter1, paramIOFileFilter2).iterator();
  }
  
  public static Iterator<File> iterateFiles(File paramFile, String[] paramArrayOfString, boolean paramBoolean)
  {
    return listFiles(paramFile, paramArrayOfString, paramBoolean).iterator();
  }
  
  public static Iterator<File> iterateFilesAndDirs(File paramFile, IOFileFilter paramIOFileFilter1, IOFileFilter paramIOFileFilter2)
  {
    return listFilesAndDirs(paramFile, paramIOFileFilter1, paramIOFileFilter2).iterator();
  }
  
  public static LineIterator lineIterator(File paramFile)
    throws IOException
  {
    return lineIterator(paramFile, null);
  }
  
  public static LineIterator lineIterator(File paramFile, String paramString)
    throws IOException
  {
    File localFile2 = null;
    File localFile1 = null;
    try
    {
      paramFile = openInputStream(paramFile);
      localFile1 = paramFile;
      localFile2 = paramFile;
      paramFile = IOUtils.lineIterator(paramFile, paramString);
      return paramFile;
    }
    catch (IOException paramFile)
    {
      IOUtils.closeQuietly(localFile1);
      throw paramFile;
    }
    catch (RuntimeException paramFile)
    {
      IOUtils.closeQuietly(localFile2);
      throw paramFile;
    }
  }
  
  public static Collection<File> listFiles(File paramFile, IOFileFilter paramIOFileFilter1, IOFileFilter paramIOFileFilter2)
  {
    validateListFilesParameters(paramFile, paramIOFileFilter1);
    paramIOFileFilter1 = setUpEffectiveFileFilter(paramIOFileFilter1);
    paramIOFileFilter2 = setUpEffectiveDirFilter(paramIOFileFilter2);
    LinkedList localLinkedList = new LinkedList();
    innerListFiles(localLinkedList, paramFile, FileFilterUtils.or(new IOFileFilter[] { paramIOFileFilter1, paramIOFileFilter2 }), false);
    return localLinkedList;
  }
  
  public static Collection<File> listFiles(File paramFile, String[] paramArrayOfString, boolean paramBoolean)
  {
    if (paramArrayOfString == null)
    {
      paramArrayOfString = TrueFileFilter.INSTANCE;
      if (!paramBoolean) {
        break label38;
      }
    }
    label38:
    for (IOFileFilter localIOFileFilter = TrueFileFilter.INSTANCE;; localIOFileFilter = FalseFileFilter.INSTANCE)
    {
      return listFiles(paramFile, paramArrayOfString, localIOFileFilter);
      paramArrayOfString = new SuffixFileFilter(toSuffixes(paramArrayOfString));
      break;
    }
  }
  
  public static Collection<File> listFilesAndDirs(File paramFile, IOFileFilter paramIOFileFilter1, IOFileFilter paramIOFileFilter2)
  {
    validateListFilesParameters(paramFile, paramIOFileFilter1);
    paramIOFileFilter1 = setUpEffectiveFileFilter(paramIOFileFilter1);
    paramIOFileFilter2 = setUpEffectiveDirFilter(paramIOFileFilter2);
    LinkedList localLinkedList = new LinkedList();
    if (paramFile.isDirectory()) {
      localLinkedList.add(paramFile);
    }
    innerListFiles(localLinkedList, paramFile, FileFilterUtils.or(new IOFileFilter[] { paramIOFileFilter1, paramIOFileFilter2 }), true);
    return localLinkedList;
  }
  
  public static void moveDirectory(File paramFile1, File paramFile2)
    throws IOException
  {
    if (paramFile1 == null) {
      throw new NullPointerException("Source must not be null");
    }
    if (paramFile2 == null) {
      throw new NullPointerException("Destination must not be null");
    }
    if (!paramFile1.exists()) {
      throw new FileNotFoundException("Source '" + paramFile1 + "' does not exist");
    }
    if (!paramFile1.isDirectory()) {
      throw new IOException("Source '" + paramFile1 + "' is not a directory");
    }
    if (paramFile2.exists()) {
      throw new FileExistsException("Destination '" + paramFile2 + "' already exists");
    }
    if (!paramFile1.renameTo(paramFile2))
    {
      if (paramFile2.getCanonicalPath().startsWith(paramFile1.getCanonicalPath())) {
        throw new IOException("Cannot move directory: " + paramFile1 + " to a subdirectory of itself: " + paramFile2);
      }
      copyDirectory(paramFile1, paramFile2);
      deleteDirectory(paramFile1);
      if (paramFile1.exists()) {
        throw new IOException("Failed to delete original directory '" + paramFile1 + "' after copy to '" + paramFile2 + "'");
      }
    }
  }
  
  public static void moveDirectoryToDirectory(File paramFile1, File paramFile2, boolean paramBoolean)
    throws IOException
  {
    if (paramFile1 == null) {
      throw new NullPointerException("Source must not be null");
    }
    if (paramFile2 == null) {
      throw new NullPointerException("Destination directory must not be null");
    }
    if ((!paramFile2.exists()) && (paramBoolean)) {
      paramFile2.mkdirs();
    }
    if (!paramFile2.exists()) {
      throw new FileNotFoundException("Destination directory '" + paramFile2 + "' does not exist [createDestDir=" + paramBoolean + "]");
    }
    if (!paramFile2.isDirectory()) {
      throw new IOException("Destination '" + paramFile2 + "' is not a directory");
    }
    moveDirectory(paramFile1, new File(paramFile2, paramFile1.getName()));
  }
  
  public static void moveFile(File paramFile1, File paramFile2)
    throws IOException
  {
    if (paramFile1 == null) {
      throw new NullPointerException("Source must not be null");
    }
    if (paramFile2 == null) {
      throw new NullPointerException("Destination must not be null");
    }
    if (!paramFile1.exists()) {
      throw new FileNotFoundException("Source '" + paramFile1 + "' does not exist");
    }
    if (paramFile1.isDirectory()) {
      throw new IOException("Source '" + paramFile1 + "' is a directory");
    }
    if (paramFile2.exists()) {
      throw new FileExistsException("Destination '" + paramFile2 + "' already exists");
    }
    if (paramFile2.isDirectory()) {
      throw new IOException("Destination '" + paramFile2 + "' is a directory");
    }
    if (!paramFile1.renameTo(paramFile2))
    {
      copyFile(paramFile1, paramFile2);
      if (!paramFile1.delete())
      {
        deleteQuietly(paramFile2);
        throw new IOException("Failed to delete original file '" + paramFile1 + "' after copy to '" + paramFile2 + "'");
      }
    }
  }
  
  public static void moveFileToDirectory(File paramFile1, File paramFile2, boolean paramBoolean)
    throws IOException
  {
    if (paramFile1 == null) {
      throw new NullPointerException("Source must not be null");
    }
    if (paramFile2 == null) {
      throw new NullPointerException("Destination directory must not be null");
    }
    if ((!paramFile2.exists()) && (paramBoolean)) {
      paramFile2.mkdirs();
    }
    if (!paramFile2.exists()) {
      throw new FileNotFoundException("Destination directory '" + paramFile2 + "' does not exist [createDestDir=" + paramBoolean + "]");
    }
    if (!paramFile2.isDirectory()) {
      throw new IOException("Destination '" + paramFile2 + "' is not a directory");
    }
    moveFile(paramFile1, new File(paramFile2, paramFile1.getName()));
  }
  
  public static void moveToDirectory(File paramFile1, File paramFile2, boolean paramBoolean)
    throws IOException
  {
    if (paramFile1 == null) {
      throw new NullPointerException("Source must not be null");
    }
    if (paramFile2 == null) {
      throw new NullPointerException("Destination must not be null");
    }
    if (!paramFile1.exists()) {
      throw new FileNotFoundException("Source '" + paramFile1 + "' does not exist");
    }
    if (paramFile1.isDirectory())
    {
      moveDirectoryToDirectory(paramFile1, paramFile2, paramBoolean);
      return;
    }
    moveFileToDirectory(paramFile1, paramFile2, paramBoolean);
  }
  
  public static FileInputStream openInputStream(File paramFile)
    throws IOException
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory()) {
        throw new IOException("File '" + paramFile + "' exists but is a directory");
      }
      if (!paramFile.canRead()) {
        throw new IOException("File '" + paramFile + "' cannot be read");
      }
    }
    else
    {
      throw new FileNotFoundException("File '" + paramFile + "' does not exist");
    }
    return new FileInputStream(paramFile);
  }
  
  public static FileOutputStream openOutputStream(File paramFile)
    throws IOException
  {
    return openOutputStream(paramFile, false);
  }
  
  public static FileOutputStream openOutputStream(File paramFile, boolean paramBoolean)
    throws IOException
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory()) {
        throw new IOException("File '" + paramFile + "' exists but is a directory");
      }
      if (!paramFile.canWrite()) {
        throw new IOException("File '" + paramFile + "' cannot be written to");
      }
    }
    else
    {
      File localFile = paramFile.getParentFile();
      if ((localFile != null) && (!localFile.mkdirs()) && (!localFile.isDirectory())) {
        throw new IOException("Directory '" + localFile + "' could not be created");
      }
    }
    return new FileOutputStream(paramFile, paramBoolean);
  }
  
  public static byte[] readFileToByteArray(File paramFile)
    throws IOException
  {
    Object localObject = null;
    try
    {
      FileInputStream localFileInputStream = openInputStream(paramFile);
      localObject = localFileInputStream;
      paramFile = IOUtils.toByteArray(localFileInputStream, paramFile.length());
      IOUtils.closeQuietly(localFileInputStream);
      return paramFile;
    }
    finally
    {
      IOUtils.closeQuietly((InputStream)localObject);
    }
  }
  
  public static String readFileToString(File paramFile)
    throws IOException
  {
    return readFileToString(paramFile, Charset.defaultCharset());
  }
  
  public static String readFileToString(File paramFile, String paramString)
    throws IOException
  {
    return readFileToString(paramFile, Charsets.toCharset(paramString));
  }
  
  public static String readFileToString(File paramFile, Charset paramCharset)
    throws IOException
  {
    File localFile = null;
    try
    {
      paramFile = openInputStream(paramFile);
      localFile = paramFile;
      paramCharset = IOUtils.toString(paramFile, Charsets.toCharset(paramCharset));
      return paramCharset;
    }
    finally
    {
      IOUtils.closeQuietly(localFile);
    }
  }
  
  public static List<String> readLines(File paramFile)
    throws IOException
  {
    return readLines(paramFile, Charset.defaultCharset());
  }
  
  public static List<String> readLines(File paramFile, String paramString)
    throws IOException
  {
    return readLines(paramFile, Charsets.toCharset(paramString));
  }
  
  public static List<String> readLines(File paramFile, Charset paramCharset)
    throws IOException
  {
    File localFile = null;
    try
    {
      paramFile = openInputStream(paramFile);
      localFile = paramFile;
      paramCharset = IOUtils.readLines(paramFile, Charsets.toCharset(paramCharset));
      return paramCharset;
    }
    finally
    {
      IOUtils.closeQuietly(localFile);
    }
  }
  
  private static IOFileFilter setUpEffectiveDirFilter(IOFileFilter paramIOFileFilter)
  {
    if (paramIOFileFilter == null) {
      return FalseFileFilter.INSTANCE;
    }
    return FileFilterUtils.and(new IOFileFilter[] { paramIOFileFilter, DirectoryFileFilter.INSTANCE });
  }
  
  private static IOFileFilter setUpEffectiveFileFilter(IOFileFilter paramIOFileFilter)
  {
    return FileFilterUtils.and(new IOFileFilter[] { paramIOFileFilter, FileFilterUtils.notFileFilter(DirectoryFileFilter.INSTANCE) });
  }
  
  public static long sizeOf(File paramFile)
  {
    if (!paramFile.exists()) {
      throw new IllegalArgumentException(paramFile + " does not exist");
    }
    if (paramFile.isDirectory()) {
      return sizeOfDirectory(paramFile);
    }
    return paramFile.length();
  }
  
  public static BigInteger sizeOfAsBigInteger(File paramFile)
  {
    if (!paramFile.exists()) {
      throw new IllegalArgumentException(paramFile + " does not exist");
    }
    if (paramFile.isDirectory()) {
      return sizeOfDirectoryAsBigInteger(paramFile);
    }
    return BigInteger.valueOf(paramFile.length());
  }
  
  public static long sizeOfDirectory(File paramFile)
  {
    checkDirectory(paramFile);
    paramFile = paramFile.listFiles();
    if (paramFile == null)
    {
      l2 = 0L;
      return l2;
    }
    l1 = 0L;
    int j = paramFile.length;
    int i = 0;
    for (;;)
    {
      l2 = l1;
      if (i >= j) {
        break;
      }
      File localFile = paramFile[i];
      l2 = l1;
      try
      {
        if (!isSymlink(localFile))
        {
          l2 = sizeOf(localFile);
          l1 += l2;
          l2 = l1;
          if (l1 < 0L) {
            break;
          }
          l2 = l1;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          l2 = l1;
        }
      }
      i += 1;
      l1 = l2;
    }
  }
  
  public static BigInteger sizeOfDirectoryAsBigInteger(File paramFile)
  {
    checkDirectory(paramFile);
    File[] arrayOfFile = paramFile.listFiles();
    Object localObject;
    if (arrayOfFile == null)
    {
      localObject = BigInteger.ZERO;
      return (BigInteger)localObject;
    }
    paramFile = BigInteger.ZERO;
    int j = arrayOfFile.length;
    int i = 0;
    for (;;)
    {
      localObject = paramFile;
      if (i >= j) {
        break;
      }
      File localFile2 = arrayOfFile[i];
      localObject = paramFile;
      try
      {
        if (!isSymlink(localFile2)) {
          localObject = paramFile.add(BigInteger.valueOf(sizeOf(localFile2)));
        }
        i += 1;
        paramFile = (File)localObject;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          File localFile1 = paramFile;
        }
      }
    }
  }
  
  public static File toFile(URL paramURL)
  {
    if ((paramURL == null) || (!"file".equalsIgnoreCase(paramURL.getProtocol()))) {
      return null;
    }
    return new File(decodeUrl(paramURL.getFile().replace('/', File.separatorChar)));
  }
  
  public static File[] toFiles(URL[] paramArrayOfURL)
  {
    Object localObject;
    if ((paramArrayOfURL == null) || (paramArrayOfURL.length == 0))
    {
      localObject = EMPTY_FILE_ARRAY;
      return (File[])localObject;
    }
    File[] arrayOfFile = new File[paramArrayOfURL.length];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfFile;
      if (i >= paramArrayOfURL.length) {
        break;
      }
      localObject = paramArrayOfURL[i];
      if (localObject != null)
      {
        if (!((URL)localObject).getProtocol().equals("file")) {
          throw new IllegalArgumentException("URL could not be converted to a File: " + localObject);
        }
        arrayOfFile[i] = toFile((URL)localObject);
      }
      i += 1;
    }
  }
  
  private static String[] toSuffixes(String[] paramArrayOfString)
  {
    String[] arrayOfString = new String[paramArrayOfString.length];
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      arrayOfString[i] = ("." + paramArrayOfString[i]);
      i += 1;
    }
    return arrayOfString;
  }
  
  public static URL[] toURLs(File[] paramArrayOfFile)
    throws IOException
  {
    URL[] arrayOfURL = new URL[paramArrayOfFile.length];
    int i = 0;
    while (i < arrayOfURL.length)
    {
      arrayOfURL[i] = paramArrayOfFile[i].toURI().toURL();
      i += 1;
    }
    return arrayOfURL;
  }
  
  public static void touch(File paramFile)
    throws IOException
  {
    if (!paramFile.exists()) {
      IOUtils.closeQuietly(openOutputStream(paramFile));
    }
    if (!paramFile.setLastModified(System.currentTimeMillis())) {
      throw new IOException("Unable to set the last modification time for " + paramFile);
    }
  }
  
  private static void validateListFilesParameters(File paramFile, IOFileFilter paramIOFileFilter)
  {
    if (!paramFile.isDirectory()) {
      throw new IllegalArgumentException("Parameter 'directory' is not a directory");
    }
    if (paramIOFileFilter == null) {
      throw new NullPointerException("Parameter 'fileFilter' is null");
    }
  }
  
  public static boolean waitFor(File paramFile, int paramInt)
  {
    int j = 0;
    int i = 0;
    if (!paramFile.exists())
    {
      if (i < 10) {
        break label47;
      }
      i = 0;
      if (j > paramInt) {
        return false;
      }
      j += 1;
    }
    for (;;)
    {
      try
      {
        Thread.sleep(100L);
      }
      catch (InterruptedException localInterruptedException) {}catch (Exception paramFile) {}
      return true;
      label47:
      i += 1;
    }
  }
  
  public static void write(File paramFile, CharSequence paramCharSequence)
    throws IOException
  {
    write(paramFile, paramCharSequence, Charset.defaultCharset(), false);
  }
  
  public static void write(File paramFile, CharSequence paramCharSequence, String paramString)
    throws IOException
  {
    write(paramFile, paramCharSequence, paramString, false);
  }
  
  public static void write(File paramFile, CharSequence paramCharSequence, String paramString, boolean paramBoolean)
    throws IOException
  {
    write(paramFile, paramCharSequence, Charsets.toCharset(paramString), paramBoolean);
  }
  
  public static void write(File paramFile, CharSequence paramCharSequence, Charset paramCharset)
    throws IOException
  {
    write(paramFile, paramCharSequence, paramCharset, false);
  }
  
  public static void write(File paramFile, CharSequence paramCharSequence, Charset paramCharset, boolean paramBoolean)
    throws IOException
  {
    if (paramCharSequence == null) {}
    for (paramCharSequence = null;; paramCharSequence = paramCharSequence.toString())
    {
      writeStringToFile(paramFile, paramCharSequence, paramCharset, paramBoolean);
      return;
    }
  }
  
  public static void write(File paramFile, CharSequence paramCharSequence, boolean paramBoolean)
    throws IOException
  {
    write(paramFile, paramCharSequence, Charset.defaultCharset(), paramBoolean);
  }
  
  public static void writeByteArrayToFile(File paramFile, byte[] paramArrayOfByte)
    throws IOException
  {
    writeByteArrayToFile(paramFile, paramArrayOfByte, false);
  }
  
  public static void writeByteArrayToFile(File paramFile, byte[] paramArrayOfByte, boolean paramBoolean)
    throws IOException
  {
    File localFile = null;
    try
    {
      paramFile = openOutputStream(paramFile, paramBoolean);
      localFile = paramFile;
      paramFile.write(paramArrayOfByte);
      localFile = paramFile;
      paramFile.close();
      return;
    }
    finally
    {
      IOUtils.closeQuietly(localFile);
    }
  }
  
  public static void writeLines(File paramFile, String paramString, Collection<?> paramCollection)
    throws IOException
  {
    writeLines(paramFile, paramString, paramCollection, null, false);
  }
  
  public static void writeLines(File paramFile, String paramString1, Collection<?> paramCollection, String paramString2)
    throws IOException
  {
    writeLines(paramFile, paramString1, paramCollection, paramString2, false);
  }
  
  public static void writeLines(File paramFile, String paramString1, Collection<?> paramCollection, String paramString2, boolean paramBoolean)
    throws IOException
  {
    File localFile = null;
    try
    {
      paramFile = openOutputStream(paramFile, paramBoolean);
      localFile = paramFile;
      BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(paramFile);
      localFile = paramFile;
      IOUtils.writeLines(paramCollection, paramString2, localBufferedOutputStream, paramString1);
      localFile = paramFile;
      localBufferedOutputStream.flush();
      localFile = paramFile;
      paramFile.close();
      return;
    }
    finally
    {
      IOUtils.closeQuietly(localFile);
    }
  }
  
  public static void writeLines(File paramFile, String paramString, Collection<?> paramCollection, boolean paramBoolean)
    throws IOException
  {
    writeLines(paramFile, paramString, paramCollection, null, paramBoolean);
  }
  
  public static void writeLines(File paramFile, Collection<?> paramCollection)
    throws IOException
  {
    writeLines(paramFile, null, paramCollection, null, false);
  }
  
  public static void writeLines(File paramFile, Collection<?> paramCollection, String paramString)
    throws IOException
  {
    writeLines(paramFile, null, paramCollection, paramString, false);
  }
  
  public static void writeLines(File paramFile, Collection<?> paramCollection, String paramString, boolean paramBoolean)
    throws IOException
  {
    writeLines(paramFile, null, paramCollection, paramString, paramBoolean);
  }
  
  public static void writeLines(File paramFile, Collection<?> paramCollection, boolean paramBoolean)
    throws IOException
  {
    writeLines(paramFile, null, paramCollection, null, paramBoolean);
  }
  
  public static void writeStringToFile(File paramFile, String paramString)
    throws IOException
  {
    writeStringToFile(paramFile, paramString, Charset.defaultCharset(), false);
  }
  
  public static void writeStringToFile(File paramFile, String paramString1, String paramString2)
    throws IOException
  {
    writeStringToFile(paramFile, paramString1, paramString2, false);
  }
  
  public static void writeStringToFile(File paramFile, String paramString1, String paramString2, boolean paramBoolean)
    throws IOException
  {
    writeStringToFile(paramFile, paramString1, Charsets.toCharset(paramString2), paramBoolean);
  }
  
  public static void writeStringToFile(File paramFile, String paramString, Charset paramCharset)
    throws IOException
  {
    writeStringToFile(paramFile, paramString, paramCharset, false);
  }
  
  public static void writeStringToFile(File paramFile, String paramString, Charset paramCharset, boolean paramBoolean)
    throws IOException
  {
    File localFile = null;
    try
    {
      paramFile = openOutputStream(paramFile, paramBoolean);
      localFile = paramFile;
      IOUtils.write(paramString, paramFile, paramCharset);
      localFile = paramFile;
      paramFile.close();
      return;
    }
    finally
    {
      IOUtils.closeQuietly(localFile);
    }
  }
  
  public static void writeStringToFile(File paramFile, String paramString, boolean paramBoolean)
    throws IOException
  {
    writeStringToFile(paramFile, paramString, Charset.defaultCharset(), paramBoolean);
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.FileUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */