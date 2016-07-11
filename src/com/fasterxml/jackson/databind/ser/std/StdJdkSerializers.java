package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonIntegerFormatVisitor;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URL;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

public class StdJdkSerializers
{
  public static Collection<Map.Entry<Class<?>, Object>> all()
  {
    HashMap localHashMap = new HashMap();
    ToStringSerializer localToStringSerializer = ToStringSerializer.instance;
    localHashMap.put(URL.class, localToStringSerializer);
    localHashMap.put(URI.class, localToStringSerializer);
    localHashMap.put(Currency.class, localToStringSerializer);
    localHashMap.put(UUID.class, new UUIDSerializer());
    localHashMap.put(Pattern.class, localToStringSerializer);
    localHashMap.put(Locale.class, localToStringSerializer);
    localHashMap.put(Locale.class, localToStringSerializer);
    localHashMap.put(AtomicBoolean.class, AtomicBooleanSerializer.class);
    localHashMap.put(AtomicInteger.class, AtomicIntegerSerializer.class);
    localHashMap.put(AtomicLong.class, AtomicLongSerializer.class);
    localHashMap.put(File.class, FileSerializer.class);
    localHashMap.put(Class.class, ClassSerializer.class);
    localHashMap.put(Void.class, NullSerializer.instance);
    localHashMap.put(Void.TYPE, NullSerializer.instance);
    return localHashMap.entrySet();
  }
  
  public static class AtomicBooleanSerializer
    extends StdScalarSerializer<AtomicBoolean>
  {
    public AtomicBooleanSerializer()
    {
      super(false);
    }
    
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper paramJsonFormatVisitorWrapper, JavaType paramJavaType)
      throws JsonMappingException
    {
      paramJsonFormatVisitorWrapper.expectBooleanFormat(paramJavaType);
    }
    
    public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
    {
      return createSchemaNode("boolean", true);
    }
    
    public void serialize(AtomicBoolean paramAtomicBoolean, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
    {
      paramJsonGenerator.writeBoolean(paramAtomicBoolean.get());
    }
  }
  
  public static class AtomicIntegerSerializer
    extends StdScalarSerializer<AtomicInteger>
  {
    public AtomicIntegerSerializer()
    {
      super(false);
    }
    
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper paramJsonFormatVisitorWrapper, JavaType paramJavaType)
      throws JsonMappingException
    {
      paramJsonFormatVisitorWrapper = paramJsonFormatVisitorWrapper.expectIntegerFormat(paramJavaType);
      if (paramJsonFormatVisitorWrapper != null) {
        paramJsonFormatVisitorWrapper.numberType(JsonParser.NumberType.INT);
      }
    }
    
    public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
    {
      return createSchemaNode("integer", true);
    }
    
    public void serialize(AtomicInteger paramAtomicInteger, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
    {
      paramJsonGenerator.writeNumber(paramAtomicInteger.get());
    }
  }
  
  public static class AtomicLongSerializer
    extends StdScalarSerializer<AtomicLong>
  {
    public AtomicLongSerializer()
    {
      super(false);
    }
    
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper paramJsonFormatVisitorWrapper, JavaType paramJavaType)
      throws JsonMappingException
    {
      paramJsonFormatVisitorWrapper = paramJsonFormatVisitorWrapper.expectIntegerFormat(paramJavaType);
      if (paramJsonFormatVisitorWrapper != null) {
        paramJsonFormatVisitorWrapper.numberType(JsonParser.NumberType.LONG);
      }
    }
    
    public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
    {
      return createSchemaNode("integer", true);
    }
    
    public void serialize(AtomicLong paramAtomicLong, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
    {
      paramJsonGenerator.writeNumber(paramAtomicLong.get());
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.std.StdJdkSerializers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */