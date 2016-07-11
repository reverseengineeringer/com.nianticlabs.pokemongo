package org.apache.commons.io.output;

import java.io.OutputStream;

public class CloseShieldOutputStream
  extends ProxyOutputStream
{
  public CloseShieldOutputStream(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  public void close()
  {
    out = new ClosedOutputStream();
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.output.CloseShieldOutputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */