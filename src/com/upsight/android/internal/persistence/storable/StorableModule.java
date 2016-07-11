package com.upsight.android.internal.persistence.storable;

import com.fasterxml.jackson.databind.ObjectMapper;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public final class StorableModule
{
  @Provides
  @Singleton
  public StorableInfoCache provideStorableInfoCache(ObjectMapper paramObjectMapper)
  {
    return new StorableInfoCache(paramObjectMapper);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.storable.StorableModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */