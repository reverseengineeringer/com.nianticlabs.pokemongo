package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId.Referring;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Method;

public class SettableAnyProperty
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final BeanProperty _property;
  protected final AnnotatedMethod _setter;
  protected final JavaType _type;
  protected JsonDeserializer<Object> _valueDeserializer;
  protected final TypeDeserializer _valueTypeDeserializer;
  
  public SettableAnyProperty(BeanProperty paramBeanProperty, AnnotatedMethod paramAnnotatedMethod, JavaType paramJavaType, JsonDeserializer<Object> paramJsonDeserializer, TypeDeserializer paramTypeDeserializer)
  {
    _property = paramBeanProperty;
    _setter = paramAnnotatedMethod;
    _type = paramJavaType;
    _valueDeserializer = paramJsonDeserializer;
    _valueTypeDeserializer = paramTypeDeserializer;
  }
  
  protected SettableAnyProperty(SettableAnyProperty paramSettableAnyProperty)
  {
    _property = _property;
    _setter = _setter;
    _type = _type;
    _valueDeserializer = _valueDeserializer;
    _valueTypeDeserializer = _valueTypeDeserializer;
  }
  
  private String getClassName()
  {
    return _setter.getDeclaringClass().getName();
  }
  
  protected void _throwAsIOE(Exception paramException, String paramString, Object paramObject)
    throws IOException
  {
    if ((paramException instanceof IllegalArgumentException))
    {
      if (paramObject == null)
      {
        paramObject = "[NULL]";
        paramString = new StringBuilder("Problem deserializing \"any\" property '").append(paramString);
        paramString.append("' of class " + getClassName() + " (expected type: ").append(_type);
        paramString.append("; actual type: ").append((String)paramObject).append(")");
        paramObject = paramException.getMessage();
        if (paramObject == null) {
          break label128;
        }
        paramString.append(", problem: ").append((String)paramObject);
      }
      for (;;)
      {
        throw new JsonMappingException(paramString.toString(), null, paramException);
        paramObject = paramObject.getClass().getName();
        break;
        label128:
        paramString.append(" (no error message provided)");
      }
    }
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
  
  public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    if (paramJsonParser.getCurrentToken() == JsonToken.VALUE_NULL) {
      return null;
    }
    if (_valueTypeDeserializer != null) {
      return _valueDeserializer.deserializeWithType(paramJsonParser, paramDeserializationContext, _valueTypeDeserializer);
    }
    return _valueDeserializer.deserialize(paramJsonParser, paramDeserializationContext);
  }
  
  public final void deserializeAndSet(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject, String paramString)
    throws IOException
  {
    try
    {
      set(paramObject, paramString, deserialize(paramJsonParser, paramDeserializationContext));
      return;
    }
    catch (UnresolvedForwardReference paramDeserializationContext)
    {
      if (_valueDeserializer.getObjectIdReader() == null) {
        throw JsonMappingException.from(paramJsonParser, "Unresolved forward reference but no identity info.", paramDeserializationContext);
      }
      paramJsonParser = new AnySetterReferring(this, paramDeserializationContext, _type.getRawClass(), paramObject, paramString);
      paramDeserializationContext.getRoid().appendReferring(paramJsonParser);
    }
  }
  
  public BeanProperty getProperty()
  {
    return _property;
  }
  
  public JavaType getType()
  {
    return _type;
  }
  
  public boolean hasValueDeserializer()
  {
    return _valueDeserializer != null;
  }
  
  Object readResolve()
  {
    if ((_setter == null) || (_setter.getAnnotated() == null)) {
      throw new IllegalArgumentException("Missing method (broken JDK (de)serialization?)");
    }
    return this;
  }
  
  public void set(Object paramObject1, String paramString, Object paramObject2)
    throws IOException
  {
    try
    {
      _setter.getAnnotated().invoke(paramObject1, new Object[] { paramString, paramObject2 });
      return;
    }
    catch (Exception paramObject1)
    {
      _throwAsIOE((Exception)paramObject1, paramString, paramObject2);
    }
  }
  
  public String toString()
  {
    return "[any property on class " + getClassName() + "]";
  }
  
  public SettableAnyProperty withValueDeserializer(JsonDeserializer<Object> paramJsonDeserializer)
  {
    return new SettableAnyProperty(_property, _setter, _type, paramJsonDeserializer, _valueTypeDeserializer);
  }
  
  private static class AnySetterReferring
    extends ReadableObjectId.Referring
  {
    private final SettableAnyProperty _parent;
    private final Object _pojo;
    private final String _propName;
    
    public AnySetterReferring(SettableAnyProperty paramSettableAnyProperty, UnresolvedForwardReference paramUnresolvedForwardReference, Class<?> paramClass, Object paramObject, String paramString)
    {
      super(paramClass);
      _parent = paramSettableAnyProperty;
      _pojo = paramObject;
      _propName = paramString;
    }
    
    public void handleResolvedForwardReference(Object paramObject1, Object paramObject2)
      throws IOException
    {
      if (!hasId(paramObject1)) {
        throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + paramObject1.toString() + "] that wasn't previously registered.");
      }
      _parent.set(_pojo, _propName, paramObject2);
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.SettableAnyProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */