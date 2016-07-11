package com.fasterxml.jackson.core;

public class JsonParseException
  extends JsonProcessingException
{
  private static final long serialVersionUID = 1L;
  
  public JsonParseException(String paramString, JsonLocation paramJsonLocation)
  {
    super(paramString, paramJsonLocation);
  }
  
  public JsonParseException(String paramString, JsonLocation paramJsonLocation, Throwable paramThrowable)
  {
    super(paramString, paramJsonLocation, paramThrowable);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.JsonParseException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */