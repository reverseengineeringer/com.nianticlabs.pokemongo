package com.fasterxml.jackson.core.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;

public abstract class OutputDecorator
  implements Serializable
{
  public abstract OutputStream decorate(IOContext paramIOContext, OutputStream paramOutputStream)
    throws IOException;
  
  public abstract Writer decorate(IOContext paramIOContext, Writer paramWriter)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.io.OutputDecorator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */