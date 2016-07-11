package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
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

public class FromStringDeserializer$Std
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
  
  protected FromStringDeserializer$Std(Class<?> paramClass, int paramInt)
  {
    super(paramClass);
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

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.FromStringDeserializer.Std
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */