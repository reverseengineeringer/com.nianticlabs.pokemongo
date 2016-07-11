package com.fasterxml.jackson.databind.introspect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public final class MemberKey
{
  static final Class<?>[] NO_CLASSES = new Class[0];
  final Class<?>[] _argTypes;
  final String _name;
  
  public MemberKey(String paramString, Class<?>[] paramArrayOfClass)
  {
    _name = paramString;
    paramString = paramArrayOfClass;
    if (paramArrayOfClass == null) {
      paramString = NO_CLASSES;
    }
    _argTypes = paramString;
  }
  
  public MemberKey(Constructor<?> paramConstructor)
  {
    this("", paramConstructor.getParameterTypes());
  }
  
  public MemberKey(Method paramMethod)
  {
    this(paramMethod.getName(), paramMethod.getParameterTypes());
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    for (;;)
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (paramObject.getClass() != getClass()) {
        return false;
      }
      paramObject = (MemberKey)paramObject;
      if (!_name.equals(_name)) {
        return false;
      }
      paramObject = _argTypes;
      int j = _argTypes.length;
      if (paramObject.length != j) {
        return false;
      }
      int i = 0;
      while (i < j)
      {
        if (paramObject[i] != _argTypes[i]) {
          break label92;
        }
        i += 1;
      }
    }
    label92:
    return false;
  }
  
  public int hashCode()
  {
    return _name.hashCode() + _argTypes.length;
  }
  
  public String toString()
  {
    return _name + "(" + _argTypes.length + "-args)";
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.introspect.MemberKey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */