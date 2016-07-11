package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;

@JacksonStdImpl
public class NumberDeserializers$FloatDeserializer
  extends NumberDeserializers.PrimitiveOrWrapperDeserializer<Float>
{
  static final FloatDeserializer primitiveInstance = new FloatDeserializer(Float.TYPE, Float.valueOf(0.0F));
  private static final long serialVersionUID = 1L;
  static final FloatDeserializer wrapperInstance = new FloatDeserializer(Float.class, null);
  
  public NumberDeserializers$FloatDeserializer(Class<Float> paramClass, Float paramFloat)
  {
    super(paramClass, paramFloat);
  }
  
  public Float deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    return _parseFloat(paramJsonParser, paramDeserializationContext);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.NumberDeserializers.FloatDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */