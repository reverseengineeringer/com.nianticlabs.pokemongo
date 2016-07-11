package com.fasterxml.jackson.annotation;

import java.util.Locale;
import java.util.TimeZone;

public class JsonFormat$Value
  implements JacksonAnnotationValue<JsonFormat>
{
  private TimeZone _timezone;
  private final JsonFormat.Features features;
  private final Locale locale;
  private final String pattern;
  private final JsonFormat.Shape shape;
  private final String timezoneStr;
  
  public JsonFormat$Value()
  {
    this("", JsonFormat.Shape.ANY, "", "", JsonFormat.Features.empty());
  }
  
  public JsonFormat$Value(JsonFormat paramJsonFormat)
  {
    this(paramJsonFormat.pattern(), paramJsonFormat.shape(), paramJsonFormat.locale(), paramJsonFormat.timezone(), JsonFormat.Features.construct(paramJsonFormat));
  }
  
  @Deprecated
  public JsonFormat$Value(String paramString1, JsonFormat.Shape paramShape, String paramString2, String paramString3)
  {
    this(paramString1, paramShape, paramString2, paramString3, JsonFormat.Features.empty());
  }
  
  public JsonFormat$Value(String paramString1, JsonFormat.Shape paramShape, String paramString2, String paramString3, JsonFormat.Features paramFeatures) {}
  
  @Deprecated
  public JsonFormat$Value(String paramString1, JsonFormat.Shape paramShape, Locale paramLocale, String paramString2, TimeZone paramTimeZone)
  {
    this(paramString1, paramShape, paramLocale, paramString2, paramTimeZone, JsonFormat.Features.empty());
  }
  
  public JsonFormat$Value(String paramString1, JsonFormat.Shape paramShape, Locale paramLocale, String paramString2, TimeZone paramTimeZone, JsonFormat.Features paramFeatures)
  {
    pattern = paramString1;
    paramString1 = paramShape;
    if (paramShape == null) {
      paramString1 = JsonFormat.Shape.ANY;
    }
    shape = paramString1;
    locale = paramLocale;
    _timezone = paramTimeZone;
    timezoneStr = paramString2;
    paramString1 = paramFeatures;
    if (paramFeatures == null) {
      paramString1 = JsonFormat.Features.empty();
    }
    features = paramString1;
  }
  
  @Deprecated
  public JsonFormat$Value(String paramString, JsonFormat.Shape paramShape, Locale paramLocale, TimeZone paramTimeZone)
  {
    this(paramString, paramShape, paramLocale, paramTimeZone, JsonFormat.Features.empty());
  }
  
  public JsonFormat$Value(String paramString, JsonFormat.Shape paramShape, Locale paramLocale, TimeZone paramTimeZone, JsonFormat.Features paramFeatures)
  {
    pattern = paramString;
    paramString = paramShape;
    if (paramShape == null) {
      paramString = JsonFormat.Shape.ANY;
    }
    shape = paramString;
    locale = paramLocale;
    _timezone = paramTimeZone;
    timezoneStr = null;
    paramString = paramFeatures;
    if (paramFeatures == null) {
      paramString = JsonFormat.Features.empty();
    }
    features = paramString;
  }
  
  public static Value forPattern(String paramString)
  {
    return new Value(paramString, null, null, null, null, JsonFormat.Features.empty());
  }
  
  public Boolean getFeature(JsonFormat.Feature paramFeature)
  {
    return features.get(paramFeature);
  }
  
  public Locale getLocale()
  {
    return locale;
  }
  
  public String getPattern()
  {
    return pattern;
  }
  
  public JsonFormat.Shape getShape()
  {
    return shape;
  }
  
  public TimeZone getTimeZone()
  {
    TimeZone localTimeZone2 = _timezone;
    TimeZone localTimeZone1 = localTimeZone2;
    if (localTimeZone2 == null)
    {
      if (timezoneStr == null) {
        return null;
      }
      localTimeZone1 = TimeZone.getTimeZone(timezoneStr);
      _timezone = localTimeZone1;
    }
    return localTimeZone1;
  }
  
  public boolean hasLocale()
  {
    return locale != null;
  }
  
  public boolean hasPattern()
  {
    return (pattern != null) && (pattern.length() > 0);
  }
  
  public boolean hasShape()
  {
    return shape != JsonFormat.Shape.ANY;
  }
  
  public boolean hasTimeZone()
  {
    return (_timezone != null) || ((timezoneStr != null) && (!timezoneStr.isEmpty()));
  }
  
  public String timeZoneAsString()
  {
    if (_timezone != null) {
      return _timezone.getID();
    }
    return timezoneStr;
  }
  
  public Class<JsonFormat> valueFor()
  {
    return JsonFormat.class;
  }
  
  public Value withFeature(JsonFormat.Feature paramFeature)
  {
    paramFeature = features.with(new JsonFormat.Feature[] { paramFeature });
    if (paramFeature == features) {
      return this;
    }
    return new Value(pattern, shape, locale, timezoneStr, _timezone, paramFeature);
  }
  
  public Value withLocale(Locale paramLocale)
  {
    return new Value(pattern, shape, paramLocale, timezoneStr, _timezone, features);
  }
  
  public Value withPattern(String paramString)
  {
    return new Value(paramString, shape, locale, timezoneStr, _timezone, features);
  }
  
  public Value withShape(JsonFormat.Shape paramShape)
  {
    return new Value(pattern, paramShape, locale, timezoneStr, _timezone, features);
  }
  
  public Value withTimeZone(TimeZone paramTimeZone)
  {
    return new Value(pattern, shape, locale, null, paramTimeZone, features);
  }
  
  public Value withoutFeature(JsonFormat.Feature paramFeature)
  {
    paramFeature = features.without(new JsonFormat.Feature[] { paramFeature });
    if (paramFeature == features) {
      return this;
    }
    return new Value(pattern, shape, locale, timezoneStr, _timezone, paramFeature);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.annotation.JsonFormat.Value
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */