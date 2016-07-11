package com.voxelbusters.nativeplugins.features.reachability;

import com.voxelbusters.nativeplugins.utilities.Debug;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class HostConnectionPoller
{
  private long connectionTimeOutPeriod = 60L;
  private int currentRetryCount;
  private String ip = "8.8.8.8";
  private int maxRetryCount = 3;
  private int port = 56;
  private Future socketFutureTask = null;
  private float timeGapBetweenPolls = 2.0F;
  
  private void ReportConnectionFailure()
  {
    currentRetryCount += 1;
    if (currentRetryCount > getMaxRetryCount())
    {
      NetworkReachabilityHandler.sendSocketConnectionStatus(false);
      currentRetryCount = 0;
    }
  }
  
  private void ReportConnectionSuccess()
  {
    NetworkReachabilityHandler.sendSocketConnectionStatus(true);
  }
  
  void Start()
  {
    if (socketFutureTask != null) {
      socketFutureTask.cancel(true);
    }
    socketFutureTask = Executors.newSingleThreadExecutor().submit(new Runnable()
    {
      public void run()
      {
        InetSocketAddress localInetSocketAddress = new InetSocketAddress(getIp(), getPort());
        for (;;)
        {
          Socket localSocket = new Socket();
          try
          {
            localSocket.connect(localInetSocketAddress, (int)(getConnectionTimeOutPeriod() * 1000L));
            HostConnectionPoller.this.ReportConnectionSuccess();
            localSocket.close();
            try
            {
              Thread.sleep((timeGapBetweenPolls * 1000.0F));
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
              HostConnectionPoller.this.ReportConnectionFailure();
              localIOException.printStackTrace();
            }
          }
        }
      }
    });
  }
  
  public long getConnectionTimeOutPeriod()
  {
    return connectionTimeOutPeriod;
  }
  
  public String getIp()
  {
    return ip;
  }
  
  public int getMaxRetryCount()
  {
    return maxRetryCount;
  }
  
  public int getPort()
  {
    return port;
  }
  
  public float getTimeGapBetweenPolls()
  {
    return timeGapBetweenPolls;
  }
  
  public void setConnectionTimeOutPeriod(int paramInt)
  {
    if (paramInt != 0)
    {
      connectionTimeOutPeriod = paramInt;
      return;
    }
    Debug.warning("NativePlugins.NetworkConnectivity", "time out value should not be zero. Considering default 60 secs for timeout");
  }
  
  public void setIp(String paramString)
  {
    ip = paramString;
  }
  
  public void setMaxRetryCount(int paramInt)
  {
    maxRetryCount = paramInt;
  }
  
  public void setPort(int paramInt)
  {
    port = paramInt;
  }
  
  public void setTimeGapBetweenPolls(float paramFloat)
  {
    timeGapBetweenPolls = paramFloat;
  }
}

/* Location:
 * Qualified Name:     com.voxelbusters.nativeplugins.features.reachability.HostConnectionPoller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */