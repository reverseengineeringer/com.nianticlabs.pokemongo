package com.upsight.android.marketing.internal.content;

public class MarketingContent$ScopelessAvailabilityEvent
  extends MarketingContent.AvailabilityEvent
{
  private final String mParentId;
  
  public MarketingContent$ScopelessAvailabilityEvent(String paramString1, String paramString2)
  {
    super(paramString1, null);
    mParentId = paramString2;
  }
  
  public String getParentId()
  {
    return mParentId;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.MarketingContent.ScopelessAvailabilityEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */