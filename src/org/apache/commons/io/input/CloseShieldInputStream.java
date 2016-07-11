package org.apache.commons.io.input;

import java.io.InputStream;

public class CloseShieldInputStream
  extends ProxyInputStream
{
  public CloseShieldInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public void close()
  {
    in = new ClosedInputStream();
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.input.CloseShieldInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */