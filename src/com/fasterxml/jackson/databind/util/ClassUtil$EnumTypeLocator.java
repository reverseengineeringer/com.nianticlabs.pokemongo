package com.fasterxml.jackson.databind.util;

import java.lang.reflect.Field;
import java.util.EnumMap;
import java.util.EnumSet;

class ClassUtil$EnumTypeLocator
{
  static final EnumTypeLocator instance = new EnumTypeLocator();
  private final Field enumMapTypeField = locateField(EnumMap.class, "elementType", Class.class);
  private final Field enumSetTypeField = locateField(EnumSet.class, "elementType", Class.class);
  
  private Object get(Object paramObject, Field paramField)
  {
    try
    {
      paramObject = paramField.get(paramObject);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      throw new IllegalArgumentException((Throwable)paramObject);
    }
  }
  
  private static Field locateField(Class<?> paramClass1, String paramString, Class<?> paramClass2)
  {
    Object localObject = null;
    Field[] arrayOfField = paramClass1.getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    paramClass1 = (Class<?>)localObject;
    if (i < j)
    {
      paramClass1 = arrayOfField[i];
      if ((!paramString.equals(paramClass1.getName())) || (paramClass1.getType() != paramClass2)) {}
    }
    else
    {
      paramString = paramClass1;
      if (paramClass1 != null) {
        break label112;
      }
      j = arrayOfField.length;
      i = 0;
    }
    for (;;)
    {
      paramString = paramClass1;
      if (i >= j) {
        break label112;
      }
      localObject = arrayOfField[i];
      paramString = paramClass1;
      if (((Field)localObject).getType() == paramClass2)
      {
        if (paramClass1 != null)
        {
          return null;
          i += 1;
          break;
        }
        paramString = (String)localObject;
      }
      i += 1;
      paramClass1 = paramString;
    }
    label112:
    if (paramString != null) {}
    try
    {
      paramString.setAccessible(true);
      return paramString;
    }
    catch (Throwable paramClass1)
    {
      for (;;) {}
    }
  }
  
  public Class<? extends Enum<?>> enumTypeFor(EnumMap<?, ?> paramEnumMap)
  {
    if (enumMapTypeField != null) {
      return (Class)get(paramEnumMap, enumMapTypeField);
    }
    throw new IllegalStateException("Can not figure out type for EnumMap (odd JDK platform?)");
  }
  
  public Class<? extends Enum<?>> enumTypeFor(EnumSet<?> paramEnumSet)
  {
    if (enumSetTypeField != null) {
      return (Class)get(paramEnumSet, enumSetTypeField);
    }
    throw new IllegalStateException("Can not figure out type for EnumSet (odd JDK platform?)");
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.util.ClassUtil.EnumTypeLocator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */