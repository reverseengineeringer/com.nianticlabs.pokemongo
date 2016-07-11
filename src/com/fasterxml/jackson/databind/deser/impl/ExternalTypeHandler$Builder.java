package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.util.ArrayList;
import java.util.HashMap;

public class ExternalTypeHandler$Builder
{
  private final HashMap<String, Integer> _nameToPropertyIndex = new HashMap();
  private final ArrayList<ExternalTypeHandler.ExtTypedProperty> _properties = new ArrayList();
  
  public void addExternal(SettableBeanProperty paramSettableBeanProperty, TypeDeserializer paramTypeDeserializer)
  {
    Integer localInteger = Integer.valueOf(_properties.size());
    _properties.add(new ExternalTypeHandler.ExtTypedProperty(paramSettableBeanProperty, paramTypeDeserializer));
    _nameToPropertyIndex.put(paramSettableBeanProperty.getName(), localInteger);
    _nameToPropertyIndex.put(paramTypeDeserializer.getPropertyName(), localInteger);
  }
  
  public ExternalTypeHandler build()
  {
    return new ExternalTypeHandler((ExternalTypeHandler.ExtTypedProperty[])_properties.toArray(new ExternalTypeHandler.ExtTypedProperty[_properties.size()]), _nameToPropertyIndex, null, null);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */