package com.upsight.android.marketing.internal.content;

import com.fasterxml.jackson.databind.JsonNode;
import com.upsight.android.analytics.internal.action.Action;

abstract interface MarketingContentActions$InternalFactory
{
  public abstract Action<MarketingContent, MarketingContentActions.MarketingContentActionContext> create(MarketingContentActions.MarketingContentActionContext paramMarketingContentActionContext, String paramString, JsonNode paramJsonNode);
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.MarketingContentActions.InternalFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */