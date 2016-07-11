package com.upsight.android.internal.persistence.storable;

import com.upsight.android.internal.persistence.Storable;
import rx.Observable.Operator;

public final class Storables
{
  public static <T> Observable.Operator<T, Storable> deserialize(StorableInfo<T> paramStorableInfo)
  {
    return new OperatorDeserialize(paramStorableInfo);
  }
  
  public static <T> Observable.Operator<Storable, T> serialize(StorableInfo<T> paramStorableInfo, StorableIdFactory paramStorableIdFactory)
  {
    return new OperatorSerialize(paramStorableInfo, paramStorableIdFactory);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.storable.Storables
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */