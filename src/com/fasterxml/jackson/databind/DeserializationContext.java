package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualKeyDeserializer;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.deser.DeserializerCache;
import com.fasterxml.jackson.databind.deser.DeserializerFactory;
import com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.fasterxml.jackson.databind.deser.impl.TypeWrappedDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.LinkedNode;
import com.fasterxml.jackson.databind.util.ObjectBuffer;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

public abstract class DeserializationContext
  extends DatabindContext
  implements Serializable
{
  private static final int MAX_ERROR_STR_LEN = 500;
  private static final long serialVersionUID = 1L;
  protected transient ArrayBuilders _arrayBuilders;
  protected transient ContextAttributes _attributes;
  protected final DeserializerCache _cache;
  protected final DeserializationConfig _config;
  protected LinkedNode<JavaType> _currentType;
  protected transient DateFormat _dateFormat;
  protected final DeserializerFactory _factory;
  protected final int _featureFlags;
  protected final InjectableValues _injectableValues;
  protected transient ObjectBuffer _objectBuffer;
  protected transient JsonParser _parser;
  protected final Class<?> _view;
  
  protected DeserializationContext(DeserializationContext paramDeserializationContext)
  {
    _cache = new DeserializerCache();
    _factory = _factory;
    _config = _config;
    _featureFlags = _featureFlags;
    _view = _view;
    _injectableValues = null;
  }
  
  protected DeserializationContext(DeserializationContext paramDeserializationContext, DeserializationConfig paramDeserializationConfig, JsonParser paramJsonParser, InjectableValues paramInjectableValues)
  {
    _cache = _cache;
    _factory = _factory;
    _config = paramDeserializationConfig;
    _featureFlags = paramDeserializationConfig.getDeserializationFeatures();
    _view = paramDeserializationConfig.getActiveView();
    _parser = paramJsonParser;
    _injectableValues = paramInjectableValues;
    _attributes = paramDeserializationConfig.getAttributes();
  }
  
  protected DeserializationContext(DeserializationContext paramDeserializationContext, DeserializerFactory paramDeserializerFactory)
  {
    _cache = _cache;
    _factory = paramDeserializerFactory;
    _config = _config;
    _featureFlags = _featureFlags;
    _view = _view;
    _parser = _parser;
    _injectableValues = _injectableValues;
    _attributes = _attributes;
  }
  
  protected DeserializationContext(DeserializerFactory paramDeserializerFactory)
  {
    this(paramDeserializerFactory, null);
  }
  
  protected DeserializationContext(DeserializerFactory paramDeserializerFactory, DeserializerCache paramDeserializerCache)
  {
    if (paramDeserializerFactory == null) {
      throw new IllegalArgumentException("Can not pass null DeserializerFactory");
    }
    _factory = paramDeserializerFactory;
    paramDeserializerFactory = paramDeserializerCache;
    if (paramDeserializerCache == null) {
      paramDeserializerFactory = new DeserializerCache();
    }
    _cache = paramDeserializerFactory;
    _featureFlags = 0;
    _config = null;
    _injectableValues = null;
    _view = null;
    _attributes = null;
  }
  
  protected String _calcName(Class<?> paramClass)
  {
    if (paramClass.isArray()) {
      return _calcName(paramClass.getComponentType()) + "[]";
    }
    return paramClass.getName();
  }
  
  protected String _desc(String paramString)
  {
    String str = paramString;
    if (paramString.length() > 500) {
      str = paramString.substring(0, 500) + "]...[" + paramString.substring(paramString.length() - 500);
    }
    return str;
  }
  
  protected String _valueDesc()
  {
    try
    {
      String str = _desc(_parser.getText());
      return str;
    }
    catch (Exception localException) {}
    return "[N/A]";
  }
  
  public abstract void checkUnresolvedObjectId()
    throws UnresolvedForwardReference;
  
  public Calendar constructCalendar(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance(getTimeZone());
    localCalendar.setTime(paramDate);
    return localCalendar;
  }
  
  public final JavaType constructType(Class<?> paramClass)
  {
    return _config.constructType(paramClass);
  }
  
  public abstract JsonDeserializer<Object> deserializerInstance(Annotated paramAnnotated, Object paramObject)
    throws JsonMappingException;
  
  protected String determineClassName(Object paramObject)
  {
    return ClassUtil.getClassDescription(paramObject);
  }
  
  public JsonMappingException endOfInputException(Class<?> paramClass)
  {
    return JsonMappingException.from(_parser, "Unexpected end-of-input when trying to deserialize a " + paramClass.getName());
  }
  
  public Class<?> findClass(String paramString)
    throws ClassNotFoundException
  {
    return getTypeFactory().findClass(paramString);
  }
  
  public final JsonDeserializer<Object> findContextualValueDeserializer(JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    JsonDeserializer localJsonDeserializer2 = _cache.findValueDeserializer(this, _factory, paramJavaType);
    JsonDeserializer localJsonDeserializer1 = localJsonDeserializer2;
    if (localJsonDeserializer2 != null) {
      localJsonDeserializer1 = handleSecondaryContextualization(localJsonDeserializer2, paramBeanProperty, paramJavaType);
    }
    return localJsonDeserializer1;
  }
  
  public final Object findInjectableValue(Object paramObject1, BeanProperty paramBeanProperty, Object paramObject2)
  {
    if (_injectableValues == null) {
      throw new IllegalStateException("No 'injectableValues' configured, can not inject value with id [" + paramObject1 + "]");
    }
    return _injectableValues.findInjectableValue(paramObject1, this, paramBeanProperty, paramObject2);
  }
  
  public final KeyDeserializer findKeyDeserializer(JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    KeyDeserializer localKeyDeserializer = _cache.findKeyDeserializer(this, _factory, paramJavaType);
    paramJavaType = localKeyDeserializer;
    if ((localKeyDeserializer instanceof ContextualKeyDeserializer)) {
      paramJavaType = ((ContextualKeyDeserializer)localKeyDeserializer).createContextual(this, paramBeanProperty);
    }
    return paramJavaType;
  }
  
  public final JsonDeserializer<Object> findNonContextualValueDeserializer(JavaType paramJavaType)
    throws JsonMappingException
  {
    return _cache.findValueDeserializer(this, _factory, paramJavaType);
  }
  
  @Deprecated
  public abstract ReadableObjectId findObjectId(Object paramObject, ObjectIdGenerator<?> paramObjectIdGenerator);
  
  public abstract ReadableObjectId findObjectId(Object paramObject, ObjectIdGenerator<?> paramObjectIdGenerator, ObjectIdResolver paramObjectIdResolver);
  
  public final JsonDeserializer<Object> findRootValueDeserializer(JavaType paramJavaType)
    throws JsonMappingException
  {
    JsonDeserializer localJsonDeserializer = _cache.findValueDeserializer(this, _factory, paramJavaType);
    if (localJsonDeserializer == null) {
      return null;
    }
    localJsonDeserializer = handleSecondaryContextualization(localJsonDeserializer, null, paramJavaType);
    paramJavaType = _factory.findTypeDeserializer(_config, paramJavaType);
    if (paramJavaType != null) {
      return new TypeWrappedDeserializer(paramJavaType.forProperty(null), localJsonDeserializer);
    }
    return localJsonDeserializer;
  }
  
  public final Class<?> getActiveView()
  {
    return _view;
  }
  
  public final AnnotationIntrospector getAnnotationIntrospector()
  {
    return _config.getAnnotationIntrospector();
  }
  
  public final ArrayBuilders getArrayBuilders()
  {
    if (_arrayBuilders == null) {
      _arrayBuilders = new ArrayBuilders();
    }
    return _arrayBuilders;
  }
  
  public Object getAttribute(Object paramObject)
  {
    return _attributes.getAttribute(paramObject);
  }
  
  public final Base64Variant getBase64Variant()
  {
    return _config.getBase64Variant();
  }
  
  public DeserializationConfig getConfig()
  {
    return _config;
  }
  
  public JavaType getContextualType()
  {
    if (_currentType == null) {
      return null;
    }
    return (JavaType)_currentType.value();
  }
  
  protected DateFormat getDateFormat()
  {
    if (_dateFormat != null) {
      return _dateFormat;
    }
    DateFormat localDateFormat = (DateFormat)_config.getDateFormat().clone();
    _dateFormat = localDateFormat;
    return localDateFormat;
  }
  
  public final int getDeserializationFeatures()
  {
    return _featureFlags;
  }
  
  public DeserializerFactory getFactory()
  {
    return _factory;
  }
  
  public Locale getLocale()
  {
    return _config.getLocale();
  }
  
  public final JsonNodeFactory getNodeFactory()
  {
    return _config.getNodeFactory();
  }
  
  public final JsonParser getParser()
  {
    return _parser;
  }
  
  public TimeZone getTimeZone()
  {
    return _config.getTimeZone();
  }
  
  public final TypeFactory getTypeFactory()
  {
    return _config.getTypeFactory();
  }
  
  @Deprecated
  public JsonDeserializer<?> handlePrimaryContextualization(JsonDeserializer<?> paramJsonDeserializer, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    return handlePrimaryContextualization(paramJsonDeserializer, paramBeanProperty, TypeFactory.unknownType());
  }
  
  public JsonDeserializer<?> handlePrimaryContextualization(JsonDeserializer<?> paramJsonDeserializer, BeanProperty paramBeanProperty, JavaType paramJavaType)
    throws JsonMappingException
  {
    Object localObject = paramJsonDeserializer;
    if ((paramJsonDeserializer instanceof ContextualDeserializer)) {
      _currentType = new LinkedNode(paramJavaType, _currentType);
    }
    try
    {
      localObject = ((ContextualDeserializer)paramJsonDeserializer).createContextual(this, paramBeanProperty);
      return (JsonDeserializer<?>)localObject;
    }
    finally
    {
      _currentType = _currentType.next();
    }
  }
  
  @Deprecated
  public JsonDeserializer<?> handleSecondaryContextualization(JsonDeserializer<?> paramJsonDeserializer, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    Object localObject = paramJsonDeserializer;
    if ((paramJsonDeserializer instanceof ContextualDeserializer)) {
      localObject = ((ContextualDeserializer)paramJsonDeserializer).createContextual(this, paramBeanProperty);
    }
    return (JsonDeserializer<?>)localObject;
  }
  
  public JsonDeserializer<?> handleSecondaryContextualization(JsonDeserializer<?> paramJsonDeserializer, BeanProperty paramBeanProperty, JavaType paramJavaType)
    throws JsonMappingException
  {
    Object localObject = paramJsonDeserializer;
    if ((paramJsonDeserializer instanceof ContextualDeserializer)) {
      _currentType = new LinkedNode(paramJavaType, _currentType);
    }
    try
    {
      localObject = ((ContextualDeserializer)paramJsonDeserializer).createContextual(this, paramBeanProperty);
      return (JsonDeserializer<?>)localObject;
    }
    finally
    {
      _currentType = _currentType.next();
    }
  }
  
  public boolean handleUnknownProperty(JsonParser paramJsonParser, JsonDeserializer<?> paramJsonDeserializer, Object paramObject, String paramString)
    throws IOException, JsonProcessingException
  {
    LinkedNode localLinkedNode = _config.getProblemHandlers();
    if (localLinkedNode != null) {
      while (localLinkedNode != null)
      {
        if (((DeserializationProblemHandler)localLinkedNode.value()).handleUnknownProperty(this, paramJsonParser, paramJsonDeserializer, paramObject, paramString)) {
          return true;
        }
        localLinkedNode = localLinkedNode.next();
      }
    }
    return false;
  }
  
  public final boolean hasDeserializationFeatures(int paramInt)
  {
    return (_featureFlags & paramInt) == paramInt;
  }
  
  public final boolean hasSomeOfFeatures(int paramInt)
  {
    return (_featureFlags & paramInt) != 0;
  }
  
  @Deprecated
  public boolean hasValueDeserializerFor(JavaType paramJavaType)
  {
    return hasValueDeserializerFor(paramJavaType, null);
  }
  
  public boolean hasValueDeserializerFor(JavaType paramJavaType, AtomicReference<Throwable> paramAtomicReference)
  {
    try
    {
      boolean bool = _cache.hasValueDeserializerFor(this, _factory, paramJavaType);
      return bool;
    }
    catch (JsonMappingException paramJavaType)
    {
      if (paramAtomicReference != null) {
        paramAtomicReference.set(paramJavaType);
      }
      return false;
    }
    catch (RuntimeException paramJavaType)
    {
      for (;;)
      {
        if (paramAtomicReference == null) {
          throw paramJavaType;
        }
        paramAtomicReference.set(paramJavaType);
      }
    }
  }
  
  public JsonMappingException instantiationException(Class<?> paramClass, String paramString)
  {
    return JsonMappingException.from(_parser, String.format("Can not construct instance of %s, problem: %s", new Object[] { paramClass.getName(), paramString }));
  }
  
  public JsonMappingException instantiationException(Class<?> paramClass, Throwable paramThrowable)
  {
    return JsonMappingException.from(_parser, String.format("Can not construct instance of %s, problem: %s", new Object[] { paramClass.getName(), paramThrowable.getMessage() }), paramThrowable);
  }
  
  public final boolean isEnabled(DeserializationFeature paramDeserializationFeature)
  {
    return (_featureFlags & paramDeserializationFeature.getMask()) != 0;
  }
  
  public abstract KeyDeserializer keyDeserializerInstance(Annotated paramAnnotated, Object paramObject)
    throws JsonMappingException;
  
  public final ObjectBuffer leaseObjectBuffer()
  {
    ObjectBuffer localObjectBuffer = _objectBuffer;
    if (localObjectBuffer == null) {
      return new ObjectBuffer();
    }
    _objectBuffer = null;
    return localObjectBuffer;
  }
  
  public JsonMappingException mappingException(Class<?> paramClass)
  {
    return mappingException(paramClass, _parser.getCurrentToken());
  }
  
  public JsonMappingException mappingException(Class<?> paramClass, JsonToken paramJsonToken)
  {
    return JsonMappingException.from(_parser, String.format("Can not deserialize instance of %s out of %s token", new Object[] { _calcName(paramClass), paramJsonToken }));
  }
  
  public JsonMappingException mappingException(String paramString)
  {
    return JsonMappingException.from(getParser(), paramString);
  }
  
  public JsonMappingException mappingException(String paramString, Object... paramVarArgs)
  {
    paramString = String.format(paramString, paramVarArgs);
    return JsonMappingException.from(getParser(), paramString);
  }
  
  public Date parseDate(String paramString)
    throws IllegalArgumentException
  {
    try
    {
      Date localDate = getDateFormat().parse(paramString);
      return localDate;
    }
    catch (ParseException localParseException)
    {
      throw new IllegalArgumentException(String.format("Failed to parse Date value '%s': %s", new Object[] { paramString, localParseException.getMessage() }));
    }
  }
  
  public <T> T readPropertyValue(JsonParser paramJsonParser, BeanProperty paramBeanProperty, JavaType paramJavaType)
    throws IOException
  {
    JsonDeserializer localJsonDeserializer = findContextualValueDeserializer(paramJavaType, paramBeanProperty);
    if (localJsonDeserializer == null)
    {
      if (paramBeanProperty == null) {}
      for (paramJsonParser = "NULL";; paramJsonParser = "'" + paramBeanProperty.getName() + "'") {
        throw mappingException("Could not find JsonDeserializer for type %s (via property %s)", new Object[] { paramJavaType, paramJsonParser });
      }
    }
    return (T)localJsonDeserializer.deserialize(paramJsonParser, this);
  }
  
  public <T> T readPropertyValue(JsonParser paramJsonParser, BeanProperty paramBeanProperty, Class<T> paramClass)
    throws IOException
  {
    return (T)readPropertyValue(paramJsonParser, paramBeanProperty, getTypeFactory().constructType(paramClass));
  }
  
  public <T> T readValue(JsonParser paramJsonParser, JavaType paramJavaType)
    throws IOException
  {
    JsonDeserializer localJsonDeserializer = findRootValueDeserializer(paramJavaType);
    if (localJsonDeserializer == null) {
      throw mappingException("Could not find JsonDeserializer for type %s", new Object[] { paramJavaType });
    }
    return (T)localJsonDeserializer.deserialize(paramJsonParser, this);
  }
  
  public <T> T readValue(JsonParser paramJsonParser, Class<T> paramClass)
    throws IOException
  {
    return (T)readValue(paramJsonParser, getTypeFactory().constructType(paramClass));
  }
  
  public void reportUnknownProperty(Object paramObject, String paramString, JsonDeserializer<?> paramJsonDeserializer)
    throws JsonMappingException
  {
    if (!isEnabled(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)) {
      return;
    }
    if (paramJsonDeserializer == null) {}
    for (paramJsonDeserializer = null;; paramJsonDeserializer = paramJsonDeserializer.getKnownPropertyNames()) {
      throw UnrecognizedPropertyException.from(_parser, paramObject, paramString, paramJsonDeserializer);
    }
  }
  
  public final void returnObjectBuffer(ObjectBuffer paramObjectBuffer)
  {
    if ((_objectBuffer == null) || (paramObjectBuffer.initialCapacity() >= _objectBuffer.initialCapacity())) {
      _objectBuffer = paramObjectBuffer;
    }
  }
  
  public DeserializationContext setAttribute(Object paramObject1, Object paramObject2)
  {
    _attributes = _attributes.withPerCallAttribute(paramObject1, paramObject2);
    return this;
  }
  
  @Deprecated
  public JsonMappingException unknownTypeException(JavaType paramJavaType, String paramString)
  {
    return JsonMappingException.from(_parser, "Could not resolve type id '" + paramString + "' into a subtype of " + paramJavaType);
  }
  
  public JsonMappingException unknownTypeException(JavaType paramJavaType, String paramString1, String paramString2)
  {
    paramString1 = "Could not resolve type id '" + paramString1 + "' into a subtype of " + paramJavaType;
    paramJavaType = paramString1;
    if (paramString2 != null) {
      paramJavaType = paramString1 + ": " + paramString2;
    }
    return JsonMappingException.from(_parser, paramJavaType);
  }
  
  public JsonMappingException weirdKeyException(Class<?> paramClass, String paramString1, String paramString2)
  {
    return InvalidFormatException.from(_parser, String.format("Can not construct Map key of type %s from String \"%s\": ", new Object[] { paramClass.getName(), _desc(paramString1), paramString2 }), paramString1, paramClass);
  }
  
  public JsonMappingException weirdNumberException(Number paramNumber, Class<?> paramClass, String paramString)
  {
    return InvalidFormatException.from(_parser, String.format("Can not construct instance of %s from number value (%s): %s", new Object[] { paramClass.getName(), _valueDesc(), paramString }), null, paramClass);
  }
  
  public JsonMappingException weirdStringException(String paramString1, Class<?> paramClass, String paramString2)
  {
    return InvalidFormatException.from(_parser, String.format("Can not construct instance of %s from String value '%s': %s", new Object[] { paramClass.getName(), _valueDesc(), paramString2 }), paramString1, paramClass);
  }
  
  public JsonMappingException wrongTokenException(JsonParser paramJsonParser, JsonToken paramJsonToken, String paramString)
  {
    String str = String.format("Unexpected token (%s), expected %s", new Object[] { paramJsonParser.getCurrentToken(), paramJsonToken });
    paramJsonToken = str;
    if (paramString != null) {
      paramJsonToken = str + ": " + paramString;
    }
    return JsonMappingException.from(paramJsonParser, paramJsonToken);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.DeserializationContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */