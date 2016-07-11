package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder.Value;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdValueProperty;
import com.fasterxml.jackson.databind.deser.impl.ValueInjector;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.Annotations;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BeanDeserializerBuilder
{
  protected SettableAnyProperty _anySetter;
  protected HashMap<String, SettableBeanProperty> _backRefProperties;
  protected final BeanDescription _beanDesc;
  protected AnnotatedMethod _buildMethod;
  protected JsonPOJOBuilder.Value _builderConfig;
  protected final boolean _caseInsensitivePropertyComparison;
  protected final boolean _defaultViewInclusion;
  protected HashSet<String> _ignorableProps;
  protected boolean _ignoreAllUnknown;
  protected List<ValueInjector> _injectables;
  protected ObjectIdReader _objectIdReader;
  protected final Map<String, SettableBeanProperty> _properties = new LinkedHashMap();
  protected ValueInstantiator _valueInstantiator;
  
  public BeanDeserializerBuilder(BeanDescription paramBeanDescription, DeserializationConfig paramDeserializationConfig)
  {
    _beanDesc = paramBeanDescription;
    _defaultViewInclusion = paramDeserializationConfig.isEnabled(MapperFeature.DEFAULT_VIEW_INCLUSION);
    _caseInsensitivePropertyComparison = paramDeserializationConfig.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
  }
  
  protected BeanDeserializerBuilder(BeanDeserializerBuilder paramBeanDeserializerBuilder)
  {
    _beanDesc = _beanDesc;
    _defaultViewInclusion = _defaultViewInclusion;
    _caseInsensitivePropertyComparison = _caseInsensitivePropertyComparison;
    _properties.putAll(_properties);
    _injectables = _copy(_injectables);
    _backRefProperties = _copy(_backRefProperties);
    _ignorableProps = _ignorableProps;
    _valueInstantiator = _valueInstantiator;
    _objectIdReader = _objectIdReader;
    _anySetter = _anySetter;
    _ignoreAllUnknown = _ignoreAllUnknown;
    _buildMethod = _buildMethod;
    _builderConfig = _builderConfig;
  }
  
  private static HashMap<String, SettableBeanProperty> _copy(HashMap<String, SettableBeanProperty> paramHashMap)
  {
    if (paramHashMap == null) {
      return null;
    }
    return new HashMap(paramHashMap);
  }
  
  private static <T> List<T> _copy(List<T> paramList)
  {
    if (paramList == null) {
      return null;
    }
    return new ArrayList(paramList);
  }
  
  public void addBackReferenceProperty(String paramString, SettableBeanProperty paramSettableBeanProperty)
  {
    if (_backRefProperties == null) {
      _backRefProperties = new HashMap(4);
    }
    _backRefProperties.put(paramString, paramSettableBeanProperty);
    if (_properties != null) {
      _properties.remove(paramSettableBeanProperty.getName());
    }
  }
  
  public void addCreatorProperty(SettableBeanProperty paramSettableBeanProperty)
  {
    addProperty(paramSettableBeanProperty);
  }
  
  public void addIgnorable(String paramString)
  {
    if (_ignorableProps == null) {
      _ignorableProps = new HashSet();
    }
    _ignorableProps.add(paramString);
  }
  
  public void addInjectable(PropertyName paramPropertyName, JavaType paramJavaType, Annotations paramAnnotations, AnnotatedMember paramAnnotatedMember, Object paramObject)
  {
    if (_injectables == null) {
      _injectables = new ArrayList();
    }
    _injectables.add(new ValueInjector(paramPropertyName, paramJavaType, paramAnnotations, paramAnnotatedMember, paramObject));
  }
  
  public void addOrReplaceProperty(SettableBeanProperty paramSettableBeanProperty, boolean paramBoolean)
  {
    _properties.put(paramSettableBeanProperty.getName(), paramSettableBeanProperty);
  }
  
  public void addProperty(SettableBeanProperty paramSettableBeanProperty)
  {
    SettableBeanProperty localSettableBeanProperty = (SettableBeanProperty)_properties.put(paramSettableBeanProperty.getName(), paramSettableBeanProperty);
    if ((localSettableBeanProperty != null) && (localSettableBeanProperty != paramSettableBeanProperty)) {
      throw new IllegalArgumentException("Duplicate property '" + paramSettableBeanProperty.getName() + "' for " + _beanDesc.getType());
    }
  }
  
  public JsonDeserializer<?> build()
  {
    Object localObject = _properties.values();
    BeanPropertyMap localBeanPropertyMap = BeanPropertyMap.construct((Collection)localObject, _caseInsensitivePropertyComparison);
    localBeanPropertyMap.assignIndexes();
    if (!_defaultViewInclusion) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        localObject = ((Collection)localObject).iterator();
        do
        {
          bool2 = bool1;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (!((SettableBeanProperty)((Iterator)localObject).next()).hasViews());
        bool2 = true;
      }
      localObject = localBeanPropertyMap;
      if (_objectIdReader != null) {
        localObject = localBeanPropertyMap.withProperty(new ObjectIdValueProperty(_objectIdReader, PropertyMetadata.STD_REQUIRED));
      }
      return new BeanDeserializer(this, _beanDesc, (BeanPropertyMap)localObject, _backRefProperties, _ignorableProps, _ignoreAllUnknown, bool2);
    }
  }
  
  public AbstractDeserializer buildAbstract()
  {
    return new AbstractDeserializer(this, _beanDesc, _backRefProperties);
  }
  
  public JsonDeserializer<?> buildBuilderBased(JavaType paramJavaType, String paramString)
  {
    if (_buildMethod == null)
    {
      if (!paramString.isEmpty()) {
        throw new IllegalArgumentException("Builder class " + _beanDesc.getBeanClass().getName() + " does not have build method (name: '" + paramString + "')");
      }
    }
    else
    {
      paramString = _buildMethod.getRawReturnType();
      Class localClass = paramJavaType.getRawClass();
      if ((paramString != localClass) && (!paramString.isAssignableFrom(localClass)) && (!localClass.isAssignableFrom(paramString))) {
        throw new IllegalArgumentException("Build method '" + _buildMethod.getFullName() + " has bad return type (" + paramString.getName() + "), not compatible with POJO type (" + paramJavaType.getRawClass().getName() + ")");
      }
    }
    paramJavaType = _properties.values();
    paramString = BeanPropertyMap.construct(paramJavaType, _caseInsensitivePropertyComparison);
    paramString.assignIndexes();
    if (!_defaultViewInclusion) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        paramJavaType = paramJavaType.iterator();
        do
        {
          bool2 = bool1;
          if (!paramJavaType.hasNext()) {
            break;
          }
        } while (!((SettableBeanProperty)paramJavaType.next()).hasViews());
        bool2 = true;
      }
      paramJavaType = paramString;
      if (_objectIdReader != null) {
        paramJavaType = paramString.withProperty(new ObjectIdValueProperty(_objectIdReader, PropertyMetadata.STD_REQUIRED));
      }
      return new BuilderBasedDeserializer(this, _beanDesc, paramJavaType, _backRefProperties, _ignorableProps, _ignoreAllUnknown, bool2);
    }
  }
  
  public SettableBeanProperty findProperty(PropertyName paramPropertyName)
  {
    return (SettableBeanProperty)_properties.get(paramPropertyName.getSimpleName());
  }
  
  public SettableAnyProperty getAnySetter()
  {
    return _anySetter;
  }
  
  public AnnotatedMethod getBuildMethod()
  {
    return _buildMethod;
  }
  
  public JsonPOJOBuilder.Value getBuilderConfig()
  {
    return _builderConfig;
  }
  
  public List<ValueInjector> getInjectables()
  {
    return _injectables;
  }
  
  public ObjectIdReader getObjectIdReader()
  {
    return _objectIdReader;
  }
  
  public Iterator<SettableBeanProperty> getProperties()
  {
    return _properties.values().iterator();
  }
  
  public ValueInstantiator getValueInstantiator()
  {
    return _valueInstantiator;
  }
  
  public boolean hasProperty(PropertyName paramPropertyName)
  {
    return findProperty(paramPropertyName) != null;
  }
  
  public SettableBeanProperty removeProperty(PropertyName paramPropertyName)
  {
    return (SettableBeanProperty)_properties.remove(paramPropertyName.getSimpleName());
  }
  
  public void setAnySetter(SettableAnyProperty paramSettableAnyProperty)
  {
    if ((_anySetter != null) && (paramSettableAnyProperty != null)) {
      throw new IllegalStateException("_anySetter already set to non-null");
    }
    _anySetter = paramSettableAnyProperty;
  }
  
  public void setIgnoreUnknownProperties(boolean paramBoolean)
  {
    _ignoreAllUnknown = paramBoolean;
  }
  
  public void setObjectIdReader(ObjectIdReader paramObjectIdReader)
  {
    _objectIdReader = paramObjectIdReader;
  }
  
  public void setPOJOBuilder(AnnotatedMethod paramAnnotatedMethod, JsonPOJOBuilder.Value paramValue)
  {
    _buildMethod = paramAnnotatedMethod;
    _builderConfig = paramValue;
  }
  
  public void setValueInstantiator(ValueInstantiator paramValueInstantiator)
  {
    _valueInstantiator = paramValueInstantiator;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.BeanDeserializerBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */