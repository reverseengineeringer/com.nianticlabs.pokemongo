package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import java.io.Serializable;
import java.util.Collection;

public class ObjectMapper$DefaultTypeResolverBuilder
  extends StdTypeResolverBuilder
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final ObjectMapper.DefaultTyping _appliesFor;
  
  public ObjectMapper$DefaultTypeResolverBuilder(ObjectMapper.DefaultTyping paramDefaultTyping)
  {
    _appliesFor = paramDefaultTyping;
  }
  
  public TypeDeserializer buildTypeDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, Collection<NamedType> paramCollection)
  {
    if (useForType(paramJavaType)) {
      return super.buildTypeDeserializer(paramDeserializationConfig, paramJavaType, paramCollection);
    }
    return null;
  }
  
  public TypeSerializer buildTypeSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, Collection<NamedType> paramCollection)
  {
    if (useForType(paramJavaType)) {
      return super.buildTypeSerializer(paramSerializationConfig, paramJavaType, paramCollection);
    }
    return null;
  }
  
  public boolean useForType(JavaType paramJavaType)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    JavaType localJavaType1 = paramJavaType;
    JavaType localJavaType2 = paramJavaType;
    JavaType localJavaType3 = paramJavaType;
    switch (ObjectMapper.2.$SwitchMap$com$fasterxml$jackson$databind$ObjectMapper$DefaultTyping[_appliesFor.ordinal()])
    {
    default: 
      bool1 = paramJavaType.isJavaLangObject();
    case 1: 
    case 2: 
      do
      {
        do
        {
          return bool1;
          for (;;)
          {
            localJavaType2 = localJavaType1;
            if (!localJavaType1.isArrayType()) {
              break;
            }
            localJavaType1 = localJavaType1.getContentType();
          }
          if (localJavaType2.isJavaLangObject()) {
            break;
          }
          bool1 = bool2;
        } while (localJavaType2.isConcrete());
        bool1 = bool2;
      } while (TreeNode.class.isAssignableFrom(localJavaType2.getRawClass()));
      return true;
    }
    while (localJavaType3.isArrayType()) {
      localJavaType3 = localJavaType3.getContentType();
    }
    if ((!localJavaType3.isFinal()) && (!TreeNode.class.isAssignableFrom(localJavaType3.getRawClass()))) {}
    for (;;)
    {
      return bool1;
      bool1 = false;
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ObjectMapper.DefaultTypeResolverBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */