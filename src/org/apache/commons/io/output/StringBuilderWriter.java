package org.apache.commons.io.output;

import java.io.Serializable;
import java.io.Writer;

public class StringBuilderWriter
  extends Writer
  implements Serializable
{
  private final StringBuilder builder;
  
  public StringBuilderWriter()
  {
    builder = new StringBuilder();
  }
  
  public StringBuilderWriter(int paramInt)
  {
    builder = new StringBuilder(paramInt);
  }
  
  public StringBuilderWriter(StringBuilder paramStringBuilder)
  {
    if (paramStringBuilder != null) {}
    for (;;)
    {
      builder = paramStringBuilder;
      return;
      paramStringBuilder = new StringBuilder();
    }
  }
  
  public Writer append(char paramChar)
  {
    builder.append(paramChar);
    return this;
  }
  
  public Writer append(CharSequence paramCharSequence)
  {
    builder.append(paramCharSequence);
    return this;
  }
  
  public Writer append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    builder.append(paramCharSequence, paramInt1, paramInt2);
    return this;
  }
  
  public void close() {}
  
  public void flush() {}
  
  public StringBuilder getBuilder()
  {
    return builder;
  }
  
  public String toString()
  {
    return builder.toString();
  }
  
  public void write(String paramString)
  {
    if (paramString != null) {
      builder.append(paramString);
    }
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramArrayOfChar != null) {
      builder.append(paramArrayOfChar, paramInt1, paramInt2);
    }
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.output.StringBuilderWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */