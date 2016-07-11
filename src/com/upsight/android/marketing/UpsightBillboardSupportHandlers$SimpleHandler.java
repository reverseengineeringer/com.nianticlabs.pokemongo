package com.upsight.android.marketing;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import com.upsight.android.marketing.internal.billboard.BillboardSupportFragment;
import java.util.List;

abstract class UpsightBillboardSupportHandlers$SimpleHandler
  implements UpsightBillboard.Handler
{
  protected FragmentActivity mActivity;
  protected BillboardSupportFragment mFragment = null;
  
  protected UpsightBillboardSupportHandlers$SimpleHandler(FragmentActivity paramFragmentActivity)
  {
    mActivity = paramFragmentActivity;
  }
  
  public void onDetach()
  {
    BillboardSupportFragment localBillboardSupportFragment = mFragment;
    if (localBillboardSupportFragment != null)
    {
      localBillboardSupportFragment.dismissAllowingStateLoss();
      mFragment = null;
    }
  }
  
  public void onNextView() {}
  
  public void onPurchases(List<UpsightPurchase> paramList) {}
  
  public void onRewards(List<UpsightReward> paramList) {}
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.UpsightBillboardSupportHandlers.SimpleHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */