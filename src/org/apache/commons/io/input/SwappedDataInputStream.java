package org.apache.commons.io.input;

import java.io.DataInput;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.EndianUtils;

public class SwappedDataInputStream
  extends ProxyInputStream
  implements DataInput
{
  public SwappedDataInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public boolean readBoolean()
    throws IOException, EOFException
  {
    return readByte() != 0;
  }
  
  public byte readByte()
    throws IOException, EOFException
  {
    return (byte)in.read();
  }
  
  public char readChar()
    throws IOException, EOFException
  {
    return (char)readShort();
  }
  
  public double readDouble()
    throws IOException, EOFException
  {
    return EndianUtils.readSwappedDouble(in);
  }
  
  public float readFloat()
    throws IOException, EOFException
  {
    return EndianUtils.readSwappedFloat(in);
  }
  
  public void readFully(byte[] paramArrayOfByte)
    throws IOException, EOFException
  {
    readFully(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException, EOFException
  {
    int i = paramInt2;
    while (i > 0)
    {
      int j = read(paramArrayOfByte, paramInt1 + paramInt2 - i, i);
      if (-1 == j) {
        throw new EOFException();
      }
      i -= j;
    }
  }
  
  public int readInt()
    throws IOException, EOFException
  {
    return EndianUtils.readSwappedInteger(in);
  }
  
  public String readLine()
    throws IOException, EOFException
  {
    throw new UnsupportedOperationException("Operation not supported: readLine()");
  }
  
  public long readLong()
    throws IOException, EOFException
  {
    return EndianUtils.readSwappedLong(in);
  }
  
  public short readShort()
    throws IOException, EOFException
  {
    return EndianUtils.readSwappedShort(in);
  }
  
  public String readUTF()
    throws IOException, EOFException
  {
    throw new UnsupportedOperationException("Operation not supported: readUTF()");
  }
  
  public int readUnsignedByte()
    throws IOException, EOFException
  {
    return in.read();
  }
  
  public int readUnsignedShort()
    throws IOException, EOFException
  {
    return EndianUtils.readSwappedUnsignedShort(in);
  }
  
  public int skipBytes(int paramInt)
    throws IOException, EOFException
  {
    return (int)in.skip(paramInt);
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.input.SwappedDataInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */