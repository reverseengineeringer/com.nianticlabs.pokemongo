package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import java.util.Collection;
import java.util.Map;

public class SimpleType
  extends TypeBase
{
  private static final long serialVersionUID = 1L;
  protected final String[] _typeNames;
  protected final JavaType[] _typeParameters;
  protected final Class<?> _typeParametersFor;
  
  protected SimpleType(Class<?> paramClass)
  {
    this(paramClass, null, null, null, null, false, null);
  }
  
  protected SimpleType(Class<?> paramClass, int paramInt, Object paramObject1, Object paramObject2, boolean paramBoolean)
  {
    super(paramClass, paramInt, paramObject1, paramObject2, paramBoolean);
    _typeNames = null;
    _typeParameters = null;
    _typeParametersFor = paramClass;
  }
  
  @Deprecated
  protected SimpleType(Class<?> paramClass, String[] paramArrayOfString, JavaType[] paramArrayOfJavaType, Object paramObject1, Object paramObject2, boolean paramBoolean)
  {
    this(paramClass, paramArrayOfString, paramArrayOfJavaType, paramObject1, paramObject2, paramBoolean, null);
  }
  
  protected SimpleType(Class<?> paramClass1, String[] paramArrayOfString, JavaType[] paramArrayOfJavaType, Object paramObject1, Object paramObject2, boolean paramBoolean, Class<?> paramClass2)
  {
    super(paramClass1, 0, paramObject1, paramObject2, paramBoolean);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      _typeNames = null;
    }
    for (_typeParameters = null;; _typeParameters = paramArrayOfJavaType)
    {
      _typeParametersFor = paramClass2;
      return;
      _typeNames = paramArrayOfString;
    }
  }
  
  public static SimpleType construct(Class<?> paramClass)
  {
    if (Map.class.isAssignableFrom(paramClass)) {
      throw new IllegalArgumentException("Can not construct SimpleType for a Map (class: " + paramClass.getName() + ")");
    }
    if (Collection.class.isAssignableFrom(paramClass)) {
      throw new IllegalArgumentException("Can not construct SimpleType for a Collection (class: " + paramClass.getName() + ")");
    }
    if (paramClass.isArray()) {
      throw new IllegalArgumentException("Can not construct SimpleType for an array (class: " + paramClass.getName() + ")");
    }
    return new SimpleType(paramClass);
  }
  
  public static SimpleType constructUnsafe(Class<?> paramClass)
  {
    return new SimpleType(paramClass, null, null, null, null, false, null);
  }
  
  protected JavaType _narrow(Class<?> paramClass)
  {
    return new SimpleType(paramClass, _typeNames, _typeParameters, _valueHandler, _typeHandler, _asStatic, _typeParametersFor);
  }
  
  protected String buildCanonicalName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(_class.getName());
    if ((_typeParameters != null) && (_typeParameters.length > 0))
    {
      localStringBuilder.append('<');
      int j = 1;
      JavaType[] arrayOfJavaType = _typeParameters;
      int k = arrayOfJavaType.length;
      int i = 0;
      if (i < k)
      {
        JavaType localJavaType = arrayOfJavaType[i];
        if (j != 0) {
          j = 0;
        }
        for (;;)
        {
          localStringBuilder.append(localJavaType.toCanonical());
          i += 1;
          break;
          localStringBuilder.append(',');
        }
      }
      localStringBuilder.append('>');
    }
    return localStringBuilder.toString();
  }
  
  public JavaType containedType(int paramInt)
  {
    if ((paramInt < 0) || (_typeParameters == null) || (paramInt >= _typeParameters.length)) {
      return null;
    }
    return _typeParameters[paramInt];
  }
  
  public int containedTypeCount()
  {
    if (_typeParameters == null) {
      return 0;
    }
    return _typeParameters.length;
  }
  
  public String containedTypeName(int paramInt)
  {
    if ((paramInt < 0) || (_typeNames == null) || (paramInt >= _typeNames.length)) {
      return null;
    }
    return _typeNames[paramInt];
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    Object localObject;
    label92:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                bool1 = bool2;
              } while (paramObject == null);
              bool1 = bool2;
            } while (paramObject.getClass() != getClass());
            localObject = (SimpleType)paramObject;
            bool1 = bool2;
          } while (_class != _class);
          paramObject = _typeParameters;
          localObject = _typeParameters;
          if (paramObject != null) {
            break label92;
          }
          if (localObject == null) {
            break;
          }
          bool1 = bool2;
        } while (localObject.length != 0);
        return true;
        bool1 = bool2;
      } while (localObject == null);
      bool1 = bool2;
    } while (paramObject.length != localObject.length);
    int i = 0;
    int j = paramObject.length;
    for (;;)
    {
      if (i >= j) {
        break label147;
      }
      bool1 = bool2;
      if (!paramObject[i].equals(localObject[i])) {
        break;
      }
      i += 1;
    }
    label147:
    return true;
  }
  
  public StringBuilder getErasedSignature(StringBuilder paramStringBuilder)
  {
    return _classSignature(_class, paramStringBuilder, true);
  }
  
  public StringBuilder getGenericSignature(StringBuilder paramStringBuilder)
  {
    _classSignature(_class, paramStringBuilder, false);
    Object localObject = paramStringBuilder;
    if (_typeParameters != null)
    {
      paramStringBuilder.append('<');
      localObject = _typeParameters;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        paramStringBuilder = localObject[i].getGenericSignature(paramStringBuilder);
        i += 1;
      }
      paramStringBuilder.append('>');
      localObject = paramStringBuilder;
    }
    ((StringBuilder)localObject).append(';');
    return (StringBuilder)localObject;
  }
  
  public Class<?> getParameterSource()
  {
    return _typeParametersFor;
  }
  
  public boolean isContainerType()
  {
    return false;
  }
  
  public JavaType narrowContentsBy(Class<?> paramClass)
  {
    throw new IllegalArgumentException("Internal error: SimpleType.narrowContentsBy() should never be called");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(40);
    localStringBuilder.append("[simple type, class ").append(buildCanonicalName()).append(']');
    return localStringBuilder.toString();
  }
  
  public JavaType widenContentsBy(Class<?> paramClass)
  {
    throw new IllegalArgumentException("Internal error: SimpleType.widenContentsBy() should never be called");
  }
  
  public JavaType withContentTypeHandler(Object paramObject)
  {
    throw new IllegalArgumentException("Simple types have no content types; can not call withContenTypeHandler()");
  }
  
  public SimpleType withContentValueHandler(Object paramObject)
  {
    throw new IllegalArgumentException("Simple types have no content types; can not call withContenValueHandler()");
  }
  
  public SimpleType withStaticTyping()
  {
    if (_asStatic) {
      return this;
    }
    return new SimpleType(_class, _typeNames, _typeParameters, _valueHandler, _typeHandler, true, _typeParametersFor);
  }
  
  public SimpleType withTypeHandler(Object paramObject)
  {
    return new SimpleType(_class, _typeNames, _typeParameters, _valueHandler, paramObject, _asStatic, _typeParametersFor);
  }
  
  public SimpleType withValueHandler(Object paramObject)
  {
    if (paramObject == _valueHandler) {
      return this;
    }
    return new SimpleType(_class, _typeNames, _typeParameters, paramObject, _typeHandler, _asStatic, _typeParametersFor);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.type.SimpleType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */