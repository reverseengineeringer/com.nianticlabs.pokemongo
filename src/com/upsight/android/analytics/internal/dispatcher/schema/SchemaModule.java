package com.upsight.android.analytics.internal.dispatcher.schema;

import com.upsight.android.UpsightContext;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public final class SchemaModule
{
  @Provides
  @Singleton
  public SchemaSelectorBuilder provideSchemaSelectorBuilder(UpsightContext paramUpsightContext)
  {
    return new SchemaSelectorBuilder(paramUpsightContext);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.schema.SchemaModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */