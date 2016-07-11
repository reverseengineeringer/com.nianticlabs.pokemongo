package org.apache.commons.io.input;

import java.io.InputStream;

public class ClosedInputStream
  extends InputStream
{
  public static final ClosedInputStream CLOSED_INPUT_STREAM = new ClosedInputStream();
  
  public int read()
  {
    return -1;
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.input.ClosedInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */