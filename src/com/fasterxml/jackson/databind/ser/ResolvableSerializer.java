package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializerProvider;

public abstract interface ResolvableSerializer
{
  public abstract void resolve(SerializerProvider paramSerializerProvider)
    throws JsonMappingException;
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.ResolvableSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */