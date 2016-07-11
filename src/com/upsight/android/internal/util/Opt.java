package com.upsight.android.internal.util;

public class Opt<T>
{
  private T mObject;
  
  private Opt(T paramT)
  {
    mObject = paramT;
  }
  
  public static <T> Opt<T> absent()
  {
    return new Opt(null);
  }
  
  public static <T> Opt<T> from(T paramT)
  {
    return new Opt(paramT);
  }
  
  public T get()
  {
    return (T)mObject;
  }
  
  public boolean isPresent()
  {
    return mObject != null;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.util.Opt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */