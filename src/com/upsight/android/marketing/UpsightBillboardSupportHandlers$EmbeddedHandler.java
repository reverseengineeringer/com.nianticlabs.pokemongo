package com.upsight.android.marketing;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;
import com.upsight.android.marketing.internal.billboard.BillboardSupportFragment;
import java.util.Set;

class UpsightBillboardSupportHandlers$EmbeddedHandler
  extends UpsightBillboardSupportHandlers.SimpleHandler
{
  protected int mContainerViewId;
  
  public UpsightBillboardSupportHandlers$EmbeddedHandler(FragmentActivity paramFragmentActivity, int paramInt)
  {
    super(paramFragmentActivity);
    mContainerViewId = paramInt;
  }
  
  public ViewGroup onAttach(String paramString, UpsightBillboard.PresentationStyle paramPresentationStyle, Set<UpsightBillboard.Dimensions> paramSet)
  {
    if ((mActivity == null) || (mActivity.isFinishing())) {
      return null;
    }
    mFragment = BillboardSupportFragment.newInstance(mActivity, paramSet);
    mActivity.getSupportFragmentManager().beginTransaction().add(mContainerViewId, mFragment).commit();
    return mFragment.getContentViewContainer();
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.UpsightBillboardSupportHandlers.EmbeddedHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */