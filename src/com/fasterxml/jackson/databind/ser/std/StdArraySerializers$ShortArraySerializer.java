package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.IOException;
import java.lang.reflect.Type;

@JacksonStdImpl
public class StdArraySerializers$ShortArraySerializer
  extends StdArraySerializers.TypedPrimitiveArraySerializer<short[]>
{
  private static final JavaType VALUE_TYPE = TypeFactory.defaultInstance().uncheckedSimpleType(Short.TYPE);
  
  public StdArraySerializers$ShortArraySerializer()
  {
    super(short[].class);
  }
  
  public StdArraySerializers$ShortArraySerializer(ShortArraySerializer paramShortArraySerializer, BeanProperty paramBeanProperty, TypeSerializer paramTypeSerializer, Boolean paramBoolean)
  {
    super(paramShortArraySerializer, paramBeanProperty, paramTypeSerializer, paramBoolean);
  }
  
  public JsonSerializer<?> _withResolved(BeanProperty paramBeanProperty, Boolean paramBoolean)
  {
    return new ShortArraySerializer(this, paramBeanProperty, _valueTypeSerializer, paramBoolean);
  }
  
  public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer paramTypeSerializer)
  {
    return new ShortArraySerializer(this, _property, paramTypeSerializer, _unwrapSingle);
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper paramJsonFormatVisitorWrapper, JavaType paramJavaType)
    throws JsonMappingException
  {
    if (paramJsonFormatVisitorWrapper != null)
    {
      paramJsonFormatVisitorWrapper = paramJsonFormatVisitorWrapper.expectArrayFormat(paramJavaType);
      if (paramJsonFormatVisitorWrapper != null) {
        paramJsonFormatVisitorWrapper.itemsFormat(JsonFormatTypes.INTEGER);
      }
    }
  }
  
  public JsonSerializer<?> getContentSerializer()
  {
    return null;
  }
  
  public JavaType getContentType()
  {
    return VALUE_TYPE;
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
  {
    return createSchemaNode("array", true).set("items", createSchemaNode("integer"));
  }
  
  public boolean hasSingleElement(short[] paramArrayOfShort)
  {
    return paramArrayOfShort.length == 1;
  }
  
  public boolean isEmpty(SerializerProvider paramSerializerProvider, short[] paramArrayOfShort)
  {
    return (paramArrayOfShort == null) || (paramArrayOfShort.length == 0);
  }
  
  public final void serialize(short[] paramArrayOfShort, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    int i = paramArrayOfShort.length;
    if ((i == 1) && (((_unwrapSingle == null) && (paramSerializerProvider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED))) || (_unwrapSingle == Boolean.TRUE)))
    {
      serializeContents(paramArrayOfShort, paramJsonGenerator, paramSerializerProvider);
      return;
    }
    paramJsonGenerator.writeStartArray(i);
    serializeContents(paramArrayOfShort, paramJsonGenerator, paramSerializerProvider);
    paramJsonGenerator.writeEndArray();
  }
  
  public void serializeContents(short[] paramArrayOfShort, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonGenerationException
  {
    if (_valueTypeSerializer != null)
    {
      i = 0;
      j = paramArrayOfShort.length;
      while (i < j)
      {
        _valueTypeSerializer.writeTypePrefixForScalar(null, paramJsonGenerator, Short.TYPE);
        paramJsonGenerator.writeNumber(paramArrayOfShort[i]);
        _valueTypeSerializer.writeTypeSuffixForScalar(null, paramJsonGenerator);
        i += 1;
      }
    }
    int i = 0;
    int j = paramArrayOfShort.length;
    while (i < j)
    {
      paramJsonGenerator.writeNumber(paramArrayOfShort[i]);
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.std.StdArraySerializers.ShortArraySerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */