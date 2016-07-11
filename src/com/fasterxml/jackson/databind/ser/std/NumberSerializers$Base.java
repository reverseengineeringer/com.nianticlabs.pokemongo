package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonIntegerFormatVisitor;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonNumberFormatVisitor;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import java.lang.reflect.Type;

public abstract class NumberSerializers$Base<T>
  extends StdScalarSerializer<T>
  implements ContextualSerializer
{
  protected static final Integer EMPTY_INTEGER = Integer.valueOf(0);
  protected final boolean _isInt;
  protected final JsonParser.NumberType _numberType;
  protected final String _schemaType;
  
  protected NumberSerializers$Base(Class<?> paramClass, JsonParser.NumberType paramNumberType, String paramString)
  {
    super(paramClass, false);
    _numberType = paramNumberType;
    _schemaType = paramString;
    if ((paramNumberType == JsonParser.NumberType.INT) || (paramNumberType == JsonParser.NumberType.LONG) || (paramNumberType == JsonParser.NumberType.BIG_INTEGER)) {
      bool = true;
    }
    _isInt = bool;
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper paramJsonFormatVisitorWrapper, JavaType paramJavaType)
    throws JsonMappingException
  {
    if (_isInt)
    {
      paramJsonFormatVisitorWrapper = paramJsonFormatVisitorWrapper.expectIntegerFormat(paramJavaType);
      if (paramJsonFormatVisitorWrapper != null) {
        paramJsonFormatVisitorWrapper.numberType(_numberType);
      }
    }
    do
    {
      return;
      paramJsonFormatVisitorWrapper = paramJsonFormatVisitorWrapper.expectNumberFormat(paramJavaType);
    } while (paramJsonFormatVisitorWrapper == null);
    paramJsonFormatVisitorWrapper.numberType(_numberType);
  }
  
  public JsonSerializer<?> createContextual(SerializerProvider paramSerializerProvider, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    if (paramBeanProperty != null)
    {
      paramBeanProperty = paramBeanProperty.getMember();
      if (paramBeanProperty != null)
      {
        paramSerializerProvider = paramSerializerProvider.getAnnotationIntrospector().findFormat(paramBeanProperty);
        if (paramSerializerProvider == null) {}
      }
    }
    switch (NumberSerializers.1.$SwitchMap$com$fasterxml$jackson$annotation$JsonFormat$Shape[paramSerializerProvider.getShape().ordinal()])
    {
    default: 
      return this;
    }
    return ToStringSerializer.instance;
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
  {
    return createSchemaNode(_schemaType, true);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.std.NumberSerializers.Base
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */