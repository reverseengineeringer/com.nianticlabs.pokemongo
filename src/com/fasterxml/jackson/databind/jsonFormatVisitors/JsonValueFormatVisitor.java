package com.fasterxml.jackson.databind.jsonFormatVisitors;

import java.util.Set;

public abstract interface JsonValueFormatVisitor
{
  public abstract void enumTypes(Set<String> paramSet);
  
  public abstract void format(JsonValueFormat paramJsonValueFormat);
  
  public static class Base
    implements JsonValueFormatVisitor
  {
    public void enumTypes(Set<String> paramSet) {}
    
    public void format(JsonValueFormat paramJsonValueFormat) {}
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormatVisitor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */