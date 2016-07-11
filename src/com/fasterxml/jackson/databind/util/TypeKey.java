package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.JavaType;

public class TypeKey
{
  protected Class<?> _class;
  protected int _hashCode;
  protected boolean _isTyped;
  protected JavaType _type;
  
  public TypeKey() {}
  
  public TypeKey(JavaType paramJavaType, boolean paramBoolean)
  {
    _type = paramJavaType;
    _class = null;
    _isTyped = paramBoolean;
    if (paramBoolean) {}
    for (int i = typedHash(paramJavaType);; i = untypedHash(paramJavaType))
    {
      _hashCode = i;
      return;
    }
  }
  
  public TypeKey(TypeKey paramTypeKey)
  {
    _hashCode = _hashCode;
    _class = _class;
    _type = _type;
    _isTyped = _isTyped;
  }
  
  public TypeKey(Class<?> paramClass, boolean paramBoolean)
  {
    _class = paramClass;
    _type = null;
    _isTyped = paramBoolean;
    if (paramBoolean) {}
    for (int i = typedHash(paramClass);; i = untypedHash(paramClass))
    {
      _hashCode = i;
      return;
    }
  }
  
  public static final int typedHash(JavaType paramJavaType)
  {
    return paramJavaType.hashCode() - 2;
  }
  
  public static final int typedHash(Class<?> paramClass)
  {
    return paramClass.getName().hashCode() + 1;
  }
  
  public static final int untypedHash(JavaType paramJavaType)
  {
    return paramJavaType.hashCode() - 1;
  }
  
  public static final int untypedHash(Class<?> paramClass)
  {
    return paramClass.getName().hashCode();
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
        if (paramObject == this) {
          return true;
        }
      } while (paramObject.getClass() != getClass());
      paramObject = (TypeKey)paramObject;
    } while (_isTyped != _isTyped);
    if (_class != null)
    {
      if (_class == _class) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    return _type.equals(_type);
  }
  
  public Class<?> getRawType()
  {
    return _class;
  }
  
  public JavaType getType()
  {
    return _type;
  }
  
  public final int hashCode()
  {
    return _hashCode;
  }
  
  public boolean isTyped()
  {
    return _isTyped;
  }
  
  public final void resetTyped(JavaType paramJavaType)
  {
    _type = paramJavaType;
    _class = null;
    _isTyped = true;
    _hashCode = typedHash(paramJavaType);
  }
  
  public final void resetTyped(Class<?> paramClass)
  {
    _type = null;
    _class = paramClass;
    _isTyped = true;
    _hashCode = typedHash(paramClass);
  }
  
  public final void resetUntyped(JavaType paramJavaType)
  {
    _type = paramJavaType;
    _class = null;
    _isTyped = false;
    _hashCode = untypedHash(paramJavaType);
  }
  
  public final void resetUntyped(Class<?> paramClass)
  {
    _type = null;
    _class = paramClass;
    _isTyped = false;
    _hashCode = untypedHash(paramClass);
  }
  
  public final String toString()
  {
    if (_class != null) {
      return "{class: " + _class.getName() + ", typed? " + _isTyped + "}";
    }
    return "{type: " + _type + ", typed? " + _isTyped + "}";
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.util.TypeKey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */