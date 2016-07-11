package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;

public class ReferenceType
  extends SimpleType
{
  private static final long serialVersionUID = 1L;
  protected final JavaType _referencedType;
  
  protected ReferenceType(Class<?> paramClass, JavaType paramJavaType, Object paramObject1, Object paramObject2, boolean paramBoolean)
  {
    super(paramClass, paramJavaType.hashCode(), paramObject1, paramObject2, paramBoolean);
    _referencedType = paramJavaType;
  }
  
  public static ReferenceType construct(Class<?> paramClass, JavaType paramJavaType, Object paramObject1, Object paramObject2)
  {
    return new ReferenceType(paramClass, paramJavaType, null, null, false);
  }
  
  protected JavaType _narrow(Class<?> paramClass)
  {
    return new ReferenceType(paramClass, _referencedType, _valueHandler, _typeHandler, _asStatic);
  }
  
  protected String buildCanonicalName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(_class.getName());
    localStringBuilder.append('<');
    localStringBuilder.append(_referencedType.toCanonical());
    return localStringBuilder.toString();
  }
  
  public JavaType containedType(int paramInt)
  {
    if (paramInt == 0) {
      return _referencedType;
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
      return "T";
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
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramObject == null);
        bool1 = bool2;
      } while (paramObject.getClass() != getClass());
      paramObject = (ReferenceType)paramObject;
      bool1 = bool2;
    } while (_class != _class);
    return _referencedType.equals(_referencedType);
  }
  
  public StringBuilder getErasedSignature(StringBuilder paramStringBuilder)
  {
    return _classSignature(_class, paramStringBuilder, true);
  }
  
  public StringBuilder getGenericSignature(StringBuilder paramStringBuilder)
  {
    _classSignature(_class, paramStringBuilder, false);
    paramStringBuilder.append('<');
    paramStringBuilder = _referencedType.getGenericSignature(paramStringBuilder);
    paramStringBuilder.append(';');
    return paramStringBuilder;
  }
  
  public Class<?> getParameterSource()
  {
    return _class;
  }
  
  public JavaType getReferencedType()
  {
    return _referencedType;
  }
  
  public boolean isReferenceType()
  {
    return true;
  }
  
  public String toString()
  {
    return 40 + "[reference type, class " + buildCanonicalName() + '<' + _referencedType + '>' + ']';
  }
  
  public ReferenceType withContentTypeHandler(Object paramObject)
  {
    if (paramObject == _referencedType.getTypeHandler()) {
      return this;
    }
    return new ReferenceType(_class, _referencedType.withTypeHandler(paramObject), _valueHandler, _typeHandler, _asStatic);
  }
  
  public ReferenceType withContentValueHandler(Object paramObject)
  {
    if (paramObject == _referencedType.getValueHandler()) {
      return this;
    }
    return new ReferenceType(_class, _referencedType.withValueHandler(paramObject), _valueHandler, _typeHandler, _asStatic);
  }
  
  public ReferenceType withStaticTyping()
  {
    if (_asStatic) {
      return this;
    }
    return new ReferenceType(_class, _referencedType.withStaticTyping(), _valueHandler, _typeHandler, true);
  }
  
  public ReferenceType withTypeHandler(Object paramObject)
  {
    if (paramObject == _typeHandler) {
      return this;
    }
    return new ReferenceType(_class, _referencedType, _valueHandler, paramObject, _asStatic);
  }
  
  public ReferenceType withValueHandler(Object paramObject)
  {
    if (paramObject == _valueHandler) {
      return this;
    }
    return new ReferenceType(_class, _referencedType, paramObject, _typeHandler, _asStatic);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.type.ReferenceType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */