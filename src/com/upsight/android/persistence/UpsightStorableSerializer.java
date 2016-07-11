package com.upsight.android.persistence;

import com.upsight.android.UpsightException;

public abstract interface UpsightStorableSerializer<T>
{
  public abstract T fromString(String paramString)
    throws UpsightException;
  
  public abstract String toString(T paramT)
    throws UpsightException;
}

/* Location:
 * Qualified Name:     com.upsight.android.persistence.UpsightStorableSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */