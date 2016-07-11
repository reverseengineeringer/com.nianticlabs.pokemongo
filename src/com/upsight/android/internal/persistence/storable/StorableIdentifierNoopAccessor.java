package com.upsight.android.internal.persistence.storable;

import com.upsight.android.UpsightException;

class StorableIdentifierNoopAccessor
  implements StorableIdentifierAccessor
{
  public String getId(Object paramObject)
    throws UpsightException
  {
    return null;
  }
  
  public void setId(Object paramObject, String paramString)
    throws UpsightException
  {}
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.storable.StorableIdentifierNoopAccessor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */