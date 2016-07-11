package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;

public abstract class KeyDeserializer
{
  public abstract Object deserializeKey(String paramString, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException;
  
  public static abstract class None
    extends KeyDeserializer
  {}
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.KeyDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */