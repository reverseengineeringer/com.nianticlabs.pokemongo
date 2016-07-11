package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper.Base;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map.Entry;

public class UnwrappingBeanPropertyWriter
  extends BeanPropertyWriter
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final NameTransformer _nameTransformer;
  
  public UnwrappingBeanPropertyWriter(BeanPropertyWriter paramBeanPropertyWriter, NameTransformer paramNameTransformer)
  {
    super(paramBeanPropertyWriter);
    _nameTransformer = paramNameTransformer;
  }
  
  protected UnwrappingBeanPropertyWriter(UnwrappingBeanPropertyWriter paramUnwrappingBeanPropertyWriter, NameTransformer paramNameTransformer, SerializedString paramSerializedString)
  {
    super(paramUnwrappingBeanPropertyWriter, paramSerializedString);
    _nameTransformer = paramNameTransformer;
  }
  
  protected void _depositSchemaProperty(ObjectNode paramObjectNode, JsonNode paramJsonNode)
  {
    paramJsonNode = paramJsonNode.get("properties");
    if (paramJsonNode != null)
    {
      Iterator localIterator = paramJsonNode.fields();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str = (String)localEntry.getKey();
        paramJsonNode = str;
        if (_nameTransformer != null) {
          paramJsonNode = _nameTransformer.transform(str);
        }
        paramObjectNode.set(paramJsonNode, (JsonNode)localEntry.getValue());
      }
    }
  }
  
  protected JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap paramPropertySerializerMap, Class<?> paramClass, SerializerProvider paramSerializerProvider)
    throws JsonMappingException
  {
    if (_nonTrivialBaseType != null) {}
    for (paramPropertySerializerMap = paramSerializerProvider.findValueSerializer(paramSerializerProvider.constructSpecializedType(_nonTrivialBaseType, paramClass), this);; paramPropertySerializerMap = paramSerializerProvider.findValueSerializer(paramClass, this))
    {
      NameTransformer localNameTransformer = _nameTransformer;
      paramSerializerProvider = localNameTransformer;
      if (paramPropertySerializerMap.isUnwrappingSerializer()) {
        paramSerializerProvider = NameTransformer.chainedTransformer(localNameTransformer, _nameTransformer);
      }
      paramPropertySerializerMap = paramPropertySerializerMap.unwrappingSerializer(paramSerializerProvider);
      _dynamicSerializers = _dynamicSerializers.newWith(paramClass, paramPropertySerializerMap);
      return paramPropertySerializerMap;
    }
  }
  
  protected UnwrappingBeanPropertyWriter _new(NameTransformer paramNameTransformer, SerializedString paramSerializedString)
  {
    return new UnwrappingBeanPropertyWriter(this, paramNameTransformer, paramSerializedString);
  }
  
  public void assignSerializer(JsonSerializer<Object> paramJsonSerializer)
  {
    super.assignSerializer(paramJsonSerializer);
    if (_serializer != null)
    {
      NameTransformer localNameTransformer = _nameTransformer;
      paramJsonSerializer = localNameTransformer;
      if (_serializer.isUnwrappingSerializer()) {
        paramJsonSerializer = NameTransformer.chainedTransformer(localNameTransformer, _serializer)._nameTransformer);
      }
      _serializer = _serializer.unwrappingSerializer(paramJsonSerializer);
    }
  }
  
  public void depositSchemaProperty(final JsonObjectFormatVisitor paramJsonObjectFormatVisitor)
    throws JsonMappingException
  {
    SerializerProvider localSerializerProvider = paramJsonObjectFormatVisitor.getProvider();
    JsonSerializer localJsonSerializer = localSerializerProvider.findValueSerializer(getType(), this).unwrappingSerializer(_nameTransformer);
    if (localJsonSerializer.isUnwrappingSerializer())
    {
      localJsonSerializer.acceptJsonFormatVisitor(new JsonFormatVisitorWrapper.Base(localSerializerProvider)
      {
        public JsonObjectFormatVisitor expectObjectFormat(JavaType paramAnonymousJavaType)
          throws JsonMappingException
        {
          return paramJsonObjectFormatVisitor;
        }
      }, getType());
      return;
    }
    super.depositSchemaProperty(paramJsonObjectFormatVisitor);
  }
  
  public boolean isUnwrapping()
  {
    return true;
  }
  
  public UnwrappingBeanPropertyWriter rename(NameTransformer paramNameTransformer)
  {
    String str = paramNameTransformer.transform(_name.getValue());
    return _new(NameTransformer.chainedTransformer(paramNameTransformer, _nameTransformer), new SerializedString(str));
  }
  
  public void serializeAsField(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws Exception
  {
    Object localObject = get(paramObject);
    if (localObject == null) {}
    JsonSerializer localJsonSerializer1;
    label149:
    do
    {
      return;
      while ((localObject == paramObject) && (_handleSelfReference(paramObject, paramJsonGenerator, paramSerializerProvider, localJsonSerializer1))) {
        do
        {
          JsonSerializer localJsonSerializer2 = _serializer;
          localJsonSerializer1 = localJsonSerializer2;
          if (localJsonSerializer2 == null)
          {
            Class localClass = localObject.getClass();
            PropertySerializerMap localPropertySerializerMap = _dynamicSerializers;
            localJsonSerializer2 = localPropertySerializerMap.serializerFor(localClass);
            localJsonSerializer1 = localJsonSerializer2;
            if (localJsonSerializer2 == null) {
              localJsonSerializer1 = _findAndAddDynamic(localPropertySerializerMap, localClass, paramSerializerProvider);
            }
          }
          if (_suppressableValue == null) {
            break;
          }
          if (MARKER_FOR_EMPTY != _suppressableValue) {
            break label149;
          }
        } while (localJsonSerializer1.isEmpty(paramSerializerProvider, localObject));
      }
      if (!localJsonSerializer1.isUnwrappingSerializer()) {
        paramJsonGenerator.writeFieldName(_name);
      }
      if (_typeSerializer != null) {
        break;
      }
      localJsonSerializer1.serialize(localObject, paramJsonGenerator, paramSerializerProvider);
      return;
    } while (!_suppressableValue.equals(localObject));
    return;
    localJsonSerializer1.serializeWithType(localObject, paramJsonGenerator, paramSerializerProvider, _typeSerializer);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.impl.UnwrappingBeanPropertyWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */