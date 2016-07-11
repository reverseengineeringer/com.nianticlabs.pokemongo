package com.google.gson.reflect;

import com.google.gson.internal..Gson.Preconditions;
import com.google.gson.internal..Gson.Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

public class TypeToken<T>
{
  final int hashCode;
  final Class<? super T> rawType;
  final Type type;
  
  protected TypeToken()
  {
    type = getSuperclassTypeParameter(getClass());
    rawType = .Gson.Types.getRawType(type);
    hashCode = type.hashCode();
  }
  
  TypeToken(Type paramType)
  {
    type = .Gson.Types.canonicalize((Type).Gson.Preconditions.checkNotNull(paramType));
    rawType = .Gson.Types.getRawType(type);
    hashCode = type.hashCode();
  }
  
  private static AssertionError buildUnexpectedTypeError(Type paramType, Class<?>... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder("Unexpected type. Expected one of: ");
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(paramVarArgs[i].getName()).append(", ");
      i += 1;
    }
    localStringBuilder.append("but got: ").append(paramType.getClass().getName()).append(", for type token: ").append(paramType.toString()).append('.');
    return new AssertionError(localStringBuilder.toString());
  }
  
  public static <T> TypeToken<T> get(Class<T> paramClass)
  {
    return new TypeToken(paramClass);
  }
  
  public static TypeToken<?> get(Type paramType)
  {
    return new TypeToken(paramType);
  }
  
  static Type getSuperclassTypeParameter(Class<?> paramClass)
  {
    paramClass = paramClass.getGenericSuperclass();
    if ((paramClass instanceof Class)) {
      throw new RuntimeException("Missing type parameter.");
    }
    return .Gson.Types.canonicalize(((ParameterizedType)paramClass).getActualTypeArguments()[0]);
  }
  
  private static boolean isAssignableFrom(Type paramType, GenericArrayType paramGenericArrayType)
  {
    Type localType = paramGenericArrayType.getGenericComponentType();
    if ((localType instanceof ParameterizedType))
    {
      paramGenericArrayType = paramType;
      if ((paramType instanceof GenericArrayType)) {
        paramGenericArrayType = ((GenericArrayType)paramType).getGenericComponentType();
      }
      for (;;)
      {
        return isAssignableFrom(paramGenericArrayType, (ParameterizedType)localType, new HashMap());
        if ((paramType instanceof Class))
        {
          for (paramType = (Class)paramType; paramType.isArray(); paramType = paramType.getComponentType()) {}
          paramGenericArrayType = paramType;
        }
      }
    }
    return true;
  }
  
  private static boolean isAssignableFrom(Type paramType, ParameterizedType paramParameterizedType, Map<String, Type> paramMap)
  {
    if (paramType == null) {
      return false;
    }
    if (paramParameterizedType.equals(paramType)) {
      return true;
    }
    Class localClass = .Gson.Types.getRawType(paramType);
    ParameterizedType localParameterizedType = null;
    if ((paramType instanceof ParameterizedType)) {
      localParameterizedType = (ParameterizedType)paramType;
    }
    if (localParameterizedType != null)
    {
      Type[] arrayOfType = localParameterizedType.getActualTypeArguments();
      TypeVariable[] arrayOfTypeVariable = localClass.getTypeParameters();
      i = 0;
      while (i < arrayOfType.length)
      {
        paramType = arrayOfType[i];
        TypeVariable localTypeVariable = arrayOfTypeVariable[i];
        while ((paramType instanceof TypeVariable)) {
          paramType = (Type)paramMap.get(((TypeVariable)paramType).getName());
        }
        paramMap.put(localTypeVariable.getName(), paramType);
        i += 1;
      }
      if (typeEquals(localParameterizedType, paramParameterizedType, paramMap)) {
        return true;
      }
    }
    paramType = localClass.getGenericInterfaces();
    int j = paramType.length;
    int i = 0;
    while (i < j)
    {
      if (isAssignableFrom(paramType[i], paramParameterizedType, new HashMap(paramMap))) {
        return true;
      }
      i += 1;
    }
    return isAssignableFrom(localClass.getGenericSuperclass(), paramParameterizedType, new HashMap(paramMap));
  }
  
  private static boolean matches(Type paramType1, Type paramType2, Map<String, Type> paramMap)
  {
    return (paramType2.equals(paramType1)) || (((paramType1 instanceof TypeVariable)) && (paramType2.equals(paramMap.get(((TypeVariable)paramType1).getName()))));
  }
  
  private static boolean typeEquals(ParameterizedType paramParameterizedType1, ParameterizedType paramParameterizedType2, Map<String, Type> paramMap)
  {
    int i;
    if (paramParameterizedType1.getRawType().equals(paramParameterizedType2.getRawType()))
    {
      paramParameterizedType1 = paramParameterizedType1.getActualTypeArguments();
      paramParameterizedType2 = paramParameterizedType2.getActualTypeArguments();
      i = 0;
    }
    while (i < paramParameterizedType1.length)
    {
      if (!matches(paramParameterizedType1[i], paramParameterizedType2[i], paramMap)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof TypeToken)) && (.Gson.Types.equals(type, type));
  }
  
  public final Class<? super T> getRawType()
  {
    return rawType;
  }
  
  public final Type getType()
  {
    return type;
  }
  
  public final int hashCode()
  {
    return hashCode;
  }
  
  @Deprecated
  public boolean isAssignableFrom(TypeToken<?> paramTypeToken)
  {
    return isAssignableFrom(paramTypeToken.getType());
  }
  
  @Deprecated
  public boolean isAssignableFrom(Class<?> paramClass)
  {
    return isAssignableFrom(paramClass);
  }
  
  @Deprecated
  public boolean isAssignableFrom(Type paramType)
  {
    if (paramType == null) {
      return false;
    }
    if (type.equals(paramType)) {
      return true;
    }
    if ((type instanceof Class)) {
      return rawType.isAssignableFrom(.Gson.Types.getRawType(paramType));
    }
    if ((type instanceof ParameterizedType)) {
      return isAssignableFrom(paramType, (ParameterizedType)type, new HashMap());
    }
    if ((type instanceof GenericArrayType))
    {
      if ((rawType.isAssignableFrom(.Gson.Types.getRawType(paramType))) && (isAssignableFrom(paramType, (GenericArrayType)type))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    throw buildUnexpectedTypeError(type, new Class[] { Class.class, ParameterizedType.class, GenericArrayType.class });
  }
  
  public final String toString()
  {
    return .Gson.Types.typeToString(type);
  }
}

/* Location:
 * Qualified Name:     com.google.gson.reflect.TypeToken
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */