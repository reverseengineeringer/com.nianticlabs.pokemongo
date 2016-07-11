package com.upsight.android.marketing.internal.content;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.upsight.android.analytics.internal.action.Action;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.marketing.R.id;
import com.upsight.android.marketing.R.layout;

class MarketingContentActions$TriggerIfContentBuilt
  extends Action<MarketingContent, MarketingContentActions.MarketingContentActionContext>
{
  public static final String CONDITION_PARAMETERS = "condition_parameters";
  public static final String CONTENT_MODEL = "content_model";
  public static final String ELSE_TRIGGER = "else_trigger";
  public static final String THEN_TRIGGER = "then_trigger";
  
  private MarketingContentActions$TriggerIfContentBuilt(MarketingContentActions.MarketingContentActionContext paramMarketingContentActionContext, String paramString, JsonNode paramJsonNode)
  {
    super(paramMarketingContentActionContext, paramString, paramJsonNode);
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

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.MarketingContentActions.TriggerIfContentBuilt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */