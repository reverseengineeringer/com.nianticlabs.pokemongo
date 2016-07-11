package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import java.io.IOException;

public class AsWrapperTypeSerializer
  extends TypeSerializerBase
{
  public AsWrapperTypeSerializer(TypeIdResolver paramTypeIdResolver, BeanProperty paramBeanProperty)
  {
    super(paramTypeIdResolver, paramBeanProperty);
  }
  
  protected String _validTypeId(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public AsWrapperTypeSerializer forProperty(BeanProperty paramBeanProperty)
  {
    if (_property == paramBeanProperty) {
      return this;
    }
    return new AsWrapperTypeSerializer(_idResolver, paramBeanProperty);
  }
  
  public JsonTypeInfo.As getTypeInclusion()
  {
    return JsonTypeInfo.As.WRAPPER_OBJECT;
  }
  
  public void writeCustomTypePrefixForArray(Object paramObject, JsonGenerator paramJsonGenerator, String paramString)
    throws IOException
  {
    if (paramJsonGenerator.canWriteTypeId())
    {
      if (paramString != null) {
        paramJsonGenerator.writeTypeId(paramString);
      }
      paramJsonGenerator.writeStartArray();
      return;
    }
    paramJsonGenerator.writeStartObject();
    paramJsonGenerator.writeArrayFieldStart(_validTypeId(paramString));
  }
  
  public void writeCustomTypePrefixForObject(Object paramObject, JsonGenerator paramJsonGenerator, String paramString)
    throws IOException
  {
    if (paramJsonGenerator.canWriteTypeId())
    {
      if (paramString != null) {
        paramJsonGenerator.writeTypeId(paramString);
      }
      paramJsonGenerator.writeStartObject();
      return;
    }
    paramJsonGenerator.writeStartObject();
    paramJsonGenerator.writeObjectFieldStart(_validTypeId(paramString));
  }
  
  public void writeCustomTypePrefixForScalar(Object paramObject, JsonGenerator paramJsonGenerator, String paramString)
    throws IOException
  {
    if (paramJsonGenerator.canWriteTypeId())
    {
      if (paramString != null) {
        paramJsonGenerator.writeTypeId(paramString);
      }
      return;
    }
    paramJsonGenerator.writeStartObject();
    paramJsonGenerator.writeFieldName(_validTypeId(paramString));
  }
  
  public void writeCustomTypeSuffixForArray(Object paramObject, JsonGenerator paramJsonGenerator, String paramString)
    throws IOException
  {
    if (!paramJsonGenerator.canWriteTypeId()) {
      writeTypeSuffixForArray(paramObject, paramJsonGenerator);
    }
  }
  
  public void writeCustomTypeSuffixForObject(Object paramObject, JsonGenerator paramJsonGenerator, String paramString)
    throws IOException
  {
    if (!paramJsonGenerator.canWriteTypeId()) {
      writeTypeSuffixForObject(paramObject, paramJsonGenerator);
    }
  }
  
  public void writeCustomTypeSuffixForScalar(Object paramObject, JsonGenerator paramJsonGenerator, String paramString)
    throws IOException
  {
    if (!paramJsonGenerator.canWriteTypeId()) {
      writeTypeSuffixForScalar(paramObject, paramJsonGenerator);
    }
  }
  
  public void writeTypePrefixForArray(Object paramObject, JsonGenerator paramJsonGenerator)
    throws IOException
  {
    paramObject = idFromValue(paramObject);
    if (paramJsonGenerator.canWriteTypeId())
    {
      if (paramObject != null) {
        paramJsonGenerator.writeTypeId(paramObject);
      }
      paramJsonGenerator.writeStartArray();
      return;
    }
    paramJsonGenerator.writeStartObject();
    paramJsonGenerator.writeArrayFieldStart(_validTypeId((String)paramObject));
  }
  
  public void writeTypePrefixForArray(Object paramObject, JsonGenerator paramJsonGenerator, Class<?> paramClass)
    throws IOException
  {
    paramObject = idFromValueAndType(paramObject, paramClass);
    if (paramJsonGenerator.canWriteTypeId())
    {
      if (paramObject != null) {
        paramJsonGenerator.writeTypeId(paramObject);
      }
      paramJsonGenerator.writeStartArray();
      return;
    }
    paramJsonGenerator.writeStartObject();
    paramJsonGenerator.writeArrayFieldStart(_validTypeId((String)paramObject));
  }
  
  public void writeTypePrefixForObject(Object paramObject, JsonGenerator paramJsonGenerator)
    throws IOException
  {
    paramObject = idFromValue(paramObject);
    if (paramJsonGenerator.canWriteTypeId())
    {
      if (paramObject != null) {
        paramJsonGenerator.writeTypeId(paramObject);
      }
      paramJsonGenerator.writeStartObject();
      return;
    }
    paramJsonGenerator.writeStartObject();
    paramJsonGenerator.writeObjectFieldStart(_validTypeId((String)paramObject));
  }
  
  public void writeTypePrefixForObject(Object paramObject, JsonGenerator paramJsonGenerator, Class<?> paramClass)
    throws IOException
  {
    paramObject = idFromValueAndType(paramObject, paramClass);
    if (paramJsonGenerator.canWriteTypeId())
    {
      if (paramObject != null) {
        paramJsonGenerator.writeTypeId(paramObject);
      }
      paramJsonGenerator.writeStartObject();
      return;
    }
    paramJsonGenerator.writeStartObject();
    paramJsonGenerator.writeObjectFieldStart(_validTypeId((String)paramObject));
  }
  
  public void writeTypePrefixForScalar(Object paramObject, JsonGenerator paramJsonGenerator)
    throws IOException
  {
    paramObject = idFromValue(paramObject);
    if (paramJsonGenerator.canWriteTypeId())
    {
      if (paramObject != null) {
        paramJsonGenerator.writeTypeId(paramObject);
      }
      return;
    }
    paramJsonGenerator.writeStartObject();
    paramJsonGenerator.writeFieldName(_validTypeId((String)paramObject));
  }
  
  public void writeTypePrefixForScalar(Object paramObject, JsonGenerator paramJsonGenerator, Class<?> paramClass)
    throws IOException
  {
    paramObject = idFromValueAndType(paramObject, paramClass);
    if (paramJsonGenerator.canWriteTypeId())
    {
      if (paramObject != null) {
        paramJsonGenerator.writeTypeId(paramObject);
      }
      return;
    }
    paramJsonGenerator.writeStartObject();
    paramJsonGenerator.writeFieldName(_validTypeId((String)paramObject));
  }
  
  public void writeTypeSuffixForArray(Object paramObject, JsonGenerator paramJsonGenerator)
    throws IOException
  {
    paramJsonGenerator.writeEndArray();
    if (!paramJsonGenerator.canWriteTypeId()) {
      paramJsonGenerator.writeEndObject();
    }
  }
  
  public void writeTypeSuffixForObject(Object paramObject, JsonGenerator paramJsonGenerator)
    throws IOException
  {
    paramJsonGenerator.writeEndObject();
    if (!paramJsonGenerator.canWriteTypeId()) {
      paramJsonGenerator.writeEndObject();
    }
  }
  
  public void writeTypeSuffixForScalar(Object paramObject, JsonGenerator paramJsonGenerator)
    throws IOException
  {
    if (!paramJsonGenerator.canWriteTypeId()) {
      paramJsonGenerator.writeEndObject();
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.jsontype.impl.AsWrapperTypeSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */