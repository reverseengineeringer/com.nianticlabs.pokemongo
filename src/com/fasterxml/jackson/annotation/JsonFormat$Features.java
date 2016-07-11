package com.fasterxml.jackson.annotation;

public class JsonFormat$Features
{
  private static final Features EMPTY = new Features(0, 0);
  private final int disabled;
  private final int enabled;
  
  private JsonFormat$Features(int paramInt1, int paramInt2)
  {
    enabled = paramInt1;
    disabled = paramInt2;
  }
  
  public static Features construct(JsonFormat paramJsonFormat)
  {
    return construct(paramJsonFormat.with(), paramJsonFormat.without());
  }
  
  public static Features construct(JsonFormat.Feature[] paramArrayOfFeature1, JsonFormat.Feature[] paramArrayOfFeature2)
  {
    int i = 0;
    int k = paramArrayOfFeature1.length;
    int j = 0;
    while (j < k)
    {
      i |= 1 << paramArrayOfFeature1[j].ordinal();
      j += 1;
    }
    k = 0;
    int m = paramArrayOfFeature2.length;
    j = 0;
    while (j < m)
    {
      k |= 1 << paramArrayOfFeature2[j].ordinal();
      j += 1;
    }
    return new Features(i, k);
  }
  
  public static Features empty()
  {
    return EMPTY;
  }
  
  public Boolean get(JsonFormat.Feature paramFeature)
  {
    int i = 1 << paramFeature.ordinal();
    if ((disabled & i) != 0) {
      return Boolean.FALSE;
    }
    if ((enabled & i) != 0) {
      return Boolean.TRUE;
    }
    return null;
  }
  
  public Features with(JsonFormat.Feature... paramVarArgs)
  {
    int j = enabled;
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      j |= 1 << paramVarArgs[i].ordinal();
      i += 1;
    }
    if (j == enabled) {
      return this;
    }
    return new Features(j, disabled);
  }
  
  public Features without(JsonFormat.Feature... paramVarArgs)
  {
    int j = disabled;
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      j |= 1 << paramVarArgs[i].ordinal();
      i += 1;
    }
    if (j == disabled) {
      return this;
    }
    return new Features(enabled, j);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.annotation.JsonFormat.Features
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */