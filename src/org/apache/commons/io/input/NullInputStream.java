package org.apache.commons.io.input;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class NullInputStream
  extends InputStream
{
  private boolean eof;
  private long mark = -1L;
  private final boolean markSupported;
  private long position;
  private long readlimit;
  private final long size;
  private final boolean throwEofException;
  
  public NullInputStream(long paramLong)
  {
    this(paramLong, true, false);
  }
  
  public NullInputStream(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    size = paramLong;
    markSupported = paramBoolean1;
    throwEofException = paramBoolean2;
  }
  
  private int doEndOfFile()
    throws EOFException
  {
    eof = true;
    if (throwEofException) {
      throw new EOFException();
    }
    return -1;
  }
  
  public int available()
  {
    long l = size - position;
    if (l <= 0L) {
      return 0;
    }
    if (l > 2147483647L) {
      return Integer.MAX_VALUE;
    }
    return (int)l;
  }
  
  public void close()
    throws IOException
  {
    eof = false;
    position = 0L;
    mark = -1L;
  }
  
  public long getPosition()
  {
    return position;
  }
  
  public long getSize()
  {
    return size;
  }
  
  public void mark(int paramInt)
  {
    try
    {
      if (!markSupported) {
        throw new UnsupportedOperationException("Mark not supported");
      }
    }
    finally {}
    mark = position;
    readlimit = paramInt;
  }
  
  public boolean markSupported()
  {
    return markSupported;
  }
  
  protected int processByte()
  {
    return 0;
  }
  
  protected void processBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  public int read()
    throws IOException
  {
    if (eof) {
      throw new IOException("Read after end of file");
    }
    if (position == size) {
      return doEndOfFile();
    }
    position += 1L;
    return processByte();
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (eof) {
      throw new IOException("Read after end of file");
    }
    if (position == size) {
      return doEndOfFile();
    }
    position += paramInt2;
    int i = paramInt2;
    if (position > size)
    {
      i = paramInt2 - (int)(position - size);
      position = size;
    }
    processBytes(paramArrayOfByte, paramInt1, i);
    return i;
  }
  
  public void reset()
    throws IOException
  {
    try
    {
      if (!markSupported) {
        throw new UnsupportedOperationException("Mark not supported");
      }
    }
    finally {}
    if (mark < 0L) {
      throw new IOException("No position has been marked");
    }
    if (position > mark + readlimit) {
      throw new IOException("Marked position [" + mark + "] is no longer valid - passed the read limit [" + readlimit + "]");
    }
    position = mark;
    eof = false;
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    if (eof) {
      throw new IOException("Skip after end of file");
    }
    if (position == size) {
      l1 = doEndOfFile();
    }
    do
    {
      return l1;
      position += paramLong;
      l1 = paramLong;
    } while (position <= size);
    long l1 = position;
    long l2 = size;
    position = size;
    return paramLong - (l1 - l2);
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.input.NullInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */