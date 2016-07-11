package com.fasterxml.jackson.databind.jsonFormatVisitors;

public abstract interface JsonBooleanFormatVisitor
  extends JsonValueFormatVisitor
{
  public static class Base
    extends JsonValueFormatVisitor.Base
    implements JsonBooleanFormatVisitor
  {}
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.jsonFormatVisitors.JsonBooleanFormatVisitor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */