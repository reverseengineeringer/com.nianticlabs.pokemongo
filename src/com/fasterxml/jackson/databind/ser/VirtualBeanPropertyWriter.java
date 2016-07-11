package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.fasterxml.jackson.databind.util.Annotations;
import java.io.Serializable;
import java.lang.reflect.Type;

public abstract class VirtualBeanPropertyWriter
  extends BeanPropertyWriter
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  
  protected VirtualBeanPropertyWriter() {}
  
  protected VirtualBeanPropertyWriter(BeanPropertyDefinition paramBeanPropertyDefinition, Annotations paramAnnotations, JavaType paramJavaType)
  {
    this(paramBeanPropertyDefinition, paramAnnotations, paramJavaType, null, null, null, paramBeanPropertyDefinition.findInclusion());
  }
  
  protected VirtualBeanPropertyWriter(BeanPropertyDefinition paramBeanPropertyDefinition, Annotations paramAnnotations, JavaType paramJavaType1, JsonSerializer<?> paramJsonSerializer, TypeSerializer paramTypeSerializer, JavaType paramJavaType2, JsonInclude.Include paramInclude)
  {
    super(paramBeanPropertyDefinition, paramBeanPropertyDefinition.getPrimaryMember(), paramAnnotations, paramJavaType1, paramJsonSerializer, paramTypeSerializer, paramJavaType2, _suppressNulls(paramInclude), _suppressableValue(paramInclude));
  }
  
  protected VirtualBeanPropertyWriter(VirtualBeanPropertyWriter paramVirtualBeanPropertyWriter)
  {
    super(paramVirtualBeanPropertyWriter);
  }
  
  protected VirtualBeanPropertyWriter(VirtualBeanPropertyWriter paramVirtualBeanPropertyWriter, PropertyName paramPropertyName)
  {
    super(paramVirtualBeanPropertyWriter, paramPropertyName);
  }
  
  protected static boolean _suppressNulls(JsonInclude.Include paramInclude)
  {
    return paramInclude != JsonInclude.Include.ALWAYS;
  }
  
  protected static Object _suppressableValue(JsonInclude.Include paramInclude)
  {
    if ((paramInclude == JsonInclude.Include.NON_EMPTY) || (paramInclude == JsonInclude.Include.NON_EMPTY)) {
      return MARKER_FOR_EMPTY;
    }
    return null;
  }
  
  public Type getGenericPropertyType()
  {
    return getPropertyType();
  }
  
  public Class<?> getPropertyType()
  {
    return _declaredType.getRawClass();
  }
  
  public boolean isVirtual()
  {
    return true;
  }
  
  public void serializeAsElement(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws Exception
  {
    Object localObject = value(paramObject, paramJsonGenerator, paramSerializerProvider);
    if (localObject == null) {
      if (_nullSerializer != null) {
        _nullSerializer.serialize(null, paramJsonGenerator, paramSerializerProvider);
      }
    }
    JsonSerializer localJsonSerializer1;
    do
    {
      return;
      paramJsonGenerator.writeNull();
      return;
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
      if (_suppressableValue != null) {
        if (MARKER_FOR_EMPTY == _suppressableValue)
        {
          if (localJsonSerializer1.isEmpty(paramSerializerProvider, localObject)) {
            serializeAsPlaceholder(paramObject, paramJsonGenerator, paramSerializerProvider);
          }
        }
        else if (_suppressableValue.equals(localObject))
        {
          serializeAsPlaceholder(paramObject, paramJsonGenerator, paramSerializerProvider);
          return;
        }
      }
    } while ((localObject == paramObject) && (_handleSelfReference(paramObject, paramJsonGenerator, paramSerializerProvider, localJsonSerializer1)));
    if (_typeSerializer == null)
    {
      localJsonSerializer1.serialize(localObject, paramJsonGenerator, paramSerializerProvider);
      return;
    }
    localJsonSerializer1.serializeWithType(localObject, paramJsonGenerator, paramSerializerProvider, _typeSerializer);
  }
  
  public void serializeAsField(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws Exception
  {
    Object localObject = value(paramObject, paramJsonGenerator, paramSerializerProvider);
    if (localObject == null) {
      if (_nullSerializer != null)
      {
        paramJsonGenerator.writeFieldName(_name);
        _nullSerializer.serialize(null, paramJsonGenerator, paramSerializerProvider);
      }
    }
    JsonSerializer localJsonSerializer1;
    label168:
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
            break label168;
          }
        } while (localJsonSerializer1.isEmpty(paramSerializerProvider, localObject));
      }
      paramJsonGenerator.writeFieldName(_name);
      if (_typeSerializer != null) {
        break;
      }
      localJsonSerializer1.serialize(localObject, paramJsonGenerator, paramSerializerProvider);
      return;
    } while (!_suppressableValue.equals(localObject));
    return;
    localJsonSerializer1.serializeWithType(localObject, paramJsonGenerator, paramSerializerProvider, _typeSerializer);
  }
  
  protected abstract Object value(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws Exception;
  
  public abstract VirtualBeanPropertyWriter withConfig(MapperConfig<?> paramMapperConfig, AnnotatedClass paramAnnotatedClass, BeanPropertyDefinition paramBeanPropertyDefinition, JavaType paramJavaType);
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.VirtualBeanPropertyWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */