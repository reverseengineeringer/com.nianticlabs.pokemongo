package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

public class WriterOutputStream
  extends OutputStream
{
  private static final int DEFAULT_BUFFER_SIZE = 1024;
  private final CharsetDecoder decoder;
  private final ByteBuffer decoderIn = ByteBuffer.allocate(128);
  private final CharBuffer decoderOut;
  private final boolean writeImmediately;
  private final Writer writer;
  
  public WriterOutputStream(Writer paramWriter)
  {
    this(paramWriter, Charset.defaultCharset(), 1024, false);
  }
  
  public WriterOutputStream(Writer paramWriter, String paramString)
  {
    this(paramWriter, paramString, 1024, false);
  }
  
  public WriterOutputStream(Writer paramWriter, String paramString, int paramInt, boolean paramBoolean)
  {
    this(paramWriter, Charset.forName(paramString), paramInt, paramBoolean);
  }
  
  public WriterOutputStream(Writer paramWriter, Charset paramCharset)
  {
    this(paramWriter, paramCharset, 1024, false);
  }
  
  public WriterOutputStream(Writer paramWriter, Charset paramCharset, int paramInt, boolean paramBoolean)
  {
    this(paramWriter, paramCharset.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).replaceWith("?"), paramInt, paramBoolean);
  }
  
  public WriterOutputStream(Writer paramWriter, CharsetDecoder paramCharsetDecoder)
  {
    this(paramWriter, paramCharsetDecoder, 1024, false);
  }
  
  public WriterOutputStream(Writer paramWriter, CharsetDecoder paramCharsetDecoder, int paramInt, boolean paramBoolean)
  {
    writer = paramWriter;
    decoder = paramCharsetDecoder;
    writeImmediately = paramBoolean;
    decoderOut = CharBuffer.allocate(paramInt);
  }
  
  private void flushOutput()
    throws IOException
  {
    if (decoderOut.position() > 0)
    {
      writer.write(decoderOut.array(), 0, decoderOut.position());
      decoderOut.rewind();
    }
  }
  
  private void processInput(boolean paramBoolean)
    throws IOException
  {
    decoderIn.flip();
    CoderResult localCoderResult;
    for (;;)
    {
      localCoderResult = decoder.decode(decoderIn, decoderOut, paramBoolean);
      if (!localCoderResult.isOverflow()) {
        break;
      }
      flushOutput();
    }
    if (localCoderResult.isUnderflow())
    {
      decoderIn.compact();
      return;
    }
    throw new IOException("Unexpected coder result");
  }
  
  public void close()
    throws IOException
  {
    processInput(true);
    flushOutput();
    writer.close();
  }
  
  public void flush()
    throws IOException
  {
    flushOutput();
    writer.flush();
  }
  
  public void write(int paramInt)
    throws IOException
  {
    write(new byte[] { (byte)paramInt }, 0, 1);
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    while (paramInt2 > 0)
    {
      int i = Math.min(paramInt2, decoderIn.remaining());
      decoderIn.put(paramArrayOfByte, paramInt1, i);
      processInput(false);
      paramInt2 -= i;
      paramInt1 += i;
    }
    if (writeImmediately) {
      flushOutput();
    }
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.output.WriterOutputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */