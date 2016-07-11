package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.EnumResolver;

@JacksonStdImpl
final class StdKeyDeserializer$EnumKD
  extends StdKeyDeserializer
{
  private static final long serialVersionUID = 1L;
  protected final AnnotatedMethod _factory;
  protected final EnumResolver _resolver;
  
  protected StdKeyDeserializer$EnumKD(EnumResolver paramEnumResolver, AnnotatedMethod paramAnnotatedMethod)
  {
    super(-1, paramEnumResolver.getEnumClass());
    _resolver = paramEnumResolver;
    _factory = paramAnnotatedMethod;
  }
  
  public Object _parse(String paramString, DeserializationContext paramDeserializationContext)
    throws JsonMappingException
  {
    if (_factory != null) {}
    do
    {
      Enum localEnum;
      do
      {
        try
        {
          Object localObject1 = _factory.call1(paramString);
          return localObject1;
        }
        catch (Exception localException)
        {
          ClassUtil.unwrapAndThrowAsIAE(localException);
        }
        localEnum = _resolver.findEnum(paramString);
        localObject2 = localEnum;
      } while (localEnum != null);
      Object localObject2 = localEnum;
    } while (paramDeserializationContext.getConfig().isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL));
    throw paramDeserializationContext.weirdKeyException(_keyClass, paramString, "not one of values for Enum class");
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer.EnumKD
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */