package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.std.CalendarSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.util.Calendar;
import javax.xml.datatype.XMLGregorianCalendar;

public class CoreXMLSerializers$XMLGregorianCalendarSerializer
  extends StdSerializer<XMLGregorianCalendar>
  implements ContextualSerializer
{
  static final XMLGregorianCalendarSerializer instance = new XMLGregorianCalendarSerializer();
  final JsonSerializer<Object> _delegate;
  
  public CoreXMLSerializers$XMLGregorianCalendarSerializer()
  {
    this(CalendarSerializer.instance);
  }
  
  protected CoreXMLSerializers$XMLGregorianCalendarSerializer(JsonSerializer<?> paramJsonSerializer)
  {
    super(XMLGregorianCalendar.class);
    _delegate = paramJsonSerializer;
  }
  
  protected Calendar _convert(XMLGregorianCalendar paramXMLGregorianCalendar)
  {
    if (paramXMLGregorianCalendar == null) {
      return null;
    }
    return paramXMLGregorianCalendar.toGregorianCalendar();
  }
  
  public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper paramJsonFormatVisitorWrapper, JavaType paramJavaType)
    throws JsonMappingException
  {
    _delegate.acceptJsonFormatVisitor(paramJsonFormatVisitorWrapper, null);
  }
  
  public JsonSerializer<?> createContextual(SerializerProvider paramSerializerProvider, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    paramBeanProperty = paramSerializerProvider.handlePrimaryContextualization(_delegate, paramBeanProperty);
    paramSerializerProvider = this;
    if (paramBeanProperty != _delegate) {
      paramSerializerProvider = new XMLGregorianCalendarSerializer(paramBeanProperty);
    }
    return paramSerializerProvider;
  }
  
  public JsonSerializer<?> getDelegatee()
  {
    return _delegate;
  }
  
  public boolean isEmpty(SerializerProvider paramSerializerProvider, XMLGregorianCalendar paramXMLGregorianCalendar)
  {
    return _delegate.isEmpty(paramSerializerProvider, _convert(paramXMLGregorianCalendar));
  }
  
  public void serialize(XMLGregorianCalendar paramXMLGregorianCalendar, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    _delegate.serialize(_convert(paramXMLGregorianCalendar), paramJsonGenerator, paramSerializerProvider);
  }
  
  public void serializeWithType(XMLGregorianCalendar paramXMLGregorianCalendar, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
    throws IOException
  {
    _delegate.serializeWithType(_convert(paramXMLGregorianCalendar), paramJsonGenerator, paramSerializerProvider, paramTypeSerializer);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ext.CoreXMLSerializers.XMLGregorianCalendarSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */