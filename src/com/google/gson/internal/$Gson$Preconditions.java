package com.google.gson.internal;

public final class $Gson$Preconditions
{
  public static void checkArgument(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException();
    }
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException();
    }
    return paramT;
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal..Gson.Preconditions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */