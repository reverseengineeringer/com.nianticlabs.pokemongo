package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.SerializerAndMapResult;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class StdKeySerializers
{
  protected static final JsonSerializer<Object> DEFAULT_KEY_SERIALIZER = new StdKeySerializer();
  protected static final JsonSerializer<Object> DEFAULT_STRING_SERIALIZER = new StringKeySerializer();
  
  @Deprecated
  public static JsonSerializer<Object> getDefault()
  {
    return DEFAULT_KEY_SERIALIZER;
  }
  
  public static JsonSerializer<Object> getFallbackKeySerializer(SerializationConfig paramSerializationConfig, Class<?> paramClass)
  {
    if (paramClass != null)
    {
      if (paramClass == Enum.class) {
        return new Dynamic();
      }
      if (paramClass.isEnum()) {
        return new Default(4, paramClass);
      }
    }
    return DEFAULT_KEY_SERIALIZER;
  }
  
  @Deprecated
  public static JsonSerializer<Object> getStdKeySerializer(JavaType paramJavaType)
  {
    return getStdKeySerializer(null, paramJavaType.getRawClass(), true);
  }
  
  public static JsonSerializer<Object> getStdKeySerializer(SerializationConfig paramSerializationConfig, Class<?> paramClass, boolean paramBoolean)
  {
    if ((paramClass == null) || (paramClass == Object.class)) {
      return new Dynamic();
    }
    if (paramClass == String.class) {
      return DEFAULT_STRING_SERIALIZER;
    }
    if ((paramClass.isPrimitive()) || (Number.class.isAssignableFrom(paramClass))) {
      return DEFAULT_KEY_SERIALIZER;
    }
    if (paramClass == Class.class) {
      return new Default(3, paramClass);
    }
    if (Date.class.isAssignableFrom(paramClass)) {
      return new Default(1, paramClass);
    }
    if (Calendar.class.isAssignableFrom(paramClass)) {
      return new Default(2, paramClass);
    }
    if (paramClass == UUID.class) {
      return new Default(5, paramClass);
    }
    if (paramBoolean) {
      return DEFAULT_KEY_SERIALIZER;
    }
    return null;
  }
  
  @Deprecated
  public static class CalendarKeySerializer
    extends StdSerializer<Calendar>
  {
    protected static final JsonSerializer<?> instance = new CalendarKeySerializer();
    
    public CalendarKeySerializer()
    {
      super();
    }
    
    public void serialize(Calendar paramCalendar, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException
    {
      paramSerializerProvider.defaultSerializeDateKey(paramCalendar.getTimeInMillis(), paramJsonGenerator);
    }
  }
  
  @Deprecated
  public static class DateKeySerializer
    extends StdSerializer<Date>
  {
    protected static final JsonSerializer<?> instance = new DateKeySerializer();
    
    public DateKeySerializer()
    {
      super();
    }
    
    public void serialize(Date paramDate, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException
    {
      paramSerializerProvider.defaultSerializeDateKey(paramDate, paramJsonGenerator);
    }
  }
  
  public static class Default
    extends StdSerializer<Object>
  {
    static final int TYPE_CALENDAR = 2;
    static final int TYPE_CLASS = 3;
    static final int TYPE_DATE = 1;
    static final int TYPE_ENUM = 4;
    static final int TYPE_TO_STRING = 5;
    protected final int _typeId;
    
    public Default(int paramInt, Class<?> paramClass)
    {
      super(false);
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
  
  public static class Dynamic
    extends StdSerializer<Object>
  {
    protected transient PropertySerializerMap _dynamicSerializers = PropertySerializerMap.emptyForProperties();
    
    public Dynamic()
    {
      super(false);
    }
    
    protected JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap paramPropertySerializerMap, Class<?> paramClass, SerializerProvider paramSerializerProvider)
      throws JsonMappingException
    {
      paramClass = paramPropertySerializerMap.findAndAddKeySerializer(paramClass, paramSerializerProvider, null);
      if (paramPropertySerializerMap != map) {
        _dynamicSerializers = map;
      }
      return serializer;
    }
    
    Object readResolve()
    {
      _dynamicSerializers = PropertySerializerMap.emptyForProperties();
      return this;
    }
    
    public void serialize(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException
    {
      Class localClass = paramObject.getClass();
      PropertySerializerMap localPropertySerializerMap = _dynamicSerializers;
      JsonSerializer localJsonSerializer2 = localPropertySerializerMap.serializerFor(localClass);
      JsonSerializer localJsonSerializer1 = localJsonSerializer2;
      if (localJsonSerializer2 == null) {
        localJsonSerializer1 = _findAndAddDynamic(localPropertySerializerMap, localClass, paramSerializerProvider);
      }
      localJsonSerializer1.serialize(paramObject, paramJsonGenerator, paramSerializerProvider);
    }
  }
  
  public static class StringKeySerializer
    extends StdSerializer<Object>
  {
    public StringKeySerializer()
    {
      super(false);
    }
    
    public void serialize(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException
    {
      paramJsonGenerator.writeFieldName((String)paramObject);
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.std.StdKeySerializers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */