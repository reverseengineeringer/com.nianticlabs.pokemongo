package com.upsight.android.marketing.internal.content;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.upsight.android.marketing.UpsightContentMediator;

public final class DefaultContentMediator
  implements UpsightContentMediator
{
  public void displayContent(MarketingContent paramMarketingContent, ViewGroup paramViewGroup)
  {
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    paramViewGroup.addView(paramMarketingContent.getContentView(), localLayoutParams);
  }
  
  public String getContentProvider()
  {
    return "upsight";
  }
  
  public void hideContent(MarketingContent paramMarketingContent, ViewGroup paramViewGroup)
  {
    paramViewGroup.removeAllViews();
  }
  
  public boolean isAvailable()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.DefaultContentMediator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */