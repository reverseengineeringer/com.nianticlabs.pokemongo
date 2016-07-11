package com.upsight.android.internal.persistence;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.upsight.android.UpsightException;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class OnSubscribeFetchById
  implements Observable.OnSubscribe<Storable>
{
  private final Context mContext;
  private final String[] mIds;
  private final String mType;
  
  OnSubscribeFetchById(Context paramContext, String paramString, String... paramVarArgs)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Provided Context can not be null.");
    }
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("Provided type can not be empty or null.");
    }
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      throw new IllegalArgumentException("Object identifiers can not be null or empty.");
    }
    mContext = paramContext;
    mType = paramString;
    mIds = paramVarArgs;
  }
  
  public void call(Subscriber<? super Storable> paramSubscriber)
  {
    Object localObject3 = new StringBuffer();
    ((StringBuffer)localObject3).append("_id").append(" IN (");
    int i = 0;
    while (i < mIds.length)
    {
      ((StringBuffer)localObject3).append("?");
      if (i < mIds.length - 1) {
        ((StringBuffer)localObject3).append(",");
      }
      i += 1;
    }
    ((StringBuffer)localObject3).append(")");
    localObject2 = null;
    localObject1 = null;
    do
    {
      try
      {
        localObject3 = mContext.getContentResolver().query(Content.getContentUri(mContext), null, ((StringBuffer)localObject3).toString(), mIds, null);
        if (localObject3 == null)
        {
          localObject1 = localObject3;
          localObject2 = localObject3;
          paramSubscriber.onError(new UpsightException("Unable to retrieve stored objects.", new Object[0]));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        do
        {
          localObject2 = localObject1;
          paramSubscriber.onError(localThrowable);
          return;
          localObject1 = localThrowable;
          localObject2 = localThrowable;
          paramSubscriber.onCompleted();
        } while (localThrowable == null);
        localThrowable.close();
        return;
      }
      finally
      {
        if (localObject2 == null) {
          break label352;
        }
        ((Cursor)localObject2).close();
      }
      localObject1 = localObject3;
      localObject2 = localObject3;
      if (((Cursor)localObject3).getCount() == mIds.length) {
        break;
      }
      localObject1 = localObject3;
      localObject2 = localObject3;
      paramSubscriber.onError(new UpsightException("Unable to retrieve stored objects. Some ID(s) were not found.", new Object[0]));
    } while (localObject3 == null);
    ((Cursor)localObject3).close();
    return;
    for (;;)
    {
      localObject1 = localObject3;
      localObject2 = localObject3;
      if (!((Cursor)localObject3).moveToNext()) {
        break;
      }
      localObject1 = localObject3;
      localObject2 = localObject3;
      paramSubscriber.onNext(Storable.create(((Cursor)localObject3).getString(((Cursor)localObject3).getColumnIndex("_id")), ((Cursor)localObject3).getString(((Cursor)localObject3).getColumnIndex("type")), ((Cursor)localObject3).getString(((Cursor)localObject3).getColumnIndex("data"))));
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.OnSubscribeFetchById
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */