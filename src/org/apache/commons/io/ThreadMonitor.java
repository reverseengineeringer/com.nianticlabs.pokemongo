package org.apache.commons.io;

class ThreadMonitor
  implements Runnable
{
  private final Thread thread;
  private final long timeout;
  
  private ThreadMonitor(Thread paramThread, long paramLong)
  {
    thread = paramThread;
    timeout = paramLong;
  }
  
  public static Thread start(long paramLong)
  {
    return start(Thread.currentThread(), paramLong);
  }
  
  public static Thread start(Thread paramThread, long paramLong)
  {
    Thread localThread = null;
    if (paramLong > 0L)
    {
      localThread = new Thread(new ThreadMonitor(paramThread, paramLong), ThreadMonitor.class.getSimpleName());
      localThread.setDaemon(true);
      localThread.start();
    }
    return localThread;
  }
  
  public static void stop(Thread paramThread)
  {
    if (paramThread != null) {
      paramThread.interrupt();
    }
  }
  
  public void run()
  {
    try
    {
      Thread.sleep(timeout);
      thread.interrupt();
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
}

/* Location:
 * Qualified Name:     org.apache.commons.io.ThreadMonitor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */