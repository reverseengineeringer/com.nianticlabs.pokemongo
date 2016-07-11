package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.util.Date;

@Deprecated
public class StdKeySerializers$DateKeySerializer
  extends StdSerializer<Date>
{
  protected static final JsonSerializer<?> instance = new DateKeySerializer();
  
  public StdKeySerializers$DateKeySerializer()
  {
    super(Date.class);
  }
  
  public void serialize(Date paramDate, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    paramSerializerProvider.defaultSerializeDateKey(paramDate, paramJsonGenerator);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.std.StdKeySerializers.DateKeySerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */