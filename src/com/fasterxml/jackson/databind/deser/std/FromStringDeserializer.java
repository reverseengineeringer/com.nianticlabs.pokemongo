package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Currency;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;

public abstract class FromStringDeserializer<T>
  extends StdScalarDeserializer<T>
{
  protected FromStringDeserializer(Class<?> paramClass)
  {
    super(paramClass);
  }
  
  public static Std findDeserializer(Class<?> paramClass)
  {
    int i;
    if (paramClass == File.class) {
      i = 1;
    }
    for (;;)
    {
      return new Std(paramClass, i);
      if (paramClass == URL.class)
      {
        i = 2;
      }
      else if (paramClass == URI.class)
      {
        i = 3;
      }
      else if (paramClass == Class.class)
      {
        i = 4;
      }
      else if (paramClass == JavaType.class)
      {
        i = 5;
      }
      else if (paramClass == Currency.class)
      {
        i = 6;
      }
      else if (paramClass == Pattern.class)
      {
        i = 7;
      }
      else if (paramClass == Locale.class)
      {
        i = 8;
      }
      else if (paramClass == Charset.class)
      {
        i = 9;
      }
      else if (paramClass == TimeZone.class)
      {
        i = 10;
      }
      else if (paramClass == InetAddress.class)
      {
        i = 11;
      }
      else
      {
        if (paramClass != InetSocketAddress.class) {
          break;
        }
        i = 12;
      }
    }
    return null;
  }
  
  public static Class<?>[] types()
  {
    return new Class[] { File.class, URL.class, URI.class, Class.class, JavaType.class, Currency.class, Pattern.class, Locale.class, Charset.class, TimeZone.class, InetAddress.class, InetSocketAddress.class };
  }
  
  protected abstract T _deserialize(String paramString, DeserializationContext paramDeserializationContext)
    throws IOException;
  
  protected T _deserializeEmbedded(Object paramObject, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    throw paramDeserializationContext.mappingException("Don't know how to convert embedded Object of type %s into %s", new Object[] { paramObject.getClass().getName(), _valueClass.getName() });
  }
  
  protected T _deserializeFromEmptyString()
    throws IOException
  {
    return null;
  }
  
  public T deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    Object localObject;
    String str2;
    if ((paramJsonParser.getCurrentToken() == JsonToken.START_ARRAY) && (paramDeserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)))
    {
      paramJsonParser.nextToken();
      localObject = deserialize(paramJsonParser, paramDeserializationContext);
      if (paramJsonParser.nextToken() != JsonToken.END_ARRAY) {
        throw paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.END_ARRAY, "Attempted to unwrap single value array for single '" + _valueClass.getName() + "' value but there was more than a single value in the array");
      }
    }
    else
    {
      localObject = paramJsonParser.getValueAsString();
      if (localObject == null) {
        break label210;
      }
      if (((String)localObject).length() != 0)
      {
        str2 = ((String)localObject).trim();
        if (str2.length() != 0) {
          break label118;
        }
      }
      localObject = _deserializeFromEmptyString();
    }
    return (T)localObject;
    label118:
    paramJsonParser = null;
    try
    {
      localObject = _deserialize(str2, paramDeserializationContext);
      if (localObject != null) {
        return (T)localObject;
      }
    }
    catch (IllegalArgumentException paramJsonParser)
    {
      String str1 = "not a valid textual representation";
      localObject = str1;
      if (paramJsonParser != null)
      {
        String str3 = paramJsonParser.getMessage();
        localObject = str1;
        if (str3 != null) {
          localObject = "not a valid textual representation" + ", problem: " + str3;
        }
      }
      paramDeserializationContext = paramDeserializationContext.weirdStringException(str2, _valueClass, (String)localObject);
      if (paramJsonParser != null) {
        paramDeserializationContext.initCause(paramJsonParser);
      }
      throw paramDeserializationContext;
    }
    label210:
    if (paramJsonParser.getCurrentToken() == JsonToken.VALUE_EMBEDDED_OBJECT)
    {
      paramJsonParser = paramJsonParser.getEmbeddedObject();
      if (paramJsonParser == null) {
        return null;
      }
      if (_valueClass.isAssignableFrom(paramJsonParser.getClass())) {
        return paramJsonParser;
      }
      return (T)_deserializeEmbedded(paramJsonParser, paramDeserializationContext);
    }
    throw paramDeserializationContext.mappingException(_valueClass);
  }
  
  public static class Std
    extends FromStringDeserializer<Object>
  {
    public static final int STD_CHARSET = 9;
    public static final int STD_CLASS = 4;
    public static final int STD_CURRENCY = 6;
    public static final int STD_FILE = 1;
    public static final int STD_INET_ADDRESS = 11;
    public static final int STD_INET_SOCKET_ADDRESS = 12;
    public static final int STD_JAVA_TYPE = 5;
    public static final int STD_LOCALE = 8;
    public static final int STD_PATTERN = 7;
    public static final int STD_TIME_ZONE = 10;
    public static final int STD_URI = 3;
    public static final int STD_URL = 2;
    private static final long serialVersionUID = 1L;
    protected final int _kind;
    
    protected Std(Class<?> paramClass, int paramInt)
    {
      super();
      _kind = paramInt;
    }
    
    protected Object _deserialize(String paramString, DeserializationContext paramDeserializationContext)
      throws IOException
    {
      switch (_kind)
      {
      default: 
        throw new IllegalArgumentException();
      case 1: 
        return new File(paramString);
      case 2: 
        return new URL(paramString);
      case 3: 
        return URI.create(paramString);
      case 4: 
        try
        {
          paramString = paramDeserializationContext.findClass(paramString);
          return paramString;
        }
        catch (Exception paramString)
        {
          throw paramDeserializationContext.instantiationException(_valueClass, ClassUtil.getRootCause(paramString));
        }
      case 5: 
        return paramDeserializationContext.getTypeFactory().constructFromCanonical(paramString);
      case 6: 
        return Currency.getInstance(paramString);
      case 7: 
        return Pattern.compile(paramString);
      case 8: 
        i = paramString.indexOf('_');
        if (i < 0) {
          return new Locale(paramString);
        }
        paramDeserializationContext = paramString.substring(0, i);
        paramString = paramString.substring(i + 1);
        i = paramString.indexOf('_');
        if (i < 0) {
          return new Locale(paramDeserializationContext, paramString);
        }
        return new Locale(paramDeserializationContext, paramString.substring(0, i), paramString.substring(i + 1));
      case 9: 
        return Charset.forName(paramString);
      case 10: 
        return TimeZone.getTimeZone(paramString);
      case 11: 
        return InetAddress.getByName(paramString);
      }
      int j;
      if (paramString.startsWith("["))
      {
        j = paramString.lastIndexOf(']');
        if (j == -1) {
          throw new InvalidFormatException("Bracketed IPv6 address must contain closing bracket", paramString, InetSocketAddress.class);
        }
        i = paramString.indexOf(':', j);
        if (i > -1) {}
        for (i = Integer.parseInt(paramString.substring(i + 1));; i = 0) {
          return new InetSocketAddress(paramString.substring(0, j + 1), i);
        }
      }
      int i = paramString.indexOf(':');
      if ((i >= 0) && (paramString.indexOf(':', i + 1) < 0))
      {
        j = Integer.parseInt(paramString.substring(i + 1));
        return new InetSocketAddress(paramString.substring(0, i), j);
      }
      return new InetSocketAddress(paramString, 0);
    }
    
    protected Object _deserializeFromEmptyString()
      throws IOException
    {
      if (_kind == 3) {
        return URI.create("");
      }
      return super._deserializeFromEmptyString();
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */