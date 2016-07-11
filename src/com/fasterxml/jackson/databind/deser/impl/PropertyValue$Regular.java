package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import java.io.IOException;

final class PropertyValue$Regular
  extends PropertyValue
{
  final SettableBeanProperty _property;
  
  public PropertyValue$Regular(PropertyValue paramPropertyValue, Object paramObject, SettableBeanProperty paramSettableBeanProperty)
  {
    super(paramPropertyValue, paramObject);
    _property = paramSettableBeanProperty;
  }
  
  public void assign(Object paramObject)
    throws IOException, JsonProcessingException
  {
    _property.set(paramObject, value);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.impl.PropertyValue.Regular
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */