package com.upsight.android.marketing.internal.content;

import android.text.TextUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.upsight.android.analytics.internal.action.Action;
import com.upsight.android.logger.UpsightLogger;
import java.util.concurrent.TimeUnit;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;

class MarketingContentActions$TriggerIfContentAvailable
  extends Action<MarketingContent, MarketingContentActions.MarketingContentActionContext>
{
  public static final String CONDITION_PARAMETERS = "condition_parameters";
  public static final String ELSE_TRIGGER = "else_trigger";
  public static final String ID = "id";
  public static final String THEN_TRIGGER = "then_trigger";
  public static final String TIMEOUT_MS = "timeout_ms";
  private boolean isTriggerExecuted = false;
  private String mConditionalContentID;
  private MarketingContent mContent;
  private Subscription mSubscription;
  
  private MarketingContentActions$TriggerIfContentAvailable(MarketingContentActions.MarketingContentActionContext paramMarketingContentActionContext, String paramString, JsonNode paramJsonNode)
  {
    super(paramMarketingContentActionContext, paramString, paramJsonNode);
  }
  
  public void execute(final MarketingContent paramMarketingContent)
  {
    localObject1 = (MarketingContentActions.MarketingContentActionContext)getActionContext();
    mContent = paramMarketingContent;
    l1 = 0L;
    try
    {
      localObject2 = optParamJsonObject("condition_parameters");
      mConditionalContentID = ((JsonNode)localObject2).get("id").asText();
      long l2 = ((JsonNode)localObject2).get("timeout_ms").asLong();
      l1 = l2;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        Object localObject2;
        mLogger.e(getClass().getSimpleName(), localNullPointerException, "Action execution failed actionType=" + getType() + " invalid CONDITION_PARAMETERS", new Object[0]);
        continue;
        mBus.register(this);
        mSubscription = mMainWorker.schedule(new Action0()
        {
          public void call()
          {
            String str = optParamString("else_trigger");
            if ((!TextUtils.isEmpty(str)) && (!isTriggerExecuted))
            {
              paramMarketingContent.executeActions(str);
              MarketingContentActions.TriggerIfContentAvailable.access$1502(MarketingContentActions.TriggerIfContentAvailable.this, true);
            }
            localObject1mBus.unregister(this);
          }
        }, l1, TimeUnit.MILLISECONDS);
        continue;
        localObject1 = optParamString("else_trigger");
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!isTriggerExecuted))
        {
          paramMarketingContent.executeActions((String)localObject1);
          isTriggerExecuted = true;
        }
      }
    }
    if (mConditionalContentID != null)
    {
      localObject2 = (MarketingContent)mContentStore.get(mConditionalContentID);
      if ((localObject2 != null) && (((MarketingContent)localObject2).isLoaded()))
      {
        localObject1 = optParamString("then_trigger");
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!isTriggerExecuted))
        {
          paramMarketingContent.executeActions((String)localObject1);
          isTriggerExecuted = true;
        }
        paramMarketingContent.signalActionCompleted(getActionContextmBus);
        return;
      }
    }
  }
  
  @Subscribe
  public void handleAvailabilityEvent(MarketingContent.ContentLoadedEvent paramContentLoadedEvent)
  {
    if (paramContentLoadedEvent.getId().equals(mConditionalContentID))
    {
      mSubscription.unsubscribe();
      getActionContextmBus.unregister(this);
      paramContentLoadedEvent = optParamString("then_trigger");
      if ((!TextUtils.isEmpty(paramContentLoadedEvent)) && (!isTriggerExecuted))
      {
        mContent.executeActions(paramContentLoadedEvent);
        isTriggerExecuted = true;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.MarketingContentActions.TriggerIfContentAvailable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */