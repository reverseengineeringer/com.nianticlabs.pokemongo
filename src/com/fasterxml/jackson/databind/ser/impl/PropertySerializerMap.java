package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.util.Arrays;

public abstract class PropertySerializerMap
{
  protected final boolean _resetWhenFull;
  
  protected PropertySerializerMap(PropertySerializerMap paramPropertySerializerMap)
  {
    _resetWhenFull = _resetWhenFull;
  }
  
  protected PropertySerializerMap(boolean paramBoolean)
  {
    _resetWhenFull = paramBoolean;
  }
  
  public static PropertySerializerMap emptyForProperties()
  {
    return Empty.FOR_PROPERTIES;
  }
  
  public static PropertySerializerMap emptyForRootValues()
  {
    return Empty.FOR_ROOT_VALUES;
  }
  
  @Deprecated
  public static PropertySerializerMap emptyMap()
  {
    return emptyForProperties();
  }
  
  public final SerializerAndMapResult addSerializer(JavaType paramJavaType, JsonSerializer<Object> paramJsonSerializer)
  {
    return new SerializerAndMapResult(paramJsonSerializer, newWith(paramJavaType.getRawClass(), paramJsonSerializer));
  }
  
  public final SerializerAndMapResult addSerializer(Class<?> paramClass, JsonSerializer<Object> paramJsonSerializer)
  {
    return new SerializerAndMapResult(paramJsonSerializer, newWith(paramClass, paramJsonSerializer));
  }
  
  public final SerializerAndMapResult findAndAddKeySerializer(Class<?> paramClass, SerializerProvider paramSerializerProvider, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    paramSerializerProvider = paramSerializerProvider.findKeySerializer(paramClass, paramBeanProperty);
    return new SerializerAndMapResult(paramSerializerProvider, newWith(paramClass, paramSerializerProvider));
  }
  
  public final SerializerAndMapResult findAndAddPrimarySerializer(JavaType paramJavaType, SerializerProvider paramSerializerProvider, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    paramSerializerProvider = paramSerializerProvider.findPrimaryPropertySerializer(paramJavaType, paramBeanProperty);
    return new SerializerAndMapResult(paramSerializerProvider, newWith(paramJavaType.getRawClass(), paramSerializerProvider));
  }
  
  public final SerializerAndMapResult findAndAddPrimarySerializer(Class<?> paramClass, SerializerProvider paramSerializerProvider, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    paramSerializerProvider = paramSerializerProvider.findPrimaryPropertySerializer(paramClass, paramBeanProperty);
    return new SerializerAndMapResult(paramSerializerProvider, newWith(paramClass, paramSerializerProvider));
  }
  
  public final SerializerAndMapResult findAndAddRootValueSerializer(JavaType paramJavaType, SerializerProvider paramSerializerProvider)
    throws JsonMappingException
  {
    paramSerializerProvider = paramSerializerProvider.findTypedValueSerializer(paramJavaType, false, null);
    return new SerializerAndMapResult(paramSerializerProvider, newWith(paramJavaType.getRawClass(), paramSerializerProvider));
  }
  
  public final SerializerAndMapResult findAndAddRootValueSerializer(Class<?> paramClass, SerializerProvider paramSerializerProvider)
    throws JsonMappingException
  {
    paramSerializerProvider = paramSerializerProvider.findTypedValueSerializer(paramClass, false, null);
    return new SerializerAndMapResult(paramSerializerProvider, newWith(paramClass, paramSerializerProvider));
  }
  
  public final SerializerAndMapResult findAndAddSecondarySerializer(JavaType paramJavaType, SerializerProvider paramSerializerProvider, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    paramSerializerProvider = paramSerializerProvider.findValueSerializer(paramJavaType, paramBeanProperty);
    return new SerializerAndMapResult(paramSerializerProvider, newWith(paramJavaType.getRawClass(), paramSerializerProvider));
  }
  
  public final SerializerAndMapResult findAndAddSecondarySerializer(Class<?> paramClass, SerializerProvider paramSerializerProvider, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    paramSerializerProvider = paramSerializerProvider.findValueSerializer(paramClass, paramBeanProperty);
    return new SerializerAndMapResult(paramSerializerProvider, newWith(paramClass, paramSerializerProvider));
  }
  
  public abstract PropertySerializerMap newWith(Class<?> paramClass, JsonSerializer<Object> paramJsonSerializer);
  
  public abstract JsonSerializer<Object> serializerFor(Class<?> paramClass);
  
  private static final class Double
    extends PropertySerializerMap
  {
    private final JsonSerializer<Object> _serializer1;
    private final JsonSerializer<Object> _serializer2;
    private final Class<?> _type1;
    private final Class<?> _type2;
    
    public Double(PropertySerializerMap paramPropertySerializerMap, Class<?> paramClass1, JsonSerializer<Object> paramJsonSerializer1, Class<?> paramClass2, JsonSerializer<Object> paramJsonSerializer2)
    {
      super();
      _type1 = paramClass1;
      _serializer1 = paramJsonSerializer1;
      _type2 = paramClass2;
      _serializer2 = paramJsonSerializer2;
    }
    
    public PropertySerializerMap newWith(Class<?> paramClass, JsonSerializer<Object> paramJsonSerializer)
    {
      return new PropertySerializerMap.Multi(this, new PropertySerializerMap.TypeAndSerializer[] { new PropertySerializerMap.TypeAndSerializer(_type1, _serializer1), new PropertySerializerMap.TypeAndSerializer(_type2, _serializer2), new PropertySerializerMap.TypeAndSerializer(paramClass, paramJsonSerializer) });
    }
    
    public JsonSerializer<Object> serializerFor(Class<?> paramClass)
    {
      if (paramClass == _type1) {
        return _serializer1;
      }
      if (paramClass == _type2) {
        return _serializer2;
      }
      return null;
    }
  }
  
  private static final class Empty
    extends PropertySerializerMap
  {
    public static final Empty FOR_PROPERTIES = new Empty(false);
    public static final Empty FOR_ROOT_VALUES = new Empty(true);
    
    protected Empty(boolean paramBoolean)
    {
      super();
    }
    
    public PropertySerializerMap newWith(Class<?> paramClass, JsonSerializer<Object> paramJsonSerializer)
    {
      return new PropertySerializerMap.Single(this, paramClass, paramJsonSerializer);
    }
    
    public JsonSerializer<Object> serializerFor(Class<?> paramClass)
    {
      return null;
    }
  }
  
  private static final class Multi
    extends PropertySerializerMap
  {
    private static final int MAX_ENTRIES = 8;
    private final PropertySerializerMap.TypeAndSerializer[] _entries;
    
    public Multi(PropertySerializerMap paramPropertySerializerMap, PropertySerializerMap.TypeAndSerializer[] paramArrayOfTypeAndSerializer)
    {
      super();
      _entries = paramArrayOfTypeAndSerializer;
    }
    
    public PropertySerializerMap newWith(Class<?> paramClass, JsonSerializer<Object> paramJsonSerializer)
    {
      int i = _entries.length;
      if (i == 8)
      {
        localObject = this;
        if (_resetWhenFull) {
          localObject = new PropertySerializerMap.Single(this, paramClass, paramJsonSerializer);
        }
        return (PropertySerializerMap)localObject;
      }
      Object localObject = (PropertySerializerMap.TypeAndSerializer[])Arrays.copyOf(_entries, i + 1);
      localObject[i] = new PropertySerializerMap.TypeAndSerializer(paramClass, paramJsonSerializer);
      return new Multi(this, (PropertySerializerMap.TypeAndSerializer[])localObject);
    }
    
    public JsonSerializer<Object> serializerFor(Class<?> paramClass)
    {
      int i = 0;
      int j = _entries.length;
      while (i < j)
      {
        PropertySerializerMap.TypeAndSerializer localTypeAndSerializer = _entries[i];
        if (type == paramClass) {
          return serializer;
        }
        i += 1;
      }
      return null;
    }
  }
  
  public static final class SerializerAndMapResult
  {
    public final PropertySerializerMap map;
    public final JsonSerializer<Object> serializer;
    
    public SerializerAndMapResult(JsonSerializer<Object> paramJsonSerializer, PropertySerializerMap paramPropertySerializerMap)
    {
      serializer = paramJsonSerializer;
      map = paramPropertySerializerMap;
    }
  }
  
  private static final class Single
    extends PropertySerializerMap
  {
    private final JsonSerializer<Object> _serializer;
    private final Class<?> _type;
    
    public Single(PropertySerializerMap paramPropertySerializerMap, Class<?> paramClass, JsonSerializer<Object> paramJsonSerializer)
    {
      super();
      _type = paramClass;
      _serializer = paramJsonSerializer;
    }
    
    public PropertySerializerMap newWith(Class<?> paramClass, JsonSerializer<Object> paramJsonSerializer)
    {
      return new PropertySerializerMap.Double(this, _type, _serializer, paramClass, paramJsonSerializer);
    }
    
    public JsonSerializer<Object> serializerFor(Class<?> paramClass)
    {
      if (paramClass == _type) {
        return _serializer;
      }
      return null;
    }
  }
  
  private static final class TypeAndSerializer
  {
    public final JsonSerializer<Object> serializer;
    public final Class<?> type;
    
    public TypeAndSerializer(Class<?> paramClass, JsonSerializer<Object> paramJsonSerializer)
    {
      type = paramClass;
      serializer = paramJsonSerializer;
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */