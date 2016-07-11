package com.upsight.android.marketing.internal.content;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightException;
import com.upsight.android.analytics.event.UpsightDynamicEvent;
import com.upsight.android.analytics.event.UpsightDynamicEvent.Builder;
import com.upsight.android.analytics.event.datacollection.UpsightDataCollectionEvent;
import com.upsight.android.analytics.event.datacollection.UpsightDataCollectionEvent.Builder;
import com.upsight.android.analytics.internal.action.Action;
import com.upsight.android.analytics.internal.action.ActionContext;
import com.upsight.android.analytics.internal.action.ActionFactory;
import com.upsight.android.analytics.internal.association.Association;
import com.upsight.android.analytics.internal.session.Clock;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.marketing.R.id;
import com.upsight.android.marketing.R.layout;
import com.upsight.android.marketing.UpsightPurchase;
import com.upsight.android.marketing.UpsightReward;
import com.upsight.android.persistence.UpsightDataStore;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;

public final class MarketingContentActions
{
  private static final Map<String, InternalFactory> FACTORY_MAP = new HashMap() {};
  
  static class AssociateOnce
    extends Action<MarketingContent, MarketingContentActions.MarketingContentActionContext>
  {
    public static final String UPSIGHT_DATA = "upsight_data";
    public static final String UPSIGHT_DATA_FILTER = "upsight_data_filter";
    public static final String WITH = "with";
    
    private AssociateOnce(MarketingContentActions.MarketingContentActionContext paramMarketingContentActionContext, String paramString, JsonNode paramJsonNode)
    {
      super(paramString, paramJsonNode);
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
  
  static class Destroy
    extends Action<MarketingContent, MarketingContentActions.MarketingContentActionContext>
  {
    private Destroy(MarketingContentActions.MarketingContentActionContext paramMarketingContentActionContext, String paramString, JsonNode paramJsonNode)
    {
      super(paramString, paramJsonNode);
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
  
  public static class DestroyEvent
  {
    public final String mId;
    
    private DestroyEvent(String paramString)
    {
      mId = paramString;
    }
  }
  
  private static abstract interface InternalFactory
  {
    public abstract Action<MarketingContent, MarketingContentActions.MarketingContentActionContext> create(MarketingContentActions.MarketingContentActionContext paramMarketingContentActionContext, String paramString, JsonNode paramJsonNode);
  }
  
  public static class MarketingContentActionContext
    extends ActionContext
  {
    public final MarketingContentStore mContentStore;
    public final ContentTemplateWebViewClientFactory mContentTemplateWebViewClientFactory;
    
    public MarketingContentActionContext(UpsightContext paramUpsightContext, Bus paramBus, ObjectMapper paramObjectMapper, Clock paramClock, Scheduler.Worker paramWorker, UpsightLogger paramUpsightLogger, MarketingContentStore paramMarketingContentStore, ContentTemplateWebViewClientFactory paramContentTemplateWebViewClientFactory)
    {
      super(paramBus, paramObjectMapper, paramClock, paramWorker, paramUpsightLogger);
      mContentStore = paramMarketingContentStore;
      mContentTemplateWebViewClientFactory = paramContentTemplateWebViewClientFactory;
    }
  }
  
  public static class MarketingContentActionFactory
    implements ActionFactory<MarketingContent, MarketingContentActions.MarketingContentActionContext>
  {
    public static final String TYPE = "marketing_content_factory";
    
    public Action<MarketingContent, MarketingContentActions.MarketingContentActionContext> create(MarketingContentActions.MarketingContentActionContext paramMarketingContentActionContext, JsonNode paramJsonNode)
      throws UpsightException
    {
      if (paramJsonNode == null) {
        throw new UpsightException("Failed to create Action. JSON is null.", new Object[0]);
      }
      String str = paramJsonNode.get("action_type").asText();
      paramJsonNode = paramJsonNode.get("parameters");
      MarketingContentActions.InternalFactory localInternalFactory = (MarketingContentActions.InternalFactory)MarketingContentActions.FACTORY_MAP.get(str);
      if (localInternalFactory == null) {
        throw new UpsightException("Failed to create Action. Unknown action type.", new Object[0]);
      }
      return localInternalFactory.create(paramMarketingContentActionContext, str, paramJsonNode);
    }
  }
  
  static class NotifyPurchases
    extends Action<MarketingContent, MarketingContentActions.MarketingContentActionContext>
  {
    public static final String PURCHASES = "purchases";
    
    private NotifyPurchases(MarketingContentActions.MarketingContentActionContext paramMarketingContentActionContext, String paramString, JsonNode paramJsonNode)
    {
      super(paramString, paramJsonNode);
    }
    
    public void execute(MarketingContent paramMarketingContent)
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = optParamJsonArray("purchases");
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
            localArrayList.add(Purchase.from(localJsonNode, mMapper));
          }
          catch (IOException localIOException)
          {
            mLogger.e(getClass().getSimpleName(), localIOException, "Failed to parse Purchase purchaseJson=" + localObject, new Object[0]);
          }
        }
      }
      localObject = getActionContextmBus;
      ((Bus)localObject).post(new MarketingContentActions.PurchasesEvent(paramMarketingContent.getId(), localArrayList, null));
      paramMarketingContent.signalActionCompleted((Bus)localObject);
    }
  }
  
  static class NotifyRewards
    extends Action<MarketingContent, MarketingContentActions.MarketingContentActionContext>
  {
    public static final String REWARDS = "rewards";
    
    private NotifyRewards(MarketingContentActions.MarketingContentActionContext paramMarketingContentActionContext, String paramString, JsonNode paramJsonNode)
    {
      super(paramString, paramJsonNode);
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
  
  static class OpenUrl
    extends Action<MarketingContent, MarketingContentActions.MarketingContentActionContext>
  {
    public static final String URL = "url";
    
    private OpenUrl(MarketingContentActions.MarketingContentActionContext paramMarketingContentActionContext, String paramString, JsonNode paramJsonNode)
    {
      super(paramString, paramJsonNode);
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
  
  static class PresentCloseButton
    extends Action<MarketingContent, MarketingContentActions.MarketingContentActionContext>
  {
    public static final String DELAY_MS = "delay_ms";
    
    private PresentCloseButton(MarketingContentActions.MarketingContentActionContext paramMarketingContentActionContext, String paramString, JsonNode paramJsonNode)
    {
      super(paramString, paramJsonNode);
    }
    
    public void execute(final MarketingContent paramMarketingContent)
    {
      long l = optParamInt("delay_ms");
      getActionContextmMainWorker.schedule(new Action0()
      {
        public void call()
        {
          View localView = paramMarketingContent.getContentView();
          if ((localView != null) && (localView.getRootView() != null)) {
            ((ImageView)localView.findViewById(R.id.upsight_marketing_content_view_close_button)).setVisibility(0);
          }
        }
      }, l, TimeUnit.MILLISECONDS);
      paramMarketingContent.signalActionCompleted(getActionContextmBus);
    }
  }
  
  static class PresentScopedContent
    extends Action<MarketingContent, MarketingContentActions.MarketingContentActionContext>
  {
    public static final String ID = "id";
    public static final String SCOPE_LIST = "scope_list";
    
    private PresentScopedContent(MarketingContentActions.MarketingContentActionContext paramMarketingContentActionContext, String paramString, JsonNode paramJsonNode)
    {
      super(paramString, paramJsonNode);
    }
    
    public void execute(MarketingContent paramMarketingContent)
    {
      String str = optParamString("id");
      Object localObject = optParamJsonArray("scope_list");
      if ((!TextUtils.isEmpty(str)) && (localObject != null) && (((JsonNode)localObject).isArray()))
      {
        ArrayList localArrayList = new ArrayList();
        localObject = ((JsonNode)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          JsonNode localJsonNode = (JsonNode)((Iterator)localObject).next();
          if (localJsonNode.isTextual()) {
            localArrayList.add(localJsonNode.asText());
          }
        }
        getActionContextmContentStore.presentScopedContent(str, (String[])localArrayList.toArray(new String[localArrayList.size()]));
      }
      paramMarketingContent.signalActionCompleted(getActionContextmBus);
    }
  }
  
  static class PresentScopelessContent
    extends Action<MarketingContent, MarketingContentActions.MarketingContentActionContext>
  {
    public static final String NEXT_ID = "next_id";
    public static final String SELF_ID = "self_id";
    
    private PresentScopelessContent(MarketingContentActions.MarketingContentActionContext paramMarketingContentActionContext, String paramString, JsonNode paramJsonNode)
    {
      super(paramString, paramJsonNode);
    }
    
    public void execute(MarketingContent paramMarketingContent)
    {
      String str1 = optParamString("self_id");
      String str2 = optParamString("next_id");
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
        getActionContextmContentStore.presentScopelessContent(str2, str1);
      }
      paramMarketingContent.signalActionCompleted(getActionContextmBus);
    }
  }
  
  public static class PurchasesEvent
  {
    public final String mId;
    public final List<UpsightPurchase> mPurchases;
    
    private PurchasesEvent(String paramString, List<UpsightPurchase> paramList)
    {
      mId = paramString;
      mPurchases = paramList;
    }
  }
  
  public static class RewardsEvent
  {
    public final String mId;
    public final List<UpsightReward> mRewards;
    
    private RewardsEvent(String paramString, List<UpsightReward> paramList)
    {
      mId = paramString;
      mRewards = paramList;
    }
  }
  
  static class SendEvent
    extends Action<MarketingContent, MarketingContentActions.MarketingContentActionContext>
  {
    public static final String EVENT = "event";
    public static final String IDENTIFIERS = "identifiers";
    public static final String PUB_DATA = "pub_data";
    public static final String TYPE = "type";
    public static final String UPSIGHT_DATA = "upsight_data";
    
    private SendEvent(MarketingContentActions.MarketingContentActionContext paramMarketingContentActionContext, String paramString, JsonNode paramJsonNode)
    {
      super(paramString, paramJsonNode);
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
  
  static class SendFormData
    extends Action<MarketingContent, MarketingContentActions.MarketingContentActionContext>
  {
    public static final String DATA_KEY = "data_key";
    public static final String STREAM_ID = "stream_id";
    
    private SendFormData(MarketingContentActions.MarketingContentActionContext paramMarketingContentActionContext, String paramString, JsonNode paramJsonNode)
    {
      super(paramString, paramJsonNode);
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
  
  static class Trigger
    extends Action<MarketingContent, MarketingContentActions.MarketingContentActionContext>
  {
    public static final String TRIGGER = "trigger";
    
    private Trigger(MarketingContentActions.MarketingContentActionContext paramMarketingContentActionContext, String paramString, JsonNode paramJsonNode)
    {
      super(paramString, paramJsonNode);
    }
    
    public void execute(MarketingContent paramMarketingContent)
    {
      String str = optParamString("trigger");
      if (!TextUtils.isEmpty(str)) {
        paramMarketingContent.executeActions(str);
      }
      paramMarketingContent.signalActionCompleted(getActionContextmBus);
    }
  }
  
  static class TriggerIfContentAvailable
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
    
    private TriggerIfContentAvailable(MarketingContentActions.MarketingContentActionContext paramMarketingContentActionContext, String paramString, JsonNode paramJsonNode)
    {
      super(paramString, paramJsonNode);
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
  
  static class TriggerIfContentBuilt
    extends Action<MarketingContent, MarketingContentActions.MarketingContentActionContext>
  {
    public static final String CONDITION_PARAMETERS = "condition_parameters";
    public static final String CONTENT_MODEL = "content_model";
    public static final String ELSE_TRIGGER = "else_trigger";
    public static final String THEN_TRIGGER = "then_trigger";
    
    private TriggerIfContentBuilt(MarketingContentActions.MarketingContentActionContext paramMarketingContentActionContext, String paramString, JsonNode paramJsonNode)
    {
      super(paramString, paramJsonNode);
    }
    
    public void execute(final MarketingContent paramMarketingContent)
    {
      int i = 0;
      localMarketingContentActionContext = (MarketingContentActions.MarketingContentActionContext)getActionContext();
      localObject1 = null;
      try
      {
        localObject2 = optParamJsonObject("condition_parameters").get("content_model");
        localObject1 = localObject2;
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;)
        {
          Object localObject2;
          mLogger.e(getClass().getSimpleName(), localNullPointerException, "Action execution failed actionType=" + getType() + " invalid CONDITION_PARAMETERS", new Object[0]);
          continue;
          mLogger.e(getClass().getSimpleName(), "Action execution failed actionType=" + getType() + " model=" + localObject1, new Object[0]);
          continue;
          localObject1 = optParamString("else_trigger");
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            paramMarketingContent.executeActions((String)localObject1);
          }
        }
      }
      if ((localObject1 != null) && (((JsonNode)localObject1).isObject()))
      {
        try
        {
          mContentStore.put(paramMarketingContent.getId(), paramMarketingContent);
          Object localObject3 = MarketingContentModel.from((JsonNode)localObject1, mMapper);
          localObject2 = LayoutInflater.from(mUpsight).inflate(R.layout.upsight_marketing_content_view, null);
          paramMarketingContent.setContentModel((MarketingContentModel)localObject3);
          paramMarketingContent.setContentView((View)localObject2);
          localObject3 = (WebView)((View)localObject2).findViewById(R.id.upsight_marketing_content_view_web_view);
          ((ImageView)((View)localObject2).findViewById(R.id.upsight_marketing_content_view_close_button)).setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              paramMarketingContent.executeActions("content_dismissed");
            }
          });
          ((WebView)localObject3).getSettings().setJavaScriptEnabled(true);
          ((WebView)localObject3).setWebViewClient(mContentTemplateWebViewClientFactory.create(paramMarketingContent));
          ((WebView)localObject3).loadUrl(paramMarketingContent.getContentModel().getTemplateUrl());
          i = 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            mLogger.e(getClass().getSimpleName(), localException, "Action execution failed actionType=" + getType() + " model=" + localObject1, new Object[0]);
          }
        }
        if (i == 0) {
          break label376;
        }
        localObject1 = optParamString("then_trigger");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramMarketingContent.executeActions((String)localObject1);
        }
        paramMarketingContent.signalActionCompleted(getActionContextmBus);
        return;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.MarketingContentActions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */