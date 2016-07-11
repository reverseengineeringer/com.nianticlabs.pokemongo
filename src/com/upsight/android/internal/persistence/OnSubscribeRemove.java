package com.upsight.android.internal.persistence;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class OnSubscribeRemove
  implements Observable.OnSubscribe<Storable>
{
  private final Context mContext;
  private final Storable mStorable;
  
  OnSubscribeRemove(Context paramContext, Storable paramStorable)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Provided Context can not be null.");
    }
    if (paramStorable == null) {
      throw new IllegalArgumentException("Provided UpsightStorable can not be null.");
    }
    mContext = paramContext;
    mStorable = paramStorable;
  }
  
  public void call(Subscriber<? super Storable> paramSubscriber)
  {
    Uri localUri = Uri.withAppendedPath(Content.getContentTypeUri(mContext, mStorable.getType()), mStorable.getID());
    if (mContext.getContentResolver().delete(localUri, null, null) > 0)
    {
      paramSubscriber.onNext(mStorable);
      paramSubscriber.onCompleted();
      return;
    }
    paramSubscriber.onError(new IllegalStateException("Object could not be removed. Already removed?"));
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.OnSubscribeRemove
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */