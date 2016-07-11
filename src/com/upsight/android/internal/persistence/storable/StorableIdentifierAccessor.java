package com.upsight.android.internal.persistence.storable;

import com.upsight.android.UpsightException;

public abstract interface StorableIdentifierAccessor
{
  public abstract String getId(Object paramObject)
    throws UpsightException;
  
  public abstract void setId(Object paramObject, String paramString)
    throws UpsightException;
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.storable.StorableIdentifierAccessor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */