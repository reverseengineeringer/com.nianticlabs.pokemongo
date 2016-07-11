package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.util.Calendar;

@Deprecated
public class StdKeySerializers$CalendarKeySerializer
  extends StdSerializer<Calendar>
{
  protected static final JsonSerializer<?> instance = new CalendarKeySerializer();
  
  public StdKeySerializers$CalendarKeySerializer()
  {
    super(Calendar.class);
  }
  
  public void serialize(Calendar paramCalendar, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    paramSerializerProvider.defaultSerializeDateKey(paramCalendar.getTimeInMillis(), paramJsonGenerator);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.std.StdKeySerializers.CalendarKeySerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */