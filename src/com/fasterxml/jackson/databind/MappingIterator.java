package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.FormatSchema;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class MappingIterator<T>
  implements Iterator<T>, Closeable
{
  protected static final MappingIterator<?> EMPTY_ITERATOR = new MappingIterator(null, null, null, null, false, null);
  protected static final int STATE_CLOSED = 0;
  protected static final int STATE_HAS_VALUE = 3;
  protected static final int STATE_MAY_HAVE_VALUE = 2;
  protected static final int STATE_NEED_RESYNC = 1;
  protected final boolean _closeParser;
  protected final DeserializationContext _context;
  protected final JsonDeserializer<T> _deserializer;
  protected final JsonParser _parser;
  protected final JsonStreamContext _seqContext;
  protected int _state;
  protected final JavaType _type;
  protected final T _updatedValue;
  
  protected MappingIterator(JavaType paramJavaType, JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, JsonDeserializer<?> paramJsonDeserializer, boolean paramBoolean, Object paramObject)
  {
    _type = paramJavaType;
    _parser = paramJsonParser;
    _context = paramDeserializationContext;
    _deserializer = paramJsonDeserializer;
    _closeParser = paramBoolean;
    if (paramObject == null) {}
    for (_updatedValue = null; paramJsonParser == null; _updatedValue = paramObject)
    {
      _seqContext = null;
      _state = 0;
      return;
    }
    paramDeserializationContext = paramJsonParser.getParsingContext();
    if ((paramBoolean) && (paramJsonParser.isExpectedStartArrayToken()))
    {
      paramJsonParser.clearCurrentToken();
      paramJavaType = paramDeserializationContext;
    }
    for (;;)
    {
      _seqContext = paramJavaType;
      _state = 2;
      return;
      paramJsonParser = paramJsonParser.getCurrentToken();
      if (paramJsonParser != JsonToken.START_OBJECT)
      {
        paramJavaType = paramDeserializationContext;
        if (paramJsonParser != JsonToken.START_ARRAY) {}
      }
      else
      {
        paramJavaType = paramDeserializationContext.getParent();
      }
    }
  }
  
  protected static <T> MappingIterator<T> emptyIterator()
  {
    return EMPTY_ITERATOR;
  }
  
  protected <R> R _handleIOException(IOException paramIOException)
  {
    throw new RuntimeException(paramIOException.getMessage(), paramIOException);
  }
  
  protected <R> R _handleMappingException(JsonMappingException paramJsonMappingException)
  {
    throw new RuntimeJsonMappingException(paramJsonMappingException.getMessage(), paramJsonMappingException);
  }
  
  protected void _resync()
    throws IOException
  {
    JsonParser localJsonParser = _parser;
    JsonToken localJsonToken;
    if (localJsonParser.getParsingContext() == _seqContext)
    {
      return;
      if ((localJsonToken != JsonToken.START_ARRAY) && (localJsonToken != JsonToken.START_OBJECT)) {
        break label71;
      }
      localJsonParser.skipChildren();
    }
    label71:
    while (localJsonToken != null)
    {
      do
      {
        localJsonToken = localJsonParser.nextToken();
        if ((localJsonToken != JsonToken.END_ARRAY) && (localJsonToken != JsonToken.END_OBJECT)) {
          break;
        }
      } while (localJsonParser.getParsingContext() != _seqContext);
      localJsonParser.clearCurrentToken();
      return;
    }
  }
  
  protected <R> R _throwNoSuchElement()
  {
    throw new NoSuchElementException();
  }
  
  public void close()
    throws IOException
  {
    if (_state != 0)
    {
      _state = 0;
      if (_parser != null) {
        _parser.close();
      }
    }
  }
  
  public JsonLocation getCurrentLocation()
  {
    return _parser.getCurrentLocation();
  }
  
  public JsonParser getParser()
  {
    return _parser;
  }
  
  public FormatSchema getParserSchema()
  {
    return _parser.getSchema();
  }
  
  public boolean hasNext()
  {
    try
    {
      boolean bool = hasNextValue();
      return bool;
    }
    catch (JsonMappingException localJsonMappingException)
    {
      return ((Boolean)_handleMappingException(localJsonMappingException)).booleanValue();
    }
    catch (IOException localIOException)
    {
      return ((Boolean)_handleIOException(localIOException)).booleanValue();
    }
  }
  
  public boolean hasNextValue()
    throws IOException
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    switch (_state)
    {
    default: 
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        _resync();
        if (_parser.getCurrentToken() != null) {
          break;
        }
        JsonToken localJsonToken = _parser.nextToken();
        if ((localJsonToken != null) && (localJsonToken != JsonToken.END_ARRAY)) {
          break;
        }
        _state = 0;
        bool1 = bool2;
      } while (!_closeParser);
      bool1 = bool2;
    } while (_parser == null);
    _parser.close();
    return false;
    _state = 3;
    return true;
  }
  
  public T next()
  {
    try
    {
      Object localObject = nextValue();
      return (T)localObject;
    }
    catch (JsonMappingException localJsonMappingException)
    {
      throw new RuntimeJsonMappingException(localJsonMappingException.getMessage(), localJsonMappingException);
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException.getMessage(), localIOException);
    }
  }
  
  /* Error */
  public T nextValue()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 65	com/fasterxml/jackson/databind/MappingIterator:_state	I
    //   4: tableswitch	default:+28->32, 0:+65->69, 1:+70->74, 2:+70->74
    //   32: aload_0
    //   33: getfield 61	com/fasterxml/jackson/databind/MappingIterator:_updatedValue	Ljava/lang/Object;
    //   36: ifnonnull +50 -> 86
    //   39: aload_0
    //   40: getfield 57	com/fasterxml/jackson/databind/MappingIterator:_deserializer	Lcom/fasterxml/jackson/databind/JsonDeserializer;
    //   43: aload_0
    //   44: getfield 53	com/fasterxml/jackson/databind/MappingIterator:_parser	Lcom/fasterxml/jackson/core/JsonParser;
    //   47: aload_0
    //   48: getfield 55	com/fasterxml/jackson/databind/MappingIterator:_context	Lcom/fasterxml/jackson/databind/DeserializationContext;
    //   51: invokevirtual 186	com/fasterxml/jackson/databind/JsonDeserializer:deserialize	(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Object;
    //   54: astore_1
    //   55: aload_0
    //   56: iconst_2
    //   57: putfield 65	com/fasterxml/jackson/databind/MappingIterator:_state	I
    //   60: aload_0
    //   61: getfield 53	com/fasterxml/jackson/databind/MappingIterator:_parser	Lcom/fasterxml/jackson/core/JsonParser;
    //   64: invokevirtual 78	com/fasterxml/jackson/core/JsonParser:clearCurrentToken	()V
    //   67: aload_1
    //   68: areturn
    //   69: aload_0
    //   70: invokevirtual 188	com/fasterxml/jackson/databind/MappingIterator:_throwNoSuchElement	()Ljava/lang/Object;
    //   73: areturn
    //   74: aload_0
    //   75: invokevirtual 164	com/fasterxml/jackson/databind/MappingIterator:hasNextValue	()Z
    //   78: ifne -46 -> 32
    //   81: aload_0
    //   82: invokevirtual 188	com/fasterxml/jackson/databind/MappingIterator:_throwNoSuchElement	()Ljava/lang/Object;
    //   85: areturn
    //   86: aload_0
    //   87: getfield 57	com/fasterxml/jackson/databind/MappingIterator:_deserializer	Lcom/fasterxml/jackson/databind/JsonDeserializer;
    //   90: aload_0
    //   91: getfield 53	com/fasterxml/jackson/databind/MappingIterator:_parser	Lcom/fasterxml/jackson/core/JsonParser;
    //   94: aload_0
    //   95: getfield 55	com/fasterxml/jackson/databind/MappingIterator:_context	Lcom/fasterxml/jackson/databind/DeserializationContext;
    //   98: aload_0
    //   99: getfield 61	com/fasterxml/jackson/databind/MappingIterator:_updatedValue	Ljava/lang/Object;
    //   102: invokevirtual 191	com/fasterxml/jackson/databind/JsonDeserializer:deserialize	(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;Ljava/lang/Object;)Ljava/lang/Object;
    //   105: pop
    //   106: aload_0
    //   107: getfield 61	com/fasterxml/jackson/databind/MappingIterator:_updatedValue	Ljava/lang/Object;
    //   110: astore_1
    //   111: goto -56 -> 55
    //   114: astore_1
    //   115: aload_0
    //   116: iconst_1
    //   117: putfield 65	com/fasterxml/jackson/databind/MappingIterator:_state	I
    //   120: aload_0
    //   121: getfield 53	com/fasterxml/jackson/databind/MappingIterator:_parser	Lcom/fasterxml/jackson/core/JsonParser;
    //   124: invokevirtual 78	com/fasterxml/jackson/core/JsonParser:clearCurrentToken	()V
    //   127: aload_1
    //   128: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	MappingIterator
    //   54	57	1	localObject1	Object
    //   114	14	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   32	55	114	finally
    //   86	111	114	finally
  }
  
  public <C extends Collection<? super T>> C readAll(C paramC)
    throws IOException
  {
    while (hasNextValue()) {
      paramC.add(nextValue());
    }
    return paramC;
  }
  
  public List<T> readAll()
    throws IOException
  {
    return readAll(new ArrayList());
  }
  
  public <L extends List<? super T>> L readAll(L paramL)
    throws IOException
  {
    while (hasNextValue()) {
      paramL.add(nextValue());
    }
    return paramL;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.MappingIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */