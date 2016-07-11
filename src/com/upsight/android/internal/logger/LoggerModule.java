package com.upsight.android.internal.logger;

import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.persistence.UpsightDataStore;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public final class LoggerModule
{
  @Provides
  @Singleton
  UpsightLogger provideUpsightLogger(UpsightDataStore paramUpsightDataStore, LogWriter paramLogWriter)
  {
    return Logger.create(paramUpsightDataStore, paramLogWriter);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.logger.LoggerModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */