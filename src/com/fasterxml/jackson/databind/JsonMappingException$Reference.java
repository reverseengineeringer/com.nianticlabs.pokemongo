package com.fasterxml.jackson.databind;

import java.io.Serializable;

public class JsonMappingException$Reference
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected String _fieldName;
  protected Object _from;
  protected int _index = -1;
  
  protected JsonMappingException$Reference() {}
  
  public JsonMappingException$Reference(Object paramObject)
  {
    _from = paramObject;
  }
  
  public JsonMappingException$Reference(Object paramObject, int paramInt)
  {
    _from = paramObject;
    _index = paramInt;
  }
  
  public JsonMappingException$Reference(Object paramObject, String paramString)
  {
    _from = paramObject;
    if (paramString == null) {
      throw new NullPointerException("Can not pass null fieldName");
    }
    _fieldName = paramString;
  }
  
  public String getFieldName()
  {
    return _fieldName;
  }
  
  public Object getFrom()
  {
    return _from;
  }
  
  public int getIndex()
  {
    return _index;
  }
  
  public void setFieldName(String paramString)
  {
    _fieldName = paramString;
  }
  
  public void setFrom(Object paramObject)
  {
    _from = paramObject;
  }
  
  public void setIndex(int paramInt)
  {
    _index = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Class localClass;
    if ((_from instanceof Class))
    {
      localClass = (Class)_from;
      Package localPackage = localClass.getPackage();
      if (localPackage != null)
      {
        localStringBuilder.append(localPackage.getName());
        localStringBuilder.append('.');
      }
      localStringBuilder.append(localClass.getSimpleName());
      localStringBuilder.append('[');
      if (_fieldName == null) {
        break label120;
      }
      localStringBuilder.append('"');
      localStringBuilder.append(_fieldName);
      localStringBuilder.append('"');
    }
    for (;;)
    {
      localStringBuilder.append(']');
      return localStringBuilder.toString();
      localClass = _from.getClass();
      break;
      label120:
      if (_index >= 0) {
        localStringBuilder.append(_index);
      } else {
        localStringBuilder.append('?');
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.JsonMappingException.Reference
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */