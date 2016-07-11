package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

public class RawValue
  implements JsonSerializable
{
  protected Object _value;
  
  public RawValue(SerializableString paramSerializableString)
  {
    _value = paramSerializableString;
  }
  
  public RawValue(JsonSerializable paramJsonSerializable)
  {
    _value = paramJsonSerializable;
  }
  
  protected RawValue(Object paramObject, boolean paramBoolean)
  {
    _value = paramObject;
  }
  
  public RawValue(String paramString)
  {
    _value = paramString;
  }
  
  protected void _serialize(JsonGenerator paramJsonGenerator)
    throws IOException
  {
    if ((_value instanceof SerializableString))
    {
      paramJsonGenerator.writeRawValue((SerializableString)_value);
      return;
    }
    paramJsonGenerator.writeRawValue(String.valueOf(_value));
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof RawValue)) {
        return false;
      }
      paramObject = (RawValue)paramObject;
    } while ((_value == _value) || ((_value != null) && (_value.equals(_value))));
    return false;
  }
  
  public int hashCode()
  {
    if (_value == null) {
      return 0;
    }
    return _value.hashCode();
  }
  
  public Object rawValue()
  {
    return _value;
  }
  
  public void serialize(JsonGenerator paramJsonGenerator)
    throws IOException
  {
    if ((_value instanceof JsonSerializable))
    {
      paramJsonGenerator.writeObject(_value);
      return;
    }
    _serialize(paramJsonGenerator);
  }
  
  public void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    if ((_value instanceof JsonSerializable))
    {
      ((JsonSerializable)_value).serialize(paramJsonGenerator, paramSerializerProvider);
      return;
    }
    _serialize(paramJsonGenerator);
  }
  
  public void serializeWithType(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
    throws IOException
  {
    if ((_value instanceof JsonSerializable)) {
      ((JsonSerializable)_value).serializeWithType(paramJsonGenerator, paramSerializerProvider, paramTypeSerializer);
    }
    while (!(_value instanceof SerializableString)) {
      return;
    }
    serialize(paramJsonGenerator, paramSerializerProvider);
  }
  
  public String toString()
  {
    if (_value == null) {}
    for (String str = "NULL";; str = _value.getClass().getName()) {
      return String.format("[RawValue of type %s]", new Object[] { str });
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.util.RawValue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */