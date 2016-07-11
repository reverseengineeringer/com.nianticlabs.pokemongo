package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import java.io.IOException;

public class AsExternalTypeSerializer
  extends TypeSerializerBase
{
  protected final String _typePropertyName;
  
  public AsExternalTypeSerializer(TypeIdResolver paramTypeIdResolver, BeanProperty paramBeanProperty, String paramString)
  {
    super(paramTypeIdResolver, paramBeanProperty);
    _typePropertyName = paramString;
  }
  
  protected final void _writeArrayPrefix(Object paramObject, JsonGenerator paramJsonGenerator)
    throws IOException
  {
    paramJsonGenerator.writeStartArray();
  }
  
  protected final void _writeArraySuffix(Object paramObject, JsonGenerator paramJsonGenerator, String paramString)
    throws IOException
  {
    paramJsonGenerator.writeEndArray();
    if (paramString != null) {
      paramJsonGenerator.writeStringField(_typePropertyName, paramString);
    }
  }
  
  protected final void _writeObjectPrefix(Object paramObject, JsonGenerator paramJsonGenerator)
    throws IOException
  {
    paramJsonGenerator.writeStartObject();
  }
  
  protected final void _writeObjectSuffix(Object paramObject, JsonGenerator paramJsonGenerator, String paramString)
    throws IOException
  {
    paramJsonGenerator.writeEndObject();
    if (paramString != null) {
      paramJsonGenerator.writeStringField(_typePropertyName, paramString);
    }
  }
  
  protected final void _writeScalarPrefix(Object paramObject, JsonGenerator paramJsonGenerator)
    throws IOException
  {}
  
  protected final void _writeScalarSuffix(Object paramObject, JsonGenerator paramJsonGenerator, String paramString)
    throws IOException
  {
    if (paramString != null) {
      paramJsonGenerator.writeStringField(_typePropertyName, paramString);
    }
  }
  
  public AsExternalTypeSerializer forProperty(BeanProperty paramBeanProperty)
  {
    if (_property == paramBeanProperty) {
      return this;
    }
    return new AsExternalTypeSerializer(_idResolver, paramBeanProperty, _typePropertyName);
  }
  
  public String getPropertyName()
  {
    return _typePropertyName;
  }
  
  public JsonTypeInfo.As getTypeInclusion()
  {
    return JsonTypeInfo.As.EXTERNAL_PROPERTY;
  }
  
  public void writeCustomTypePrefixForArray(Object paramObject, JsonGenerator paramJsonGenerator, String paramString)
    throws IOException
  {
    _writeArrayPrefix(paramObject, paramJsonGenerator);
  }
  
  public void writeCustomTypePrefixForObject(Object paramObject, JsonGenerator paramJsonGenerator, String paramString)
    throws IOException
  {
    _writeObjectPrefix(paramObject, paramJsonGenerator);
  }
  
  public void writeCustomTypePrefixForScalar(Object paramObject, JsonGenerator paramJsonGenerator, String paramString)
    throws IOException
  {
    _writeScalarPrefix(paramObject, paramJsonGenerator);
  }
  
  public void writeCustomTypeSuffixForArray(Object paramObject, JsonGenerator paramJsonGenerator, String paramString)
    throws IOException
  {
    _writeArraySuffix(paramObject, paramJsonGenerator, paramString);
  }
  
  public void writeCustomTypeSuffixForObject(Object paramObject, JsonGenerator paramJsonGenerator, String paramString)
    throws IOException
  {
    _writeObjectSuffix(paramObject, paramJsonGenerator, paramString);
  }
  
  public void writeCustomTypeSuffixForScalar(Object paramObject, JsonGenerator paramJsonGenerator, String paramString)
    throws IOException
  {
    _writeScalarSuffix(paramObject, paramJsonGenerator, paramString);
  }
  
  public void writeTypePrefixForArray(Object paramObject, JsonGenerator paramJsonGenerator)
    throws IOException
  {
    _writeArrayPrefix(paramObject, paramJsonGenerator);
  }
  
  public void writeTypePrefixForArray(Object paramObject, JsonGenerator paramJsonGenerator, Class<?> paramClass)
    throws IOException
  {
    _writeArrayPrefix(paramObject, paramJsonGenerator);
  }
  
  public void writeTypePrefixForObject(Object paramObject, JsonGenerator paramJsonGenerator)
    throws IOException
  {
    _writeObjectPrefix(paramObject, paramJsonGenerator);
  }
  
  public void writeTypePrefixForObject(Object paramObject, JsonGenerator paramJsonGenerator, Class<?> paramClass)
    throws IOException
  {
    _writeObjectPrefix(paramObject, paramJsonGenerator);
  }
  
  public void writeTypePrefixForScalar(Object paramObject, JsonGenerator paramJsonGenerator)
    throws IOException
  {
    _writeScalarPrefix(paramObject, paramJsonGenerator);
  }
  
  public void writeTypePrefixForScalar(Object paramObject, JsonGenerator paramJsonGenerator, Class<?> paramClass)
    throws IOException
  {
    _writeScalarPrefix(paramObject, paramJsonGenerator);
  }
  
  public void writeTypeSuffixForArray(Object paramObject, JsonGenerator paramJsonGenerator)
    throws IOException
  {
    _writeArraySuffix(paramObject, paramJsonGenerator, idFromValue(paramObject));
  }
  
  public void writeTypeSuffixForObject(Object paramObject, JsonGenerator paramJsonGenerator)
    throws IOException
  {
    _writeObjectSuffix(paramObject, paramJsonGenerator, idFromValue(paramObject));
  }
  
  public void writeTypeSuffixForScalar(Object paramObject, JsonGenerator paramJsonGenerator)
    throws IOException
  {
    _writeScalarSuffix(paramObject, paramJsonGenerator, idFromValue(paramObject));
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.jsontype.impl.AsExternalTypeSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */