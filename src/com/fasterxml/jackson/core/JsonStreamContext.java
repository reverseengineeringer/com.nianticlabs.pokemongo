package com.fasterxml.jackson.core;

public abstract class JsonStreamContext
{
  protected static final int TYPE_ARRAY = 1;
  protected static final int TYPE_OBJECT = 2;
  protected static final int TYPE_ROOT = 0;
  protected int _index;
  protected int _type;
  
  public final int getCurrentIndex()
  {
    if (_index < 0) {
      return 0;
    }
    return _index;
  }
  
  public abstract String getCurrentName();
  
  public Object getCurrentValue()
  {
    return null;
  }
  
  public final int getEntryCount()
  {
    return _index + 1;
  }
  
  public abstract JsonStreamContext getParent();
  
  public final String getTypeDesc()
  {
    switch (_type)
    {
    default: 
      return "?";
    case 0: 
      return "ROOT";
    case 1: 
      return "ARRAY";
    }
    return "OBJECT";
  }
  
  public final boolean inArray()
  {
    return _type == 1;
  }
  
  public final boolean inObject()
  {
    return _type == 2;
  }
  
  public final boolean inRoot()
  {
    return _type == 0;
  }
  
  public void setCurrentValue(Object paramObject) {}
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.JsonStreamContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */