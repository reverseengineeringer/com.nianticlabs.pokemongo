package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty.Std;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.impl.FilteredBeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import com.fasterxml.jackson.databind.ser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import com.fasterxml.jackson.databind.ser.std.StdDelegatingSerializer;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.Converter;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class BeanSerializerFactory
  extends BasicSerializerFactory
  implements Serializable
{
  public static final BeanSerializerFactory instance = new BeanSerializerFactory(null);
  private static final long serialVersionUID = 1L;
  
  protected BeanSerializerFactory(SerializerFactoryConfig paramSerializerFactoryConfig)
  {
    super(paramSerializerFactoryConfig);
  }
  
  protected BeanPropertyWriter _constructWriter(SerializerProvider paramSerializerProvider, BeanPropertyDefinition paramBeanPropertyDefinition, TypeBindings paramTypeBindings, PropertyBuilder paramPropertyBuilder, boolean paramBoolean, AnnotatedMember paramAnnotatedMember)
    throws JsonMappingException
  {
    Object localObject = paramBeanPropertyDefinition.getFullName();
    if (paramSerializerProvider.canOverrideAccessModifiers()) {
      paramAnnotatedMember.fixAccess();
    }
    JavaType localJavaType = paramAnnotatedMember.getType(paramTypeBindings);
    paramTypeBindings = new BeanProperty.Std((PropertyName)localObject, localJavaType, paramBeanPropertyDefinition.getWrapperName(), paramPropertyBuilder.getClassAnnotations(), paramAnnotatedMember, paramBeanPropertyDefinition.getMetadata());
    localObject = findSerializerFromAnnotation(paramSerializerProvider, paramAnnotatedMember);
    if ((localObject instanceof ResolvableSerializer)) {
      ((ResolvableSerializer)localObject).resolve(paramSerializerProvider);
    }
    localObject = paramSerializerProvider.handlePrimaryContextualization((JsonSerializer)localObject, paramTypeBindings);
    paramTypeBindings = null;
    if ((ClassUtil.isCollectionMapOrArray(localJavaType.getRawClass())) || (localJavaType.isCollectionLikeType()) || (localJavaType.isMapLikeType())) {
      paramTypeBindings = findPropertyContentTypeSerializer(localJavaType, paramSerializerProvider.getConfig(), paramAnnotatedMember);
    }
    return paramPropertyBuilder.buildWriter(paramSerializerProvider, paramBeanPropertyDefinition, localJavaType, (JsonSerializer)localObject, findPropertyTypeSerializer(localJavaType, paramSerializerProvider.getConfig(), paramAnnotatedMember), paramTypeBindings, paramAnnotatedMember, paramBoolean);
  }
  
  protected JsonSerializer<?> _createSerializer2(SerializerProvider paramSerializerProvider, JavaType paramJavaType, BeanDescription paramBeanDescription, boolean paramBoolean)
    throws JsonMappingException
  {
    Object localObject1 = null;
    SerializationConfig localSerializationConfig = paramSerializerProvider.getConfig();
    boolean bool;
    Object localObject2;
    if (paramJavaType.isContainerType())
    {
      bool = paramBoolean;
      if (!paramBoolean) {
        bool = usesStaticTyping(localSerializationConfig, paramBeanDescription, null);
      }
      localObject1 = buildContainerSerializer(paramSerializerProvider, paramJavaType, paramBeanDescription, bool);
      localObject2 = localObject1;
      if (localObject1 != null) {
        return (JsonSerializer<?>)localObject1;
      }
    }
    else
    {
      Iterator localIterator = customSerializers().iterator();
      while (localIterator.hasNext())
      {
        localObject2 = ((Serializers)localIterator.next()).findSerializer(localSerializationConfig, paramJavaType, paramBeanDescription);
        localObject1 = localObject2;
        if (localObject2 != null) {
          localObject1 = localObject2;
        }
      }
      localObject2 = localObject1;
      bool = paramBoolean;
      if (localObject1 == null)
      {
        localObject2 = findSerializerByAnnotations(paramSerializerProvider, paramJavaType, paramBeanDescription);
        bool = paramBoolean;
      }
    }
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = findSerializerByLookup(paramJavaType, localSerializationConfig, paramBeanDescription, bool);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = findSerializerByPrimaryType(paramSerializerProvider, paramJavaType, paramBeanDescription, bool);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = findBeanSerializer(paramSerializerProvider, paramJavaType, paramBeanDescription);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            paramJavaType = findSerializerByAddonType(localSerializationConfig, paramJavaType, paramBeanDescription, bool);
            localObject1 = paramJavaType;
            if (paramJavaType == null) {
              localObject1 = paramSerializerProvider.getUnknownTypeSerializer(paramBeanDescription.getBeanClass());
            }
          }
        }
      }
    }
    paramSerializerProvider = (SerializerProvider)localObject1;
    if (localObject1 != null)
    {
      paramSerializerProvider = (SerializerProvider)localObject1;
      if (_factoryConfig.hasSerializerModifiers())
      {
        paramJavaType = _factoryConfig.serializerModifiers().iterator();
        for (;;)
        {
          paramSerializerProvider = (SerializerProvider)localObject1;
          if (!paramJavaType.hasNext()) {
            break;
          }
          localObject1 = ((BeanSerializerModifier)paramJavaType.next()).modifySerializer(localSerializationConfig, paramBeanDescription, (JsonSerializer)localObject1);
        }
      }
    }
    return paramSerializerProvider;
  }
  
  protected JsonSerializer<Object> constructBeanSerializer(SerializerProvider paramSerializerProvider, BeanDescription paramBeanDescription)
    throws JsonMappingException
  {
    if (paramBeanDescription.getBeanClass() == Object.class) {
      paramSerializerProvider = paramSerializerProvider.getUnknownTypeSerializer(Object.class);
    }
    Object localObject1;
    do
    {
      Object localObject2;
      do
      {
        return paramSerializerProvider;
        SerializationConfig localSerializationConfig = paramSerializerProvider.getConfig();
        localObject2 = constructBeanSerializerBuilder(paramBeanDescription);
        ((BeanSerializerBuilder)localObject2).setConfig(localSerializationConfig);
        localObject1 = findBeanProperties(paramSerializerProvider, paramBeanDescription, (BeanSerializerBuilder)localObject2);
        if (localObject1 == null) {}
        Object localObject4;
        for (localObject1 = new ArrayList();; localObject1 = removeOverlappingTypeIds(paramSerializerProvider, paramBeanDescription, (BeanSerializerBuilder)localObject2, (List)localObject1))
        {
          paramSerializerProvider.getAnnotationIntrospector().findAndAddVirtualProperties(localSerializationConfig, paramBeanDescription.getClassInfo(), (List)localObject1);
          localObject3 = localObject1;
          if (!_factoryConfig.hasSerializerModifiers()) {
            break;
          }
          localObject4 = _factoryConfig.serializerModifiers().iterator();
          for (;;)
          {
            localObject3 = localObject1;
            if (!((Iterator)localObject4).hasNext()) {
              break;
            }
            localObject1 = ((BeanSerializerModifier)((Iterator)localObject4).next()).changeProperties(localSerializationConfig, paramBeanDescription, (List)localObject1);
          }
        }
        localObject1 = filterBeanProperties(localSerializationConfig, paramBeanDescription, (List)localObject3);
        Object localObject3 = localObject1;
        if (_factoryConfig.hasSerializerModifiers())
        {
          localObject4 = _factoryConfig.serializerModifiers().iterator();
          for (;;)
          {
            localObject3 = localObject1;
            if (!((Iterator)localObject4).hasNext()) {
              break;
            }
            localObject1 = ((BeanSerializerModifier)((Iterator)localObject4).next()).orderProperties(localSerializationConfig, paramBeanDescription, (List)localObject1);
          }
        }
        ((BeanSerializerBuilder)localObject2).setObjectIdWriter(constructObjectIdHandler(paramSerializerProvider, paramBeanDescription, (List)localObject3));
        ((BeanSerializerBuilder)localObject2).setProperties((List)localObject3);
        ((BeanSerializerBuilder)localObject2).setFilterId(findFilterId(localSerializationConfig, paramBeanDescription));
        localObject3 = paramBeanDescription.findAnyGetter();
        if (localObject3 != null)
        {
          if (localSerializationConfig.canOverrideAccessModifiers()) {
            ((AnnotatedMember)localObject3).fixAccess();
          }
          JavaType localJavaType = ((AnnotatedMember)localObject3).getType(paramBeanDescription.bindingsForBeanType());
          boolean bool = localSerializationConfig.isEnabled(MapperFeature.USE_STATIC_TYPING);
          localObject4 = localJavaType.getContentType();
          TypeSerializer localTypeSerializer = createTypeSerializer(localSerializationConfig, (JavaType)localObject4);
          localObject1 = findSerializerFromAnnotation(paramSerializerProvider, (Annotated)localObject3);
          paramSerializerProvider = (SerializerProvider)localObject1;
          if (localObject1 == null) {
            paramSerializerProvider = MapSerializer.construct(null, localJavaType, bool, localTypeSerializer, null, null, null);
          }
          ((BeanSerializerBuilder)localObject2).setAnyGetter(new AnyGetterWriter(new BeanProperty.Std(PropertyName.construct(((AnnotatedMember)localObject3).getName()), (JavaType)localObject4, null, paramBeanDescription.getClassAnnotations(), (AnnotatedMember)localObject3, PropertyMetadata.STD_OPTIONAL), (AnnotatedMember)localObject3, paramSerializerProvider));
        }
        processViews(localSerializationConfig, (BeanSerializerBuilder)localObject2);
        localObject1 = localObject2;
        if (_factoryConfig.hasSerializerModifiers())
        {
          localObject3 = _factoryConfig.serializerModifiers().iterator();
          for (paramSerializerProvider = (SerializerProvider)localObject2;; paramSerializerProvider = ((BeanSerializerModifier)((Iterator)localObject3).next()).updateBuilder(localSerializationConfig, paramBeanDescription, paramSerializerProvider))
          {
            localObject1 = paramSerializerProvider;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
          }
        }
        localObject2 = ((BeanSerializerBuilder)localObject1).build();
        paramSerializerProvider = (SerializerProvider)localObject2;
      } while (localObject2 != null);
      paramSerializerProvider = (SerializerProvider)localObject2;
    } while (!paramBeanDescription.hasKnownClassAnnotations());
    return ((BeanSerializerBuilder)localObject1).createDummy();
  }
  
  protected BeanSerializerBuilder constructBeanSerializerBuilder(BeanDescription paramBeanDescription)
  {
    return new BeanSerializerBuilder(paramBeanDescription);
  }
  
  protected BeanPropertyWriter constructFilteredBeanWriter(BeanPropertyWriter paramBeanPropertyWriter, Class<?>[] paramArrayOfClass)
  {
    return FilteredBeanPropertyWriter.constructViewBased(paramBeanPropertyWriter, paramArrayOfClass);
  }
  
  protected ObjectIdWriter constructObjectIdHandler(SerializerProvider paramSerializerProvider, BeanDescription paramBeanDescription, List<BeanPropertyWriter> paramList)
    throws JsonMappingException
  {
    ObjectIdInfo localObjectIdInfo = paramBeanDescription.getObjectIdInfo();
    if (localObjectIdInfo == null) {
      return null;
    }
    Object localObject = localObjectIdInfo.getGeneratorType();
    if (localObject == ObjectIdGenerators.PropertyGenerator.class)
    {
      localObject = localObjectIdInfo.getPropertyName().getSimpleName();
      int i = 0;
      int j = paramList.size();
      for (;;)
      {
        if (i == j) {
          throw new IllegalArgumentException("Invalid Object Id definition for " + paramBeanDescription.getBeanClass().getName() + ": can not find property with name '" + (String)localObject + "'");
        }
        paramSerializerProvider = (BeanPropertyWriter)paramList.get(i);
        if (((String)localObject).equals(paramSerializerProvider.getName()))
        {
          if (i > 0)
          {
            paramList.remove(i);
            paramList.add(0, paramSerializerProvider);
          }
          paramBeanDescription = paramSerializerProvider.getType();
          paramSerializerProvider = new PropertyBasedObjectIdGenerator(localObjectIdInfo, paramSerializerProvider);
          return ObjectIdWriter.construct(paramBeanDescription, (PropertyName)null, paramSerializerProvider, localObjectIdInfo.getAlwaysAsId());
        }
        i += 1;
      }
    }
    paramList = paramSerializerProvider.constructType((Type)localObject);
    paramList = paramSerializerProvider.getTypeFactory().findTypeParameters(paramList, com.fasterxml.jackson.annotation.ObjectIdGenerator.class)[0];
    paramSerializerProvider = paramSerializerProvider.objectIdGeneratorInstance(paramBeanDescription.getClassInfo(), localObjectIdInfo);
    return ObjectIdWriter.construct(paramList, localObjectIdInfo.getPropertyName(), paramSerializerProvider, localObjectIdInfo.getAlwaysAsId());
  }
  
  protected PropertyBuilder constructPropertyBuilder(SerializationConfig paramSerializationConfig, BeanDescription paramBeanDescription)
  {
    return new PropertyBuilder(paramSerializationConfig, paramBeanDescription);
  }
  
  public JsonSerializer<Object> createSerializer(SerializerProvider paramSerializerProvider, JavaType paramJavaType)
    throws JsonMappingException
  {
    SerializationConfig localSerializationConfig = paramSerializerProvider.getConfig();
    BeanDescription localBeanDescription = localSerializationConfig.introspect(paramJavaType);
    Object localObject = findSerializerFromAnnotation(paramSerializerProvider, localBeanDescription.getClassInfo());
    if (localObject != null) {
      return (JsonSerializer<Object>)localObject;
    }
    JavaType localJavaType2 = modifyTypeByAnnotation(localSerializationConfig, localBeanDescription.getClassInfo(), paramJavaType);
    boolean bool1;
    if (localJavaType2 == paramJavaType) {
      bool1 = false;
    }
    Converter localConverter;
    for (;;)
    {
      localConverter = localBeanDescription.findSerializationConverter();
      if (localConverter != null) {
        break;
      }
      return _createSerializer2(paramSerializerProvider, localJavaType2, localBeanDescription, bool1);
      boolean bool2 = true;
      bool1 = bool2;
      if (!localJavaType2.hasRawClass(paramJavaType.getRawClass()))
      {
        localBeanDescription = localSerializationConfig.introspect(localJavaType2);
        bool1 = bool2;
      }
    }
    JavaType localJavaType1 = localConverter.getOutputType(paramSerializerProvider.getTypeFactory());
    paramJavaType = (JavaType)localObject;
    if (!localJavaType1.hasRawClass(localJavaType2.getRawClass()))
    {
      localBeanDescription = localSerializationConfig.introspect(localJavaType1);
      paramJavaType = findSerializerFromAnnotation(paramSerializerProvider, localBeanDescription.getClassInfo());
    }
    localObject = paramJavaType;
    if (paramJavaType == null)
    {
      localObject = paramJavaType;
      if (!localJavaType1.isJavaLangObject()) {
        localObject = _createSerializer2(paramSerializerProvider, localJavaType1, localBeanDescription, true);
      }
    }
    return new StdDelegatingSerializer(localConverter, localJavaType1, (JsonSerializer)localObject);
  }
  
  protected Iterable<Serializers> customSerializers()
  {
    return _factoryConfig.serializers();
  }
  
  protected List<BeanPropertyWriter> filterBeanProperties(SerializationConfig paramSerializationConfig, BeanDescription paramBeanDescription, List<BeanPropertyWriter> paramList)
  {
    paramSerializationConfig = paramSerializationConfig.getAnnotationIntrospector().findPropertiesToIgnore(paramBeanDescription.getClassInfo(), true);
    if ((paramSerializationConfig != null) && (paramSerializationConfig.length > 0))
    {
      paramSerializationConfig = ArrayBuilders.arrayToSet(paramSerializationConfig);
      paramBeanDescription = paramList.iterator();
      while (paramBeanDescription.hasNext()) {
        if (paramSerializationConfig.contains(((BeanPropertyWriter)paramBeanDescription.next()).getName())) {
          paramBeanDescription.remove();
        }
      }
    }
    return paramList;
  }
  
  protected List<BeanPropertyWriter> findBeanProperties(SerializerProvider paramSerializerProvider, BeanDescription paramBeanDescription, BeanSerializerBuilder paramBeanSerializerBuilder)
    throws JsonMappingException
  {
    Object localObject = paramBeanDescription.findProperties();
    SerializationConfig localSerializationConfig = paramSerializerProvider.getConfig();
    removeIgnorableTypes(localSerializationConfig, paramBeanDescription, (List)localObject);
    if (localSerializationConfig.isEnabled(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS)) {
      removeSetterlessGetters(localSerializationConfig, paramBeanDescription, (List)localObject);
    }
    if (((List)localObject).isEmpty())
    {
      paramBeanDescription = null;
      return paramBeanDescription;
    }
    boolean bool = usesStaticTyping(localSerializationConfig, paramBeanDescription, null);
    PropertyBuilder localPropertyBuilder = constructPropertyBuilder(localSerializationConfig, paramBeanDescription);
    ArrayList localArrayList = new ArrayList(((List)localObject).size());
    TypeBindings localTypeBindings = paramBeanDescription.bindingsForBeanType();
    localObject = ((List)localObject).iterator();
    for (;;)
    {
      paramBeanDescription = localArrayList;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      paramBeanDescription = (BeanPropertyDefinition)((Iterator)localObject).next();
      AnnotatedMember localAnnotatedMember = paramBeanDescription.getAccessor();
      if (paramBeanDescription.isTypeId())
      {
        if (localAnnotatedMember != null)
        {
          if (localSerializationConfig.canOverrideAccessModifiers()) {
            localAnnotatedMember.fixAccess();
          }
          paramBeanSerializerBuilder.setTypeId(localAnnotatedMember);
        }
      }
      else
      {
        AnnotationIntrospector.ReferenceProperty localReferenceProperty = paramBeanDescription.findReferenceType();
        if ((localReferenceProperty == null) || (!localReferenceProperty.isBackReference())) {
          if ((localAnnotatedMember instanceof AnnotatedMethod)) {
            localArrayList.add(_constructWriter(paramSerializerProvider, paramBeanDescription, localTypeBindings, localPropertyBuilder, bool, (AnnotatedMethod)localAnnotatedMember));
          } else {
            localArrayList.add(_constructWriter(paramSerializerProvider, paramBeanDescription, localTypeBindings, localPropertyBuilder, bool, (AnnotatedField)localAnnotatedMember));
          }
        }
      }
    }
  }
  
  public JsonSerializer<Object> findBeanSerializer(SerializerProvider paramSerializerProvider, JavaType paramJavaType, BeanDescription paramBeanDescription)
    throws JsonMappingException
  {
    if ((!isPotentialBeanType(paramJavaType.getRawClass())) && (!paramJavaType.isEnumType())) {
      return null;
    }
    return constructBeanSerializer(paramSerializerProvider, paramBeanDescription);
  }
  
  public TypeSerializer findPropertyContentTypeSerializer(JavaType paramJavaType, SerializationConfig paramSerializationConfig, AnnotatedMember paramAnnotatedMember)
    throws JsonMappingException
  {
    JavaType localJavaType = paramJavaType.getContentType();
    paramJavaType = paramSerializationConfig.getAnnotationIntrospector().findPropertyContentTypeResolver(paramSerializationConfig, paramAnnotatedMember, paramJavaType);
    if (paramJavaType == null) {
      return createTypeSerializer(paramSerializationConfig, localJavaType);
    }
    return paramJavaType.buildTypeSerializer(paramSerializationConfig, localJavaType, paramSerializationConfig.getSubtypeResolver().collectAndResolveSubtypesByClass(paramSerializationConfig, paramAnnotatedMember, localJavaType));
  }
  
  public TypeSerializer findPropertyTypeSerializer(JavaType paramJavaType, SerializationConfig paramSerializationConfig, AnnotatedMember paramAnnotatedMember)
    throws JsonMappingException
  {
    TypeResolverBuilder localTypeResolverBuilder = paramSerializationConfig.getAnnotationIntrospector().findPropertyTypeResolver(paramSerializationConfig, paramAnnotatedMember, paramJavaType);
    if (localTypeResolverBuilder == null) {
      return createTypeSerializer(paramSerializationConfig, paramJavaType);
    }
    return localTypeResolverBuilder.buildTypeSerializer(paramSerializationConfig, paramJavaType, paramSerializationConfig.getSubtypeResolver().collectAndResolveSubtypesByClass(paramSerializationConfig, paramAnnotatedMember, paramJavaType));
  }
  
  protected boolean isPotentialBeanType(Class<?> paramClass)
  {
    return (ClassUtil.canBeABeanType(paramClass) == null) && (!ClassUtil.isProxyType(paramClass));
  }
  
  protected void processViews(SerializationConfig paramSerializationConfig, BeanSerializerBuilder paramBeanSerializerBuilder)
  {
    List localList = paramBeanSerializerBuilder.getProperties();
    boolean bool = paramSerializationConfig.isEnabled(MapperFeature.DEFAULT_VIEW_INCLUSION);
    int m = localList.size();
    int j = 0;
    paramSerializationConfig = new BeanPropertyWriter[m];
    int i = 0;
    if (i < m)
    {
      BeanPropertyWriter localBeanPropertyWriter = (BeanPropertyWriter)localList.get(i);
      Class[] arrayOfClass = localBeanPropertyWriter.getViews();
      int k;
      if (arrayOfClass == null)
      {
        k = j;
        if (bool)
        {
          paramSerializationConfig[i] = localBeanPropertyWriter;
          k = j;
        }
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        k = j + 1;
        paramSerializationConfig[i] = constructFilteredBeanWriter(localBeanPropertyWriter, arrayOfClass);
      }
    }
    if ((bool) && (j == 0)) {
      return;
    }
    paramBeanSerializerBuilder.setFilteredProperties(paramSerializationConfig);
  }
  
  protected void removeIgnorableTypes(SerializationConfig paramSerializationConfig, BeanDescription paramBeanDescription, List<BeanPropertyDefinition> paramList)
  {
    AnnotationIntrospector localAnnotationIntrospector = paramSerializationConfig.getAnnotationIntrospector();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramBeanDescription = ((BeanPropertyDefinition)localIterator.next()).getAccessor();
      if (paramBeanDescription == null)
      {
        localIterator.remove();
      }
      else
      {
        Class localClass = paramBeanDescription.getRawType();
        paramList = (Boolean)localHashMap.get(localClass);
        paramBeanDescription = paramList;
        if (paramList == null)
        {
          paramList = localAnnotationIntrospector.isIgnorableType(paramSerializationConfig.introspectClassAnnotations(localClass).getClassInfo());
          paramBeanDescription = paramList;
          if (paramList == null) {
            paramBeanDescription = Boolean.FALSE;
          }
          localHashMap.put(localClass, paramBeanDescription);
        }
        if (paramBeanDescription.booleanValue()) {
          localIterator.remove();
        }
      }
    }
  }
  
  protected List<BeanPropertyWriter> removeOverlappingTypeIds(SerializerProvider paramSerializerProvider, BeanDescription paramBeanDescription, BeanSerializerBuilder paramBeanSerializerBuilder, List<BeanPropertyWriter> paramList)
  {
    int i = 0;
    int j = paramList.size();
    if (i < j)
    {
      paramSerializerProvider = (BeanPropertyWriter)paramList.get(i);
      paramBeanDescription = paramSerializerProvider.getTypeSerializer();
      if ((paramBeanDescription == null) || (paramBeanDescription.getTypeInclusion() != JsonTypeInfo.As.EXTERNAL_PROPERTY)) {
        label50:
        break label76;
      }
      for (;;)
      {
        i += 1;
        break;
        paramBeanDescription = PropertyName.construct(paramBeanDescription.getPropertyName());
        paramBeanSerializerBuilder = paramList.iterator();
        label76:
        if (paramBeanSerializerBuilder.hasNext())
        {
          BeanPropertyWriter localBeanPropertyWriter = (BeanPropertyWriter)paramBeanSerializerBuilder.next();
          if ((localBeanPropertyWriter == paramSerializerProvider) || (!localBeanPropertyWriter.wouldConflictWithName(paramBeanDescription))) {
            break label50;
          }
          paramSerializerProvider.assignTypeSerializer(null);
        }
      }
    }
    return paramList;
  }
  
  protected void removeSetterlessGetters(SerializationConfig paramSerializationConfig, BeanDescription paramBeanDescription, List<BeanPropertyDefinition> paramList)
  {
    paramSerializationConfig = paramList.iterator();
    while (paramSerializationConfig.hasNext())
    {
      paramBeanDescription = (BeanPropertyDefinition)paramSerializationConfig.next();
      if ((!paramBeanDescription.couldDeserialize()) && (!paramBeanDescription.isExplicitlyIncluded())) {
        paramSerializationConfig.remove();
      }
    }
  }
  
  public SerializerFactory withConfig(SerializerFactoryConfig paramSerializerFactoryConfig)
  {
    if (_factoryConfig == paramSerializerFactoryConfig) {
      return this;
    }
    if (getClass() != BeanSerializerFactory.class) {
      throw new IllegalStateException("Subtype of BeanSerializerFactory (" + getClass().getName() + ") has not properly overridden method 'withAdditionalSerializers': can not instantiate subtype with " + "additional serializer definitions");
    }
    return new BeanSerializerFactory(paramSerializerFactoryConfig);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.BeanSerializerFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */