package com.squareup.otto;

import android.os.Looper;

public abstract interface ThreadEnforcer
{
  public static final ThreadEnforcer ANY = new ThreadEnforcer()
  {
    public void enforce(Bus paramAnonymousBus) {}
  };
  public static final ThreadEnforcer MAIN = new ThreadEnforcer()
  {
    public void enforce(Bus paramAnonymousBus)
    {
      if (Looper.myLooper() != Looper.getMainLooper()) {
        throw new IllegalStateException("Event bus " + paramAnonymousBus + " accessed from non-main thread " + Looper.myLooper());
      }
    }
  };
  
  public abstract void enforce(Bus paramBus);
}

/* Location:
 * Qualified Name:     com.squareup.otto.ThreadEnforcer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */