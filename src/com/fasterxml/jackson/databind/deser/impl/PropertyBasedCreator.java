package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class PropertyBasedCreator
{
  protected final SettableBeanProperty[] _allProperties;
  protected final int _propertyCount;
  protected final HashMap<String, SettableBeanProperty> _propertyLookup;
  protected final ValueInstantiator _valueInstantiator;
  
  protected PropertyBasedCreator(ValueInstantiator paramValueInstantiator, SettableBeanProperty[] paramArrayOfSettableBeanProperty)
  {
    _valueInstantiator = paramValueInstantiator;
    _propertyLookup = new HashMap();
    int j = paramArrayOfSettableBeanProperty.length;
    _propertyCount = j;
    _allProperties = new SettableBeanProperty[j];
    int i = 0;
    while (i < j)
    {
      paramValueInstantiator = paramArrayOfSettableBeanProperty[i];
      _allProperties[i] = paramValueInstantiator;
      _propertyLookup.put(paramValueInstantiator.getName(), paramValueInstantiator);
      i += 1;
    }
  }
  
  public static PropertyBasedCreator construct(DeserializationContext paramDeserializationContext, ValueInstantiator paramValueInstantiator, SettableBeanProperty[] paramArrayOfSettableBeanProperty)
    throws JsonMappingException
  {
    int j = paramArrayOfSettableBeanProperty.length;
    SettableBeanProperty[] arrayOfSettableBeanProperty = new SettableBeanProperty[j];
    int i = 0;
    while (i < j)
    {
      SettableBeanProperty localSettableBeanProperty2 = paramArrayOfSettableBeanProperty[i];
      SettableBeanProperty localSettableBeanProperty1 = localSettableBeanProperty2;
      if (!localSettableBeanProperty2.hasValueDeserializer()) {
        localSettableBeanProperty1 = localSettableBeanProperty2.withValueDeserializer(paramDeserializationContext.findContextualValueDeserializer(localSettableBeanProperty2.getType(), localSettableBeanProperty2));
      }
      arrayOfSettableBeanProperty[i] = localSettableBeanProperty1;
      i += 1;
    }
    return new PropertyBasedCreator(paramValueInstantiator, arrayOfSettableBeanProperty);
  }
  
  public Object build(DeserializationContext paramDeserializationContext, PropertyValueBuffer paramPropertyValueBuffer)
    throws IOException
  {
    Object localObject2 = _valueInstantiator.createFromObjectWith(paramDeserializationContext, paramPropertyValueBuffer.getParameters(_allProperties));
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject2 = paramPropertyValueBuffer.handleIdValue(paramDeserializationContext, localObject2);
      for (paramDeserializationContext = paramPropertyValueBuffer.buffered();; paramDeserializationContext = next)
      {
        localObject1 = localObject2;
        if (paramDeserializationContext == null) {
          break;
        }
        paramDeserializationContext.assign(localObject2);
      }
    }
    return localObject1;
  }
  
  public SettableBeanProperty findCreatorProperty(int paramInt)
  {
    Iterator localIterator = _propertyLookup.values().iterator();
    while (localIterator.hasNext())
    {
      SettableBeanProperty localSettableBeanProperty = (SettableBeanProperty)localIterator.next();
      if (localSettableBeanProperty.getPropertyIndex() == paramInt) {
        return localSettableBeanProperty;
      }
    }
    return null;
  }
  
  public SettableBeanProperty findCreatorProperty(String paramString)
  {
    return (SettableBeanProperty)_propertyLookup.get(paramString);
  }
  
  public Collection<SettableBeanProperty> properties()
  {
    return _propertyLookup.values();
  }
  
  public PropertyValueBuffer startBuilding(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, ObjectIdReader paramObjectIdReader)
  {
    return new PropertyValueBuffer(paramJsonParser, paramDeserializationContext, _propertyCount, paramObjectIdReader);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */