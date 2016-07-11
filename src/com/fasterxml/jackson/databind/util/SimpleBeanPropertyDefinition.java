package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class SimpleBeanPropertyDefinition
  extends BeanPropertyDefinition
{
  protected final PropertyName _fullName;
  protected final JsonInclude.Include _inclusion;
  protected final AnnotationIntrospector _introspector;
  protected final AnnotatedMember _member;
  protected final PropertyMetadata _metadata;
  @Deprecated
  protected final String _name;
  
  @Deprecated
  public SimpleBeanPropertyDefinition(AnnotatedMember paramAnnotatedMember)
  {
    this(paramAnnotatedMember, paramAnnotatedMember.getName(), null);
  }
  
  protected SimpleBeanPropertyDefinition(AnnotatedMember paramAnnotatedMember, PropertyName paramPropertyName, AnnotationIntrospector paramAnnotationIntrospector, PropertyMetadata paramPropertyMetadata, JsonInclude.Include paramInclude)
  {
    _introspector = paramAnnotationIntrospector;
    _member = paramAnnotatedMember;
    _fullName = paramPropertyName;
    _name = paramPropertyName.getSimpleName();
    paramAnnotatedMember = paramPropertyMetadata;
    if (paramPropertyMetadata == null) {
      paramAnnotatedMember = PropertyMetadata.STD_OPTIONAL;
    }
    _metadata = paramAnnotatedMember;
    _inclusion = paramInclude;
  }
  
  @Deprecated
  public SimpleBeanPropertyDefinition(AnnotatedMember paramAnnotatedMember, String paramString)
  {
    this(paramAnnotatedMember, new PropertyName(paramString), null, null, null);
  }
  
  @Deprecated
  protected SimpleBeanPropertyDefinition(AnnotatedMember paramAnnotatedMember, String paramString, AnnotationIntrospector paramAnnotationIntrospector)
  {
    this(paramAnnotatedMember, new PropertyName(paramString), paramAnnotationIntrospector, null, null);
  }
  
  public static SimpleBeanPropertyDefinition construct(MapperConfig<?> paramMapperConfig, AnnotatedMember paramAnnotatedMember)
  {
    PropertyName localPropertyName = PropertyName.construct(paramAnnotatedMember.getName());
    if (paramMapperConfig == null) {}
    for (paramMapperConfig = null;; paramMapperConfig = paramMapperConfig.getAnnotationIntrospector()) {
      return new SimpleBeanPropertyDefinition(paramAnnotatedMember, localPropertyName, paramMapperConfig, null, null);
    }
  }
  
  public static SimpleBeanPropertyDefinition construct(MapperConfig<?> paramMapperConfig, AnnotatedMember paramAnnotatedMember, PropertyName paramPropertyName)
  {
    return construct(paramMapperConfig, paramAnnotatedMember, paramPropertyName, null, null);
  }
  
  public static SimpleBeanPropertyDefinition construct(MapperConfig<?> paramMapperConfig, AnnotatedMember paramAnnotatedMember, PropertyName paramPropertyName, PropertyMetadata paramPropertyMetadata, JsonInclude.Include paramInclude)
  {
    if (paramMapperConfig == null) {}
    for (paramMapperConfig = null;; paramMapperConfig = paramMapperConfig.getAnnotationIntrospector()) {
      return new SimpleBeanPropertyDefinition(paramAnnotatedMember, paramPropertyName, paramMapperConfig, paramPropertyMetadata, paramInclude);
    }
  }
  
  @Deprecated
  public static SimpleBeanPropertyDefinition construct(MapperConfig<?> paramMapperConfig, AnnotatedMember paramAnnotatedMember, String paramString)
  {
    paramString = PropertyName.construct(paramString);
    if (paramMapperConfig == null) {}
    for (paramMapperConfig = null;; paramMapperConfig = paramMapperConfig.getAnnotationIntrospector()) {
      return new SimpleBeanPropertyDefinition(paramAnnotatedMember, paramString, paramMapperConfig, null, null);
    }
  }
  
  public JsonInclude.Include findInclusion()
  {
    return _inclusion;
  }
  
  public AnnotatedMember getAccessor()
  {
    AnnotatedMethod localAnnotatedMethod = getGetter();
    Object localObject = localAnnotatedMethod;
    if (localAnnotatedMethod == null) {
      localObject = getField();
    }
    return (AnnotatedMember)localObject;
  }
  
  public AnnotatedParameter getConstructorParameter()
  {
    if ((_member instanceof AnnotatedParameter)) {
      return (AnnotatedParameter)_member;
    }
    return null;
  }
  
  public Iterator<AnnotatedParameter> getConstructorParameters()
  {
    AnnotatedParameter localAnnotatedParameter = getConstructorParameter();
    if (localAnnotatedParameter == null) {
      return EmptyIterator.instance();
    }
    return Collections.singleton(localAnnotatedParameter).iterator();
  }
  
  public AnnotatedField getField()
  {
    if ((_member instanceof AnnotatedField)) {
      return (AnnotatedField)_member;
    }
    return null;
  }
  
  public PropertyName getFullName()
  {
    return _fullName;
  }
  
  public AnnotatedMethod getGetter()
  {
    if (((_member instanceof AnnotatedMethod)) && (((AnnotatedMethod)_member).getParameterCount() == 0)) {
      return (AnnotatedMethod)_member;
    }
    return null;
  }
  
  public String getInternalName()
  {
    return getName();
  }
  
  public PropertyMetadata getMetadata()
  {
    return _metadata;
  }
  
  public AnnotatedMember getMutator()
  {
    Object localObject2 = getConstructorParameter();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = getSetter();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = getField();
      }
    }
    return (AnnotatedMember)localObject1;
  }
  
  public String getName()
  {
    return _fullName.getSimpleName();
  }
  
  public AnnotatedMember getNonConstructorMutator()
  {
    AnnotatedMethod localAnnotatedMethod = getSetter();
    Object localObject = localAnnotatedMethod;
    if (localAnnotatedMethod == null) {
      localObject = getField();
    }
    return (AnnotatedMember)localObject;
  }
  
  public AnnotatedMember getPrimaryMember()
  {
    return _member;
  }
  
  public AnnotatedMethod getSetter()
  {
    if (((_member instanceof AnnotatedMethod)) && (((AnnotatedMethod)_member).getParameterCount() == 1)) {
      return (AnnotatedMethod)_member;
    }
    return null;
  }
  
  public PropertyName getWrapperName()
  {
    if ((_introspector == null) && (_member != null)) {
      return null;
    }
    return _introspector.findWrapperName(_member);
  }
  
  public boolean hasConstructorParameter()
  {
    return _member instanceof AnnotatedParameter;
  }
  
  public boolean hasField()
  {
    return _member instanceof AnnotatedField;
  }
  
  public boolean hasGetter()
  {
    return getGetter() != null;
  }
  
  public boolean hasName(PropertyName paramPropertyName)
  {
    return _fullName.equals(paramPropertyName);
  }
  
  public boolean hasSetter()
  {
    return getSetter() != null;
  }
  
  public boolean isExplicitlyIncluded()
  {
    return false;
  }
  
  public boolean isExplicitlyNamed()
  {
    return false;
  }
  
  public BeanPropertyDefinition withInclusion(JsonInclude.Include paramInclude)
  {
    if (_inclusion == paramInclude) {
      return this;
    }
    return new SimpleBeanPropertyDefinition(_member, _fullName, _introspector, _metadata, paramInclude);
  }
  
  public BeanPropertyDefinition withMetadata(PropertyMetadata paramPropertyMetadata)
  {
    if (paramPropertyMetadata.equals(_metadata)) {
      return this;
    }
    return new SimpleBeanPropertyDefinition(_member, _fullName, _introspector, paramPropertyMetadata, _inclusion);
  }
  
  public BeanPropertyDefinition withName(PropertyName paramPropertyName)
  {
    if (_fullName.equals(paramPropertyName)) {
      return this;
    }
    return new SimpleBeanPropertyDefinition(_member, paramPropertyName, _introspector, _metadata, _inclusion);
  }
  
  @Deprecated
  public BeanPropertyDefinition withName(String paramString)
  {
    return withSimpleName(paramString);
  }
  
  public BeanPropertyDefinition withSimpleName(String paramString)
  {
    if ((_fullName.hasSimpleName(paramString)) && (!_fullName.hasNamespace())) {
      return this;
    }
    return new SimpleBeanPropertyDefinition(_member, new PropertyName(paramString), _introspector, _metadata, _inclusion);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.util.SimpleBeanPropertyDefinition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */