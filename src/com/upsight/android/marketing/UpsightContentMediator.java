package com.upsight.android.marketing;

import android.view.ViewGroup;
import com.upsight.android.marketing.internal.content.MarketingContent;

public abstract interface UpsightContentMediator
{
  public abstract void displayContent(MarketingContent paramMarketingContent, ViewGroup paramViewGroup);
  
  public abstract String getContentProvider();
  
  public abstract void hideContent(MarketingContent paramMarketingContent, ViewGroup paramViewGroup);
  
  public abstract boolean isAvailable();
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.UpsightContentMediator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */