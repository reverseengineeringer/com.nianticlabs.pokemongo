package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

public class TokenFilterContext
  extends JsonStreamContext
{
  protected TokenFilterContext _child = null;
  protected String _currentName;
  protected TokenFilter _filter;
  protected boolean _needToHandleName;
  protected final TokenFilterContext _parent;
  protected boolean _startHandled;
  
  protected TokenFilterContext(int paramInt, TokenFilterContext paramTokenFilterContext, TokenFilter paramTokenFilter, boolean paramBoolean)
  {
    _type = paramInt;
    _parent = paramTokenFilterContext;
    _filter = paramTokenFilter;
    _index = -1;
    _startHandled = paramBoolean;
    _needToHandleName = false;
  }
  
  private void _writePath(JsonGenerator paramJsonGenerator)
    throws IOException
  {
    if ((_filter == null) || (_filter == TokenFilter.INCLUDE_ALL)) {}
    do
    {
      do
      {
        do
        {
          return;
          if (_parent != null) {
            _parent._writePath(paramJsonGenerator);
          }
          if (!_startHandled) {
            break;
          }
        } while (!_needToHandleName);
        _needToHandleName = false;
        paramJsonGenerator.writeFieldName(_currentName);
        return;
        _startHandled = true;
        if (_type != 2) {
          break;
        }
        paramJsonGenerator.writeStartObject();
      } while (!_needToHandleName);
      _needToHandleName = false;
      paramJsonGenerator.writeFieldName(_currentName);
      return;
    } while (_type != 1);
    paramJsonGenerator.writeStartArray();
  }
  
  public static TokenFilterContext createRootContext(TokenFilter paramTokenFilter)
  {
    return new TokenFilterContext(0, null, paramTokenFilter, true);
  }
  
  protected void appendDesc(StringBuilder paramStringBuilder)
  {
    if (_parent != null) {
      _parent.appendDesc(paramStringBuilder);
    }
    if (_type == 2)
    {
      paramStringBuilder.append('{');
      if (_currentName != null)
      {
        paramStringBuilder.append('"');
        paramStringBuilder.append(_currentName);
        paramStringBuilder.append('"');
      }
      for (;;)
      {
        paramStringBuilder.append('}');
        return;
        paramStringBuilder.append('?');
      }
    }
    if (_type == 1)
    {
      paramStringBuilder.append('[');
      paramStringBuilder.append(getCurrentIndex());
      paramStringBuilder.append(']');
      return;
    }
    paramStringBuilder.append("/");
  }
  
  public TokenFilter checkValue(TokenFilter paramTokenFilter)
  {
    if (_type == 2) {
      return paramTokenFilter;
    }
    int i = _index + 1;
    _index = i;
    if (_type == 1) {
      return paramTokenFilter.includeElement(i);
    }
    return paramTokenFilter.includeRootValue(i);
  }
  
  public TokenFilterContext closeArray(JsonGenerator paramJsonGenerator)
    throws IOException
  {
    if (_startHandled) {
      paramJsonGenerator.writeEndArray();
    }
    if ((_filter != null) && (_filter != TokenFilter.INCLUDE_ALL)) {
      _filter.filterFinishArray();
    }
    return _parent;
  }
  
  public TokenFilterContext closeObject(JsonGenerator paramJsonGenerator)
    throws IOException
  {
    if (_startHandled) {
      paramJsonGenerator.writeEndObject();
    }
    if ((_filter != null) && (_filter != TokenFilter.INCLUDE_ALL)) {
      _filter.filterFinishObject();
    }
    return _parent;
  }
  
  public TokenFilterContext createChildArrayContext(TokenFilter paramTokenFilter, boolean paramBoolean)
  {
    TokenFilterContext localTokenFilterContext = _child;
    if (localTokenFilterContext == null)
    {
      paramTokenFilter = new TokenFilterContext(1, this, paramTokenFilter, paramBoolean);
      _child = paramTokenFilter;
      return paramTokenFilter;
    }
    return localTokenFilterContext.reset(1, paramTokenFilter, paramBoolean);
  }
  
  public TokenFilterContext createChildObjectContext(TokenFilter paramTokenFilter, boolean paramBoolean)
  {
    TokenFilterContext localTokenFilterContext = _child;
    if (localTokenFilterContext == null)
    {
      paramTokenFilter = new TokenFilterContext(2, this, paramTokenFilter, paramBoolean);
      _child = paramTokenFilter;
      return paramTokenFilter;
    }
    return localTokenFilterContext.reset(2, paramTokenFilter, paramBoolean);
  }
  
  public TokenFilterContext findChildOf(TokenFilterContext paramTokenFilterContext)
  {
    if (_parent == paramTokenFilterContext) {
      return this;
    }
    TokenFilterContext localTokenFilterContext;
    for (Object localObject = _parent; localObject != null; localObject = localTokenFilterContext)
    {
      localTokenFilterContext = _parent;
      if (localTokenFilterContext == paramTokenFilterContext) {
        return (TokenFilterContext)localObject;
      }
    }
    return null;
  }
  
  public final String getCurrentName()
  {
    return _currentName;
  }
  
  public Object getCurrentValue()
  {
    return null;
  }
  
  public TokenFilter getFilter()
  {
    return _filter;
  }
  
  public final TokenFilterContext getParent()
  {
    return _parent;
  }
  
  public boolean isStartHandled()
  {
    return _startHandled;
  }
  
  public JsonToken nextTokenToRead()
  {
    if (!_startHandled)
    {
      _startHandled = true;
      if (_type == 2) {
        return JsonToken.START_OBJECT;
      }
      return JsonToken.START_ARRAY;
    }
    if ((_needToHandleName) && (_type == 2))
    {
      _needToHandleName = false;
      return JsonToken.FIELD_NAME;
    }
    return null;
  }
  
  protected TokenFilterContext reset(int paramInt, TokenFilter paramTokenFilter, boolean paramBoolean)
  {
    _type = paramInt;
    _filter = paramTokenFilter;
    _index = -1;
    _currentName = null;
    _startHandled = paramBoolean;
    _needToHandleName = false;
    return this;
  }
  
  public void setCurrentValue(Object paramObject) {}
  
  public TokenFilter setFieldName(String paramString)
    throws JsonProcessingException
  {
    _currentName = paramString;
    _needToHandleName = true;
    return _filter;
  }
  
  public void skipParentChecks()
  {
    _filter = null;
    for (TokenFilterContext localTokenFilterContext = _parent; localTokenFilterContext != null; localTokenFilterContext = _parent) {
      _parent._filter = null;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    appendDesc(localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public void writeImmediatePath(JsonGenerator paramJsonGenerator)
    throws IOException
  {
    if ((_filter == null) || (_filter == TokenFilter.INCLUDE_ALL)) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!_startHandled) {
            break;
          }
        } while (!_needToHandleName);
        paramJsonGenerator.writeFieldName(_currentName);
        return;
        _startHandled = true;
        if (_type != 2) {
          break;
        }
        paramJsonGenerator.writeStartObject();
      } while (!_needToHandleName);
      paramJsonGenerator.writeFieldName(_currentName);
      return;
    } while (_type != 1);
    paramJsonGenerator.writeStartArray();
  }
  
  public void writePath(JsonGenerator paramJsonGenerator)
    throws IOException
  {
    if ((_filter == null) || (_filter == TokenFilter.INCLUDE_ALL)) {}
    do
    {
      do
      {
        return;
        if (_parent != null) {
          _parent._writePath(paramJsonGenerator);
        }
        if (!_startHandled) {
          break;
        }
      } while (!_needToHandleName);
      paramJsonGenerator.writeFieldName(_currentName);
      return;
      _startHandled = true;
      if (_type == 2)
      {
        paramJsonGenerator.writeStartObject();
        paramJsonGenerator.writeFieldName(_currentName);
        return;
      }
    } while (_type != 1);
    paramJsonGenerator.writeStartArray();
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.filter.TokenFilterContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */