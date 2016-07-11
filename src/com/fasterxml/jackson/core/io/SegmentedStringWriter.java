package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.io.Writer;

public final class SegmentedStringWriter
  extends Writer
{
  protected final TextBuffer _buffer;
  
  public SegmentedStringWriter(BufferRecycler paramBufferRecycler)
  {
    _buffer = new TextBuffer(paramBufferRecycler);
  }
  
  public Writer append(char paramChar)
  {
    write(paramChar);
    return this;
  }
  
  public Writer append(CharSequence paramCharSequence)
  {
    paramCharSequence = paramCharSequence.toString();
    _buffer.append(paramCharSequence, 0, paramCharSequence.length());
    return this;
  }
  
  public Writer append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2).toString();
    _buffer.append(paramCharSequence, 0, paramCharSequence.length());
    return this;
  }
  
  public void close() {}
  
  public void flush() {}
  
  public String getAndClear()
  {
    String str = _buffer.contentsAsString();
    _buffer.releaseBuffers();
    return str;
  }
  
  public void write(int paramInt)
  {
    _buffer.append((char)paramInt);
  }
  
  public void write(String paramString)
  {
    _buffer.append(paramString, 0, paramString.length());
  }
  
  public void write(String paramString, int paramInt1, int paramInt2)
  {
    _buffer.append(paramString, paramInt1, paramInt2);
  }
  
  public void write(char[] paramArrayOfChar)
  {
    _buffer.append(paramArrayOfChar, 0, paramArrayOfChar.length);
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    _buffer.append(paramArrayOfChar, paramInt1, paramInt2);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.io.SegmentedStringWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */