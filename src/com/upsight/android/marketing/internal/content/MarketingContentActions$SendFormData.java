package com.upsight.android.marketing.internal.content;

import com.fasterxml.jackson.databind.JsonNode;
import com.upsight.android.analytics.event.datacollection.UpsightDataCollectionEvent;
import com.upsight.android.analytics.event.datacollection.UpsightDataCollectionEvent.Builder;
import com.upsight.android.analytics.internal.action.Action;
import com.upsight.android.logger.UpsightLogger;

class MarketingContentActions$SendFormData
  extends Action<MarketingContent, MarketingContentActions.MarketingContentActionContext>
{
  public static final String DATA_KEY = "data_key";
  public static final String STREAM_ID = "stream_id";
  
  private MarketingContentActions$SendFormData(MarketingContentActions.MarketingContentActionContext paramMarketingContentActionContext, String paramString, JsonNode paramJsonNode)
  {
    super(paramMarketingContentActionContext, paramString, paramJsonNode);
  }
  
  public void execute(MarketingContent paramMarketingContent)
  {
    MarketingContentActions.MarketingContentActionContext localMarketingContentActionContext = (MarketingContentActions.MarketingContentActionContext)getActionContext();
    String str2 = optParamString("data_key");
    String str1 = optParamString("stream_id");
    if ((str2 != null) && (str1 != null))
    {
      str2 = paramMarketingContent.getExtra(str2);
      if (str2 != null) {
        UpsightDataCollectionEvent.createBuilder(str2, str1).record(mUpsight);
      }
    }
    for (;;)
    {
      paramMarketingContent.signalActionCompleted(mBus);
      return;
      mLogger.e(getClass().getSimpleName(), "Action failed actionType=" + getType() + " dataKey=" + str2, new Object[0]);
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.MarketingContentActions.SendFormData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */