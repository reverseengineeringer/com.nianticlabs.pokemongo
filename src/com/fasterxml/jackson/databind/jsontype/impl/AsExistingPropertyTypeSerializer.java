package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import java.io.IOException;

public class AsExistingPropertyTypeSerializer
  extends AsPropertyTypeSerializer
{
  public AsExistingPropertyTypeSerializer(TypeIdResolver paramTypeIdResolver, BeanProperty paramBeanProperty, String paramString)
  {
    super(paramTypeIdResolver, paramBeanProperty, paramString);
  }
  
  public AsExistingPropertyTypeSerializer forProperty(BeanProperty paramBeanProperty)
  {
    if (_property == paramBeanProperty) {
      return this;
    }
    return new AsExistingPropertyTypeSerializer(_idResolver, paramBeanProperty, _typePropertyName);
  }
  
  public JsonTypeInfo.As getTypeInclusion()
  {
    return JsonTypeInfo.As.EXISTING_PROPERTY;
  }
  
  public void writeCustomTypePrefixForObject(Object paramObject, JsonGenerator paramJsonGenerator, String paramString)
    throws IOException
  {
    if ((paramString != null) && (paramJsonGenerator.canWriteTypeId())) {
      paramJsonGenerator.writeTypeId(paramString);
    }
    paramJsonGenerator.writeStartObject();
  }
  
  public void writeTypePrefixForObject(Object paramObject, JsonGenerator paramJsonGenerator)
    throws IOException
  {
    paramObject = idFromValue(paramObject);
    if ((paramObject != null) && (paramJsonGenerator.canWriteTypeId())) {
      paramJsonGenerator.writeTypeId(paramObject);
    }
    paramJsonGenerator.writeStartObject();
  }
  
  public void writeTypePrefixForObject(Object paramObject, JsonGenerator paramJsonGenerator, Class<?> paramClass)
    throws IOException
  {
    paramObject = idFromValueAndType(paramObject, paramClass);
    if ((paramObject != null) && (paramJsonGenerator.canWriteTypeId())) {
      paramJsonGenerator.writeTypeId(paramObject);
    }
    paramJsonGenerator.writeStartObject();
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.jsontype.impl.AsExistingPropertyTypeSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */