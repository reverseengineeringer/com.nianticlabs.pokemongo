package com.fasterxml.jackson.databind.jsonFormatVisitors;

public abstract interface JsonStringFormatVisitor
  extends JsonValueFormatVisitor
{
  public static class Base
    extends JsonValueFormatVisitor.Base
    implements JsonStringFormatVisitor
  {}
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.jsonFormatVisitors.JsonStringFormatVisitor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */