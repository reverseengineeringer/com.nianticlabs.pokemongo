package org.apache.commons.io.input;

import java.io.Reader;
import java.io.Serializable;

public class CharSequenceReader
  extends Reader
  implements Serializable
{
  private final CharSequence charSequence;
  private int idx;
  private int mark;
  
  public CharSequenceReader(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {}
    for (;;)
    {
      charSequence = paramCharSequence;
      return;
      paramCharSequence = "";
    }
  }
  
  public void close()
  {
    idx = 0;
    mark = 0;
  }
  
  public void mark(int paramInt)
  {
    mark = idx;
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public int read()
  {
    if (idx >= charSequence.length()) {
      return -1;
    }
    CharSequence localCharSequence = charSequence;
    int i = idx;
    idx = (i + 1);
    return localCharSequence.charAt(i);
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int k;
    if (idx >= charSequence.length())
    {
      k = -1;
      return k;
    }
    if (paramArrayOfChar == null) {
      throw new NullPointerException("Character array is missing");
    }
    if ((paramInt2 < 0) || (paramInt1 < 0) || (paramInt1 + paramInt2 > paramArrayOfChar.length)) {
      throw new IndexOutOfBoundsException("Array Size=" + paramArrayOfChar.length + ", offset=" + paramInt1 + ", length=" + paramInt2);
    }
    int i = 0;
    int j = 0;
    for (;;)
    {
      k = i;
      if (j >= paramInt2) {
        break;
      }
      int m = read();
      k = i;
      if (m == -1) {
        break;
      }
      paramArrayOfChar[(paramInt1 + j)] = ((char)m);
      i += 1;
      j += 1;
    }
  }
  
  public void reset()
  {
    idx = mark;
  }
  
  public long skip(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Number of characters to skip is less than zero: " + paramLong);
    }
    if (idx >= charSequence.length()) {
      return -1L;
    }
    int i = (int)Math.min(charSequence.length(), idx + paramLong);
    int j = idx;
    idx = i;
    return i - j;
  }
  
  public String toString()
  {
    return charSequence.toString();
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.input.CharSequenceReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */