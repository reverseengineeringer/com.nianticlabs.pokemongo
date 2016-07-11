package com.upsight.android.marketing.internal.content;

import android.text.TextUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.squareup.otto.Bus;
import com.upsight.android.analytics.internal.action.Action;

class MarketingContentActions$Destroy
  extends Action<MarketingContent, MarketingContentActions.MarketingContentActionContext>
{
  private MarketingContentActions$Destroy(MarketingContentActions.MarketingContentActionContext paramMarketingContentActionContext, String paramString, JsonNode paramJsonNode)
  {
    super(paramMarketingContentActionContext, paramString, paramJsonNode);
  }
  
  public void execute(MarketingContent paramMarketingContent)
  {
    Object localObject = paramMarketingContent.getId();
    MarketingContentActions.MarketingContentActionContext localMarketingContentActionContext = (MarketingContentActions.MarketingContentActionContext)getActionContext();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      mContentStore.remove((String)localObject);
      mBus.post(new MarketingContentActions.DestroyEvent((String)localObject, null));
    }
    localObject = mBus;
    paramMarketingContent.signalActionCompleted((Bus)localObject);
    paramMarketingContent.signalActionMapCompleted((Bus)localObject);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.MarketingContentActions.Destroy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */