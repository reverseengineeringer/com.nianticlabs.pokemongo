package com.upsight.android.analytics.internal.dispatcher.schema;

import com.upsight.android.UpsightContext;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class SchemaModule_ProvideSchemaSelectorBuilderFactory
  implements Factory<SchemaSelectorBuilder>
{
  private final SchemaModule module;
  private final Provider<UpsightContext> upsightProvider;
  
  static
  {
    if (!SchemaModule_ProvideSchemaSelectorBuilderFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public SchemaModule_ProvideSchemaSelectorBuilderFactory(SchemaModule paramSchemaModule, Provider<UpsightContext> paramProvider)
  {
    assert (paramSchemaModule != null);
    module = paramSchemaModule;
    assert (paramProvider != null);
    upsightProvider = paramProvider;
  }
  
  public static Factory<SchemaSelectorBuilder> create(SchemaModule paramSchemaModule, Provider<UpsightContext> paramProvider)
  {
    return new SchemaModule_ProvideSchemaSelectorBuilderFactory(paramSchemaModule, paramProvider);
  }
  
  public SchemaSelectorBuilder get()
  {
    SchemaSelectorBuilder localSchemaSelectorBuilder = module.provideSchemaSelectorBuilder((UpsightContext)upsightProvider.get());
    if (localSchemaSelectorBuilder == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localSchemaSelectorBuilder;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.schema.SchemaModule_ProvideSchemaSelectorBuilderFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */