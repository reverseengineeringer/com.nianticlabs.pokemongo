package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;

public abstract interface ResolvableDeserializer
{
  public abstract void resolve(DeserializationContext paramDeserializationContext)
    throws JsonMappingException;
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.ResolvableDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */