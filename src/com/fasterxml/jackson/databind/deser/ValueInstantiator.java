package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import java.io.IOException;

public abstract class ValueInstantiator
{
  protected Object _createFromStringFallbacks(DeserializationContext paramDeserializationContext, String paramString)
    throws IOException, JsonProcessingException
  {
    if (canCreateFromBoolean())
    {
      String str = paramString.trim();
      if ("true".equals(str)) {
        return createFromBoolean(paramDeserializationContext, true);
      }
      if ("false".equals(str)) {
        return createFromBoolean(paramDeserializationContext, false);
      }
    }
    if ((paramString.length() == 0) && (paramDeserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT))) {
      return null;
    }
    throw paramDeserializationContext.mappingException("Can not instantiate value of type %s from String value ('%s'); no single-String constructor/factory method", new Object[] { getValueTypeDesc(), paramString });
  }
  
  public boolean canCreateFromBoolean()
  {
    return false;
  }
  
  public boolean canCreateFromDouble()
  {
    return false;
  }
  
  public boolean canCreateFromInt()
  {
    return false;
  }
  
  public boolean canCreateFromLong()
  {
    return false;
  }
  
  public boolean canCreateFromObjectWith()
  {
    return false;
  }
  
  public boolean canCreateFromString()
  {
    return false;
  }
  
  public boolean canCreateUsingDefault()
  {
    return getDefaultCreator() != null;
  }
  
  public boolean canCreateUsingDelegate()
  {
    return false;
  }
  
  public boolean canInstantiate()
  {
    return (canCreateUsingDefault()) || (canCreateUsingDelegate()) || (canCreateFromObjectWith()) || (canCreateFromString()) || (canCreateFromInt()) || (canCreateFromLong()) || (canCreateFromDouble()) || (canCreateFromBoolean());
  }
  
  public Object createFromBoolean(DeserializationContext paramDeserializationContext, boolean paramBoolean)
    throws IOException
  {
    throw paramDeserializationContext.mappingException("Can not instantiate value of type %s from Boolean value (%s)", new Object[] { getValueTypeDesc(), Boolean.valueOf(paramBoolean) });
  }
  
  public Object createFromDouble(DeserializationContext paramDeserializationContext, double paramDouble)
    throws IOException
  {
    throw paramDeserializationContext.mappingException("Can not instantiate value of type %s from Floating-point number (%s, double)", new Object[] { getValueTypeDesc(), Double.valueOf(paramDouble) });
  }
  
  public Object createFromInt(DeserializationContext paramDeserializationContext, int paramInt)
    throws IOException
  {
    throw paramDeserializationContext.mappingException("Can not instantiate value of type %s from Integer number (%s, int)", new Object[] { getValueTypeDesc(), Integer.valueOf(paramInt) });
  }
  
  public Object createFromLong(DeserializationContext paramDeserializationContext, long paramLong)
    throws IOException
  {
    throw paramDeserializationContext.mappingException("Can not instantiate value of type %s from Integer number (%s, long)", new Object[] { getValueTypeDesc(), Long.valueOf(paramLong) });
  }
  
  public Object createFromObjectWith(DeserializationContext paramDeserializationContext, Object[] paramArrayOfObject)
    throws IOException
  {
    throw paramDeserializationContext.mappingException("Can not instantiate value of type %s with arguments", new Object[] { getValueTypeDesc() });
  }
  
  public Object createFromString(DeserializationContext paramDeserializationContext, String paramString)
    throws IOException
  {
    return _createFromStringFallbacks(paramDeserializationContext, paramString);
  }
  
  public Object createUsingDefault(DeserializationContext paramDeserializationContext)
    throws IOException
  {
    throw paramDeserializationContext.mappingException("Can not instantiate value of type %s; no default creator found", new Object[] { getValueTypeDesc() });
  }
  
  public Object createUsingDelegate(DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException
  {
    throw paramDeserializationContext.mappingException("Can not instantiate value of type %s using delegate", new Object[] { getValueTypeDesc() });
  }
  
  public AnnotatedWithParams getDefaultCreator()
  {
    return null;
  }
  
  public AnnotatedWithParams getDelegateCreator()
  {
    return null;
  }
  
  public JavaType getDelegateType(DeserializationConfig paramDeserializationConfig)
  {
    return null;
  }
  
  public SettableBeanProperty[] getFromObjectArguments(DeserializationConfig paramDeserializationConfig)
  {
    return null;
  }
  
  public AnnotatedParameter getIncompleteParameter()
  {
    return null;
  }
  
  public abstract String getValueTypeDesc();
  
  public AnnotatedWithParams getWithArgsCreator()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.ValueInstantiator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */