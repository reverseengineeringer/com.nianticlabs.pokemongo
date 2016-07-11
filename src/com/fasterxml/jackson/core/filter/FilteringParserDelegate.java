package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public class FilteringParserDelegate
  extends JsonParserDelegate
{
  protected boolean _allowMultipleMatches;
  protected JsonToken _currToken;
  protected TokenFilterContext _exposedContext;
  protected TokenFilterContext _headContext;
  @Deprecated
  protected boolean _includeImmediateParent = false;
  protected boolean _includePath;
  protected TokenFilter _itemFilter;
  protected JsonToken _lastClearedToken;
  protected int _matchCount;
  protected TokenFilter rootFilter;
  
  public FilteringParserDelegate(JsonParser paramJsonParser, TokenFilter paramTokenFilter, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramJsonParser);
    rootFilter = paramTokenFilter;
    _itemFilter = paramTokenFilter;
    _headContext = TokenFilterContext.createRootContext(paramTokenFilter);
    _includePath = paramBoolean1;
    _allowMultipleMatches = paramBoolean2;
  }
  
  private JsonToken _nextBuffered(TokenFilterContext paramTokenFilterContext)
    throws IOException
  {
    _exposedContext = paramTokenFilterContext;
    JsonToken localJsonToken = paramTokenFilterContext.nextTokenToRead();
    if (localJsonToken != null) {
      return localJsonToken;
    }
    do
    {
      if (paramTokenFilterContext == _headContext) {
        throw _constructError("Internal error: failed to locate expected buffered tokens");
      }
      paramTokenFilterContext = _exposedContext.findChildOf(paramTokenFilterContext);
      _exposedContext = paramTokenFilterContext;
      if (paramTokenFilterContext == null) {
        throw _constructError("Unexpected problem: chain of filtered context broken");
      }
      localJsonToken = _exposedContext.nextTokenToRead();
    } while (localJsonToken == null);
    return localJsonToken;
  }
  
  protected JsonStreamContext _filterContext()
  {
    if (_exposedContext != null) {
      return _exposedContext;
    }
    return _headContext;
  }
  
  protected final JsonToken _nextToken2()
    throws IOException
  {
    JsonToken localJsonToken;
    Object localObject;
    label563:
    label618:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                localJsonToken = delegate.nextToken();
                if (localJsonToken == null)
                {
                  _currToken = localJsonToken;
                  return localJsonToken;
                }
                TokenFilter localTokenFilter;
                switch (localJsonToken.id())
                {
                default: 
                  localObject = _itemFilter;
                  if (localObject != TokenFilter.INCLUDE_ALL) {
                    break label618;
                  }
                  _currToken = localJsonToken;
                  return localJsonToken;
                case 3: 
                  localObject = _itemFilter;
                  if (localObject == TokenFilter.INCLUDE_ALL)
                  {
                    _headContext = _headContext.createChildArrayContext((TokenFilter)localObject, true);
                    _currToken = localJsonToken;
                    return localJsonToken;
                  }
                  if (localObject == null)
                  {
                    delegate.skipChildren();
                  }
                  else
                  {
                    localTokenFilter = _headContext.checkValue((TokenFilter)localObject);
                    if (localTokenFilter == null)
                    {
                      delegate.skipChildren();
                    }
                    else
                    {
                      localObject = localTokenFilter;
                      if (localTokenFilter != TokenFilter.INCLUDE_ALL) {
                        localObject = localTokenFilter.filterStartArray();
                      }
                      _itemFilter = ((TokenFilter)localObject);
                      if (localObject == TokenFilter.INCLUDE_ALL)
                      {
                        _headContext = _headContext.createChildArrayContext((TokenFilter)localObject, true);
                        _currToken = localJsonToken;
                        return localJsonToken;
                      }
                      _headContext = _headContext.createChildArrayContext((TokenFilter)localObject, false);
                      if (_includePath)
                      {
                        localObject = _nextTokenWithBuffering(_headContext);
                        if (localObject != null)
                        {
                          _currToken = ((JsonToken)localObject);
                          return (JsonToken)localObject;
                        }
                      }
                    }
                  }
                  break;
                case 1: 
                  localObject = _itemFilter;
                  if (localObject == TokenFilter.INCLUDE_ALL)
                  {
                    _headContext = _headContext.createChildObjectContext((TokenFilter)localObject, true);
                    _currToken = localJsonToken;
                    return localJsonToken;
                  }
                  if (localObject == null)
                  {
                    delegate.skipChildren();
                  }
                  else
                  {
                    localTokenFilter = _headContext.checkValue((TokenFilter)localObject);
                    if (localTokenFilter == null)
                    {
                      delegate.skipChildren();
                    }
                    else
                    {
                      localObject = localTokenFilter;
                      if (localTokenFilter != TokenFilter.INCLUDE_ALL) {
                        localObject = localTokenFilter.filterStartObject();
                      }
                      _itemFilter = ((TokenFilter)localObject);
                      if (localObject == TokenFilter.INCLUDE_ALL)
                      {
                        _headContext = _headContext.createChildObjectContext((TokenFilter)localObject, true);
                        _currToken = localJsonToken;
                        return localJsonToken;
                      }
                      _headContext = _headContext.createChildObjectContext((TokenFilter)localObject, false);
                      if (_includePath)
                      {
                        localObject = _nextTokenWithBuffering(_headContext);
                        if (localObject != null)
                        {
                          _currToken = ((JsonToken)localObject);
                          return (JsonToken)localObject;
                        }
                      }
                    }
                  }
                  break;
                case 2: 
                case 4: 
                  boolean bool = _headContext.isStartHandled();
                  localObject = _headContext.getFilter();
                  if ((localObject != null) && (localObject != TokenFilter.INCLUDE_ALL)) {
                    ((TokenFilter)localObject).filterFinishArray();
                  }
                  _headContext = _headContext.getParent();
                  _itemFilter = _headContext.getFilter();
                  if (bool)
                  {
                    _currToken = localJsonToken;
                    return localJsonToken;
                  }
                  break;
                case 5: 
                  localObject = delegate.getCurrentName();
                  localTokenFilter = _headContext.setFieldName((String)localObject);
                  if (localTokenFilter == TokenFilter.INCLUDE_ALL)
                  {
                    _itemFilter = localTokenFilter;
                    _currToken = localJsonToken;
                    return localJsonToken;
                  }
                  if (localTokenFilter == null)
                  {
                    delegate.nextToken();
                    delegate.skipChildren();
                  }
                  else
                  {
                    localObject = localTokenFilter.includeProperty((String)localObject);
                    if (localObject != null) {
                      break label563;
                    }
                    delegate.nextToken();
                    delegate.skipChildren();
                  }
                  break;
                }
              }
              _itemFilter = ((TokenFilter)localObject);
              if (localObject != TokenFilter.INCLUDE_ALL) {
                break;
              }
            } while (!_includePath);
            _currToken = localJsonToken;
            return localJsonToken;
          } while (!_includePath);
          localObject = _nextTokenWithBuffering(_headContext);
        } while (localObject == null);
        _currToken = ((JsonToken)localObject);
        return (JsonToken)localObject;
      } while (localObject == null);
      localObject = _headContext.checkValue((TokenFilter)localObject);
    } while ((localObject != TokenFilter.INCLUDE_ALL) && ((localObject == null) || (!((TokenFilter)localObject).includeValue(delegate))));
    _currToken = localJsonToken;
    return localJsonToken;
  }
  
  protected final JsonToken _nextTokenWithBuffering(TokenFilterContext paramTokenFilterContext)
    throws IOException
  {
    Object localObject;
    label14:
    label356:
    label417:
    label519:
    label539:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            localObject = delegate.nextToken();
            if (localObject == null) {
              return (JsonToken)localObject;
            }
            TokenFilter localTokenFilter;
            switch (((JsonToken)localObject).id())
            {
            default: 
              localObject = _itemFilter;
              if (localObject != TokenFilter.INCLUDE_ALL) {
                break label539;
              }
              return _nextBuffered(paramTokenFilterContext);
            case 3: 
              localTokenFilter = _headContext.checkValue(_itemFilter);
              if (localTokenFilter == null)
              {
                delegate.skipChildren();
              }
              else
              {
                localObject = localTokenFilter;
                if (localTokenFilter != TokenFilter.INCLUDE_ALL) {
                  localObject = localTokenFilter.filterStartArray();
                }
                _itemFilter = ((TokenFilter)localObject);
                if (localObject == TokenFilter.INCLUDE_ALL)
                {
                  _headContext = _headContext.createChildArrayContext((TokenFilter)localObject, true);
                  return _nextBuffered(paramTokenFilterContext);
                }
                _headContext = _headContext.createChildArrayContext((TokenFilter)localObject, false);
              }
              break;
            case 1: 
              localTokenFilter = _itemFilter;
              if (localTokenFilter == TokenFilter.INCLUDE_ALL)
              {
                _headContext = _headContext.createChildObjectContext(localTokenFilter, true);
                return (JsonToken)localObject;
              }
              if (localTokenFilter == null)
              {
                delegate.skipChildren();
              }
              else
              {
                localTokenFilter = _headContext.checkValue(localTokenFilter);
                if (localTokenFilter == null)
                {
                  delegate.skipChildren();
                }
                else
                {
                  localObject = localTokenFilter;
                  if (localTokenFilter != TokenFilter.INCLUDE_ALL) {
                    localObject = localTokenFilter.filterStartObject();
                  }
                  _itemFilter = ((TokenFilter)localObject);
                  if (localObject == TokenFilter.INCLUDE_ALL)
                  {
                    _headContext = _headContext.createChildObjectContext((TokenFilter)localObject, true);
                    return _nextBuffered(paramTokenFilterContext);
                  }
                  _headContext = _headContext.createChildObjectContext((TokenFilter)localObject, false);
                }
              }
              break;
            case 2: 
            case 4: 
              localTokenFilter = _headContext.getFilter();
              if ((localTokenFilter != null) && (localTokenFilter != TokenFilter.INCLUDE_ALL)) {
                localTokenFilter.filterFinishArray();
              }
              int i;
              if (_headContext == paramTokenFilterContext)
              {
                i = 1;
                if ((i == 0) || (!_headContext.isStartHandled())) {
                  break label417;
                }
              }
              for (int j = 1;; j = 0)
              {
                _headContext = _headContext.getParent();
                _itemFilter = _headContext.getFilter();
                if (j != 0) {
                  break label14;
                }
                if ((i == 0) && (_headContext != paramTokenFilterContext)) {
                  break;
                }
                return null;
                i = 0;
                break label356;
              }
            case 5: 
              localObject = delegate.getCurrentName();
              localTokenFilter = _headContext.setFieldName((String)localObject);
              if (localTokenFilter == TokenFilter.INCLUDE_ALL)
              {
                _itemFilter = localTokenFilter;
                return _nextBuffered(paramTokenFilterContext);
              }
              if (localTokenFilter == null)
              {
                delegate.nextToken();
                delegate.skipChildren();
              }
              else
              {
                localObject = localTokenFilter.includeProperty((String)localObject);
                if (localObject != null) {
                  break label519;
                }
                delegate.nextToken();
                delegate.skipChildren();
              }
              break;
            }
          }
          _itemFilter = ((TokenFilter)localObject);
        } while (localObject != TokenFilter.INCLUDE_ALL);
        return _nextBuffered(paramTokenFilterContext);
      } while (localObject == null);
      localObject = _headContext.checkValue((TokenFilter)localObject);
    } while ((localObject != TokenFilter.INCLUDE_ALL) && ((localObject == null) || (!((TokenFilter)localObject).includeValue(delegate))));
    return _nextBuffered(paramTokenFilterContext);
  }
  
  public void clearCurrentToken()
  {
    if (_currToken != null)
    {
      _lastClearedToken = _currToken;
      _currToken = null;
    }
  }
  
  public BigInteger getBigIntegerValue()
    throws IOException
  {
    return delegate.getBigIntegerValue();
  }
  
  public byte[] getBinaryValue(Base64Variant paramBase64Variant)
    throws IOException
  {
    return delegate.getBinaryValue(paramBase64Variant);
  }
  
  public boolean getBooleanValue()
    throws IOException
  {
    return delegate.getBooleanValue();
  }
  
  public byte getByteValue()
    throws IOException
  {
    return delegate.getByteValue();
  }
  
  public JsonLocation getCurrentLocation()
  {
    return delegate.getCurrentLocation();
  }
  
  public String getCurrentName()
    throws IOException
  {
    JsonStreamContext localJsonStreamContext = _filterContext();
    if ((_currToken == JsonToken.START_OBJECT) || (_currToken == JsonToken.START_ARRAY))
    {
      localJsonStreamContext = localJsonStreamContext.getParent();
      if (localJsonStreamContext == null) {
        return null;
      }
      return localJsonStreamContext.getCurrentName();
    }
    return localJsonStreamContext.getCurrentName();
  }
  
  public JsonToken getCurrentToken()
  {
    return _currToken;
  }
  
  public final int getCurrentTokenId()
  {
    JsonToken localJsonToken = _currToken;
    if (localJsonToken == null) {
      return 0;
    }
    return localJsonToken.id();
  }
  
  public BigDecimal getDecimalValue()
    throws IOException
  {
    return delegate.getDecimalValue();
  }
  
  public double getDoubleValue()
    throws IOException
  {
    return delegate.getDoubleValue();
  }
  
  public Object getEmbeddedObject()
    throws IOException
  {
    return delegate.getEmbeddedObject();
  }
  
  public TokenFilter getFilter()
  {
    return rootFilter;
  }
  
  public float getFloatValue()
    throws IOException
  {
    return delegate.getFloatValue();
  }
  
  public int getIntValue()
    throws IOException
  {
    return delegate.getIntValue();
  }
  
  public JsonToken getLastClearedToken()
  {
    return _lastClearedToken;
  }
  
  public long getLongValue()
    throws IOException
  {
    return delegate.getLongValue();
  }
  
  public int getMatchCount()
  {
    return _matchCount;
  }
  
  public JsonParser.NumberType getNumberType()
    throws IOException
  {
    return delegate.getNumberType();
  }
  
  public Number getNumberValue()
    throws IOException
  {
    return delegate.getNumberValue();
  }
  
  public JsonStreamContext getParsingContext()
  {
    return _filterContext();
  }
  
  public short getShortValue()
    throws IOException
  {
    return delegate.getShortValue();
  }
  
  public String getText()
    throws IOException
  {
    return delegate.getText();
  }
  
  public char[] getTextCharacters()
    throws IOException
  {
    return delegate.getTextCharacters();
  }
  
  public int getTextLength()
    throws IOException
  {
    return delegate.getTextLength();
  }
  
  public int getTextOffset()
    throws IOException
  {
    return delegate.getTextOffset();
  }
  
  public JsonLocation getTokenLocation()
  {
    return delegate.getTokenLocation();
  }
  
  public boolean getValueAsBoolean()
    throws IOException
  {
    return delegate.getValueAsBoolean();
  }
  
  public boolean getValueAsBoolean(boolean paramBoolean)
    throws IOException
  {
    return delegate.getValueAsBoolean(paramBoolean);
  }
  
  public double getValueAsDouble()
    throws IOException
  {
    return delegate.getValueAsDouble();
  }
  
  public double getValueAsDouble(double paramDouble)
    throws IOException
  {
    return delegate.getValueAsDouble(paramDouble);
  }
  
  public int getValueAsInt()
    throws IOException
  {
    return delegate.getValueAsInt();
  }
  
  public int getValueAsInt(int paramInt)
    throws IOException
  {
    return delegate.getValueAsInt(paramInt);
  }
  
  public long getValueAsLong()
    throws IOException
  {
    return delegate.getValueAsLong();
  }
  
  public long getValueAsLong(long paramLong)
    throws IOException
  {
    return delegate.getValueAsLong(paramLong);
  }
  
  public String getValueAsString()
    throws IOException
  {
    return delegate.getValueAsString();
  }
  
  public String getValueAsString(String paramString)
    throws IOException
  {
    return delegate.getValueAsString(paramString);
  }
  
  public boolean hasCurrentToken()
  {
    return _currToken != null;
  }
  
  public boolean hasTextCharacters()
  {
    return delegate.hasTextCharacters();
  }
  
  public final boolean hasToken(JsonToken paramJsonToken)
  {
    return _currToken == paramJsonToken;
  }
  
  public boolean hasTokenId(int paramInt)
  {
    JsonToken localJsonToken = _currToken;
    if (localJsonToken == null) {
      if (paramInt != 0) {}
    }
    while (localJsonToken.id() == paramInt)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public boolean isExpectedStartArrayToken()
  {
    return _currToken == JsonToken.START_ARRAY;
  }
  
  public boolean isExpectedStartObjectToken()
  {
    return _currToken == JsonToken.START_OBJECT;
  }
  
  public JsonToken nextToken()
    throws IOException
  {
    Object localObject1 = _exposedContext;
    if (localObject1 != null)
    {
      do
      {
        localObject2 = ((TokenFilterContext)localObject1).nextTokenToRead();
        if (localObject2 != null)
        {
          _currToken = ((JsonToken)localObject2);
          return (JsonToken)localObject2;
        }
        if (localObject1 == _headContext)
        {
          _exposedContext = null;
          if (!((TokenFilterContext)localObject1).inArray()) {
            break;
          }
          localObject1 = delegate.getCurrentToken();
          _currToken = ((JsonToken)localObject1);
          return (JsonToken)localObject1;
        }
        localObject2 = _headContext.findChildOf((TokenFilterContext)localObject1);
        _exposedContext = ((TokenFilterContext)localObject2);
        localObject1 = localObject2;
      } while (localObject2 != null);
      throw _constructError("Unexpected problem: chain of filtered context broken");
    }
    Object localObject2 = delegate.nextToken();
    if (localObject2 == null)
    {
      _currToken = ((JsonToken)localObject2);
      return (JsonToken)localObject2;
    }
    switch (((JsonToken)localObject2).id())
    {
    default: 
      localObject1 = _itemFilter;
      if (localObject1 == TokenFilter.INCLUDE_ALL)
      {
        _currToken = ((JsonToken)localObject2);
        return (JsonToken)localObject2;
      }
      break;
    case 3: 
      localObject1 = _itemFilter;
      if (localObject1 == TokenFilter.INCLUDE_ALL)
      {
        _headContext = _headContext.createChildArrayContext((TokenFilter)localObject1, true);
        _currToken = ((JsonToken)localObject2);
        return (JsonToken)localObject2;
      }
      if (localObject1 == null) {
        delegate.skipChildren();
      }
      break;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return _nextToken2();
              TokenFilter localTokenFilter = _headContext.checkValue((TokenFilter)localObject1);
              if (localTokenFilter == null)
              {
                delegate.skipChildren();
              }
              else
              {
                localObject1 = localTokenFilter;
                if (localTokenFilter != TokenFilter.INCLUDE_ALL) {
                  localObject1 = localTokenFilter.filterStartArray();
                }
                _itemFilter = ((TokenFilter)localObject1);
                if (localObject1 == TokenFilter.INCLUDE_ALL)
                {
                  _headContext = _headContext.createChildArrayContext((TokenFilter)localObject1, true);
                  _currToken = ((JsonToken)localObject2);
                  return (JsonToken)localObject2;
                }
                _headContext = _headContext.createChildArrayContext((TokenFilter)localObject1, false);
                if (_includePath)
                {
                  localObject1 = _nextTokenWithBuffering(_headContext);
                  if (localObject1 != null)
                  {
                    _currToken = ((JsonToken)localObject1);
                    return (JsonToken)localObject1;
                    localObject1 = _itemFilter;
                    if (localObject1 == TokenFilter.INCLUDE_ALL)
                    {
                      _headContext = _headContext.createChildObjectContext((TokenFilter)localObject1, true);
                      _currToken = ((JsonToken)localObject2);
                      return (JsonToken)localObject2;
                    }
                    if (localObject1 == null)
                    {
                      delegate.skipChildren();
                    }
                    else
                    {
                      localTokenFilter = _headContext.checkValue((TokenFilter)localObject1);
                      if (localTokenFilter == null)
                      {
                        delegate.skipChildren();
                      }
                      else
                      {
                        localObject1 = localTokenFilter;
                        if (localTokenFilter != TokenFilter.INCLUDE_ALL) {
                          localObject1 = localTokenFilter.filterStartObject();
                        }
                        _itemFilter = ((TokenFilter)localObject1);
                        if (localObject1 == TokenFilter.INCLUDE_ALL)
                        {
                          _headContext = _headContext.createChildObjectContext((TokenFilter)localObject1, true);
                          _currToken = ((JsonToken)localObject2);
                          return (JsonToken)localObject2;
                        }
                        _headContext = _headContext.createChildObjectContext((TokenFilter)localObject1, false);
                        if (_includePath)
                        {
                          localObject1 = _nextTokenWithBuffering(_headContext);
                          if (localObject1 != null)
                          {
                            _currToken = ((JsonToken)localObject1);
                            return (JsonToken)localObject1;
                            boolean bool = _headContext.isStartHandled();
                            localObject1 = _headContext.getFilter();
                            if ((localObject1 != null) && (localObject1 != TokenFilter.INCLUDE_ALL)) {
                              ((TokenFilter)localObject1).filterFinishArray();
                            }
                            _headContext = _headContext.getParent();
                            _itemFilter = _headContext.getFilter();
                            if (bool)
                            {
                              _currToken = ((JsonToken)localObject2);
                              return (JsonToken)localObject2;
                              localObject1 = delegate.getCurrentName();
                              localTokenFilter = _headContext.setFieldName((String)localObject1);
                              if (localTokenFilter == TokenFilter.INCLUDE_ALL)
                              {
                                _itemFilter = localTokenFilter;
                                localObject1 = localObject2;
                                if (!_includePath)
                                {
                                  localObject1 = localObject2;
                                  if (_includeImmediateParent)
                                  {
                                    localObject1 = localObject2;
                                    if (!_headContext.isStartHandled())
                                    {
                                      localObject1 = _headContext.nextTokenToRead();
                                      _exposedContext = _headContext;
                                    }
                                  }
                                }
                                _currToken = ((JsonToken)localObject1);
                                return (JsonToken)localObject1;
                              }
                              if (localTokenFilter == null)
                              {
                                delegate.nextToken();
                                delegate.skipChildren();
                              }
                              else
                              {
                                localObject1 = localTokenFilter.includeProperty((String)localObject1);
                                if (localObject1 != null) {
                                  break;
                                }
                                delegate.nextToken();
                                delegate.skipChildren();
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            _itemFilter = ((TokenFilter)localObject1);
            if ((localObject1 == TokenFilter.INCLUDE_ALL) && (_includePath))
            {
              _currToken = ((JsonToken)localObject2);
              return (JsonToken)localObject2;
            }
          } while (!_includePath);
          localObject1 = _nextTokenWithBuffering(_headContext);
        } while (localObject1 == null);
        _currToken = ((JsonToken)localObject1);
        return (JsonToken)localObject1;
      } while (localObject1 == null);
      localObject1 = _headContext.checkValue((TokenFilter)localObject1);
    } while ((localObject1 != TokenFilter.INCLUDE_ALL) && ((localObject1 == null) || (!((TokenFilter)localObject1).includeValue(delegate))));
    _currToken = ((JsonToken)localObject2);
    return (JsonToken)localObject2;
  }
  
  public JsonToken nextValue()
    throws IOException
  {
    JsonToken localJsonToken2 = nextToken();
    JsonToken localJsonToken1 = localJsonToken2;
    if (localJsonToken2 == JsonToken.FIELD_NAME) {
      localJsonToken1 = nextToken();
    }
    return localJsonToken1;
  }
  
  public void overrideCurrentName(String paramString)
  {
    throw new UnsupportedOperationException("Can not currently override name during filtering read");
  }
  
  public int readBinaryValue(Base64Variant paramBase64Variant, OutputStream paramOutputStream)
    throws IOException
  {
    return delegate.readBinaryValue(paramBase64Variant, paramOutputStream);
  }
  
  public JsonParser skipChildren()
    throws IOException
  {
    if ((_currToken != JsonToken.START_OBJECT) && (_currToken != JsonToken.START_ARRAY)) {
      return this;
    }
    int i = 1;
    label47:
    int j;
    do
    {
      JsonToken localJsonToken;
      do
      {
        for (;;)
        {
          localJsonToken = nextToken();
          if (localJsonToken == null) {
            break;
          }
          if (!localJsonToken.isStructStart()) {
            break label47;
          }
          i += 1;
        }
      } while (!localJsonToken.isStructEnd());
      j = i - 1;
      i = j;
    } while (j != 0);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.filter.FilteringParserDelegate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */