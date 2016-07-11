package com.upsight.android.internal.logger;

import com.upsight.android.UpsightException;
import com.upsight.android.persistence.UpsightDataStore;
import com.upsight.android.persistence.UpsightDataStoreListener;

class Logger$1
  implements UpsightDataStoreListener<LogMessage>
{
  Logger$1(Logger paramLogger) {}
  
  public void onFailure(UpsightException paramUpsightException) {}
  
  public void onSuccess(LogMessage paramLogMessage)
  {
    Logger.access$000(this$0).remove(paramLogMessage);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.logger.Logger.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */