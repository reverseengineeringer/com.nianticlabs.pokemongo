package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.ser.VirtualBeanPropertyWriter;
import com.fasterxml.jackson.databind.util.Converter;

public abstract class HandlerInstantiator
{
  public Converter<?, ?> converterInstance(MapperConfig<?> paramMapperConfig, Annotated paramAnnotated, Class<?> paramClass)
  {
    return null;
  }
  
  public abstract JsonDeserializer<?> deserializerInstance(DeserializationConfig paramDeserializationConfig, Annotated paramAnnotated, Class<?> paramClass);
  
  public abstract KeyDeserializer keyDeserializerInstance(DeserializationConfig paramDeserializationConfig, Annotated paramAnnotated, Class<?> paramClass);
  
  public PropertyNamingStrategy namingStrategyInstance(MapperConfig<?> paramMapperConfig, Annotated paramAnnotated, Class<?> paramClass)
  {
    return null;
  }
  
  public ObjectIdGenerator<?> objectIdGeneratorInstance(MapperConfig<?> paramMapperConfig, Annotated paramAnnotated, Class<?> paramClass)
  {
    return null;
  }
  
  public ObjectIdResolver resolverIdGeneratorInstance(MapperConfig<?> paramMapperConfig, Annotated paramAnnotated, Class<?> paramClass)
  {
    return null;
  }
  
  public abstract JsonSerializer<?> serializerInstance(SerializationConfig paramSerializationConfig, Annotated paramAnnotated, Class<?> paramClass);
  
  public abstract TypeIdResolver typeIdResolverInstance(MapperConfig<?> paramMapperConfig, Annotated paramAnnotated, Class<?> paramClass);
  
  public abstract TypeResolverBuilder<?> typeResolverBuilderInstance(MapperConfig<?> paramMapperConfig, Annotated paramAnnotated, Class<?> paramClass);
  
  public ValueInstantiator valueInstantiatorInstance(MapperConfig<?> paramMapperConfig, Annotated paramAnnotated, Class<?> paramClass)
  {
    return null;
  }
  
  public VirtualBeanPropertyWriter virtualPropertyWriterInstance(MapperConfig<?> paramMapperConfig, Class<?> paramClass)
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.cfg.HandlerInstantiator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */