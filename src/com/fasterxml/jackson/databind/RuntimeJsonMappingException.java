package com.fasterxml.jackson.databind;

public class RuntimeJsonMappingException
  extends RuntimeException
{
  public RuntimeJsonMappingException(JsonMappingException paramJsonMappingException)
  {
    super(paramJsonMappingException);
  }
  
  public RuntimeJsonMappingException(String paramString)
  {
    super(paramString);
  }
  
  public RuntimeJsonMappingException(String paramString, JsonMappingException paramJsonMappingException)
  {
    super(paramString, paramJsonMappingException);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.RuntimeJsonMappingException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */