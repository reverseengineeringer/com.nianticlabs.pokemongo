package com.fasterxml.jackson.databind.ser.std;

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
public class StdArraySerializers$IntArraySerializer
  extends ArraySerializerBase<int[]>
{
  private static final JavaType VALUE_TYPE = TypeFactory.defaultInstance().uncheckedSimpleType(Integer.TYPE);
  
  public StdArraySerializers$IntArraySerializer()
  {
    super(int[].class);
  }
  
  protected StdArraySerializers$IntArraySerializer(IntArraySerializer paramIntArraySerializer, BeanProperty paramBeanProperty, Boolean paramBoolean)
  {
    super(paramIntArraySerializer, paramBeanProperty, paramBoolean);
  }
  
  public JsonSerializer<?> _withResolved(BeanProperty paramBeanProperty, Boolean paramBoolean)
  {
    return new IntArraySerializer(this, paramBeanProperty, paramBoolean);
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
  
  public boolean hasSingleElement(int[] paramArrayOfInt)
  {
    return paramArrayOfInt.length == 1;
  }
  
  public boolean isEmpty(SerializerProvider paramSerializerProvider, int[] paramArrayOfInt)
  {
    return (paramArrayOfInt == null) || (paramArrayOfInt.length == 0);
  }
  
  public final void serialize(int[] paramArrayOfInt, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    int i = paramArrayOfInt.length;
    if ((i == 1) && (((_unwrapSingle == null) && (paramSerializerProvider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED))) || (_unwrapSingle == Boolean.TRUE)))
    {
      serializeContents(paramArrayOfInt, paramJsonGenerator, paramSerializerProvider);
      return;
    }
    paramJsonGenerator.writeStartArray(i);
    serializeContents(paramArrayOfInt, paramJsonGenerator, paramSerializerProvider);
    paramJsonGenerator.writeEndArray();
  }
  
  public void serializeContents(int[] paramArrayOfInt, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    int i = 0;
    int j = paramArrayOfInt.length;
    while (i < j)
    {
      paramJsonGenerator.writeNumber(paramArrayOfInt[i]);
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.std.StdArraySerializers.IntArraySerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */