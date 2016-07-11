package org.apache.commons.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Selector;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.io.output.StringBuilderWriter;

public class IOUtils
{
  private static final int DEFAULT_BUFFER_SIZE = 4096;
  public static final char DIR_SEPARATOR = File.separatorChar;
  public static final char DIR_SEPARATOR_UNIX = '/';
  public static final char DIR_SEPARATOR_WINDOWS = '\\';
  private static final int EOF = -1;
  public static final String LINE_SEPARATOR;
  public static final String LINE_SEPARATOR_UNIX = "\n";
  public static final String LINE_SEPARATOR_WINDOWS = "\r\n";
  private static final int SKIP_BUFFER_SIZE = 2048;
  private static byte[] SKIP_BYTE_BUFFER;
  private static char[] SKIP_CHAR_BUFFER;
  
  static
  {
    StringBuilderWriter localStringBuilderWriter = new StringBuilderWriter(4);
    PrintWriter localPrintWriter = new PrintWriter(localStringBuilderWriter);
    localPrintWriter.println();
    LINE_SEPARATOR = localStringBuilderWriter.toString();
    localPrintWriter.close();
  }
  
  public static void close(URLConnection paramURLConnection)
  {
    if ((paramURLConnection instanceof HttpURLConnection)) {
      ((HttpURLConnection)paramURLConnection).disconnect();
    }
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  public static void closeQuietly(InputStream paramInputStream)
  {
    closeQuietly(paramInputStream);
  }
  
  public static void closeQuietly(OutputStream paramOutputStream)
  {
    closeQuietly(paramOutputStream);
  }
  
  public static void closeQuietly(Reader paramReader)
  {
    closeQuietly(paramReader);
  }
  
  public static void closeQuietly(Writer paramWriter)
  {
    closeQuietly(paramWriter);
  }
  
  public static void closeQuietly(ServerSocket paramServerSocket)
  {
    if (paramServerSocket != null) {}
    try
    {
      paramServerSocket.close();
      return;
    }
    catch (IOException paramServerSocket) {}
  }
  
  public static void closeQuietly(Socket paramSocket)
  {
    if (paramSocket != null) {}
    try
    {
      paramSocket.close();
      return;
    }
    catch (IOException paramSocket) {}
  }
  
  public static void closeQuietly(Selector paramSelector)
  {
    if (paramSelector != null) {}
    try
    {
      paramSelector.close();
      return;
    }
    catch (IOException paramSelector) {}
  }
  
  public static boolean contentEquals(InputStream paramInputStream1, InputStream paramInputStream2)
    throws IOException
  {
    Object localObject = paramInputStream1;
    if (!(paramInputStream1 instanceof BufferedInputStream)) {
      localObject = new BufferedInputStream(paramInputStream1);
    }
    paramInputStream1 = paramInputStream2;
    if (!(paramInputStream2 instanceof BufferedInputStream)) {
      paramInputStream1 = new BufferedInputStream(paramInputStream2);
    }
    int i = ((InputStream)localObject).read();
    if (-1 != i) {
      if (i == paramInputStream1.read()) {}
    }
    while (paramInputStream1.read() != -1)
    {
      return false;
      i = ((InputStream)localObject).read();
      break;
    }
    return true;
  }
  
  public static boolean contentEquals(Reader paramReader1, Reader paramReader2)
    throws IOException
  {
    paramReader1 = toBufferedReader(paramReader1);
    paramReader2 = toBufferedReader(paramReader2);
    int i = paramReader1.read();
    if (-1 != i) {
      if (i == paramReader2.read()) {}
    }
    while (paramReader2.read() != -1)
    {
      return false;
      i = paramReader1.read();
      break;
    }
    return true;
  }
  
  public static boolean contentEqualsIgnoreEOL(Reader paramReader1, Reader paramReader2)
    throws IOException
  {
    BufferedReader localBufferedReader1 = toBufferedReader(paramReader1);
    BufferedReader localBufferedReader2 = toBufferedReader(paramReader2);
    paramReader1 = localBufferedReader1.readLine();
    for (paramReader2 = localBufferedReader2.readLine(); (paramReader1 != null) && (paramReader2 != null) && (paramReader1.equals(paramReader2)); paramReader2 = localBufferedReader2.readLine()) {
      paramReader1 = localBufferedReader1.readLine();
    }
    if (paramReader1 == null) {
      return paramReader2 == null;
    }
    return paramReader1.equals(paramReader2);
  }
  
  public static int copy(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    long l = copyLarge(paramInputStream, paramOutputStream);
    if (l > 2147483647L) {
      return -1;
    }
    return (int)l;
  }
  
  public static int copy(Reader paramReader, Writer paramWriter)
    throws IOException
  {
    long l = copyLarge(paramReader, paramWriter);
    if (l > 2147483647L) {
      return -1;
    }
    return (int)l;
  }
  
  public static void copy(InputStream paramInputStream, Writer paramWriter)
    throws IOException
  {
    copy(paramInputStream, paramWriter, Charset.defaultCharset());
  }
  
  public static void copy(InputStream paramInputStream, Writer paramWriter, String paramString)
    throws IOException
  {
    copy(paramInputStream, paramWriter, Charsets.toCharset(paramString));
  }
  
  public static void copy(InputStream paramInputStream, Writer paramWriter, Charset paramCharset)
    throws IOException
  {
    copy(new InputStreamReader(paramInputStream, Charsets.toCharset(paramCharset)), paramWriter);
  }
  
  public static void copy(Reader paramReader, OutputStream paramOutputStream)
    throws IOException
  {
    copy(paramReader, paramOutputStream, Charset.defaultCharset());
  }
  
  public static void copy(Reader paramReader, OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    copy(paramReader, paramOutputStream, Charsets.toCharset(paramString));
  }
  
  public static void copy(Reader paramReader, OutputStream paramOutputStream, Charset paramCharset)
    throws IOException
  {
    paramOutputStream = new OutputStreamWriter(paramOutputStream, Charsets.toCharset(paramCharset));
    copy(paramReader, paramOutputStream);
    paramOutputStream.flush();
  }
  
  public static long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    return copyLarge(paramInputStream, paramOutputStream, new byte['က']);
  }
  
  public static long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong1, long paramLong2)
    throws IOException
  {
    return copyLarge(paramInputStream, paramOutputStream, paramLong1, paramLong2, new byte['က']);
  }
  
  public static long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramLong1 > 0L) {
      skipFully(paramInputStream, paramLong1);
    }
    long l;
    if (paramLong2 == 0L)
    {
      l = 0L;
      return l;
    }
    int k = paramArrayOfByte.length;
    int j = k;
    int i = j;
    if (paramLong2 > 0L)
    {
      i = j;
      if (paramLong2 < k) {
        i = (int)paramLong2;
      }
    }
    paramLong1 = 0L;
    for (;;)
    {
      l = paramLong1;
      if (i <= 0) {
        break;
      }
      j = paramInputStream.read(paramArrayOfByte, 0, i);
      l = paramLong1;
      if (-1 == j) {
        break;
      }
      paramOutputStream.write(paramArrayOfByte, 0, j);
      l = paramLong1 + j;
      paramLong1 = l;
      if (paramLong2 > 0L)
      {
        i = (int)Math.min(paramLong2 - l, k);
        paramLong1 = l;
      }
    }
  }
  
  public static long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramInputStream.read(paramArrayOfByte);
      if (-1 == i) {
        break;
      }
      paramOutputStream.write(paramArrayOfByte, 0, i);
    }
    return l;
  }
  
  public static long copyLarge(Reader paramReader, Writer paramWriter)
    throws IOException
  {
    return copyLarge(paramReader, paramWriter, new char['က']);
  }
  
  public static long copyLarge(Reader paramReader, Writer paramWriter, long paramLong1, long paramLong2)
    throws IOException
  {
    return copyLarge(paramReader, paramWriter, paramLong1, paramLong2, new char['က']);
  }
  
  public static long copyLarge(Reader paramReader, Writer paramWriter, long paramLong1, long paramLong2, char[] paramArrayOfChar)
    throws IOException
  {
    if (paramLong1 > 0L) {
      skipFully(paramReader, paramLong1);
    }
    long l;
    if (paramLong2 == 0L)
    {
      l = 0L;
      return l;
    }
    int j = paramArrayOfChar.length;
    int i = j;
    if (paramLong2 > 0L)
    {
      i = j;
      if (paramLong2 < paramArrayOfChar.length) {
        i = (int)paramLong2;
      }
    }
    paramLong1 = 0L;
    for (;;)
    {
      l = paramLong1;
      if (i <= 0) {
        break;
      }
      j = paramReader.read(paramArrayOfChar, 0, i);
      l = paramLong1;
      if (-1 == j) {
        break;
      }
      paramWriter.write(paramArrayOfChar, 0, j);
      l = paramLong1 + j;
      paramLong1 = l;
      if (paramLong2 > 0L)
      {
        i = (int)Math.min(paramLong2 - l, paramArrayOfChar.length);
        paramLong1 = l;
      }
    }
  }
  
  public static long copyLarge(Reader paramReader, Writer paramWriter, char[] paramArrayOfChar)
    throws IOException
  {
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramReader.read(paramArrayOfChar);
      if (-1 == i) {
        break;
      }
      paramWriter.write(paramArrayOfChar, 0, i);
    }
    return l;
  }
  
  public static LineIterator lineIterator(InputStream paramInputStream, String paramString)
    throws IOException
  {
    return lineIterator(paramInputStream, Charsets.toCharset(paramString));
  }
  
  public static LineIterator lineIterator(InputStream paramInputStream, Charset paramCharset)
    throws IOException
  {
    return new LineIterator(new InputStreamReader(paramInputStream, Charsets.toCharset(paramCharset)));
  }
  
  public static LineIterator lineIterator(Reader paramReader)
  {
    return new LineIterator(paramReader);
  }
  
  public static int read(InputStream paramInputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramInputStream, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static int read(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 < 0) {
      throw new IllegalArgumentException("Length must not be negative: " + paramInt2);
    }
    int i = paramInt2;
    for (;;)
    {
      int j;
      if (i > 0)
      {
        j = paramInputStream.read(paramArrayOfByte, paramInt1 + (paramInt2 - i), i);
        if (-1 != j) {}
      }
      else
      {
        return paramInt2 - i;
      }
      i -= j;
    }
  }
  
  public static int read(Reader paramReader, char[] paramArrayOfChar)
    throws IOException
  {
    return read(paramReader, paramArrayOfChar, 0, paramArrayOfChar.length);
  }
  
  public static int read(Reader paramReader, char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 < 0) {
      throw new IllegalArgumentException("Length must not be negative: " + paramInt2);
    }
    int i = paramInt2;
    for (;;)
    {
      int j;
      if (i > 0)
      {
        j = paramReader.read(paramArrayOfChar, paramInt1 + (paramInt2 - i), i);
        if (-1 != j) {}
      }
      else
      {
        return paramInt2 - i;
      }
      i -= j;
    }
  }
  
  public static void readFully(InputStream paramInputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    readFully(paramInputStream, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static void readFully(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt1 = read(paramInputStream, paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 != paramInt2) {
      throw new EOFException("Length to read: " + paramInt2 + " actual: " + paramInt1);
    }
  }
  
  public static void readFully(Reader paramReader, char[] paramArrayOfChar)
    throws IOException
  {
    readFully(paramReader, paramArrayOfChar, 0, paramArrayOfChar.length);
  }
  
  public static void readFully(Reader paramReader, char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt1 = read(paramReader, paramArrayOfChar, paramInt1, paramInt2);
    if (paramInt1 != paramInt2) {
      throw new EOFException("Length to read: " + paramInt2 + " actual: " + paramInt1);
    }
  }
  
  public static List<String> readLines(InputStream paramInputStream)
    throws IOException
  {
    return readLines(paramInputStream, Charset.defaultCharset());
  }
  
  public static List<String> readLines(InputStream paramInputStream, String paramString)
    throws IOException
  {
    return readLines(paramInputStream, Charsets.toCharset(paramString));
  }
  
  public static List<String> readLines(InputStream paramInputStream, Charset paramCharset)
    throws IOException
  {
    return readLines(new InputStreamReader(paramInputStream, Charsets.toCharset(paramCharset)));
  }
  
  public static List<String> readLines(Reader paramReader)
    throws IOException
  {
    BufferedReader localBufferedReader = toBufferedReader(paramReader);
    ArrayList localArrayList = new ArrayList();
    for (paramReader = localBufferedReader.readLine(); paramReader != null; paramReader = localBufferedReader.readLine()) {
      localArrayList.add(paramReader);
    }
    return localArrayList;
  }
  
  public static long skip(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Skip count must be non-negative, actual: " + paramLong);
    }
    if (SKIP_BYTE_BUFFER == null) {
      SKIP_BYTE_BUFFER = new byte['ࠀ'];
    }
    long l2;
    for (long l1 = paramLong;; l1 -= l2) {
      if (l1 > 0L)
      {
        l2 = paramInputStream.read(SKIP_BYTE_BUFFER, 0, (int)Math.min(l1, 2048L));
        if (l2 >= 0L) {}
      }
      else
      {
        return paramLong - l1;
      }
    }
  }
  
  public static long skip(Reader paramReader, long paramLong)
    throws IOException
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Skip count must be non-negative, actual: " + paramLong);
    }
    if (SKIP_CHAR_BUFFER == null) {
      SKIP_CHAR_BUFFER = new char['ࠀ'];
    }
    long l2;
    for (long l1 = paramLong;; l1 -= l2) {
      if (l1 > 0L)
      {
        l2 = paramReader.read(SKIP_CHAR_BUFFER, 0, (int)Math.min(l1, 2048L));
        if (l2 >= 0L) {}
      }
      else
      {
        return paramLong - l1;
      }
    }
  }
  
  public static void skipFully(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Bytes to skip must not be negative: " + paramLong);
    }
    long l = skip(paramInputStream, paramLong);
    if (l != paramLong) {
      throw new EOFException("Bytes to skip: " + paramLong + " actual: " + l);
    }
  }
  
  public static void skipFully(Reader paramReader, long paramLong)
    throws IOException
  {
    long l = skip(paramReader, paramLong);
    if (l != paramLong) {
      throw new EOFException("Chars to skip: " + paramLong + " actual: " + l);
    }
  }
  
  public static InputStream toBufferedInputStream(InputStream paramInputStream)
    throws IOException
  {
    return ByteArrayOutputStream.toBufferedInputStream(paramInputStream);
  }
  
  public static BufferedReader toBufferedReader(Reader paramReader)
  {
    if ((paramReader instanceof BufferedReader)) {
      return (BufferedReader)paramReader;
    }
    return new BufferedReader(paramReader);
  }
  
  public static byte[] toByteArray(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    copy(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static byte[] toByteArray(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Size must be equal or greater than zero: " + paramInt);
    }
    if (paramInt == 0) {
      paramInputStream = new byte[0];
    }
    int i;
    do
    {
      return paramInputStream;
      byte[] arrayOfByte = new byte[paramInt];
      i = 0;
      while (i < paramInt)
      {
        int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
        if (j == -1) {
          break;
        }
        i += j;
      }
      paramInputStream = arrayOfByte;
    } while (i == paramInt);
    throw new IOException("Unexpected readed size. current: " + i + ", excepted: " + paramInt);
  }
  
  public static byte[] toByteArray(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    if (paramLong > 2147483647L) {
      throw new IllegalArgumentException("Size cannot be greater than Integer max value: " + paramLong);
    }
    return toByteArray(paramInputStream, (int)paramLong);
  }
  
  public static byte[] toByteArray(Reader paramReader)
    throws IOException
  {
    return toByteArray(paramReader, Charset.defaultCharset());
  }
  
  public static byte[] toByteArray(Reader paramReader, String paramString)
    throws IOException
  {
    return toByteArray(paramReader, Charsets.toCharset(paramString));
  }
  
  public static byte[] toByteArray(Reader paramReader, Charset paramCharset)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    copy(paramReader, localByteArrayOutputStream, paramCharset);
    return localByteArrayOutputStream.toByteArray();
  }
  
  @Deprecated
  public static byte[] toByteArray(String paramString)
    throws IOException
  {
    return paramString.getBytes();
  }
  
  public static byte[] toByteArray(URI paramURI)
    throws IOException
  {
    return toByteArray(paramURI.toURL());
  }
  
  public static byte[] toByteArray(URL paramURL)
    throws IOException
  {
    paramURL = paramURL.openConnection();
    try
    {
      byte[] arrayOfByte = toByteArray(paramURL);
      return arrayOfByte;
    }
    finally
    {
      close(paramURL);
    }
  }
  
  public static byte[] toByteArray(URLConnection paramURLConnection)
    throws IOException
  {
    paramURLConnection = paramURLConnection.getInputStream();
    try
    {
      byte[] arrayOfByte = toByteArray(paramURLConnection);
      return arrayOfByte;
    }
    finally
    {
      paramURLConnection.close();
    }
  }
  
  public static char[] toCharArray(InputStream paramInputStream)
    throws IOException
  {
    return toCharArray(paramInputStream, Charset.defaultCharset());
  }
  
  public static char[] toCharArray(InputStream paramInputStream, String paramString)
    throws IOException
  {
    return toCharArray(paramInputStream, Charsets.toCharset(paramString));
  }
  
  public static char[] toCharArray(InputStream paramInputStream, Charset paramCharset)
    throws IOException
  {
    CharArrayWriter localCharArrayWriter = new CharArrayWriter();
    copy(paramInputStream, localCharArrayWriter, paramCharset);
    return localCharArrayWriter.toCharArray();
  }
  
  public static char[] toCharArray(Reader paramReader)
    throws IOException
  {
    CharArrayWriter localCharArrayWriter = new CharArrayWriter();
    copy(paramReader, localCharArrayWriter);
    return localCharArrayWriter.toCharArray();
  }
  
  public static InputStream toInputStream(CharSequence paramCharSequence)
  {
    return toInputStream(paramCharSequence, Charset.defaultCharset());
  }
  
  public static InputStream toInputStream(CharSequence paramCharSequence, String paramString)
    throws IOException
  {
    return toInputStream(paramCharSequence, Charsets.toCharset(paramString));
  }
  
  public static InputStream toInputStream(CharSequence paramCharSequence, Charset paramCharset)
  {
    return toInputStream(paramCharSequence.toString(), paramCharset);
  }
  
  public static InputStream toInputStream(String paramString)
  {
    return toInputStream(paramString, Charset.defaultCharset());
  }
  
  public static InputStream toInputStream(String paramString1, String paramString2)
    throws IOException
  {
    return new ByteArrayInputStream(paramString1.getBytes(Charsets.toCharset(paramString2)));
  }
  
  public static InputStream toInputStream(String paramString, Charset paramCharset)
  {
    return new ByteArrayInputStream(paramString.getBytes(Charsets.toCharset(paramCharset)));
  }
  
  public static String toString(InputStream paramInputStream)
    throws IOException
  {
    return toString(paramInputStream, Charset.defaultCharset());
  }
  
  public static String toString(InputStream paramInputStream, String paramString)
    throws IOException
  {
    return toString(paramInputStream, Charsets.toCharset(paramString));
  }
  
  public static String toString(InputStream paramInputStream, Charset paramCharset)
    throws IOException
  {
    StringBuilderWriter localStringBuilderWriter = new StringBuilderWriter();
    copy(paramInputStream, localStringBuilderWriter, paramCharset);
    return localStringBuilderWriter.toString();
  }
  
  public static String toString(Reader paramReader)
    throws IOException
  {
    StringBuilderWriter localStringBuilderWriter = new StringBuilderWriter();
    copy(paramReader, localStringBuilderWriter);
    return localStringBuilderWriter.toString();
  }
  
  public static String toString(URI paramURI)
    throws IOException
  {
    return toString(paramURI, Charset.defaultCharset());
  }
  
  public static String toString(URI paramURI, String paramString)
    throws IOException
  {
    return toString(paramURI, Charsets.toCharset(paramString));
  }
  
  public static String toString(URI paramURI, Charset paramCharset)
    throws IOException
  {
    return toString(paramURI.toURL(), Charsets.toCharset(paramCharset));
  }
  
  public static String toString(URL paramURL)
    throws IOException
  {
    return toString(paramURL, Charset.defaultCharset());
  }
  
  public static String toString(URL paramURL, String paramString)
    throws IOException
  {
    return toString(paramURL, Charsets.toCharset(paramString));
  }
  
  public static String toString(URL paramURL, Charset paramCharset)
    throws IOException
  {
    paramURL = paramURL.openStream();
    try
    {
      paramCharset = toString(paramURL, paramCharset);
      return paramCharset;
    }
    finally
    {
      paramURL.close();
    }
  }
  
  @Deprecated
  public static String toString(byte[] paramArrayOfByte)
    throws IOException
  {
    return new String(paramArrayOfByte);
  }
  
  public static String toString(byte[] paramArrayOfByte, String paramString)
    throws IOException
  {
    return new String(paramArrayOfByte, Charsets.toCharset(paramString));
  }
  
  public static void write(CharSequence paramCharSequence, OutputStream paramOutputStream)
    throws IOException
  {
    write(paramCharSequence, paramOutputStream, Charset.defaultCharset());
  }
  
  public static void write(CharSequence paramCharSequence, OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    write(paramCharSequence, paramOutputStream, Charsets.toCharset(paramString));
  }
  
  public static void write(CharSequence paramCharSequence, OutputStream paramOutputStream, Charset paramCharset)
    throws IOException
  {
    if (paramCharSequence != null) {
      write(paramCharSequence.toString(), paramOutputStream, paramCharset);
    }
  }
  
  public static void write(CharSequence paramCharSequence, Writer paramWriter)
    throws IOException
  {
    if (paramCharSequence != null) {
      write(paramCharSequence.toString(), paramWriter);
    }
  }
  
  public static void write(String paramString, OutputStream paramOutputStream)
    throws IOException
  {
    write(paramString, paramOutputStream, Charset.defaultCharset());
  }
  
  public static void write(String paramString1, OutputStream paramOutputStream, String paramString2)
    throws IOException
  {
    write(paramString1, paramOutputStream, Charsets.toCharset(paramString2));
  }
  
  public static void write(String paramString, OutputStream paramOutputStream, Charset paramCharset)
    throws IOException
  {
    if (paramString != null) {
      paramOutputStream.write(paramString.getBytes(Charsets.toCharset(paramCharset)));
    }
  }
  
  public static void write(String paramString, Writer paramWriter)
    throws IOException
  {
    if (paramString != null) {
      paramWriter.write(paramString);
    }
  }
  
  @Deprecated
  public static void write(StringBuffer paramStringBuffer, OutputStream paramOutputStream)
    throws IOException
  {
    write(paramStringBuffer, paramOutputStream, (String)null);
  }
  
  @Deprecated
  public static void write(StringBuffer paramStringBuffer, OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    if (paramStringBuffer != null) {
      paramOutputStream.write(paramStringBuffer.toString().getBytes(Charsets.toCharset(paramString)));
    }
  }
  
  @Deprecated
  public static void write(StringBuffer paramStringBuffer, Writer paramWriter)
    throws IOException
  {
    if (paramStringBuffer != null) {
      paramWriter.write(paramStringBuffer.toString());
    }
  }
  
  public static void write(byte[] paramArrayOfByte, OutputStream paramOutputStream)
    throws IOException
  {
    if (paramArrayOfByte != null) {
      paramOutputStream.write(paramArrayOfByte);
    }
  }
  
  public static void write(byte[] paramArrayOfByte, Writer paramWriter)
    throws IOException
  {
    write(paramArrayOfByte, paramWriter, Charset.defaultCharset());
  }
  
  public static void write(byte[] paramArrayOfByte, Writer paramWriter, String paramString)
    throws IOException
  {
    write(paramArrayOfByte, paramWriter, Charsets.toCharset(paramString));
  }
  
  public static void write(byte[] paramArrayOfByte, Writer paramWriter, Charset paramCharset)
    throws IOException
  {
    if (paramArrayOfByte != null) {
      paramWriter.write(new String(paramArrayOfByte, Charsets.toCharset(paramCharset)));
    }
  }
  
  public static void write(char[] paramArrayOfChar, OutputStream paramOutputStream)
    throws IOException
  {
    write(paramArrayOfChar, paramOutputStream, Charset.defaultCharset());
  }
  
  public static void write(char[] paramArrayOfChar, OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    write(paramArrayOfChar, paramOutputStream, Charsets.toCharset(paramString));
  }
  
  public static void write(char[] paramArrayOfChar, OutputStream paramOutputStream, Charset paramCharset)
    throws IOException
  {
    if (paramArrayOfChar != null) {
      paramOutputStream.write(new String(paramArrayOfChar).getBytes(Charsets.toCharset(paramCharset)));
    }
  }
  
  public static void write(char[] paramArrayOfChar, Writer paramWriter)
    throws IOException
  {
    if (paramArrayOfChar != null) {
      paramWriter.write(paramArrayOfChar);
    }
  }
  
  public static void writeLines(Collection<?> paramCollection, String paramString, OutputStream paramOutputStream)
    throws IOException
  {
    writeLines(paramCollection, paramString, paramOutputStream, Charset.defaultCharset());
  }
  
  public static void writeLines(Collection<?> paramCollection, String paramString1, OutputStream paramOutputStream, String paramString2)
    throws IOException
  {
    writeLines(paramCollection, paramString1, paramOutputStream, Charsets.toCharset(paramString2));
  }
  
  public static void writeLines(Collection<?> paramCollection, String paramString, OutputStream paramOutputStream, Charset paramCharset)
    throws IOException
  {
    if (paramCollection == null) {}
    for (;;)
    {
      return;
      String str = paramString;
      if (paramString == null) {
        str = LINE_SEPARATOR;
      }
      paramString = Charsets.toCharset(paramCharset);
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        paramCharset = paramCollection.next();
        if (paramCharset != null) {
          paramOutputStream.write(paramCharset.toString().getBytes(paramString));
        }
        paramOutputStream.write(str.getBytes(paramString));
      }
    }
  }
  
  public static void writeLines(Collection<?> paramCollection, String paramString, Writer paramWriter)
    throws IOException
  {
    if (paramCollection == null) {}
    for (;;)
    {
      return;
      String str = paramString;
      if (paramString == null) {
        str = LINE_SEPARATOR;
      }
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        paramString = paramCollection.next();
        if (paramString != null) {
          paramWriter.write(paramString.toString());
        }
        paramWriter.write(str);
      }
    }
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.IOUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */