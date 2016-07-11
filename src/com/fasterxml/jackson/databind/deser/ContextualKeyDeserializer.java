package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.KeyDeserializer;

public abstract interface ContextualKeyDeserializer
{
  public abstract KeyDeserializer createContextual(DeserializationContext paramDeserializationContext, BeanProperty paramBeanProperty)
    throws JsonMappingException;
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.ContextualKeyDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */