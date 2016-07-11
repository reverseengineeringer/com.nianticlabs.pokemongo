package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;

@JacksonStdImpl
public final class NumberDeserializers$BooleanDeserializer
  extends NumberDeserializers.PrimitiveOrWrapperDeserializer<Boolean>
{
  static final BooleanDeserializer primitiveInstance = new BooleanDeserializer(Boolean.TYPE, Boolean.FALSE);
  private static final long serialVersionUID = 1L;
  static final BooleanDeserializer wrapperInstance = new BooleanDeserializer(Boolean.class, null);
  
  public NumberDeserializers$BooleanDeserializer(Class<Boolean> paramClass, Boolean paramBoolean)
  {
    super(paramClass, paramBoolean);
  }
  
  public Boolean deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    return _parseBoolean(paramJsonParser, paramDeserializationContext);
  }
  
  public Boolean deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
    throws IOException
  {
    return _parseBoolean(paramJsonParser, paramDeserializationContext);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.NumberDeserializers.BooleanDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */