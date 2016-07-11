package com.fasterxml.jackson.databind.jsonFormatVisitors;

import com.fasterxml.jackson.core.JsonParser.NumberType;

public abstract interface JsonNumberFormatVisitor
  extends JsonValueFormatVisitor
{
  public abstract void numberType(JsonParser.NumberType paramNumberType);
  
  public static class Base
    extends JsonValueFormatVisitor.Base
    implements JsonNumberFormatVisitor
  {
    public void numberType(JsonParser.NumberType paramNumberType) {}
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.jsonFormatVisitors.JsonNumberFormatVisitor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */