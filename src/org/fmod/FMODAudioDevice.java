package org.fmod;

import android.media.AudioTrack;
import android.util.Log;
import java.nio.ByteBuffer;

public class FMODAudioDevice
  implements Runnable
{
  private static int h = 0;
  private static int i = 1;
  private static int j = 2;
  private static int k = 3;
  private volatile Thread a = null;
  private volatile boolean b = false;
  private AudioTrack c = null;
  private boolean d = false;
  private ByteBuffer e = null;
  private byte[] f = null;
  private volatile a g;
  
  private native int fmodGetInfo(int paramInt);
  
  private native int fmodProcess(ByteBuffer paramByteBuffer);
  
  private void releaseAudioTrack()
  {
    if (c != null)
    {
      if (c.getState() == 1) {
        c.stop();
      }
      c.release();
      c = null;
    }
    e = null;
    f = null;
    d = false;
  }
  
  public void close()
  {
    try
    {
      stop();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  native int fmodProcessMicData(ByteBuffer paramByteBuffer, int paramInt);
  
  public boolean isRunning()
  {
    return (a != null) && (a.isAlive());
  }
  
  public void run()
  {
    int m = 3;
    boolean bool;
    if (b)
    {
      if ((d) || (m <= 0)) {
        break label314;
      }
      releaseAudioTrack();
      int i2 = fmodGetInfo(h);
      int i1 = Math.round(AudioTrack.getMinBufferSize(i2, 3, 2) * 1.1F) & 0xFFFFFFFC;
      int i3 = fmodGetInfo(i);
      int i4 = fmodGetInfo(j);
      int n = i1;
      if (i3 * i4 * 4 > i1) {
        n = i4 * i3 * 4;
      }
      c = new AudioTrack(3, i2, 3, 2, n, 1);
      if (c.getState() == 1)
      {
        bool = true;
        label122:
        d = bool;
        if (!d) {
          break label255;
        }
        e = ByteBuffer.allocateDirect(i3 * 2 * 2);
        f = new byte[e.capacity()];
        c.play();
        m = 3;
      }
    }
    label255:
    label314:
    for (;;)
    {
      if (d)
      {
        if (fmodGetInfo(k) == 1)
        {
          fmodProcess(e);
          e.get(f, 0, e.capacity());
          c.write(f, 0, e.capacity());
          e.position(0);
          break;
          bool = false;
          break label122;
          Log.e("FMOD", "AudioTrack failed to initialize (status " + c.getState() + ")");
          releaseAudioTrack();
          m -= 1;
          continue;
        }
        releaseAudioTrack();
        break;
        releaseAudioTrack();
        return;
      }
      break;
    }
  }
  
  public void start()
  {
    try
    {
      if (a != null) {
        stop();
      }
      a = new Thread(this, "FMODAudioDevice");
      a.setPriority(10);
      b = true;
      a.start();
      if (g != null) {
        g.b();
      }
      return;
    }
    finally {}
  }
  
  public int startAudioRecord(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      if (g == null)
      {
        g = new a(this, paramInt1, paramInt2);
        g.b();
      }
      paramInt1 = g.a();
      return paramInt1;
    }
    finally {}
  }
  
  public void stop()
  {
    try
    {
      while (a != null)
      {
        b = false;
        try
        {
          a.join();
          a = null;
        }
        catch (InterruptedException localInterruptedException) {}
      }
      if (g != null) {
        g.c();
      }
      return;
    }
    finally {}
  }
  
  public void stopAudioRecord()
  {
    try
    {
      if (g != null)
      {
        g.c();
        g = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     org.fmod.FMODAudioDevice
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */