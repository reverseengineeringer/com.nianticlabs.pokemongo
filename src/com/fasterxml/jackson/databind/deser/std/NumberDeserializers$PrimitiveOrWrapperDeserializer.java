package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;

public abstract class NumberDeserializers$PrimitiveOrWrapperDeserializer<T>
  extends StdScalarDeserializer<T>
{
  private static final long serialVersionUID = 1L;
  protected final T _nullValue;
  protected final boolean _primitive;
  
  protected NumberDeserializers$PrimitiveOrWrapperDeserializer(Class<T> paramClass, T paramT)
  {
    super(paramClass);
    _nullValue = paramT;
    _primitive = paramClass.isPrimitive();
  }
  
  @Deprecated
  public final T getNullValue()
  {
    return (T)_nullValue;
  }
  
  public final T getNullValue(DeserializationContext paramDeserializationContext)
    throws JsonMappingException
  {
    if ((_primitive) && (paramDeserializationContext.isEnabled(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES))) {
      throw paramDeserializationContext.mappingException("Can not map JSON null into type %s (set DeserializationConfig.DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES to 'false' to allow)", new Object[] { handledType().toString() });
    }
    return (T)_nullValue;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */