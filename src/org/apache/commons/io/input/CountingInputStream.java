package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

public class CountingInputStream
  extends ProxyInputStream
{
  private long count;
  
  public CountingInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  protected void afterRead(int paramInt)
  {
    if (paramInt != -1) {}
    try
    {
      count += paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long getByteCount()
  {
    try
    {
      long l = count;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getCount()
  {
    long l = getByteCount();
    if (l > 2147483647L) {
      throw new ArithmeticException("The byte count " + l + " is too large to be converted to an int");
    }
    return (int)l;
  }
  
  public long resetByteCount()
  {
    try
    {
      long l = count;
      count = 0L;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int resetCount()
  {
    long l = resetByteCount();
    if (l > 2147483647L) {
      throw new ArithmeticException("The byte count " + l + " is too large to be converted to an int");
    }
    return (int)l;
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    try
    {
      paramLong = super.skip(paramLong);
      count += paramLong;
      return paramLong;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.input.CountingInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */