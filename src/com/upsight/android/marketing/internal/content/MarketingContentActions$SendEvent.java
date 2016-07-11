package com.upsight.android.marketing.internal.content;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.upsight.android.analytics.event.UpsightDynamicEvent;
import com.upsight.android.analytics.event.UpsightDynamicEvent.Builder;
import com.upsight.android.analytics.internal.action.Action;
import com.upsight.android.logger.UpsightLogger;

class MarketingContentActions$SendEvent
  extends Action<MarketingContent, MarketingContentActions.MarketingContentActionContext>
{
  public static final String EVENT = "event";
  public static final String IDENTIFIERS = "identifiers";
  public static final String PUB_DATA = "pub_data";
  public static final String TYPE = "type";
  public static final String UPSIGHT_DATA = "upsight_data";
  
  private MarketingContentActions$SendEvent(MarketingContentActions.MarketingContentActionContext paramMarketingContentActionContext, String paramString, JsonNode paramJsonNode)
  {
    super(paramMarketingContentActionContext, paramString, paramJsonNode);
  }
  
  public void execute(MarketingContent paramMarketingContent)
  {
    MarketingContentActions.MarketingContentActionContext localMarketingContentActionContext = (MarketingContentActions.MarketingContentActionContext)getActionContext();
    ObjectNode localObjectNode = optParamJsonObject("event");
    Object localObject;
    if (localObjectNode != null)
    {
      localObject = localObjectNode.path("type");
      if (((JsonNode)localObject).isTextual())
      {
        localObject = UpsightDynamicEvent.createBuilder(((JsonNode)localObject).asText()).putUpsightData(localObjectNode.path("upsight_data"));
        if (!localObjectNode.path("pub_data").isMissingNode()) {
          ((UpsightDynamicEvent.Builder)localObject).putPublisherData(localObjectNode.path("pub_data"));
        }
        if (localObjectNode.path("identifiers").isTextual()) {
          ((UpsightDynamicEvent.Builder)localObject).setDynamicIdentifiers(localObjectNode.path("identifiers").asText());
        }
        ((UpsightDynamicEvent.Builder)localObject).record(mUpsight);
      }
    }
    for (;;)
    {
      paramMarketingContent.signalActionCompleted(mBus);
      return;
      mLogger.e(getClass().getSimpleName(), "Action failed actionType=" + getType() + " type=" + localObject, new Object[0]);
      continue;
      mLogger.e(getClass().getSimpleName(), "Action failed actionType=" + getType() + " event=" + localObjectNode, new Object[0]);
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.MarketingContentActions.SendEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */