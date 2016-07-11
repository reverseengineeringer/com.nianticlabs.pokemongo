package com.fasterxml.jackson.databind.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ByteBufferBackedInputStream
  extends InputStream
{
  protected final ByteBuffer _b;
  
  public ByteBufferBackedInputStream(ByteBuffer paramByteBuffer)
  {
    _b = paramByteBuffer;
  }
  
  public int available()
  {
    return _b.remaining();
  }
  
  public int read()
    throws IOException
  {
    if (_b.hasRemaining()) {
      return _b.get() & 0xFF;
    }
    return -1;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (!_b.hasRemaining()) {
      return -1;
    }
    paramInt2 = Math.min(paramInt2, _b.remaining());
    _b.get(paramArrayOfByte, paramInt1, paramInt2);
    return paramInt2;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.util.ByteBufferBackedInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */