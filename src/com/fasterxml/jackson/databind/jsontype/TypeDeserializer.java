package com.fasterxml.jackson.databind.jsontype;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import java.io.IOException;

public abstract class TypeDeserializer
{
  public static Object deserializeIfNatural(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, JavaType paramJavaType)
    throws IOException
  {
    return deserializeIfNatural(paramJsonParser, paramDeserializationContext, paramJavaType.getRawClass());
  }
  
  public static Object deserializeIfNatural(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Class<?> paramClass)
    throws IOException
  {
    paramDeserializationContext = paramJsonParser.getCurrentToken();
    if (paramDeserializationContext == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return null;
              switch (paramDeserializationContext)
              {
              default: 
                return null;
              }
            } while (!paramClass.isAssignableFrom(String.class));
            return paramJsonParser.getText();
          } while (!paramClass.isAssignableFrom(Integer.class));
          return Integer.valueOf(paramJsonParser.getIntValue());
        } while (!paramClass.isAssignableFrom(Double.class));
        return Double.valueOf(paramJsonParser.getDoubleValue());
      } while (!paramClass.isAssignableFrom(Boolean.class));
      return Boolean.TRUE;
    } while (!paramClass.isAssignableFrom(Boolean.class));
    return Boolean.FALSE;
  }
  
  public abstract Object deserializeTypedFromAny(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException;
  
  public abstract Object deserializeTypedFromArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException;
  
  public abstract Object deserializeTypedFromObject(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException;
  
  public abstract Object deserializeTypedFromScalar(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException;
  
  public abstract TypeDeserializer forProperty(BeanProperty paramBeanProperty);
  
  public abstract Class<?> getDefaultImpl();
  
  public abstract String getPropertyName();
  
  public abstract TypeIdResolver getTypeIdResolver();
  
  public abstract JsonTypeInfo.As getTypeInclusion();
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.jsontype.TypeDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */