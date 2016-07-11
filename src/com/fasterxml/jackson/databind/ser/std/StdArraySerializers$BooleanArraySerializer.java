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
public class StdArraySerializers$BooleanArraySerializer
  extends ArraySerializerBase<boolean[]>
{
  private static final JavaType VALUE_TYPE = TypeFactory.defaultInstance().uncheckedSimpleType(Boolean.class);
  
  public StdArraySerializers$BooleanArraySerializer()
  {
    super(boolean[].class);
  }
  
  protected StdArraySerializers$BooleanArraySerializer(BooleanArraySerializer paramBooleanArraySerializer, BeanProperty paramBeanProperty, Boolean paramBoolean)
  {
    super(paramBooleanArraySerializer, paramBeanProperty, paramBoolean);
  }
  
  public JsonSerializer<?> _withResolved(BeanProperty paramBeanProperty, Boolean paramBoolean)
  {
    return new BooleanArraySerializer(this, paramBeanProperty, paramBoolean);
  }
  
  public ContainerSerializer<?> _withValueTypeSerializer(TypeSerializer paramTypeSerializer)
  {
    return this;
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper paramJsonFormatVisitorWrapper, JavaType paramJavaType)
    throws JsonMappingException
  {
    if (paramJsonFormatVisitorWrapper != null)
    {
      paramJsonFormatVisitorWrapper = paramJsonFormatVisitorWrapper.expectArrayFormat(paramJavaType);
      if (paramJsonFormatVisitorWrapper != null) {
        paramJsonFormatVisitorWrapper.itemsFormat(JsonFormatTypes.BOOLEAN);
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
    paramSerializerProvider = createSchemaNode("array", true);
    paramSerializerProvider.set("items", createSchemaNode("boolean"));
    return paramSerializerProvider;
  }
  
  public boolean hasSingleElement(boolean[] paramArrayOfBoolean)
  {
    return paramArrayOfBoolean.length == 1;
  }
  
  public boolean isEmpty(SerializerProvider paramSerializerProvider, boolean[] paramArrayOfBoolean)
  {
    return (paramArrayOfBoolean == null) || (paramArrayOfBoolean.length == 0);
  }
  
  public final void serialize(boolean[] paramArrayOfBoolean, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    int i = paramArrayOfBoolean.length;
    if ((i == 1) && (((_unwrapSingle == null) && (paramSerializerProvider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED))) || (_unwrapSingle == Boolean.TRUE)))
    {
      serializeContents(paramArrayOfBoolean, paramJsonGenerator, paramSerializerProvider);
      return;
    }
    paramJsonGenerator.writeStartArray(i);
    serializeContents(paramArrayOfBoolean, paramJsonGenerator, paramSerializerProvider);
    paramJsonGenerator.writeEndArray();
  }
  
  public void serializeContents(boolean[] paramArrayOfBoolean, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonGenerationException
  {
    int i = 0;
    int j = paramArrayOfBoolean.length;
    while (i < j)
    {
      paramJsonGenerator.writeBoolean(paramArrayOfBoolean[i]);
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.std.StdArraySerializers.BooleanArraySerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */