package com.fasterxml.jackson.databind.jsonFormatVisitors;

import com.fasterxml.jackson.databind.SerializerProvider;

public abstract interface JsonFormatVisitorWithSerializerProvider
{
  public abstract SerializerProvider getProvider();
  
  public abstract void setProvider(SerializerProvider paramSerializerProvider);
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWithSerializerProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */