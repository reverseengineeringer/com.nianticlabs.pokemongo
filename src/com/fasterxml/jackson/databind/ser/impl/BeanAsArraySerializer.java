package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonMappingException.Reference;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.IOException;

public class BeanAsArraySerializer
  extends BeanSerializerBase
{
  private static final long serialVersionUID = 1L;
  protected final BeanSerializerBase _defaultSerializer;
  
  public BeanAsArraySerializer(BeanSerializerBase paramBeanSerializerBase)
  {
    super(paramBeanSerializerBase, (ObjectIdWriter)null);
    _defaultSerializer = paramBeanSerializerBase;
  }
  
  protected BeanAsArraySerializer(BeanSerializerBase paramBeanSerializerBase, ObjectIdWriter paramObjectIdWriter, Object paramObject)
  {
    super(paramBeanSerializerBase, paramObjectIdWriter, paramObject);
    _defaultSerializer = paramBeanSerializerBase;
  }
  
  protected BeanAsArraySerializer(BeanSerializerBase paramBeanSerializerBase, String[] paramArrayOfString)
  {
    super(paramBeanSerializerBase, paramArrayOfString);
    _defaultSerializer = paramBeanSerializerBase;
  }
  
  private boolean hasSingleElement(SerializerProvider paramSerializerProvider)
  {
    if ((_filteredProps != null) && (paramSerializerProvider.getActiveView() != null)) {}
    for (paramSerializerProvider = _filteredProps; paramSerializerProvider.length == 1; paramSerializerProvider = _props) {
      return true;
    }
    return false;
  }
  
  protected BeanSerializerBase asArraySerializer()
  {
    return this;
  }
  
  public boolean isUnwrappingSerializer()
  {
    return false;
  }
  
  public final void serialize(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    if ((paramSerializerProvider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) && (hasSingleElement(paramSerializerProvider)))
    {
      serializeAsArray(paramObject, paramJsonGenerator, paramSerializerProvider);
      return;
    }
    paramJsonGenerator.writeStartArray();
    paramJsonGenerator.setCurrentValue(paramObject);
    serializeAsArray(paramObject, paramJsonGenerator, paramSerializerProvider);
    paramJsonGenerator.writeEndArray();
  }
  
  protected final void serializeAsArray(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    BeanPropertyWriter[] arrayOfBeanPropertyWriter;
    if ((_filteredProps != null) && (paramSerializerProvider.getActiveView() != null)) {
      arrayOfBeanPropertyWriter = _filteredProps;
    }
    int k;
    for (;;)
    {
      int j = 0;
      k = 0;
      int i = 0;
      try
      {
        int m = arrayOfBeanPropertyWriter.length;
        label34:
        if (i < m)
        {
          BeanPropertyWriter localBeanPropertyWriter = arrayOfBeanPropertyWriter[i];
          if (localBeanPropertyWriter == null)
          {
            j = i;
            k = i;
            paramJsonGenerator.writeNull();
          }
          for (;;)
          {
            i += 1;
            break label34;
            arrayOfBeanPropertyWriter = _props;
            break;
            j = i;
            k = i;
            localBeanPropertyWriter.serializeAsElement(paramObject, paramJsonGenerator, paramSerializerProvider);
          }
        }
        paramJsonGenerator = "[anySetter]";
      }
      catch (Exception localException)
      {
        if (j == arrayOfBeanPropertyWriter.length) {}
        for (paramJsonGenerator = "[anySetter]";; paramJsonGenerator = arrayOfBeanPropertyWriter[j].getName())
        {
          wrapAndThrow(paramSerializerProvider, localException, paramObject, paramJsonGenerator);
          return;
        }
      }
      catch (StackOverflowError paramJsonGenerator)
      {
        paramSerializerProvider = new JsonMappingException("Infinite recursion (StackOverflowError)", paramJsonGenerator);
        if (k != arrayOfBeanPropertyWriter.length) {}
      }
    }
    for (;;)
    {
      paramSerializerProvider.prependPath(new JsonMappingException.Reference(paramObject, paramJsonGenerator));
      throw paramSerializerProvider;
      paramJsonGenerator = arrayOfBeanPropertyWriter[k].getName();
    }
  }
  
  public void serializeWithType(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
    throws IOException
  {
    if (_objectIdWriter != null)
    {
      _serializeWithObjectId(paramObject, paramJsonGenerator, paramSerializerProvider, paramTypeSerializer);
      return;
    }
    String str;
    if (_typeId == null)
    {
      str = null;
      if (str != null) {
        break label69;
      }
      paramTypeSerializer.writeTypePrefixForArray(paramObject, paramJsonGenerator);
    }
    for (;;)
    {
      serializeAsArray(paramObject, paramJsonGenerator, paramSerializerProvider);
      if (str != null) {
        break label81;
      }
      paramTypeSerializer.writeTypeSuffixForArray(paramObject, paramJsonGenerator);
      return;
      str = _customTypeId(paramObject);
      break;
      label69:
      paramTypeSerializer.writeCustomTypePrefixForArray(paramObject, paramJsonGenerator, str);
    }
    label81:
    paramTypeSerializer.writeCustomTypeSuffixForArray(paramObject, paramJsonGenerator, str);
  }
  
  public String toString()
  {
    return "BeanAsArraySerializer for " + handledType().getName();
  }
  
  public JsonSerializer<Object> unwrappingSerializer(NameTransformer paramNameTransformer)
  {
    return _defaultSerializer.unwrappingSerializer(paramNameTransformer);
  }
  
  public BeanSerializerBase withFilterId(Object paramObject)
  {
    return new BeanAsArraySerializer(this, _objectIdWriter, paramObject);
  }
  
  protected BeanAsArraySerializer withIgnorals(String[] paramArrayOfString)
  {
    return new BeanAsArraySerializer(this, paramArrayOfString);
  }
  
  public BeanSerializerBase withObjectIdWriter(ObjectIdWriter paramObjectIdWriter)
  {
    return _defaultSerializer.withObjectIdWriter(paramObjectIdWriter);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.impl.BeanAsArraySerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */