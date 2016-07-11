package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.impl.BeanAsArraySerializer;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import com.fasterxml.jackson.databind.ser.impl.UnwrappingBeanSerializer;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.IOException;

public class BeanSerializer
  extends BeanSerializerBase
{
  private static final long serialVersionUID = -3618164443537292758L;
  
  public BeanSerializer(JavaType paramJavaType, BeanSerializerBuilder paramBeanSerializerBuilder, BeanPropertyWriter[] paramArrayOfBeanPropertyWriter1, BeanPropertyWriter[] paramArrayOfBeanPropertyWriter2)
  {
    super(paramJavaType, paramBeanSerializerBuilder, paramArrayOfBeanPropertyWriter1, paramArrayOfBeanPropertyWriter2);
  }
  
  protected BeanSerializer(BeanSerializerBase paramBeanSerializerBase)
  {
    super(paramBeanSerializerBase);
  }
  
  protected BeanSerializer(BeanSerializerBase paramBeanSerializerBase, ObjectIdWriter paramObjectIdWriter)
  {
    super(paramBeanSerializerBase, paramObjectIdWriter);
  }
  
  protected BeanSerializer(BeanSerializerBase paramBeanSerializerBase, ObjectIdWriter paramObjectIdWriter, Object paramObject)
  {
    super(paramBeanSerializerBase, paramObjectIdWriter, paramObject);
  }
  
  protected BeanSerializer(BeanSerializerBase paramBeanSerializerBase, String[] paramArrayOfString)
  {
    super(paramBeanSerializerBase, paramArrayOfString);
  }
  
  public static BeanSerializer createDummy(JavaType paramJavaType)
  {
    return new BeanSerializer(paramJavaType, null, NO_PROPS, null);
  }
  
  protected BeanSerializerBase asArraySerializer()
  {
    Object localObject = this;
    if (_objectIdWriter == null)
    {
      localObject = this;
      if (_anyGetterWriter == null)
      {
        localObject = this;
        if (_propertyFilterId == null) {
          localObject = new BeanAsArraySerializer(this);
        }
      }
    }
    return (BeanSerializerBase)localObject;
  }
  
  public final void serialize(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException
  {
    if (_objectIdWriter != null)
    {
      paramJsonGenerator.setCurrentValue(paramObject);
      _serializeWithObjectId(paramObject, paramJsonGenerator, paramSerializerProvider, true);
      return;
    }
    paramJsonGenerator.writeStartObject();
    paramJsonGenerator.setCurrentValue(paramObject);
    if (_propertyFilterId != null) {
      serializeFieldsFiltered(paramObject, paramJsonGenerator, paramSerializerProvider);
    }
    for (;;)
    {
      paramJsonGenerator.writeEndObject();
      return;
      serializeFields(paramObject, paramJsonGenerator, paramSerializerProvider);
    }
  }
  
  public String toString()
  {
    return "BeanSerializer for " + handledType().getName();
  }
  
  public JsonSerializer<Object> unwrappingSerializer(NameTransformer paramNameTransformer)
  {
    return new UnwrappingBeanSerializer(this, paramNameTransformer);
  }
  
  public BeanSerializerBase withFilterId(Object paramObject)
  {
    return new BeanSerializer(this, _objectIdWriter, paramObject);
  }
  
  protected BeanSerializerBase withIgnorals(String[] paramArrayOfString)
  {
    return new BeanSerializer(this, paramArrayOfString);
  }
  
  public BeanSerializerBase withObjectIdWriter(ObjectIdWriter paramObjectIdWriter)
  {
    return new BeanSerializer(this, paramObjectIdWriter, _propertyFilterId);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.BeanSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */