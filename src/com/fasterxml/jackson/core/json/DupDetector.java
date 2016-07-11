package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import java.util.HashSet;

public class DupDetector
{
  protected String _firstName;
  protected String _secondName;
  protected HashSet<String> _seen;
  protected final Object _source;
  
  private DupDetector(Object paramObject)
  {
    _source = paramObject;
  }
  
  public static DupDetector rootDetector(JsonGenerator paramJsonGenerator)
  {
    return new DupDetector(paramJsonGenerator);
  }
  
  public static DupDetector rootDetector(JsonParser paramJsonParser)
  {
    return new DupDetector(paramJsonParser);
  }
  
  public DupDetector child()
  {
    return new DupDetector(_source);
  }
  
  public JsonLocation findLocation()
  {
    if ((_source instanceof JsonParser)) {
      return ((JsonParser)_source).getCurrentLocation();
    }
    return null;
  }
  
  public boolean isDup(String paramString)
    throws JsonParseException
  {
    boolean bool2 = true;
    boolean bool1;
    if (_firstName == null)
    {
      _firstName = paramString;
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramString.equals(_firstName));
        if (_secondName == null)
        {
          _secondName = paramString;
          return false;
        }
        bool1 = bool2;
      } while (paramString.equals(_secondName));
      if (_seen == null)
      {
        _seen = new HashSet(16);
        _seen.add(_firstName);
        _seen.add(_secondName);
      }
      bool1 = bool2;
    } while (!_seen.add(paramString));
    return false;
  }
  
  public void reset()
  {
    _firstName = null;
    _secondName = null;
    _seen = null;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.json.DupDetector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */