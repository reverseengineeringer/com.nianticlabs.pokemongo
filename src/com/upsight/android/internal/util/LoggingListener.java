package com.upsight.android.internal.util;

import android.util.Log;
import com.upsight.android.UpsightException;
import com.upsight.android.persistence.UpsightDataStoreListener;

public final class LoggingListener<T>
  implements UpsightDataStoreListener<T>
{
  public void onFailure(UpsightException paramUpsightException)
  {
    Log.e("Upsight", "Uncaught Exception within Upsight SDK.", paramUpsightException);
  }
  
  public void onSuccess(T paramT) {}
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.util.LoggingListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */