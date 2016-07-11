package com.fasterxml.jackson.databind;

public class PropertyNamingStrategy$PascalCaseStrategy
  extends PropertyNamingStrategy.PropertyNamingStrategyBase
{
  public String translate(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    char c1;
    char c2;
    do
    {
      return paramString;
      c1 = paramString.charAt(0);
      c2 = Character.toUpperCase(c1);
    } while (c1 == c2);
    paramString = new StringBuilder(paramString);
    paramString.setCharAt(0, c2);
    return paramString.toString();
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.PropertyNamingStrategy.PascalCaseStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */