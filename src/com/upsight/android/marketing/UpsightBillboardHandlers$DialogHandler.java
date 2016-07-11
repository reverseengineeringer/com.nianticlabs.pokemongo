package com.upsight.android.marketing;

import android.app.Activity;
import android.view.ViewGroup;
import com.upsight.android.marketing.internal.billboard.BillboardFragment;
import java.util.Set;

public class UpsightBillboardHandlers$DialogHandler
  extends UpsightBillboardHandlers.SimpleHandler
{
  public UpsightBillboardHandlers$DialogHandler(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public ViewGroup onAttach(String paramString, UpsightBillboard.PresentationStyle paramPresentationStyle, Set<UpsightBillboard.Dimensions> paramSet)
  {
    if ((mActivity == null) || (mActivity.isFinishing())) {
      return null;
    }
    mFragment = BillboardFragment.newInstance(mActivity, paramSet);
    mFragment.setStyle(1, UpsightBillboardHandlers.access$000());
    mFragment.setCancelable(false);
    mFragment.show(mActivity.getFragmentManager(), null);
    return mFragment.getContentViewContainer();
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.marketing.UpsightBillboardHandlers.DialogHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */