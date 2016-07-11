package com.unity3d.player;

import java.util.concurrent.ArrayBlockingQueue;

final class UnityPlayer$b
  extends Thread
{
  ArrayBlockingQueue a = new ArrayBlockingQueue(32);
  boolean b = false;
  
  UnityPlayer$b(UnityPlayer paramUnityPlayer) {}
  
  private void a(UnityPlayer.a parama)
  {
    try
    {
      a.put(parama);
      return;
    }
    catch (InterruptedException parama)
    {
      interrupt();
    }
  }
  
  public final void a()
  {
    a(UnityPlayer.a.c);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (UnityPlayer.a locala = UnityPlayer.a.d;; locala = UnityPlayer.a.e)
    {
      a(locala);
      return;
    }
  }
  
  public final void b()
  {
    a(UnityPlayer.a.b);
  }
  
  public final void c()
  {
    a(UnityPlayer.a.a);
  }
  
  public final void run()
  {
    setName("UnityMain");
    try
    {
      UnityPlayer.a locala = (UnityPlayer.a)a.take();
      if (locala != UnityPlayer.a.c)
      {
        if (locala == UnityPlayer.a.b) {
          b = true;
        }
        while (b)
        {
          do
          {
            c.executeGLThreadJobs();
            if (a.peek() != null) {
              break;
            }
            if ((!c.isFinishing()) && (!UnityPlayer.a(c))) {
              UnityPlayer.b(c);
            }
          } while (!interrupted());
          break;
          if (locala == UnityPlayer.a.a)
          {
            b = false;
            c.executeGLThreadJobs();
          }
          else if ((locala == UnityPlayer.a.e) && (!b))
          {
            c.executeGLThreadJobs();
          }
        }
      }
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.UnityPlayer.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */