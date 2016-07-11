package com.upsight.android.marketing.internal.content;

import com.fasterxml.jackson.databind.JsonNode;
import com.upsight.android.UpsightException;
import com.upsight.android.analytics.internal.action.Action;
import com.upsight.android.analytics.internal.action.ActionFactory;
import java.util.Map;

public class MarketingContentActions$MarketingContentActionFactory
  implements ActionFactory<MarketingContent, MarketingContentActions.MarketingContentActionContext>
{
  public static final String TYPE = "marketing_content_factory";
  
  public Action<MarketingContent, MarketingContentActions.MarketingContentActionContext> create(MarketingContentActions.MarketingContentActionContext paramMarketingContentActionContext, JsonNode paramJsonNode)
    throws UpsightException
  {
    if (paramJsonNode == null) {
      throw new UpsightException("Failed to create Action. JSON is null.", new Object[0]);
    }
    String str = paramJsonNode.get("action_type").asText();
    paramJsonNode = paramJsonNode.get("parameters");
    MarketingContentActions.InternalFactory localInternalFactory = (MarketingContentActions.InternalFactory)MarketingContentActions.access$1300().get(str);
    if (localInternalFactory == null) {
      throw new UpsightException("Failed to create Action. Unknown action type.", new Object[0]);
    }
    return localInternalFactory.create(paramMarketingContentActionContext, str, paramJsonNode);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.MarketingContentActions.MarketingContentActionFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */