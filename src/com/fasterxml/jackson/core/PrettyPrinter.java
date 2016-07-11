package com.fasterxml.jackson.core;

import java.io.IOException;

public abstract interface PrettyPrinter
{
  public abstract void beforeArrayValues(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException;
  
  public abstract void beforeObjectEntries(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException;
  
  public abstract void writeArrayValueSeparator(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException;
  
  public abstract void writeEndArray(JsonGenerator paramJsonGenerator, int paramInt)
    throws IOException, JsonGenerationException;
  
  public abstract void writeEndObject(JsonGenerator paramJsonGenerator, int paramInt)
    throws IOException, JsonGenerationException;
  
  public abstract void writeObjectEntrySeparator(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException;
  
  public abstract void writeObjectFieldValueSeparator(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException;
  
  public abstract void writeRootValueSeparator(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException;
  
  public abstract void writeStartArray(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException;
  
  public abstract void writeStartObject(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException;
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.PrettyPrinter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */