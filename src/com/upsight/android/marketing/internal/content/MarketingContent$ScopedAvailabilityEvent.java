package com.upsight.android.marketing.internal.content;

import java.util.Arrays;
import java.util.List;

public class MarketingContent$ScopedAvailabilityEvent
  extends MarketingContent.AvailabilityEvent
{
  private final String[] mScopes;
  
  public MarketingContent$ScopedAvailabilityEvent(String paramString, String[] paramArrayOfString)
  {
    super(paramString, null);
    mScopes = paramArrayOfString;
  }
  
  public List<String> getScopes()
  {
    return Arrays.asList(mScopes);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.MarketingContent.ScopedAvailabilityEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */