package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import java.util.Map;

public class MapLikeType
  extends TypeBase
{
  private static final long serialVersionUID = 1L;
  protected final JavaType _keyType;
  protected final JavaType _valueType;
  
  protected MapLikeType(Class<?> paramClass, JavaType paramJavaType1, JavaType paramJavaType2, Object paramObject1, Object paramObject2, boolean paramBoolean)
  {
    super(paramClass, paramJavaType1.hashCode() ^ paramJavaType2.hashCode(), paramObject1, paramObject2, paramBoolean);
    _keyType = paramJavaType1;
    _valueType = paramJavaType2;
  }
  
  public static MapLikeType construct(Class<?> paramClass, JavaType paramJavaType1, JavaType paramJavaType2)
  {
    return new MapLikeType(paramClass, paramJavaType1, paramJavaType2, null, null, false);
  }
  
  protected JavaType _narrow(Class<?> paramClass)
  {
    return new MapLikeType(paramClass, _keyType, _valueType, _valueHandler, _typeHandler, _asStatic);
  }
  
  protected String buildCanonicalName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(_class.getName());
    if (_keyType != null)
    {
      localStringBuilder.append('<');
      localStringBuilder.append(_keyType.toCanonical());
      localStringBuilder.append(',');
      localStringBuilder.append(_valueType.toCanonical());
      localStringBuilder.append('>');
    }
    return localStringBuilder.toString();
  }
  
  public JavaType containedType(int paramInt)
  {
    if (paramInt == 0) {
      return _keyType;
    }
    if (paramInt == 1) {
      return _valueType;
    }
    return null;
  }
  
  public int containedTypeCount()
  {
    return 2;
  }
  
  public String containedTypeName(int paramInt)
  {
    if (paramInt == 0) {
      return "K";
    }
    if (paramInt == 1) {
      return "V";
    }
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (paramObject.getClass() != getClass()) {
        return false;
      }
      paramObject = (MapLikeType)paramObject;
    } while ((_class == _class) && (_keyType.equals(_keyType)) && (_valueType.equals(_valueType)));
    return false;
  }
  
  public JavaType getContentType()
  {
    return _valueType;
  }
  
  public StringBuilder getErasedSignature(StringBuilder paramStringBuilder)
  {
    return _classSignature(_class, paramStringBuilder, true);
  }
  
  public StringBuilder getGenericSignature(StringBuilder paramStringBuilder)
  {
    _classSignature(_class, paramStringBuilder, false);
    paramStringBuilder.append('<');
    _keyType.getGenericSignature(paramStringBuilder);
    _valueType.getGenericSignature(paramStringBuilder);
    paramStringBuilder.append(">;");
    return paramStringBuilder;
  }
  
  public JavaType getKeyType()
  {
    return _keyType;
  }
  
  public Class<?> getParameterSource()
  {
    return null;
  }
  
  public boolean isContainerType()
  {
    return true;
  }
  
  public boolean isMapLikeType()
  {
    return true;
  }
  
  public boolean isTrueMapType()
  {
    return Map.class.isAssignableFrom(_class);
  }
  
  public JavaType narrowContentsBy(Class<?> paramClass)
  {
    if (paramClass == _valueType.getRawClass()) {
      return this;
    }
    return new MapLikeType(_class, _keyType, _valueType.narrowBy(paramClass), _valueHandler, _typeHandler, _asStatic);
  }
  
  public JavaType narrowKey(Class<?> paramClass)
  {
    if (paramClass == _keyType.getRawClass()) {
      return this;
    }
    return new MapLikeType(_class, _keyType.narrowBy(paramClass), _valueType, _valueHandler, _typeHandler, _asStatic);
  }
  
  public String toString()
  {
    return "[map-like type; class " + _class.getName() + ", " + _keyType + " -> " + _valueType + "]";
  }
  
  public JavaType widenContentsBy(Class<?> paramClass)
  {
    if (paramClass == _valueType.getRawClass()) {
      return this;
    }
    return new MapLikeType(_class, _keyType, _valueType.widenBy(paramClass), _valueHandler, _typeHandler, _asStatic);
  }
  
  public JavaType widenKey(Class<?> paramClass)
  {
    if (paramClass == _keyType.getRawClass()) {
      return this;
    }
    return new MapLikeType(_class, _keyType.widenBy(paramClass), _valueType, _valueHandler, _typeHandler, _asStatic);
  }
  
  public MapLikeType withContentTypeHandler(Object paramObject)
  {
    return new MapLikeType(_class, _keyType, _valueType.withTypeHandler(paramObject), _valueHandler, _typeHandler, _asStatic);
  }
  
  public MapLikeType withContentValueHandler(Object paramObject)
  {
    return new MapLikeType(_class, _keyType, _valueType.withValueHandler(paramObject), _valueHandler, _typeHandler, _asStatic);
  }
  
  public MapLikeType withKeyTypeHandler(Object paramObject)
  {
    return new MapLikeType(_class, _keyType.withTypeHandler(paramObject), _valueType, _valueHandler, _typeHandler, _asStatic);
  }
  
  public MapLikeType withKeyValueHandler(Object paramObject)
  {
    return new MapLikeType(_class, _keyType.withValueHandler(paramObject), _valueType, _valueHandler, _typeHandler, _asStatic);
  }
  
  public MapLikeType withStaticTyping()
  {
    if (_asStatic) {
      return this;
    }
    return new MapLikeType(_class, _keyType, _valueType.withStaticTyping(), _valueHandler, _typeHandler, true);
  }
  
  public MapLikeType withTypeHandler(Object paramObject)
  {
    return new MapLikeType(_class, _keyType, _valueType, _valueHandler, paramObject, _asStatic);
  }
  
  public MapLikeType withValueHandler(Object paramObject)
  {
    return new MapLikeType(_class, _keyType, _valueType, paramObject, _typeHandler, _asStatic);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.type.MapLikeType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */