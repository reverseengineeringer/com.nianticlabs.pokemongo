package com.google.vr.cardboard;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;

public class DisplaySynchronizer
  implements Choreographer.FrameCallback
{
  private static final long FRAME_TIME_NS = 16666666L;
  private Choreographer choreographer = Choreographer.getInstance();
  private final long nativeDisplaySynchronizer = nativeInit(16666666L);
  
  public DisplaySynchronizer()
  {
    choreographer.postFrameCallback(this);
  }
  
  private native void nativeAddSyncTime(long paramLong1, long paramLong2);
  
  private native void nativeDestroy(long paramLong);
  
  private native long nativeInit(long paramLong);
  
  private native long nativeRetainNativeDisplaySynchronizer(long paramLong);
  
  private native long nativeSyncToNextVsync(long paramLong);
  
  public void doFrame(long paramLong)
  {
    nativeAddSyncTime(nativeDisplaySynchronizer, paramLong);
    choreographer.postFrameCallback(this);
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      nativeDestroy(nativeDisplaySynchronizer);
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public long retainNativeDisplaySynchronizer()
  {
    return nativeRetainNativeDisplaySynchronizer(nativeDisplaySynchronizer);
  }
  
  public long syncToNextVsync()
  {
    return nativeSyncToNextVsync(nativeDisplaySynchronizer);
  }
}

/* Location:
 * Qualified Name:     com.google.vr.cardboard.DisplaySynchronizer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */