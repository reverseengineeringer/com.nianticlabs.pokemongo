package com.fasterxml.jackson.databind.jsontype;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationConfig;
import java.util.Collection;

public abstract interface TypeResolverBuilder<T extends TypeResolverBuilder<T>>
{
  public abstract TypeDeserializer buildTypeDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, Collection<NamedType> paramCollection);
  
  public abstract TypeSerializer buildTypeSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, Collection<NamedType> paramCollection);
  
  public abstract T defaultImpl(Class<?> paramClass);
  
  public abstract Class<?> getDefaultImpl();
  
  public abstract T inclusion(JsonTypeInfo.As paramAs);
  
  public abstract T init(JsonTypeInfo.Id paramId, TypeIdResolver paramTypeIdResolver);
  
  public abstract T typeIdVisibility(boolean paramBoolean);
  
  public abstract T typeProperty(String paramString);
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */