package com.fasterxml.jackson.databind.exc;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;

public class InvalidFormatException
  extends JsonMappingException
{
  private static final long serialVersionUID = 1L;
  protected final Class<?> _targetType;
  protected final Object _value;
  
  public InvalidFormatException(String paramString, JsonLocation paramJsonLocation, Object paramObject, Class<?> paramClass)
  {
    super(paramString, paramJsonLocation);
    _value = paramObject;
    _targetType = paramClass;
  }
  
  public InvalidFormatException(String paramString, Object paramObject, Class<?> paramClass)
  {
    super(paramString);
    _value = paramObject;
    _targetType = paramClass;
  }
  
  public static InvalidFormatException from(JsonParser paramJsonParser, String paramString, Object paramObject, Class<?> paramClass)
  {
    return new InvalidFormatException(paramString, paramJsonParser.getTokenLocation(), paramObject, paramClass);
  }
  
  public Class<?> getTargetType()
  {
    return _targetType;
  }
  
  public Object getValue()
  {
    return _value;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.exc.InvalidFormatException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */