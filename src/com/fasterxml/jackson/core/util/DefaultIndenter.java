package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;

public class DefaultIndenter
  extends DefaultPrettyPrinter.NopIndenter
{
  private static final int INDENT_LEVELS = 16;
  public static final DefaultIndenter SYSTEM_LINEFEED_INSTANCE;
  public static final String SYS_LF;
  private static final long serialVersionUID = 1L;
  private final int charsPerLevel;
  private final String eol;
  private final char[] indents;
  
  static
  {
    try
    {
      String str1 = System.getProperty("line.separator");
      SYS_LF = str1;
      SYSTEM_LINEFEED_INSTANCE = new DefaultIndenter("  ", SYS_LF);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        String str2 = "\n";
      }
    }
  }
  
  public DefaultIndenter()
  {
    this("  ", SYS_LF);
  }
  
  public DefaultIndenter(String paramString1, String paramString2)
  {
    charsPerLevel = paramString1.length();
    indents = new char[paramString1.length() * 16];
    int j = 0;
    int i = 0;
    while (i < 16)
    {
      paramString1.getChars(0, paramString1.length(), indents, j);
      j += paramString1.length();
      i += 1;
    }
    eol = paramString2;
  }
  
  public String getEol()
  {
    return eol;
  }
  
  public String getIndent()
  {
    return new String(indents, 0, charsPerLevel);
  }
  
  public boolean isInline()
  {
    return false;
  }
  
  public DefaultIndenter withIndent(String paramString)
  {
    if (paramString.equals(getIndent())) {
      return this;
    }
    return new DefaultIndenter(paramString, eol);
  }
  
  public DefaultIndenter withLinefeed(String paramString)
  {
    if (paramString.equals(eol)) {
      return this;
    }
    return new DefaultIndenter(getIndent(), paramString);
  }
  
  public void writeIndentation(JsonGenerator paramJsonGenerator, int paramInt)
    throws IOException
  {
    paramJsonGenerator.writeRaw(eol);
    if (paramInt > 0)
    {
      paramInt *= charsPerLevel;
      while (paramInt > indents.length)
      {
        paramJsonGenerator.writeRaw(indents, 0, indents.length);
        paramInt -= indents.length;
      }
      paramJsonGenerator.writeRaw(indents, 0, paramInt);
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.util.DefaultIndenter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */