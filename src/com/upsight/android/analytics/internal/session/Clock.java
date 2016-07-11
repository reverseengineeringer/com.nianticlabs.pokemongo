package com.upsight.android.analytics.internal.session;

public abstract interface Clock
{
  public abstract long currentTimeMillis();
  
  public abstract long currentTimeSeconds();
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.session.Clock
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */