package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.text.DateFormat;

public class DateDeserializers$SqlDateDeserializer
  extends DateDeserializers.DateBasedDeserializer<java.sql.Date>
{
  public DateDeserializers$SqlDateDeserializer()
  {
    super(java.sql.Date.class);
  }
  
  public DateDeserializers$SqlDateDeserializer(SqlDateDeserializer paramSqlDateDeserializer, DateFormat paramDateFormat, String paramString)
  {
    super(paramSqlDateDeserializer, paramDateFormat, paramString);
  }
  
  public java.sql.Date deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    paramJsonParser = _parseDate(paramJsonParser, paramDeserializationContext);
    if (paramJsonParser == null) {
      return null;
    }
    return new java.sql.Date(paramJsonParser.getTime());
  }
  
  protected SqlDateDeserializer withDateFormat(DateFormat paramDateFormat, String paramString)
  {
    return new SqlDateDeserializer(this, paramDateFormat, paramString);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.DateDeserializers.SqlDateDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */