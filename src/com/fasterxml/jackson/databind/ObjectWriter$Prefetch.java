package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.impl.TypeWrappedSerializer;
import java.io.IOException;
import java.io.Serializable;

public final class ObjectWriter$Prefetch
  implements Serializable
{
  public static final Prefetch empty = new Prefetch(null, null, null);
  private static final long serialVersionUID = 1L;
  private final JavaType rootType;
  private final TypeSerializer typeSerializer;
  private final JsonSerializer<Object> valueSerializer;
  
  private ObjectWriter$Prefetch(JavaType paramJavaType, JsonSerializer<Object> paramJsonSerializer, TypeSerializer paramTypeSerializer)
  {
    rootType = paramJavaType;
    valueSerializer = paramJsonSerializer;
    typeSerializer = paramTypeSerializer;
  }
  
  public Prefetch forRootType(ObjectWriter paramObjectWriter, JavaType paramJavaType)
  {
    int j = 1;
    int i = j;
    if (paramJavaType != null)
    {
      if (paramJavaType.isJavaLangObject()) {
        i = j;
      }
    }
    else
    {
      if (i == 0) {
        break label59;
      }
      if ((rootType != null) && (valueSerializer != null)) {
        break label45;
      }
    }
    label45:
    label59:
    while (paramJavaType.equals(rootType))
    {
      return this;
      i = 0;
      break;
      return new Prefetch(null, null, typeSerializer);
    }
    if (paramObjectWriter.isEnabled(SerializationFeature.EAGER_SERIALIZER_FETCH))
    {
      paramObjectWriter = paramObjectWriter._serializerProvider();
      try
      {
        paramObjectWriter = paramObjectWriter.findTypedValueSerializer(paramJavaType, true, null);
        if ((paramObjectWriter instanceof TypeWrappedSerializer)) {
          return new Prefetch(paramJavaType, null, ((TypeWrappedSerializer)paramObjectWriter).typeSerializer());
        }
        paramObjectWriter = new Prefetch(paramJavaType, paramObjectWriter, null);
        return paramObjectWriter;
      }
      catch (JsonProcessingException paramObjectWriter) {}
    }
    return new Prefetch(null, null, typeSerializer);
  }
  
  public final TypeSerializer getTypeSerializer()
  {
    return typeSerializer;
  }
  
  public final JsonSerializer<Object> getValueSerializer()
  {
    return valueSerializer;
  }
  
  public boolean hasSerializer()
  {
    return (valueSerializer != null) || (typeSerializer != null);
  }
  
  public void serialize(JsonGenerator paramJsonGenerator, Object paramObject, DefaultSerializerProvider paramDefaultSerializerProvider)
    throws IOException
  {
    if (typeSerializer != null)
    {
      paramDefaultSerializerProvider.serializePolymorphic(paramJsonGenerator, paramObject, rootType, valueSerializer, typeSerializer);
      return;
    }
    if (valueSerializer != null)
    {
      paramDefaultSerializerProvider.serializeValue(paramJsonGenerator, paramObject, rootType, valueSerializer);
      return;
    }
    paramDefaultSerializerProvider.serializeValue(paramJsonGenerator, paramObject);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ObjectWriter.Prefetch
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */