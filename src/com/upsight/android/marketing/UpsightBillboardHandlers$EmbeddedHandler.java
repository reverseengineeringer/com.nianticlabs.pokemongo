package com.upsight.android.marketing;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.ViewGroup;
import com.upsight.android.marketing.internal.billboard.BillboardFragment;
import java.util.Set;

class UpsightBillboardHandlers$EmbeddedHandler
  extends UpsightBillboardHandlers.SimpleHandler
{
  protected int mContainerViewId;
  
  public UpsightBillboardHandlers$EmbeddedHandler(Activity paramActivity, int paramInt)
  {
    super(paramActivity);
    mContainerViewId = paramInt;
  }
  
  public ViewGroup onAttach(String paramString, UpsightBillboard.PresentationStyle paramPresentationStyle, Set<UpsightBillboard.Dimensions> paramSet)
  {
    if ((mActivity == null) || (mActivity.isFinishing())) {
      return null;
    }
    mFragment = BillboardFragment.newInstance(mActivity, paramSet);
    mActivity.getFragmentManager().beginTransaction().add(mContainerViewId, mFragment).commit();
    return mFragment.getContentViewContainer();
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.UpsightBillboardHandlers.EmbeddedHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */