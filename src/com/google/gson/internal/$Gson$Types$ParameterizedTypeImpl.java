package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

final class $Gson$Types$ParameterizedTypeImpl
  implements ParameterizedType, Serializable
{
  private static final long serialVersionUID = 0L;
  private final Type ownerType;
  private final Type rawType;
  private final Type[] typeArguments;
  
  public $Gson$Types$ParameterizedTypeImpl(Type paramType1, Type paramType2, Type... paramVarArgs)
  {
    boolean bool1;
    if ((paramType2 instanceof Class))
    {
      Class localClass = (Class)paramType2;
      if ((paramType1 != null) || (localClass.getEnclosingClass() == null))
      {
        bool1 = true;
        .Gson.Preconditions.checkArgument(bool1);
        if (paramType1 != null)
        {
          bool1 = bool2;
          if (localClass.getEnclosingClass() == null) {}
        }
        else
        {
          bool1 = true;
        }
        .Gson.Preconditions.checkArgument(bool1);
      }
    }
    else
    {
      if (paramType1 != null) {
        break label160;
      }
    }
    label160:
    for (paramType1 = null;; paramType1 = .Gson.Types.canonicalize(paramType1))
    {
      ownerType = paramType1;
      rawType = .Gson.Types.canonicalize(paramType2);
      typeArguments = ((Type[])paramVarArgs.clone());
      int i = 0;
      while (i < typeArguments.length)
      {
        .Gson.Preconditions.checkNotNull(typeArguments[i]);
        .Gson.Types.access$000(typeArguments[i]);
        typeArguments[i] = .Gson.Types.canonicalize(typeArguments[i]);
        i += 1;
      }
      bool1 = false;
      break;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof ParameterizedType)) && (.Gson.Types.equals(this, (ParameterizedType)paramObject));
  }
  
  public Type[] getActualTypeArguments()
  {
    return (Type[])typeArguments.clone();
  }
  
  public Type getOwnerType()
  {
    return ownerType;
  }
  
  public Type getRawType()
  {
    return rawType;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(typeArguments) ^ rawType.hashCode() ^ .Gson.Types.access$100(ownerType);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder((typeArguments.length + 1) * 30);
    localStringBuilder.append(.Gson.Types.typeToString(rawType));
    if (typeArguments.length == 0) {
      return localStringBuilder.toString();
    }
    localStringBuilder.append("<").append(.Gson.Types.typeToString(typeArguments[0]));
    int i = 1;
    while (i < typeArguments.length)
    {
      localStringBuilder.append(", ").append(.Gson.Types.typeToString(typeArguments[i]));
      i += 1;
    }
    return ">";
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal..Gson.Types.ParameterizedTypeImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */