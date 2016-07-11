package com.upsight.android.marketing.internal.content;

import android.view.View;
import android.widget.ImageView;
import com.upsight.android.marketing.R.id;
import rx.functions.Action0;

class MarketingContentActions$PresentCloseButton$1
  implements Action0
{
  MarketingContentActions$PresentCloseButton$1(MarketingContentActions.PresentCloseButton paramPresentCloseButton, MarketingContent paramMarketingContent) {}
  
  public void call()
  {
    View localView = val$content.getContentView();
    if ((localView != null) && (localView.getRootView() != null)) {
      ((ImageView)localView.findViewById(R.id.upsight_marketing_content_view_close_button)).setVisibility(0);
    }
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.MarketingContentActions.PresentCloseButton.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */