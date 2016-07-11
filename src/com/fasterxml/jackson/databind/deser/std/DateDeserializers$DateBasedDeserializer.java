package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public abstract class DateDeserializers$DateBasedDeserializer<T>
  extends StdScalarDeserializer<T>
  implements ContextualDeserializer
{
  protected final DateFormat _customFormat;
  protected final String _formatString;
  
  protected DateDeserializers$DateBasedDeserializer(DateBasedDeserializer<T> paramDateBasedDeserializer, DateFormat paramDateFormat, String paramString)
  {
    super(_valueClass);
    _customFormat = paramDateFormat;
    _formatString = paramString;
  }
  
  protected DateDeserializers$DateBasedDeserializer(Class<?> paramClass)
  {
    super(paramClass);
    _customFormat = null;
    _formatString = null;
  }
  
  protected Date _parseDate(JsonParser paramJsonParser, DeserializationContext arg2)
    throws IOException
  {
    if (_customFormat != null)
    {
      Object localObject = paramJsonParser.getCurrentToken();
      if (localObject == JsonToken.VALUE_STRING)
      {
        paramJsonParser = paramJsonParser.getText().trim();
        if (paramJsonParser.length() == 0) {
          return (Date)getEmptyValue(???);
        }
        try
        {
          synchronized (_customFormat)
          {
            localObject = _customFormat.parse(paramJsonParser);
            return (Date)localObject;
          }
          if (localParseException != JsonToken.START_ARRAY) {
            break label172;
          }
        }
        catch (ParseException localParseException)
        {
          throw new IllegalArgumentException("Failed to parse Date value '" + paramJsonParser + "' (format: \"" + _formatString + "\"): " + localParseException.getMessage());
        }
      }
      else if (???.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS))
      {
        paramJsonParser.nextToken();
        Date localDate = _parseDate(paramJsonParser, ???);
        if (paramJsonParser.nextToken() != JsonToken.END_ARRAY) {
          throw ???.wrongTokenException(paramJsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single 'java.util.Date' value but there was more than a single value in the array");
        }
        return localDate;
      }
    }
    label172:
    return super._parseDate(paramJsonParser, ???);
  }
  
  public JsonDeserializer<?> createContextual(DeserializationContext paramDeserializationContext, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    Object localObject1 = this;
    Object localObject2;
    TimeZone localTimeZone;
    if (paramBeanProperty != null)
    {
      localObject2 = paramDeserializationContext.getAnnotationIntrospector().findFormat(paramBeanProperty.getMember());
      localObject1 = this;
      if (localObject2 != null)
      {
        localTimeZone = ((JsonFormat.Value)localObject2).getTimeZone();
        if (!((JsonFormat.Value)localObject2).hasPattern()) {
          break label111;
        }
        localObject1 = ((JsonFormat.Value)localObject2).getPattern();
        if (!((JsonFormat.Value)localObject2).hasLocale()) {
          break label103;
        }
        paramBeanProperty = ((JsonFormat.Value)localObject2).getLocale();
        localObject2 = new SimpleDateFormat((String)localObject1, paramBeanProperty);
        paramBeanProperty = localTimeZone;
        if (localTimeZone == null) {
          paramBeanProperty = paramDeserializationContext.getTimeZone();
        }
        ((SimpleDateFormat)localObject2).setTimeZone(paramBeanProperty);
        localObject1 = withDateFormat((DateFormat)localObject2, (String)localObject1);
      }
    }
    label103:
    label111:
    do
    {
      return (JsonDeserializer<?>)localObject1;
      paramBeanProperty = paramDeserializationContext.getLocale();
      break;
      localObject1 = this;
    } while (localTimeZone == null);
    paramBeanProperty = paramDeserializationContext.getConfig().getDateFormat();
    if (paramBeanProperty.getClass() == StdDateFormat.class) {
      if (((JsonFormat.Value)localObject2).hasLocale())
      {
        paramDeserializationContext = ((JsonFormat.Value)localObject2).getLocale();
        paramDeserializationContext = ((StdDateFormat)paramBeanProperty).withTimeZone(localTimeZone).withLocale(paramDeserializationContext);
      }
    }
    for (;;)
    {
      return withDateFormat(paramDeserializationContext, _formatString);
      paramDeserializationContext = paramDeserializationContext.getLocale();
      break;
      paramDeserializationContext = (DateFormat)paramBeanProperty.clone();
      paramDeserializationContext.setTimeZone(localTimeZone);
    }
  }
  
  protected abstract DateBasedDeserializer<T> withDateFormat(DateFormat paramDateFormat, String paramString);
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateBasedDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */