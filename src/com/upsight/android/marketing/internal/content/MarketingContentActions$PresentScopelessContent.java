package com.upsight.android.marketing.internal.content;

import android.text.TextUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.upsight.android.analytics.internal.action.Action;

class MarketingContentActions$PresentScopelessContent
  extends Action<MarketingContent, MarketingContentActions.MarketingContentActionContext>
{
  public static final String NEXT_ID = "next_id";
  public static final String SELF_ID = "self_id";
  
  private MarketingContentActions$PresentScopelessContent(MarketingContentActions.MarketingContentActionContext paramMarketingContentActionContext, String paramString, JsonNode paramJsonNode)
  {
    super(paramMarketingContentActionContext, paramString, paramJsonNode);
  }
  
  public void execute(MarketingContent paramMarketingContent)
  {
    String str1 = optParamString("self_id");
    String str2 = optParamString("next_id");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
      getActionContextmContentStore.presentScopelessContent(str2, str1);
    }
    paramMarketingContent.signalActionCompleted(getActionContextmBus);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.MarketingContentActions.PresentScopelessContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */