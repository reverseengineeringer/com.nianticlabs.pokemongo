package com.upsight.android.marketing.internal.content;

import android.text.TextUtils;
import com.upsight.android.analytics.internal.action.ActionMap;
import com.upsight.android.analytics.internal.action.ActionMapResponse;

public final class MarketingContentFactory
{
  private static final MarketingContentActions.MarketingContentActionFactory sMarketingContentActionFactory = new MarketingContentActions.MarketingContentActionFactory();
  private MarketingContentActions.MarketingContentActionContext mActionContext;
  
  public MarketingContentFactory(MarketingContentActions.MarketingContentActionContext paramMarketingContentActionContext)
  {
    mActionContext = paramMarketingContentActionContext;
  }
  
  public MarketingContent create(ActionMapResponse paramActionMapResponse)
  {
    Object localObject2 = null;
    String str = paramActionMapResponse.getActionMapId();
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(str))
    {
      localObject1 = localObject2;
      if ("marketing_content_factory".equals(paramActionMapResponse.getActionFactory())) {
        localObject1 = MarketingContent.create(str, new ActionMap(sMarketingContentActionFactory, mActionContext, paramActionMapResponse.getActionMap()));
      }
    }
    return (MarketingContent)localObject1;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.MarketingContentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */