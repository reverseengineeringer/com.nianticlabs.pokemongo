package com.upsight.android.marketing;

import android.app.Activity;
import android.app.DialogFragment;
import com.upsight.android.marketing.internal.billboard.BillboardFragment;
import java.util.List;

abstract class UpsightBillboardHandlers$SimpleHandler
  implements UpsightBillboard.Handler
{
  protected Activity mActivity;
  protected BillboardFragment mFragment = null;
  
  protected UpsightBillboardHandlers$SimpleHandler(Activity paramActivity)
  {
    mActivity = paramActivity;
  }
  
  public void onDetach()
  {
    BillboardFragment localBillboardFragment = mFragment;
    if (localBillboardFragment != null)
    {
      localBillboardFragment.dismissAllowingStateLoss();
      mFragment = null;
    }
  }
  
  public void onNextView() {}
  
  public void onPurchases(List<UpsightPurchase> paramList) {}
  
  public void onRewards(List<UpsightReward> paramList) {}
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.UpsightBillboardHandlers.SimpleHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */