package com.upsight.android.marketing.internal.content;

import android.view.View;
import android.widget.ImageView;
import com.fasterxml.jackson.databind.JsonNode;
import com.upsight.android.analytics.internal.action.Action;
import com.upsight.android.marketing.R.id;
import java.util.concurrent.TimeUnit;
import rx.Scheduler.Worker;
import rx.functions.Action0;

class MarketingContentActions$PresentCloseButton
  extends Action<MarketingContent, MarketingContentActions.MarketingContentActionContext>
{
  public static final String DELAY_MS = "delay_ms";
  
  private MarketingContentActions$PresentCloseButton(MarketingContentActions.MarketingContentActionContext paramMarketingContentActionContext, String paramString, JsonNode paramJsonNode)
  {
    super(paramMarketingContentActionContext, paramString, paramJsonNode);
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

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.MarketingContentActions.PresentCloseButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */