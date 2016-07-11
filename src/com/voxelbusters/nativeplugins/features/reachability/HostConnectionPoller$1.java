package com.voxelbusters.nativeplugins.features.reachability;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

class HostConnectionPoller$1
  implements Runnable
{
  HostConnectionPoller$1(HostConnectionPoller paramHostConnectionPoller) {}
  
  public void run()
  {
    InetSocketAddress localInetSocketAddress = new InetSocketAddress(this$0.getIp(), this$0.getPort());
    for (;;)
    {
      Socket localSocket = new Socket();
      try
      {
        localSocket.connect(localInetSocketAddress, (int)(this$0.getConnectionTimeOutPeriod() * 1000L));
        HostConnectionPoller.access$0(this$0);
        localSocket.close();
        try
        {
          Thread.sleep((HostConnectionPoller.access$2(this$0) * 1000.0F));
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          HostConnectionPoller.access$1(this$0);
          localIOException.printStackTrace();
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.voxelbusters.nativeplugins.features.reachability.HostConnectionPoller.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */