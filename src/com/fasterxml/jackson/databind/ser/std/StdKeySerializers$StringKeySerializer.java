package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class StdKeySerializers$StringKeySerializer
  extends StdSerializer<Object>
{
  public StdKeySerializers$StringKeySerializer()
  {
    super(String.class, false);
  }
  
  public void serialize(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    paramJsonGenerator.writeFieldName((String)paramObject);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.std.StdKeySerializers.StringKeySerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */