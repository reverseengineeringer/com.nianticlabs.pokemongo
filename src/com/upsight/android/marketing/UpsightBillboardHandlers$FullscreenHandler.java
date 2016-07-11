package com.upsight.android.marketing;

import android.app.Activity;
import android.view.ViewGroup;
import com.upsight.android.marketing.internal.billboard.BillboardFragment;
import java.util.Set;

public class UpsightBillboardHandlers$FullscreenHandler
  extends UpsightBillboardHandlers.SimpleHandler
{
  public UpsightBillboardHandlers$FullscreenHandler(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public ViewGroup onAttach(String paramString, UpsightBillboard.PresentationStyle paramPresentationStyle, Set<UpsightBillboard.Dimensions> paramSet)
  {
    if ((mActivity == null) || (mActivity.isFinishing())) {
      return null;
    }
    mFragment = BillboardFragment.newInstance(mActivity, null);
    mFragment.setStyle(1, 16974122);
    mFragment.setCancelable(false);
    mFragment.show(mActivity.getFragmentManager(), null);
    return mFragment.getContentViewContainer();
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.UpsightBillboardHandlers.FullscreenHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */