package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.deser.KeyDeserializers;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.EnumResolver;
import java.io.Serializable;
import java.lang.reflect.Constructor;

public class StdKeyDeserializers
  implements KeyDeserializers, Serializable
{
  private static final long serialVersionUID = 1L;
  
  public static KeyDeserializer constructDelegatingKeyDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, JsonDeserializer<?> paramJsonDeserializer)
  {
    return new StdKeyDeserializer.DelegatingKD(paramJavaType.getRawClass(), paramJsonDeserializer);
  }
  
  public static KeyDeserializer constructEnumKeyDeserializer(EnumResolver paramEnumResolver)
  {
    return new StdKeyDeserializer.EnumKD(paramEnumResolver, null);
  }
  
  public static KeyDeserializer constructEnumKeyDeserializer(EnumResolver paramEnumResolver, AnnotatedMethod paramAnnotatedMethod)
  {
    return new StdKeyDeserializer.EnumKD(paramEnumResolver, paramAnnotatedMethod);
  }
  
  public static KeyDeserializer findStringBasedKeyDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType)
  {
    paramJavaType = paramDeserializationConfig.introspect(paramJavaType);
    Constructor localConstructor = paramJavaType.findSingleArgConstructor(new Class[] { String.class });
    if (localConstructor != null)
    {
      if (paramDeserializationConfig.canOverrideAccessModifiers()) {
        ClassUtil.checkAndFixAccess(localConstructor);
      }
      return new StdKeyDeserializer.StringCtorKeyDeserializer(localConstructor);
    }
    paramJavaType = paramJavaType.findFactoryMethod(new Class[] { String.class });
    if (paramJavaType != null)
    {
      if (paramDeserializationConfig.canOverrideAccessModifiers()) {
        ClassUtil.checkAndFixAccess(paramJavaType);
      }
      return new StdKeyDeserializer.StringFactoryKeyDeserializer(paramJavaType);
    }
    return null;
  }
  
  public KeyDeserializer findKeyDeserializer(JavaType paramJavaType, DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription)
    throws JsonMappingException
  {
    paramDeserializationConfig = paramJavaType.getRawClass();
    paramJavaType = paramDeserializationConfig;
    if (paramDeserializationConfig.isPrimitive()) {
      paramJavaType = ClassUtil.wrapperType(paramDeserializationConfig);
    }
    return StdKeyDeserializer.forType(paramJavaType);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */