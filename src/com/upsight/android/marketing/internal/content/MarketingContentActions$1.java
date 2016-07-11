package com.upsight.android.marketing.internal.content;

import com.fasterxml.jackson.databind.JsonNode;
import com.upsight.android.analytics.internal.action.Action;
import java.util.HashMap;

final class MarketingContentActions$1
  extends HashMap<String, MarketingContentActions.InternalFactory>
{
  MarketingContentActions$1()
  {
    put("action_trigger", new MarketingContentActions.InternalFactory()
    {
      public Action<MarketingContent, MarketingContentActions.MarketingContentActionContext> create(MarketingContentActions.MarketingContentActionContext paramAnonymousMarketingContentActionContext, String paramAnonymousString, JsonNode paramAnonymousJsonNode)
      {
        return new MarketingContentActions.Trigger(paramAnonymousMarketingContentActionContext, paramAnonymousString, paramAnonymousJsonNode, null);
      }
    });
    put("action_trigger_if_content_built", new MarketingContentActions.InternalFactory()
    {
      public Action<MarketingContent, MarketingContentActions.MarketingContentActionContext> create(MarketingContentActions.MarketingContentActionContext paramAnonymousMarketingContentActionContext, String paramAnonymousString, JsonNode paramAnonymousJsonNode)
      {
        return new MarketingContentActions.TriggerIfContentBuilt(paramAnonymousMarketingContentActionContext, paramAnonymousString, paramAnonymousJsonNode, null);
      }
    });
    put("action_trigger_if_content_available", new MarketingContentActions.InternalFactory()
    {
      public Action<MarketingContent, MarketingContentActions.MarketingContentActionContext> create(MarketingContentActions.MarketingContentActionContext paramAnonymousMarketingContentActionContext, String paramAnonymousString, JsonNode paramAnonymousJsonNode)
      {
        return new MarketingContentActions.TriggerIfContentAvailable(paramAnonymousMarketingContentActionContext, paramAnonymousString, paramAnonymousJsonNode, null);
      }
    });
    put("action_present_scoped_content", new MarketingContentActions.InternalFactory()
    {
      public Action<MarketingContent, MarketingContentActions.MarketingContentActionContext> create(MarketingContentActions.MarketingContentActionContext paramAnonymousMarketingContentActionContext, String paramAnonymousString, JsonNode paramAnonymousJsonNode)
      {
        return new MarketingContentActions.PresentScopedContent(paramAnonymousMarketingContentActionContext, paramAnonymousString, paramAnonymousJsonNode, null);
      }
    });
    put("action_present_scopeless_content", new MarketingContentActions.InternalFactory()
    {
      public Action<MarketingContent, MarketingContentActions.MarketingContentActionContext> create(MarketingContentActions.MarketingContentActionContext paramAnonymousMarketingContentActionContext, String paramAnonymousString, JsonNode paramAnonymousJsonNode)
      {
        return new MarketingContentActions.PresentScopelessContent(paramAnonymousMarketingContentActionContext, paramAnonymousString, paramAnonymousJsonNode, null);
      }
    });
    put("action_present_close_button", new MarketingContentActions.InternalFactory()
    {
      public Action<MarketingContent, MarketingContentActions.MarketingContentActionContext> create(MarketingContentActions.MarketingContentActionContext paramAnonymousMarketingContentActionContext, String paramAnonymousString, JsonNode paramAnonymousJsonNode)
      {
        return new MarketingContentActions.PresentCloseButton(paramAnonymousMarketingContentActionContext, paramAnonymousString, paramAnonymousJsonNode, null);
      }
    });
    put("action_destroy", new MarketingContentActions.InternalFactory()
    {
      public Action<MarketingContent, MarketingContentActions.MarketingContentActionContext> create(MarketingContentActions.MarketingContentActionContext paramAnonymousMarketingContentActionContext, String paramAnonymousString, JsonNode paramAnonymousJsonNode)
      {
        return new MarketingContentActions.Destroy(paramAnonymousMarketingContentActionContext, paramAnonymousString, paramAnonymousJsonNode, null);
      }
    });
    put("action_open_url", new MarketingContentActions.InternalFactory()
    {
      public Action<MarketingContent, MarketingContentActions.MarketingContentActionContext> create(MarketingContentActions.MarketingContentActionContext paramAnonymousMarketingContentActionContext, String paramAnonymousString, JsonNode paramAnonymousJsonNode)
      {
        return new MarketingContentActions.OpenUrl(paramAnonymousMarketingContentActionContext, paramAnonymousString, paramAnonymousJsonNode, null);
      }
    });
    put("action_send_event", new MarketingContentActions.InternalFactory()
    {
      public Action<MarketingContent, MarketingContentActions.MarketingContentActionContext> create(MarketingContentActions.MarketingContentActionContext paramAnonymousMarketingContentActionContext, String paramAnonymousString, JsonNode paramAnonymousJsonNode)
      {
        return new MarketingContentActions.SendEvent(paramAnonymousMarketingContentActionContext, paramAnonymousString, paramAnonymousJsonNode, null);
      }
    });
    put("action_send_form_data", new MarketingContentActions.InternalFactory()
    {
      public Action<MarketingContent, MarketingContentActions.MarketingContentActionContext> create(MarketingContentActions.MarketingContentActionContext paramAnonymousMarketingContentActionContext, String paramAnonymousString, JsonNode paramAnonymousJsonNode)
      {
        return new MarketingContentActions.SendFormData(paramAnonymousMarketingContentActionContext, paramAnonymousString, paramAnonymousJsonNode, null);
      }
    });
    put("action_notify_rewards", new MarketingContentActions.InternalFactory()
    {
      public Action<MarketingContent, MarketingContentActions.MarketingContentActionContext> create(MarketingContentActions.MarketingContentActionContext paramAnonymousMarketingContentActionContext, String paramAnonymousString, JsonNode paramAnonymousJsonNode)
      {
        return new MarketingContentActions.NotifyRewards(paramAnonymousMarketingContentActionContext, paramAnonymousString, paramAnonymousJsonNode, null);
      }
    });
    put("action_notify_purchases", new MarketingContentActions.InternalFactory()
    {
      public Action<MarketingContent, MarketingContentActions.MarketingContentActionContext> create(MarketingContentActions.MarketingContentActionContext paramAnonymousMarketingContentActionContext, String paramAnonymousString, JsonNode paramAnonymousJsonNode)
      {
        return new MarketingContentActions.NotifyPurchases(paramAnonymousMarketingContentActionContext, paramAnonymousString, paramAnonymousJsonNode, null);
      }
    });
    put("action_associate_once", new MarketingContentActions.InternalFactory()
    {
      public Action<MarketingContent, MarketingContentActions.MarketingContentActionContext> create(MarketingContentActions.MarketingContentActionContext paramAnonymousMarketingContentActionContext, String paramAnonymousString, JsonNode paramAnonymousJsonNode)
      {
        return new MarketingContentActions.AssociateOnce(paramAnonymousMarketingContentActionContext, paramAnonymousString, paramAnonymousJsonNode, null);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.MarketingContentActions.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */