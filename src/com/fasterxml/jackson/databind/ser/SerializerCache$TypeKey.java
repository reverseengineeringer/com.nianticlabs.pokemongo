package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.util.TypeKey;

@Deprecated
public final class SerializerCache$TypeKey
  extends TypeKey
{
  public SerializerCache$TypeKey(JavaType paramJavaType, boolean paramBoolean)
  {
    super(paramJavaType, paramBoolean);
  }
  
  public SerializerCache$TypeKey(Class<?> paramClass, boolean paramBoolean)
  {
    super(paramClass, paramBoolean);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.SerializerCache.TypeKey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */