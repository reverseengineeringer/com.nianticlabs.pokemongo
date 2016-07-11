package com.fasterxml.jackson.databind.util;

import java.lang.reflect.Array;

final class ArrayBuilders$1
{
  ArrayBuilders$1(Class paramClass, int paramInt, Object paramObject) {}
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject == null) || (paramObject.getClass() != val$defaultValueType)) {
      return false;
    }
    if (Array.getLength(paramObject) != val$length) {
      return false;
    }
    int i = 0;
    label39:
    Object localObject1;
    Object localObject2;
    if (i < val$length)
    {
      localObject1 = Array.get(val$defaultValue, i);
      localObject2 = Array.get(paramObject, i);
      if (localObject1 != localObject2) {
        break label76;
      }
    }
    label76:
    while ((localObject1 == null) || (localObject1.equals(localObject2)))
    {
      i += 1;
      break label39;
      break;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.util.ArrayBuilders.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */