package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UnwrappedPropertyHandler
{
  protected final List<SettableBeanProperty> _properties;
  
  public UnwrappedPropertyHandler()
  {
    _properties = new ArrayList();
  }
  
  protected UnwrappedPropertyHandler(List<SettableBeanProperty> paramList)
  {
    _properties = paramList;
  }
  
  public void addProperty(SettableBeanProperty paramSettableBeanProperty)
  {
    _properties.add(paramSettableBeanProperty);
  }
  
  public Object processUnwrapped(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject, TokenBuffer paramTokenBuffer)
    throws IOException, JsonProcessingException
  {
    int i = 0;
    int j = _properties.size();
    while (i < j)
    {
      paramJsonParser = (SettableBeanProperty)_properties.get(i);
      JsonParser localJsonParser = paramTokenBuffer.asParser();
      localJsonParser.nextToken();
      paramJsonParser.deserializeAndSet(localJsonParser, paramDeserializationContext, paramObject);
      i += 1;
    }
    return paramObject;
  }
  
  public UnwrappedPropertyHandler renameAll(NameTransformer paramNameTransformer)
  {
    ArrayList localArrayList = new ArrayList(_properties.size());
    Iterator localIterator = _properties.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (SettableBeanProperty)localIterator.next();
      SettableBeanProperty localSettableBeanProperty = ((SettableBeanProperty)localObject).withSimpleName(paramNameTransformer.transform(((SettableBeanProperty)localObject).getName()));
      JsonDeserializer localJsonDeserializer1 = localSettableBeanProperty.getValueDeserializer();
      localObject = localSettableBeanProperty;
      if (localJsonDeserializer1 != null)
      {
        JsonDeserializer localJsonDeserializer2 = localJsonDeserializer1.unwrappingDeserializer(paramNameTransformer);
        localObject = localSettableBeanProperty;
        if (localJsonDeserializer2 != localJsonDeserializer1) {
          localObject = localSettableBeanProperty.withValueDeserializer(localJsonDeserializer2);
        }
      }
      localArrayList.add(localObject);
    }
    return new UnwrappedPropertyHandler(localArrayList);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.deser.impl.UnwrappedPropertyHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */