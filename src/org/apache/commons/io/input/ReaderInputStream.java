package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

public class ReaderInputStream
  extends InputStream
{
  private static final int DEFAULT_BUFFER_SIZE = 1024;
  private final CharsetEncoder encoder;
  private final CharBuffer encoderIn;
  private final ByteBuffer encoderOut;
  private boolean endOfInput;
  private CoderResult lastCoderResult;
  private final Reader reader;
  
  public ReaderInputStream(Reader paramReader)
  {
    this(paramReader, Charset.defaultCharset());
  }
  
  public ReaderInputStream(Reader paramReader, String paramString)
  {
    this(paramReader, paramString, 1024);
  }
  
  public ReaderInputStream(Reader paramReader, String paramString, int paramInt)
  {
    this(paramReader, Charset.forName(paramString), paramInt);
  }
  
  public ReaderInputStream(Reader paramReader, Charset paramCharset)
  {
    this(paramReader, paramCharset, 1024);
  }
  
  public ReaderInputStream(Reader paramReader, Charset paramCharset, int paramInt)
  {
    this(paramReader, paramCharset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE), paramInt);
  }
  
  public ReaderInputStream(Reader paramReader, CharsetEncoder paramCharsetEncoder)
  {
    this(paramReader, paramCharsetEncoder, 1024);
  }
  
  public ReaderInputStream(Reader paramReader, CharsetEncoder paramCharsetEncoder, int paramInt)
  {
    reader = paramReader;
    encoder = paramCharsetEncoder;
    encoderIn = CharBuffer.allocate(paramInt);
    encoderIn.flip();
    encoderOut = ByteBuffer.allocate(128);
    encoderOut.flip();
  }
  
  private void fillBuffer()
    throws IOException
  {
    int i;
    int j;
    if ((!endOfInput) && ((lastCoderResult == null) || (lastCoderResult.isUnderflow())))
    {
      encoderIn.compact();
      i = encoderIn.position();
      j = reader.read(encoderIn.array(), i, encoderIn.remaining());
      if (j != -1) {
        break label121;
      }
      endOfInput = true;
    }
    for (;;)
    {
      encoderIn.flip();
      encoderOut.compact();
      lastCoderResult = encoder.encode(encoderIn, encoderOut, endOfInput);
      encoderOut.flip();
      return;
      label121:
      encoderIn.position(i + j);
    }
  }
  
  public void close()
    throws IOException
  {
    reader.close();
  }
  
  public int read()
    throws IOException
  {
    do
    {
      if (encoderOut.hasRemaining()) {
        return encoderOut.get() & 0xFF;
      }
      fillBuffer();
    } while ((!endOfInput) || (encoderOut.hasRemaining()));
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
    if (paramArrayOfByte == null) {
      throw new NullPointerException("Byte array must not be null");
    }
    if ((paramInt2 < 0) || (paramInt1 < 0) || (paramInt1 + paramInt2 > paramArrayOfByte.length)) {
      throw new IndexOutOfBoundsException("Array Size=" + paramArrayOfByte.length + ", offset=" + paramInt1 + ", length=" + paramInt2);
    }
    int i = 0;
    int j = paramInt2;
    if (paramInt2 == 0) {
      return 0;
    }
    do
    {
      for (;;)
      {
        if (j <= 0) {
          break label167;
        }
        if (!encoderOut.hasRemaining()) {
          break;
        }
        paramInt2 = Math.min(encoderOut.remaining(), j);
        encoderOut.get(paramArrayOfByte, paramInt1, paramInt2);
        paramInt1 += paramInt2;
        j -= paramInt2;
        i += paramInt2;
      }
      fillBuffer();
    } while ((!endOfInput) || (encoderOut.hasRemaining()));
    label167:
    if ((i == 0) && (endOfInput)) {
      return -1;
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.input.ReaderInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */