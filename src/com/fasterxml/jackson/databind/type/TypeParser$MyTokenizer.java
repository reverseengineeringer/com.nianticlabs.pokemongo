package com.fasterxml.jackson.databind.type;

import java.util.StringTokenizer;

final class TypeParser$MyTokenizer
  extends StringTokenizer
{
  protected int _index;
  protected final String _input;
  protected String _pushbackToken;
  
  public TypeParser$MyTokenizer(String paramString)
  {
    super(paramString, "<,>", true);
    _input = paramString;
  }
  
  public String getAllInput()
  {
    return _input;
  }
  
  public String getRemainingInput()
  {
    return _input.substring(_index);
  }
  
  public String getUsedInput()
  {
    return _input.substring(0, _index);
  }
  
  public boolean hasMoreTokens()
  {
    return (_pushbackToken != null) || (super.hasMoreTokens());
  }
  
  public String nextToken()
  {
    String str;
    if (_pushbackToken != null)
    {
      str = _pushbackToken;
      _pushbackToken = null;
    }
    for (;;)
    {
      _index += str.length();
      return str;
      str = super.nextToken();
    }
  }
  
  public void pushBack(String paramString)
  {
    _pushbackToken = paramString;
    _index -= paramString.length();
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.type.TypeParser.MyTokenizer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */