package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Typing;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.ext.OptionalHandlerFactory;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.BasicBeanDescription;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.impl.IndexedListSerializer;
import com.fasterxml.jackson.databind.ser.impl.IndexedStringListSerializer;
import com.fasterxml.jackson.databind.ser.impl.IteratorSerializer;
import com.fasterxml.jackson.databind.ser.impl.MapEntrySerializer;
import com.fasterxml.jackson.databind.ser.impl.StringArraySerializer;
import com.fasterxml.jackson.databind.ser.impl.StringCollectionSerializer;
import com.fasterxml.jackson.databind.ser.std.AtomicReferenceSerializer;
import com.fasterxml.jackson.databind.ser.std.BooleanSerializer;
import com.fasterxml.jackson.databind.ser.std.ByteBufferSerializer;
import com.fasterxml.jackson.databind.ser.std.CalendarSerializer;
import com.fasterxml.jackson.databind.ser.std.CollectionSerializer;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.databind.ser.std.EnumSerializer;
import com.fasterxml.jackson.databind.ser.std.EnumSetSerializer;
import com.fasterxml.jackson.databind.ser.std.InetAddressSerializer;
import com.fasterxml.jackson.databind.ser.std.InetSocketAddressSerializer;
import com.fasterxml.jackson.databind.ser.std.IterableSerializer;
import com.fasterxml.jackson.databind.ser.std.JsonValueSerializer;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import com.fasterxml.jackson.databind.ser.std.NumberSerializer;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers;
import com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer;
import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;
import com.fasterxml.jackson.databind.ser.std.SqlDateSerializer;
import com.fasterxml.jackson.databind.ser.std.SqlTimeSerializer;
import com.fasterxml.jackson.databind.ser.std.StdArraySerializers;
import com.fasterxml.jackson.databind.ser.std.StdDelegatingSerializer;
import com.fasterxml.jackson.databind.ser.std.StdJdkSerializers;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.fasterxml.jackson.databind.ser.std.TimeZoneSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.Serializable;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.RandomAccess;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

public abstract class BasicSerializerFactory
  extends SerializerFactory
  implements Serializable
{
  protected static final HashMap<String, JsonSerializer<?>> _concrete = new HashMap();
  protected static final HashMap<String, Class<? extends JsonSerializer<?>>> _concreteLazy = new HashMap();
  protected final SerializerFactoryConfig _factoryConfig;
  
  static
  {
    _concrete.put(String.class.getName(), new StringSerializer());
    Object localObject1 = ToStringSerializer.instance;
    _concrete.put(StringBuffer.class.getName(), localObject1);
    _concrete.put(StringBuilder.class.getName(), localObject1);
    _concrete.put(Character.class.getName(), localObject1);
    _concrete.put(Character.TYPE.getName(), localObject1);
    NumberSerializers.addAll(_concrete);
    _concrete.put(Boolean.TYPE.getName(), new BooleanSerializer(true));
    _concrete.put(Boolean.class.getName(), new BooleanSerializer(false));
    _concrete.put(BigInteger.class.getName(), new NumberSerializer(BigInteger.class));
    _concrete.put(BigDecimal.class.getName(), new NumberSerializer(BigDecimal.class));
    _concrete.put(Calendar.class.getName(), CalendarSerializer.instance);
    localObject1 = DateSerializer.instance;
    _concrete.put(java.util.Date.class.getName(), localObject1);
    _concrete.put(Timestamp.class.getName(), localObject1);
    _concreteLazy.put(java.sql.Date.class.getName(), SqlDateSerializer.class);
    _concreteLazy.put(Time.class.getName(), SqlTimeSerializer.class);
    localObject1 = StdJdkSerializers.all().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
      Object localObject2 = localEntry.getValue();
      if ((localObject2 instanceof JsonSerializer))
      {
        _concrete.put(((Class)localEntry.getKey()).getName(), (JsonSerializer)localObject2);
      }
      else if ((localObject2 instanceof Class))
      {
        localObject2 = (Class)localObject2;
        _concreteLazy.put(((Class)localEntry.getKey()).getName(), localObject2);
      }
      else
      {
        throw new IllegalStateException("Internal error: unrecognized value of type " + localEntry.getClass().getName());
      }
    }
    _concreteLazy.put(TokenBuffer.class.getName(), TokenBufferSerializer.class);
  }
  
  protected BasicSerializerFactory(SerializerFactoryConfig paramSerializerFactoryConfig)
  {
    SerializerFactoryConfig localSerializerFactoryConfig = paramSerializerFactoryConfig;
    if (paramSerializerFactoryConfig == null) {
      localSerializerFactoryConfig = new SerializerFactoryConfig();
    }
    _factoryConfig = localSerializerFactoryConfig;
  }
  
  /* Error */
  protected static <T extends JavaType> T modifySecondaryTypesByAnnotation(SerializationConfig paramSerializationConfig, Annotated paramAnnotated, T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 179	com/fasterxml/jackson/databind/SerializationConfig:getAnnotationIntrospector	()Lcom/fasterxml/jackson/databind/AnnotationIntrospector;
    //   4: astore 4
    //   6: aload_2
    //   7: astore_3
    //   8: aload_2
    //   9: invokevirtual 184	com/fasterxml/jackson/databind/JavaType:isContainerType	()Z
    //   12: ifeq +91 -> 103
    //   15: aload 4
    //   17: aload_1
    //   18: aload_2
    //   19: invokevirtual 188	com/fasterxml/jackson/databind/JavaType:getKeyType	()Lcom/fasterxml/jackson/databind/JavaType;
    //   22: invokevirtual 194	com/fasterxml/jackson/databind/AnnotationIntrospector:findSerializationKeyType	(Lcom/fasterxml/jackson/databind/introspect/Annotated;Lcom/fasterxml/jackson/databind/JavaType;)Ljava/lang/Class;
    //   25: astore_3
    //   26: aload_2
    //   27: astore_0
    //   28: aload_3
    //   29: ifnull +51 -> 80
    //   32: aload_2
    //   33: instanceof 196
    //   36: ifne +35 -> 71
    //   39: new 173	java/lang/IllegalArgumentException
    //   42: dup
    //   43: new 51	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   50: ldc -58
    //   52: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_2
    //   56: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   59: ldc -53
    //   61: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokespecial 204	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   70: athrow
    //   71: aload_2
    //   72: checkcast 196	com/fasterxml/jackson/databind/type/MapType
    //   75: aload_3
    //   76: invokevirtual 208	com/fasterxml/jackson/databind/type/MapType:widenKey	(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JavaType;
    //   79: astore_0
    //   80: aload 4
    //   82: aload_1
    //   83: aload_0
    //   84: invokevirtual 211	com/fasterxml/jackson/databind/JavaType:getContentType	()Lcom/fasterxml/jackson/databind/JavaType;
    //   87: invokevirtual 214	com/fasterxml/jackson/databind/AnnotationIntrospector:findSerializationContentType	(Lcom/fasterxml/jackson/databind/introspect/Annotated;Lcom/fasterxml/jackson/databind/JavaType;)Ljava/lang/Class;
    //   90: astore_1
    //   91: aload_0
    //   92: astore_3
    //   93: aload_1
    //   94: ifnull +9 -> 103
    //   97: aload_0
    //   98: aload_1
    //   99: invokevirtual 217	com/fasterxml/jackson/databind/JavaType:widenContentsBy	(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JavaType;
    //   102: astore_3
    //   103: aload_3
    //   104: areturn
    //   105: astore_0
    //   106: new 173	java/lang/IllegalArgumentException
    //   109: dup
    //   110: new 51	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   117: ldc -37
    //   119: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_2
    //   123: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   126: ldc -35
    //   128: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_3
    //   132: invokevirtual 34	java/lang/Class:getName	()Ljava/lang/String;
    //   135: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc -33
    //   140: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_0
    //   144: invokevirtual 226	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   147: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokespecial 204	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   156: athrow
    //   157: astore_2
    //   158: new 173	java/lang/IllegalArgumentException
    //   161: dup
    //   162: new 51	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   169: ldc -28
    //   171: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_0
    //   175: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   178: ldc -26
    //   180: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload_1
    //   184: invokevirtual 34	java/lang/Class:getName	()Ljava/lang/String;
    //   187: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc -33
    //   192: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_2
    //   196: invokevirtual 226	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   199: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokespecial 204	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   208: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	paramSerializationConfig	SerializationConfig
    //   0	209	1	paramAnnotated	Annotated
    //   0	209	2	paramT	T
    //   7	125	3	localObject	Object
    //   4	77	4	localAnnotationIntrospector	AnnotationIntrospector
    // Exception table:
    //   from	to	target	type
    //   71	80	105	java/lang/IllegalArgumentException
    //   97	103	157	java/lang/IllegalArgumentException
  }
  
  protected JsonSerializer<Object> _findContentSerializer(SerializerProvider paramSerializerProvider, Annotated paramAnnotated)
    throws JsonMappingException
  {
    Object localObject = paramSerializerProvider.getAnnotationIntrospector().findContentSerializer(paramAnnotated);
    if (localObject != null) {
      return paramSerializerProvider.serializerInstance(paramAnnotated, localObject);
    }
    return null;
  }
  
  protected JsonSerializer<Object> _findKeySerializer(SerializerProvider paramSerializerProvider, Annotated paramAnnotated)
    throws JsonMappingException
  {
    Object localObject = paramSerializerProvider.getAnnotationIntrospector().findKeySerializer(paramAnnotated);
    if (localObject != null) {
      return paramSerializerProvider.serializerInstance(paramAnnotated, localObject);
    }
    return null;
  }
  
  protected Class<?> _verifyAsClass(Object paramObject, String paramString, Class<?> paramClass)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    do
    {
      return (Class<?>)paramObject;
      if (!(paramObject instanceof Class)) {
        throw new IllegalStateException("AnnotationIntrospector." + paramString + "() returned value of type " + paramObject.getClass().getName() + ": expected type JsonSerializer or Class<JsonSerializer> instead");
      }
      paramString = (Class)paramObject;
      if (paramString == paramClass) {
        break;
      }
      paramObject = paramString;
    } while (!ClassUtil.isBogusClass(paramString));
    return null;
  }
  
  protected JsonSerializer<?> buildArraySerializer(SerializerProvider paramSerializerProvider, ArrayType paramArrayType, BeanDescription paramBeanDescription, boolean paramBoolean, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer)
    throws JsonMappingException
  {
    SerializationConfig localSerializationConfig = paramSerializerProvider.getConfig();
    Object localObject = null;
    Iterator localIterator = customSerializers().iterator();
    while (localIterator.hasNext())
    {
      paramSerializerProvider = ((Serializers)localIterator.next()).findArraySerializer(localSerializationConfig, paramArrayType, paramBeanDescription, paramTypeSerializer, paramJsonSerializer);
      localObject = paramSerializerProvider;
      if (paramSerializerProvider != null) {
        localObject = paramSerializerProvider;
      }
    }
    paramSerializerProvider = (SerializerProvider)localObject;
    if (localObject == null)
    {
      paramSerializerProvider = paramArrayType.getRawClass();
      if ((paramJsonSerializer == null) || (ClassUtil.isJacksonStdImpl(paramJsonSerializer))) {
        if (String[].class != paramSerializerProvider) {
          break label190;
        }
      }
    }
    label190:
    for (localObject = StringArraySerializer.instance;; localObject = StdArraySerializers.findStandardImpl(paramSerializerProvider))
    {
      paramSerializerProvider = (SerializerProvider)localObject;
      if (localObject == null) {
        paramSerializerProvider = new ObjectArraySerializer(paramArrayType.getContentType(), paramBoolean, paramTypeSerializer, paramJsonSerializer);
      }
      paramTypeSerializer = paramSerializerProvider;
      if (!_factoryConfig.hasSerializerModifiers()) {
        break;
      }
      paramJsonSerializer = _factoryConfig.serializerModifiers().iterator();
      for (;;)
      {
        paramTypeSerializer = paramSerializerProvider;
        if (!paramJsonSerializer.hasNext()) {
          break;
        }
        paramSerializerProvider = ((BeanSerializerModifier)paramJsonSerializer.next()).modifyArraySerializer(localSerializationConfig, paramArrayType, paramBeanDescription, paramSerializerProvider);
      }
    }
    return paramTypeSerializer;
  }
  
  protected JsonSerializer<?> buildCollectionSerializer(SerializerProvider paramSerializerProvider, CollectionType paramCollectionType, BeanDescription paramBeanDescription, boolean paramBoolean, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer)
    throws JsonMappingException
  {
    SerializationConfig localSerializationConfig = paramSerializerProvider.getConfig();
    Object localObject1 = null;
    Iterator localIterator = customSerializers().iterator();
    Object localObject2;
    do
    {
      localObject2 = localObject1;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject2 = ((Serializers)localIterator.next()).findCollectionSerializer(localSerializationConfig, paramCollectionType, paramBeanDescription, paramTypeSerializer, paramJsonSerializer);
      localObject1 = localObject2;
    } while (localObject2 == null);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = findSerializerByAnnotations(paramSerializerProvider, paramCollectionType, paramBeanDescription);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        paramSerializerProvider = paramBeanDescription.findExpectedFormat(null);
        if ((paramSerializerProvider != null) && (paramSerializerProvider.getShape() == JsonFormat.Shape.OBJECT)) {
          return null;
        }
        paramSerializerProvider = paramCollectionType.getRawClass();
        if (!EnumSet.class.isAssignableFrom(paramSerializerProvider)) {
          break label222;
        }
        paramTypeSerializer = paramCollectionType.getContentType();
        paramSerializerProvider = paramTypeSerializer;
        if (!paramTypeSerializer.isEnumType()) {
          paramSerializerProvider = null;
        }
        localObject1 = buildEnumSetSerializer(paramSerializerProvider);
      }
    }
    paramSerializerProvider = (SerializerProvider)localObject1;
    if (_factoryConfig.hasSerializerModifiers())
    {
      paramTypeSerializer = _factoryConfig.serializerModifiers().iterator();
      for (;;)
      {
        paramSerializerProvider = (SerializerProvider)localObject1;
        if (!paramTypeSerializer.hasNext()) {
          break;
        }
        localObject1 = ((BeanSerializerModifier)paramTypeSerializer.next()).modifyCollectionSerializer(localSerializationConfig, paramCollectionType, paramBeanDescription, (JsonSerializer)localObject1);
      }
      label222:
      localObject1 = paramCollectionType.getContentType().getRawClass();
      if (isIndexedList(paramSerializerProvider)) {
        if (localObject1 == String.class) {
          if (paramJsonSerializer != null)
          {
            paramSerializerProvider = (SerializerProvider)localObject2;
            if (!ClassUtil.isJacksonStdImpl(paramJsonSerializer)) {}
          }
          else
          {
            paramSerializerProvider = IndexedStringListSerializer.instance;
          }
        }
      }
      for (;;)
      {
        localObject1 = paramSerializerProvider;
        if (paramSerializerProvider != null) {
          break;
        }
        localObject1 = buildCollectionSerializer(paramCollectionType.getContentType(), paramBoolean, paramTypeSerializer, paramJsonSerializer);
        break;
        paramSerializerProvider = buildIndexedListSerializer(paramCollectionType.getContentType(), paramBoolean, paramTypeSerializer, paramJsonSerializer);
        continue;
        paramSerializerProvider = (SerializerProvider)localObject2;
        if (localObject1 == String.class) {
          if (paramJsonSerializer != null)
          {
            paramSerializerProvider = (SerializerProvider)localObject2;
            if (!ClassUtil.isJacksonStdImpl(paramJsonSerializer)) {}
          }
          else
          {
            paramSerializerProvider = StringCollectionSerializer.instance;
          }
        }
      }
    }
    return paramSerializerProvider;
  }
  
  public ContainerSerializer<?> buildCollectionSerializer(JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer)
  {
    return new CollectionSerializer(paramJavaType, paramBoolean, paramTypeSerializer, paramJsonSerializer);
  }
  
  protected JsonSerializer<?> buildContainerSerializer(SerializerProvider paramSerializerProvider, JavaType paramJavaType, BeanDescription paramBeanDescription, boolean paramBoolean)
    throws JsonMappingException
  {
    SerializationConfig localSerializationConfig = paramSerializerProvider.getConfig();
    boolean bool = paramBoolean;
    if (!paramBoolean)
    {
      bool = paramBoolean;
      if (paramJavaType.useStaticType()) {
        if (paramJavaType.isContainerType())
        {
          bool = paramBoolean;
          if (paramJavaType.getContentType().getRawClass() == Object.class) {}
        }
        else
        {
          bool = true;
        }
      }
    }
    TypeSerializer localTypeSerializer = createTypeSerializer(localSerializationConfig, paramJavaType.getContentType());
    if (localTypeSerializer != null) {
      bool = false;
    }
    JsonSerializer localJsonSerializer = _findContentSerializer(paramSerializerProvider, paramBeanDescription.getClassInfo());
    Object localObject1;
    Object localObject4;
    if (paramJavaType.isMapLikeType())
    {
      localObject1 = (MapLikeType)paramJavaType;
      localObject4 = _findKeySerializer(paramSerializerProvider, paramBeanDescription.getClassInfo());
      if (((MapLikeType)localObject1).isTrueMapType()) {
        paramSerializerProvider = buildMapSerializer(paramSerializerProvider, (MapType)localObject1, paramBeanDescription, bool, (JsonSerializer)localObject4, localTypeSerializer, localJsonSerializer);
      }
    }
    Object localObject3;
    do
    {
      do
      {
        Object localObject2;
        do
        {
          do
          {
            return paramSerializerProvider;
            localObject1 = null;
            localObject3 = (MapLikeType)paramJavaType;
            Iterator localIterator = customSerializers().iterator();
            do
            {
              localObject2 = localObject1;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject2 = ((Serializers)localIterator.next()).findMapLikeSerializer(localSerializationConfig, (MapLikeType)localObject3, paramBeanDescription, (JsonSerializer)localObject4, localTypeSerializer, localJsonSerializer);
              localObject1 = localObject2;
            } while (localObject2 == null);
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = findSerializerByAnnotations(paramSerializerProvider, paramJavaType, paramBeanDescription);
            }
            paramSerializerProvider = (SerializerProvider)localObject1;
          } while (localObject1 == null);
          paramSerializerProvider = (SerializerProvider)localObject1;
        } while (!_factoryConfig.hasSerializerModifiers());
        paramJavaType = _factoryConfig.serializerModifiers().iterator();
        for (;;)
        {
          paramSerializerProvider = (SerializerProvider)localObject1;
          if (!paramJavaType.hasNext()) {
            break;
          }
          localObject1 = ((BeanSerializerModifier)paramJavaType.next()).modifyMapLikeSerializer(localSerializationConfig, (MapLikeType)localObject3, paramBeanDescription, (JsonSerializer)localObject1);
        }
        if (!paramJavaType.isCollectionLikeType()) {
          break;
        }
        localObject1 = (CollectionLikeType)paramJavaType;
        if (((CollectionLikeType)localObject1).isTrueCollectionType()) {
          return buildCollectionSerializer(paramSerializerProvider, (CollectionType)localObject1, paramBeanDescription, bool, localTypeSerializer, localJsonSerializer);
        }
        localObject1 = null;
        localObject3 = (CollectionLikeType)paramJavaType;
        localObject4 = customSerializers().iterator();
        do
        {
          localObject2 = localObject1;
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          localObject2 = ((Serializers)((Iterator)localObject4).next()).findCollectionLikeSerializer(localSerializationConfig, (CollectionLikeType)localObject3, paramBeanDescription, localTypeSerializer, localJsonSerializer);
          localObject1 = localObject2;
        } while (localObject2 == null);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = findSerializerByAnnotations(paramSerializerProvider, paramJavaType, paramBeanDescription);
        }
        paramSerializerProvider = (SerializerProvider)localObject1;
      } while (localObject1 == null);
      paramSerializerProvider = (SerializerProvider)localObject1;
    } while (!_factoryConfig.hasSerializerModifiers());
    paramJavaType = _factoryConfig.serializerModifiers().iterator();
    for (;;)
    {
      paramSerializerProvider = (SerializerProvider)localObject1;
      if (!paramJavaType.hasNext()) {
        break;
      }
      localObject1 = ((BeanSerializerModifier)paramJavaType.next()).modifyCollectionLikeSerializer(localSerializationConfig, (CollectionLikeType)localObject3, paramBeanDescription, (JsonSerializer)localObject1);
    }
    if (paramJavaType.isArrayType()) {
      return buildArraySerializer(paramSerializerProvider, (ArrayType)paramJavaType, paramBeanDescription, bool, localTypeSerializer, localJsonSerializer);
    }
    return null;
  }
  
  protected JsonSerializer<?> buildEnumSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BeanDescription paramBeanDescription)
    throws JsonMappingException
  {
    Object localObject1 = null;
    Object localObject2 = paramBeanDescription.findExpectedFormat(null);
    if ((localObject2 != null) && (((JsonFormat.Value)localObject2).getShape() == JsonFormat.Shape.OBJECT)) {
      ((BasicBeanDescription)paramBeanDescription).removeProperty("declaringClass");
    }
    do
    {
      return (JsonSerializer<?>)localObject1;
      localObject2 = EnumSerializer.construct(paramJavaType.getRawClass(), paramSerializationConfig, paramBeanDescription, (JsonFormat.Value)localObject2);
      localObject1 = localObject2;
    } while (!_factoryConfig.hasSerializerModifiers());
    Iterator localIterator = _factoryConfig.serializerModifiers().iterator();
    for (;;)
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject2 = ((BeanSerializerModifier)localIterator.next()).modifyEnumSerializer(paramSerializationConfig, paramJavaType, paramBeanDescription, (JsonSerializer)localObject2);
    }
  }
  
  public JsonSerializer<?> buildEnumSetSerializer(JavaType paramJavaType)
  {
    return new EnumSetSerializer(paramJavaType);
  }
  
  public ContainerSerializer<?> buildIndexedListSerializer(JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer)
  {
    return new IndexedListSerializer(paramJavaType, paramBoolean, paramTypeSerializer, paramJsonSerializer);
  }
  
  @Deprecated
  protected JsonSerializer<?> buildIterableSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BeanDescription paramBeanDescription, boolean paramBoolean)
    throws JsonMappingException
  {
    Object localObject = paramSerializationConfig.getTypeFactory().findTypeParameters(paramJavaType, Iterable.class);
    if ((localObject == null) || (localObject.length != 1)) {}
    for (localObject = TypeFactory.unknownType();; localObject = localObject[0]) {
      return buildIterableSerializer(paramSerializationConfig, paramJavaType, paramBeanDescription, paramBoolean, (JavaType)localObject);
    }
  }
  
  protected JsonSerializer<?> buildIterableSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType1, BeanDescription paramBeanDescription, boolean paramBoolean, JavaType paramJavaType2)
    throws JsonMappingException
  {
    return new IterableSerializer(paramJavaType2, paramBoolean, createTypeSerializer(paramSerializationConfig, paramJavaType2));
  }
  
  @Deprecated
  protected JsonSerializer<?> buildIteratorSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BeanDescription paramBeanDescription, boolean paramBoolean)
    throws JsonMappingException
  {
    Object localObject = paramSerializationConfig.getTypeFactory().findTypeParameters(paramJavaType, Iterator.class);
    if ((localObject == null) || (localObject.length != 1)) {}
    for (localObject = TypeFactory.unknownType();; localObject = localObject[0]) {
      return buildIteratorSerializer(paramSerializationConfig, paramJavaType, paramBeanDescription, paramBoolean, (JavaType)localObject);
    }
  }
  
  protected JsonSerializer<?> buildIteratorSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType1, BeanDescription paramBeanDescription, boolean paramBoolean, JavaType paramJavaType2)
    throws JsonMappingException
  {
    return new IteratorSerializer(paramJavaType2, paramBoolean, createTypeSerializer(paramSerializationConfig, paramJavaType2));
  }
  
  protected JsonSerializer<?> buildMapEntrySerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType1, BeanDescription paramBeanDescription, boolean paramBoolean, JavaType paramJavaType2, JavaType paramJavaType3)
    throws JsonMappingException
  {
    return new MapEntrySerializer(paramJavaType3, paramJavaType2, paramJavaType3, paramBoolean, createTypeSerializer(paramSerializationConfig, paramJavaType3), null);
  }
  
  protected JsonSerializer<?> buildMapSerializer(SerializerProvider paramSerializerProvider, MapType paramMapType, BeanDescription paramBeanDescription, boolean paramBoolean, JsonSerializer<Object> paramJsonSerializer1, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer2)
    throws JsonMappingException
  {
    SerializationConfig localSerializationConfig = paramSerializerProvider.getConfig();
    Object localObject1 = null;
    Iterator localIterator = customSerializers().iterator();
    Object localObject2;
    do
    {
      localObject2 = localObject1;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject2 = ((Serializers)localIterator.next()).findMapSerializer(localSerializationConfig, paramMapType, paramBeanDescription, paramJsonSerializer1, paramTypeSerializer, paramJsonSerializer2);
      localObject1 = localObject2;
    } while (localObject2 == null);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      paramSerializerProvider = findSerializerByAnnotations(paramSerializerProvider, paramMapType, paramBeanDescription);
      localObject1 = paramSerializerProvider;
      if (paramSerializerProvider == null)
      {
        paramSerializerProvider = findFilterId(localSerializationConfig, paramBeanDescription);
        paramJsonSerializer1 = MapSerializer.construct(localSerializationConfig.getAnnotationIntrospector().findPropertiesToIgnore(paramBeanDescription.getClassInfo(), true), paramMapType, paramBoolean, paramTypeSerializer, paramJsonSerializer1, paramJsonSerializer2, paramSerializerProvider);
        paramTypeSerializer = findSuppressableContentValue(localSerializationConfig, paramMapType.getContentType(), paramBeanDescription);
        paramSerializerProvider = paramJsonSerializer1;
        if (paramTypeSerializer != null) {
          paramSerializerProvider = paramJsonSerializer1.withContentInclusion(paramTypeSerializer);
        }
        localObject1 = paramSerializerProvider;
      }
    }
    paramSerializerProvider = (SerializerProvider)localObject1;
    if (_factoryConfig.hasSerializerModifiers())
    {
      paramJsonSerializer1 = _factoryConfig.serializerModifiers().iterator();
      for (;;)
      {
        paramSerializerProvider = (SerializerProvider)localObject1;
        if (!paramJsonSerializer1.hasNext()) {
          break;
        }
        localObject1 = ((BeanSerializerModifier)paramJsonSerializer1.next()).modifyMapSerializer(localSerializationConfig, paramMapType, paramBeanDescription, (JsonSerializer)localObject1);
      }
    }
    return paramSerializerProvider;
  }
  
  public JsonSerializer<Object> createKeySerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, JsonSerializer<Object> paramJsonSerializer)
  {
    BeanDescription localBeanDescription = paramSerializationConfig.introspectClassAnnotations(paramJavaType.getRawClass());
    Object localObject2 = null;
    Object localObject1 = null;
    if (_factoryConfig.hasKeySerializers())
    {
      localObject3 = _factoryConfig.keySerializers().iterator();
      localObject2 = localObject1;
      while (((Iterator)localObject3).hasNext())
      {
        localObject1 = ((Serializers)((Iterator)localObject3).next()).findSerializer(paramSerializationConfig, paramJavaType, localBeanDescription);
        localObject2 = localObject1;
        if (localObject1 != null) {
          localObject2 = localObject1;
        }
      }
    }
    Object localObject3 = localBeanDescription;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject3 = localBeanDescription;
      localObject1 = paramJsonSerializer;
      if (paramJsonSerializer == null)
      {
        paramJsonSerializer = StdKeySerializers.getStdKeySerializer(paramSerializationConfig, paramJavaType.getRawClass(), false);
        localObject3 = localBeanDescription;
        localObject1 = paramJsonSerializer;
        if (paramJsonSerializer == null)
        {
          localObject3 = paramSerializationConfig.introspect(paramJavaType);
          localObject1 = ((BeanDescription)localObject3).findJsonValueMethod();
          if (localObject1 == null) {
            break label258;
          }
          paramJsonSerializer = StdKeySerializers.getStdKeySerializer(paramSerializationConfig, ((AnnotatedMethod)localObject1).getRawReturnType(), true);
          localObject1 = ((AnnotatedMethod)localObject1).getAnnotated();
          if (paramSerializationConfig.canOverrideAccessModifiers()) {
            ClassUtil.checkAndFixAccess((Member)localObject1);
          }
        }
      }
    }
    label258:
    for (localObject1 = new JsonValueSerializer((Method)localObject1, paramJsonSerializer);; localObject1 = StdKeySerializers.getFallbackKeySerializer(paramSerializationConfig, paramJavaType.getRawClass()))
    {
      paramJsonSerializer = (JsonSerializer<Object>)localObject1;
      if (!_factoryConfig.hasSerializerModifiers()) {
        break;
      }
      localObject2 = _factoryConfig.serializerModifiers().iterator();
      for (;;)
      {
        paramJsonSerializer = (JsonSerializer<Object>)localObject1;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = ((BeanSerializerModifier)((Iterator)localObject2).next()).modifyKeySerializer(paramSerializationConfig, paramJavaType, (BeanDescription)localObject3, (JsonSerializer)localObject1);
      }
    }
    return paramJsonSerializer;
  }
  
  public abstract JsonSerializer<Object> createSerializer(SerializerProvider paramSerializerProvider, JavaType paramJavaType)
    throws JsonMappingException;
  
  public TypeSerializer createTypeSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType)
  {
    AnnotatedClass localAnnotatedClass = paramSerializationConfig.introspectClassAnnotations(paramJavaType.getRawClass()).getClassInfo();
    TypeResolverBuilder localTypeResolverBuilder = paramSerializationConfig.getAnnotationIntrospector().findTypeResolver(paramSerializationConfig, localAnnotatedClass, paramJavaType);
    Collection localCollection = null;
    if (localTypeResolverBuilder == null) {
      localTypeResolverBuilder = paramSerializationConfig.getDefaultTyper(paramJavaType);
    }
    while (localTypeResolverBuilder == null)
    {
      return null;
      localCollection = paramSerializationConfig.getSubtypeResolver().collectAndResolveSubtypesByClass(paramSerializationConfig, localAnnotatedClass);
    }
    return localTypeResolverBuilder.buildTypeSerializer(paramSerializationConfig, paramJavaType, localCollection);
  }
  
  protected abstract Iterable<Serializers> customSerializers();
  
  protected Converter<Object, Object> findConverter(SerializerProvider paramSerializerProvider, Annotated paramAnnotated)
    throws JsonMappingException
  {
    Object localObject = paramSerializerProvider.getAnnotationIntrospector().findSerializationConverter(paramAnnotated);
    if (localObject == null) {
      return null;
    }
    return paramSerializerProvider.converterInstance(paramAnnotated, localObject);
  }
  
  protected JsonSerializer<?> findConvertingSerializer(SerializerProvider paramSerializerProvider, Annotated paramAnnotated, JsonSerializer<?> paramJsonSerializer)
    throws JsonMappingException
  {
    paramAnnotated = findConverter(paramSerializerProvider, paramAnnotated);
    if (paramAnnotated == null) {
      return paramJsonSerializer;
    }
    return new StdDelegatingSerializer(paramAnnotated, paramAnnotated.getOutputType(paramSerializerProvider.getTypeFactory()), paramJsonSerializer);
  }
  
  protected Object findFilterId(SerializationConfig paramSerializationConfig, BeanDescription paramBeanDescription)
  {
    return paramSerializationConfig.getAnnotationIntrospector().findFilterId(paramBeanDescription.getClassInfo());
  }
  
  protected JsonSerializer<?> findOptionalStdSerializer(SerializerProvider paramSerializerProvider, JavaType paramJavaType, BeanDescription paramBeanDescription, boolean paramBoolean)
    throws JsonMappingException
  {
    return OptionalHandlerFactory.instance.findSerializer(paramSerializerProvider.getConfig(), paramJavaType, paramBeanDescription);
  }
  
  protected final JsonSerializer<?> findSerializerByAddonType(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BeanDescription paramBeanDescription, boolean paramBoolean)
    throws JsonMappingException
  {
    Object localObject = paramJavaType.getRawClass();
    if (Iterator.class.isAssignableFrom((Class)localObject))
    {
      localObject = paramSerializationConfig.getTypeFactory().findTypeParameters(paramJavaType, Iterator.class);
      if ((localObject == null) || (localObject.length != 1)) {}
      for (localObject = TypeFactory.unknownType();; localObject = localObject[0]) {
        return buildIteratorSerializer(paramSerializationConfig, paramJavaType, paramBeanDescription, paramBoolean, (JavaType)localObject);
      }
    }
    if (Iterable.class.isAssignableFrom((Class)localObject))
    {
      localObject = paramSerializationConfig.getTypeFactory().findTypeParameters(paramJavaType, Iterable.class);
      if ((localObject == null) || (localObject.length != 1)) {}
      for (localObject = TypeFactory.unknownType();; localObject = localObject[0]) {
        return buildIterableSerializer(paramSerializationConfig, paramJavaType, paramBeanDescription, paramBoolean, (JavaType)localObject);
      }
    }
    if (CharSequence.class.isAssignableFrom((Class)localObject)) {
      return ToStringSerializer.instance;
    }
    return null;
  }
  
  protected final JsonSerializer<?> findSerializerByAnnotations(SerializerProvider paramSerializerProvider, JavaType paramJavaType, BeanDescription paramBeanDescription)
    throws JsonMappingException
  {
    if (JsonSerializable.class.isAssignableFrom(paramJavaType.getRawClass())) {
      return SerializableSerializer.instance;
    }
    paramJavaType = paramBeanDescription.findJsonValueMethod();
    if (paramJavaType != null)
    {
      paramBeanDescription = paramJavaType.getAnnotated();
      if (paramSerializerProvider.canOverrideAccessModifiers()) {
        ClassUtil.checkAndFixAccess(paramBeanDescription);
      }
      return new JsonValueSerializer(paramBeanDescription, findSerializerFromAnnotation(paramSerializerProvider, paramJavaType));
    }
    return null;
  }
  
  protected final JsonSerializer<?> findSerializerByLookup(JavaType paramJavaType, SerializationConfig paramSerializationConfig, BeanDescription paramBeanDescription, boolean paramBoolean)
  {
    paramSerializationConfig = paramJavaType.getRawClass().getName();
    if ((paramJavaType.isReferenceType()) && (paramJavaType.isTypeOrSubTypeOf(AtomicReference.class))) {
      return new AtomicReferenceSerializer((ReferenceType)paramJavaType);
    }
    paramBeanDescription = (JsonSerializer)_concrete.get(paramSerializationConfig);
    if (paramBeanDescription == null)
    {
      paramJavaType = (Class)_concreteLazy.get(paramSerializationConfig);
      if (paramJavaType != null) {
        try
        {
          paramSerializationConfig = (JsonSerializer)paramJavaType.newInstance();
          return paramSerializationConfig;
        }
        catch (Exception paramSerializationConfig)
        {
          throw new IllegalStateException("Failed to instantiate standard serializer (of type " + paramJavaType.getName() + "): " + paramSerializationConfig.getMessage(), paramSerializationConfig);
        }
      }
    }
    return paramBeanDescription;
  }
  
  protected final JsonSerializer<?> findSerializerByPrimaryType(SerializerProvider paramSerializerProvider, JavaType paramJavaType, BeanDescription paramBeanDescription, boolean paramBoolean)
    throws JsonMappingException
  {
    Object localObject1 = paramJavaType.getRawClass();
    Object localObject2 = findOptionalStdSerializer(paramSerializerProvider, paramJavaType, paramBeanDescription, paramBoolean);
    if (localObject2 != null) {
      return (JsonSerializer<?>)localObject2;
    }
    if (Calendar.class.isAssignableFrom((Class)localObject1)) {
      return CalendarSerializer.instance;
    }
    if (java.util.Date.class.isAssignableFrom((Class)localObject1)) {
      return DateSerializer.instance;
    }
    if (Map.Entry.class.isAssignableFrom((Class)localObject1))
    {
      localObject2 = paramJavaType.containedType(0);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = TypeFactory.unknownType();
      }
      JavaType localJavaType = paramJavaType.containedType(1);
      localObject2 = localJavaType;
      if (localJavaType == null) {
        localObject2 = TypeFactory.unknownType();
      }
      return buildMapEntrySerializer(paramSerializerProvider.getConfig(), paramJavaType, paramBeanDescription, paramBoolean, (JavaType)localObject1, (JavaType)localObject2);
    }
    if (ByteBuffer.class.isAssignableFrom((Class)localObject1)) {
      return new ByteBufferSerializer();
    }
    if (InetAddress.class.isAssignableFrom((Class)localObject1)) {
      return new InetAddressSerializer();
    }
    if (InetSocketAddress.class.isAssignableFrom((Class)localObject1)) {
      return new InetSocketAddressSerializer();
    }
    if (TimeZone.class.isAssignableFrom((Class)localObject1)) {
      return new TimeZoneSerializer();
    }
    if (Charset.class.isAssignableFrom((Class)localObject1)) {
      return ToStringSerializer.instance;
    }
    if (Number.class.isAssignableFrom((Class)localObject1))
    {
      paramSerializerProvider = paramBeanDescription.findExpectedFormat(null);
      if (paramSerializerProvider != null) {}
      switch (1.$SwitchMap$com$fasterxml$jackson$annotation$JsonFormat$Shape[paramSerializerProvider.getShape().ordinal()])
      {
      default: 
        return NumberSerializer.instance;
      case 1: 
        return ToStringSerializer.instance;
      }
      return null;
    }
    if (Enum.class.isAssignableFrom((Class)localObject1)) {
      return buildEnumSerializer(paramSerializerProvider.getConfig(), paramJavaType, paramBeanDescription);
    }
    return null;
  }
  
  protected JsonSerializer<Object> findSerializerFromAnnotation(SerializerProvider paramSerializerProvider, Annotated paramAnnotated)
    throws JsonMappingException
  {
    Object localObject = paramSerializerProvider.getAnnotationIntrospector().findSerializer(paramAnnotated);
    if (localObject == null) {
      return null;
    }
    return findConvertingSerializer(paramSerializerProvider, paramAnnotated, paramSerializerProvider.serializerInstance(paramAnnotated, localObject));
  }
  
  protected Object findSuppressableContentValue(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BeanDescription paramBeanDescription)
    throws JsonMappingException
  {
    paramSerializationConfig = null;
    paramJavaType = paramBeanDescription.findSerializationInclusionForContent(null);
    if (paramJavaType != null) {
      switch (paramJavaType)
      {
      }
    }
    for (paramSerializationConfig = paramJavaType;; paramSerializationConfig = JsonInclude.Include.NON_EMPTY) {
      return paramSerializationConfig;
    }
  }
  
  public SerializerFactoryConfig getFactoryConfig()
  {
    return _factoryConfig;
  }
  
  protected boolean isIndexedList(Class<?> paramClass)
  {
    return RandomAccess.class.isAssignableFrom(paramClass);
  }
  
  protected <T extends JavaType> T modifyTypeByAnnotation(SerializationConfig paramSerializationConfig, Annotated paramAnnotated, T paramT)
  {
    Class localClass = paramSerializationConfig.getAnnotationIntrospector().findSerializationType(paramAnnotated);
    Object localObject = paramT;
    if (localClass != null) {}
    try
    {
      localObject = paramT.widenBy(localClass);
      return modifySecondaryTypesByAnnotation(paramSerializationConfig, paramAnnotated, (JavaType)localObject);
    }
    catch (IllegalArgumentException paramSerializationConfig)
    {
      throw new IllegalArgumentException("Failed to widen type " + paramT + " with concrete-type annotation (value " + localClass.getName() + "), method '" + paramAnnotated.getName() + "': " + paramSerializationConfig.getMessage());
    }
  }
  
  protected boolean usesStaticTyping(SerializationConfig paramSerializationConfig, BeanDescription paramBeanDescription, TypeSerializer paramTypeSerializer)
  {
    if (paramTypeSerializer != null) {}
    do
    {
      return false;
      paramBeanDescription = paramSerializationConfig.getAnnotationIntrospector().findSerializationTyping(paramBeanDescription.getClassInfo());
      if ((paramBeanDescription == null) || (paramBeanDescription == JsonSerialize.Typing.DEFAULT_TYPING)) {
        break;
      }
    } while (paramBeanDescription != JsonSerialize.Typing.STATIC);
    return true;
    return paramSerializationConfig.isEnabled(MapperFeature.USE_STATIC_TYPING);
  }
  
  public final SerializerFactory withAdditionalKeySerializers(Serializers paramSerializers)
  {
    return withConfig(_factoryConfig.withAdditionalKeySerializers(paramSerializers));
  }
  
  public final SerializerFactory withAdditionalSerializers(Serializers paramSerializers)
  {
    return withConfig(_factoryConfig.withAdditionalSerializers(paramSerializers));
  }
  
  public abstract SerializerFactory withConfig(SerializerFactoryConfig paramSerializerFactoryConfig);
  
  public final SerializerFactory withSerializerModifier(BeanSerializerModifier paramBeanSerializerModifier)
  {
    return withConfig(_factoryConfig.withSerializerModifier(paramBeanSerializerModifier));
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.BasicSerializerFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */