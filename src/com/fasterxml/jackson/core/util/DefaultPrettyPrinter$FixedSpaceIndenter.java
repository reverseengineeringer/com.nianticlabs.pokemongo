package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;

public class DefaultPrettyPrinter$FixedSpaceIndenter
  extends DefaultPrettyPrinter.NopIndenter
{
  public static final FixedSpaceIndenter instance = new FixedSpaceIndenter();
  
  public boolean isInline()
  {
    return true;
  }
  
  public void writeIndentation(JsonGenerator paramJsonGenerator, int paramInt)
    throws IOException
  {
    paramJsonGenerator.writeRaw(' ');
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.util.DefaultPrettyPrinter.FixedSpaceIndenter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */