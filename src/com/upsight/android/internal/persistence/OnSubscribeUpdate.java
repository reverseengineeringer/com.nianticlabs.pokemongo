package com.upsight.android.internal.persistence;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.upsight.android.UpsightException;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class OnSubscribeUpdate
  implements Observable.OnSubscribe<Storable>
{
  private final Context mContext;
  private final Storable mStorable;
  
  OnSubscribeUpdate(Context paramContext, Storable paramStorable)
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
    localContentValues.put("data", mStorable.getValue());
    Uri localUri = Uri.withAppendedPath(Content.getContentTypeUri(mContext, mStorable.getType()), mStorable.getID());
    if (mContext.getContentResolver().update(localUri, localContentValues, null, null) > 0)
    {
      paramSubscriber.onNext(mStorable);
      paramSubscriber.onCompleted();
      return;
    }
    paramSubscriber.onError(new UpsightException("Update failed. Storable exists?", new Object[0]));
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.OnSubscribeUpdate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */