package com.upsight.android.marketing.internal.content;

import android.text.TextUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.upsight.android.analytics.internal.action.Action;

class MarketingContentActions$Trigger
  extends Action<MarketingContent, MarketingContentActions.MarketingContentActionContext>
{
  public static final String TRIGGER = "trigger";
  
  private MarketingContentActions$Trigger(MarketingContentActions.MarketingContentActionContext paramMarketingContentActionContext, String paramString, JsonNode paramJsonNode)
  {
    super(paramMarketingContentActionContext, paramString, paramJsonNode);
  }
  
  public void execute(MarketingContent paramMarketingContent)
  {
    String str = optParamString("trigger");
    if (!TextUtils.isEmpty(str)) {
      paramMarketingContent.executeActions(str);
    }
    paramMarketingContent.signalActionCompleted(getActionContextmBus);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.MarketingContentActions.Trigger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */