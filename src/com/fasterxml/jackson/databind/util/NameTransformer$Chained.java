package com.fasterxml.jackson.databind.util;

import java.io.Serializable;

public class NameTransformer$Chained
  extends NameTransformer
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final NameTransformer _t1;
  protected final NameTransformer _t2;
  
  public NameTransformer$Chained(NameTransformer paramNameTransformer1, NameTransformer paramNameTransformer2)
  {
    _t1 = paramNameTransformer1;
    _t2 = paramNameTransformer2;
  }
  
  public String reverse(String paramString)
  {
    String str = _t1.reverse(paramString);
    paramString = str;
    if (str != null) {
      paramString = _t2.reverse(str);
    }
    return paramString;
  }
  
  public String toString()
  {
    return "[ChainedTransformer(" + _t1 + ", " + _t2 + ")]";
  }
  
  public String transform(String paramString)
  {
    return _t1.transform(_t2.transform(paramString));
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.util.NameTransformer.Chained
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */