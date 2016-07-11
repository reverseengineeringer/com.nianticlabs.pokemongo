package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.io.Serializable;

public class DefaultPrettyPrinter$NopIndenter
  implements DefaultPrettyPrinter.Indenter, Serializable
{
  public static final NopIndenter instance = new NopIndenter();
  
  public boolean isInline()
  {
    return true;
  }
  
  public void writeIndentation(JsonGenerator paramJsonGenerator, int paramInt)
    throws IOException
  {}
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.util.DefaultPrettyPrinter.NopIndenter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */