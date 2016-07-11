package com.upsight.android.marketing.internal.content;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.otto.Bus;
import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.internal.action.ActionContext;
import com.upsight.android.analytics.internal.session.Clock;
import com.upsight.android.logger.UpsightLogger;
import rx.Scheduler.Worker;

public class MarketingContentActions$MarketingContentActionContext
  extends ActionContext
{
  public final MarketingContentStore mContentStore;
  public final ContentTemplateWebViewClientFactory mContentTemplateWebViewClientFactory;
  
  public MarketingContentActions$MarketingContentActionContext(UpsightContext paramUpsightContext, Bus paramBus, ObjectMapper paramObjectMapper, Clock paramClock, Scheduler.Worker paramWorker, UpsightLogger paramUpsightLogger, MarketingContentStore paramMarketingContentStore, ContentTemplateWebViewClientFactory paramContentTemplateWebViewClientFactory)
  {
    super(paramUpsightContext, paramBus, paramObjectMapper, paramClock, paramWorker, paramUpsightLogger);
    mContentStore = paramMarketingContentStore;
    mContentTemplateWebViewClientFactory = paramContentTemplateWebViewClientFactory;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.MarketingContentActions.MarketingContentActionContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */