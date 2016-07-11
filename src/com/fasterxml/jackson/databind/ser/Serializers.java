package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;

public abstract interface Serializers
{
  public abstract JsonSerializer<?> findArraySerializer(SerializationConfig paramSerializationConfig, ArrayType paramArrayType, BeanDescription paramBeanDescription, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer);
  
  public abstract JsonSerializer<?> findCollectionLikeSerializer(SerializationConfig paramSerializationConfig, CollectionLikeType paramCollectionLikeType, BeanDescription paramBeanDescription, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer);
  
  public abstract JsonSerializer<?> findCollectionSerializer(SerializationConfig paramSerializationConfig, CollectionType paramCollectionType, BeanDescription paramBeanDescription, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer);
  
  public abstract JsonSerializer<?> findMapLikeSerializer(SerializationConfig paramSerializationConfig, MapLikeType paramMapLikeType, BeanDescription paramBeanDescription, JsonSerializer<Object> paramJsonSerializer1, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer2);
  
  public abstract JsonSerializer<?> findMapSerializer(SerializationConfig paramSerializationConfig, MapType paramMapType, BeanDescription paramBeanDescription, JsonSerializer<Object> paramJsonSerializer1, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer2);
  
  public abstract JsonSerializer<?> findSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BeanDescription paramBeanDescription);
  
  public static class Base
    implements Serializers
  {
    public JsonSerializer<?> findArraySerializer(SerializationConfig paramSerializationConfig, ArrayType paramArrayType, BeanDescription paramBeanDescription, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer)
    {
      return null;
    }
    
    public JsonSerializer<?> findCollectionLikeSerializer(SerializationConfig paramSerializationConfig, CollectionLikeType paramCollectionLikeType, BeanDescription paramBeanDescription, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer)
    {
      return null;
    }
    
    public JsonSerializer<?> findCollectionSerializer(SerializationConfig paramSerializationConfig, CollectionType paramCollectionType, BeanDescription paramBeanDescription, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer)
    {
      return null;
    }
    
    public JsonSerializer<?> findMapLikeSerializer(SerializationConfig paramSerializationConfig, MapLikeType paramMapLikeType, BeanDescription paramBeanDescription, JsonSerializer<Object> paramJsonSerializer1, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer2)
    {
      return null;
    }
    
    public JsonSerializer<?> findMapSerializer(SerializationConfig paramSerializationConfig, MapType paramMapType, BeanDescription paramBeanDescription, JsonSerializer<Object> paramJsonSerializer1, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer2)
    {
      return null;
    }
    
    public JsonSerializer<?> findSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BeanDescription paramBeanDescription)
    {
      return null;
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.Serializers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */