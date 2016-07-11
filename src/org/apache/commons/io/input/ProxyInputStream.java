package org.apache.commons.io.input;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class ProxyInputStream
  extends FilterInputStream
{
  public ProxyInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  protected void afterRead(int paramInt)
    throws IOException
  {}
  
  public int available()
    throws IOException
  {
    try
    {
      int i = super.available();
      return i;
    }
    catch (IOException localIOException)
    {
      handleIOException(localIOException);
    }
    return 0;
  }
  
  protected void beforeRead(int paramInt)
    throws IOException
  {}
  
  public void close()
    throws IOException
  {
    try
    {
      in.close();
      return;
    }
    catch (IOException localIOException)
    {
      handleIOException(localIOException);
    }
  }
  
  protected void handleIOException(IOException paramIOException)
    throws IOException
  {
    throw paramIOException;
  }
  
  public void mark(int paramInt)
  {
    try
    {
      in.mark(paramInt);
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
    int i = 1;
    try
    {
      beforeRead(1);
      int j = in.read();
      if (j != -1) {}
      for (;;)
      {
        afterRead(i);
        return j;
        i = -1;
      }
      return -1;
    }
    catch (IOException localIOException)
    {
      handleIOException(localIOException);
    }
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        i = paramArrayOfByte.length;
        beforeRead(i);
        i = in.read(paramArrayOfByte);
        afterRead(i);
        return i;
      }
      catch (IOException paramArrayOfByte)
      {
        int i;
        handleIOException(paramArrayOfByte);
      }
      i = 0;
    }
    return -1;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      beforeRead(paramInt2);
      paramInt1 = in.read(paramArrayOfByte, paramInt1, paramInt2);
      afterRead(paramInt1);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte)
    {
      handleIOException(paramArrayOfByte);
    }
    return -1;
  }
  
  public void reset()
    throws IOException
  {
    try
    {
      in.reset();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        handleIOException(localIOException);
      }
    }
    finally {}
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    try
    {
      paramLong = in.skip(paramLong);
      return paramLong;
    }
    catch (IOException localIOException)
    {
      handleIOException(localIOException);
    }
    return 0L;
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.input.ProxyInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */