package com.upsight.android.internal.persistence.storable;

import com.upsight.android.UpsightException;

public abstract interface StorableTypeAccessor<T>
{
  public abstract String getType()
    throws UpsightException;
  
  public abstract String getType(T paramT)
    throws UpsightException;
  
  public abstract boolean isDynamic();
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.storable.StorableTypeAccessor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */