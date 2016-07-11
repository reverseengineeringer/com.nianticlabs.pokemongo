package com.upsight.android.marketing.internal.content;

import android.text.TextUtils;
import com.squareup.otto.Bus;
import rx.functions.Action0;

class MarketingContentActions$TriggerIfContentAvailable$1
  implements Action0
{
  MarketingContentActions$TriggerIfContentAvailable$1(MarketingContentActions.TriggerIfContentAvailable paramTriggerIfContentAvailable, MarketingContent paramMarketingContent, MarketingContentActions.MarketingContentActionContext paramMarketingContentActionContext) {}
  
  public void call()
  {
    String str = MarketingContentActions.TriggerIfContentAvailable.access$1400(this$0, "else_trigger");
    if ((!TextUtils.isEmpty(str)) && (!MarketingContentActions.TriggerIfContentAvailable.access$1500(this$0)))
    {
      val$content.executeActions(str);
      MarketingContentActions.TriggerIfContentAvailable.access$1502(this$0, true);
    }
    val$actionContext.mBus.unregister(this);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.MarketingContentActions.TriggerIfContentAvailable.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */