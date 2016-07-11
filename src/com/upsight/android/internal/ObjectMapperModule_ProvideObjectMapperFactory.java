package com.upsight.android.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import dagger.internal.Factory;

public final class ObjectMapperModule_ProvideObjectMapperFactory
  implements Factory<ObjectMapper>
{
  private final ObjectMapperModule module;
  
  static
  {
    if (!ObjectMapperModule_ProvideObjectMapperFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ObjectMapperModule_ProvideObjectMapperFactory(ObjectMapperModule paramObjectMapperModule)
  {
    assert (paramObjectMapperModule != null);
    module = paramObjectMapperModule;
  }
  
  public static Factory<ObjectMapper> create(ObjectMapperModule paramObjectMapperModule)
  {
    return new ObjectMapperModule_ProvideObjectMapperFactory(paramObjectMapperModule);
  }
  
  public ObjectMapper get()
  {
    ObjectMapper localObjectMapper = module.provideObjectMapper();
    if (localObjectMapper == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localObjectMapper;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.ObjectMapperModule_ProvideObjectMapperFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */