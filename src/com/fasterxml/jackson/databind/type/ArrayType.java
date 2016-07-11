package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import java.lang.reflect.Array;

public final class ArrayType
  extends TypeBase
{
  private static final long serialVersionUID = 1L;
  protected final JavaType _componentType;
  protected final Object _emptyArray;
  
  protected ArrayType(JavaType paramJavaType, Object paramObject1, Object paramObject2, Object paramObject3, boolean paramBoolean)
  {
    super(paramObject1.getClass(), paramJavaType.hashCode(), paramObject2, paramObject3, paramBoolean);
    _componentType = paramJavaType;
    _emptyArray = paramObject1;
  }
  
  public static ArrayType construct(JavaType paramJavaType, Object paramObject1, Object paramObject2)
  {
    return new ArrayType(paramJavaType, Array.newInstance(paramJavaType.getRawClass(), 0), null, null, false);
  }
  
  protected JavaType _narrow(Class<?> paramClass)
  {
    if (!paramClass.isArray()) {
      throw new IllegalArgumentException("Incompatible narrowing operation: trying to narrow " + toString() + " to class " + paramClass.getName());
    }
    paramClass = paramClass.getComponentType();
    return construct(TypeFactory.defaultInstance().constructType(paramClass), _valueHandler, _typeHandler);
  }
  
  protected String buildCanonicalName()
  {
    return _class.getName();
  }
  
  public JavaType containedType(int paramInt)
  {
    if (paramInt == 0) {
      return _componentType;
    }
    return null;
  }
  
  public int containedTypeCount()
  {
    return 1;
  }
  
  public String containedTypeName(int paramInt)
  {
    if (paramInt == 0) {
      return "E";
    }
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == null);
      bool1 = bool2;
    } while (paramObject.getClass() != getClass());
    paramObject = (ArrayType)paramObject;
    return _componentType.equals(_componentType);
  }
  
  public JavaType getContentType()
  {
    return _componentType;
  }
  
  public StringBuilder getErasedSignature(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append('[');
    return _componentType.getErasedSignature(paramStringBuilder);
  }
  
  public StringBuilder getGenericSignature(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append('[');
    return _componentType.getGenericSignature(paramStringBuilder);
  }
  
  public Class<?> getParameterSource()
  {
    return null;
  }
  
  public boolean hasGenericTypes()
  {
    return _componentType.hasGenericTypes();
  }
  
  public boolean isAbstract()
  {
    return false;
  }
  
  public boolean isArrayType()
  {
    return true;
  }
  
  public boolean isConcrete()
  {
    return true;
  }
  
  public boolean isContainerType()
  {
    return true;
  }
  
  public JavaType narrowContentsBy(Class<?> paramClass)
  {
    if (paramClass == _componentType.getRawClass()) {
      return this;
    }
    return construct(_componentType.narrowBy(paramClass), _valueHandler, _typeHandler);
  }
  
  public String toString()
  {
    return "[array type, component type: " + _componentType + "]";
  }
  
  public JavaType widenContentsBy(Class<?> paramClass)
  {
    if (paramClass == _componentType.getRawClass()) {
      return this;
    }
    return construct(_componentType.widenBy(paramClass), _valueHandler, _typeHandler);
  }
  
  public ArrayType withContentTypeHandler(Object paramObject)
  {
    if (paramObject == _componentType.getTypeHandler()) {
      return this;
    }
    return new ArrayType(_componentType.withTypeHandler(paramObject), _emptyArray, _valueHandler, _typeHandler, _asStatic);
  }
  
  public ArrayType withContentValueHandler(Object paramObject)
  {
    if (paramObject == _componentType.getValueHandler()) {
      return this;
    }
    return new ArrayType(_componentType.withValueHandler(paramObject), _emptyArray, _valueHandler, _typeHandler, _asStatic);
  }
  
  public ArrayType withStaticTyping()
  {
    if (_asStatic) {
      return this;
    }
    return new ArrayType(_componentType.withStaticTyping(), _emptyArray, _valueHandler, _typeHandler, true);
  }
  
  public ArrayType withTypeHandler(Object paramObject)
  {
    if (paramObject == _typeHandler) {
      return this;
    }
    return new ArrayType(_componentType, _emptyArray, _valueHandler, paramObject, _asStatic);
  }
  
  public ArrayType withValueHandler(Object paramObject)
  {
    if (paramObject == _valueHandler) {
      return this;
    }
    return new ArrayType(_componentType, _emptyArray, paramObject, _typeHandler, _asStatic);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.type.ArrayType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */