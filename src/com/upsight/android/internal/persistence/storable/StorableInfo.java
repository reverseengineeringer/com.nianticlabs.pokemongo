package com.upsight.android.internal.persistence.storable;

import com.upsight.android.persistence.UpsightStorableSerializer;

public final class StorableInfo<T>
{
  private final StorableIdentifierAccessor mIdentifierAccessor;
  private final UpsightStorableSerializer<T> mSerializer;
  private final StorableTypeAccessor<T> mStorableType;
  
  StorableInfo(StorableTypeAccessor<T> paramStorableTypeAccessor, UpsightStorableSerializer<T> paramUpsightStorableSerializer, StorableIdentifierAccessor paramStorableIdentifierAccessor)
  {
    if (paramStorableTypeAccessor == null) {
      throw new IllegalArgumentException("StorableTypeAccessor type can not be null.");
    }
    if (paramUpsightStorableSerializer == null) {
      throw new IllegalArgumentException("UpsightStorableSerializer can not be null.");
    }
    if (paramStorableIdentifierAccessor == null) {
      throw new IllegalArgumentException("StorableIdentifierAccessor can not be null.");
    }
    mStorableType = paramStorableTypeAccessor;
    mSerializer = paramUpsightStorableSerializer;
    mIdentifierAccessor = paramStorableIdentifierAccessor;
  }
  
  public static final <T> StorableInfo<T> create(StorableTypeAccessor<T> paramStorableTypeAccessor, UpsightStorableSerializer<T> paramUpsightStorableSerializer, StorableIdentifierAccessor paramStorableIdentifierAccessor)
  {
    return new StorableInfo(paramStorableTypeAccessor, paramUpsightStorableSerializer, paramStorableIdentifierAccessor);
  }
  
  public UpsightStorableSerializer<T> getDeserializer()
  {
    return mSerializer;
  }
  
  public StorableIdentifierAccessor getIdentifierAccessor()
  {
    return mIdentifierAccessor;
  }
  
  public StorableTypeAccessor<T> getStorableTypeAccessor()
  {
    return mStorableType;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.storable.StorableInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */