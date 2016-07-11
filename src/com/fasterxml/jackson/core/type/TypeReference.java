package com.fasterxml.jackson.core.type;

import java.lang.reflect.Type;

public abstract class TypeReference<T>
  implements Comparable<TypeReference<T>>
{
  protected final Type _type;
  
  protected TypeReference()
  {
    Type localType = getClass().getGenericSuperclass();
    if ((localType instanceof Class)) {
      throw new IllegalArgumentException("Internal error: TypeReference constructed without actual type information");
    }
    _type = ((java.lang.reflect.ParameterizedType)localType).getActualTypeArguments()[0];
  }
  
  public int compareTo(TypeReference<T> paramTypeReference)
  {
    return 0;
  }
  
  public Type getType()
  {
    return _type;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.type.TypeReference
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */