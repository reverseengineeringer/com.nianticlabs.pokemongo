package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;

public class AsExternalTypeDeserializer
  extends AsArrayTypeDeserializer
{
  private static final long serialVersionUID = 1L;
  
  public AsExternalTypeDeserializer(JavaType paramJavaType, TypeIdResolver paramTypeIdResolver, String paramString, boolean paramBoolean, Class<?> paramClass)
  {
    super(paramJavaType, paramTypeIdResolver, paramString, paramBoolean, paramClass);
  }
  
  public AsExternalTypeDeserializer(AsExternalTypeDeserializer paramAsExternalTypeDeserializer, BeanProperty paramBeanProperty)
  {
    super(paramAsExternalTypeDeserializer, paramBeanProperty);
  }
  
  protected boolean _usesExternalId()
  {
    return true;
  }
  
  public TypeDeserializer forProperty(BeanProperty paramBeanProperty)
  {
    if (paramBeanProperty == _property) {
      return this;
    }
    return new AsExternalTypeDeserializer(this, paramBeanProperty);
  }
  
  public JsonTypeInfo.As getTypeInclusion()
  {
    return JsonTypeInfo.As.EXTERNAL_PROPERTY;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.jsontype.impl.AsExternalTypeDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */