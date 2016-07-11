package org.apache.commons.io;

import java.io.IOException;

public class IOExceptionWithCause
  extends IOException
{
  private static final long serialVersionUID = 1L;
  
  public IOExceptionWithCause(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    initCause(paramThrowable);
  }
  
  public IOExceptionWithCause(Throwable paramThrowable) {}
}

/* Location:
 * Qualified Name:     org.apache.commons.io.IOExceptionWithCause
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */