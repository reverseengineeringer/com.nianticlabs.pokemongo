package com.google.android.gms.common.api;

public abstract class OptionalPendingResult<R extends Result>
  extends PendingResult<R>
{
  public abstract R get();
  
  public abstract boolean isDone();
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.OptionalPendingResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */