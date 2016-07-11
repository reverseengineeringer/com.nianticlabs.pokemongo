package com.upsight.android.marketing.internal.content;

import android.view.View;
import android.view.View.OnClickListener;

class MarketingContentActions$TriggerIfContentBuilt$1
  implements View.OnClickListener
{
  MarketingContentActions$TriggerIfContentBuilt$1(MarketingContentActions.TriggerIfContentBuilt paramTriggerIfContentBuilt, MarketingContent paramMarketingContent) {}
  
  public void onClick(View paramView)
  {
    val$content.executeActions("content_dismissed");
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.MarketingContentActions.TriggerIfContentBuilt.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */