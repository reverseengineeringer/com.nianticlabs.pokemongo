package com.fasterxml.jackson.databind.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class HierarchicType
{
  protected final Type _actualType;
  protected final ParameterizedType _genericType;
  protected final Class<?> _rawClass;
  protected HierarchicType _subType;
  protected HierarchicType _superType;
  
  public HierarchicType(Type paramType)
  {
    _actualType = paramType;
    if ((paramType instanceof Class))
    {
      _rawClass = ((Class)paramType);
      _genericType = null;
      return;
    }
    if ((paramType instanceof ParameterizedType))
    {
      _genericType = ((ParameterizedType)paramType);
      _rawClass = ((Class)_genericType.getRawType());
      return;
    }
    throw new IllegalArgumentException("Type " + paramType.getClass().getName() + " can not be used to construct HierarchicType");
  }
  
  private HierarchicType(Type paramType, Class<?> paramClass, ParameterizedType paramParameterizedType, HierarchicType paramHierarchicType1, HierarchicType paramHierarchicType2)
  {
    _actualType = paramType;
    _rawClass = paramClass;
    _genericType = paramParameterizedType;
    _superType = paramHierarchicType1;
    _subType = paramHierarchicType2;
  }
  
  public final ParameterizedType asGeneric()
  {
    return _genericType;
  }
  
  public HierarchicType deepCloneWithoutSubtype()
  {
    if (_superType == null) {}
    for (HierarchicType localHierarchicType1 = null;; localHierarchicType1 = _superType.deepCloneWithoutSubtype())
    {
      HierarchicType localHierarchicType2 = new HierarchicType(_actualType, _rawClass, _genericType, localHierarchicType1, null);
      if (localHierarchicType1 != null) {
        localHierarchicType1.setSubType(localHierarchicType2);
      }
      return localHierarchicType2;
    }
  }
  
  public final Class<?> getRawClass()
  {
    return _rawClass;
  }
  
  public final HierarchicType getSubType()
  {
    return _subType;
  }
  
  public final HierarchicType getSuperType()
  {
    return _superType;
  }
  
  public final boolean isGeneric()
  {
    return _genericType != null;
  }
  
  public void setSubType(HierarchicType paramHierarchicType)
  {
    _subType = paramHierarchicType;
  }
  
  public void setSuperType(HierarchicType paramHierarchicType)
  {
    _superType = paramHierarchicType;
  }
  
  public String toString()
  {
    if (_genericType != null) {
      return _genericType.toString();
    }
    return _rawClass.getName();
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.type.HierarchicType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */