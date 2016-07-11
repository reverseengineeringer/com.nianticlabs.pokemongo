package com.upsight.android.googleadvertisingid.internal;

import com.upsight.android.UpsightContext;
import com.upsight.android.logger.UpsightLogger;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public final class GoogleAdvertisingProviderModule
{
  private final UpsightContext mUpsight;
  
  public GoogleAdvertisingProviderModule(UpsightContext paramUpsightContext)
  {
    mUpsight = paramUpsightContext;
  }
  
  @Provides
  @Singleton
  public GooglePlayAdvertisingProvider provideGooglePlayAdvertisingProvider()
  {
    UpsightLogger localUpsightLogger = mUpsight.getLogger();
    return new GooglePlayAdvertisingProvider(mUpsight, localUpsightLogger);
  }
  
  @Provides
  @Singleton
  UpsightContext provideUpsightContext()
  {
    return mUpsight;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.googleadvertisingid.internal.GoogleAdvertisingProviderModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */