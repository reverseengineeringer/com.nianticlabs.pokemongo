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
public class StdArraySerializers$FloatArraySerializer
  extends StdArraySerializers.TypedPrimitiveArraySerializer<float[]>
{
  private static final JavaType VALUE_TYPE = TypeFactory.defaultInstance().uncheckedSimpleType(Float.TYPE);
  
  public StdArraySerializers$FloatArraySerializer()
  {
    super(float[].class);
  }
  
  public StdArraySerializers$FloatArraySerializer(FloatArraySerializer paramFloatArraySerializer, BeanProperty paramBeanProperty, TypeSerializer paramTypeSerializer, Boolean paramBoolean)
  {
    super(paramFloatArraySerializer, paramBeanProperty, paramTypeSerializer, paramBoolean);
  }
  
  public JsonSerializer<?> _withResolved(BeanProperty paramBeanProperty, Boolean paramBoolean)
  {
    return new FloatArraySerializer(this, paramBeanProperty, _valueTypeSerializer, paramBoolean);
  }
  
  public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer paramTypeSerializer)
  {
    return new FloatArraySerializer(this, _property, paramTypeSerializer, _unwrapSingle);
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper paramJsonFormatVisitorWrapper, JavaType paramJavaType)
    throws JsonMappingException
  {
    if (paramJsonFormatVisitorWrapper != null)
    {
      paramJsonFormatVisitorWrapper = paramJsonFormatVisitorWrapper.expectArrayFormat(paramJavaType);
      if (paramJsonFormatVisitorWrapper != null) {
        paramJsonFormatVisitorWrapper.itemsFormat(JsonFormatTypes.NUMBER);
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
    return createSchemaNode("array", true).set("items", createSchemaNode("number"));
  }
  
  public boolean hasSingleElement(float[] paramArrayOfFloat)
  {
    return paramArrayOfFloat.length == 1;
  }
  
  public boolean isEmpty(SerializerProvider paramSerializerProvider, float[] paramArrayOfFloat)
  {
    return (paramArrayOfFloat == null) || (paramArrayOfFloat.length == 0);
  }
  
  public final void serialize(float[] paramArrayOfFloat, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    int i = paramArrayOfFloat.length;
    if ((i == 1) && (((_unwrapSingle == null) && (paramSerializerProvider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED))) || (_unwrapSingle == Boolean.TRUE)))
    {
      serializeContents(paramArrayOfFloat, paramJsonGenerator, paramSerializerProvider);
      return;
    }
    paramJsonGenerator.writeStartArray(i);
    serializeContents(paramArrayOfFloat, paramJsonGenerator, paramSerializerProvider);
    paramJsonGenerator.writeEndArray();
  }
  
  public void serializeContents(float[] paramArrayOfFloat, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonGenerationException
  {
    if (_valueTypeSerializer != null)
    {
      i = 0;
      j = paramArrayOfFloat.length;
      while (i < j)
      {
        _valueTypeSerializer.writeTypePrefixForScalar(null, paramJsonGenerator, Float.TYPE);
        paramJsonGenerator.writeNumber(paramArrayOfFloat[i]);
        _valueTypeSerializer.writeTypeSuffixForScalar(null, paramJsonGenerator);
        i += 1;
      }
    }
    int i = 0;
    int j = paramArrayOfFloat.length;
    while (i < j)
    {
      paramJsonGenerator.writeNumber(paramArrayOfFloat[i]);
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.std.StdArraySerializers.FloatArraySerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */