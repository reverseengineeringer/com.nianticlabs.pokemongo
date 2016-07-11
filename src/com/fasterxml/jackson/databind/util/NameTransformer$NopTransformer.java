package com.fasterxml.jackson.databind.util;

import java.io.Serializable;

public final class NameTransformer$NopTransformer
  extends NameTransformer
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  
  public String reverse(String paramString)
  {
    return paramString;
  }
  
  public String transform(String paramString)
  {
    return paramString;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.util.NameTransformer.NopTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */