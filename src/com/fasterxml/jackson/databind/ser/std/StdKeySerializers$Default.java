package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class StdKeySerializers$Default
  extends StdSerializer<Object>
{
  static final int TYPE_CALENDAR = 2;
  static final int TYPE_CLASS = 3;
  static final int TYPE_DATE = 1;
  static final int TYPE_ENUM = 4;
  static final int TYPE_TO_STRING = 5;
  protected final int _typeId;
  
  public StdKeySerializers$Default(int paramInt, Class<?> paramClass)
  {
    super(paramClass, false);
    _typeId = paramInt;
  }
  
  public void serialize(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    switch (_typeId)
    {
    default: 
      paramJsonGenerator.writeFieldName(paramObject.toString());
      return;
    case 1: 
      paramSerializerProvider.defaultSerializeDateKey((Date)paramObject, paramJsonGenerator);
      return;
    case 2: 
      paramSerializerProvider.defaultSerializeDateKey(((Calendar)paramObject).getTimeInMillis(), paramJsonGenerator);
      return;
    case 3: 
      paramJsonGenerator.writeFieldName(((Class)paramObject).getName());
      return;
    }
    if (paramSerializerProvider.isEnabled(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)) {}
    for (paramObject = paramObject.toString();; paramObject = ((Enum)paramObject).name())
    {
      paramJsonGenerator.writeFieldName((String)paramObject);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */