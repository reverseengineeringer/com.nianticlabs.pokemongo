package com.squareup.otto;

import android.os.Looper;

final class ThreadEnforcer$2
  implements ThreadEnforcer
{
  public void enforce(Bus paramBus)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new IllegalStateException("Event bus " + paramBus + " accessed from non-main thread " + Looper.myLooper());
    }
  }
}

/* Location:
 * Qualified Name:     com.squareup.otto.ThreadEnforcer.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */