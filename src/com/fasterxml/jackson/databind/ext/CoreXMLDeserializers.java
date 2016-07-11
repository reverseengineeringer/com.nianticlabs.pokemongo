package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

public class CoreXMLDeserializers
  extends Deserializers.Base
{
  protected static final int TYPE_DURATION = 1;
  protected static final int TYPE_G_CALENDAR = 2;
  protected static final int TYPE_QNAME = 3;
  static final DatatypeFactory _dataTypeFactory;
  
  static
  {
    try
    {
      _dataTypeFactory = DatatypeFactory.newInstance();
      return;
    }
    catch (DatatypeConfigurationException localDatatypeConfigurationException)
    {
      throw new RuntimeException(localDatatypeConfigurationException);
    }
  }
  
  public JsonDeserializer<?> findBeanDeserializer(JavaType paramJavaType, DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription)
  {
    paramJavaType = paramJavaType.getRawClass();
    if (paramJavaType == QName.class) {
      return new Std(paramJavaType, 3);
    }
    if (paramJavaType == XMLGregorianCalendar.class) {
      return new Std(paramJavaType, 2);
    }
    if (paramJavaType == Duration.class) {
      return new Std(paramJavaType, 1);
    }
    return null;
  }
  
  public static class Std
    extends FromStringDeserializer<Object>
  {
    private static final long serialVersionUID = 1L;
    protected final int _kind;
    
    public Std(Class<?> paramClass, int paramInt)
    {
      super();
      _kind = paramInt;
    }
    
    protected Object _deserialize(String paramString, DeserializationContext paramDeserializationContext)
      throws IllegalArgumentException
    {
      switch (_kind)
      {
      case 2: 
      default: 
        throw new IllegalStateException();
      case 1: 
        return CoreXMLDeserializers._dataTypeFactory.newDuration(paramString);
      }
      return QName.valueOf(paramString);
    }
    
    public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if (_kind == 2)
      {
        Date localDate = _parseDate(paramJsonParser, paramDeserializationContext);
        if (localDate == null) {
          return null;
        }
        paramJsonParser = new GregorianCalendar();
        paramJsonParser.setTime(localDate);
        paramDeserializationContext = paramDeserializationContext.getTimeZone();
        if (paramDeserializationContext != null) {
          paramJsonParser.setTimeZone(paramDeserializationContext);
        }
        return CoreXMLDeserializers._dataTypeFactory.newXMLGregorianCalendar(paramJsonParser);
      }
      return super.deserialize(paramJsonParser, paramDeserializationContext);
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ext.CoreXMLDeserializers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */