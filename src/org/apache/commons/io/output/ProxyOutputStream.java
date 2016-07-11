package org.apache.commons.io.output;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ProxyOutputStream
  extends FilterOutputStream
{
  public ProxyOutputStream(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  protected void afterWrite(int paramInt)
    throws IOException
  {}
  
  protected void beforeWrite(int paramInt)
    throws IOException
  {}
  
  public void close()
    throws IOException
  {
    try
    {
      out.close();
      return;
    }
    catch (IOException localIOException)
    {
      handleIOException(localIOException);
    }
  }
  
  public void flush()
    throws IOException
  {
    try
    {
      out.flush();
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
  
  public void write(int paramInt)
    throws IOException
  {
    try
    {
      beforeWrite(1);
      out.write(paramInt);
      afterWrite(1);
      return;
    }
    catch (IOException localIOException)
    {
      handleIOException(localIOException);
    }
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        i = paramArrayOfByte.length;
        beforeWrite(i);
        out.write(paramArrayOfByte);
        afterWrite(i);
        return;
      }
      catch (IOException paramArrayOfByte)
      {
        int i;
        handleIOException(paramArrayOfByte);
      }
      i = 0;
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      beforeWrite(paramInt2);
      out.write(paramArrayOfByte, paramInt1, paramInt2);
      afterWrite(paramInt2);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      handleIOException(paramArrayOfByte);
    }
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.output.ProxyOutputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */