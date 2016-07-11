package com.upsight.android.internal.persistence.storable;

import com.upsight.android.UpsightException;
import com.upsight.android.internal.persistence.Storable;
import com.upsight.android.persistence.UpsightStorableSerializer;
import rx.Observable.Operator;
import rx.Subscriber;

class OperatorDeserialize<T>
  implements Observable.Operator<T, Storable>
{
  private final StorableInfo<T> mStorableInfo;
  
  public OperatorDeserialize(StorableInfo<T> paramStorableInfo)
  {
    if (paramStorableInfo == null) {
      throw new IllegalArgumentException("StorableInfo can not be null.");
    }
    mStorableInfo = paramStorableInfo;
  }
  
  public Subscriber<? super Storable> call(Subscriber<? super T> paramSubscriber)
  {
    return new DeserializeSubscriber(mStorableInfo, paramSubscriber);
  }
  
  private static class DeserializeSubscriber<T>
    extends Subscriber<Storable>
  {
    private final Subscriber<? super T> mChildSubscriber;
    private final StorableInfo<T> mStorableInfo;
    
    public DeserializeSubscriber(StorableInfo<T> paramStorableInfo, Subscriber<? super T> paramSubscriber)
    {
      super();
      mStorableInfo = paramStorableInfo;
      mChildSubscriber = paramSubscriber;
    }
    
    public void onCompleted()
    {
      mChildSubscriber.onCompleted();
    }
    
    public void onError(Throwable paramThrowable)
    {
      mChildSubscriber.onError(paramThrowable);
    }
    
    public void onNext(Storable paramStorable)
    {
      Object localObject = mStorableInfo.getDeserializer();
      try
      {
        if (!mChildSubscriber.isUnsubscribed())
        {
          localObject = ((UpsightStorableSerializer)localObject).fromString(paramStorable.getValue());
          mStorableInfo.getIdentifierAccessor().setId(localObject, paramStorable.getID());
          mChildSubscriber.onNext(localObject);
        }
        return;
      }
      catch (UpsightException paramStorable)
      {
        mChildSubscriber.onError(paramStorable);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.storable.OperatorDeserialize
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */