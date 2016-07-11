package com.upsight.android.marketing;

import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import com.upsight.android.marketing.internal.billboard.BillboardSupportFragment;
import java.util.Set;

public class UpsightBillboardSupportHandlers$DialogHandler
  extends UpsightBillboardSupportHandlers.SimpleHandler
{
  public UpsightBillboardSupportHandlers$DialogHandler(FragmentActivity paramFragmentActivity)
  {
    super(paramFragmentActivity);
  }
  
  public ViewGroup onAttach(String paramString, UpsightBillboard.PresentationStyle paramPresentationStyle, Set<UpsightBillboard.Dimensions> paramSet)
  {
    if ((mActivity == null) || (mActivity.isFinishing())) {
      return null;
    }
    mFragment = BillboardSupportFragment.newInstance(mActivity, paramSet);
    mFragment.setStyle(1, UpsightBillboardSupportHandlers.access$000());
    mFragment.setCancelable(false);
    mFragment.show(mActivity.getSupportFragmentManager(), null);
    return mFragment.getContentViewContainer();
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.UpsightBillboardSupportHandlers.DialogHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */