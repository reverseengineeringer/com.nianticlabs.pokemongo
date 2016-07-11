package com.upsight.android.analytics.internal.dispatcher.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ByFilterSelector<D>
  implements Selector<D>
{
  private Map<String, D> mData;
  private D mDefaultValue = null;
  private Set<Filter> mFilters;
  
  public ByFilterSelector(Map<String, D> paramMap)
  {
    mData = paramMap;
    mFilters = new HashSet();
    paramMap = mData.keySet().iterator();
    while (paramMap.hasNext())
    {
      String str = (String)paramMap.next();
      mFilters.add(new Filter(str));
    }
  }
  
  public ByFilterSelector(Map<String, D> paramMap, D paramD)
  {
    this(paramMap);
  }
  
  private String getFilterFor(String paramString)
  {
    Filter localFilter = null;
    Iterator localIterator = mFilters.iterator();
    while (localIterator.hasNext()) {
      localFilter = ((Filter)localIterator.next()).getFilterIfBetter(paramString, localFilter);
    }
    if (localFilter == null) {
      return null;
    }
    return localFilter.getFilter();
  }
  
  public D select(String paramString)
  {
    paramString = getFilterFor(paramString);
    if (paramString == null) {
      return (D)mDefaultValue;
    }
    return (D)mData.get(paramString);
  }
  
  static class Filter
  {
    private static final String SEPARATOR = ".";
    private final String mFilter;
    private final boolean mIsWildcard;
    private final String mMatcher;
    
    public Filter(String paramString)
    {
      mFilter = paramString;
      mIsWildcard = paramString.endsWith("*");
      mMatcher = paramString.replaceAll("\\*", "");
    }
    
    public String getFilter()
    {
      return mFilter;
    }
    
    public Filter getFilterIfBetter(String paramString, Filter paramFilter)
    {
      if (!mMatcher.equals(paramString))
      {
        localFilter = paramFilter;
        if (!paramString.startsWith(mMatcher)) {
          return localFilter;
        }
        if ((!mMatcher.endsWith(".")) && (!mIsWildcard))
        {
          localFilter = paramFilter;
          if (!mMatcher.isEmpty()) {
            return localFilter;
          }
        }
        if (paramFilter != null)
        {
          localFilter = paramFilter;
          if (paramFilter.getMatcher().length() >= mMatcher.length()) {
            return localFilter;
          }
        }
      }
      Filter localFilter = this;
      return localFilter;
    }
    
    public String getMatcher()
    {
      return mMatcher;
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.util.ByFilterSelector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */