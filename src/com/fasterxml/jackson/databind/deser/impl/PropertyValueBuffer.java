package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.SettableAnyProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import java.io.IOException;
import java.util.BitSet;

public class PropertyValueBuffer
{
  protected PropertyValue _buffered;
  protected final DeserializationContext _context;
  protected final Object[] _creatorParameters;
  protected Object _idValue;
  protected final ObjectIdReader _objectIdReader;
  protected int _paramsNeeded;
  protected int _paramsSeen;
  protected final BitSet _paramsSeenBig;
  protected final JsonParser _parser;
  
  public PropertyValueBuffer(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, int paramInt, ObjectIdReader paramObjectIdReader)
  {
    _parser = paramJsonParser;
    _context = paramDeserializationContext;
    _paramsNeeded = paramInt;
    _objectIdReader = paramObjectIdReader;
    _creatorParameters = new Object[paramInt];
    if (paramInt < 32)
    {
      _paramsSeenBig = null;
      return;
    }
    _paramsSeenBig = new BitSet();
  }
  
  protected Object _findMissing(SettableBeanProperty paramSettableBeanProperty)
    throws JsonMappingException
  {
    if (paramSettableBeanProperty.getInjectableValueId() != null) {
      return _context.findInjectableValue(paramSettableBeanProperty.getInjectableValueId(), paramSettableBeanProperty, null);
    }
    if (paramSettableBeanProperty.isRequired()) {
      throw _context.mappingException("Missing required creator property '%s' (index %d)", new Object[] { paramSettableBeanProperty.getName(), Integer.valueOf(paramSettableBeanProperty.getCreatorIndex()) });
    }
    if (_context.isEnabled(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES)) {
      throw _context.mappingException("Missing creator property '%s' (index %d); DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES enabled", new Object[] { paramSettableBeanProperty.getName(), Integer.valueOf(paramSettableBeanProperty.getCreatorIndex()) });
    }
    return paramSettableBeanProperty.getValueDeserializer().getNullValue(_context);
  }
  
  @Deprecated
  public boolean assignParameter(int paramInt, Object paramObject)
  {
    _creatorParameters[paramInt] = paramObject;
    return false;
  }
  
  public boolean assignParameter(SettableBeanProperty paramSettableBeanProperty, Object paramObject)
  {
    int i = paramSettableBeanProperty.getCreatorIndex();
    _creatorParameters[i] = paramObject;
    int j;
    if (_paramsSeenBig == null)
    {
      j = _paramsSeen;
      i = j | 1 << i;
      if (j != i)
      {
        _paramsSeen = i;
        i = _paramsNeeded - 1;
        _paramsNeeded = i;
        if (i > 0) {}
      }
    }
    else
    {
      do
      {
        return true;
        if (_paramsSeenBig.get(i)) {
          break;
        }
        j = _paramsNeeded - 1;
        _paramsNeeded = j;
      } while (j <= 0);
      _paramsSeenBig.set(i);
    }
    return false;
  }
  
  public void bufferAnyProperty(SettableAnyProperty paramSettableAnyProperty, String paramString, Object paramObject)
  {
    _buffered = new PropertyValue.Any(_buffered, paramObject, paramSettableAnyProperty, paramString);
  }
  
  public void bufferMapProperty(Object paramObject1, Object paramObject2)
  {
    _buffered = new PropertyValue.Map(_buffered, paramObject2, paramObject1);
  }
  
  public void bufferProperty(SettableBeanProperty paramSettableBeanProperty, Object paramObject)
  {
    _buffered = new PropertyValue.Regular(_buffered, paramObject, paramSettableBeanProperty);
  }
  
  protected PropertyValue buffered()
  {
    return _buffered;
  }
  
  protected Object[] getParameters(SettableBeanProperty[] paramArrayOfSettableBeanProperty)
    throws JsonMappingException
  {
    if (_paramsNeeded > 0)
    {
      if (_paramsSeenBig == null)
      {
        i = _paramsSeen;
        j = 0;
        int k = _creatorParameters.length;
        while (j < k)
        {
          if ((i & 0x1) == 0) {
            _creatorParameters[j] = _findMissing(paramArrayOfSettableBeanProperty[j]);
          }
          j += 1;
          i >>= 1;
        }
      }
      int j = _creatorParameters.length;
      int i = 0;
      for (;;)
      {
        i = _paramsSeenBig.nextClearBit(i);
        if (i >= j) {
          break;
        }
        _creatorParameters[i] = _findMissing(paramArrayOfSettableBeanProperty[i]);
        i += 1;
      }
    }
    return _creatorParameters;
  }
  
  public Object handleIdValue(DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException
  {
    Object localObject = paramObject;
    if (_objectIdReader != null)
    {
      if (_idValue == null) {
        break label68;
      }
      paramDeserializationContext.findObjectId(_idValue, _objectIdReader.generator, _objectIdReader.resolver).bindItem(paramObject);
      paramDeserializationContext = _objectIdReader.idProperty;
      localObject = paramObject;
      if (paramDeserializationContext != null) {
        localObject = paramDeserializationContext.setAndReturn(paramObject, _idValue);
      }
    }
    return localObject;
    label68:
    throw paramDeserializationContext.mappingException("No _idValue when handleIdValue called, on instance of %s", new Object[] { paramObject.getClass().getName() });
  }
  
  public boolean isComplete()
  {
    return _paramsNeeded <= 0;
  }
  
  public boolean readIdProperty(String paramString)
    throws IOException
  {
    if ((_objectIdReader != null) && (paramString.equals(_objectIdReader.propertyName.getSimpleName())))
    {
      _idValue = _objectIdReader.readObjectReference(_parser, _context);
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */