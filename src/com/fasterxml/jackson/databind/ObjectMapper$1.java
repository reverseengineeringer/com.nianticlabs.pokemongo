package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonFactory.Feature;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.deser.DeserializerFactory;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.deser.KeyDeserializers;
import com.fasterxml.jackson.databind.deser.ValueInstantiators;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.type.TypeModifier;

class ObjectMapper$1
  implements Module.SetupContext
{
  ObjectMapper$1(ObjectMapper paramObjectMapper1, ObjectMapper paramObjectMapper2) {}
  
  public void addAbstractTypeResolver(AbstractTypeResolver paramAbstractTypeResolver)
  {
    paramAbstractTypeResolver = val$mapper._deserializationContext._factory.withAbstractTypeResolver(paramAbstractTypeResolver);
    val$mapper._deserializationContext = val$mapper._deserializationContext.with(paramAbstractTypeResolver);
  }
  
  public void addBeanDeserializerModifier(BeanDeserializerModifier paramBeanDeserializerModifier)
  {
    paramBeanDeserializerModifier = val$mapper._deserializationContext._factory.withDeserializerModifier(paramBeanDeserializerModifier);
    val$mapper._deserializationContext = val$mapper._deserializationContext.with(paramBeanDeserializerModifier);
  }
  
  public void addBeanSerializerModifier(BeanSerializerModifier paramBeanSerializerModifier)
  {
    val$mapper._serializerFactory = val$mapper._serializerFactory.withSerializerModifier(paramBeanSerializerModifier);
  }
  
  public void addDeserializationProblemHandler(DeserializationProblemHandler paramDeserializationProblemHandler)
  {
    val$mapper.addHandler(paramDeserializationProblemHandler);
  }
  
  public void addDeserializers(Deserializers paramDeserializers)
  {
    paramDeserializers = val$mapper._deserializationContext._factory.withAdditionalDeserializers(paramDeserializers);
    val$mapper._deserializationContext = val$mapper._deserializationContext.with(paramDeserializers);
  }
  
  public void addKeyDeserializers(KeyDeserializers paramKeyDeserializers)
  {
    paramKeyDeserializers = val$mapper._deserializationContext._factory.withAdditionalKeyDeserializers(paramKeyDeserializers);
    val$mapper._deserializationContext = val$mapper._deserializationContext.with(paramKeyDeserializers);
  }
  
  public void addKeySerializers(Serializers paramSerializers)
  {
    val$mapper._serializerFactory = val$mapper._serializerFactory.withAdditionalKeySerializers(paramSerializers);
  }
  
  public void addSerializers(Serializers paramSerializers)
  {
    val$mapper._serializerFactory = val$mapper._serializerFactory.withAdditionalSerializers(paramSerializers);
  }
  
  public void addTypeModifier(TypeModifier paramTypeModifier)
  {
    paramTypeModifier = val$mapper._typeFactory.withModifier(paramTypeModifier);
    val$mapper.setTypeFactory(paramTypeModifier);
  }
  
  public void addValueInstantiators(ValueInstantiators paramValueInstantiators)
  {
    paramValueInstantiators = val$mapper._deserializationContext._factory.withValueInstantiators(paramValueInstantiators);
    val$mapper._deserializationContext = val$mapper._deserializationContext.with(paramValueInstantiators);
  }
  
  public void appendAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector)
  {
    val$mapper._deserializationConfig = val$mapper._deserializationConfig.withAppendedAnnotationIntrospector(paramAnnotationIntrospector);
    val$mapper._serializationConfig = val$mapper._serializationConfig.withAppendedAnnotationIntrospector(paramAnnotationIntrospector);
  }
  
  public Version getMapperVersion()
  {
    return this$0.version();
  }
  
  public <C extends ObjectCodec> C getOwner()
  {
    return val$mapper;
  }
  
  public TypeFactory getTypeFactory()
  {
    return this$0._typeFactory;
  }
  
  public void insertAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector)
  {
    val$mapper._deserializationConfig = val$mapper._deserializationConfig.withInsertedAnnotationIntrospector(paramAnnotationIntrospector);
    val$mapper._serializationConfig = val$mapper._serializationConfig.withInsertedAnnotationIntrospector(paramAnnotationIntrospector);
  }
  
  public boolean isEnabled(JsonFactory.Feature paramFeature)
  {
    return val$mapper.isEnabled(paramFeature);
  }
  
  public boolean isEnabled(JsonGenerator.Feature paramFeature)
  {
    return val$mapper.isEnabled(paramFeature);
  }
  
  public boolean isEnabled(JsonParser.Feature paramFeature)
  {
    return val$mapper.isEnabled(paramFeature);
  }
  
  public boolean isEnabled(DeserializationFeature paramDeserializationFeature)
  {
    return val$mapper.isEnabled(paramDeserializationFeature);
  }
  
  public boolean isEnabled(MapperFeature paramMapperFeature)
  {
    return val$mapper.isEnabled(paramMapperFeature);
  }
  
  public boolean isEnabled(SerializationFeature paramSerializationFeature)
  {
    return val$mapper.isEnabled(paramSerializationFeature);
  }
  
  public void registerSubtypes(NamedType... paramVarArgs)
  {
    val$mapper.registerSubtypes(paramVarArgs);
  }
  
  public void registerSubtypes(Class<?>... paramVarArgs)
  {
    val$mapper.registerSubtypes(paramVarArgs);
  }
  
  public void setClassIntrospector(ClassIntrospector paramClassIntrospector)
  {
    val$mapper._deserializationConfig = val$mapper._deserializationConfig.with(paramClassIntrospector);
    val$mapper._serializationConfig = val$mapper._serializationConfig.with(paramClassIntrospector);
  }
  
  public void setMixInAnnotations(Class<?> paramClass1, Class<?> paramClass2)
  {
    val$mapper.addMixIn(paramClass1, paramClass2);
  }
  
  public void setNamingStrategy(PropertyNamingStrategy paramPropertyNamingStrategy)
  {
    val$mapper.setPropertyNamingStrategy(paramPropertyNamingStrategy);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ObjectMapper.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */