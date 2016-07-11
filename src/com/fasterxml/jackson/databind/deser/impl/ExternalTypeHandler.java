package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ExternalTypeHandler
{
  private final HashMap<String, Integer> _nameToPropertyIndex;
  private final ExtTypedProperty[] _properties;
  private final TokenBuffer[] _tokens;
  private final String[] _typeIds;
  
  protected ExternalTypeHandler(ExternalTypeHandler paramExternalTypeHandler)
  {
    _properties = _properties;
    _nameToPropertyIndex = _nameToPropertyIndex;
    int i = _properties.length;
    _typeIds = new String[i];
    _tokens = new TokenBuffer[i];
  }
  
  protected ExternalTypeHandler(ExtTypedProperty[] paramArrayOfExtTypedProperty, HashMap<String, Integer> paramHashMap, String[] paramArrayOfString, TokenBuffer[] paramArrayOfTokenBuffer)
  {
    _properties = paramArrayOfExtTypedProperty;
    _nameToPropertyIndex = paramHashMap;
    _typeIds = paramArrayOfString;
    _tokens = paramArrayOfTokenBuffer;
  }
  
  protected final Object _deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, int paramInt, String paramString)
    throws IOException
  {
    JsonParser localJsonParser = _tokens[paramInt].asParser(paramJsonParser);
    if (localJsonParser.nextToken() == JsonToken.VALUE_NULL) {
      return null;
    }
    TokenBuffer localTokenBuffer = new TokenBuffer(paramJsonParser, paramDeserializationContext);
    localTokenBuffer.writeStartArray();
    localTokenBuffer.writeString(paramString);
    localTokenBuffer.copyCurrentStructure(localJsonParser);
    localTokenBuffer.writeEndArray();
    paramJsonParser = localTokenBuffer.asParser(paramJsonParser);
    paramJsonParser.nextToken();
    return _properties[paramInt].getProperty().deserialize(paramJsonParser, paramDeserializationContext);
  }
  
  protected final void _deserializeAndSet(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject, int paramInt, String paramString)
    throws IOException
  {
    JsonParser localJsonParser = _tokens[paramInt].asParser(paramJsonParser);
    if (localJsonParser.nextToken() == JsonToken.VALUE_NULL)
    {
      _properties[paramInt].getProperty().set(paramObject, null);
      return;
    }
    TokenBuffer localTokenBuffer = new TokenBuffer(paramJsonParser, paramDeserializationContext);
    localTokenBuffer.writeStartArray();
    localTokenBuffer.writeString(paramString);
    localTokenBuffer.copyCurrentStructure(localJsonParser);
    localTokenBuffer.writeEndArray();
    paramJsonParser = localTokenBuffer.asParser(paramJsonParser);
    paramJsonParser.nextToken();
    _properties[paramInt].getProperty().deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject);
  }
  
  public Object complete(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, PropertyValueBuffer paramPropertyValueBuffer, PropertyBasedCreator paramPropertyBasedCreator)
    throws IOException
  {
    int j = _properties.length;
    Object[] arrayOfObject = new Object[j];
    int i = 0;
    while (i < j)
    {
      String str = _typeIds[i];
      if (str == null)
      {
        if (_tokens[i] == null)
        {
          i += 1;
        }
        else
        {
          if (!_properties[i].hasDefaultType()) {
            throw paramDeserializationContext.mappingException("Missing external type id property '%s'", new Object[] { _properties[i].getTypePropertyName() });
          }
          str = _properties[i].getDefaultTypeId();
        }
      }
      else
      {
        while (_tokens[i] != null) {
          for (;;)
          {
            arrayOfObject[i] = _deserialize(paramJsonParser, paramDeserializationContext, i, str);
          }
        }
        throw paramDeserializationContext.mappingException("Missing property '%s' for external type id '%s'", new Object[] { _properties[i].getProperty().getName(), _properties[i].getTypePropertyName() });
      }
    }
    i = 0;
    while (i < j)
    {
      paramJsonParser = _properties[i].getProperty();
      if (paramPropertyBasedCreator.findCreatorProperty(paramJsonParser.getName()) != null) {
        paramPropertyValueBuffer.assignParameter(paramJsonParser, arrayOfObject[i]);
      }
      i += 1;
    }
    paramJsonParser = paramPropertyBasedCreator.build(paramDeserializationContext, paramPropertyValueBuffer);
    i = 0;
    while (i < j)
    {
      paramDeserializationContext = _properties[i].getProperty();
      if (paramPropertyBasedCreator.findCreatorProperty(paramDeserializationContext.getName()) == null) {
        paramDeserializationContext.set(paramJsonParser, arrayOfObject[i]);
      }
      i += 1;
    }
    return paramJsonParser;
  }
  
  public Object complete(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException
  {
    int i = 0;
    int j = _properties.length;
    if (i < j)
    {
      Object localObject2 = _typeIds[i];
      Object localObject1;
      if (localObject2 == null)
      {
        TokenBuffer localTokenBuffer = _tokens[i];
        if (localTokenBuffer == null) {}
        for (;;)
        {
          i += 1;
          break;
          JsonToken localJsonToken = localTokenBuffer.firstToken();
          localObject1 = localObject2;
          if (localJsonToken == null) {
            break label186;
          }
          localObject1 = localObject2;
          if (!localJsonToken.isScalarValue()) {
            break label186;
          }
          localObject2 = localTokenBuffer.asParser(paramJsonParser);
          ((JsonParser)localObject2).nextToken();
          localObject1 = _properties[i].getProperty();
          localObject2 = TypeDeserializer.deserializeIfNatural((JsonParser)localObject2, paramDeserializationContext, ((SettableBeanProperty)localObject1).getType());
          if (localObject2 == null) {
            break label137;
          }
          ((SettableBeanProperty)localObject1).set(paramObject, localObject2);
        }
        label137:
        if (!_properties[i].hasDefaultType()) {
          throw paramDeserializationContext.mappingException("Missing external type id property '%s'", new Object[] { _properties[i].getTypePropertyName() });
        }
        localObject1 = _properties[i].getDefaultTypeId();
      }
      label186:
      do
      {
        _deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject, i, (String)localObject1);
        break;
        localObject1 = localObject2;
      } while (_tokens[i] != null);
      throw paramDeserializationContext.mappingException("Missing property '%s' for external type id '%s'", new Object[] { _properties[i].getProperty().getName(), _properties[i].getTypePropertyName() });
    }
    return paramObject;
  }
  
  public boolean handlePropertyValue(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, String paramString, Object paramObject)
    throws IOException
  {
    Integer localInteger = (Integer)_nameToPropertyIndex.get(paramString);
    if (localInteger == null) {
      return false;
    }
    int j = localInteger.intValue();
    if (_properties[j].hasTypePropertyName(paramString))
    {
      _typeIds[j] = paramJsonParser.getText();
      paramJsonParser.skipChildren();
      if ((paramObject != null) && (_tokens[j] != null)) {}
      for (i = 1;; i = 0)
      {
        if (i != 0)
        {
          paramString = _typeIds[j];
          _typeIds[j] = null;
          _deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject, j, paramString);
          _tokens[j] = null;
        }
        return true;
      }
    }
    paramString = new TokenBuffer(paramJsonParser, paramDeserializationContext);
    paramString.copyCurrentStructure(paramJsonParser);
    _tokens[j] = paramString;
    if ((paramObject != null) && (_typeIds[j] != null)) {}
    for (int i = 1;; i = 0) {
      break;
    }
  }
  
  public boolean handleTypePropertyValue(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, String paramString, Object paramObject)
    throws IOException
  {
    Integer localInteger = (Integer)_nameToPropertyIndex.get(paramString);
    if (localInteger == null) {}
    int j;
    do
    {
      return false;
      j = localInteger.intValue();
    } while (!_properties[j].hasTypePropertyName(paramString));
    paramString = paramJsonParser.getText();
    int i;
    if ((paramObject != null) && (_tokens[j] != null))
    {
      i = 1;
      if (i == 0) {
        break label96;
      }
      _deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject, j, paramString);
      _tokens[j] = null;
    }
    for (;;)
    {
      return true;
      i = 0;
      break;
      label96:
      _typeIds[j] = paramString;
    }
  }
  
  public ExternalTypeHandler start()
  {
    return new ExternalTypeHandler(this);
  }
  
  public static class Builder
  {
    private final HashMap<String, Integer> _nameToPropertyIndex = new HashMap();
    private final ArrayList<ExternalTypeHandler.ExtTypedProperty> _properties = new ArrayList();
    
    public void addExternal(SettableBeanProperty paramSettableBeanProperty, TypeDeserializer paramTypeDeserializer)
    {
      Integer localInteger = Integer.valueOf(_properties.size());
      _properties.add(new ExternalTypeHandler.ExtTypedProperty(paramSettableBeanProperty, paramTypeDeserializer));
      _nameToPropertyIndex.put(paramSettableBeanProperty.getName(), localInteger);
      _nameToPropertyIndex.put(paramTypeDeserializer.getPropertyName(), localInteger);
    }
    
    public ExternalTypeHandler build()
    {
      return new ExternalTypeHandler((ExternalTypeHandler.ExtTypedProperty[])_properties.toArray(new ExternalTypeHandler.ExtTypedProperty[_properties.size()]), _nameToPropertyIndex, null, null);
    }
  }
  
  private static final class ExtTypedProperty
  {
    private final SettableBeanProperty _property;
    private final TypeDeserializer _typeDeserializer;
    private final String _typePropertyName;
    
    public ExtTypedProperty(SettableBeanProperty paramSettableBeanProperty, TypeDeserializer paramTypeDeserializer)
    {
      _property = paramSettableBeanProperty;
      _typeDeserializer = paramTypeDeserializer;
      _typePropertyName = paramTypeDeserializer.getPropertyName();
    }
    
    public String getDefaultTypeId()
    {
      Class localClass = _typeDeserializer.getDefaultImpl();
      if (localClass == null) {
        return null;
      }
      return _typeDeserializer.getTypeIdResolver().idFromValueAndType(null, localClass);
    }
    
    public SettableBeanProperty getProperty()
    {
      return _property;
    }
    
    public String getTypePropertyName()
    {
      return _typePropertyName;
    }
    
    public boolean hasDefaultType()
    {
      return _typeDeserializer.getDefaultImpl() != null;
    }
    
    public boolean hasTypePropertyName(String paramString)
    {
      return paramString.equals(_typePropertyName);
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */