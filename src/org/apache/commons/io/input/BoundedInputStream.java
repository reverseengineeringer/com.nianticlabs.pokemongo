package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

public class BoundedInputStream
  extends InputStream
{
  private final InputStream in;
  private long mark = -1L;
  private final long max;
  private long pos = 0L;
  private boolean propagateClose = true;
  
  public BoundedInputStream(InputStream paramInputStream)
  {
    this(paramInputStream, -1L);
  }
  
  public BoundedInputStream(InputStream paramInputStream, long paramLong)
  {
    max = paramLong;
    in = paramInputStream;
  }
  
  public int available()
    throws IOException
  {
    if ((max >= 0L) && (pos >= max)) {
      return 0;
    }
    return in.available();
  }
  
  public void close()
    throws IOException
  {
    if (propagateClose) {
      in.close();
    }
  }
  
  public boolean isPropagateClose()
  {
    return propagateClose;
  }
  
  public void mark(int paramInt)
  {
    try
    {
      in.mark(paramInt);
      mark = pos;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean markSupported()
  {
    return in.markSupported();
  }
  
  public int read()
    throws IOException
  {
    if ((max >= 0L) && (pos >= max)) {
      return -1;
    }
    int i = in.read();
    pos += 1L;
    return i;
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if ((max >= 0L) && (pos >= max)) {
      return -1;
    }
    if (max >= 0L) {}
    for (long l = Math.min(paramInt2, max - pos);; l = paramInt2)
    {
      paramInt1 = in.read(paramArrayOfByte, paramInt1, (int)l);
      if (paramInt1 != -1) {
        break;
      }
      return -1;
    }
    pos += paramInt1;
    return paramInt1;
  }
  
  public void reset()
    throws IOException
  {
    try
    {
      in.reset();
      pos = mark;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setPropagateClose(boolean paramBoolean)
  {
    propagateClose = paramBoolean;
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    if (max >= 0L) {
      paramLong = Math.min(paramLong, max - pos);
    }
    for (;;)
    {
      paramLong = in.skip(paramLong);
      pos += paramLong;
      return paramLong;
    }
  }
  
  public String toString()
  {
    return in.toString();
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.input.BoundedInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */