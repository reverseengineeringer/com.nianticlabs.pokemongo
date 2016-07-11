package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

public class CharSequenceInputStream
  extends InputStream
{
  private final ByteBuffer bbuf;
  private final CharBuffer cbuf;
  private final CharsetEncoder encoder;
  private int mark;
  
  public CharSequenceInputStream(CharSequence paramCharSequence, String paramString)
  {
    this(paramCharSequence, paramString, 2048);
  }
  
  public CharSequenceInputStream(CharSequence paramCharSequence, String paramString, int paramInt)
  {
    this(paramCharSequence, Charset.forName(paramString), paramInt);
  }
  
  public CharSequenceInputStream(CharSequence paramCharSequence, Charset paramCharset)
  {
    this(paramCharSequence, paramCharset, 2048);
  }
  
  public CharSequenceInputStream(CharSequence paramCharSequence, Charset paramCharset, int paramInt)
  {
    encoder = paramCharset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
    bbuf = ByteBuffer.allocate(paramInt);
    bbuf.flip();
    cbuf = CharBuffer.wrap(paramCharSequence);
    mark = -1;
  }
  
  private void fillBuffer()
    throws CharacterCodingException
  {
    bbuf.compact();
    CoderResult localCoderResult = encoder.encode(cbuf, bbuf, true);
    if (localCoderResult.isError()) {
      localCoderResult.throwException();
    }
    bbuf.flip();
  }
  
  public int available()
    throws IOException
  {
    return cbuf.remaining();
  }
  
  public void close()
    throws IOException
  {}
  
  public void mark(int paramInt)
  {
    try
    {
      mark = cbuf.position();
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
    return true;
  }
  
  public int read()
    throws IOException
  {
    do
    {
      if (bbuf.hasRemaining()) {
        return bbuf.get() & 0xFF;
      }
      fillBuffer();
    } while ((bbuf.hasRemaining()) || (cbuf.hasRemaining()));
    return -1;
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = -1;
    if (paramArrayOfByte == null) {
      throw new NullPointerException("Byte array is null");
    }
    if ((paramInt2 < 0) || (paramInt1 + paramInt2 > paramArrayOfByte.length)) {
      throw new IndexOutOfBoundsException("Array Size=" + paramArrayOfByte.length + ", offset=" + paramInt1 + ", length=" + paramInt2);
    }
    if (paramInt2 == 0) {
      i = 0;
    }
    while ((!bbuf.hasRemaining()) && (!cbuf.hasRemaining())) {
      return i;
    }
    int j = 0;
    i = paramInt1;
    paramInt1 = j;
    do
    {
      for (;;)
      {
        if (paramInt2 <= 0) {
          break label198;
        }
        if (!bbuf.hasRemaining()) {
          break;
        }
        j = Math.min(bbuf.remaining(), paramInt2);
        bbuf.get(paramArrayOfByte, i, j);
        i += j;
        paramInt2 -= j;
        paramInt1 += j;
      }
      fillBuffer();
    } while ((bbuf.hasRemaining()) || (cbuf.hasRemaining()));
    label198:
    paramInt2 = paramInt1;
    if (paramInt1 == 0)
    {
      paramInt2 = paramInt1;
      if (!cbuf.hasRemaining()) {
        paramInt2 = -1;
      }
    }
    return paramInt2;
  }
  
  public void reset()
    throws IOException
  {
    try
    {
      if (mark != -1)
      {
        cbuf.position(mark);
        mark = -1;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    int i = 0;
    while ((paramLong > 0L) && (cbuf.hasRemaining()))
    {
      cbuf.get();
      paramLong -= 1L;
      i += 1;
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.input.CharSequenceInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */