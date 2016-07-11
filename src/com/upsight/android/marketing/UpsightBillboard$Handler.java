package com.upsight.android.marketing;

import android.view.ViewGroup;
import java.util.List;
import java.util.Set;

public abstract interface UpsightBillboard$Handler
{
  public abstract ViewGroup onAttach(String paramString, UpsightBillboard.PresentationStyle paramPresentationStyle, Set<UpsightBillboard.Dimensions> paramSet);
  
  public abstract void onDetach();
  
  public abstract void onNextView();
  
  public abstract void onPurchases(List<UpsightPurchase> paramList);
  
  public abstract void onRewards(List<UpsightReward> paramList);
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.UpsightBillboard.Handler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */