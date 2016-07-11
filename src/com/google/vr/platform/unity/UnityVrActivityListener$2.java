package com.google.vr.platform.unity;

class UnityVrActivityListener$2
  implements Runnable
{
  UnityVrActivityListener$2(UnityVrActivityListener paramUnityVrActivityListener, int paramInt1, int paramInt2, long paramLong) {}
  
  public void run()
  {
    this$0.injectTouchUp(val$x, val$y, val$time);
    UnityVrActivityListener.access$102(this$0, false);
    if ((UnityVrActivityListener.access$200(this$0)) && ((val$x != UnityVrActivityListener.access$300(this$0)) || (val$y != UnityVrActivityListener.access$400(this$0)))) {
      this$0.injectMouseMove(UnityVrActivityListener.access$300(this$0), UnityVrActivityListener.access$400(this$0));
    }
  }
}

/* Location:
 * Qualified Name:     com.google.vr.platform.unity.UnityVrActivityListener.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */