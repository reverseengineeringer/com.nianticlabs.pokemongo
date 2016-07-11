package com.upsight.android.persistence;

import com.upsight.android.UpsightException;

public abstract interface UpsightDataStoreListener<T>
{
  public abstract void onFailure(UpsightException paramUpsightException);
  
  public abstract void onSuccess(T paramT);
}

/* Location:
 * Qualified Name:     com.upsight.android.persistence.UpsightDataStoreListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */