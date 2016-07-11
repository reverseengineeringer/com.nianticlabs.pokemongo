package com.google.gson;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

final class DefaultDateTypeAdapter
  implements JsonSerializer<java.util.Date>, JsonDeserializer<java.util.Date>
{
  private final DateFormat enUsFormat;
  private final DateFormat iso8601Format;
  private final DateFormat localFormat;
  
  DefaultDateTypeAdapter()
  {
    this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
  }
  
  DefaultDateTypeAdapter(int paramInt)
  {
    this(DateFormat.getDateInstance(paramInt, Locale.US), DateFormat.getDateInstance(paramInt));
  }
  
  public DefaultDateTypeAdapter(int paramInt1, int paramInt2)
  {
    this(DateFormat.getDateTimeInstance(paramInt1, paramInt2, Locale.US), DateFormat.getDateTimeInstance(paramInt1, paramInt2));
  }
  
  DefaultDateTypeAdapter(String paramString)
  {
    this(new SimpleDateFormat(paramString, Locale.US), new SimpleDateFormat(paramString));
  }
  
  DefaultDateTypeAdapter(DateFormat paramDateFormat1, DateFormat paramDateFormat2)
  {
    enUsFormat = paramDateFormat1;
    localFormat = paramDateFormat2;
    iso8601Format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
    iso8601Format.setTimeZone(TimeZone.getTimeZone("UTC"));
  }
  
  private java.util.Date deserializeToDate(JsonElement paramJsonElement)
  {
    java.util.Date localDate2;
    synchronized (localFormat)
    {
      try
      {
        java.util.Date localDate1 = localFormat.parse(paramJsonElement.getAsString());
        return localDate1;
      }
      catch (ParseException localParseException1) {}
    }
  }
  
  public java.util.Date deserialize(JsonElement paramJsonElement, Type paramType, JsonDeserializationContext paramJsonDeserializationContext)
    throws JsonParseException
  {
    if (!(paramJsonElement instanceof JsonPrimitive)) {
      throw new JsonParseException("The date should be a string value");
    }
    paramJsonElement = deserializeToDate(paramJsonElement);
    if (paramType == java.util.Date.class) {
      return paramJsonElement;
    }
    if (paramType == Timestamp.class) {
      return new Timestamp(paramJsonElement.getTime());
    }
    if (paramType == java.sql.Date.class) {
      return new java.sql.Date(paramJsonElement.getTime());
    }
    throw new IllegalArgumentException(getClass() + " cannot deserialize to " + paramType);
  }
  
  public JsonElement serialize(java.util.Date paramDate, Type arg2, JsonSerializationContext paramJsonSerializationContext)
  {
    synchronized (localFormat)
    {
      paramDate = new JsonPrimitive(enUsFormat.format(paramDate));
      return paramDate;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(DefaultDateTypeAdapter.class.getSimpleName());
    localStringBuilder.append('(').append(localFormat.getClass().getSimpleName()).append(')');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.google.gson.DefaultDateTypeAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */