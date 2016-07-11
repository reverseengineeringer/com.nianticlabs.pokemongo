package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.InjectableValues;

public final class DefaultDeserializationContext$Impl
  extends DefaultDeserializationContext
{
  private static final long serialVersionUID = 1L;
  
  protected DefaultDeserializationContext$Impl(Impl paramImpl)
  {
    super(paramImpl);
  }
  
  protected DefaultDeserializationContext$Impl(Impl paramImpl, DeserializationConfig paramDeserializationConfig, JsonParser paramJsonParser, InjectableValues paramInjectableValues)
  {
    super(paramImpl, paramDeserializationConfig, paramJsonParser, paramInjectableValues);
  }
  
  protected DefaultDeserializationContext$Impl(Impl paramImpl, DeserializerFactory paramDeserializerFactory)
  {
    super(paramImpl, paramDeserializerFactory);
  }
  
  public DefaultDeserializationContext$Impl(DeserializerFactory paramDeserializerFactory)
  {
    super(paramDeserializerFactory, null);
  }
  
  public DefaultDeserializationContext copy()
  {
    if (getClass() != Impl.class) {
      return super.copy();
    }
    return new Impl(this);
  }
  
  public DefaultDeserializationContext createInstance(DeserializationConfig paramDeserializationConfig, JsonParser paramJsonParser, InjectableValues paramInjectableValues)
  {
    return new Impl(this, paramDeserializationConfig, paramJsonParser, paramInjectableValues);
  }
  
  public DefaultDeserializationContext with(DeserializerFactory paramDeserializerFactory)
  {
    return new Impl(this, paramDeserializerFactory);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.Impl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */