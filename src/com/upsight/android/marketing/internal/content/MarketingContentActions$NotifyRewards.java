package com.upsight.android.marketing.internal.content;

import com.fasterxml.jackson.databind.JsonNode;
import com.squareup.otto.Bus;
import com.upsight.android.analytics.internal.action.Action;
import com.upsight.android.analytics.internal.action.ActionContext;
import com.upsight.android.logger.UpsightLogger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MarketingContentActions$NotifyRewards
  extends Action<MarketingContent, MarketingContentActions.MarketingContentActionContext>
{
  public static final String REWARDS = "rewards";
  
  private MarketingContentActions$NotifyRewards(MarketingContentActions.MarketingContentActionContext paramMarketingContentActionContext, String paramString, JsonNode paramJsonNode)
  {
    super(paramMarketingContentActionContext, paramString, paramJsonNode);
  }
  
  public void execute(MarketingContent paramMarketingContent)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = optParamJsonArray("rewards");
    if ((localObject != null) && (((JsonNode)localObject).isArray()))
    {
      ActionContext localActionContext = getActionContext();
      Iterator localIterator = ((JsonNode)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = null;
        try
        {
          JsonNode localJsonNode = (JsonNode)localIterator.next();
          localObject = localJsonNode;
          localArrayList.add(Reward.from(localJsonNode, mMapper));
        }
        catch (IOException localIOException)
        {
          mLogger.e(getClass().getSimpleName(), localIOException, "Failed to parse Reward rewardJson=" + localObject, new Object[0]);
        }
      }
    }
    localObject = getActionContextmBus;
    ((Bus)localObject).post(new MarketingContentActions.RewardsEvent(paramMarketingContent.getId(), localArrayList, null));
    paramMarketingContent.signalActionCompleted((Bus)localObject);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.MarketingContentActions.NotifyRewards
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */