package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class DateDeserializers$DateDeserializer
  extends DateDeserializers.DateBasedDeserializer<Date>
{
  public static final DateDeserializer instance = new DateDeserializer();
  
  public DateDeserializers$DateDeserializer()
  {
    super(Date.class);
  }
  
  public DateDeserializers$DateDeserializer(DateDeserializer paramDateDeserializer, DateFormat paramDateFormat, String paramString)
  {
    super(paramDateDeserializer, paramDateFormat, paramString);
  }
  
  public Date deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    return _parseDate(paramJsonParser, paramDeserializationContext);
  }
  
  protected DateDeserializer withDateFormat(DateFormat paramDateFormat, String paramString)
  {
    return new DateDeserializer(this, paramDateFormat, paramString);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */