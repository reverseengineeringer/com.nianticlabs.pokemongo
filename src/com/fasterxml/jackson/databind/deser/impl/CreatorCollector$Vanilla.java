package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public final class CreatorCollector$Vanilla
  extends ValueInstantiator
  implements Serializable
{
  public static final int TYPE_COLLECTION = 1;
  public static final int TYPE_HASH_MAP = 3;
  public static final int TYPE_MAP = 2;
  private static final long serialVersionUID = 1L;
  private final int _type;
  
  public CreatorCollector$Vanilla(int paramInt)
  {
    _type = paramInt;
  }
  
  public boolean canCreateUsingDefault()
  {
    return true;
  }
  
  public boolean canInstantiate()
  {
    return true;
  }
  
  public Object createUsingDefault(DeserializationContext paramDeserializationContext)
    throws IOException
  {
    switch (_type)
    {
    default: 
      throw new IllegalStateException("Unknown type " + _type);
    case 1: 
      return new ArrayList();
    case 2: 
      return new LinkedHashMap();
    }
    return new HashMap();
  }
  
  public String getValueTypeDesc()
  {
    switch (_type)
    {
    default: 
      return Object.class.getName();
    case 1: 
      return ArrayList.class.getName();
    case 2: 
      return LinkedHashMap.class.getName();
    }
    return HashMap.class.getName();
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.impl.CreatorCollector.Vanilla
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */