package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonStringFormatVisitor;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import com.fasterxml.jackson.databind.jsonschema.SchemaAware;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.Set;

@JacksonStdImpl
public class JsonValueSerializer
  extends StdSerializer<Object>
  implements ContextualSerializer, JsonFormatVisitable, SchemaAware
{
  protected final Method _accessorMethod;
  protected final boolean _forceTypeInformation;
  protected final BeanProperty _property;
  protected final JsonSerializer<Object> _valueSerializer;
  
  public JsonValueSerializer(JsonValueSerializer paramJsonValueSerializer, BeanProperty paramBeanProperty, JsonSerializer<?> paramJsonSerializer, boolean paramBoolean)
  {
    super(_notNullClass(paramJsonValueSerializer.handledType()));
    _accessorMethod = _accessorMethod;
    _valueSerializer = paramJsonSerializer;
    _property = paramBeanProperty;
    _forceTypeInformation = paramBoolean;
  }
  
  public JsonValueSerializer(Method paramMethod, JsonSerializer<?> paramJsonSerializer)
  {
    super(paramMethod.getReturnType(), false);
    _accessorMethod = paramMethod;
    _valueSerializer = paramJsonSerializer;
    _property = null;
    _forceTypeInformation = true;
  }
  
  private static final Class<Object> _notNullClass(Class<?> paramClass)
  {
    Object localObject = paramClass;
    if (paramClass == null) {
      localObject = Object.class;
    }
    return (Class<Object>)localObject;
  }
  
  protected boolean _acceptJsonFormatVisitorForEnum(JsonFormatVisitorWrapper paramJsonFormatVisitorWrapper, JavaType paramJavaType, Class<?> paramClass)
    throws JsonMappingException
  {
    paramJsonFormatVisitorWrapper = paramJsonFormatVisitorWrapper.expectStringFormat(paramJavaType);
    if (paramJsonFormatVisitorWrapper != null)
    {
      LinkedHashSet localLinkedHashSet = new LinkedHashSet();
      paramClass = paramClass.getEnumConstants();
      int j = paramClass.length;
      int i = 0;
      while (i < j)
      {
        paramJavaType = paramClass[i];
        try
        {
          localLinkedHashSet.add(String.valueOf(_accessorMethod.invoke(paramJavaType, new Object[0])));
          i += 1;
        }
        catch (Exception paramJsonFormatVisitorWrapper)
        {
          while (((paramJsonFormatVisitorWrapper instanceof InvocationTargetException)) && (paramJsonFormatVisitorWrapper.getCause() != null)) {
            paramJsonFormatVisitorWrapper = paramJsonFormatVisitorWrapper.getCause();
          }
          if ((paramJsonFormatVisitorWrapper instanceof Error)) {
            throw ((Error)paramJsonFormatVisitorWrapper);
          }
          throw JsonMappingException.wrapWithPath(paramJsonFormatVisitorWrapper, paramJavaType, _accessorMethod.getName() + "()");
        }
      }
      paramJsonFormatVisitorWrapper.enumTypes(localLinkedHashSet);
    }
    return true;
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper paramJsonFormatVisitorWrapper, JavaType paramJavaType)
    throws JsonMappingException
  {
    if (paramJavaType == null) {}
    for (Object localObject1 = null;; localObject1 = paramJavaType.getRawClass())
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = _accessorMethod.getDeclaringClass();
      }
      if ((localObject2 == null) || (!((Class)localObject2).isEnum()) || (!_acceptJsonFormatVisitorForEnum(paramJsonFormatVisitorWrapper, paramJavaType, (Class)localObject2))) {
        break;
      }
      return;
    }
    localObject1 = _valueSerializer;
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = paramJavaType;
      if (paramJavaType == null)
      {
        if (_property != null) {
          paramJavaType = _property.getType();
        }
        localObject1 = paramJavaType;
        if (paramJavaType == null) {
          localObject1 = paramJsonFormatVisitorWrapper.getProvider().constructType(_handledType);
        }
      }
      paramJavaType = paramJsonFormatVisitorWrapper.getProvider().findTypedValueSerializer((JavaType)localObject1, false, _property);
      localObject2 = paramJavaType;
      if (paramJavaType == null)
      {
        paramJsonFormatVisitorWrapper.expectAnyFormat((JavaType)localObject1);
        return;
      }
    }
    ((JsonSerializer)localObject2).acceptJsonFormatVisitor(paramJsonFormatVisitorWrapper, null);
  }
  
  public JsonSerializer<?> createContextual(SerializerProvider paramSerializerProvider, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    Object localObject = _valueSerializer;
    if (localObject == null)
    {
      if (!paramSerializerProvider.isEnabled(MapperFeature.USE_STATIC_TYPING))
      {
        localObject = this;
        if (!Modifier.isFinal(_accessorMethod.getReturnType().getModifiers())) {}
      }
      else
      {
        localObject = paramSerializerProvider.constructType(_accessorMethod.getGenericReturnType());
        paramSerializerProvider = paramSerializerProvider.findPrimaryPropertySerializer((JavaType)localObject, paramBeanProperty);
        localObject = withResolved(paramBeanProperty, paramSerializerProvider, isNaturalTypeWithStdHandling(((JavaType)localObject).getRawClass(), paramSerializerProvider));
      }
      return (JsonSerializer<?>)localObject;
    }
    return withResolved(paramBeanProperty, paramSerializerProvider.handlePrimaryContextualization((JsonSerializer)localObject, paramBeanProperty), _forceTypeInformation);
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
    throws JsonMappingException
  {
    if ((_valueSerializer instanceof SchemaAware)) {
      return ((SchemaAware)_valueSerializer).getSchema(paramSerializerProvider, null);
    }
    return JsonSchema.getDefaultSchemaNode();
  }
  
  protected boolean isNaturalTypeWithStdHandling(Class<?> paramClass, JsonSerializer<?> paramJsonSerializer)
  {
    if (paramClass.isPrimitive())
    {
      if ((paramClass == Integer.TYPE) || (paramClass == Boolean.TYPE) || (paramClass == Double.TYPE)) {}
    }
    else {
      while ((paramClass != String.class) && (paramClass != Integer.class) && (paramClass != Boolean.class) && (paramClass != Double.class)) {
        return false;
      }
    }
    return isDefaultSerializer(paramJsonSerializer);
  }
  
  public void serialize(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    try
    {
      Object localObject = _accessorMethod.invoke(paramObject, new Object[0]);
      if (localObject == null)
      {
        paramSerializerProvider.defaultSerializeNull(paramJsonGenerator);
        return;
      }
      JsonSerializer localJsonSerializer2 = _valueSerializer;
      JsonSerializer localJsonSerializer1 = localJsonSerializer2;
      if (localJsonSerializer2 == null) {
        localJsonSerializer1 = paramSerializerProvider.findTypedValueSerializer(localObject.getClass(), true, _property);
      }
      localJsonSerializer1.serialize(localObject, paramJsonGenerator, paramSerializerProvider);
      return;
    }
    catch (IOException paramObject)
    {
      throw ((Throwable)paramObject);
    }
    catch (Exception paramJsonGenerator)
    {
      while (((paramJsonGenerator instanceof InvocationTargetException)) && (paramJsonGenerator.getCause() != null)) {
        paramJsonGenerator = paramJsonGenerator.getCause();
      }
      if ((paramJsonGenerator instanceof Error)) {
        throw ((Error)paramJsonGenerator);
      }
      throw JsonMappingException.wrapWithPath(paramJsonGenerator, paramObject, _accessorMethod.getName() + "()");
    }
  }
  
  public void serializeWithType(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
    throws IOException
  {
    try
    {
      localObject = _accessorMethod.invoke(paramObject, new Object[0]);
      if (localObject == null)
      {
        paramSerializerProvider.defaultSerializeNull(paramJsonGenerator);
        return;
      }
      localJsonSerializer2 = _valueSerializer;
      if (localJsonSerializer2 != null) {
        break label66;
      }
      localJsonSerializer1 = paramSerializerProvider.findValueSerializer(localObject.getClass(), _property);
    }
    catch (IOException paramObject)
    {
      Object localObject;
      JsonSerializer localJsonSerializer2;
      do
      {
        throw ((Throwable)paramObject);
        JsonSerializer localJsonSerializer1 = localJsonSerializer2;
      } while (!_forceTypeInformation);
      paramTypeSerializer.writeTypePrefixForScalar(paramObject, paramJsonGenerator);
      localJsonSerializer2.serialize(localObject, paramJsonGenerator, paramSerializerProvider);
      paramTypeSerializer.writeTypeSuffixForScalar(paramObject, paramJsonGenerator);
      return;
    }
    catch (Exception paramJsonGenerator)
    {
      label66:
      while (((paramJsonGenerator instanceof InvocationTargetException)) && (paramJsonGenerator.getCause() != null)) {
        paramJsonGenerator = paramJsonGenerator.getCause();
      }
      if (!(paramJsonGenerator instanceof Error)) {
        break label136;
      }
      throw ((Error)paramJsonGenerator);
      label136:
      throw JsonMappingException.wrapWithPath(paramJsonGenerator, paramObject, _accessorMethod.getName() + "()");
    }
    localJsonSerializer1.serializeWithType(localObject, paramJsonGenerator, paramSerializerProvider, paramTypeSerializer);
  }
  
  public String toString()
  {
    return "(@JsonValue serializer for method " + _accessorMethod.getDeclaringClass() + "#" + _accessorMethod.getName() + ")";
  }
  
  public JsonValueSerializer withResolved(BeanProperty paramBeanProperty, JsonSerializer<?> paramJsonSerializer, boolean paramBoolean)
  {
    if ((_property == paramBeanProperty) && (_valueSerializer == paramJsonSerializer) && (paramBoolean == _forceTypeInformation)) {
      return this;
    }
    return new JsonValueSerializer(this, paramBeanProperty, paramJsonSerializer, paramBoolean);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.std.JsonValueSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */