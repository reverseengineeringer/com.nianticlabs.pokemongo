package org.apache.commons.io.input;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import org.apache.commons.io.Charsets;

public class ReversedLinesFileReader
  implements Closeable
{
  private final int avoidNewlineSplitBufferSize;
  private final int blockSize;
  private final int byteDecrement;
  private FilePart currentFilePart;
  private final Charset encoding;
  private final byte[][] newLineSequences;
  private final RandomAccessFile randomAccessFile;
  private final long totalBlockCount;
  private final long totalByteLength;
  private boolean trailingNewlineOfFileSkipped = false;
  
  public ReversedLinesFileReader(File paramFile)
    throws IOException
  {
    this(paramFile, 4096, Charset.defaultCharset().toString());
  }
  
  public ReversedLinesFileReader(File paramFile, int paramInt, String paramString)
    throws IOException
  {
    this(paramFile, paramInt, Charsets.toCharset(paramString));
  }
  
  public ReversedLinesFileReader(File paramFile, int paramInt, Charset paramCharset)
    throws IOException
  {
    blockSize = paramInt;
    encoding = paramCharset;
    randomAccessFile = new RandomAccessFile(paramFile, "r");
    totalByteLength = randomAccessFile.length();
    int i = (int)(totalByteLength % paramInt);
    if (i > 0)
    {
      totalBlockCount = (totalByteLength / paramInt + 1L);
      currentFilePart = new FilePart(totalBlockCount, i, null, null);
      paramFile = Charsets.toCharset(paramCharset);
      if (paramFile.newEncoder().maxBytesPerChar() != 1.0F) {
        break label187;
      }
      byteDecrement = 1;
    }
    for (;;)
    {
      newLineSequences = new byte[][] { "\r\n".getBytes(paramCharset), "\n".getBytes(paramCharset), "\r".getBytes(paramCharset) };
      avoidNewlineSplitBufferSize = newLineSequences[0].length;
      return;
      totalBlockCount = (totalByteLength / paramInt);
      if (totalByteLength <= 0L) {
        break;
      }
      i = paramInt;
      break;
      label187:
      if (paramFile == Charset.forName("UTF-8"))
      {
        byteDecrement = 1;
      }
      else if (paramFile == Charset.forName("Shift_JIS"))
      {
        byteDecrement = 1;
      }
      else
      {
        if ((paramFile != Charset.forName("UTF-16BE")) && (paramFile != Charset.forName("UTF-16LE"))) {
          break label247;
        }
        byteDecrement = 2;
      }
    }
    label247:
    if (paramFile == Charset.forName("UTF-16")) {
      throw new UnsupportedEncodingException("For UTF-16, you need to specify the byte order (use UTF-16BE or UTF-16LE)");
    }
    throw new UnsupportedEncodingException("Encoding " + paramCharset + " is not supported yet (feel free to submit a patch)");
  }
  
  public void close()
    throws IOException
  {
    randomAccessFile.close();
  }
  
  public String readLine()
    throws IOException
  {
    for (String str1 = currentFilePart.readLine(); str1 == null; str1 = currentFilePart.readLine())
    {
      currentFilePart = currentFilePart.rollOver();
      if (currentFilePart == null) {
        break;
      }
    }
    String str2 = str1;
    if ("".equals(str1))
    {
      str2 = str1;
      if (!trailingNewlineOfFileSkipped)
      {
        trailingNewlineOfFileSkipped = true;
        str2 = readLine();
      }
    }
    return str2;
  }
  
  private class FilePart
  {
    private int currentLastBytePos;
    private final byte[] data;
    private byte[] leftOver;
    private final long no;
    
    private FilePart(long paramLong, int paramInt, byte[] paramArrayOfByte)
      throws IOException
    {
      no = paramLong;
      if (paramArrayOfByte != null) {}
      for (int i = paramArrayOfByte.length;; i = 0)
      {
        data = new byte[paramInt + i];
        long l = blockSize;
        if (paramLong <= 0L) {
          break;
        }
        randomAccessFile.seek((paramLong - 1L) * l);
        if (randomAccessFile.read(data, 0, paramInt) == paramInt) {
          break;
        }
        throw new IllegalStateException("Count of requested bytes and actually read bytes don't match");
      }
      if (paramArrayOfByte != null) {
        System.arraycopy(paramArrayOfByte, 0, data, paramInt, paramArrayOfByte.length);
      }
      currentLastBytePos = (data.length - 1);
      leftOver = null;
    }
    
    private void createLeftOver()
    {
      int i = currentLastBytePos + 1;
      if (i > 0)
      {
        leftOver = new byte[i];
        System.arraycopy(data, 0, leftOver, 0, i);
      }
      for (;;)
      {
        currentLastBytePos = -1;
        return;
        leftOver = null;
      }
    }
    
    private int getNewLineMatchByteCount(byte[] paramArrayOfByte, int paramInt)
    {
      int n = 0;
      byte[][] arrayOfByte = newLineSequences;
      int i1 = arrayOfByte.length;
      int i = 0;
      for (;;)
      {
        int j = n;
        if (i < i1)
        {
          byte[] arrayOfByte1 = arrayOfByte[i];
          int k = 1;
          j = arrayOfByte1.length - 1;
          if (j >= 0)
          {
            int m = paramInt + j - (arrayOfByte1.length - 1);
            if ((m >= 0) && (paramArrayOfByte[m] == arrayOfByte1[j])) {}
            for (m = 1;; m = 0)
            {
              k &= m;
              j -= 1;
              break;
            }
          }
          if (k != 0) {
            j = arrayOfByte1.length;
          }
        }
        else
        {
          return j;
        }
        i += 1;
      }
    }
    
    private String readLine()
      throws IOException
    {
      Object localObject2 = null;
      int i;
      int j;
      label19:
      Object localObject1;
      if (no == 1L)
      {
        i = 1;
        j = currentLastBytePos;
        localObject1 = localObject2;
        if (j > -1)
        {
          if ((i != 0) || (j >= avoidNewlineSplitBufferSize)) {
            break label103;
          }
          createLeftOver();
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (i != 0)
        {
          localObject2 = localObject1;
          if (leftOver != null)
          {
            localObject2 = new String(leftOver, encoding);
            leftOver = null;
          }
        }
        return (String)localObject2;
        i = 0;
        break;
        label103:
        int k = getNewLineMatchByteCount(data, j);
        if (k > 0)
        {
          int m = j + 1;
          int n = currentLastBytePos - m + 1;
          if (n < 0) {
            throw new IllegalStateException("Unexpected negative line length=" + n);
          }
          localObject1 = new byte[n];
          System.arraycopy(data, m, localObject1, 0, n);
          localObject1 = new String((byte[])localObject1, encoding);
          currentLastBytePos = (j - k);
        }
        else
        {
          k = j - byteDecrement;
          j = k;
          if (k >= 0) {
            break label19;
          }
          createLeftOver();
          localObject1 = localObject2;
        }
      }
    }
    
    private FilePart rollOver()
      throws IOException
    {
      if (currentLastBytePos > -1) {
        throw new IllegalStateException("Current currentLastCharPos unexpectedly positive... last readLine() should have returned something! currentLastCharPos=" + currentLastBytePos);
      }
      if (no > 1L) {
        return new FilePart(ReversedLinesFileReader.this, no - 1L, blockSize, leftOver);
      }
      if (leftOver != null) {
        throw new IllegalStateException("Unexpected leftover of the last block: leftOverOfThisFilePart=" + new String(leftOver, encoding));
      }
      return null;
    }
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.input.ReversedLinesFileReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */