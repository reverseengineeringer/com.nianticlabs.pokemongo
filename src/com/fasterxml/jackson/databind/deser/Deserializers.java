package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;

public abstract interface Deserializers
{
  public abstract JsonDeserializer<?> findArrayDeserializer(ArrayType paramArrayType, DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription, TypeDeserializer paramTypeDeserializer, JsonDeserializer<?> paramJsonDeserializer)
    throws JsonMappingException;
  
  public abstract JsonDeserializer<?> findBeanDeserializer(JavaType paramJavaType, DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription)
    throws JsonMappingException;
  
  public abstract JsonDeserializer<?> findCollectionDeserializer(CollectionType paramCollectionType, DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription, TypeDeserializer paramTypeDeserializer, JsonDeserializer<?> paramJsonDeserializer)
    throws JsonMappingException;
  
  public abstract JsonDeserializer<?> findCollectionLikeDeserializer(CollectionLikeType paramCollectionLikeType, DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription, TypeDeserializer paramTypeDeserializer, JsonDeserializer<?> paramJsonDeserializer)
    throws JsonMappingException;
  
  public abstract JsonDeserializer<?> findEnumDeserializer(Class<?> paramClass, DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription)
    throws JsonMappingException;
  
  public abstract JsonDeserializer<?> findMapDeserializer(MapType paramMapType, DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription, KeyDeserializer paramKeyDeserializer, TypeDeserializer paramTypeDeserializer, JsonDeserializer<?> paramJsonDeserializer)
    throws JsonMappingException;
  
  public abstract JsonDeserializer<?> findMapLikeDeserializer(MapLikeType paramMapLikeType, DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription, KeyDeserializer paramKeyDeserializer, TypeDeserializer paramTypeDeserializer, JsonDeserializer<?> paramJsonDeserializer)
    throws JsonMappingException;
  
  public abstract JsonDeserializer<?> findTreeNodeDeserializer(Class<? extends JsonNode> paramClass, DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription)
    throws JsonMappingException;
  
  public static class Base
    implements Deserializers
  {
    public JsonDeserializer<?> findArrayDeserializer(ArrayType paramArrayType, DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription, TypeDeserializer paramTypeDeserializer, JsonDeserializer<?> paramJsonDeserializer)
      throws JsonMappingException
    {
      return null;
    }
    
    public JsonDeserializer<?> findBeanDeserializer(JavaType paramJavaType, DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription)
      throws JsonMappingException
    {
      return null;
    }
    
    public JsonDeserializer<?> findCollectionDeserializer(CollectionType paramCollectionType, DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription, TypeDeserializer paramTypeDeserializer, JsonDeserializer<?> paramJsonDeserializer)
      throws JsonMappingException
    {
      return null;
    }
    
    public JsonDeserializer<?> findCollectionLikeDeserializer(CollectionLikeType paramCollectionLikeType, DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription, TypeDeserializer paramTypeDeserializer, JsonDeserializer<?> paramJsonDeserializer)
      throws JsonMappingException
    {
      return null;
    }
    
    public JsonDeserializer<?> findEnumDeserializer(Class<?> paramClass, DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription)
      throws JsonMappingException
    {
      return null;
    }
    
    public JsonDeserializer<?> findMapDeserializer(MapType paramMapType, DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription, KeyDeserializer paramKeyDeserializer, TypeDeserializer paramTypeDeserializer, JsonDeserializer<?> paramJsonDeserializer)
      throws JsonMappingException
    {
      return null;
    }
    
    public JsonDeserializer<?> findMapLikeDeserializer(MapLikeType paramMapLikeType, DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription, KeyDeserializer paramKeyDeserializer, TypeDeserializer paramTypeDeserializer, JsonDeserializer<?> paramJsonDeserializer)
      throws JsonMappingException
    {
      return null;
    }
    
    public JsonDeserializer<?> findTreeNodeDeserializer(Class<? extends JsonNode> paramClass, DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription)
      throws JsonMappingException
    {
      return null;
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.Deserializers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */