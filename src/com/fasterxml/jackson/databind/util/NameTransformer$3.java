package com.fasterxml.jackson.databind.util;

final class NameTransformer$3
  extends NameTransformer
{
  NameTransformer$3(String paramString) {}
  
  public String reverse(String paramString)
  {
    if (paramString.endsWith(val$suffix)) {
      return paramString.substring(0, paramString.length() - val$suffix.length());
    }
    return null;
  }
  
  public String toString()
  {
    return "[SuffixTransformer('" + val$suffix + "')]";
  }
  
  public String transform(String paramString)
  {
    return paramString + val$suffix;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.util.NameTransformer.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */