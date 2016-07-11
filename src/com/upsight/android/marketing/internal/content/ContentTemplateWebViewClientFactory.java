package com.upsight.android.marketing.internal.content;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.otto.Bus;
import com.upsight.android.logger.UpsightLogger;

public class ContentTemplateWebViewClientFactory
{
  protected final Bus mBus;
  protected final UpsightLogger mLogger;
  protected final ObjectMapper mMapper;
  
  public ContentTemplateWebViewClientFactory(Bus paramBus, ObjectMapper paramObjectMapper, UpsightLogger paramUpsightLogger)
  {
    mBus = paramBus;
    mMapper = paramObjectMapper;
    mLogger = paramUpsightLogger;
  }
  
  public ContentTemplateWebViewClient create(MarketingContent paramMarketingContent)
  {
    return new ContentTemplateWebViewClient(paramMarketingContent, mBus, mMapper, mLogger);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.ContentTemplateWebViewClientFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */