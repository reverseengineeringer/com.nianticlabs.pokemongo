package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.type.TypeFactory;

public abstract class TypeIdResolverBase
  implements TypeIdResolver
{
  protected final JavaType _baseType;
  protected final TypeFactory _typeFactory;
  
  protected TypeIdResolverBase()
  {
    this(null, null);
  }
  
  protected TypeIdResolverBase(JavaType paramJavaType, TypeFactory paramTypeFactory)
  {
    _baseType = paramJavaType;
    _typeFactory = paramTypeFactory;
  }
  
  public String getDescForKnownTypeIds()
  {
    return null;
  }
  
  public String idFromBaseType()
  {
    return idFromValueAndType(null, _baseType.getRawClass());
  }
  
  public void init(JavaType paramJavaType) {}
  
  public JavaType typeFromId(DatabindContext paramDatabindContext, String paramString)
  {
    return typeFromId(paramString);
  }
  
  @Deprecated
  public JavaType typeFromId(String paramString)
  {
    return typeFromId(null, paramString);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */