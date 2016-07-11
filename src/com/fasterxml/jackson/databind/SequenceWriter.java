package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.Versioned;
import com.fasterxml.jackson.databind.cfg.PackageVersion;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.SerializerAndMapResult;
import com.fasterxml.jackson.databind.ser.impl.TypeWrappedSerializer;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public class SequenceWriter
  implements Versioned, Closeable, Flushable
{
  protected final boolean _cfgCloseCloseable;
  protected final boolean _cfgFlush;
  protected final boolean _closeGenerator;
  protected boolean _closed;
  protected final SerializationConfig _config;
  protected PropertySerializerMap _dynamicSerializers;
  protected final JsonGenerator _generator;
  protected boolean _openArray;
  protected final DefaultSerializerProvider _provider;
  protected final JsonSerializer<Object> _rootSerializer;
  protected final TypeSerializer _typeSerializer;
  
  public SequenceWriter(DefaultSerializerProvider paramDefaultSerializerProvider, JsonGenerator paramJsonGenerator, boolean paramBoolean, ObjectWriter.Prefetch paramPrefetch)
    throws IOException
  {
    _provider = paramDefaultSerializerProvider;
    _generator = paramJsonGenerator;
    _closeGenerator = paramBoolean;
    _rootSerializer = paramPrefetch.getValueSerializer();
    _typeSerializer = paramPrefetch.getTypeSerializer();
    _config = paramDefaultSerializerProvider.getConfig();
    _cfgFlush = _config.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE);
    _cfgCloseCloseable = _config.isEnabled(SerializationFeature.CLOSE_CLOSEABLE);
    _dynamicSerializers = PropertySerializerMap.emptyForRootValues();
  }
  
  private final JsonSerializer<Object> _findAndAddDynamic(JavaType paramJavaType)
    throws JsonMappingException
  {
    if (_typeSerializer == null) {}
    for (paramJavaType = _dynamicSerializers.findAndAddRootValueSerializer(paramJavaType, _provider);; paramJavaType = _dynamicSerializers.addSerializer(paramJavaType, new TypeWrappedSerializer(_typeSerializer, _provider.findValueSerializer(paramJavaType, null))))
    {
      _dynamicSerializers = map;
      return serializer;
    }
  }
  
  private final JsonSerializer<Object> _findAndAddDynamic(Class<?> paramClass)
    throws JsonMappingException
  {
    if (_typeSerializer == null) {}
    for (paramClass = _dynamicSerializers.findAndAddRootValueSerializer(paramClass, _provider);; paramClass = _dynamicSerializers.addSerializer(paramClass, new TypeWrappedSerializer(_typeSerializer, _provider.findValueSerializer(paramClass, null))))
    {
      _dynamicSerializers = map;
      return serializer;
    }
  }
  
  /* Error */
  protected SequenceWriter _writeCloseableValue(Object paramObject)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: checkcast 8	java/io/Closeable
    //   4: astore 4
    //   6: aload 4
    //   8: astore_3
    //   9: aload_0
    //   10: getfield 50	com/fasterxml/jackson/databind/SequenceWriter:_rootSerializer	Lcom/fasterxml/jackson/databind/JsonSerializer;
    //   13: astore 5
    //   15: aload 5
    //   17: astore_2
    //   18: aload 5
    //   20: ifnonnull +44 -> 64
    //   23: aload 4
    //   25: astore_3
    //   26: aload_1
    //   27: invokevirtual 141	java/lang/Object:getClass	()Ljava/lang/Class;
    //   30: astore 6
    //   32: aload 4
    //   34: astore_3
    //   35: aload_0
    //   36: getfield 91	com/fasterxml/jackson/databind/SequenceWriter:_dynamicSerializers	Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;
    //   39: aload 6
    //   41: invokevirtual 144	com/fasterxml/jackson/databind/ser/impl/PropertySerializerMap:serializerFor	(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JsonSerializer;
    //   44: astore 5
    //   46: aload 5
    //   48: astore_2
    //   49: aload 5
    //   51: ifnonnull +13 -> 64
    //   54: aload 4
    //   56: astore_3
    //   57: aload_0
    //   58: aload 6
    //   60: invokespecial 146	com/fasterxml/jackson/databind/SequenceWriter:_findAndAddDynamic	(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JsonSerializer;
    //   63: astore_2
    //   64: aload 4
    //   66: astore_3
    //   67: aload_0
    //   68: getfield 38	com/fasterxml/jackson/databind/SequenceWriter:_provider	Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;
    //   71: aload_0
    //   72: getfield 40	com/fasterxml/jackson/databind/SequenceWriter:_generator	Lcom/fasterxml/jackson/core/JsonGenerator;
    //   75: aload_1
    //   76: aconst_null
    //   77: aload_2
    //   78: invokevirtual 150	com/fasterxml/jackson/databind/ser/DefaultSerializerProvider:serializeValue	(Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/Object;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JsonSerializer;)V
    //   81: aload 4
    //   83: astore_3
    //   84: aload_0
    //   85: getfield 78	com/fasterxml/jackson/databind/SequenceWriter:_cfgFlush	Z
    //   88: ifeq +13 -> 101
    //   91: aload 4
    //   93: astore_3
    //   94: aload_0
    //   95: getfield 40	com/fasterxml/jackson/databind/SequenceWriter:_generator	Lcom/fasterxml/jackson/core/JsonGenerator;
    //   98: invokevirtual 155	com/fasterxml/jackson/core/JsonGenerator:flush	()V
    //   101: aconst_null
    //   102: astore_3
    //   103: aload 4
    //   105: invokeinterface 158 1 0
    //   110: iconst_0
    //   111: ifeq +11 -> 122
    //   114: new 160	java/lang/NullPointerException
    //   117: dup
    //   118: invokespecial 161	java/lang/NullPointerException:<init>	()V
    //   121: athrow
    //   122: aload_0
    //   123: areturn
    //   124: astore_1
    //   125: aload_3
    //   126: ifnull +9 -> 135
    //   129: aload_3
    //   130: invokeinterface 158 1 0
    //   135: aload_1
    //   136: athrow
    //   137: astore_1
    //   138: aload_0
    //   139: areturn
    //   140: astore_2
    //   141: goto -6 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	SequenceWriter
    //   0	144	1	paramObject	Object
    //   17	61	2	localJsonSerializer1	JsonSerializer
    //   140	1	2	localIOException	IOException
    //   8	122	3	localCloseable1	Closeable
    //   4	100	4	localCloseable2	Closeable
    //   13	37	5	localJsonSerializer2	JsonSerializer
    //   30	29	6	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   9	15	124	finally
    //   26	32	124	finally
    //   35	46	124	finally
    //   57	64	124	finally
    //   67	81	124	finally
    //   84	91	124	finally
    //   94	101	124	finally
    //   103	110	124	finally
    //   114	122	137	java/io/IOException
    //   129	135	140	java/io/IOException
  }
  
  /* Error */
  protected SequenceWriter _writeCloseableValue(Object paramObject, JavaType paramJavaType)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: checkcast 8	java/io/Closeable
    //   4: astore 5
    //   6: aload 5
    //   8: astore_3
    //   9: aload_0
    //   10: getfield 91	com/fasterxml/jackson/databind/SequenceWriter:_dynamicSerializers	Lcom/fasterxml/jackson/databind/ser/impl/PropertySerializerMap;
    //   13: aload_2
    //   14: invokevirtual 167	com/fasterxml/jackson/databind/JavaType:getRawClass	()Ljava/lang/Class;
    //   17: invokevirtual 144	com/fasterxml/jackson/databind/ser/impl/PropertySerializerMap:serializerFor	(Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JsonSerializer;
    //   20: astore 6
    //   22: aload 6
    //   24: astore 4
    //   26: aload 6
    //   28: ifnonnull +13 -> 41
    //   31: aload 5
    //   33: astore_3
    //   34: aload_0
    //   35: aload_2
    //   36: invokespecial 169	com/fasterxml/jackson/databind/SequenceWriter:_findAndAddDynamic	(Lcom/fasterxml/jackson/databind/JavaType;)Lcom/fasterxml/jackson/databind/JsonSerializer;
    //   39: astore 4
    //   41: aload 5
    //   43: astore_3
    //   44: aload_0
    //   45: getfield 38	com/fasterxml/jackson/databind/SequenceWriter:_provider	Lcom/fasterxml/jackson/databind/ser/DefaultSerializerProvider;
    //   48: aload_0
    //   49: getfield 40	com/fasterxml/jackson/databind/SequenceWriter:_generator	Lcom/fasterxml/jackson/core/JsonGenerator;
    //   52: aload_1
    //   53: aload_2
    //   54: aload 4
    //   56: invokevirtual 150	com/fasterxml/jackson/databind/ser/DefaultSerializerProvider:serializeValue	(Lcom/fasterxml/jackson/core/JsonGenerator;Ljava/lang/Object;Lcom/fasterxml/jackson/databind/JavaType;Lcom/fasterxml/jackson/databind/JsonSerializer;)V
    //   59: aload 5
    //   61: astore_3
    //   62: aload_0
    //   63: getfield 78	com/fasterxml/jackson/databind/SequenceWriter:_cfgFlush	Z
    //   66: ifeq +13 -> 79
    //   69: aload 5
    //   71: astore_3
    //   72: aload_0
    //   73: getfield 40	com/fasterxml/jackson/databind/SequenceWriter:_generator	Lcom/fasterxml/jackson/core/JsonGenerator;
    //   76: invokevirtual 155	com/fasterxml/jackson/core/JsonGenerator:flush	()V
    //   79: aconst_null
    //   80: astore_3
    //   81: aload 5
    //   83: invokeinterface 158 1 0
    //   88: iconst_0
    //   89: ifeq +11 -> 100
    //   92: new 160	java/lang/NullPointerException
    //   95: dup
    //   96: invokespecial 161	java/lang/NullPointerException:<init>	()V
    //   99: athrow
    //   100: aload_0
    //   101: areturn
    //   102: astore_1
    //   103: aload_3
    //   104: ifnull +9 -> 113
    //   107: aload_3
    //   108: invokeinterface 158 1 0
    //   113: aload_1
    //   114: athrow
    //   115: astore_1
    //   116: aload_0
    //   117: areturn
    //   118: astore_2
    //   119: goto -6 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	SequenceWriter
    //   0	122	1	paramObject	Object
    //   0	122	2	paramJavaType	JavaType
    //   8	100	3	localCloseable1	Closeable
    //   24	31	4	localJsonSerializer1	JsonSerializer
    //   4	78	5	localCloseable2	Closeable
    //   20	7	6	localJsonSerializer2	JsonSerializer
    // Exception table:
    //   from	to	target	type
    //   9	22	102	finally
    //   34	41	102	finally
    //   44	59	102	finally
    //   62	69	102	finally
    //   72	79	102	finally
    //   81	88	102	finally
    //   92	100	115	java/io/IOException
    //   107	113	118	java/io/IOException
  }
  
  public void close()
    throws IOException
  {
    if (!_closed)
    {
      _closed = true;
      if (_openArray)
      {
        _openArray = false;
        _generator.writeEndArray();
      }
      if (_closeGenerator) {
        _generator.close();
      }
    }
  }
  
  public void flush()
    throws IOException
  {
    if (!_closed) {
      _generator.flush();
    }
  }
  
  public SequenceWriter init(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean)
    {
      _generator.writeStartArray();
      _openArray = true;
    }
    return this;
  }
  
  public Version version()
  {
    return PackageVersion.VERSION;
  }
  
  public SequenceWriter write(Object paramObject)
    throws IOException
  {
    if (paramObject == null) {
      _provider.serializeValue(_generator, null);
    }
    do
    {
      return this;
      if ((_cfgCloseCloseable) && ((paramObject instanceof Closeable))) {
        return _writeCloseableValue(paramObject);
      }
      JsonSerializer localJsonSerializer2 = _rootSerializer;
      JsonSerializer localJsonSerializer1 = localJsonSerializer2;
      if (localJsonSerializer2 == null)
      {
        Class localClass = paramObject.getClass();
        localJsonSerializer2 = _dynamicSerializers.serializerFor(localClass);
        localJsonSerializer1 = localJsonSerializer2;
        if (localJsonSerializer2 == null) {
          localJsonSerializer1 = _findAndAddDynamic(localClass);
        }
      }
      _provider.serializeValue(_generator, paramObject, null, localJsonSerializer1);
    } while (!_cfgFlush);
    _generator.flush();
    return this;
  }
  
  public SequenceWriter write(Object paramObject, JavaType paramJavaType)
    throws IOException
  {
    if (paramObject == null) {
      _provider.serializeValue(_generator, null);
    }
    do
    {
      return this;
      if ((_cfgCloseCloseable) && ((paramObject instanceof Closeable))) {
        return _writeCloseableValue(paramObject, paramJavaType);
      }
      JsonSerializer localJsonSerializer2 = _dynamicSerializers.serializerFor(paramJavaType.getRawClass());
      JsonSerializer localJsonSerializer1 = localJsonSerializer2;
      if (localJsonSerializer2 == null) {
        localJsonSerializer1 = _findAndAddDynamic(paramJavaType);
      }
      _provider.serializeValue(_generator, paramObject, paramJavaType, localJsonSerializer1);
    } while (!_cfgFlush);
    _generator.flush();
    return this;
  }
  
  public <C extends Collection<?>> SequenceWriter writeAll(C paramC)
    throws IOException
  {
    paramC = paramC.iterator();
    while (paramC.hasNext()) {
      write(paramC.next());
    }
    return this;
  }
  
  public SequenceWriter writeAll(Object[] paramArrayOfObject)
    throws IOException
  {
    int i = 0;
    int j = paramArrayOfObject.length;
    while (i < j)
    {
      write(paramArrayOfObject[i]);
      i += 1;
    }
    return this;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.SequenceWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */