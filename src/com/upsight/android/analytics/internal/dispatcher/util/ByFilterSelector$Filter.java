package com.upsight.android.analytics.internal.dispatcher.util;

class ByFilterSelector$Filter
{
  private static final String SEPARATOR = ".";
  private final String mFilter;
  private final boolean mIsWildcard;
  private final String mMatcher;
  
  public ByFilterSelector$Filter(String paramString)
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

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.util.ByFilterSelector.Filter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */