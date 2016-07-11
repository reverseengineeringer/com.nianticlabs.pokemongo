package com.fasterxml.jackson.databind.util;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class ByteBufferBackedOutputStream
  extends OutputStream
{
  protected final ByteBuffer _b;
  
  public ByteBufferBackedOutputStream(ByteBuffer paramByteBuffer)
  {
    _b = paramByteBuffer;
  }
  
  public void write(int paramInt)
    throws IOException
  {
    _b.put((byte)paramInt);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    _b.put(paramArrayOfByte, paramInt1, paramInt2);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.util.ByteBufferBackedOutputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */