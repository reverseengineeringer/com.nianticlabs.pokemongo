package com.upsight.android.analytics.internal.dispatcher.util;

import java.util.Map;

public class ByNameSelector<D>
  implements Selector<D>
{
  private Map<String, D> mData;
  private D mDefaultValue = null;
  
  public ByNameSelector(Map<String, D> paramMap)
  {
    mData = paramMap;
  }
  
  public ByNameSelector(Map<String, D> paramMap, D paramD)
  {
    this(paramMap);
  }
  
  public D select(String paramString)
  {
    paramString = mData.get(paramString);
    if (paramString != null) {
      return paramString;
    }
    return (D)mDefaultValue;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.util.ByNameSelector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */