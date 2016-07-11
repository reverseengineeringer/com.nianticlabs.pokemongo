package com.upsight.android.marketing.internal.content;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.internal.action.Action;
import com.upsight.android.logger.UpsightLogger;

class MarketingContentActions$OpenUrl
  extends Action<MarketingContent, MarketingContentActions.MarketingContentActionContext>
{
  public static final String URL = "url";
  
  private MarketingContentActions$OpenUrl(MarketingContentActions.MarketingContentActionContext paramMarketingContentActionContext, String paramString, JsonNode paramJsonNode)
  {
    super(paramMarketingContentActionContext, paramString, paramJsonNode);
  }
  
  public void execute(MarketingContent paramMarketingContent)
  {
    MarketingContentActions.MarketingContentActionContext localMarketingContentActionContext = (MarketingContentActions.MarketingContentActionContext)getActionContext();
    Object localObject = optParamString("url");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject));
      ((Intent)localObject).setFlags(268435456);
    }
    for (;;)
    {
      try
      {
        mUpsight.startActivity((Intent)localObject);
        paramMarketingContent.signalActionCompleted(mBus);
        return;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        mLogger.e(getClass().getSimpleName(), localActivityNotFoundException, "Action execution failed actionType=" + getType() + " intent=" + localObject, new Object[0]);
        continue;
      }
      mLogger.e(getClass().getSimpleName(), "Action execution failed actionType=" + getType() + " uri=" + (String)localObject, new Object[0]);
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.MarketingContentActions.OpenUrl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */