package crittercism.android;

import java.io.FileDescriptor;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketImpl;

final class ac$1
  extends SocketImpl
{
  protected final void accept(SocketImpl paramSocketImpl) {}
  
  protected final int available()
  {
    return 0;
  }
  
  protected final void bind(InetAddress paramInetAddress, int paramInt) {}
  
  protected final void close() {}
  
  protected final void connect(String paramString, int paramInt) {}
  
  protected final void connect(InetAddress paramInetAddress, int paramInt) {}
  
  protected final void connect(SocketAddress paramSocketAddress, int paramInt) {}
  
  protected final void create(boolean paramBoolean) {}
  
  protected final FileDescriptor getFileDescriptor()
  {
    return null;
  }
  
  protected final InetAddress getInetAddress()
  {
    return null;
  }
  
  protected final InputStream getInputStream()
  {
    return null;
  }
  
  protected final int getLocalPort()
  {
    return 0;
  }
  
  public final Object getOption(int paramInt)
  {
    return null;
  }
  
  protected final OutputStream getOutputStream()
  {
    return null;
  }
  
  protected final int getPort()
  {
    return 0;
  }
  
  protected final void listen(int paramInt) {}
  
  protected final void sendUrgentData(int paramInt) {}
  
  public final void setOption(int paramInt, Object paramObject) {}
  
  protected final void setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3) {}
  
  protected final void shutdownInput() {}
  
  protected final void shutdownOutput() {}
  
  protected final boolean supportsUrgentData()
  {
    return false;
  }
  
  public final String toString()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     crittercism.android.ac.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */