package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.fasterxml.jackson.annotation.SimpleObjectIdResolver;
import com.fasterxml.jackson.databind.PropertyName;

public class ObjectIdInfo
{
  protected final boolean _alwaysAsId;
  protected final Class<? extends ObjectIdGenerator<?>> _generator;
  protected final PropertyName _propertyName;
  protected final Class<? extends ObjectIdResolver> _resolver;
  protected final Class<?> _scope;
  
  @Deprecated
  public ObjectIdInfo(PropertyName paramPropertyName, Class<?> paramClass, Class<? extends ObjectIdGenerator<?>> paramClass1)
  {
    this(paramPropertyName, paramClass, paramClass1, false);
  }
  
  public ObjectIdInfo(PropertyName paramPropertyName, Class<?> paramClass, Class<? extends ObjectIdGenerator<?>> paramClass1, Class<? extends ObjectIdResolver> paramClass2)
  {
    this(paramPropertyName, paramClass, paramClass1, false, paramClass2);
  }
  
  protected ObjectIdInfo(PropertyName paramPropertyName, Class<?> paramClass, Class<? extends ObjectIdGenerator<?>> paramClass1, boolean paramBoolean)
  {
    this(paramPropertyName, paramClass, paramClass1, paramBoolean, SimpleObjectIdResolver.class);
  }
  
  protected ObjectIdInfo(PropertyName paramPropertyName, Class<?> paramClass, Class<? extends ObjectIdGenerator<?>> paramClass1, boolean paramBoolean, Class<? extends ObjectIdResolver> paramClass2)
  {
    _propertyName = paramPropertyName;
    _scope = paramClass;
    _generator = paramClass1;
    _alwaysAsId = paramBoolean;
    paramPropertyName = paramClass2;
    if (paramClass2 == null) {
      paramPropertyName = SimpleObjectIdResolver.class;
    }
    _resolver = paramPropertyName;
  }
  
  @Deprecated
  public ObjectIdInfo(String paramString, Class<?> paramClass, Class<? extends ObjectIdGenerator<?>> paramClass1)
  {
    this(new PropertyName(paramString), paramClass, paramClass1, false);
  }
  
  public boolean getAlwaysAsId()
  {
    return _alwaysAsId;
  }
  
  public Class<? extends ObjectIdGenerator<?>> getGeneratorType()
  {
    return _generator;
  }
  
  public PropertyName getPropertyName()
  {
    return _propertyName;
  }
  
  public Class<? extends ObjectIdResolver> getResolverType()
  {
    return _resolver;
  }
  
  public Class<?> getScope()
  {
    return _scope;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("ObjectIdInfo: propName=").append(_propertyName).append(", scope=");
    if (_scope == null)
    {
      str = "null";
      localStringBuilder = localStringBuilder.append(str).append(", generatorType=");
      if (_generator != null) {
        break label88;
      }
    }
    label88:
    for (String str = "null";; str = _generator.getName())
    {
      return str + ", alwaysAsId=" + _alwaysAsId;
      str = _scope.getName();
      break;
    }
  }
  
  public ObjectIdInfo withAlwaysAsId(boolean paramBoolean)
  {
    if (_alwaysAsId == paramBoolean) {
      return this;
    }
    return new ObjectIdInfo(_propertyName, _scope, _generator, paramBoolean, _resolver);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.introspect.ObjectIdInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */