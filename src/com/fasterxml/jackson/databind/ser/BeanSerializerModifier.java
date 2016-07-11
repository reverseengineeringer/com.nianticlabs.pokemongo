package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import java.util.List;

public abstract class BeanSerializerModifier
{
  public List<BeanPropertyWriter> changeProperties(SerializationConfig paramSerializationConfig, BeanDescription paramBeanDescription, List<BeanPropertyWriter> paramList)
  {
    return paramList;
  }
  
  public JsonSerializer<?> modifyArraySerializer(SerializationConfig paramSerializationConfig, ArrayType paramArrayType, BeanDescription paramBeanDescription, JsonSerializer<?> paramJsonSerializer)
  {
    return paramJsonSerializer;
  }
  
  public JsonSerializer<?> modifyCollectionLikeSerializer(SerializationConfig paramSerializationConfig, CollectionLikeType paramCollectionLikeType, BeanDescription paramBeanDescription, JsonSerializer<?> paramJsonSerializer)
  {
    return paramJsonSerializer;
  }
  
  public JsonSerializer<?> modifyCollectionSerializer(SerializationConfig paramSerializationConfig, CollectionType paramCollectionType, BeanDescription paramBeanDescription, JsonSerializer<?> paramJsonSerializer)
  {
    return paramJsonSerializer;
  }
  
  public JsonSerializer<?> modifyEnumSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BeanDescription paramBeanDescription, JsonSerializer<?> paramJsonSerializer)
  {
    return paramJsonSerializer;
  }
  
  public JsonSerializer<?> modifyKeySerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BeanDescription paramBeanDescription, JsonSerializer<?> paramJsonSerializer)
  {
    return paramJsonSerializer;
  }
  
  public JsonSerializer<?> modifyMapLikeSerializer(SerializationConfig paramSerializationConfig, MapLikeType paramMapLikeType, BeanDescription paramBeanDescription, JsonSerializer<?> paramJsonSerializer)
  {
    return paramJsonSerializer;
  }
  
  public JsonSerializer<?> modifyMapSerializer(SerializationConfig paramSerializationConfig, MapType paramMapType, BeanDescription paramBeanDescription, JsonSerializer<?> paramJsonSerializer)
  {
    return paramJsonSerializer;
  }
  
  public JsonSerializer<?> modifySerializer(SerializationConfig paramSerializationConfig, BeanDescription paramBeanDescription, JsonSerializer<?> paramJsonSerializer)
  {
    return paramJsonSerializer;
  }
  
  public List<BeanPropertyWriter> orderProperties(SerializationConfig paramSerializationConfig, BeanDescription paramBeanDescription, List<BeanPropertyWriter> paramList)
  {
    return paramList;
  }
  
  public BeanSerializerBuilder updateBuilder(SerializationConfig paramSerializationConfig, BeanDescription paramBeanDescription, BeanSerializerBuilder paramBeanSerializerBuilder)
  {
    return paramBeanSerializerBuilder;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.BeanSerializerModifier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */