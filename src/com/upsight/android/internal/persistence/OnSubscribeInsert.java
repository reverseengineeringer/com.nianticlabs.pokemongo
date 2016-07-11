package com.upsight.android.internal.persistence;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class OnSubscribeInsert
  implements Observable.OnSubscribe<Storable>
{
  private final Context mContext;
  private final Storable mStorable;
  
  OnSubscribeInsert(Context paramContext, Storable paramStorable)
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
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("_id", mStorable.getID());
    localContentValues.put("type", mStorable.getType());
    localContentValues.put("data", mStorable.getValue());
    Uri localUri = Uri.withAppendedPath(Content.getContentUri(mContext), mStorable.getType());
    if (mContext.getContentResolver().insert(localUri, localContentValues) == null) {
      throw new IllegalStateException("Unable to persist model!");
    }
    paramSubscriber.onNext(mStorable);
    paramSubscriber.onCompleted();
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.OnSubscribeInsert
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */