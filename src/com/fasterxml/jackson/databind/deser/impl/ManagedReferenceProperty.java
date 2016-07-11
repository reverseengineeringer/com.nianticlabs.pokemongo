package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.util.Annotations;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class ManagedReferenceProperty
  extends SettableBeanProperty
{
  private static final long serialVersionUID = 1L;
  protected final SettableBeanProperty _backProperty;
  protected final boolean _isContainer;
  protected final SettableBeanProperty _managedProperty;
  protected final String _referenceName;
  
  public ManagedReferenceProperty(SettableBeanProperty paramSettableBeanProperty1, String paramString, SettableBeanProperty paramSettableBeanProperty2, Annotations paramAnnotations, boolean paramBoolean)
  {
    super(paramSettableBeanProperty1.getFullName(), paramSettableBeanProperty1.getType(), paramSettableBeanProperty1.getWrapperName(), paramSettableBeanProperty1.getValueTypeDeserializer(), paramAnnotations, paramSettableBeanProperty1.getMetadata());
    _referenceName = paramString;
    _managedProperty = paramSettableBeanProperty1;
    _backProperty = paramSettableBeanProperty2;
    _isContainer = paramBoolean;
  }
  
  protected ManagedReferenceProperty(ManagedReferenceProperty paramManagedReferenceProperty, JsonDeserializer<?> paramJsonDeserializer)
  {
    super(paramManagedReferenceProperty, paramJsonDeserializer);
    _referenceName = _referenceName;
    _isContainer = _isContainer;
    _managedProperty = _managedProperty;
    _backProperty = _backProperty;
  }
  
  protected ManagedReferenceProperty(ManagedReferenceProperty paramManagedReferenceProperty, PropertyName paramPropertyName)
  {
    super(paramManagedReferenceProperty, paramPropertyName);
    _referenceName = _referenceName;
    _isContainer = _isContainer;
    _managedProperty = _managedProperty;
    _backProperty = _backProperty;
  }
  
  public void deserializeAndSet(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException
  {
    set(paramObject, _managedProperty.deserialize(paramJsonParser, paramDeserializationContext));
  }
  
  public Object deserializeSetAndReturn(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException
  {
    return setAndReturn(paramObject, deserialize(paramJsonParser, paramDeserializationContext));
  }
  
  public <A extends Annotation> A getAnnotation(Class<A> paramClass)
  {
    return _managedProperty.getAnnotation(paramClass);
  }
  
  public AnnotatedMember getMember()
  {
    return _managedProperty.getMember();
  }
  
  public final void set(Object paramObject1, Object paramObject2)
    throws IOException
  {
    setAndReturn(paramObject1, paramObject2);
  }
  
  public Object setAndReturn(Object paramObject1, Object paramObject2)
    throws IOException
  {
    if (paramObject2 != null)
    {
      if (_isContainer)
      {
        Object localObject1;
        Object localObject2;
        if ((paramObject2 instanceof Object[]))
        {
          localObject1 = (Object[])paramObject2;
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            localObject2 = localObject1[i];
            if (localObject2 != null) {
              _backProperty.set(localObject2, paramObject1);
            }
            i += 1;
          }
        }
        if ((paramObject2 instanceof Collection))
        {
          localObject1 = ((Collection)paramObject2).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            if (localObject2 != null) {
              _backProperty.set(localObject2, paramObject1);
            }
          }
        }
        if ((paramObject2 instanceof Map))
        {
          localObject1 = ((Map)paramObject2).values().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            if (localObject2 != null) {
              _backProperty.set(localObject2, paramObject1);
            }
          }
        }
        throw new IllegalStateException("Unsupported container type (" + paramObject2.getClass().getName() + ") when resolving reference '" + _referenceName + "'");
      }
      _backProperty.set(paramObject2, paramObject1);
    }
    return _managedProperty.setAndReturn(paramObject1, paramObject2);
  }
  
  public ManagedReferenceProperty withName(PropertyName paramPropertyName)
  {
    return new ManagedReferenceProperty(this, paramPropertyName);
  }
  
  public ManagedReferenceProperty withValueDeserializer(JsonDeserializer<?> paramJsonDeserializer)
  {
    return new ManagedReferenceProperty(this, paramJsonDeserializer);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.impl.ManagedReferenceProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */