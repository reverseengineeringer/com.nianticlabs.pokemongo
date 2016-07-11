package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.impl.FailingDeserializer;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.Annotations;
import com.fasterxml.jackson.databind.util.ViewMatcher;
import java.io.IOException;
import java.io.Serializable;
import java.lang.annotation.Annotation;

public abstract class SettableBeanProperty
  implements BeanProperty, Serializable
{
  protected static final JsonDeserializer<Object> MISSING_VALUE_DESERIALIZER = new FailingDeserializer("No _valueDeserializer assigned");
  protected final transient Annotations _contextAnnotations;
  protected String _managedReferenceName;
  protected final PropertyMetadata _metadata;
  protected ObjectIdInfo _objectIdInfo;
  protected final PropertyName _propName;
  protected int _propertyIndex = -1;
  protected final JavaType _type;
  protected final JsonDeserializer<Object> _valueDeserializer;
  protected final TypeDeserializer _valueTypeDeserializer;
  protected ViewMatcher _viewMatcher;
  protected final PropertyName _wrapperName;
  
  protected SettableBeanProperty(PropertyName paramPropertyName, JavaType paramJavaType, PropertyMetadata paramPropertyMetadata, JsonDeserializer<Object> paramJsonDeserializer)
  {
    if (paramPropertyName == null) {}
    for (_propName = PropertyName.NO_NAME;; _propName = paramPropertyName.internSimpleName())
    {
      _type = paramJavaType;
      _wrapperName = null;
      _metadata = paramPropertyMetadata;
      _contextAnnotations = null;
      _viewMatcher = null;
      _valueTypeDeserializer = null;
      _valueDeserializer = paramJsonDeserializer;
      return;
    }
  }
  
  protected SettableBeanProperty(PropertyName paramPropertyName1, JavaType paramJavaType, PropertyName paramPropertyName2, TypeDeserializer paramTypeDeserializer, Annotations paramAnnotations, PropertyMetadata paramPropertyMetadata)
  {
    if (paramPropertyName1 == null) {}
    for (_propName = PropertyName.NO_NAME;; _propName = paramPropertyName1.internSimpleName())
    {
      _type = paramJavaType;
      _wrapperName = paramPropertyName2;
      _metadata = paramPropertyMetadata;
      _contextAnnotations = paramAnnotations;
      _viewMatcher = null;
      paramPropertyName1 = paramTypeDeserializer;
      if (paramTypeDeserializer != null) {
        paramPropertyName1 = paramTypeDeserializer.forProperty(this);
      }
      _valueTypeDeserializer = paramPropertyName1;
      _valueDeserializer = MISSING_VALUE_DESERIALIZER;
      return;
    }
  }
  
  protected SettableBeanProperty(SettableBeanProperty paramSettableBeanProperty)
  {
    _propName = _propName;
    _type = _type;
    _wrapperName = _wrapperName;
    _metadata = _metadata;
    _contextAnnotations = _contextAnnotations;
    _valueDeserializer = _valueDeserializer;
    _valueTypeDeserializer = _valueTypeDeserializer;
    _managedReferenceName = _managedReferenceName;
    _propertyIndex = _propertyIndex;
    _viewMatcher = _viewMatcher;
  }
  
  protected SettableBeanProperty(SettableBeanProperty paramSettableBeanProperty, JsonDeserializer<?> paramJsonDeserializer)
  {
    _propName = _propName;
    _type = _type;
    _wrapperName = _wrapperName;
    _metadata = _metadata;
    _contextAnnotations = _contextAnnotations;
    _valueTypeDeserializer = _valueTypeDeserializer;
    _managedReferenceName = _managedReferenceName;
    _propertyIndex = _propertyIndex;
    if (paramJsonDeserializer == null) {}
    for (_valueDeserializer = MISSING_VALUE_DESERIALIZER;; _valueDeserializer = paramJsonDeserializer)
    {
      _viewMatcher = _viewMatcher;
      return;
    }
  }
  
  protected SettableBeanProperty(SettableBeanProperty paramSettableBeanProperty, PropertyName paramPropertyName)
  {
    _propName = paramPropertyName;
    _type = _type;
    _wrapperName = _wrapperName;
    _metadata = _metadata;
    _contextAnnotations = _contextAnnotations;
    _valueDeserializer = _valueDeserializer;
    _valueTypeDeserializer = _valueTypeDeserializer;
    _managedReferenceName = _managedReferenceName;
    _propertyIndex = _propertyIndex;
    _viewMatcher = _viewMatcher;
  }
  
  @Deprecated
  protected SettableBeanProperty(SettableBeanProperty paramSettableBeanProperty, String paramString)
  {
    this(paramSettableBeanProperty, new PropertyName(paramString));
  }
  
  protected SettableBeanProperty(BeanPropertyDefinition paramBeanPropertyDefinition, JavaType paramJavaType, TypeDeserializer paramTypeDeserializer, Annotations paramAnnotations)
  {
    this(paramBeanPropertyDefinition.getFullName(), paramJavaType, paramBeanPropertyDefinition.getWrapperName(), paramTypeDeserializer, paramAnnotations, paramBeanPropertyDefinition.getMetadata());
  }
  
  @Deprecated
  protected SettableBeanProperty(String paramString, JavaType paramJavaType, PropertyName paramPropertyName, TypeDeserializer paramTypeDeserializer, Annotations paramAnnotations, boolean paramBoolean)
  {
    this(new PropertyName(paramString), paramJavaType, paramPropertyName, paramTypeDeserializer, paramAnnotations, PropertyMetadata.construct(paramBoolean, null, null, null));
  }
  
  protected IOException _throwAsIOE(Exception paramException)
    throws IOException
  {
    if ((paramException instanceof IOException)) {
      throw ((IOException)paramException);
    }
    if ((paramException instanceof RuntimeException)) {
      throw ((RuntimeException)paramException);
    }
    while (paramException.getCause() != null) {
      paramException = paramException.getCause();
    }
    throw new JsonMappingException(paramException.getMessage(), null, paramException);
  }
  
  protected void _throwAsIOE(Exception paramException, Object paramObject)
    throws IOException
  {
    if ((paramException instanceof IllegalArgumentException))
    {
      StringBuilder localStringBuilder;
      if (paramObject == null)
      {
        paramObject = "[NULL]";
        localStringBuilder = new StringBuilder("Problem deserializing property '").append(getName());
        localStringBuilder.append("' (expected type: ").append(getType());
        localStringBuilder.append("; actual type: ").append((String)paramObject).append(")");
        paramObject = paramException.getMessage();
        if (paramObject == null) {
          break label106;
        }
        localStringBuilder.append(", problem: ").append((String)paramObject);
      }
      for (;;)
      {
        throw new JsonMappingException(localStringBuilder.toString(), null, paramException);
        paramObject = paramObject.getClass().getName();
        break;
        label106:
        localStringBuilder.append(" (no error message provided)");
      }
    }
    _throwAsIOE(paramException);
  }
  
  public void assignIndex(int paramInt)
  {
    if (_propertyIndex != -1) {
      throw new IllegalStateException("Property '" + getName() + "' already had index (" + _propertyIndex + "), trying to assign " + paramInt);
    }
    _propertyIndex = paramInt;
  }
  
  public void depositSchemaProperty(JsonObjectFormatVisitor paramJsonObjectFormatVisitor)
    throws JsonMappingException
  {
    if (isRequired())
    {
      paramJsonObjectFormatVisitor.property(this);
      return;
    }
    paramJsonObjectFormatVisitor.optionalProperty(this);
  }
  
  public final Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    if (paramJsonParser.getCurrentToken() == JsonToken.VALUE_NULL) {
      return _valueDeserializer.getNullValue(paramDeserializationContext);
    }
    if (_valueTypeDeserializer != null) {
      return _valueDeserializer.deserializeWithType(paramJsonParser, paramDeserializationContext, _valueTypeDeserializer);
    }
    return _valueDeserializer.deserialize(paramJsonParser, paramDeserializationContext);
  }
  
  public abstract void deserializeAndSet(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException;
  
  public abstract Object deserializeSetAndReturn(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException;
  
  public JsonFormat.Value findFormatOverrides(AnnotationIntrospector paramAnnotationIntrospector)
  {
    if (paramAnnotationIntrospector != null)
    {
      AnnotatedMember localAnnotatedMember = getMember();
      if (localAnnotatedMember != null) {
        return paramAnnotationIntrospector.findFormat(localAnnotatedMember);
      }
    }
    return null;
  }
  
  public abstract <A extends Annotation> A getAnnotation(Class<A> paramClass);
  
  public <A extends Annotation> A getContextAnnotation(Class<A> paramClass)
  {
    return _contextAnnotations.get(paramClass);
  }
  
  public int getCreatorIndex()
  {
    return -1;
  }
  
  protected final Class<?> getDeclaringClass()
  {
    return getMember().getDeclaringClass();
  }
  
  public PropertyName getFullName()
  {
    return _propName;
  }
  
  public Object getInjectableValueId()
  {
    return null;
  }
  
  public String getManagedReferenceName()
  {
    return _managedReferenceName;
  }
  
  public abstract AnnotatedMember getMember();
  
  public PropertyMetadata getMetadata()
  {
    return _metadata;
  }
  
  public final String getName()
  {
    return _propName.getSimpleName();
  }
  
  public ObjectIdInfo getObjectIdInfo()
  {
    return _objectIdInfo;
  }
  
  public int getPropertyIndex()
  {
    return _propertyIndex;
  }
  
  public JavaType getType()
  {
    return _type;
  }
  
  public JsonDeserializer<Object> getValueDeserializer()
  {
    JsonDeserializer localJsonDeserializer2 = _valueDeserializer;
    JsonDeserializer localJsonDeserializer1 = localJsonDeserializer2;
    if (localJsonDeserializer2 == MISSING_VALUE_DESERIALIZER) {
      localJsonDeserializer1 = null;
    }
    return localJsonDeserializer1;
  }
  
  public TypeDeserializer getValueTypeDeserializer()
  {
    return _valueTypeDeserializer;
  }
  
  public PropertyName getWrapperName()
  {
    return _wrapperName;
  }
  
  public boolean hasValueDeserializer()
  {
    return (_valueDeserializer != null) && (_valueDeserializer != MISSING_VALUE_DESERIALIZER);
  }
  
  public boolean hasValueTypeDeserializer()
  {
    return _valueTypeDeserializer != null;
  }
  
  public boolean hasViews()
  {
    return _viewMatcher != null;
  }
  
  public boolean isRequired()
  {
    return _metadata.isRequired();
  }
  
  public abstract void set(Object paramObject1, Object paramObject2)
    throws IOException;
  
  public abstract Object setAndReturn(Object paramObject1, Object paramObject2)
    throws IOException;
  
  public void setManagedReferenceName(String paramString)
  {
    _managedReferenceName = paramString;
  }
  
  public void setObjectIdInfo(ObjectIdInfo paramObjectIdInfo)
  {
    _objectIdInfo = paramObjectIdInfo;
  }
  
  public void setViews(Class<?>[] paramArrayOfClass)
  {
    if (paramArrayOfClass == null)
    {
      _viewMatcher = null;
      return;
    }
    _viewMatcher = ViewMatcher.construct(paramArrayOfClass);
  }
  
  public String toString()
  {
    return "[property '" + getName() + "']";
  }
  
  public boolean visibleInView(Class<?> paramClass)
  {
    return (_viewMatcher == null) || (_viewMatcher.isVisibleForView(paramClass));
  }
  
  public abstract SettableBeanProperty withName(PropertyName paramPropertyName);
  
  @Deprecated
  public SettableBeanProperty withName(String paramString)
  {
    return withName(new PropertyName(paramString));
  }
  
  public SettableBeanProperty withSimpleName(String paramString)
  {
    if (_propName == null) {}
    for (paramString = new PropertyName(paramString); paramString == _propName; paramString = _propName.withSimpleName(paramString)) {
      return this;
    }
    return withName(paramString);
  }
  
  public abstract SettableBeanProperty withValueDeserializer(JsonDeserializer<?> paramJsonDeserializer);
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.SettableBeanProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */