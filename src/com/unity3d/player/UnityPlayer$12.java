package com.unity3d.player;

final class UnityPlayer$12
  implements Runnable
{
  UnityPlayer$12(UnityPlayer paramUnityPlayer, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5) {}
  
  public final void run()
  {
    if (UnityPlayer.q(h) != null) {
      return;
    }
    h.pause();
    UnityPlayer.a(h, new w(h, UnityPlayer.n(h), a, b, c, d, e, f, g));
    h.addView(UnityPlayer.q(h));
    UnityPlayer.q(h).requestFocus();
    UnityPlayer.g(h).d(UnityPlayer.f(h));
  }
}

/* Location:
 * Qualified Name:     com.unity3d.player.UnityPlayer.12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */