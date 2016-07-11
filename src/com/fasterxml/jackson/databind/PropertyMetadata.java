package com.fasterxml.jackson.databind;

import java.io.Serializable;

public class PropertyMetadata
  implements Serializable
{
  public static final PropertyMetadata STD_OPTIONAL = new PropertyMetadata(Boolean.FALSE, null, null, null);
  public static final PropertyMetadata STD_REQUIRED = new PropertyMetadata(Boolean.TRUE, null, null, null);
  public static final PropertyMetadata STD_REQUIRED_OR_OPTIONAL = new PropertyMetadata(null, null, null, null);
  private static final long serialVersionUID = -1L;
  protected final String _defaultValue;
  protected final String _description;
  protected final Integer _index;
  protected final Boolean _required;
  
  @Deprecated
  protected PropertyMetadata(Boolean paramBoolean, String paramString)
  {
    this(paramBoolean, paramString, null, null);
  }
  
  protected PropertyMetadata(Boolean paramBoolean, String paramString1, Integer paramInteger, String paramString2)
  {
    _required = paramBoolean;
    _description = paramString1;
    _index = paramInteger;
    if (paramString2 != null)
    {
      paramBoolean = paramString2;
      if (!paramString2.isEmpty()) {}
    }
    else
    {
      paramBoolean = null;
    }
    _defaultValue = paramBoolean;
  }
  
  @Deprecated
  public static PropertyMetadata construct(boolean paramBoolean, String paramString)
  {
    return construct(paramBoolean, paramString, null, null);
  }
  
  public static PropertyMetadata construct(boolean paramBoolean, String paramString1, Integer paramInteger, String paramString2)
  {
    if ((paramString1 != null) || (paramInteger != null) || (paramString2 != null)) {
      return new PropertyMetadata(Boolean.valueOf(paramBoolean), paramString1, paramInteger, paramString2);
    }
    if (paramBoolean) {
      return STD_REQUIRED;
    }
    return STD_OPTIONAL;
  }
  
  public String getDefaultValue()
  {
    return _defaultValue;
  }
  
  public String getDescription()
  {
    return _description;
  }
  
  public Integer getIndex()
  {
    return _index;
  }
  
  public Boolean getRequired()
  {
    return _required;
  }
  
  public boolean hasDefaultValue()
  {
    return _defaultValue != null;
  }
  
  @Deprecated
  public boolean hasDefuaultValue()
  {
    return hasDefaultValue();
  }
  
  public boolean hasIndex()
  {
    return _index != null;
  }
  
  public boolean isRequired()
  {
    return (_required != null) && (_required.booleanValue());
  }
  
  protected Object readResolve()
  {
    if ((_description == null) && (_index == null) && (_defaultValue == null))
    {
      if (_required == null) {
        return STD_REQUIRED_OR_OPTIONAL;
      }
      if (_required.booleanValue()) {
        return STD_REQUIRED;
      }
      return STD_OPTIONAL;
    }
    return this;
  }
  
  public PropertyMetadata withDefaultValue(String paramString)
  {
    String str;
    if ((paramString == null) || (paramString.isEmpty()))
    {
      if (_defaultValue == null) {
        return this;
      }
      str = null;
    }
    do
    {
      return new PropertyMetadata(_required, _description, _index, str);
      str = paramString;
    } while (!_defaultValue.equals(paramString));
    return this;
  }
  
  public PropertyMetadata withDescription(String paramString)
  {
    return new PropertyMetadata(_required, paramString, _index, _defaultValue);
  }
  
  public PropertyMetadata withIndex(Integer paramInteger)
  {
    return new PropertyMetadata(_required, _description, paramInteger, _defaultValue);
  }
  
  public PropertyMetadata withRequired(Boolean paramBoolean)
  {
    if (paramBoolean == null)
    {
      if (_required != null) {}
    }
    else {
      while ((_required != null) && (_required.booleanValue() == paramBoolean.booleanValue())) {
        return this;
      }
    }
    return new PropertyMetadata(paramBoolean, _description, _index, _defaultValue);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.PropertyMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */