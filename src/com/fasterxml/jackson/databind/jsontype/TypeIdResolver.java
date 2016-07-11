package com.fasterxml.jackson.databind.jsontype;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;

public abstract interface TypeIdResolver
{
  public abstract JsonTypeInfo.Id getMechanism();
  
  public abstract String idFromBaseType();
  
  public abstract String idFromValue(Object paramObject);
  
  public abstract String idFromValueAndType(Object paramObject, Class<?> paramClass);
  
  public abstract void init(JavaType paramJavaType);
  
  public abstract JavaType typeFromId(DatabindContext paramDatabindContext, String paramString);
  
  @Deprecated
  public abstract JavaType typeFromId(String paramString);
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.jsontype.TypeIdResolver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */