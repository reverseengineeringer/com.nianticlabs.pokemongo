package com.upsight.android.internal.persistence.storable;

import com.upsight.android.UpsightException;
import com.upsight.android.internal.persistence.Storable;
import com.upsight.android.persistence.UpsightStorableSerializer;
import rx.Subscriber;

class OperatorSerialize$DeserializeSubscriber<T>
  extends Subscriber<T>
{
  private final Subscriber<? super Storable> mChildSubscriber;
  private final StorableIdFactory mIdFactory;
  private final StorableInfo<T> mStorableInfo;
  
  public OperatorSerialize$DeserializeSubscriber(StorableInfo<T> paramStorableInfo, StorableIdFactory paramStorableIdFactory, Subscriber<? super Storable> paramSubscriber)
  {
    super(paramSubscriber);
    mStorableInfo = paramStorableInfo;
    mChildSubscriber = paramSubscriber;
    mIdFactory = paramStorableIdFactory;
  }
  
  public void onCompleted()
  {
    mChildSubscriber.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    mChildSubscriber.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    UpsightStorableSerializer localUpsightStorableSerializer = mStorableInfo.getDeserializer();
    try
    {
      if (!mChildSubscriber.isUnsubscribed())
      {
        String str1 = mStorableInfo.getIdentifierAccessor().getId(paramT);
        String str2 = mStorableInfo.getStorableTypeAccessor().getType(paramT);
        paramT = localUpsightStorableSerializer.toString(paramT);
        mChildSubscriber.onNext(Storable.create(str1, str2, paramT));
      }
      return;
    }
    catch (UpsightException paramT)
    {
      mChildSubscriber.onError(paramT);
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.storable.OperatorSerialize.DeserializeSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */