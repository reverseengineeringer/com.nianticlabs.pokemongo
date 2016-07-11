package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.lang.reflect.Constructor;

final class StdKeyDeserializer$StringCtorKeyDeserializer
  extends StdKeyDeserializer
{
  private static final long serialVersionUID = 1L;
  protected final Constructor<?> _ctor;
  
  public StdKeyDeserializer$StringCtorKeyDeserializer(Constructor<?> paramConstructor)
  {
    super(-1, paramConstructor.getDeclaringClass());
    _ctor = paramConstructor;
  }
  
  public Object _parse(String paramString, DeserializationContext paramDeserializationContext)
    throws Exception
  {
    return _ctor.newInstance(new Object[] { paramString });
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer.StringCtorKeyDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */