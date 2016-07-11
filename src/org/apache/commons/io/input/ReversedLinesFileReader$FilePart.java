package org.apache.commons.io.input;

import java.io.IOException;
import java.io.RandomAccessFile;

class ReversedLinesFileReader$FilePart
{
  private int currentLastBytePos;
  private final byte[] data;
  private byte[] leftOver;
  private final long no;
  
  private ReversedLinesFileReader$FilePart(ReversedLinesFileReader paramReversedLinesFileReader, long paramLong, int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    no = paramLong;
    if (paramArrayOfByte != null) {}
    for (int i = paramArrayOfByte.length;; i = 0)
    {
      data = new byte[paramInt + i];
      long l = ReversedLinesFileReader.access$300(paramReversedLinesFileReader);
      if (paramLong <= 0L) {
        break;
      }
      ReversedLinesFileReader.access$400(paramReversedLinesFileReader).seek((paramLong - 1L) * l);
      if (ReversedLinesFileReader.access$400(paramReversedLinesFileReader).read(data, 0, paramInt) == paramInt) {
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
    byte[][] arrayOfByte = ReversedLinesFileReader.access$800(this$0);
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
        if ((i != 0) || (j >= ReversedLinesFileReader.access$600(this$0))) {
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
          localObject2 = new String(leftOver, ReversedLinesFileReader.access$500(this$0));
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
        localObject1 = new String((byte[])localObject1, ReversedLinesFileReader.access$500(this$0));
        currentLastBytePos = (j - k);
      }
      else
      {
        k = j - ReversedLinesFileReader.access$700(this$0);
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
      return new FilePart(this$0, no - 1L, ReversedLinesFileReader.access$300(this$0), leftOver);
    }
    if (leftOver != null) {
      throw new IllegalStateException("Unexpected leftover of the last block: leftOverOfThisFilePart=" + new String(leftOver, ReversedLinesFileReader.access$500(this$0)));
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.input.ReversedLinesFileReader.FilePart
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */