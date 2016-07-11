package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;

public class DemuxOutputStream
  extends OutputStream
{
  private final InheritableThreadLocal<OutputStream> m_streams = new InheritableThreadLocal();
  
  public OutputStream bindStream(OutputStream paramOutputStream)
  {
    OutputStream localOutputStream = (OutputStream)m_streams.get();
    m_streams.set(paramOutputStream);
    return localOutputStream;
  }
  
  public void close()
    throws IOException
  {
    OutputStream localOutputStream = (OutputStream)m_streams.get();
    if (localOutputStream != null) {
      localOutputStream.close();
    }
  }
  
  public void flush()
    throws IOException
  {
    OutputStream localOutputStream = (OutputStream)m_streams.get();
    if (localOutputStream != null) {
      localOutputStream.flush();
    }
  }
  
  public void write(int paramInt)
    throws IOException
  {
    OutputStream localOutputStream = (OutputStream)m_streams.get();
    if (localOutputStream != null) {
      localOutputStream.write(paramInt);
    }
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.output.DemuxOutputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */