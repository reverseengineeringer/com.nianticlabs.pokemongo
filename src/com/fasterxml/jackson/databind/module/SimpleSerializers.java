package com.fasterxml.jackson.databind.module;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.Serializers.Base;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SimpleSerializers
  extends Serializers.Base
  implements Serializable
{
  private static final long serialVersionUID = 8531646511998456779L;
  protected HashMap<ClassKey, JsonSerializer<?>> _classMappings = null;
  protected boolean _hasEnumSerializer = false;
  protected HashMap<ClassKey, JsonSerializer<?>> _interfaceMappings = null;
  
  public SimpleSerializers() {}
  
  public SimpleSerializers(List<JsonSerializer<?>> paramList)
  {
    addSerializers(paramList);
  }
  
  protected void _addSerializer(Class<?> paramClass, JsonSerializer<?> paramJsonSerializer)
  {
    ClassKey localClassKey = new ClassKey(paramClass);
    if (paramClass.isInterface())
    {
      if (_interfaceMappings == null) {
        _interfaceMappings = new HashMap();
      }
      _interfaceMappings.put(localClassKey, paramJsonSerializer);
    }
    do
    {
      return;
      if (_classMappings == null) {
        _classMappings = new HashMap();
      }
      _classMappings.put(localClassKey, paramJsonSerializer);
    } while (paramClass != Enum.class);
    _hasEnumSerializer = true;
  }
  
  protected JsonSerializer<?> _findInterfaceMapping(Class<?> paramClass, ClassKey paramClassKey)
  {
    Class[] arrayOfClass = paramClass.getInterfaces();
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfClass[i];
      paramClassKey.reset((Class)localObject);
      paramClass = (JsonSerializer)_interfaceMappings.get(paramClassKey);
      if (paramClass != null) {}
      do
      {
        return paramClass;
        localObject = _findInterfaceMapping((Class)localObject, paramClassKey);
        paramClass = (Class<?>)localObject;
      } while (localObject != null);
      i += 1;
    }
    return null;
  }
  
  public void addSerializer(JsonSerializer<?> paramJsonSerializer)
  {
    Class localClass = paramJsonSerializer.handledType();
    if ((localClass == null) || (localClass == Object.class)) {
      throw new IllegalArgumentException("JsonSerializer of type " + paramJsonSerializer.getClass().getName() + " does not define valid handledType() -- must either register with method that takes type argument " + " or make serializer extend 'com.fasterxml.jackson.databind.ser.std.StdSerializer'");
    }
    _addSerializer(localClass, paramJsonSerializer);
  }
  
  public <T> void addSerializer(Class<? extends T> paramClass, JsonSerializer<T> paramJsonSerializer)
  {
    _addSerializer(paramClass, paramJsonSerializer);
  }
  
  public void addSerializers(List<JsonSerializer<?>> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      addSerializer((JsonSerializer)paramList.next());
    }
  }
  
  public JsonSerializer<?> findArraySerializer(SerializationConfig paramSerializationConfig, ArrayType paramArrayType, BeanDescription paramBeanDescription, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer)
  {
    return findSerializer(paramSerializationConfig, paramArrayType, paramBeanDescription);
  }
  
  public JsonSerializer<?> findCollectionLikeSerializer(SerializationConfig paramSerializationConfig, CollectionLikeType paramCollectionLikeType, BeanDescription paramBeanDescription, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer)
  {
    return findSerializer(paramSerializationConfig, paramCollectionLikeType, paramBeanDescription);
  }
  
  public JsonSerializer<?> findCollectionSerializer(SerializationConfig paramSerializationConfig, CollectionType paramCollectionType, BeanDescription paramBeanDescription, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer)
  {
    return findSerializer(paramSerializationConfig, paramCollectionType, paramBeanDescription);
  }
  
  public JsonSerializer<?> findMapLikeSerializer(SerializationConfig paramSerializationConfig, MapLikeType paramMapLikeType, BeanDescription paramBeanDescription, JsonSerializer<Object> paramJsonSerializer1, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer2)
  {
    return findSerializer(paramSerializationConfig, paramMapLikeType, paramBeanDescription);
  }
  
  public JsonSerializer<?> findMapSerializer(SerializationConfig paramSerializationConfig, MapType paramMapType, BeanDescription paramBeanDescription, JsonSerializer<Object> paramJsonSerializer1, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer2)
  {
    return findSerializer(paramSerializationConfig, paramMapType, paramBeanDescription);
  }
  
  public JsonSerializer<?> findSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BeanDescription paramBeanDescription)
  {
    paramSerializationConfig = paramJavaType.getRawClass();
    paramBeanDescription = new ClassKey(paramSerializationConfig);
    if (paramSerializationConfig.isInterface())
    {
      if (_interfaceMappings != null)
      {
        paramJavaType = (JsonSerializer)_interfaceMappings.get(paramBeanDescription);
        if (paramJavaType != null) {
          return paramJavaType;
        }
      }
    }
    else if (_classMappings != null)
    {
      JsonSerializer localJsonSerializer = (JsonSerializer)_classMappings.get(paramBeanDescription);
      if (localJsonSerializer != null) {
        return localJsonSerializer;
      }
      if ((_hasEnumSerializer) && (paramJavaType.isEnumType()))
      {
        paramBeanDescription.reset(Enum.class);
        paramJavaType = (JsonSerializer)_classMappings.get(paramBeanDescription);
        if (paramJavaType != null) {
          return paramJavaType;
        }
      }
      for (paramJavaType = paramSerializationConfig; paramJavaType != null; paramJavaType = paramJavaType.getSuperclass())
      {
        paramBeanDescription.reset(paramJavaType);
        localJsonSerializer = (JsonSerializer)_classMappings.get(paramBeanDescription);
        if (localJsonSerializer != null) {
          return localJsonSerializer;
        }
      }
    }
    if (_interfaceMappings != null)
    {
      paramJavaType = _findInterfaceMapping(paramSerializationConfig, paramBeanDescription);
      if (paramJavaType != null) {
        return paramJavaType;
      }
      if (!paramSerializationConfig.isInterface())
      {
        do
        {
          paramSerializationConfig = paramSerializationConfig.getSuperclass();
          if (paramSerializationConfig == null) {
            break;
          }
          paramJavaType = _findInterfaceMapping(paramSerializationConfig, paramBeanDescription);
        } while (paramJavaType == null);
        return paramJavaType;
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.module.SimpleSerializers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */