package com.upsight.android.internal.persistence;

import android.content.Context;
import rx.Observable;

final class ContentObservables
{
  public static Observable<Storable> fetch(Context paramContext, String paramString)
  {
    return Observable.create(new OnSubscribeFetchByType(paramContext, paramString)).onBackpressureBuffer();
  }
  
  public static Observable<Storable> fetch(Context paramContext, String paramString, String[] paramArrayOfString)
  {
    return Observable.create(new OnSubscribeFetchById(paramContext, paramString, paramArrayOfString)).onBackpressureBuffer();
  }
  
  public static Observable<Storable> insert(Context paramContext, Storable paramStorable)
  {
    return Observable.create(new OnSubscribeInsert(paramContext, paramStorable));
  }
  
  public static Observable<Storable> remove(Context paramContext, Storable paramStorable)
  {
    return Observable.create(new OnSubscribeRemove(paramContext, paramStorable));
  }
  
  public static Observable<Storable> update(Context paramContext, Storable paramStorable)
  {
    return Observable.create(new OnSubscribeUpdate(paramContext, paramStorable));
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.ContentObservables
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */