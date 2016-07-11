package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.lang.reflect.Method;

final class StdKeyDeserializer$StringFactoryKeyDeserializer
  extends StdKeyDeserializer
{
  private static final long serialVersionUID = 1L;
  final Method _factoryMethod;
  
  public StdKeyDeserializer$StringFactoryKeyDeserializer(Method paramMethod)
  {
    super(-1, paramMethod.getDeclaringClass());
    _factoryMethod = paramMethod;
  }
  
  public Object _parse(String paramString, DeserializationContext paramDeserializationContext)
    throws Exception
  {
    return _factoryMethod.invoke(null, new Object[] { paramString });
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer.StringFactoryKeyDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */