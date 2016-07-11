package com.upsight.android.marketing.internal.content;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.internal.action.Action;
import com.upsight.android.analytics.internal.action.ActionContext;
import com.upsight.android.analytics.internal.association.Association;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.persistence.UpsightDataStore;

class MarketingContentActions$AssociateOnce
  extends Action<MarketingContent, MarketingContentActions.MarketingContentActionContext>
{
  public static final String UPSIGHT_DATA = "upsight_data";
  public static final String UPSIGHT_DATA_FILTER = "upsight_data_filter";
  public static final String WITH = "with";
  
  private MarketingContentActions$AssociateOnce(MarketingContentActions.MarketingContentActionContext paramMarketingContentActionContext, String paramString, JsonNode paramJsonNode)
  {
    super(paramMarketingContentActionContext, paramString, paramJsonNode);
  }
  
  public void execute(MarketingContent paramMarketingContent)
  {
    ActionContext localActionContext = getActionContext();
    String str = optParamString("with");
    ObjectNode localObjectNode1 = optParamJsonObject("upsight_data_filter");
    ObjectNode localObjectNode2 = optParamJsonObject("upsight_data");
    try
    {
      Association localAssociation = Association.from(str, localObjectNode1, localObjectNode2, mMapper, mClock);
      mUpsight.getDataStore().store(localAssociation);
      paramMarketingContent.signalActionCompleted(mBus);
      return;
    }
    catch (JsonProcessingException localJsonProcessingException)
    {
      for (;;)
      {
        mLogger.e(getClass().getSimpleName(), localJsonProcessingException, "Failed to parse Association with=" + str + " upsightDataFilter=" + localObjectNode1 + " upsightData" + localObjectNode2, new Object[0]);
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.MarketingContentActions.AssociateOnce
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */