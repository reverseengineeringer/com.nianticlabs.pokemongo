package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.JsonDeserializer;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class JdkDeserializers
{
  private static final HashSet<String> _classNames = new HashSet();
  
  static
  {
    Class[] arrayOfClass = new Class[4];
    arrayOfClass[0] = UUID.class;
    arrayOfClass[1] = AtomicBoolean.class;
    arrayOfClass[2] = StackTraceElement.class;
    arrayOfClass[3] = ByteBuffer.class;
    int j = arrayOfClass.length;
    int i = 0;
    Class localClass;
    while (i < j)
    {
      localClass = arrayOfClass[i];
      _classNames.add(localClass.getName());
      i += 1;
    }
    arrayOfClass = FromStringDeserializer.types();
    j = arrayOfClass.length;
    i = 0;
    while (i < j)
    {
      localClass = arrayOfClass[i];
      _classNames.add(localClass.getName());
      i += 1;
    }
  }
  
  public static JsonDeserializer<?> find(Class<?> paramClass, String paramString)
  {
    if (_classNames.contains(paramString))
    {
      paramString = FromStringDeserializer.findDeserializer(paramClass);
      if (paramString != null) {
        return paramString;
      }
      if (paramClass == UUID.class) {
        return new UUIDDeserializer();
      }
      if (paramClass == StackTraceElement.class) {
        return new StackTraceElementDeserializer();
      }
      if (paramClass == AtomicBoolean.class) {
        return new AtomicBooleanDeserializer();
      }
      if (paramClass == ByteBuffer.class) {
        return new ByteBufferDeserializer();
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.JdkDeserializers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */