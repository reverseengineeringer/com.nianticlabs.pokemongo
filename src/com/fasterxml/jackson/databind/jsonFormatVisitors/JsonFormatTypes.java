package com.fasterxml.jackson.databind.jsonFormatVisitors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

public enum JsonFormatTypes
{
  private static final Map<String, JsonFormatTypes> _byLCName;
  
  static
  {
    NUMBER = new JsonFormatTypes("NUMBER", 1);
    INTEGER = new JsonFormatTypes("INTEGER", 2);
    BOOLEAN = new JsonFormatTypes("BOOLEAN", 3);
    OBJECT = new JsonFormatTypes("OBJECT", 4);
    ARRAY = new JsonFormatTypes("ARRAY", 5);
    NULL = new JsonFormatTypes("NULL", 6);
    ANY = new JsonFormatTypes("ANY", 7);
    $VALUES = new JsonFormatTypes[] { STRING, NUMBER, INTEGER, BOOLEAN, OBJECT, ARRAY, NULL, ANY };
    _byLCName = new HashMap();
    JsonFormatTypes[] arrayOfJsonFormatTypes = values();
    int j = arrayOfJsonFormatTypes.length;
    int i = 0;
    while (i < j)
    {
      JsonFormatTypes localJsonFormatTypes = arrayOfJsonFormatTypes[i];
      _byLCName.put(localJsonFormatTypes.name().toLowerCase(), localJsonFormatTypes);
      i += 1;
    }
  }
  
  private JsonFormatTypes() {}
  
  @JsonCreator
  public static JsonFormatTypes forValue(String paramString)
  {
    return (JsonFormatTypes)_byLCName.get(paramString);
  }
  
  @JsonValue
  public String value()
  {
    return name().toLowerCase();
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */