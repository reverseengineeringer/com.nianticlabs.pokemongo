package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;

public abstract interface ContextualDeserializer
{
  public abstract JsonDeserializer<?> createContextual(DeserializationContext paramDeserializationContext, BeanProperty paramBeanProperty)
    throws JsonMappingException;
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.ContextualDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */