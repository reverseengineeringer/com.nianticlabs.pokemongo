package com.upsight.android.internal.persistence.storable;

import com.upsight.android.UpsightException;

class StorableStaticTypeAccessor<T>
  implements StorableTypeAccessor<T>
{
  private final String mType;
  
  public StorableStaticTypeAccessor(String paramString)
  {
    mType = paramString;
  }
  
  public String getType()
    throws UpsightException
  {
    return mType;
  }
  
  public String getType(T paramT)
    throws UpsightException
  {
    return mType;
  }
  
  public boolean isDynamic()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.storable.StorableStaticTypeAccessor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */