package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@JacksonStdImpl
public class DateDeserializers$CalendarDeserializer
  extends DateDeserializers.DateBasedDeserializer<Calendar>
{
  protected final Class<? extends Calendar> _calendarClass;
  
  public DateDeserializers$CalendarDeserializer()
  {
    super(Calendar.class);
    _calendarClass = null;
  }
  
  public DateDeserializers$CalendarDeserializer(CalendarDeserializer paramCalendarDeserializer, DateFormat paramDateFormat, String paramString)
  {
    super(paramCalendarDeserializer, paramDateFormat, paramString);
    _calendarClass = _calendarClass;
  }
  
  public DateDeserializers$CalendarDeserializer(Class<? extends Calendar> paramClass)
  {
    super(paramClass);
    _calendarClass = paramClass;
  }
  
  public Calendar deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    paramJsonParser = _parseDate(paramJsonParser, paramDeserializationContext);
    if (paramJsonParser == null) {
      paramJsonParser = null;
    }
    for (;;)
    {
      return paramJsonParser;
      if (_calendarClass == null) {
        return paramDeserializationContext.constructCalendar(paramJsonParser);
      }
      try
      {
        Calendar localCalendar = (Calendar)_calendarClass.newInstance();
        localCalendar.setTimeInMillis(paramJsonParser.getTime());
        TimeZone localTimeZone = paramDeserializationContext.getTimeZone();
        paramJsonParser = localCalendar;
        if (localTimeZone == null) {
          continue;
        }
        localCalendar.setTimeZone(localTimeZone);
        return localCalendar;
      }
      catch (Exception paramJsonParser)
      {
        throw paramDeserializationContext.instantiationException(_calendarClass, paramJsonParser);
      }
    }
  }
  
  protected CalendarDeserializer withDateFormat(DateFormat paramDateFormat, String paramString)
  {
    return new CalendarDeserializer(this, paramDateFormat, paramString);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.DateDeserializers.CalendarDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */