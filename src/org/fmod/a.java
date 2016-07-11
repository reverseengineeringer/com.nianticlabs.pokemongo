package org.fmod;

import android.media.AudioRecord;
import android.util.Log;
import java.nio.ByteBuffer;

final class a
  implements Runnable
{
  private final FMODAudioDevice a;
  private final ByteBuffer b;
  private final int c;
  private final int d;
  private final int e;
  private volatile Thread f;
  private volatile boolean g;
  private AudioRecord h;
  private boolean i;
  
  a(FMODAudioDevice paramFMODAudioDevice, int paramInt1, int paramInt2)
  {
    a = paramFMODAudioDevice;
    c = paramInt1;
    d = paramInt2;
    e = 2;
    b = ByteBuffer.allocateDirect(AudioRecord.getMinBufferSize(paramInt1, paramInt2, 2));
  }
  
  private void d()
  {
    if (h != null)
    {
      if (h.getState() == 1) {
        h.stop();
      }
      h.release();
      h = null;
    }
    b.position(0);
    i = false;
  }
  
  public final int a()
  {
    return b.capacity();
  }
  
  public final void b()
  {
    if (f != null) {
      c();
    }
    g = true;
    f = new Thread(this);
    f.start();
  }
  
  public final void c()
  {
    while (f != null)
    {
      g = false;
      try
      {
        f.join();
        f = null;
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  public final void run()
  {
    int j = 3;
    label72:
    label169:
    label220:
    for (;;)
    {
      if (g)
      {
        int k = j;
        boolean bool;
        if (!i)
        {
          k = j;
          if (j > 0)
          {
            d();
            h = new AudioRecord(1, c, d, e, b.capacity());
            if (h.getState() == 1)
            {
              bool = true;
              i = bool;
              if (!i) {
                break label169;
              }
              b.position(0);
              h.startRecording();
            }
          }
        }
        for (j = 3;; j = k)
        {
          if ((!i) || (h.getRecordingState() != 3)) {
            break label220;
          }
          k = h.read(b, b.capacity());
          a.fmodProcessMicData(b, k);
          b.position(0);
          break;
          bool = false;
          break label72;
          Log.e("FMOD", "AudioRecord failed to initialize (status " + h.getState() + ")");
          k = j - 1;
          d();
        }
      }
      d();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     org.fmod.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */