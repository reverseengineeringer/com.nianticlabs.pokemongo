package org.apache.commons.io.input;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

public abstract class ProxyReader
  extends FilterReader
{
  public ProxyReader(Reader paramReader)
  {
    super(paramReader);
  }
  
  protected void afterRead(int paramInt)
    throws IOException
  {}
  
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
    throws IOException
  {
    try
    {
      in.mark(paramInt);
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
  
  public int read(CharBuffer paramCharBuffer)
    throws IOException
  {
    if (paramCharBuffer != null) {}
    for (;;)
    {
      try
      {
        i = paramCharBuffer.length();
        beforeRead(i);
        i = in.read(paramCharBuffer);
        afterRead(i);
        return i;
      }
      catch (IOException paramCharBuffer)
      {
        int i;
        handleIOException(paramCharBuffer);
      }
      i = 0;
    }
    return -1;
  }
  
  public int read(char[] paramArrayOfChar)
    throws IOException
  {
    if (paramArrayOfChar != null) {}
    for (;;)
    {
      try
      {
        i = paramArrayOfChar.length;
        beforeRead(i);
        i = in.read(paramArrayOfChar);
        afterRead(i);
        return i;
      }
      catch (IOException paramArrayOfChar)
      {
        int i;
        handleIOException(paramArrayOfChar);
      }
      i = 0;
    }
    return -1;
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      beforeRead(paramInt2);
      paramInt1 = in.read(paramArrayOfChar, paramInt1, paramInt2);
      afterRead(paramInt1);
      return paramInt1;
    }
    catch (IOException paramArrayOfChar)
    {
      handleIOException(paramArrayOfChar);
    }
    return -1;
  }
  
  public boolean ready()
    throws IOException
  {
    try
    {
      boolean bool = in.ready();
      return bool;
    }
    catch (IOException localIOException)
    {
      handleIOException(localIOException);
    }
    return false;
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
 * Qualified Name:     org.apache.commons.io.input.ProxyReader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */