package com.fasterxml.jackson.databind.jsontype;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanProperty;
import java.io.IOException;

public abstract class TypeSerializer
{
  public abstract TypeSerializer forProperty(BeanProperty paramBeanProperty);
  
  public abstract String getPropertyName();
  
  public abstract TypeIdResolver getTypeIdResolver();
  
  public abstract JsonTypeInfo.As getTypeInclusion();
  
  public abstract void writeCustomTypePrefixForArray(Object paramObject, JsonGenerator paramJsonGenerator, String paramString)
    throws IOException;
  
  public abstract void writeCustomTypePrefixForObject(Object paramObject, JsonGenerator paramJsonGenerator, String paramString)
    throws IOException;
  
  public abstract void writeCustomTypePrefixForScalar(Object paramObject, JsonGenerator paramJsonGenerator, String paramString)
    throws IOException, JsonProcessingException;
  
  public abstract void writeCustomTypeSuffixForArray(Object paramObject, JsonGenerator paramJsonGenerator, String paramString)
    throws IOException;
  
  public abstract void writeCustomTypeSuffixForObject(Object paramObject, JsonGenerator paramJsonGenerator, String paramString)
    throws IOException;
  
  public abstract void writeCustomTypeSuffixForScalar(Object paramObject, JsonGenerator paramJsonGenerator, String paramString)
    throws IOException;
  
  public abstract void writeTypePrefixForArray(Object paramObject, JsonGenerator paramJsonGenerator)
    throws IOException;
  
  public void writeTypePrefixForArray(Object paramObject, JsonGenerator paramJsonGenerator, Class<?> paramClass)
    throws IOException
  {
    writeTypePrefixForArray(paramObject, paramJsonGenerator);
  }
  
  public abstract void writeTypePrefixForObject(Object paramObject, JsonGenerator paramJsonGenerator)
    throws IOException;
  
  public void writeTypePrefixForObject(Object paramObject, JsonGenerator paramJsonGenerator, Class<?> paramClass)
    throws IOException
  {
    writeTypePrefixForObject(paramObject, paramJsonGenerator);
  }
  
  public abstract void writeTypePrefixForScalar(Object paramObject, JsonGenerator paramJsonGenerator)
    throws IOException;
  
  public void writeTypePrefixForScalar(Object paramObject, JsonGenerator paramJsonGenerator, Class<?> paramClass)
    throws IOException
  {
    writeTypePrefixForScalar(paramObject, paramJsonGenerator);
  }
  
  public abstract void writeTypeSuffixForArray(Object paramObject, JsonGenerator paramJsonGenerator)
    throws IOException;
  
  public abstract void writeTypeSuffixForObject(Object paramObject, JsonGenerator paramJsonGenerator)
    throws IOException;
  
  public abstract void writeTypeSuffixForScalar(Object paramObject, JsonGenerator paramJsonGenerator)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.jsontype.TypeSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */