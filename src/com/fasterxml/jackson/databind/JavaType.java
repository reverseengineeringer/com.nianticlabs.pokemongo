package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.type.ResolvedType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public abstract class JavaType
  extends ResolvedType
  implements Serializable, Type
{
  private static final long serialVersionUID = 1L;
  protected final boolean _asStatic;
  protected final Class<?> _class;
  protected final int _hash;
  protected final Object _typeHandler;
  protected final Object _valueHandler;
  
  protected JavaType(Class<?> paramClass, int paramInt, Object paramObject1, Object paramObject2, boolean paramBoolean)
  {
    _class = paramClass;
    _hash = (paramClass.getName().hashCode() + paramInt);
    _valueHandler = paramObject1;
    _typeHandler = paramObject2;
    _asStatic = paramBoolean;
  }
  
  protected void _assertSubclass(Class<?> paramClass1, Class<?> paramClass2)
  {
    if (!_class.isAssignableFrom(paramClass1)) {
      throw new IllegalArgumentException("Class " + paramClass1.getName() + " is not assignable to " + _class.getName());
    }
  }
  
  protected abstract JavaType _narrow(Class<?> paramClass);
  
  protected JavaType _widen(Class<?> paramClass)
  {
    return _narrow(paramClass);
  }
  
  public JavaType containedType(int paramInt)
  {
    return null;
  }
  
  public int containedTypeCount()
  {
    return 0;
  }
  
  public String containedTypeName(int paramInt)
  {
    return null;
  }
  
  public JavaType containedTypeOrUnknown(int paramInt)
  {
    JavaType localJavaType2 = containedType(paramInt);
    JavaType localJavaType1 = localJavaType2;
    if (localJavaType2 == null) {
      localJavaType1 = TypeFactory.unknownType();
    }
    return localJavaType1;
  }
  
  public abstract boolean equals(Object paramObject);
  
  public JavaType forcedNarrowBy(Class<?> paramClass)
  {
    if (paramClass == _class) {
      return this;
    }
    Object localObject = _narrow(paramClass);
    paramClass = (Class<?>)localObject;
    if (_valueHandler != ((JavaType)localObject).getValueHandler()) {
      paramClass = ((JavaType)localObject).withValueHandler(_valueHandler);
    }
    localObject = paramClass;
    if (_typeHandler != paramClass.getTypeHandler()) {
      localObject = paramClass.withTypeHandler(_typeHandler);
    }
    return (JavaType)localObject;
  }
  
  public JavaType getContentType()
  {
    return null;
  }
  
  public String getErasedSignature()
  {
    StringBuilder localStringBuilder = new StringBuilder(40);
    getErasedSignature(localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public abstract StringBuilder getErasedSignature(StringBuilder paramStringBuilder);
  
  public String getGenericSignature()
  {
    StringBuilder localStringBuilder = new StringBuilder(40);
    getGenericSignature(localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public abstract StringBuilder getGenericSignature(StringBuilder paramStringBuilder);
  
  public JavaType getKeyType()
  {
    return null;
  }
  
  public abstract Class<?> getParameterSource();
  
  public final Class<?> getRawClass()
  {
    return _class;
  }
  
  public JavaType getReferencedType()
  {
    return null;
  }
  
  public <T> T getTypeHandler()
  {
    return (T)_typeHandler;
  }
  
  public <T> T getValueHandler()
  {
    return (T)_valueHandler;
  }
  
  public boolean hasGenericTypes()
  {
    return containedTypeCount() > 0;
  }
  
  public final boolean hasRawClass(Class<?> paramClass)
  {
    return _class == paramClass;
  }
  
  public boolean hasValueHandler()
  {
    return _valueHandler != null;
  }
  
  public final int hashCode()
  {
    return _hash;
  }
  
  public boolean isAbstract()
  {
    return Modifier.isAbstract(_class.getModifiers());
  }
  
  public boolean isArrayType()
  {
    return false;
  }
  
  public boolean isCollectionLikeType()
  {
    return false;
  }
  
  public boolean isConcrete()
  {
    if ((_class.getModifiers() & 0x600) == 0) {
      return true;
    }
    return _class.isPrimitive();
  }
  
  public abstract boolean isContainerType();
  
  public final boolean isEnumType()
  {
    return _class.isEnum();
  }
  
  public final boolean isFinal()
  {
    return Modifier.isFinal(_class.getModifiers());
  }
  
  public final boolean isInterface()
  {
    return _class.isInterface();
  }
  
  public final boolean isJavaLangObject()
  {
    return _class == Object.class;
  }
  
  public boolean isMapLikeType()
  {
    return false;
  }
  
  public final boolean isPrimitive()
  {
    return _class.isPrimitive();
  }
  
  public boolean isThrowable()
  {
    return Throwable.class.isAssignableFrom(_class);
  }
  
  public final boolean isTypeOrSubTypeOf(Class<?> paramClass)
  {
    return (_class == paramClass) || (paramClass.isAssignableFrom(_class));
  }
  
  public JavaType narrowBy(Class<?> paramClass)
  {
    if (paramClass == _class) {
      return this;
    }
    _assertSubclass(paramClass, _class);
    Object localObject = _narrow(paramClass);
    paramClass = (Class<?>)localObject;
    if (_valueHandler != ((JavaType)localObject).getValueHandler()) {
      paramClass = ((JavaType)localObject).withValueHandler(_valueHandler);
    }
    localObject = paramClass;
    if (_typeHandler != paramClass.getTypeHandler()) {
      localObject = paramClass.withTypeHandler(_typeHandler);
    }
    return (JavaType)localObject;
  }
  
  public abstract JavaType narrowContentsBy(Class<?> paramClass);
  
  public abstract String toString();
  
  public final boolean useStaticType()
  {
    return _asStatic;
  }
  
  public JavaType widenBy(Class<?> paramClass)
  {
    if (paramClass == _class) {
      return this;
    }
    _assertSubclass(_class, paramClass);
    return _widen(paramClass);
  }
  
  public abstract JavaType widenContentsBy(Class<?> paramClass);
  
  public abstract JavaType withContentTypeHandler(Object paramObject);
  
  public abstract JavaType withContentValueHandler(Object paramObject);
  
  public abstract JavaType withStaticTyping();
  
  public abstract JavaType withTypeHandler(Object paramObject);
  
  public abstract JavaType withValueHandler(Object paramObject);
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.JavaType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */