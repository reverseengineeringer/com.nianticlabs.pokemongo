package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class POJOPropertiesCollector
{
  protected final AnnotationIntrospector _annotationIntrospector;
  protected LinkedList<AnnotatedMember> _anyGetters;
  protected LinkedList<AnnotatedMethod> _anySetters;
  protected final AnnotatedClass _classDef;
  protected boolean _collected;
  protected final MapperConfig<?> _config;
  protected LinkedList<POJOPropertyBuilder> _creatorProperties;
  protected final boolean _forSerialization;
  protected HashSet<String> _ignoredPropertyNames;
  protected LinkedHashMap<Object, AnnotatedMember> _injectables;
  protected LinkedList<AnnotatedMethod> _jsonValueGetters;
  protected final String _mutatorPrefix;
  protected LinkedHashMap<String, POJOPropertyBuilder> _properties;
  protected final boolean _stdBeanNaming;
  protected final JavaType _type;
  protected final VisibilityChecker<?> _visibilityChecker;
  
  protected POJOPropertiesCollector(MapperConfig<?> paramMapperConfig, boolean paramBoolean, JavaType paramJavaType, AnnotatedClass paramAnnotatedClass, String paramString)
  {
    _config = paramMapperConfig;
    _stdBeanNaming = paramMapperConfig.isEnabled(MapperFeature.USE_STD_BEAN_NAMING);
    _forSerialization = paramBoolean;
    _type = paramJavaType;
    _classDef = paramAnnotatedClass;
    paramJavaType = paramString;
    if (paramString == null) {
      paramJavaType = "set";
    }
    _mutatorPrefix = paramJavaType;
    if (paramMapperConfig.isAnnotationProcessingEnabled()) {}
    for (paramMapperConfig = _config.getAnnotationIntrospector();; paramMapperConfig = null)
    {
      _annotationIntrospector = paramMapperConfig;
      if (_annotationIntrospector != null) {
        break;
      }
      _visibilityChecker = _config.getDefaultVisibilityChecker();
      return;
    }
    _visibilityChecker = _annotationIntrospector.findAutoDetectVisibility(paramAnnotatedClass, _config.getDefaultVisibilityChecker());
  }
  
  private void _collectIgnorals(String paramString)
  {
    if (!_forSerialization)
    {
      if (_ignoredPropertyNames == null) {
        _ignoredPropertyNames = new HashSet();
      }
      _ignoredPropertyNames.add(paramString);
    }
  }
  
  private PropertyNamingStrategy _findNamingStrategy()
  {
    if (_annotationIntrospector == null) {}
    for (Object localObject1 = null; localObject1 == null; localObject1 = _annotationIntrospector.findNamingStrategy(_classDef)) {
      return _config.getPropertyNamingStrategy();
    }
    if ((localObject1 instanceof PropertyNamingStrategy)) {
      return (PropertyNamingStrategy)localObject1;
    }
    if (!(localObject1 instanceof Class)) {
      throw new IllegalStateException("AnnotationIntrospector returned PropertyNamingStrategy definition of type " + localObject1.getClass().getName() + "; expected type PropertyNamingStrategy or Class<PropertyNamingStrategy> instead");
    }
    localObject1 = (Class)localObject1;
    if (!PropertyNamingStrategy.class.isAssignableFrom((Class)localObject1)) {
      throw new IllegalStateException("AnnotationIntrospector returned Class " + ((Class)localObject1).getName() + "; expected Class<PropertyNamingStrategy>");
    }
    Object localObject2 = _config.getHandlerInstantiator();
    if (localObject2 != null)
    {
      localObject2 = ((HandlerInstantiator)localObject2).namingStrategyInstance(_config, _classDef, (Class)localObject1);
      if (localObject2 != null) {
        return (PropertyNamingStrategy)localObject2;
      }
    }
    return (PropertyNamingStrategy)ClassUtil.createInstance((Class)localObject1, _config.canOverrideAccessModifiers());
  }
  
  private PropertyName _propNameFromSimple(String paramString)
  {
    return PropertyName.construct(paramString, null);
  }
  
  protected void _addCreatorParam(Map<String, POJOPropertyBuilder> paramMap, AnnotatedParameter paramAnnotatedParameter)
  {
    Object localObject2 = _annotationIntrospector.findImplicitPropertyName(paramAnnotatedParameter);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = _annotationIntrospector.findNameForDeserialization(paramAnnotatedParameter);
    boolean bool;
    if ((localObject2 != null) && (!((PropertyName)localObject2).isEmpty()))
    {
      bool = true;
      if (bool) {
        break label87;
      }
      if (!((String)localObject1).isEmpty()) {
        break label66;
      }
    }
    label66:
    while (!_annotationIntrospector.hasCreatorAnnotation(paramAnnotatedParameter.getOwner()))
    {
      return;
      bool = false;
      break;
    }
    localObject2 = PropertyName.construct((String)localObject1);
    label87:
    if ((bool) && (((String)localObject1).isEmpty())) {}
    for (paramMap = _property(paramMap, (PropertyName)localObject2);; paramMap = _property(paramMap, (String)localObject1))
    {
      paramMap.addCtor(paramAnnotatedParameter, (PropertyName)localObject2, bool, true, false);
      _creatorProperties.add(paramMap);
      return;
    }
  }
  
  protected void _addCreators(Map<String, POJOPropertyBuilder> paramMap)
  {
    if (_annotationIntrospector != null)
    {
      Iterator localIterator = _classDef.getConstructors().iterator();
      Object localObject;
      int i;
      int j;
      while (localIterator.hasNext())
      {
        localObject = (AnnotatedConstructor)localIterator.next();
        if (_creatorProperties == null) {
          _creatorProperties = new LinkedList();
        }
        i = 0;
        j = ((AnnotatedConstructor)localObject).getParameterCount();
        while (i < j)
        {
          _addCreatorParam(paramMap, ((AnnotatedConstructor)localObject).getParameter(i));
          i += 1;
        }
      }
      localIterator = _classDef.getStaticMethods().iterator();
      while (localIterator.hasNext())
      {
        localObject = (AnnotatedMethod)localIterator.next();
        if (_creatorProperties == null) {
          _creatorProperties = new LinkedList();
        }
        i = 0;
        j = ((AnnotatedMethod)localObject).getParameterCount();
        while (i < j)
        {
          _addCreatorParam(paramMap, ((AnnotatedMethod)localObject).getParameter(i));
          i += 1;
        }
      }
    }
  }
  
  protected void _addFields(Map<String, POJOPropertyBuilder> paramMap)
  {
    AnnotationIntrospector localAnnotationIntrospector = _annotationIntrospector;
    int i;
    boolean bool6;
    label54:
    AnnotatedField localAnnotatedField;
    Object localObject1;
    label84:
    Object localObject2;
    label108:
    boolean bool1;
    label115:
    Object localObject3;
    boolean bool3;
    if ((!_forSerialization) && (!_config.isEnabled(MapperFeature.ALLOW_FINAL_FIELDS_AS_MUTATORS)))
    {
      i = 1;
      bool6 = _config.isEnabled(MapperFeature.PROPAGATE_TRANSIENT_MARKER);
      Iterator localIterator = _classDef.fields().iterator();
      if (!localIterator.hasNext()) {
        return;
      }
      localAnnotatedField = (AnnotatedField)localIterator.next();
      if (localAnnotationIntrospector != null) {
        break label283;
      }
      localObject1 = null;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localAnnotatedField.getName();
      }
      if (localAnnotationIntrospector != null) {
        break label295;
      }
      localObject1 = null;
      if (localObject1 == null) {
        break label326;
      }
      bool1 = true;
      localObject3 = localObject1;
      bool3 = bool1;
      if (bool1)
      {
        localObject3 = localObject1;
        bool3 = bool1;
        if (((PropertyName)localObject1).isEmpty())
        {
          localObject3 = _propNameFromSimple((String)localObject2);
          bool3 = false;
        }
      }
      if (localObject3 == null) {
        break label331;
      }
      bool2 = true;
      label160:
      bool1 = bool2;
      if (!bool2) {
        bool1 = _visibilityChecker.isFieldVisible(localAnnotatedField);
      }
      if ((localAnnotationIntrospector == null) || (!localAnnotationIntrospector.hasIgnoreMarker(localAnnotatedField))) {
        break label337;
      }
    }
    label283:
    label295:
    label326:
    label331:
    label337:
    for (boolean bool2 = true;; bool2 = false)
    {
      boolean bool4 = bool2;
      if (localAnnotatedField.isTransient())
      {
        boolean bool5 = false;
        bool1 = bool5;
        bool4 = bool2;
        if (bool6)
        {
          bool4 = true;
          bool1 = bool5;
        }
      }
      if ((i != 0) && (localObject3 == null) && (!bool4) && (Modifier.isFinal(localAnnotatedField.getModifiers()))) {
        break label54;
      }
      _property(paramMap, (String)localObject2).addField(localAnnotatedField, (PropertyName)localObject3, bool3, bool1, bool4);
      break label54;
      i = 0;
      break;
      localObject1 = localAnnotationIntrospector.findImplicitPropertyName(localAnnotatedField);
      break label84;
      if (_forSerialization)
      {
        localObject1 = localAnnotationIntrospector.findNameForSerialization(localAnnotatedField);
        break label108;
      }
      localObject1 = localAnnotationIntrospector.findNameForDeserialization(localAnnotatedField);
      break label108;
      bool1 = false;
      break label115;
      bool2 = false;
      break label160;
    }
  }
  
  protected void _addGetterMethod(Map<String, POJOPropertyBuilder> paramMap, AnnotatedMethod paramAnnotatedMethod, AnnotationIntrospector paramAnnotationIntrospector)
  {
    boolean bool3 = false;
    Object localObject2 = null;
    Object localObject3 = null;
    if (!paramAnnotatedMethod.hasReturnType()) {}
    Object localObject1;
    boolean bool1;
    label108:
    label117:
    do
    {
      return;
      if (paramAnnotationIntrospector != null)
      {
        if (paramAnnotationIntrospector.hasAnyGetterAnnotation(paramAnnotatedMethod))
        {
          if (_anyGetters == null) {
            _anyGetters = new LinkedList();
          }
          _anyGetters.add(paramAnnotatedMethod);
          return;
        }
        if (paramAnnotationIntrospector.hasAsValueAnnotation(paramAnnotatedMethod))
        {
          if (_jsonValueGetters == null) {
            _jsonValueGetters = new LinkedList();
          }
          _jsonValueGetters.add(paramAnnotatedMethod);
          return;
        }
      }
      if (paramAnnotationIntrospector != null) {
        break;
      }
      localObject1 = null;
      if (localObject1 == null) {
        break label210;
      }
      bool1 = true;
      if (bool1) {
        break label241;
      }
      if (paramAnnotationIntrospector != null) {
        break label216;
      }
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = BeanUtil.okNameForRegularGetter(paramAnnotatedMethod, paramAnnotatedMethod.getName(), _stdBeanNaming);
      }
      if (localObject2 != null) {
        break label226;
      }
      localObject2 = BeanUtil.okNameForIsGetter(paramAnnotatedMethod, paramAnnotatedMethod.getName(), _stdBeanNaming);
    } while (localObject2 == null);
    boolean bool2 = _visibilityChecker.isIsGetterVisible(paramAnnotatedMethod);
    label176:
    if (paramAnnotationIntrospector == null) {}
    for (;;)
    {
      _property(paramMap, (String)localObject2).addGetter(paramAnnotatedMethod, (PropertyName)localObject1, bool1, bool2, bool3);
      return;
      localObject1 = paramAnnotationIntrospector.findNameForSerialization(paramAnnotatedMethod);
      break;
      label210:
      bool1 = false;
      break label108;
      label216:
      localObject3 = paramAnnotationIntrospector.findImplicitPropertyName(paramAnnotatedMethod);
      break label117;
      label226:
      bool2 = _visibilityChecker.isGetterVisible(paramAnnotatedMethod);
      break label176;
      label241:
      if (paramAnnotationIntrospector == null) {}
      for (;;)
      {
        localObject3 = localObject2;
        if (localObject2 == null) {
          localObject3 = BeanUtil.okNameForGetter(paramAnnotatedMethod, _stdBeanNaming);
        }
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = paramAnnotatedMethod.getName();
        }
        localObject3 = localObject1;
        if (((PropertyName)localObject1).isEmpty())
        {
          localObject3 = _propNameFromSimple((String)localObject2);
          bool1 = false;
        }
        bool2 = true;
        localObject1 = localObject3;
        break;
        localObject2 = paramAnnotationIntrospector.findImplicitPropertyName(paramAnnotatedMethod);
      }
      bool3 = paramAnnotationIntrospector.hasIgnoreMarker(paramAnnotatedMethod);
    }
  }
  
  protected void _addInjectables(Map<String, POJOPropertyBuilder> paramMap)
  {
    paramMap = _annotationIntrospector;
    if (paramMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = _classDef.fields().iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = (AnnotatedField)localIterator.next();
        _doAddInjectable(paramMap.findInjectableValueId((AnnotatedMember)localObject), (AnnotatedMember)localObject);
      }
      localIterator = _classDef.memberMethods().iterator();
      while (localIterator.hasNext())
      {
        localObject = (AnnotatedMethod)localIterator.next();
        if (((AnnotatedMethod)localObject).getParameterCount() == 1) {
          _doAddInjectable(paramMap.findInjectableValueId((AnnotatedMember)localObject), (AnnotatedMember)localObject);
        }
      }
    }
  }
  
  protected void _addMethods(Map<String, POJOPropertyBuilder> paramMap)
  {
    AnnotationIntrospector localAnnotationIntrospector = _annotationIntrospector;
    Iterator localIterator = _classDef.memberMethods().iterator();
    while (localIterator.hasNext())
    {
      AnnotatedMethod localAnnotatedMethod = (AnnotatedMethod)localIterator.next();
      int i = localAnnotatedMethod.getParameterCount();
      if (i == 0)
      {
        _addGetterMethod(paramMap, localAnnotatedMethod, localAnnotationIntrospector);
      }
      else if (i == 1)
      {
        _addSetterMethod(paramMap, localAnnotatedMethod, localAnnotationIntrospector);
      }
      else if ((i == 2) && (localAnnotationIntrospector != null) && (localAnnotationIntrospector.hasAnySetterAnnotation(localAnnotatedMethod)))
      {
        if (_anySetters == null) {
          _anySetters = new LinkedList();
        }
        _anySetters.add(localAnnotatedMethod);
      }
    }
  }
  
  protected void _addSetterMethod(Map<String, POJOPropertyBuilder> paramMap, AnnotatedMethod paramAnnotatedMethod, AnnotationIntrospector paramAnnotationIntrospector)
  {
    boolean bool3 = false;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1;
    boolean bool1;
    if (paramAnnotationIntrospector == null)
    {
      localObject1 = null;
      if (localObject1 == null) {
        break label72;
      }
      bool1 = true;
      label24:
      if (bool1) {
        break label128;
      }
      if (paramAnnotationIntrospector != null) {
        break label78;
      }
    }
    for (;;)
    {
      localObject3 = localObject2;
      if (localObject2 == null) {
        localObject3 = BeanUtil.okNameForMutator(paramAnnotatedMethod, _mutatorPrefix, _stdBeanNaming);
      }
      if (localObject3 != null) {
        break label88;
      }
      return;
      localObject1 = paramAnnotationIntrospector.findNameForDeserialization(paramAnnotatedMethod);
      break;
      label72:
      bool1 = false;
      break label24;
      label78:
      localObject2 = paramAnnotationIntrospector.findImplicitPropertyName(paramAnnotatedMethod);
    }
    label88:
    boolean bool2 = _visibilityChecker.isSetterVisible(paramAnnotatedMethod);
    localObject2 = localObject3;
    if (paramAnnotationIntrospector == null) {}
    for (;;)
    {
      _property(paramMap, (String)localObject2).addSetter(paramAnnotatedMethod, (PropertyName)localObject1, bool1, bool2, bool3);
      return;
      label128:
      if (paramAnnotationIntrospector == null) {}
      for (localObject2 = localObject3;; localObject2 = paramAnnotationIntrospector.findImplicitPropertyName(paramAnnotatedMethod))
      {
        localObject3 = localObject2;
        if (localObject2 == null) {
          localObject3 = BeanUtil.okNameForMutator(paramAnnotatedMethod, _mutatorPrefix, _stdBeanNaming);
        }
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = paramAnnotatedMethod.getName();
        }
        localObject3 = localObject1;
        if (((PropertyName)localObject1).isEmpty())
        {
          localObject3 = _propNameFromSimple((String)localObject2);
          bool1 = false;
        }
        bool2 = true;
        localObject1 = localObject3;
        break;
      }
      bool3 = paramAnnotationIntrospector.hasIgnoreMarker(paramAnnotatedMethod);
    }
  }
  
  protected void _doAddInjectable(Object paramObject, AnnotatedMember paramAnnotatedMember)
  {
    if (paramObject == null) {}
    do
    {
      return;
      if (_injectables == null) {
        _injectables = new LinkedHashMap();
      }
    } while ((AnnotatedMember)_injectables.put(paramObject, paramAnnotatedMember) == null);
    paramAnnotatedMember = paramObject.getClass().getName();
    throw new IllegalArgumentException("Duplicate injectable value with id '" + String.valueOf(paramObject) + "' (of type " + paramAnnotatedMember + ")");
  }
  
  protected POJOPropertyBuilder _property(Map<String, POJOPropertyBuilder> paramMap, PropertyName paramPropertyName)
  {
    return _property(paramMap, paramPropertyName.getSimpleName());
  }
  
  protected POJOPropertyBuilder _property(Map<String, POJOPropertyBuilder> paramMap, String paramString)
  {
    POJOPropertyBuilder localPOJOPropertyBuilder2 = (POJOPropertyBuilder)paramMap.get(paramString);
    POJOPropertyBuilder localPOJOPropertyBuilder1 = localPOJOPropertyBuilder2;
    if (localPOJOPropertyBuilder2 == null)
    {
      localPOJOPropertyBuilder1 = new POJOPropertyBuilder(PropertyName.construct(paramString), _annotationIntrospector, _forSerialization);
      paramMap.put(paramString, localPOJOPropertyBuilder1);
    }
    return localPOJOPropertyBuilder1;
  }
  
  protected void _removeUnwantedAccessor(Map<String, POJOPropertyBuilder> paramMap)
  {
    boolean bool = _config.isEnabled(MapperFeature.INFER_PROPERTY_MUTATORS);
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext()) {
      ((POJOPropertyBuilder)paramMap.next()).removeNonVisible(bool);
    }
  }
  
  protected void _removeUnwantedProperties(Map<String, POJOPropertyBuilder> paramMap)
  {
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      POJOPropertyBuilder localPOJOPropertyBuilder = (POJOPropertyBuilder)paramMap.next();
      if (!localPOJOPropertyBuilder.anyVisible()) {
        paramMap.remove();
      } else if (localPOJOPropertyBuilder.anyIgnorals()) {
        if (!localPOJOPropertyBuilder.isExplicitlyIncluded())
        {
          paramMap.remove();
          _collectIgnorals(localPOJOPropertyBuilder.getName());
        }
        else
        {
          localPOJOPropertyBuilder.removeIgnored();
          if ((!_forSerialization) && (!localPOJOPropertyBuilder.couldDeserialize())) {
            _collectIgnorals(localPOJOPropertyBuilder.getName());
          }
        }
      }
    }
  }
  
  protected void _renameProperties(Map<String, POJOPropertyBuilder> paramMap)
  {
    Object localObject3 = paramMap.entrySet().iterator();
    Object localObject1 = null;
    POJOPropertyBuilder localPOJOPropertyBuilder;
    Object localObject2;
    while (((Iterator)localObject3).hasNext())
    {
      localPOJOPropertyBuilder = (POJOPropertyBuilder)((Map.Entry)((Iterator)localObject3).next()).getValue();
      Set localSet = localPOJOPropertyBuilder.findExplicitNames();
      if (!localSet.isEmpty())
      {
        ((Iterator)localObject3).remove();
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new LinkedList();
        }
        if (localSet.size() == 1)
        {
          ((LinkedList)localObject2).add(localPOJOPropertyBuilder.withName((PropertyName)localSet.iterator().next()));
          localObject1 = localObject2;
        }
        else
        {
          ((LinkedList)localObject2).addAll(localPOJOPropertyBuilder.explode(localSet));
          localObject1 = localObject2;
        }
      }
    }
    if (localObject1 != null)
    {
      localObject1 = ((LinkedList)localObject1).iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (POJOPropertyBuilder)((Iterator)localObject1).next();
        localObject3 = ((POJOPropertyBuilder)localObject2).getName();
        localPOJOPropertyBuilder = (POJOPropertyBuilder)paramMap.get(localObject3);
        if (localPOJOPropertyBuilder == null) {
          paramMap.put(localObject3, localObject2);
        }
        for (;;)
        {
          _updateCreatorProperty((POJOPropertyBuilder)localObject2, _creatorProperties);
          break;
          localPOJOPropertyBuilder.addAll((POJOPropertyBuilder)localObject2);
        }
      }
    }
  }
  
  protected void _renameUsing(Map<String, POJOPropertyBuilder> paramMap, PropertyNamingStrategy paramPropertyNamingStrategy)
  {
    POJOPropertyBuilder[] arrayOfPOJOPropertyBuilder = (POJOPropertyBuilder[])paramMap.values().toArray(new POJOPropertyBuilder[paramMap.size()]);
    paramMap.clear();
    int j = arrayOfPOJOPropertyBuilder.length;
    int i = 0;
    if (i < j)
    {
      Object localObject2 = arrayOfPOJOPropertyBuilder[i];
      PropertyName localPropertyName = ((POJOPropertyBuilder)localObject2).getFullName();
      Object localObject3 = null;
      Object localObject1 = localObject3;
      if (!((POJOPropertyBuilder)localObject2).isExplicitlyNamed())
      {
        if (!_forSerialization) {
          break label220;
        }
        if (((POJOPropertyBuilder)localObject2).hasGetter()) {
          localObject1 = paramPropertyNamingStrategy.nameForGetterMethod(_config, ((POJOPropertyBuilder)localObject2).getGetter(), localPropertyName.getSimpleName());
        }
      }
      else
      {
        label107:
        if ((localObject1 == null) || (localPropertyName.hasSimpleName((String)localObject1))) {
          break label348;
        }
        localObject3 = ((POJOPropertyBuilder)localObject2).withSimpleName((String)localObject1);
        localObject2 = localObject1;
        localObject1 = localObject3;
        label139:
        localObject3 = (POJOPropertyBuilder)paramMap.get(localObject2);
        if (localObject3 != null) {
          break label366;
        }
        paramMap.put(localObject2, localObject1);
      }
      for (;;)
      {
        _updateCreatorProperty((POJOPropertyBuilder)localObject1, _creatorProperties);
        i += 1;
        break;
        localObject1 = localObject3;
        if (!((POJOPropertyBuilder)localObject2).hasField()) {
          break label107;
        }
        localObject1 = paramPropertyNamingStrategy.nameForField(_config, ((POJOPropertyBuilder)localObject2).getField(), localPropertyName.getSimpleName());
        break label107;
        label220:
        if (((POJOPropertyBuilder)localObject2).hasSetter())
        {
          localObject1 = paramPropertyNamingStrategy.nameForSetterMethod(_config, ((POJOPropertyBuilder)localObject2).getSetter(), localPropertyName.getSimpleName());
          break label107;
        }
        if (((POJOPropertyBuilder)localObject2).hasConstructorParameter())
        {
          localObject1 = paramPropertyNamingStrategy.nameForConstructorParameter(_config, ((POJOPropertyBuilder)localObject2).getConstructorParameter(), localPropertyName.getSimpleName());
          break label107;
        }
        if (((POJOPropertyBuilder)localObject2).hasField())
        {
          localObject1 = paramPropertyNamingStrategy.nameForField(_config, ((POJOPropertyBuilder)localObject2).getField(), localPropertyName.getSimpleName());
          break label107;
        }
        localObject1 = localObject3;
        if (!((POJOPropertyBuilder)localObject2).hasGetter()) {
          break label107;
        }
        localObject1 = paramPropertyNamingStrategy.nameForGetterMethod(_config, ((POJOPropertyBuilder)localObject2).getGetter(), localPropertyName.getSimpleName());
        break label107;
        label348:
        localObject3 = localPropertyName.getSimpleName();
        localObject1 = localObject2;
        localObject2 = localObject3;
        break label139;
        label366:
        ((POJOPropertyBuilder)localObject3).addAll((POJOPropertyBuilder)localObject1);
      }
    }
  }
  
  protected void _renameWithWrappers(Map<String, POJOPropertyBuilder> paramMap)
  {
    Object localObject3 = paramMap.entrySet().iterator();
    Object localObject1 = null;
    POJOPropertyBuilder localPOJOPropertyBuilder;
    Object localObject2;
    while (((Iterator)localObject3).hasNext())
    {
      localPOJOPropertyBuilder = (POJOPropertyBuilder)((Map.Entry)((Iterator)localObject3).next()).getValue();
      localObject2 = localPOJOPropertyBuilder.getPrimaryMember();
      if (localObject2 != null)
      {
        PropertyName localPropertyName = _annotationIntrospector.findWrapperName((Annotated)localObject2);
        if ((localPropertyName != null) && (localPropertyName.hasSimpleName()) && (!localPropertyName.equals(localPOJOPropertyBuilder.getFullName())))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new LinkedList();
          }
          ((LinkedList)localObject2).add(localPOJOPropertyBuilder.withName(localPropertyName));
          ((Iterator)localObject3).remove();
          localObject1 = localObject2;
        }
      }
    }
    if (localObject1 != null)
    {
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (POJOPropertyBuilder)((Iterator)localObject1).next();
        localObject3 = ((POJOPropertyBuilder)localObject2).getName();
        localPOJOPropertyBuilder = (POJOPropertyBuilder)paramMap.get(localObject3);
        if (localPOJOPropertyBuilder == null) {
          paramMap.put(localObject3, localObject2);
        } else {
          localPOJOPropertyBuilder.addAll((POJOPropertyBuilder)localObject2);
        }
      }
    }
  }
  
  protected void _sortProperties(Map<String, POJOPropertyBuilder> paramMap)
  {
    Object localObject2 = _annotationIntrospector;
    boolean bool;
    if (localObject2 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label68;
      }
      bool = _config.shouldSortPropertiesAlphabetically();
      label28:
      if (localObject2 != null) {
        break label78;
      }
    }
    label68:
    label78:
    for (localObject2 = null;; localObject2 = ((AnnotationIntrospector)localObject2).findSerializationPropertyOrder(_classDef))
    {
      if ((bool) || (_creatorProperties != null) || (localObject2 != null)) {
        break label92;
      }
      return;
      localObject1 = ((AnnotationIntrospector)localObject2).findSerializationSortAlphabetically(_classDef);
      break;
      bool = ((Boolean)localObject1).booleanValue();
      break label28;
    }
    label92:
    int i = paramMap.size();
    if (bool) {}
    Object localObject3;
    Object localObject4;
    for (Object localObject1 = new TreeMap();; localObject1 = new LinkedHashMap(i + i))
    {
      localObject3 = paramMap.values().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (POJOPropertyBuilder)((Iterator)localObject3).next();
        ((Map)localObject1).put(((POJOPropertyBuilder)localObject4).getName(), localObject4);
      }
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(i + i);
    if (localObject2 != null)
    {
      int j = localObject2.length;
      i = 0;
      while (i < j)
      {
        Object localObject5 = localObject2[i];
        POJOPropertyBuilder localPOJOPropertyBuilder = (POJOPropertyBuilder)((Map)localObject1).get(localObject5);
        localObject4 = localObject5;
        localObject3 = localPOJOPropertyBuilder;
        if (localPOJOPropertyBuilder == null)
        {
          Iterator localIterator = paramMap.values().iterator();
          do
          {
            localObject4 = localObject5;
            localObject3 = localPOJOPropertyBuilder;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject4 = (POJOPropertyBuilder)localIterator.next();
          } while (!((String)localObject5).equals(((POJOPropertyBuilder)localObject4).getInternalName()));
          localObject3 = localObject4;
          localObject4 = ((POJOPropertyBuilder)localObject4).getName();
        }
        if (localObject3 != null) {
          localLinkedHashMap.put(localObject4, localObject3);
        }
        i += 1;
      }
    }
    if (_creatorProperties != null)
    {
      if (bool)
      {
        localObject2 = new TreeMap();
        localObject3 = _creatorProperties.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (POJOPropertyBuilder)((Iterator)localObject3).next();
          ((TreeMap)localObject2).put(((POJOPropertyBuilder)localObject4).getName(), localObject4);
        }
      }
      for (localObject2 = ((TreeMap)localObject2).values();; localObject2 = _creatorProperties)
      {
        localObject2 = ((Collection)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (POJOPropertyBuilder)((Iterator)localObject2).next();
          localLinkedHashMap.put(((POJOPropertyBuilder)localObject3).getName(), localObject3);
        }
      }
    }
    localLinkedHashMap.putAll((Map)localObject1);
    paramMap.clear();
    paramMap.putAll(localLinkedHashMap);
  }
  
  protected void _updateCreatorProperty(POJOPropertyBuilder paramPOJOPropertyBuilder, List<POJOPropertyBuilder> paramList)
  {
    int i;
    int j;
    if (paramList != null)
    {
      i = 0;
      j = paramList.size();
    }
    for (;;)
    {
      if (i < j)
      {
        if (((POJOPropertyBuilder)paramList.get(i)).getInternalName().equals(paramPOJOPropertyBuilder.getInternalName())) {
          paramList.set(i, paramPOJOPropertyBuilder);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  @Deprecated
  public POJOPropertiesCollector collect()
  {
    return this;
  }
  
  protected void collectAll()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    _addFields(localLinkedHashMap);
    _addMethods(localLinkedHashMap);
    _addCreators(localLinkedHashMap);
    _addInjectables(localLinkedHashMap);
    _removeUnwantedProperties(localLinkedHashMap);
    Object localObject = localLinkedHashMap.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((POJOPropertyBuilder)((Iterator)localObject).next()).mergeAnnotations(_forSerialization);
    }
    _removeUnwantedAccessor(localLinkedHashMap);
    _renameProperties(localLinkedHashMap);
    localObject = _findNamingStrategy();
    if (localObject != null) {
      _renameUsing(localLinkedHashMap, (PropertyNamingStrategy)localObject);
    }
    localObject = localLinkedHashMap.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((POJOPropertyBuilder)((Iterator)localObject).next()).trimByVisibility();
    }
    if (_config.isEnabled(MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME)) {
      _renameWithWrappers(localLinkedHashMap);
    }
    _sortProperties(localLinkedHashMap);
    _properties = localLinkedHashMap;
    _collected = true;
  }
  
  public Class<?> findPOJOBuilderClass()
  {
    return _annotationIntrospector.findPOJOBuilder(_classDef);
  }
  
  public AnnotationIntrospector getAnnotationIntrospector()
  {
    return _annotationIntrospector;
  }
  
  public AnnotatedMember getAnyGetter()
  {
    if (!_collected) {
      collectAll();
    }
    if (_anyGetters != null)
    {
      if (_anyGetters.size() > 1) {
        reportProblem("Multiple 'any-getters' defined (" + _anyGetters.get(0) + " vs " + _anyGetters.get(1) + ")");
      }
      return (AnnotatedMember)_anyGetters.getFirst();
    }
    return null;
  }
  
  public AnnotatedMethod getAnySetterMethod()
  {
    if (!_collected) {
      collectAll();
    }
    if (_anySetters != null)
    {
      if (_anySetters.size() > 1) {
        reportProblem("Multiple 'any-setters' defined (" + _anySetters.get(0) + " vs " + _anySetters.get(1) + ")");
      }
      return (AnnotatedMethod)_anySetters.getFirst();
    }
    return null;
  }
  
  public AnnotatedClass getClassDef()
  {
    return _classDef;
  }
  
  public MapperConfig<?> getConfig()
  {
    return _config;
  }
  
  public Set<String> getIgnoredPropertyNames()
  {
    return _ignoredPropertyNames;
  }
  
  public Map<Object, AnnotatedMember> getInjectables()
  {
    if (!_collected) {
      collectAll();
    }
    return _injectables;
  }
  
  public AnnotatedMethod getJsonValueMethod()
  {
    if (!_collected) {
      collectAll();
    }
    if (_jsonValueGetters != null)
    {
      if (_jsonValueGetters.size() > 1) {
        reportProblem("Multiple value properties defined (" + _jsonValueGetters.get(0) + " vs " + _jsonValueGetters.get(1) + ")");
      }
      return (AnnotatedMethod)_jsonValueGetters.get(0);
    }
    return null;
  }
  
  public ObjectIdInfo getObjectIdInfo()
  {
    Object localObject;
    if (_annotationIntrospector == null) {
      localObject = null;
    }
    ObjectIdInfo localObjectIdInfo;
    do
    {
      return (ObjectIdInfo)localObject;
      localObjectIdInfo = _annotationIntrospector.findObjectIdInfo(_classDef);
      localObject = localObjectIdInfo;
    } while (localObjectIdInfo == null);
    return _annotationIntrospector.findObjectReferenceInfo(_classDef, localObjectIdInfo);
  }
  
  public List<BeanPropertyDefinition> getProperties()
  {
    return new ArrayList(getPropertyMap().values());
  }
  
  protected Map<String, POJOPropertyBuilder> getPropertyMap()
  {
    if (!_collected) {
      collectAll();
    }
    return _properties;
  }
  
  public JavaType getType()
  {
    return _type;
  }
  
  protected void reportProblem(String paramString)
  {
    throw new IllegalArgumentException("Problem with definition of " + _classDef + ": " + paramString);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.introspect.POJOPropertiesCollector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */