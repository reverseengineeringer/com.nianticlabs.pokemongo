package com.upsight.android.marketing.internal.content;

import com.upsight.android.marketing.UpsightPurchase;
import java.util.List;

public class MarketingContentActions$PurchasesEvent
{
  public final String mId;
  public final List<UpsightPurchase> mPurchases;
  
  private MarketingContentActions$PurchasesEvent(String paramString, List<UpsightPurchase> paramList)
  {
    mId = paramString;
    mPurchases = paramList;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.internal.content.MarketingContentActions.PurchasesEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */