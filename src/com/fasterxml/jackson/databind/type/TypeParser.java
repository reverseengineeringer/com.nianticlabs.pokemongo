package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TypeParser
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final TypeFactory _factory;
  
  public TypeParser(TypeFactory paramTypeFactory)
  {
    _factory = paramTypeFactory;
  }
  
  protected IllegalArgumentException _problem(MyTokenizer paramMyTokenizer, String paramString)
  {
    return new IllegalArgumentException("Failed to parse type '" + paramMyTokenizer.getAllInput() + "' (remaining: '" + paramMyTokenizer.getRemainingInput() + "'): " + paramString);
  }
  
  protected Class<?> findClass(String paramString, MyTokenizer paramMyTokenizer)
  {
    try
    {
      Class localClass = _factory.findClass(paramString);
      return localClass;
    }
    catch (Exception localException)
    {
      if ((localException instanceof RuntimeException)) {
        throw ((RuntimeException)localException);
      }
      throw _problem(paramMyTokenizer, "Can not locate class '" + paramString + "', problem: " + localException.getMessage());
    }
  }
  
  public JavaType parse(String paramString)
    throws IllegalArgumentException
  {
    paramString = new MyTokenizer(paramString.trim());
    JavaType localJavaType = parseType(paramString);
    if (paramString.hasMoreTokens()) {
      throw _problem(paramString, "Unexpected tokens after complete type");
    }
    return localJavaType;
  }
  
  protected JavaType parseType(MyTokenizer paramMyTokenizer)
    throws IllegalArgumentException
  {
    if (!paramMyTokenizer.hasMoreTokens()) {
      throw _problem(paramMyTokenizer, "Unexpected end-of-string");
    }
    Class localClass = findClass(paramMyTokenizer.nextToken(), paramMyTokenizer);
    if (paramMyTokenizer.hasMoreTokens())
    {
      String str = paramMyTokenizer.nextToken();
      if ("<".equals(str)) {
        return _factory._fromParameterizedClass(localClass, parseTypes(paramMyTokenizer));
      }
      paramMyTokenizer.pushBack(str);
    }
    return _factory._fromClass(localClass, null);
  }
  
  protected List<JavaType> parseTypes(MyTokenizer paramMyTokenizer)
    throws IllegalArgumentException
  {
    ArrayList localArrayList = new ArrayList();
    String str;
    do
    {
      if (paramMyTokenizer.hasMoreTokens())
      {
        localArrayList.add(parseType(paramMyTokenizer));
        if (paramMyTokenizer.hasMoreTokens()) {}
      }
      else
      {
        throw _problem(paramMyTokenizer, "Unexpected end-of-string");
      }
      str = paramMyTokenizer.nextToken();
      if (">".equals(str)) {
        return localArrayList;
      }
    } while (",".equals(str));
    throw _problem(paramMyTokenizer, "Unexpected token '" + str + "', expected ',' or '>')");
  }
  
  public TypeParser withFactory(TypeFactory paramTypeFactory)
  {
    if (paramTypeFactory == _factory) {
      return this;
    }
    return new TypeParser(paramTypeFactory);
  }
  
  static final class MyTokenizer
    extends StringTokenizer
  {
    protected int _index;
    protected final String _input;
    protected String _pushbackToken;
    
    public MyTokenizer(String paramString)
    {
      super("<,>", true);
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
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.type.TypeParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */