package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import java.io.Serializable;

@Deprecated
public final class NullProvider
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private final boolean _isPrimitive;
  private final Object _nullValue;
  private final Class<?> _rawType;
  
  public NullProvider(JavaType paramJavaType, Object paramObject)
  {
    _nullValue = paramObject;
    _isPrimitive = paramJavaType.isPrimitive();
    _rawType = paramJavaType.getRawClass();
  }
  
  public Object nullValue(DeserializationContext paramDeserializationContext)
    throws JsonProcessingException
  {
    if ((_isPrimitive) && (paramDeserializationContext.isEnabled(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES))) {
      throw paramDeserializationContext.mappingException("Can not map JSON null into type %s (set DeserializationConfig.DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES to 'false' to allow)", new Object[] { _rawType.getName() });
    }
    return _nullValue;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.impl.NullProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */