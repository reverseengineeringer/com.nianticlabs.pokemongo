package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.io.CharTypes;

public final class JsonReadContext
  extends JsonStreamContext
{
  protected JsonReadContext _child = null;
  protected int _columnNr;
  protected String _currentName;
  protected Object _currentValue;
  protected DupDetector _dups;
  protected int _lineNr;
  protected final JsonReadContext _parent;
  
  public JsonReadContext(JsonReadContext paramJsonReadContext, DupDetector paramDupDetector, int paramInt1, int paramInt2, int paramInt3)
  {
    _parent = paramJsonReadContext;
    _dups = paramDupDetector;
    _type = paramInt1;
    _lineNr = paramInt2;
    _columnNr = paramInt3;
    _index = -1;
  }
  
  private void _checkDup(DupDetector paramDupDetector, String paramString)
    throws JsonProcessingException
  {
    if (paramDupDetector.isDup(paramString)) {
      throw new JsonParseException("Duplicate field '" + paramString + "'", paramDupDetector.findLocation());
    }
  }
  
  @Deprecated
  public static JsonReadContext createRootContext()
  {
    return createRootContext(null);
  }
  
  @Deprecated
  public static JsonReadContext createRootContext(int paramInt1, int paramInt2)
  {
    return createRootContext(paramInt1, paramInt2, null);
  }
  
  public static JsonReadContext createRootContext(int paramInt1, int paramInt2, DupDetector paramDupDetector)
  {
    return new JsonReadContext(null, paramDupDetector, 0, paramInt1, paramInt2);
  }
  
  public static JsonReadContext createRootContext(DupDetector paramDupDetector)
  {
    return new JsonReadContext(null, paramDupDetector, 0, 1, 0);
  }
  
  public JsonReadContext createChildArrayContext(int paramInt1, int paramInt2)
  {
    Object localObject = _child;
    if (localObject == null)
    {
      if (_dups == null) {}
      for (localObject = null;; localObject = _dups.child())
      {
        localObject = new JsonReadContext(this, (DupDetector)localObject, 1, paramInt1, paramInt2);
        _child = ((JsonReadContext)localObject);
        return (JsonReadContext)localObject;
      }
    }
    ((JsonReadContext)localObject).reset(1, paramInt1, paramInt2);
    return (JsonReadContext)localObject;
  }
  
  public JsonReadContext createChildObjectContext(int paramInt1, int paramInt2)
  {
    Object localObject = _child;
    if (localObject == null)
    {
      if (_dups == null) {}
      for (localObject = null;; localObject = _dups.child())
      {
        localObject = new JsonReadContext(this, (DupDetector)localObject, 2, paramInt1, paramInt2);
        _child = ((JsonReadContext)localObject);
        return (JsonReadContext)localObject;
      }
    }
    ((JsonReadContext)localObject).reset(2, paramInt1, paramInt2);
    return (JsonReadContext)localObject;
  }
  
  public boolean expectComma()
  {
    int i = _index + 1;
    _index = i;
    return (_type != 0) && (i > 0);
  }
  
  public String getCurrentName()
  {
    return _currentName;
  }
  
  public Object getCurrentValue()
  {
    return _currentValue;
  }
  
  public DupDetector getDupDetector()
  {
    return _dups;
  }
  
  public JsonReadContext getParent()
  {
    return _parent;
  }
  
  public JsonLocation getStartLocation(Object paramObject)
  {
    return new JsonLocation(paramObject, -1L, _lineNr, _columnNr);
  }
  
  protected void reset(int paramInt1, int paramInt2, int paramInt3)
  {
    _type = paramInt1;
    _index = -1;
    _lineNr = paramInt2;
    _columnNr = paramInt3;
    _currentName = null;
    _currentValue = null;
    if (_dups != null) {
      _dups.reset();
    }
  }
  
  public void setCurrentName(String paramString)
    throws JsonProcessingException
  {
    _currentName = paramString;
    if (_dups != null) {
      _checkDup(_dups, paramString);
    }
  }
  
  public void setCurrentValue(Object paramObject)
  {
    _currentValue = paramObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    switch (_type)
    {
    default: 
    case 0: 
    case 1: 
      for (;;)
      {
        return localStringBuilder.toString();
        localStringBuilder.append("/");
        continue;
        localStringBuilder.append('[');
        localStringBuilder.append(getCurrentIndex());
        localStringBuilder.append(']');
      }
    }
    localStringBuilder.append('{');
    if (_currentName != null)
    {
      localStringBuilder.append('"');
      CharTypes.appendQuoted(localStringBuilder, _currentName);
      localStringBuilder.append('"');
    }
    for (;;)
    {
      localStringBuilder.append('}');
      break;
      localStringBuilder.append('?');
    }
  }
  
  public JsonReadContext withDupDetector(DupDetector paramDupDetector)
  {
    _dups = paramDupDetector;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.json.JsonReadContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */